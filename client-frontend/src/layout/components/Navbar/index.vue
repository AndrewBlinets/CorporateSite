<template>
  <header
    v-scroll="handleSroll"
    class="navbar navbar-default navbar-fixed menu-top"
    :class="{ 'menu-shrink': menuShrink }"
  >
    <div class="app-container">
      <div class="content">
        <div class="logo">
          <app-image :id="142" name="ИППС" backgroundColor="#ffffff00" />
        </div>

        <div class="navigation-panel">
          <app-menu v-if="!mobile" :dark="menuShrink" />

          <settings :dark="!menuShrink"></settings>
          <menu-button
            v-if="mobile"
            :dark="!menuShrink"
            @click="openSidebar"
          ></menu-button>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
import { mapState, mapActions } from 'vuex';
import { Scroll } from '@/directive/scroll';
import AppMenu from './components/Menu.vue';
import AppImage from '@/components/AppImage/index.vue';
import MenuButton from './components/MenuButton.vue';
import Settings from './Settings';

export default {
  name: 'Navbar',
  components: {
    AppMenu,
    AppImage,
    MenuButton,
    Settings,
  },
  directives: {
    Scroll,
  },
  data: () => ({
    menuShrink: false,
  }),
  computed: {
    ...mapState('app', ['mobile', 'sidebar']),
  },
  methods: {
    ...mapActions('app', ['openSidebar']),
    handleSroll() {
      this.menuShrink = window.scrollY > 50;
    },
  },
};
</script>

<style lang="stylus" scoped>
.navbar {
  position: relative;
  min-height: 50px;
  z-index: 1000;

  &.navbar-default {
    width: 100%;
    padding: 10px 0;
    transition: all 0.3s cubic-bezier(0.25, 0.8, 0.5, 1);
    -webkit-transition: all 0.3s cubic-bezier(0.25, 0.8, 0.5, 1);

    .content {
      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 50px;

      .navigation-panel {
        display: flex;
        justify-content: flex-end;
        align-items: center;
      }
    }
  }

  &.navbar-fixed {
    position: fixed;
    right: 0;
    left: 0;
  }

  &.menu-top {
    themify(
      $themes,
      @($theme) {
      background: $theme.$navbar--background--color;
    }
    );
  }
}

.navbar-default.menu-shrink {
  themify(
    $themes,
    @($theme) {
    background-color: $theme.$navbar--background--color--scroll;
  }
  );
  box-shadow: 0px 5px 10px rgba(20, 97, 255, 0.1);
}

.logo {
  width: 50px;
  height: 50px;
}
</style>
