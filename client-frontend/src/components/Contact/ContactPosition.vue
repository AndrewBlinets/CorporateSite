<template>
  <div class="position">
    <h5>
      <slot></slot>
    </h5>
  </div>
</template>

<script>
export default {
  name: 'ContactPositon',
};
</script>

<style lang="stylus" scoped>
.position {
  margin-bottom: 1rem;

  h5::after {
    content: '';
    display: block;
    width: 60px;
    margin-top: 6px;
    themify(
      $themes,
      @($theme) {
      border-bottom: 2px solid $theme.$primary--dark--color;
    }
    );
  }
}
</style>
