import request from '@/utils/request';
import store from '@/store';
// const { baseURL } = request.defaults;

export function getDocumentsByPage(params) {
  return request({
    url: '/document',
    methods: 'GET',
    params,
  });
}

export function getDocumentsAll() {
  return request({
    url: '/document/all',
    methods: 'GET',
  });
}

export function getDocument(id) {
  return request({
    url: `/document/${id}`,
    methods: 'GET',
  });
}

export function getDocumentsByProject(id, params) {
  return request({
    url: `/document/byProject/${id}`,
    methods: 'GET',
    params,
  });
}

export function getDocumentsAllByProject(id) {
  return request({
    url: `/document/byProject/${id}/all`,
    methods: 'GET',
  });
}

export function getDocumentsBySheet(id, params) {
  return request({
    url: `/document/bySheet/${id}`,
    methods: 'GET',
    params,
  });
}

export function getDocumentsAllBySheet(id) {
  return request({
    url: `/document/bySheet/${id}/all`,
    methods: 'GET',
  });
}

export function downloadDocument(id) {
  return request({
    url: `/document/download/${id}`,
    methods: 'GET',
    responseType: 'blob',
    onDownloadProgress: progressEvent => {
      const { loaded } = progressEvent;
      store.dispatch('project/progressLoadFile', { id, loaded });
    },
  });
}
