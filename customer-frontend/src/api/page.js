import request from '@/utils/request';

export function getPage(id) {
  return request({
    url: `/page/${id}`,
    method: 'GET',
  });
}
