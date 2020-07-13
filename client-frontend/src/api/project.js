import request from '@/utils/request';

export function getProjectsList(params) {
  return request({
    url: '/project',
    method: 'GET',
    params: params,
  });
}

export function getProjectById(id, params) {
  return request({
    url: `/project/${id}`,
    method: 'GET',
    params: params,
  });
}
