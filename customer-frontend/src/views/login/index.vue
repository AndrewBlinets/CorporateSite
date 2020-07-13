<template>
  <v-row justify="center">
    <v-col cols="4" align-self="center" class="img">
      <v-img src="@/assets/trends_b0wg.svg" />
    </v-col>
    <v-col cols="3" align-self="center" class="form-col">
      <v-img
        src="@/assets/avatar.svg"
        width="150"
        height="150"
        class="avatar"
      />

      <v-form>
        <v-text-field
          ref="username"
          v-model="loginForm.username"
          label="Лоигин"
          outlined
          :error-messages="usernameErrors"
          @change="$v.loginForm.username.$touch()"
          @blur="$v.loginForm.username.$touch()"
        ></v-text-field>

        <v-text-field
          ref="password"
          v-model="loginForm.password"
          label="Пароль"
          outlined
          :append-icon="showPassword ? 'mdi-eye-off' : 'mdi-eye'"
          :type="showPassword ? 'text' : 'password'"
          :error-messages="passwordErrors"
          @keyup.enter.native="handleLogin"
          @keyup.native="checkCapsLock"
          @change="$v.loginForm.password.$touch()"
          @blur="handleBlurPassword"
          @click:append="showPassword = !showPassword"
        ></v-text-field>

        <v-tooltip v-model="onCapsLoock" top>
          <template v-slot:activator="{ on }">
            <div v-on="on"></div>
          </template>
          <span>Caps Lock включён</span>
        </v-tooltip>

        <v-btn
          color="primary"
          class="mt-5"
          x-large
          rounded
          block
          :loading="submitStatus === 'PENDING'"
          :disabled="submitStatus === 'PENDING'"
          @click="handleLogin"
        >
          Войти
        </v-btn>
      </v-form>
    </v-col>
  </v-row>
</template>

<script>
import { validationMixin } from 'vuelidate';
import { required, minLength } from 'vuelidate/lib/validators';

export default {
  name: 'Login',
  mixins: [validationMixin],

  computed: {
    usernameErrors() {
      const errors = [];
      const { username, password } = this.$v.loginForm;

      if (!username.$dirty) return errors;
      !username.minLength &&
        errors.push(
          `Логин должен быть больше ${username.$params.minLength.min} символов`,
        );
      !username.required && errors.push('Логин обязательно');
      this.submitStatus === 'ERROR' && password.$error && errors.push('');

      return errors;
    },

    passwordErrors() {
      const errors = [];
      const { password } = this.$v.loginForm;

      if (!password.$dirty) return errors;
      !password.minLength &&
        errors.push(
          `Пароль должен быть больше ${password.$params.minLength.min} символов`,
        );
      !password.required &&
        this.submitStatus === 'ERROR' &&
        errors.push('Неверный логин или пароль');
      !password.required && errors.push('Пароль обязательно');

      return errors;
    },
  },

  watch: {
    $route: {
      handler: function(route) {
        const { query } = route;

        if (query) {
          this.redirect = query.redirect;
          this.otherQuery = this.getOtherQuery(query);
        }
      },
      immediate: true,
    },
  },

  data: () => ({
    loginForm: {
      username: 'javainuse',
      password: 'password',
    },
    onCapsLoock: false,
    showPassword: false,
    submitStatus: false,
    redirect: '',
    otherQuery: {},
  }),

  validations: {
    loginForm: {
      username: {
        required,
        minLength: minLength(4),
      },
      password: {
        required,
        minLength: minLength(8),
      },
    },
  },

  mounted() {
    if (!this.loginForm.username) {
      this.$refs.username.focus();
    } else if (!this.loginForm.password) {
      this.$refs.password.focus();
    }
  },

  methods: {
    handleLogin() {
      this.$v.loginForm.$touch();
      if (!this.$v.loginForm.$error && !this.loading) {
        this.submitStatus = 'PENDING';
        this.$store
          .dispatch('user/login', this.loginForm)
          .then(() => {
            this.submitStatus = 'OK';
            this.$router.push({
              path: this.redirect || '/',
              query: this.otherQuery,
            });
          })
          .catch(error => {
            this.submitStatus = 'ERROR';
            if (error.response.status === 401) {
              this.loginForm.password = '';
              this.$refs.password.focus();
              this.$v.loginForm.$touch();
            }
          });
      } else {
        return false;
      }
    },

    handleBlurPassword() {
      this.$v.loginForm.password.$touch();
      this.onCapsLoock = false;
    },

    getOtherQuery(query) {
      return Object.keys(query).reduce((acc, cur) => {
        if (cur !== 'redirect') {
          acc[cur] = query[cur];
        }
        return acc;
      }, {});
    },

    checkCapsLock(event) {
      this.onCapsLoock = event.getModifierState('CapsLock');
    },
  },
};
</script>

<style lang="scss" scoped>
.img {
  margin-bottom: 200px;
  margin-right: -70px;
}
.form-col {
  display: flex;
  flex-direction: column;
  align-items: center;

  .avatar {
    margin-bottom: 50px;
  }

  form {
    width: 100%;
  }
}
</style>
