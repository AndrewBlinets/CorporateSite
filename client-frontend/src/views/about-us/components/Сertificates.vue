<template>
  <section-component v-bind="section" />
</template>

<script>
import SectionComponent from '@/components/Section';

export default {
  name: 'Certificates',
  components: {
    SectionComponent
  },
  data: () => ({
    section: {
      name: 'Сертификаты',
      type: 3
    }
  })
};
</script>

<style lang="stylus" scoped>

</style>