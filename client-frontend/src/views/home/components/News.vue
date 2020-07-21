<template>
  <section id="news">
    <div class="app-container grid-area">
      <div class="section-header">
        <h2>{{ $t('views.home.news.title') }}</h2>
      </div>
      <div class="section-body">
        <div class="row mx-md-n4">
          <div
            v-for="item in newsList"
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
          <div class="button-item">
            <router-link :to="{ name: 'news' }" class="btn btn-main">
              {{ $t('views.home.news.allNews') }}
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapState, mapActions } from 'vuex';
import NewsCard from '@/components/NewsCard';

export default {
  name: 'News',
  components: {
    NewsCard,
  },
  data: () => ({
    params: { size: 3, page: 0 },
  }),
  computed: {
    ...mapState({
      locale: state => state.app.locale,
      newsList: state => state.news.newsList,
    }),
  },
  watch: {
    locale() {
      this.getNews(this.params);
    },
  },
  mounted() {
    this.getNews(this.params);
  },
  methods: {
    ...mapActions('news', ['getNews']),
  },
};
</script>
