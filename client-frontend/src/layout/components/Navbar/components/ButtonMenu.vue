<template>
  <div :class="{ 'dark-btn': dark }" class="btn-menu" v-on="$listeners">
    <font-awesome-icon :icon="icon" class="icon" />
  </div>
</template>

<script>
import { faBars } from '@fortawesome/free-solid-svg-icons';

export default {
  name: 'ButtonMenu',
  props: {
    dark: {
      type: Boolean,
      default: false,
    },
  },
  computed: {
    icon() {
      return faBars;
    },
  },
};
</script>

<style lang="stylus" scoped>
.btn-menu {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #222;
  min-width: 50px;
  min-height: 50px;
  border-radius: 4px;
  cursor: pointer;
  z-index: 1;

  &::before {
    content: '';
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    border-radius: inherit;
    opacity: 0;
    transition: opacity 0.2s cubic-bezier(0.4, 0, 0.6, 1);
    background-color: currentColor;
  }

  &:hover::before {
    opacity: 0.08;
  }

  &.dark-btn {
    color: #fff;
  }

  .icon {
    font-size: 20px;
  }
}
</style>
