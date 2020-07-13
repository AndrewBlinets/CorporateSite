<template>
  <div class="contact__name" :class="directionNameClass">
    <h3>{{ name }}</h3>
    <h3>{{ patronicname }}</h3>
    <h3>{{ surname }}</h3>
  </div>
</template>

<script>
export default {
  name: 'ContactName',
  props: {
    name: String,
    patronicname: String,
    surname: String,
    direction: {
      type: String,
      default: 'row',
    },
  },
  computed: {
    directionNameClass() {
      return `name-${this.direction}`;
    },
  },
};
</script>

<style lang="stylus" scoped>
.contact__name {
  display: flex;
  margin-bottom: 2rem;

  &.name-row {
    flex-direction: row;

    h3:not(:last-child) {
      margin-right: 10px;
    }
  }

  &.name-column {
    flex-direction: column;
  }

  h3 {
    themify(
      $themes,
      @($theme) {
      color: $theme.$secondary--dark--color;
    }
    );
    font-weight: 300;
  }
}
</style>
