<template>
  <v-container class="news-list">
    <v-row justify="center">
      <v-col v-for="item in news" :key="item.id" cols="8">
        <news-card v-bind="item"></news-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { getNewsProject } from '@/api/news';
import { mapState } from 'vuex';
import NewsCard from './NewsCard';

export default {
  name: 'NewsList',
  components: {
    NewsCard,
  },
  data: () => ({
    news: [],
  }),
  computed: {
    ...mapState('project', ['project']),
  },
  mounted() {
    getNewsProject(this.project.id).then(news => {
      this.news = [...news];
    });
  },
};
</script>

<style lang="scss" scoped>
.news-list {
  max-height: 100%;
  overflow: hidden;
}
</style>
