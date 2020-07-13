import {
  getProject,
  createProject,
  updateProject,
  deleteProject,
} from '@/api/project';

const state = {
  project: {},
};

const mutations = {
  SET_PROJECT: (state, project) => {
    state.project = project;
  },
};

const actions = {
  getProject({ commit }, id) {
    return new Promise(resolve => {
      getProject(id).then(data => {
        commit('SET_PROJECT', data);
        resolve();
      });
    });
  },
  createProject({ commit }, project) {
    return new Promise(resolve => {
      createProject(project).then(data => {
        commit('SET_PROJECT', data);
        resolve(data.id);
      });
    });
  },
  updateProject({ commit }, project) {
    return new Promise(resolve => {
      updateProject(project).then(data => {
        commit('SET_PROJECT', data);
        resolve();
      });
    });
  },
  deleteProject(id) {
    return new Promise(resolve => {
      deleteProject(id).then(() => {
        resolve();
      });
    });
  },
  resetProject({ commit }) {
    commit('SET_PROJECT', {});
    return Promise.resolve();
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
