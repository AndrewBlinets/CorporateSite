<template>
  <div class="row mx-md-n4">
    <div
      v-for="item in news"
      :key="item.id"
      class="col-lg-4 col-sm-6 px-md-4 mb-5"
    >
      <news-card
        :id="item.id"
        :heightTitle="250"
        :image="item.mainImage"
        :title="item.shortTitle"
        :views="item.countView"
        :datePublish="item.datePublic"
        :text="item.entrySpeech"
      />
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import NewsCard from '@/components/NewsCard';

export default {
  name: 'News',
  components: {
    NewsCard,
  },
  props: {
    pageId: Number,
  },
  computed: {
    ...mapGetters(['news']),
    lastIndex() {
      return this.news.length - 1;
    },
  },
  created() {
    this.$store.dispatch('news/getNews', { pageId: this.pageId, size: 3 });
  },
};
</script>
