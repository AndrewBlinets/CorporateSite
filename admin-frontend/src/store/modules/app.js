const state = {
  loading: false,
  stutusRequest: ''
};
const mutations = {
  SHOW_LOADING: (state) => {
    state.loading = true;
  },
  HIDE_LOADING: (state) => {
    state.loading = false;
  },
  SET_STATUS_REQUEST: (state, status) => {
    state.status = status;
  }
};
const actions = {};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};