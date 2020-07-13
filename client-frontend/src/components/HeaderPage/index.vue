<template>
  <div class="header-page">
    <div class="img-container">
      <app-image :id="image" />
    </div>
    <div class="app-container">
      <div class="title">
        <slot />
      </div>
    </div>
  </div>
</template>

<script>
import AppImage from '@/components/AppImage';

export default {
  name: 'HeaderPage',
  props: {
    image: {
      type: Number,
      default: 16,
    },
  },
  components: {
    AppImage,
  },
};
</script>

<style lang="stylus" scoped>
.header-page {
  position: relative;
  z-index: 0;

  .img-container {
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    overflow: hidden;
    z-index: 1;

    &:before {
      content: '';
      position: absolute;
      width: 100%;
      height: 100%;
      themify(
        $themes,
        @($theme) {
        background: $theme.$gradient--primary--color;
      }
      );
      z-index: 3;
    }

    &:after {
      position: absolute;
      content: '';
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      z-index: 2;
      themify(
        $themes,
        @($theme) {
        background: $theme.$gradient--secondary--color;
      }
      );
    }
  }

  .title {
    position: relative;
    display: flex;
    flex-direction: column;
    padding-top: 200px;
    padding-bottom: 2rem;
    themify(
      $themes,
      @($theme) {
      color: $theme.$primary--light--color;
    }
    );
    z-index: 4;
  }
}
</style>
