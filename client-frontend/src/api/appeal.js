import request from '@/utils/request';

export function sendAppeal(data) {
  return request({
    headers: { 'Content-Type': 'multipart/form-data' },
    url: '/electronicAppeal',
    method: 'POST',
    data,
  });
}
