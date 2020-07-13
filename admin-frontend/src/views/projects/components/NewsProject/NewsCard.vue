<template>
  <el-card class="news-card">
    <div slot="header" class="clearfix">
      <span class="title">{{ title }}</span>
      <span class="date">{{ date | formatDate }}</span>
    </div>

    <div class="content" v-html="content"></div>
  </el-card>
</template>

<script>
export default {
  name: 'NewsCard',
  props: {
    title: String,
    shortTitle: String,
    date: String,
    content: String,
  },
};
</script>

<style lang="stylus">
.news-card {
  flex: 100%;
  margin-bottom: 20px;
  width: 700px;
  overflow: initial;

  .title {
    font-size: 18px;
    font-weight: 600;
  }

  .content {
    width: 100%;

    .image img {
      width: 100%;
      object-fit: contain;
    }
  }
}
</style>
