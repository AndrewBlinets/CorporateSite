import {
  getDepartmentsList,
  getDepartment,
  createDepartment,
  updateDepartment,
  deleteDepartment
} from '@/api/department';

const state = {
  departmentsList: [],
  department: {}
};

const mutations = {
  SET_DEPARTMENTS_LIST: (state, list) => {
    state.departmentsList = list;
  },
  ADD_DEPARTMENT: (state, department) => {
    state.departmentsList.push(department);
  },
  UPDATE_DEPARTMENT: (state, { index, department }) => {
    Object.assign(state.departmentsList[index], department);
  },
  SET_DEPARTMENT: (state, department) => {
    state.department = department;
  },
  DELETE_DEPARTMENT: (state, id) => {
    state.departmentsList = state.departmentsList.filter(item => item.id !== id);
  }
};

const getters = {
  searchDepartmens: state => search => state.departmentsList.filter(item => !search || item.name.toLowerCase().includes(search.toLowerCase())),
  getIndex: state => id => state.departmentsList.findIndex(item => item.id === id)
};

const actions = {
  getDepartmentsList({ commit }) {
    return new Promise((resolve) => {
      getDepartmentsList().then(data => {
        commit('SET_DEPARTMENTS_LIST', data);
        resolve();
      });
    });
  },
  getDepartmentById({ commit }, id) {
    return new Promise((resolve) => {
      getDepartment(id).then(data => {
        commit('SET_DEPARTMENT', data);
        resolve();
      });
    });
  },
  createDepartment({ commit }, department) {
    return new Promise((resolve) => {
      createDepartment(department).then((data) => {
        commit('ADD_DEPARTMENT', data);
        resolve();
      });
    });
  },
  updateDepartment({ commit, getters }, department) {
    return new Promise((resolve) => {
      updateDepartment(department).then((data) => {
        const { id } = data;
        const index = getters.getIndex(id);
        commit('UPDATE_DEPARTMENT', { index, department });
        resolve();
      });
    });
  },
  deleteDepartment({ commit }, id) {
    return new Promise((resolve) => {
      deleteDepartment(id).then(() => {
        commit('DELETE_DEPARTMENT', id);
        resolve();
      });
    });
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  getters,
  actions,
};
