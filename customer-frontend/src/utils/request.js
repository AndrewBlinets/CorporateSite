import axios from 'axios';
import store from '@/store';
import { getToken } from './auth';

const service = axios.create({
  baseURL: 'http://www.ipps.by:5454/customer/api',
});

service.interceptors.request.use(
  config => {
    if (store.getters.token) {
      config.headers['Authorization'] = `Bearer ${getToken()}`;
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  },
);

service.interceptors.response.use(
  response => {
    const { data } = response;
    return data;
  },
  error => {
    return Promise.reject(error);
  },
);

export default service;
