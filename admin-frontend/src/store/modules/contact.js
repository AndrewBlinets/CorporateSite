import {
  getContactsList,
  getContact,
  createContact,
  updateContact,
  deleteContact
} from '@/api/contact';

const state = {
  contactsList: [],
  contact: {}
};

const mutations = {
  SET_CONTACTS_LIST: (state, list) => {
    state.ContactsList = list;
  },
  SET_CONTACT: (state, Contact) => {
    state.Contact = Contact;
  }
};

const getters = {};

const actions = {
  getContactsList({ commit }) {
    return new Promise((resolve) => {
      getContactsList().then(data => {
        commit('SET_CONTACTS_LIST', data);
        resolve();
      });
    });
  },
  getContactById({ commit }, id) {
    return new Promise((resolve) => {
      getContact(id).then(data => {
        commit('SET_CONTACTt', data);
        resolve();
      });
    });
  },
  createContact() {
    return new Promise((resolve) => {
      createContact().then(() => {
        resolve();
      });
    });
  },
  updateContact() {
    return new Promise((resolve) => {
      updateContact().then(() => {
        resolve();
      });
    });
  },
  deleteContactById(id) {
    return new Promise((resolve) => {
      deleteContact(id).then(() => {
        resolve();
      });
    });
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  getters,
  actions,
};
