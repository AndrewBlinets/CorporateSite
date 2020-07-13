<template>
  <div>
    <header-page :image="imagePageId">
      <h1>{{ titlePage }}</h1>
    </header-page>
    <div class="body-page">
      <div class="app-container">
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

        <div class="button-container">
          <div v-if="!hasNewsFull" class="button-item">
            <div class="btn btn-main" @click="loadMore">Загрузить ещё</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import store from '@/store';
import { mapState, mapGetters } from 'vuex';
import HeaderPage from '@/components/HeaderPage/index.vue';
import NewsCard from '@/components/NewsCard/index.vue';

export default {
  name: 'News',
  components: {
    HeaderPage,
    NewsCard,
  },
  computed: {
    ...mapState({
      news: state => state.news.newsList,
      hasNewsFull: state => state.news.hasNewsFull,
    }),
    ...mapGetters('news', ['page']),
  },
  data: () => ({
    titlePage: 'Новости',
    imagePageId: 16,
  }),
  beforeRouteEnter(to, from, next) {
    store.dispatch('news/getNews', { size: 9, page: 0 }).then(() => {
      next();
    });
  },
  destroyed() {
    store.dispatch('news/resetNews');
  },
  methods: {
    loadMore() {
      store.dispatch('news/getNews', { page: this.page + 1 });
    },
  },
};
</script>

<style lang="stylus" scoped>
.body-page {
  margin-top: 50px;
  margin-bottom: 50px;
}
</style>
