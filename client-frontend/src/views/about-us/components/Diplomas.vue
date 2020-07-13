<template>
  <section-component v-bind="section" />
</template>

<script>
import SectionComponent from '@/components/Section';

export default {
  name: 'Diplomas',
  components: {
    SectionComponent
  },
  data: () => ({
    section: {
      name: 'Дипломы',
      type: 3
    }
  })
};
</script>

<style lang="stylus" scoped>

</style>