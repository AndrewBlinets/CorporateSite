import { login, logout, getInfo } from '@/api/user';
import { getToken, setToken, removeToken } from '@/utils/auth';
import { resetRouter } from '../../router';

const state = {
  token: getToken(),
  name: '',
  surname: '',
  patronic: '',
  roles: [],
};

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token;
  },
  SET_NAME: (state, name) => {
    state.name = name;
  },
  SET_SURNAME: (state, surname) => {
    state.surname = surname;
  },
  SET_PATRONYMIC: (state, patronic) => {
    state.patronic = patronic;
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles;
  },
};

const actions = {
  login(
    { commit },
    userInfo = { username: 'javainuse', password: 'password' },
  ) {
    const { username, password } = userInfo;
    return new Promise((resolve, reject) => {
      login({ username, password })
        .then(data => {
          commit('SET_TOKEN', data.token);
          setToken(data.token);
          resolve();
        })
        .catch(error => {
          reject(error);
        });
    });
  },

  getInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      getInfo(state.token)
        .then(data => {
          const { name, surName, patronicName, roles } = data;

          commit('SET_NAME', name);
          commit('SET_SURNAME', surName);
          commit('SET_PATRONYMIC', patronicName);
          commit('SET_ROLES', roles);
          resolve(data);
        })
        .catch(error => {
          reject(error);
        });
    });
  },

  logout({ dispatch }) {
    return new Promise((resolve, reject) => {
      logout()
        .then(() => {
          dispatch('resetToken');
          resetRouter();
          resolve();
        })
        .catch(error => {
          reject(error);
        });
    });
  },

  resetToken({ commit }) {
    return new Promise(resolve => {
      commit('SET_TOKEN', '');
      commit('SET_NAME', '');
      commit('SET_SURNAME', '');
      commit('SET_PATRONYMIC', '');
      commit('SET_ROLES', []);
      removeToken();
      resolve();
    });
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
