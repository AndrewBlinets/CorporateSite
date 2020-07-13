<template>
  <div>
    <v-radio-group v-model.number="typePerson" class="type-person__group">
      <v-radio label="Юридическое лицо" :value="1"></v-radio>
      <v-radio label="Физическое лицо" :value="0"></v-radio>
    </v-radio-group>

    <transition name="fade">
      <entity-form v-if="typePerson"></entity-form>
      <individual-form v-else></individual-form>
    </transition>
  </div>
</template>

<script>
import VRadioGroup from '@/components/UI/VRadioGroup';
import VRadio from '@/components/UI/VRadioGroup/VRadio';
import EntityForm from './EntityForm';
import IndividualForm from './IndividualForm';

export default {
  name: 'FormAppeal',
  components: {
    VRadioGroup,
    VRadio,
    EntityForm,
    IndividualForm,
  },
  data: () => ({
    typePerson: 1,
  }),
};
</script>

<style lang="stylus" scoped>
.type-person__group {
  padding-left: 16px;
}

.fade-enter-active, .fade-leave-active {
  transition: all 0.2s cubic-bezier(0.694, 0, 0.335, 1);
}

.fade-enter, .fade-leave-to {
  opacity: 0;
}
</style>
