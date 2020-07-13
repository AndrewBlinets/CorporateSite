import request from '@/utils/request';

export function getCustomers() {
  return request({
    url: '/customer',
    method: 'GET',
  });
}

export function getCustomersByProject(id) {
  return request({
    url: `/customer/getList/${id}`,
    method: 'GET',
  });
}

export function createCustomer(data) {
  return request({
    url: '/customer',
    method: 'POST',
    data,
  });
}
