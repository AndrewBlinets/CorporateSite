<template>
  <div class="v-list">
    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="v-list-item__subtitle">
          ПОЛНОЕ НАИМЕНОВАНИЕ ЮРИДИЧЕСКОГО ЛИЦА <span class="red--text">*</span>
        </div>
        <v-text-field
          v-model.trim="form.jurName"
          hide-details="auto"
          :error-messages="jurNameErrors"
          @input="$v.form.jurName.$touch()"
          @blur="$v.form.jurName.$touch()"
        ></v-text-field>
      </div>
    </div>

    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="v-list-item__subtitle">
          ПОЧТОВЫЙ ИНДЕКС ЮРИДИЧЕСКОГО ЛИЦА <span class="red--text">*</span>
        </div>
        <v-text-field
          v-model.number.trim="form.postcode"
          hide-details="auto"
          :error-messages="postcodeErrors"
          @input="$v.form.postcode.$touch()"
          @blur="$v.form.postcode.$touch()"
        ></v-text-field>
      </div>
    </div>

    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="v-list-item__subtitle">
          ПОЧТОВЫЙ АДРЕС ЮРИДИЧЕСКОГО ЛИЦА <span class="red--text">*</span>
        </div>
        <v-text-field
          v-model.trim="form.address"
          hide-details="auto"
          :error-messages="addressErrors"
          @input="$v.form.address.$touch()"
          @blur="$v.form.address.$touch()"
        ></v-text-field>
      </div>
    </div>

    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="v-list-item__subtitle">
          АДРЕС ЭЛЕКТРОННОЙ ПОЧТЫ <span class="red--text">*</span>
        </div>
        <v-text-field
          ref="email"
          v-model.trim="form.email"
          hide-details="auto"
          :error-messages="emailErrors"
          @input="$v.form.email.$touch()"
          @blur="$v.form.email.$touch()"
        ></v-text-field>
      </div>
    </div>

    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="v-list-item__subtitle">
          ФАМИЛИЯ, СОБСТВЕННОЕ ИМЯ, ОТЧЕСТВО <span class="red--text">*</span>
        </div>
        <v-text-field
          v-model.trim="form.name"
          hide-details="auto"
          :error-messages="nameErrors"
          @input="$v.form.name.$touch()"
          @blur="$v.form.name.$touch()"
        ></v-text-field>
      </div>
    </div>

    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="v-list-item__subtitle">
          ТЕКСТ ОБРАЩЕНИЯ <span class="red--text">*</span>
        </div>
        <v-textareas
          v-model.trim="form.textAppeal"
          hide-details="auto"
          counter
          :error-messages="textAppealErrors"
          @input="$v.form.textAppeal.$touch()"
          @blur="$v.form.textAppeal.$touch()"
        ></v-textareas>
      </div>
    </div>

    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="v-list-item__subtitle">
          ПРИКРЕПИТЬ ФАЙЛ
        </div>
        <v-file-input v-model="form.file" hide-details="auto"></v-file-input>
      </div>
    </div>

    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="button-container">
          <div class="button-item">
            <button class="btn btn-main" @click="send">
              Отправить
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { formMixin } from '../form.mixin';

export default {
  name: 'EntityForm',
  mixins: [formMixin],
  data: () => ({
    form: {
      type: 2,
      jurName: '',
      postcode: null,
    },
  }),
  computed: {
    jurNameErrors() {
      const errors = [];

      if (!this.$v.form.jurName.$dirty) return errors;
      !this.$v.form.jurName.required && errors.push('Поле обязательно');

      return errors;
    },
    postcodeErrors() {
      const errors = [];

      if (!this.$v.form.postcode.$dirty) return errors;
      !this.$v.form.postcode.required && errors.push('Поле обязательно');

      return errors;
    },
  },
};
</script>

<style lang="stylus" scoped>
.button-item {
  width: 100%;

  .btn {
    width: 100%;
  }
}
</style>
