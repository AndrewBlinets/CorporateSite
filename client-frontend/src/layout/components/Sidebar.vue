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
        <router-link
          v-for="(link, index) in links"
          :key="index"
          :to="{ name: link.path }"
          class="sidebar--link"
        >
          {{ link.name }}
        </router-link>
      </div>
    </transition>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
  name: 'Sidebar',
  data: () => ({
    links: [
      {
        name: 'Главная',
        path: 'home',
      },
      {
        name: 'О нас',
        path: 'about-us',
      },
      {
        name: 'Новости',
        path: 'news',
      },
      {
        name: 'Проекты',
        path: 'projects',
      },
      {
        name: 'Контакты',
        path: 'contacts',
      },
      {
        name: 'Международное Сотрудничество',
        path: 'eastern-partnership',
      },
      {
        name: 'Национальный Технический Комитет',
        path: 'technical-committee',
      },
      {
        name: 'Электронное Обращение',
        path: 'electronic-appeal',
      },
    ],
  }),
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
    display: flex;
    flex-direction: column;
    top: 0;
    right: 0;
    width: 70%;
    height: 100vh;
    padding: 8px;
    overflow: auto;
    themify(
      $themes,
      @($theme) {
      background: $theme.$navbar--background--color--scroll;
    }
    );

    .sidebar--link {
      position: relative;
      display: flex;
      align-items: center;
      padding: 0 8px;
      min-height: 40px;
      font-size: 16px;
      font-weight: 500;
      line-height: 1rem;
      white-space: nowrap;
      border-radius: 4px;
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

      &:not(:last-child) {
        margin-bottom: 4px;
      }
    }
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
