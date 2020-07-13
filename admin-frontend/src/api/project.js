import request from '@/utils/request';

export function getProjectsList(params) {
  return request({
    url: '/project',
    method: 'GET',
    params,
  });
}

export function getProject(id) {
  return request({
    url: `/project/${id}`,
    method: 'GET',
  });
}

export function createProject(data) {
  return request({
    url: '/project',
    method: 'POST',
    data,
  });
}

export function updateProject(data) {
  return request({
    url: '/project',
    method: 'PUT',
    data,
  });
}

export function deleteProject(id) {
  return request({
    url: `/project/${id}`,
    method: 'DELETE',
  });
}

export function setCustomers(id, data) {
  return request({
    url: `/project/setCustomers/${id}`,
    method: 'POST',
    data,
  });
}

export function publicForClient(id, data) {
  return request({
    url: `/project/publicForClient/${id}`,
    method: 'POST',
    data,
  });
}
