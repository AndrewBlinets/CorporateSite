<template>
  <transition name="slide-fade">
    <div class="visually-panel__container">
      <div ref="sdfsdf" class="mb-3">
        <div class="subheader">Размер шрифта</div>
        <div class="content">
          <div class="row mx-n1">
            <div class="col px-1">
              <v-button class="font-button" @click="setFontSize('default')">
                A
              </v-button>
            </div>
            <div class="col px-1">
              <v-button
                class="font-button"
                fontSize="medium"
                @click="setFontSize('medium')"
              >
                A
              </v-button>
            </div>
            <div class="col px-1">
              <v-button
                class="font-button"
                fontSize="large"
                @click="setFontSize('large')"
              >
                A
              </v-button>
            </div>
          </div>
        </div>
      </div>

      <div>
        <div class="subheader">Цветовая схема</div>
        <div class="content">
          <div class="row mx-n2 mb-2">
            <div class="col px-2">
              <v-button color="#1461ff" @click="setThemeApp('default')" />
            </div>
            <div class="col px-2">
              <v-button color="#fff" @click="setThemeApp('white')" />
            </div>
            <div class="col px-2">
              <v-button color="#000" @click="setThemeApp('black')" />
            </div>
            <div class="col px-2">
              <v-button color="#9dd1ff" @click="setThemeApp('blue')" />
            </div>
          </div>

          <div class="row mx-n2">
            <div class="col px-2">
              <v-button color="#f7f3d6" @click="setThemeApp('beige')" />
            </div>
            <div class="col px-2">
              <v-button color="#3b2716" @click="setThemeApp('brown')" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
import { mapActions } from 'vuex';
import VButton from '@/components/UI/VButton';

export default {
  name: 'SettingsPanel',
  components: {
    VButton,
  },
  methods: {
    ...mapActions('app', ['setThemeApp', 'setFontSize']),
  },
};
</script>

<style lang="stylus" scoped>
.visually-panel__container {
  position: absolute;
  min-width: 240px;
  padding: 8px 0;
  background: #fff;
  overflow-y: auto;
  overflow-x: hidden;
  box-shadow: 0 5px 5px -3px rgba(0, 0, 0, 0.2), 0 8px 10px 1px rgba(0, 0, 0, 0.14), 0 3px 14px 2px rgba(0, 0, 0, 0.12);
  border-radius: 4px;

  .subheader {
    display: flex;
    align-items: center;
    height: 48px;
    font-size: 0.875rem;
    padding: 0 16px;
    color: rgba(0, 0, 0, 0.6);
  }

  .content {
    display: flex;
    flex-wrap: wrap;
    padding: 0 16px;

    .font-button {
      color: #222;
    }
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
