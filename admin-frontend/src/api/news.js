import request from '@/utils/request';

export function getNewsList(params) {
  return request({
    url: '/news',
    method: 'GET',
    params,
  });
}

export function getNews(id) {
  return request({
    url: `/news/${id}`,
    method: 'GET',
  });
}

export function createNews(data) {
  return request({
    url: '/news',
    method: 'POST',
    data,
  });
}

export function updateNews(data) {
  return request({
    url: '/news',
    method: 'PUT',
    data,
  });
}

export function deleteNews(id) {
  return request({
    url: `/news/${id}`,
    method: 'DELETE',
  });
}

export function getNewsForCustomerProject(id) {
  return request({
    url: `/newsForCustomer/byProject/${id}/all/`,
    method: 'GET',
  });
}

export function createNewsForCustomer(data) {
  return request({
    url: '/newsForCustomer',
    method: 'POST',
    data,
  });
}

export function deleteNewsForCustomer(id) {
  return request({
    url: `/newForCustomer/${id}`,
    method: 'DELETE',
  });
}
