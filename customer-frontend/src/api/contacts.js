import request from '../utils/request';

export function getContacts() {
  return request({
    url: '/contact',
    method: 'get',
  });
}
