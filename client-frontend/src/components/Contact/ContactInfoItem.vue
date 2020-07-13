<template>
  <div class="contact__info-item">
    <font-awesome-icon :icon="icon" class="icon" />
    <span class="info-item-title">{{ title }}</span>
    <span>: {{ value }}</span>
  </div>
</template>

<script>
export default {
  name: 'ContactInfoItem',
  props: {
    icon: Object,
    title: String,
    value: String,
  },
};
</script>

<style lang="stylus" scoped>
.contact__info-item {
  display: flex;
  flex-wrap: wrap;
  align-items: center;

  .icon {
    width: 20px;
    text-align: center;
    margin-right: 10px;
  }

  .info-item-title {
    min-width: 80px;
    word-wrap: normal;
  }

  .icon, .info-item-title {
    themify(
      $themes,
      @($theme) {
      color: $theme.$third--light--color;
    }
    );
  }
}
</style>
