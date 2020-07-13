import request from '@/utils/request';

export function getDocumentsByProject(id) {
  return request({
    url: `/documentForCustomer/byProject/${id}/all`,
    method: 'GET',
  });
}

export function createDocumentByProject(data) {
  return request({
    url: '/documentForCustomer',
    method: 'POST',
    data,
  });
}

export function deleteDocument(id) {
  return request({
    url: `/documentForCustomer/${id}`,
    method: 'DELETE',
  });
}
