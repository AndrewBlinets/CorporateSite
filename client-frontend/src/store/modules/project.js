import { getProjectsList, getProjectById } from '@/api/project';

const state = {
  projectsList: [],
  hasProjectsFull: false,
  params: {
    size: 9,
    page: 0,
  },
  project: {},
};

const mutations = {
  SET_PROJECTS_LIST: (state, list) => {
    if (state.params.page) {
      state.projectsList = state.projectsList.concat(list);
    } else {
      state.projectsList = list;
    }
  },
  SET_HAS_PROJECTS_FULL: (state, value) => {
    state.hasProjectsFull = value;
  },
  SET_PARAMS: (state, params) => {
    state.params = params;
  },
  ADD_PARAMS: (state, params) => {
    Object.assign(state.params, params);
  },
  SET_PROJECT: (state, project) => {
    state.project = project;
  },
};

const getters = {
  page: state => state.params.page,
};

const actions = {
  getProjects({ commit }, params = {}) {
    commit('ADD_PARAMS', params);
    return new Promise(resolve => {
      getProjectsList(state.params).then(data => {
        const { content, number, totalPages } = data;

        commit('SET_HAS_PROJECTS_FULL', number + 1 === totalPages);
        commit('SET_PROJECTS_LIST', content);
        resolve();
      });
    });
  },
  getProject({ commit }, id) {
    return new Promise(resolve => {
      getProjectById(id).then(data => {
        commit('SET_PROJECT', data);
        resolve();
      });
    });
  },
  resetProjects({ commit }) {
    commit('SET_PROJECTS_LIST', []);
    commit('SET_HAS_PROJECTS_FULL', false);
    commit('SET_PARAMS', { size: 9, page: 0 });
    return Promise.resolve();
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
  getters,
  actions,
};
