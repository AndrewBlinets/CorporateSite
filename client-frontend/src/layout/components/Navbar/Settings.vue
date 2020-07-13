<template>
  <div class="settings-container">
    <settings-button
      ref="settings-button"
      :dark="dark"
      @click="settings = !settings"
    ></settings-button>

    <settings-panel
      v-if="settings"
      v-click-outside="handleClickOutside"
      class="menu-settings"
    ></settings-panel>
  </div>
</template>

<script>
import { ClickOutside } from '@/directive/click-outside';
import SettingsButton from './components/SettingsButton';
import SettingsPanel from './components/SettingsPanel/index';

export default {
  name: 'Settings',
  components: {
    SettingsButton,
    SettingsPanel,
  },
  directives: {
    ClickOutside,
  },
  props: {
    dark: {
      type: Boolean,
      default: false,
    },
  },
  data: () => ({
    settings: false,
  }),
  methods: {
    handleClickOutside() {
      if (this.$refs['settings-button'].$el !== event.target)
        this.settings = false;
    },
  },
};
</script>

<style lang="stylus" scoped>
.settings-container {
  position: relative;

  .menu-settings {
    top: 70px;
    right: 0;
  }
}
</style>
