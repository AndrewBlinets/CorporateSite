import axios from 'axios';
import router from '@/router';

const service = axios.create({
  baseURL: '/api',
  timeout: 5000,
});

service.interceptors.request.use(
  config => config,
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
    if (error.response.status === 404) {
      router.push({ name: '404' });
    } else if (typeof error.response === 'undefined') {
      router.push({ name: 'network-issue' });
    }
    return Promise.reject(error);
  },
);

export default service;
