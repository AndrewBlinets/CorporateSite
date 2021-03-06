<template>
  <div class="menu-container">
    <div class="menu" :class="{ 'dark-menu': dark }">
      <router-link
        v-for="(link, index) in links"
        :key="index"
        :to="{ name: link.path }"
        class="menu__link"
      >
        {{ $t(`meta.navbar.${link.name}`) }}
      </router-link>

      <v-menu>
        <template v-slot:activator="{ on, attrs }">
          <v-button text v-bind="attrs" v-on="on">
            {{ $t('meta.navbar.more') }}
            <font-awesome-icon :icon="caretDownIcon" class="icon-right" />
          </v-button>
        </template>

        <div class="list--nav">
          <router-link
            :to="{ name: 'eastern-partnership' }"
            class="sub-nav--link"
          >
            {{ $t('meta.navbar.internationalСooperation') }}
          </router-link>

          <router-link
            :to="{ name: 'technical-committee' }"
            class="sub-nav--link"
          >
            {{ $t('meta.navbar.technicalCommittee') }}
          </router-link>

          <router-link
            :to="{ name: 'electronic-appeal' }"
            class="sub-nav--link"
          >
            {{ $t('meta.navbar.eappeal') }}
          </router-link>
        </div>
      </v-menu>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';
import VButton from '@/components/UI/VButton';
import VMenu from '@/components/UI/VMenu';
import { faCaretDown } from '@fortawesome/free-solid-svg-icons';

export default {
  name: 'Menu',
  components: {
    VButton,
    VMenu,
  },
  props: {
    dark: {
      type: Boolean,
      default: false,
    },
  },
  data: () => ({
    links: [
      {
        name: 'home',
        path: 'home',
      },
      {
        name: 'aboutUs',
        path: 'about-us',
      },
      {
        name: 'news',
        path: 'news',
      },
      {
        name: 'projects',
        path: 'projects',
      },
      {
        name: 'contacts',
        path: 'contacts',
      },
    ],
  }),
  computed: {
    ...mapState('app', ['mobile', 'sidebar']),
    caretDownIcon() {
      return faCaretDown;
    },
  },
  watch: {
    $route: 'closeSidebar',
  },
  methods: {
    ...mapActions('app', ['closeSidebar']),
  },
};
</script>

<style lang="stylus" scoped>
.menu-container {
  position: relative;
}

.menu {
  display: flex;
  themify(
    $themes,
    @($theme) {
    color: $theme.$navbar--menu-link--color;
  }
  );

  .menu__link {
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
    font-weight: 400;
    font-size: 16px;
    min-width: 48px;
    min-height: 36px;
    padding: 4px 16px;
    border-radius: 4px;
    margin-right: 5px;
    themify(
      $themes,
      @($theme) {
      color: $theme.$navbar--menu-link--color;
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
  }

  &.dark-menu {
    themify(
      $themes,
      @($theme) {
      color: $theme.$navbar--menu-link--dark--color;
    }
    );

    .menu__link {
      themify(
        $themes,
        @($theme) {
        color: $theme.$navbar--menu-link--dark--color;
      }
      );
    }
  }
}

.icon-right {
  margin-left: 8px;
  font-size: 12px;
}

.list--nav {
  display: flex;
  flex-direction: column;
  padding: 0 8px;

  .sub-nav--link {
    position: relative;
    display: flex;
    align-items: center;
    padding: 0 8px;
    min-height: 40px;
    font-size: 14px;
    font-weight: 500;
    line-height: 1rem;
    white-space: nowrap;
    color: inherit;
    border-radius: 4px;

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
  }

  .sub-nav--link:not(:last-child) {
    margin-bottom: 4px;
  }
}
</style>
