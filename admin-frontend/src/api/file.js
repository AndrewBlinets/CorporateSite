import request from '@/utils/request';

const { baseURL } = request.defaults;

export function getFile(id) {
  return `${baseURL}/file/${id}`;
}

export function uploadFileEditor() {
  return `${baseURL}/file/`;
}

export function uploadFile(data) {
  return request({
    url: '/file/file',
    method: 'POST',
    headers: {
      'Content-Type': 'multipart/form-data',
    },
    data,
  });
}
