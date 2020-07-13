<template>
  <router-link
    :to="{ path: `/news/${id}` }"
    class="news-card"
    tag="div"
  >
    <div
      class="news-title"
      :style="{ height: heightTitle + 'px' }"
    >
      <div class="image">
        <app-image :id="image" :name="title" />
      </div>
      <h5 class="title">{{ title }}</h5>
      <div class="title-details">
        <news-details :views="views" :date="datePublish"></news-details>
      </div>
    </div>
    <div v-if="text" class="news-text">{{ text }}</div>
  </router-link>
</template>

<script>
import AppImage from '@/components/AppImage';
import NewsDetails from './NewsDetails';

export default {
  name: 'NewsCard',
  components: {
    AppImage,
    NewsDetails
  },
  props: {
    id: {
      type: Number,
      default: 1
    },
    heightTitle: {
      type: Number,
      default: 100
    },
    image: {
      type: Number,
      default: 15
    },
    title: {
      type: String,
      default: ''
    },
    views: {
      type: Number,
      default: 0
    },
    datePublish: {
      type: String,
      default: ''
    },
    text: {
      type: String,
      default: ''
    }
  }
};
</script>

<style lang="stylus">
.news-card
  z-index: 3
  &:hover
    cursor: pointer
.news-title
  position: relative
  overflow: hidden
  .image
    width: 100%
    height: 100%
  .title
    bottom: 15px
    font-size: 18px
    line-height: 1.3rem
    text-shadow: 0 1px 1px rgba(0,0,0,.5)
  .title-details
    top: 15px
  .title, .title-details
    position: absolute
    color: #fff
    left: 15px
    right: 15px
.news-text
  position: relative
  padding-top: 10px
  line-height: 1.4
  min-height: 70px
  max-height: 120px
  overflow: hidden
  &::after
    content: '';
    display: block;
    position: absolute;
    left: 0;
    right: 0;
    bottom: 0;
    height: 20px;
    background-image: linear-gradient(180deg,rgba(255,255,255,.4) 0,#fff 100%)
</style>