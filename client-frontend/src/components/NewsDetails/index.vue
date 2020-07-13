<template>
  <div class="details-container">
    <div v-if="views" class="views-block">
      <font-awesome-icon :icon="['fas', 'eye']" />
      <span>{{ views }}</span>
    </div>

    <div class="publish-date">
      <span :class="{ 'text--shadow': shadow }">{{ date | formatDate }}</span>
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
    date: String,
    shadow: {
      type: Boolean,
      default: false,
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
    themify(
      $themes,
      @($theme) {
      color: $theme.$secondary--light--color;
      background: $theme.$primary--light--color;
    }
    );
    padding: 6px 8px;
    border-radius: 5px;
    margin-right: 15px;

    >:first-child {
      margin-right: 5px;
    }
  }

  .text--shadow {
    text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.5);
  }
}
</style>
