import request from '@/utils/request';

export function login(data) {
  return request({
    url: '/authenticate',
    method: 'POST',
    data,
  });
}

export function logout() {
  return request({
    url: '/logoutUser',
    method: 'GET',
  });
}

export function getInfo() {
  return request({
    url: '/getInfo',
    method: 'GET',
  });
}
