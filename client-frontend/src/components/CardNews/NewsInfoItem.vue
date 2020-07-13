<template>
  <div
    v-resize="handleResize"
    class="news-info"
  >
    <h5>
      <router-link :to="{ path: `/news/${id}` }">{{ shortTitle }}</router-link>
    </h5>
    <div class="state">
      <div class="state-item state-comment">
        <font-awesome-icon :icon="['fas', 'comment-alt']" />
        <span>{{ countView }}</span>
      </div>
      <div class="state-item state-data">
        <span>{{ datePublic | formatDate }}</span>
      </div>
    </div>
    <p v-if="!compact">{{ entrySpeech }}</p>
  </div>
</template>

<script>
import { Resize } from '@/directive/resize';

export default {
  name: 'NewsInfoItem',
  directives: {
    Resize
  },
  props: {
    id: Number,
    datePublic: String,
    shortTitle: String,
    mainImage: Number,
    countView: Number,
    entrySpeech: String,
    compact: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      showSpeech: true,
      over: false
    };
  },
  mounted() {
    // this.compact = this.$el.clientWidth < 310;
  },
  methods: {
    handleResize() {
      // this.compact = this.$el.clientWidth < 310;
    }
  }
};
</script>

<style lang="stylus" scoped>
.news-info
  padding: 20px
  z-index: 1
  &:not(:last-child)
    margin-bottom: -20px
  h5 a:hover
      text-decoration: underline
  .state
    display: flex
    width: 100%
    font-size: 14px
    .state-item
      padding-right: 10px
    .state-comment
      span
        margin-left: 5px
  p
    margin-top: 0.5rem

.news-item-img.compact
  .news-info
    h5 a,
    p,
    .state-item
      color: #fff
      text-shadow: 1px 1px 0 rgba(0, 0, 0, .3)
</style>
