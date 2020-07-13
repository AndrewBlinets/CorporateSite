import { getPage } from '@/api/page';

const state = {
  page: {},
};

const mutations = {
  SET_PAGE: (state, page) => {
    state.page = page;
  },
};

const actions = {
  getPage({ commit }, id) {
    return new Promise(resolve => {
      getPage(id).then(data => {
        commit('SET_PAGE', data);
        resolve();
      });
    });
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
