import request from '@/utils/request';

export function login(data) {
  return request({
    url: '/authenticate',
    method: 'POST',
    data,
  });
}

export function logout() {
  console.log('logout');
  return request({
    url: '/logoutCustomer',
    method: 'GET',
  });
}

export function getInfo() {
  return request({
    url: '/getInfoAboutCustomer',
    method: 'GET',
  });
}

export function saveChangesProfile(data) {
  return request({
    url: '/userProfile',
    method: 'POST',
    data,
  });
}
