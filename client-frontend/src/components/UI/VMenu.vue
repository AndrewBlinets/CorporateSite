<template>
  <div class="v-menu">
    <slot name="activator" :attrs="attrs" :on="{ click: toggleMenu }"></slot>

    <transition name="slide-fade">
      <div
        v-if="showMenu"
        v-click-outside="handleClickOutsideMenu"
        class="v-memu__container"
      >
        <slot></slot>
      </div>
    </transition>
  </div>
</template>

<script>
import { ClickOutside } from '@/directive/click-outside';

export default {
  name: 'VMenu',
  directives: {
    ClickOutside,
  },
  data: () => ({
    showMenu: false,
    hasActivator: false,
    attrs: { 'data-activator': '' },
  }),
  methods: {
    toggleMenu() {
      this.showMenu = !this.showMenu;
    },
    handleClickOutsideMenu(event) {
      !event.target.attributes['data-activator'] && this.toggleMenu();
    },
  },
};
</script>

<style lang="stylus" scoped>
.v-menu {
  position: relative;

  .v-memu__container {
    position: absolute;
    min-width: 240px;
    top: 70px;
    right: 0;
    padding: 8px 0;
    background: #fff;
    overflow-y: auto;
    overflow-x: hidden;
    box-shadow: 0 5px 5px -3px rgba(0, 0, 0, 0.2), 0 8px 10px 1px rgba(0, 0, 0, 0.14), 0 3px 14px 2px rgba(0, 0, 0, 0.12);
    border-radius: 4px;
    themify(
      $themes,
      @($theme) {
      color: $theme.$menu--color;
      background: $theme.$menu--background--color;
    }
    );
  }
}

.slide-fade-enter-active, .slide-fade-leave-active {
  transition: all 0.3s cubic-bezier(0.694, 0, 0.335, 1);
}

.slide-fade-enter, .slide-fade-leave-to {
  transform: translateY(-20px);
  opacity: 0;
}
</style>
