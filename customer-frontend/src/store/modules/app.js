const state = {
  sidebar: true,
};

const mutations = {
  SET_SIDEBAR: (state, value) => {
    state.sidebar = value;
  },
  TOGGLE_SIDEBAR: state => {
    state.sidebar = !state.sidebar;
  },
};

const actions = {
  openSidebar({ commit }) {
    commit('SET_SIDEBAR', true);
  },
  closeSidebar({ commit }) {
    commit('SET_SIDEBAR', false);
  },
  toggleSidebar({ commit }) {
    commit('TOGGLE_SIDEBAR');
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
