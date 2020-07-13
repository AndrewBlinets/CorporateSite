<template>
  <div>
    <v-list>
      <v-list-item two-line>
        <v-list-item-content>
          <v-list-item-subtitle class="caption">
            ИМЯ ПОЛЬЗОВАТЕЛЯ<span v-if="edit" class="red--text">*</span>
          </v-list-item-subtitle>

          <v-row v-if="edit">
            <v-col :cols="12">
              <v-text-field
                ref="surName"
                v-model.trim="userProfile.surName"
                label="Фамилия"
                outlined
                dense
                hide-details="auto"
                :error-messages="surNameErrors"
              />
            </v-col>

            <v-col :cols="12">
              <v-text-field
                v-if="edit"
                ref="name"
                v-model.trim="userProfile.name"
                label="Имя"
                outlined
                dense
                hide-details="auto"
                :error-messages="nameErrors"
              />
            </v-col>

            <v-col :cols="12">
              <v-text-field
                v-if="edit"
                ref="patronicName"
                v-model.trim="userProfile.patronicName"
                label="Отчество"
                outlined
                dense
                hide-details="auto"
              />
            </v-col>
          </v-row>

          <v-list-item-title v-else>{{ shortName }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item two-line>
        <v-list-item-content>
          <v-list-item-subtitle class="caption">
            EMAIL<span v-if="edit" class="red--text">*</span>
          </v-list-item-subtitle>
          <v-text-field
            v-if="edit"
            v-model.trim="userProfile.email"
            outlined
            single-line
            dense
            hide-details="auto"
            :error-messages="emailErrors"
          />
          <v-list-item-title v-else>{{ email }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item v-if="edit" two-line>
        <v-list-item-content>
          <v-list-item-subtitle class="caption">
            ТЕКУЩИЙ ПАРОЛЬ<span v-if="edit" class="red--text">*</span>
          </v-list-item-subtitle>
          <v-text-field
            v-model.trim="userProfile.password"
            outlined
            single-line
            dense
            type="password"
            hide-details="auto"
            :error-messages="passwordErrors"
          />
          <v-list-item-title></v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item v-if="edit && !changePassword">
        <v-btn text small color="primary" @click="changePassword = true">
          Изменить пароль?
        </v-btn>
      </v-list-item>

      <v-list-item v-if="edit && changePassword" two-line>
        <v-list-item-content>
          <v-list-item-subtitle class="caption">
            НОВЫЙ ПАРОЛЬ<span v-if="edit" class="red--text">*</span>
          </v-list-item-subtitle>
          <v-text-field
            v-model.trim="userProfile.newPassword"
            outlined
            single-line
            dense
            type="password"
            hide-details="auto"
            :error-messages="newPasswordErrors"
          />
          <v-list-item-title></v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </div>
</template>

<script>
import { validationMixin } from 'vuelidate';
import {
  required,
  requiredIf,
  email,
  sameAs,
  not,
  minLength,
} from 'vuelidate/lib/validators';
import { mapState, mapGetters } from 'vuex';

export default {
  name: 'AccountInfoList',
  mixins: [validationMixin],
  props: {
    edit: Boolean,
  },

  data: () => ({
    changePassword: false,
    userProfile: {
      id: null,
      surName: '',
      name: '',
      patronicName: '',
      email: '',
      password: '',
      newPassword: '',
    },
    saveStatus: false,
  }),

  computed: {
    ...mapState('user', ['id', 'surName', 'name', 'patronicName', 'email']),
    ...mapGetters('user', ['shortName']),

    surNameErrors() {
      const errors = [];
      const { surName } = this.$v.userProfile;

      if (!surName.$dirty) return errors;
      !surName.required && errors.push('Обязательное поле');

      return errors;
    },

    nameErrors() {
      const errors = [];
      const { name } = this.$v.userProfile;

      if (!name.$dirty) return errors;
      !name.required && errors.push('Обязательное поле');

      return errors;
    },

    emailErrors() {
      const errors = [];
      const { email } = this.$v.userProfile;

      if (!email.$dirty) return errors;
      !email.email && errors.push('Некоректный email');
      !email.required && errors.push('Обязательное поле');

      return errors;
    },

    passwordErrors() {
      const errors = [];
      const { password } = this.$v.userProfile;

      if (!password.$dirty) return errors;
      this.saveStatus === 'ERROR' && errors.push('Пароль не совпадает');
      !password.minLength &&
        errors.push(
          `Поле должно быть больше ${password.$params.minLength.min} символов`,
        );
      !password.required && errors.push('Обязательное поле');

      return errors;
    },

    newPasswordErrors() {
      const errors = [];
      const { newPassword } = this.$v.userProfile;

      if (!newPassword.$dirty) return errors;
      !newPassword.minLength &&
        errors.push(
          `Поле должно быть больше ${newPassword.$params.minLength.min} символов`,
        );
      !newPassword.notSameAsPassword &&
        errors.push('Пароли не должны совпадать.');
      !newPassword.required && errors.push('Обязательное поле');

      return errors;
    },
  },

  watch: {
    edit(value) {
      if (value) {
        this.$nextTick(() => {
          if (!this.userProfile.surName) {
            this.$refs.surName.focus();
          } else if (!this.userProfile.name) {
            this.$refs.name.focus();
          } else if (!this.userProfile.patronicName) {
            this.$refs.patronicName.focus();
          }
        });
      } else {
        this.changePassword = false;
        this.userProfile.password = '';
        this.userProfile.newPassword = '';
        this.$v.userProfile.$reset();
      }
    },

    id: {
      handler: function(value) {
        this.userProfile.id = value;
      },
      immediate: true,
    },

    surName: {
      handler: function(value) {
        this.userProfile.surName = value;
      },
      immediate: true,
    },

    name: {
      handler: function(value) {
        this.userProfile.name = value;
      },
      immediate: true,
    },

    patronicName: {
      handler: function(value) {
        this.userProfile.patronicName = value;
      },
      immediate: true,
    },

    email: {
      handler: function(value) {
        this.userProfile.email = value;
      },
      immediate: true,
    },
  },

  validations: {
    userProfile: {
      surName: {
        required,
      },
      name: {
        required,
      },
      email: {
        required,
        email,
      },
      password: {
        required,
        minLength: minLength(8),
      },
      newPassword: {
        required: requiredIf(function() {
          return this.changePassword;
        }),
        notSameAsPassword: not(sameAs('password')),
        minLength: minLength(8),
      },
    },
  },

  methods: {
    handleSave() {
      if (!this.userProfile.password && !this.userProfile.newPassword) {
        this.$emit('cancel');
      } else {
        this.$v.userProfile.$touch();

        if (!this.$v.userProfile.$error && !this.loading) {
          this.saveStatus = 'PENDING';
          this.$store
            .dispatch('user/saveProfile', this.userProfile)
            .then(() => {
              this.saveStatus = 'OK';
              this.$emit('cancel');
            })
            .catch(error => {
              this.saveStatus = 'ERROR';
              if (error.response.status === 401) {
                this.$refs.password.focus();
                this.$v.userProfile.$touch();
              }
            });
        }
      }
    },
  },
};
</script>
