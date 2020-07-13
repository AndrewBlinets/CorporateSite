import request from '@/utils/request';

export function getSections(params) {
  return request({
    url: '/section',
    method: 'GET',
    params
  });
}

export function getSectionsAll() {
  return request({
    url: '/section/all',
    method: 'GET'
  });
}

export function getSectionByPageId(id) {
  return request({
    url: `/section/getByIdPage/${id}`,
    method: 'GET'
  });
}

export function getSection(id) {
  return request({
    url: `/section/${id}`,
    method: 'GET'
  });
}

export function createSection(data) {
  return request({
    url: '/section',
    method: 'POST',
    data
  });
}

export function updateSection(data) {
  return request({
    url: '/section',
    method: 'PUT',
    data
  });
}

export function deleteSection(id) {
  return request({
    url: `/section/${id}`,
    method: 'DELETE'
  });
}
