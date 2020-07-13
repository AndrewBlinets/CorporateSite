<template>
  <div>
    <h3 class="title mb-3">Последнии новости</h3>
    <div class="last-news_container ">
      <div
        class="row mx-lg-n3 mx-n1 d-flex flex-lg-wrap flex-nowrap overflow-auto"
      >
        <div
          v-for="item of news"
          :key="item.id"
          class="col-lg-12 col-md-5 col-sm-5 col-10 mb-lg-2 px-lg-3 px-1"
        >
          <news-card
            :id="item.id"
            :heightTitle="200"
            :image="item.mainImage"
            :title="item.shortTitle"
            :datePublish="item.datePublic"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import NewsCard from '@/components/NewsCard';

export default {
  name: 'LastNewsList',
  components: {
    NewsCard,
  },
  computed: {
    ...mapState({
      news: state => state.news.newsList,
    }),
  },
  created() {
    this.$store.dispatch('news/getNews', { size: 5, page: 0 });
  },
};
</script>

<style lang="stylus" scoped>
.title {
  font-size: 20px;
  font-weight: 800;
  text-transform: uppercase;
  themify(
    $themes,
    @($theme) {
    color: $theme.$third--light--color;
  }
  );
}

.overflow-auto {
  overflow: auto;
}
</style>
