<template>
  <img
    :src="urlLowQuality"
    :data-src="url"
    :data-srcset="`${url} 2x`"
    :alt="name"
    :style="style"
    :class="{ 'blur-image': loading }"
    class="app-image"
  />
</template>

<script>
import { getImage, getImageSmall } from '@/api/index';
import lozad from 'lozad';

export default {
  name: 'AppImage',
  props: {
    id: Number,
    name: {
      type: String,
      default: '',
    },
    backgroundColor: {
      type: String,
      default: '#7b8ca3',
    },
    height: Number,
    width: Number,
  },
  data: () => ({
    loading: false,
  }),
  computed: {
    url() {
      return getImage(this.id);
    },
    urlLowQuality() {
      return getImageSmall(this.id);
    },
    aspectRatio() {
      if (this.width || !this.height) return null;

      return (this.height / this.width) * 100;
    },
    style() {
      const style = { backgroundColor: this.backgroundColor };

      if (this.width) style.width = `${this.width}px`;

      const applyAspectRatio = this.loading && this.aspectRatio;
      if (applyAspectRatio) {
        style.height = 0;
        style.paddingTop = `${this.aspectRatio}%`;
      }

      return style;
    },
  },
  mounted() {
    this.setLoadingState(true);
    const observer = lozad(this.$el, {
      load: el => {
        el.src = el.dataset.src;
        el.onload = () => {
          this.loading = false;
        };
      },
    });
    observer.observe();
  },
  updated() {
    // this.$el.src = this.$el.dataset.src;
  },
  destroyed() {
    this.$el.removeEventListener('load', this.setLoadingState(false));
  },
  methods: {
    setLoadingState(state) {
      this.loading = state;
    },
  },
};
</script>

<style lang="stylus" scoped>
.app-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  object-position: center center;
  transition: 0.3s;
  themify(
    $themes,
    @($theme) {
    filter: $theme.$image--grayscale--filter;
  }
  );

  &.blur-image {
    filter: blur(20px);
    transform: scale(1.1);
  }
}
</style>
