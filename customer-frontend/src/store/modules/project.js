import {
  getProject,
  addFavoritesProject,
  deleteFavoritesProject,
} from '@/api/project';

const state = {
  project: {
    id: null,
    shortTitle: '',
    favorites: false,
    customers: [],
  },
  rightPanel: true,
};

const mutations = {
  SET_PROJECT: (state, project) => {
    state.project = { ...project };
  },
  SET_RIGHT_PANEL: (state, value) => {
    state.rightPanel = value;
  },
  SET_FILES: (state, files) => {
    state.files = [...files];
  },
};

const getters = {
  countMembers: state =>
    state.project.customers ? state.project.customers.length : 0,
  getFile: state => id => state.files.find(item => item.id === id),
};

const actions = {
  getProject({ commit }, id) {
    return new Promise((resolve, reject) => {
      getProject(id)
        .then(data => {
          commit('SET_PROJECT', data);
          resolve();
        })
        .catch(error => {
          reject(error);
        });
    });
  },

  toggleRightPanel({ state, commit }) {
    commit('SET_RIGHT_PANEL', !state.rightPanel);
  },

  toggleProjectFavorites({ commit }, project) {
    const { id, favorites } = project;
    return new Promise((resolve, reject) => {
      favorites
        ? deleteFavoritesProject(id)
            .then(() => {
              commit('SET_PROJECT', { ...project, favorites: !favorites });
              resolve();
            })
            .catch(error => reject(error))
        : addFavoritesProject({ project: id })
            .then(() => {
              commit('SET_PROJECT', { ...project, favorites: !favorites });
              resolve();
            })
            .catch(error => reject(error));
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
