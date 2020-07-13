<template>
  <div
    v-resize="handleResize"
    class="card news-item-img"
    :class="{ 'compact': false }"
  >
    <div class="news-img">
      <app-image
        :id="mainImage"
        :name="shortTitle"
      />
    </div>  
    <news-info-item v-bind="$props" />
  </div>
</template>

<script>
import AppImage from '@/components/AppImage';
import NewsInfoItem from './NewsInfoItem';
import { Resize } from '@/directive/resize';

export default {
  name: 'CardNewsItem',
  components: {
    AppImage,
    NewsInfoItem
  },
  directives: {
    Resize
  },
  props: {
    id: {
      type: Number,
      default: 1
    },
    datePublic: {
      type: String,
      default: '2019-11-20T07:27:52.000+0000'
    },
    shortTitle: {
      type: String,
      default: 'С 4 по 30 октября 2019 года в Республике Беларусь пройдет перепись населения',
    },
    mainImage: {
      type: Number,
      default: 15
    },
    countView: {
      type: Number,
      default: 123
    },
    entrySpeech: {
      type: String,
      default: 'Целью подписания соглашения является взаимодействие и координация деятельности по интеграции автоматизированных систем и электронной торговой площадки «Грузовые перевозки».'
    },
    compact: {
      type: Boolean,
      default: false
    }
  },
  mounted() {
    this.handleResize();
  },
  methods: {
    handleResize() {
      // this.compact = this.$el.clientWidth > 411 || this.$el.clientWidth < 308;
    }
  }
};
</script>

<style lang="stylus" scoped>
.news-item-img
  position: relative
  overflow: hidden
  height: 100%
  .news-img
    display: flex
    overflow: hidden
    z-index: 0

.news-item-img.compact
  .news-img
    position: absolute
    width: 100%
</style>