<template>
  <div class="lang-container" :class="{ 'dark-menu': dark }">
    <v-menu>
      <template v-slot:activator="{ on, attrs }">
        <v-button v-bind="attrs" text v-on="on">
          <font-awesome-icon :icon="iconGlobe" class="icon-left" />
          {{ currentNameLang }}
          <font-awesome-icon :icon="iconCaretDown" class="icon-right" />
        </v-button>
      </template>

      <div class="v-list">
        <div v-for="lang of langList" :key="lang.lacale" class="v-list-item">
          <div class="v-list-item__content">
            <v-button block text @click="setLanguge(lang)">
              {{ lang.name }}
            </v-button>
          </div>
        </div>
      </div>
    </v-menu>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

import VButton from '@/components/UI/VButton';
import VMenu from '@/components/UI/VMenu';
import { faCaretDown, faGlobe } from '@fortawesome/free-solid-svg-icons';

export default {
  name: 'Language',
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
    currentNameLang: 'Русский',
    langList: [
      {
        name: 'Русский',
        locale: 'ru',
      },
      {
        name: 'Беларуская',
        locale: 'by',
      },
      {
        name: 'English',
        locale: 'en',
      },
    ],
  }),
  computed: {
    ...mapState('app', ['locale']),
    iconCaretDown() {
      return faCaretDown;
    },
    iconGlobe() {
      return faGlobe;
    },
  },
  mounted() {
    this.currentNameLang = this.langList.filter(
      item => item.locale === this.locale,
    )[0].name;
  },
  methods: {
    ...mapActions('app', ['setLocale']),
    setLanguge(lang) {
      this.currentNameLang = lang.name;
      this.setLocale(lang.locale);
      this.$root.$i18n.locale = lang.locale;
    },
  },
};
</script>

<style lang="stylus" scoped>
.lang-container {
  themify(
    $themes,
    @($theme) {
    color: $theme.$navbar--menu-link--dark--color;
  }
  );

  &.dark-menu {
    themify(
      $themes,
      @($theme) {
      color: $theme.$navbar--menu-link--color;
    }
    );
  }
}

.v-list {
  margin: -8px 0;
}

.icon-left {
  font-size: 20px;
  margin-right: 8px;
}

.icon-right {
  margin-left: 8px;
  font-size: 12px;
}
</style>
