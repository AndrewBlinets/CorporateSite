import Vue from 'vue';

import '@/styles/index.styl';
import 'bootstrap/dist/css/bootstrap-grid.min.css';

import VueYouTubeEmbed from 'vue-youtube-embed';

import App from './App.vue';

import router from '@/router';
import store from '@/store';
import * as filters from '@/filters';

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
  render: h => h(App),
}).$mount('#app');
