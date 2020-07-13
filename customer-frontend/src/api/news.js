import request from '@/utils/request';

export function getNews(params) {
  return request({
    url: '/news',
    method: 'GET',
    params,
  });
}

export function getNewsAll() {
  return request({
    url: '/news/all',
    method: 'GET',
  });
}

export function getNewsById(id) {
  return request({
    url: `/news/${id}`,
    method: 'GET',
  });
}

export function getNewsProject(id) {
  return request({
    url: `/news/byIdProject/${id}`,
    method: 'GET',
  });
}

export function getNewsProjectPage(id, params) {
  return request({
    url: `/news/byIdProjectPage/${id}`,
    method: 'GET',
    params,
  });
}
