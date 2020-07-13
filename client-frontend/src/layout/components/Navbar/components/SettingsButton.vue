<template>
  <div
    :class="{ 'dark-btn': dark }"
    class="btn-settings"
    v-bind="$attrs"
    v-on="$listeners"
  >
    <font-awesome-icon :icon="icon" class="icon" />
  </div>
</template>

<script>
import { faCog } from '@fortawesome/free-solid-svg-icons';

export default {
  name: 'SettingsButton',
  props: {
    dark: {
      type: Boolean,
      default: false,
    },
  },
  computed: {
    icon() {
      return faCog;
    },
  },
};
</script>

<style lang="stylus" scoped>
.btn-settings {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  min-width: 50px;
  min-height: 50px;
  border-radius: 4px;
  cursor: pointer;
  z-index: 1;
  themify(
    $themes,
    @($theme) {
    color: $theme.$navbar--menu-link--dark--color;
  }
  );

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
    themify(
      $themes,
      @($theme) {
      color: $theme.$navbar--menu-link--color;
    }
    );
  }

  .icon {
    font-size: 20px;
  }
}
</style>
