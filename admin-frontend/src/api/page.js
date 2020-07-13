import request from '@/utils/request';

export function getPages(params) {
  return request({
    url: '/page',
    method: 'GET',
    params
  });
}

export function getPagesAll() {
  return request({
    url: '/page/all',
    method: 'GET'
  });
}

export function getPage(id) {
  return request({
    url: `/page/${id}`,
    method: 'GET'
  });
}

export function createPage(data) {
  return request({
    url: '/page',
    method: 'POST',
    data
  });
}

export function updatePage(data) {
  return request({
    url: '/page',
    method: 'PUT',
    data
  });
}

export function deletePage(id) {
  return request({
    url: `/page/${id}`,
    method: 'DELETE'
  });
}
