import Vue from 'vue';

import ElementUI from 'element-ui';
import locale from 'element-ui/lib/locale/lang/ru-RU';
import 'element-ui/lib/theme-chalk/index.css';
import CKEditor from '@ckeditor/ckeditor5-vue';

import '@/styles/index.styl';

import './permission';

import App from './App';

import router from './router';
import store from './store';
import * as filters from '@/filters';

import Vuelidate from 'vuelidate';

Vue.use(ElementUI, { locale });
Vue.use(CKEditor);
Vue.use(Vuelidate);

Vue.config.productionTip = false;

Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key]);
});

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');
