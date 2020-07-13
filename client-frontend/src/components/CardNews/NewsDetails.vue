<template>
  <div class="details-container">
    <div v-if="views" class="views-block">
      <font-awesome-icon :icon="['fas', 'eye']" />
      <span>{{ views }}</span>
    </div>
    <div class="publish-date">
      <span>{{ date | formatDate }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'NewsDetails',
  props: {
    views: {
      type: Number,
      default: 0,
    },
    date: {
      type: String,
      default: '',
    },
  },
};
</script>

<style lang="stylus" scoped>
.details-container {
  display: flex;
  flex-direction: row;
  align-items: center;
  line-height: 1;

  .views-block {
    display: flex;
    background-color: #fff;
    color: #1461ff;
    padding: 6px 8px;
    border-radius: 5px;
    margin-right: 15px;

    >:first-child {
      margin-right: 5px;
    }
  }
}
</style>
