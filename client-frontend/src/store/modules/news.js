import { getNewsList, getNewsById } from '@/api/news';

const state = {
  newsList: [],
  hasNewsFull: false,
  params: {
    size: 9,
    page: 0,
  },
  article: {},
};

const mutations = {
  SET_NEWS_LIST: (state, list) => {
    if (state.params.page) {
      state.newsList = state.newsList.concat(list);
    } else {
      state.newsList = list;
    }
  },
  SET_HAS_NEWS_FULL: (state, value) => {
    state.hasNewsFull = value;
  },
  SET_PARAMS: (state, params) => {
    state.params = params;
  },
  RESET_PARAMS: state => {
    state.params = { size: 9, page: 0 };
  },
  ADD_PARAMS: (state, params) => {
    Object.assign(state.params, params);
  },
  SET_ARTICLE: (state, article) => {
    state.article = article;
  },
};

const getters = {
  page: state => state.params.page,
};

const actions = {
  getNews({ commit }, params = {}) {
    commit('RESET_PARAMS');
    commit('ADD_PARAMS', params);
    return new Promise(resolve => {
      getNewsList(state.params).then(data => {
        const { content, number, totalPages } = data;

        commit('SET_HAS_NEWS_FULL', number + 1 === totalPages);
        commit('SET_NEWS_LIST', content);
        resolve();
      });
    });
  },
  getArticle({ commit }, id) {
    return new Promise(resolve => {
      getNewsById(id).then(data => {
        commit('SET_ARTICLE', data);
        resolve();
      });
    });
  },
  resetNews({ commit }) {
    commit('SET_NEWS_LIST', []);
    commit('RESET_PARAMS');
    return Promise.resolve();
  },
  resetArticle({ commit }) {
    commit('SET_ARTICLE', {});
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
