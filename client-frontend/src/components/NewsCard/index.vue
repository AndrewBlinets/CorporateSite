<template>
  <router-link :to="{ path: `/news/${id}` }" class="news-card" tag="div">
    <div class="news-title" :style="{ height: height }">
      <div class="image">
        <app-image :id="image" :name="title" />
      </div>

      <div class="title-details">
        <news-details :date="datePublish" shadow></news-details>
      </div>

      <h5 class="title">{{ title }}</h5>
    </div>

    <div v-if="text" class="news-text">{{ text }}</div>
  </router-link>
</template>

<script>
import AppImage from '@/components/AppImage';
import NewsDetails from '@/components/NewsDetails';

export default {
  name: 'CardNews',
  components: {
    AppImage,
    NewsDetails,
  },
  props: {
    id: Number,
    title: String,
    views: Number,
    datePublish: String,
    height: {
      type: String,
      default: '200px',
    },
    image: {
      type: Number,
      default: 15,
    },
    text: {
      type: String,
      default: '',
    },
  },
};
</script>

<style lang="stylus">
.news-card {
  z-index: 3;

  &:hover {
    cursor: pointer;
  }
}

.news-title {
  position: relative;
  overflow: hidden;

  .image {
    position: relative;
    width: 100%;
    height: 100%;

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
    }
  }

  .title {
    position: relative;
    bottom: 15px;
    font-size: 20px;
    line-height: 1.3rem;
    text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.5);
    z-index: 2;
    themify(
      $themes,
      @($theme) {
      text-shadow: 1px 1px 1px $theme.$gradient--secondary--color;
    }
    );
  }

  .title-details {
    position: relative;
    top: 15px;
    z-index: 2;
  }

  .title, .title-details {
    position: absolute;
    left: 15px;
    right: 15px;
    themify(
      $themes,
      @($theme) {
      color: $theme.$background--primary--color;
    }
    );
  }
}

.news-text {
  position: relative;
  padding-top: 10px;
  line-height: 1.4;
  min-height: 70px;
  max-height: 120px;
  overflow: hidden;

  &::after {
    content: '';
    display: block;
    position: absolute;
    left: 0;
    right: 0;
    bottom: 0;
    height: 20px;
    themify(
      $themes,
      @($theme) {
      background-image: $theme.$news--after--gradient;
    }
    );
  }
}
</style>
