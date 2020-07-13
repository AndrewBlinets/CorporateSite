<template>
  <router-link
    :to="{ path: `/projects/${id}` }"
    :style="{ height: height }"
    class="project-card"
    tag="div"
  >
    <div class="image">
      <app-image :id="image" :name="title" />
    </div>

    <div class="project-title">
      <h5 class="title">{{ title }}</h5>
    </div>
  </router-link>
</template>

<script>
import AppImage from '@/components/AppImage';

export default {
  name: 'ProjectCard',
  components: {
    AppImage,
  },
  props: {
    id: Number,
    title: String,
    height: {
      type: String,
      default: '250px',
    },
    image: {
      type: Number,
      default: 15,
    },
  },
};
</script>

<style lang="stylus" scoped>
.project-card {
  position: relative;
  overflow: hidden;
  z-index: 1;

  &:hover {
    cursor: pointer;

    .project-title {
      themify(
        $themes,
        @($theme) {
        background: $theme.$gradient--secondary--color;
      }
      );
    }
  }

  .image {
    position: relative;
    width: 100%;
    height: 100%;
    z-index: 2;

    &::before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      z-index: 1;
      themify(
        $themes,
        @($theme) {
        background: $theme.$news--card--image-gradient;
      }
      );
      z-index: 3;
    }
  }

  .project-title {
    display: flex;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    padding: 20px;
    -webkit-transition: 0.2s;
    transition: 0.2s;
    z-index: 4;

    .title {
      margin: auto;
      text-align: center;
      themify(
        $themes,
        @($theme) {
        color: $theme.$background--primary--color;
        text-shadow: 1px 1px 1px $theme.$gradient--secondary--color;
      }
      );
    }
  }
}
</style>
