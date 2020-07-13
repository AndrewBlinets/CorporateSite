<template>
  <div class="row">
    <div
      v-for="block in blocks"
      :key="block.id"
      :class="`resize col-lg-${colNumber} col-md-6 col-12 mb-lg-0 mb-3`"
    >
      <content-page
        v-if="contentWidth"
        v-resize="handleContent"
        :html="block.content"
        :width="contentWidth"
      />
    </div>
  </div>
</template>

<script>
import { Resize } from '@/directive/resize';
import ContentPage from '@/components/ContentPage';

export default {
  name: 'ContentBlock',
  components: {
    ContentPage,
  },
  directives: {
    Resize,
  },
  props: {
    blocks: {
      type: Array,
      default: () => [],
    },
  },
  data: () => ({
    contentWidth: null,
  }),
  computed: {
    colNumber() {
      return 12 / this.blocks.length;
    },
  },
  mounted() {
    this.handleContent();
  },
  methods: {
    handleContent() {
      this.contentWidth = this.$el.querySelector('.resize').clientWidth - 30;
    },
  },
};
</script>
