import { getFile, uploadFile } from '@/api/file';

const state = {
  fileId: null
};

const mutations = {
  SET_FILE_ID: (state, id) => {
    state.fileId = id;
  }
};

const getters = {
  urlFile: state => state.fileId ? getFile(state.fileId) : '',
  fileObject: state => {
    if (state.fileId) {
      return [{
        name: state.fileId,
        url: getFile(state.fileId)
      }];
    } else {
      return [];
    }
  }
};

const actions = {
  uploadFileServer({ commit }, file) {
    let formData = new FormData();
    formData.append('file', file);
    return new Promise(resolve => {
      uploadFile(formData).then(data => {
        commit('SET_FILE_ID', data);
        resolve(data);
      });
    });
  },
  resetFile({ commit }) {
    commit('SET_FILE_ID', null);
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  getters,
  actions
};