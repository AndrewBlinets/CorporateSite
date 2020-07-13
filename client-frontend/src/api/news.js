import request from '@/utils/request';

export function getNewsList(params) {
  return request({
    url: '/news',
    method: 'GET',
    params,
  });
}

export function getNewsById(id, params) {
  return request({
    url: `/news/${id}`,
    method: 'GET',
    params,
  });
}
