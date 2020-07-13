import { sendAppeal } from '@/api/appeal';

import VTextField from '@/components/UI/VTextField';
import VTextareas from '@/components/UI/VTextareas';
import VFileInput from '@/components/UI/VFileInput';

import { validationMixin } from 'vuelidate';
import {
  required,
  requiredIf,
  maxLength,
  email,
} from 'vuelidate/lib/validators';
import { Object } from 'core-js';

export const formMixin = {
  components: {
    VTextField,
    VTextareas,
    VFileInput,
  },

  mixins: [validationMixin],
  validations: {
    form: {
      jurName: {
        required: requiredIf(function() {
          return this.form.type === 2;
        }),
      },
      postcode: {
        required: requiredIf(function() {
          return this.form.type === 2;
        }),
      },
      name: { required },
      address: { required },
      email: { required, email },
      textAppeal: { required, maxLength: maxLength(2000) },
    },
  },

  data: () => ({
    form: {
      name: '',
      address: '',
      email: '',
      textAppeal: '',
      file: null,
    },
    sendStatus: null,
  }),

  computed: {
    nameErrors() {
      const errors = [];

      if (!this.$v.form.name.$dirty) return errors;
      !this.$v.form.name.required && errors.push('Поле обязательно');

      return errors;
    },
    addressErrors() {
      const errors = [];

      if (!this.$v.form.address.$dirty) return errors;
      !this.$v.form.address.required && errors.push('Поле обязательно');

      return errors;
    },
    emailErrors() {
      const errors = [];

      if (!this.$v.form.email.$dirty) return errors;
      !this.$v.form.email.required && errors.push('Поле обязательно');
      !this.$v.form.email.email &&
        !this.$refs.email.hasFocus &&
        errors.push('Некорректный электронный адрес');

      return errors;
    },
    textAppealErrors() {
      const errors = [];

      if (!this.$v.form.textAppeal.$dirty) return errors;
      !this.$v.form.textAppeal.required && errors.push('Поле обязательно');
      !this.$v.form.textAppeal.maxLength &&
        errors.push(
          `Максимум ${this.$v.form.textAppeal.$params.maxLength.max} символов`,
        );

      return errors;
    },
  },

  methods: {
    send() {
      this.$v.form.$touch();

      if (!this.$v.form.$error && this.sendStatus !== 'PENDING') {
        this.sendStatus = 'PENDING';
        let formData = new FormData();

        for (const [key, value] of Object.entries(this.form)) {
          value && formData.append(key, value);
        }

        sendAppeal(formData)
          .then(() => {
            this.sendStatus = 'OK';

            Object.keys(this.form).forEach(key => {
              if (!['file', 'type'].includes(key)) this.form[key] = '';
            });
            this.$v.form.$reset();
          })
          .catch(() => {
            this.sendStatus = 'ERROR';
          });
      }
    },
  },
};
