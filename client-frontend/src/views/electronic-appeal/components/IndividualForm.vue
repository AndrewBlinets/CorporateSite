<template>
  <div class="v-list">
    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="v-list-item__subtitle">
          {{ $t('views.e-appeal.form.individual.name') }}
          <span class="red--text">*</span>
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
          {{ $t('views.e-appeal.form.individual.address') }}
          <span class="red--text">*</span>
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
          {{ $t('views.e-appeal.form.individual.email') }}
          <span class="red--text">*</span>
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
          {{ $t('views.e-appeal.form.individual.textAppeal') }}
          <span class="red--text">*</span>
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
          {{ $t('views.e-appeal.form.individual.file') }}
        </div>
        <v-file-input v-model="form.file" hide-details="auto"></v-file-input>
      </div>
    </div>

    <div class="v-list-item">
      <div class="v-list-item__content">
        <div class="button-container">
          <div class="button-item">
            <button class="btn btn-main" @click="send">
              {{ $t('views.e-appeal.form.individual.button') }}
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
  name: 'IndividualForm',
  mixins: [formMixin],
  data: () => ({
    form: {
      type: 1,
    },
  }),
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
