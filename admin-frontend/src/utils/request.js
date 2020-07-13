import axios from 'axios';
import store from '@/store';
import { Message } from 'element-ui';

const service = axios.create({
  // baseURL: 'http://ws-675:8081/admin-api',
  // baseURL: 'http://www.ipps.by:5454/admin/api',
  baseURL: '/admin/api',
  // timeout: 5000
});

service.interceptors.request.use(
  config => {
    const status = store.state.app.stutusRequest;
    if (store.getters.token) {
      config.headers['Authorization'] = `Bearer ${store.getters.token}`;
    }
    
    store.commit('app/SET_STATUS_REQUEST', 'PENDING');
    setTimeout(() => {
      if (status === 'PENDING') store.commit('app/SHOW_LOADING');
    }, 1000);

    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

service.interceptors.response.use(
  response => {
    const { data } = response;
    
    store.commit('app/SET_STATUS_REQUEST', 'SUCCESS');
    store.commit('app/HIDE_LOADING');

    return data;
  },
  error => {
    store.commit('app/SET_STATUS_REQUEST', 'ERROR');
    store.commit('app/HIDE_LOADING');
    
    Message({
      message: error.message,
      type: 'error',
      duration: 5000
    });
    return Promise.reject(error);
  }
);

export default service;