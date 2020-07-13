<template>
  <div class="login-container">
    <div class="shadow-container">
      <div class="title">
        <h1>Вход</h1>
      </div>
      <el-form ref="form" :model="form" :rules="rules" label-position="top">
        <el-form-item label="Логин" prop="username">
          <el-input
            ref="username"
            v-model="form.username"
            name="username"
            tabindex="1"
            type="text"
          />
        </el-form-item>

        <el-tooltip v-model="capsTooltip" content="Caps Lock включён" manual>
          <el-form-item label="Пароль" prop="password">
            <el-input
              ref="password"
              v-model="form.password"
              name="password"
              type="password"
              tabindex="2"
              show-password
              @keyup.native="checkCapslock"
              @blur="capsTooltip = false"
              @keyup.enter.native="handleLogin"
            >
            </el-input>
          </el-form-item>
        </el-tooltip>

        <el-form-item>
          <el-button
            class="full-width margin-top"
            type="primary"
            @click="handleLogin"
          >
            Войти
          </el-button>
        </el-form-item>

        <el-form-item>
          <router-link :to="{ name: 'reminder' }" tag="el-link">
            Забыли пароль?
          </router-link>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  name: 'Login',

  data: () => {
    const validateUsername = (rule, value, callback) => {
      if (!value.length) {
        callback(new Error('Введите логин.'));
      } else {
        callback();
      }
    };

    const validatePassword = (rule, value, callback) => {
      if (!value.length) {
        callback(new Error('Введите пароль.'));
      } else {
        callback();
      }
    };

    return {
      form: {
        username: 'javainuse',
        password: 'password',
      },
      rules: {
        username: [{ validator: validateUsername, trigger: 'blur' }],
        password: [{ validator: validatePassword, trigger: 'blur' }],
      },
      capsTooltip: false,
      redirect: undefined,
    };
  },

  watch: {
    $route: {
      handler: function (route) {
        const query = route.query;
        if (query) {
          this.redirect = query.redirect;
          this.otherQuery = this.getOtherQuery(query);
        }
      },
      immediate: true,
    },
  },

  mounted() {
    if (this.form.username === '') {
      this.$refs.username.focus();
    } else if (this.form.password === '') {
      this.$refs.password.focus();
    }
  },

  methods: {
    ...mapActions({
      login: 'user/login',
    }),
    checkCapslock(event) {
      this.capsTooltip = event.getModifierState('CapsLock');
    },
    handleLogin() {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.login(this.form).then(() => {
            this.$router.push({
              path: this.redirect || '/',
              query: this.otherQuery,
            });
          });
        } else {
          return false;
        }
      });
    },
    getOtherQuery(query) {
      return Object.keys(query).reduce((acc, cur) => {
        if (cur !== 'redirect') {
          acc[cur] = query[cur];
        }
        return acc;
      }, {});
    },
  },
};
</script>

<style lang="stylus" scoped>
.login-container {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  min-height: 100%;
  background-color: #ebeef5;

  .shadow-container {
    width: 500px;
    padding: 40px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    background-color: #fff;

    .title {
      margin-bottom: 40px;

      h1 {
        font-size: 22px;
      }
    }
  }
}
</style>
