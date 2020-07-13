import request from '@/utils/request';

export function getContactsList() {
  return request({
    url: 'admin-api/contact',
    method: 'GET'
  });
}

export function getContact(id) {
  return request({
    url: `admin-api/contact/${id}`,
    method: 'GET'
  });
}

export function createContact() {
  return request({
    url: 'admin-api/contact',
    method: 'POST'
  });
}

export function updateContact() {
  return request({
    url: 'admin-api/contact',
    method: 'UPDATE'
  });
}

export function deleteContact(id) {
  return request({
    url: `admin-api/contact/${id}`,
    method: 'DELETE'
  });
}