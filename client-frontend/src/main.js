import Vue from 'vue';

import '@/styles/index.styl';
import 'bootstrap/dist/css/bootstrap-grid.min.css';

import VueYouTubeEmbed from 'vue-youtube-embed';

import App from './App.vue';

import router from '@/router';
import store from '@/store';
import * as filters from '@/filters';

import { createI18n } from '@/i18n';

const i18n = createI18n(store, router);

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
Vue.component('font-awesome-icon', FontAwesomeIcon);

Vue.config.productionTip = false;

Vue.use(VueYouTubeEmbed);

Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key]);
});

new Vue({
  router,
  store,
  i18n,
  render: h => h(App),
}).$mount('#app');
