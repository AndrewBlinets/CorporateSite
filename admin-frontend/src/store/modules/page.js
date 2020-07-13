import {
  getPages,
  getPage
} from '@/api/page';

const state = {
  pagesList: [],
  page: {}
};

const mutations = {
  SET_PAGES_LIST: (state, list) => {
    state.pagesList = list;
  },
  SET_PAGE: (state, page) => {
    state.page = page;
  }
};

const getters = {
  sections: state => state.page.sections || []
};

const actions = {
  getPagesList({ commit }) {
    return new Promise(resolve => {
      getPages().then(data => {
        commit('SET_PAGES_LIST', data.content);
        resolve();
      });
    });
  },
  getPage({ commit }, id) {
    return new Promise(resolve => {
      getPage(id).then(data => {
        commit('SET_PAGE', data);
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
  actions
};
