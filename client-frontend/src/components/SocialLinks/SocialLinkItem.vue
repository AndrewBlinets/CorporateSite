<template>
  <a :href="url" target="_blank" class="social-link">
    <font-awesome-icon :icon="fortAwesomeIcon" />
  </a>
</template>

<script>
export default {
  name: 'SocialLinkItem',
  props: {
    url: {
      type: String,
      default: '',
    },
    fortAwesomeIcon: {
      type: Object,
      default: function() {
        return {};
      },
    },
  },
};
</script>

<style lang="stylus" scoped>
.social-link {
  margin-right: 15px;
  width: 40px;
  height: 40px;
  line-height: 40px;
  border-radius: 50%;
  text-align: center;
  display: inline-block;
  font-size: 14px;
  transition: 0.5s;
  themify(
    $themes,
    @($theme) {
    border: 1px solid $theme.$primary--light--color;
    color: $theme.$primary--light--color;
  }
  );

  &:hover {
    themify(
      $themes,
      @($theme) {
      color: $theme.$secondary--light--color;
      background: $theme.$primary--light--color;
    }
    );
  }
}
</style>
