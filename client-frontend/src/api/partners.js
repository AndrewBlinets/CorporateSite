import request from '@/utils/request';

export function getPartners() {
  return request({
    url: '/partners',
    method: 'get',
  });
}
