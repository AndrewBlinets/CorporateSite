import {
  getSection,
  createSection,
  updateSection,
  deleteSection
} from '@/api/section';

const state = {
  section: {},
  pageId: null
};

const mutations = {
  SET_SECTION: (state, section) => {
    state.section = section;
  },
  SET_PAGE_ID: (state, id) => {
    state.pageId = id;
  }
};

const actions = {
  getSection({ commit }, id) {
    return new Promise(resolve => {
      getSection(id).then(data => {
        commit('SET_SECTION', data);
        resolve();
      });
    });
  },
  createSection({ commit }, data) {
    return new Promise(resolve => {
      createSection(data).then(data => {
        commit('SET_SECTION', data);
        resolve();
      });
    });
  },
  updateSection({ commit }, data) {
    return new Promise(resolve => {
      updateSection(data).then(data => {
        commit('SET_SECTION', data);
        resolve();
      });
    });
  },
  deleteSection({ commit }, id) {
    return new Promise(resolve => {
      deleteSection(id).then(() => {
        commit('SET_SECTION', {});
        resolve();
      });
    });
  },
  resetSection({ commit }) {
    commit('SET_SECTION', {});
    return Promise.resolve();
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
