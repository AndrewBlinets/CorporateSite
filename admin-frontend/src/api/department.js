import request from '@/utils/request';

export function getDepartmentsList() {
  return request({
    url: '/department/all',
    method: 'GET',
  });
}

export function getDepartment(id) {
  return request({
    url: `/department/${id}`,
    method: 'GET'
  });
}

export function createDepartment(data) {
  return request({
    url: '/department',
    method: 'POST',
    data
  });
}

export function updateDepartment(data) {
  return request({
    url: '/department',
    method: 'PUT',
    data
  });
}

export function deleteDepartment(id) {
  return request({
    url: `/department/${id}`,
    method: 'DELETE'
  });
}
