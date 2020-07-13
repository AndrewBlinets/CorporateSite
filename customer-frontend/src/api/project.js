import request from '@/utils/request';

export function getProjects() {
  return request({
    url: '/project',
    method: 'GET',
  });
}

export function getProject(id) {
  return request({
    url: `/project/${id}`,
    method: 'GET',
  });
}

export function getProjectsAll() {
  return request({
    url: '/project/all',
    method: 'GET',
  });
}

export function getFavoritesProjects() {
  return request({
    url: '/favorites',
    method: 'GET',
  });
}

export function addFavoritesProject(data) {
  return request({
    url: '/favorites',
    method: 'POST',
    data,
  });
}

export function deleteFavoritesProject(id) {
  return request({
    url: `/favorites/${id}`,
    method: 'DELETE',
  });
}
