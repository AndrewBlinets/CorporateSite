function setLocalStorage(value) {
  const stateLocal = JSON.parse(localStorage.getItem('ipps-site')) || {};

  localStorage.setItem(
    'ipps-site',
    JSON.stringify({ ...stateLocal, ...value }),
  );
}

const state = {
  mobile: false,
  sidebar: false,
  theme: 'theme-default',
  fontSize: 'font-size__default',
};

const mutations = {
  SET_MOBILE: (state, value) => {
    state.mobile = value;
  },
  SET_SIDEBAR: (state, value) => {
    state.sidebar = value;
  },
  SET_THEME: (state, value) => {
    state.theme = `theme-${value}`;
  },
  SET_FONT_SIZE: (state, value) => {
    state.fontSize = `font-size--${value}`;
  },
};

const actions = {
  openSidebar({ commit }) {
    commit('SET_SIDEBAR', true);
    return Promise.resolve();
  },
  closeSidebar({ commit }) {
    commit('SET_SIDEBAR', false);
    return Promise.resolve();
  },
  hasMobileDevice({ commit }, value) {
    commit('SET_MOBILE', value);
    return Promise.resolve();
  },
  setThemeApp({ commit }, themeName) {
    setLocalStorage({ theme: themeName });
    commit('SET_THEME', themeName);
    return Promise.resolve();
  },
  setFontSize({ commit }, fontSize) {
    setLocalStorage({ fontSize: fontSize });
    commit('SET_FONT_SIZE', fontSize);
    return Promise.resolve();
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
