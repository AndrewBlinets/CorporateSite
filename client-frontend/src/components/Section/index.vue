<template>
  <section>
    <div class="app-container grid-area">
      <div class="section-header">
        <h2>{{ section.name }}</h2>
      </div>
      <div class="section-body">
        <component :is="componentToShow" v-bind="componentProps" />
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'Section',
  props: {
    section: {
      type: Object,
      default: () => ({}),
    },
    page: {
      type: Number,
      default: null,
    },
  },
  computed: {
    componentToShow() {
      const { type } = this.section;
      if (type === 2) {
        return () => import('./components/News');
      } else if (type === 3) {
        return () => import('./components/Images');
      }

      return () => import('./components/ContentBlock');
    },
    componentProps() {
      const { type, blocks, files } = this.section;
      if (type === 2) {
        return { pageId: this.page };
      } else if (type === 3) {
        return { files };
      }

      return { blocks };
    },
  },
};
</script>
