<template>
  <div class="news-project__container">
    <div class="news-list">
      <news-card v-for="item in news" :key="item.id" v-bind="item"></news-card>
    </div>

    <el-divider></el-divider>

    <el-button v-if="!addNews" type="primary" @click="addNews = true">
      Новая нвость
    </el-button>
    <div v-else>
      <el-form ref="form" label-width="190px">
        <content-project v-bind="newsForm" @input="contentNews" />
      </el-form>
      <div>
        <el-button type="success" @click="createNews">
          Опубликовать
        </el-button>
        <el-button type="primary" @click="addNews = false">
          Отмена
        </el-button>
      </div>
    </div>
  </div>
</template>

<script>
import { getNewsForCustomerProject, createNewsForCustomer } from '@/api/news';
import NewsCard from './NewsCard';
import ContentProject from '../ContentProject';

export default {
  name: 'NewsProject',
  components: {
    NewsCard,
    ContentProject,
  },
  data: () => ({
    addNews: false,
    news: [],
    newsForm: {
      title: '',
      shortTitle: '',
      content: '',
    },
  }),
  mounted() {
    this.getNews();
  },
  methods: {
    getNews() {
      const { id } = this.$route.params;
      getNewsForCustomerProject(id).then(data => {
        this.news = data;
      });
    },
    contentNews({ field }) {
      this.newsForm[field.name] = field.value;
    },
    createNews() {
      const { id } = this.$route.params;
      createNewsForCustomer({ project: { id: +id }, ...this.newsForm }).then(
        () => {
          this.getNews();
          this.cleanSetNews();
        },
      );
    },
    cleanSetNews() {
      this.newsForm = {
        title: '',
        shortTitle: '',
        content: '',
      };
      this.addNews = false;
    },
  },
};
</script>

<style lang="stylus" scoped>
.news-project__container {
  display: flex;
  flex-direction: column;
  height: 100%;

  .news-list {
    display: flex;
    flex-direction: column-reverse;
    align-items: center;
    overflow: auto;
  }
}
</style>
