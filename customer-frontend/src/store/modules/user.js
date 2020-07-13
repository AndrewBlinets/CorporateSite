import { login, logout, getInfo, saveChangesProfile } from '@/api/user';
import { getToken, setToken, removeToken } from '@/utils/auth';

const state = {
  token: getToken(),
  id: null,
  name: '',
  surName: '',
  patronicName: '',
  email: '',
  organization: {},
  projects: [],
  roles: [],
};

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token;
  },
  SET_ID: (state, id) => {
    state.id = id;
  },
  SET_NAME: (state, name) => {
    state.name = name;
  },
  SET_SUR_NAME: (state, surName) => {
    state.surName = surName;
  },
  SET_PATRONIC_NAME: (state, patronicName) => {
    state.patronicName = patronicName;
  },
  SET_EMAIL: (state, email) => {
    state.email = email;
  },
  SET_ORGANIZATION: (state, organization) => {
    state.organization = { ...organization };
  },
  SET_PROJECTS: (state, projects) => {
    state.projects = [...projects];
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles;
  },
};

const getters = {
  shortName: state => `${state.name} ${state.surName}`,
  fullName: state => `${state.name} ${state.patronicName} ${state.surName}`,
  nameAvatar: state => (state.name[0] + state.surName[0] || 'a').toUpperCase(),
};

const actions = {
  login({ commit }, userInfo) {
    return new Promise((resolve, reject) => {
      login(userInfo)
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

  getInfo({ commit }) {
    return new Promise((resolve, reject) => {
      getInfo()
        .then(data => {
          const {
            id,
            name,
            roles,
            surName,
            patronicName,
            email,
            org,
            projects,
          } = data;
          commit('SET_ID', id);
          commit('SET_NAME', name);
          commit('SET_SUR_NAME', surName);
          commit('SET_PATRONIC_NAME', patronicName);
          commit('SET_EMAIL', email);
          commit('SET_ORGANIZATION', org);
          commit('SET_PROJECTS', projects);
          commit('SET_ROLES', roles);
          resolve(data);
        })
        .catch(error => {
          reject(error);
        });
    });
  },

  saveProfile({ dispatch }, userProfile) {
    console.log('handle save profile');
    return new Promise((resolve, reject) => {
      saveChangesProfile(userProfile)
        .then(() => {
          dispatch('getInfo');
          resolve();
        })
        .catch(error => reject(error));
    });
  },

  logout({ dispatch }) {
    return new Promise((resolve, reject) => {
      logout()
        .then(() => {
          dispatch('resetToken').then(() => {
            resolve();
          });
        })
        .catch(error => {
          reject(error);
        });
    });
  },

  resetToken({ commit }) {
    return new Promise(resolve => {
      commit('SET_TOKEN', '');
      commit('SET_ID', null);
      commit('SET_NAME', '');
      commit('SET_SUR_NAME', '');
      commit('SET_PATRONIC_NAME', '');
      commit('SET_EMAIL', '');
      commit('SET_ORGANIZATION', {});
      commit('SET_PROJECTS', []);
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
  getters,
  actions,
};
