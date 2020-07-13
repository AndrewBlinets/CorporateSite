<template>
  <div class="sidebar-container">
    <transition name="fade">
      <div
        v-if="mobile && sidebar"
        class="overlay__background"
        @click="closeSidebar"
      ></div>
    </transition>

    <transition name="slide-fade">
      <div v-if="mobile && sidebar" class="sidebar-content">
        <app-menu dark></app-menu>
      </div>
    </transition>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';
import AppMenu from './Navbar/components/Menu';

export default {
  name: 'Sidebar',
  components: {
    AppMenu,
  },
  computed: {
    ...mapState('app', ['mobile', 'sidebar']),
  },
  methods: {
    ...mapActions('app', ['closeSidebar']),
  },
};
</script>

<style lang="stylus" scoped>
.sidebar-container {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;

  .overlay__background {
    width: 100vw;
    height: 100vh;
    background: #0003;
    cursor: pointer;
    z-index: 1;
  }

  .sidebar-content {
    position: absolute;
    top: 0;
    right: 0;
    width: 70%;
    height: 100vh;
    padding: 0 10px;
    background: #fff;
    overflow: auto;
  }
}

.slide-fade-enter-active, .slide-fade-leave-active {
  transition: all 0.4s cubic-bezier(0.694, 0, 0.335, 1);
}

.slide-fade-enter, .slide-fade-leave-to {
  transform: translateX(100%);
}

.fade-enter-active, .fade-leave-active {
  transition: opacity 0.4s cubic-bezier(0.694, 0, 0.335, 1);
}

.fade-enter, .fade-leave-to {
  opacity: 0;
}
</style>
