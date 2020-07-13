<template>
  <div class="card news-list-item">
    <news-info-item
      v-for="news in listNews"
      v-bind="news"
      :key="news.id"
    />
  </div>
</template>

<script>
import NewsInfoItem from './NewsInfoItem';

export default {
  name: 'NewsCardList',
  components: {
    NewsInfoItem
  },
  props: {
    listNews: {
      type: Array,
      default: () => [
        {
          id: 1,
          datePublic: '2019-11-20T07:27:52.000+0000',
          shortTitle: '1С 4 по 30 октября 2019 года в Республике Беларусь пройдет перепись населения',          
          mainImage: 0,
          countView: 123,
          entrySpeech: 'Целью подписания соглашения является взаимодействие и координация деятельности по интеграции автоматизированных систем и электронной торговой площадки «Грузовые перевозки».'
        },
        {
          id: 2,
          datePublic: '2019-11-20T07:27:52.000+0000',
          shortTitle: '2С 4 по 30 октября 2019 года в Республике Беларусь пройдет перепись населения',          
          mainImage: 0,
          countView: 123,
          entrySpeech: 'Целью подписания соглашения является взаимодействие и координация деятельности по интеграции автоматизированных систем и электронной торговой площадки «Грузовые перевозки».'
        },
        {
          id: 3,
          datePublic: '2019-11-20T07:27:52.000+0000',
          shortTitle: '3С 4 по 30 октября 2019 года в Республике Беларусь пройдет перепись населения',          
          mainImage: 0,
          countView: 123,
          entrySpeech: 'Целью подписания соглашения является взаимодействие и координация деятельности по интеграции автоматизированных систем и электронной торговой площадки «Грузовые перевозки».'
        }
      ]
    }
  }
};
</script>


<style lang="stylus" scoped>
.news-list-item
  display: flex
  justify-content: space-around
  height: 100%
</style>