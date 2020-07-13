import { 
  getNewsList,
  getNews,
  createNews,
  updateNews,
  deleteNews
} from '@/api/news';

const state = {
  newsList: {},
  params: {
    size: 10,
    page: 0
  },
  news: {}
};

const mutations = {
  SET_NEWS_LIST: (state, list) => {
    state.newsList = list;
  },
  ADD_PARAMS: (state, params) => {
    Object.assign(state.params, params);
  },
  REMOVE_PARAMS: (state, name) => {
    delete state.params[name];
  },
  SET_PARAMS_LIST: (state, params) => {
    const { size, page} = params;
    state.size = size;
    state.page = page;
  },
  SET_NEWS: (state, news) => {
    state.news = news;
  }
};

const getters = {
  newsListData: state => state.newsList.content,
  newsListTotal: state => state.newsList.totalElements
};

const actions = {
  getNewsList({ state, commit }, params = {}) {
    commit('ADD_PARAMS', params);
    return new Promise(resolve => {
      getNewsList(state.params).then(data => {
        commit('SET_NEWS_LIST', data);
        resolve();
      });
    });
  },
  getNews({ commit }, id) {
    return new Promise(resolve => {
      getNews(id).then(data => {
        commit('SET_NEWS', data);
        resolve();
      });
    });
  },
  createNews({ commit }, news) {
    return new Promise(resolve => {
      createNews(news).then(data => {
        commit('SET_NEWS', data);
        resolve(data.id);
      });
    });
  },
  updateNews({ commit }, news) {
    return new Promise((resolve) => {
      updateNews(news).then(data => {
        commit('SET_NEWS', data);
        resolve();
      });
    });
  },
  deleteNews({ dispatch }, id) {
    return new Promise(resolve => {
      deleteNews(id).then(() => {
        dispatch('getNewsList');
        resolve();
      });
    });
  },
  resetNews({ commit }) {
    commit('SET_NEWS', {});
    return Promise.resolve();
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  getters,
  actions
};