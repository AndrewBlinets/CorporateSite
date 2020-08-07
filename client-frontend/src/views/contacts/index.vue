<template>
  <div>
    <header-page :image="page.imageId">
      <h1>{{ $t('views.contacts.title') }}</h1>
    </header-page>
    <div class="body-page">
      <div class="app-container">
        <category-contacts
          v-for="contact in contactsList"
          :key="contact.id"
          v-bind="contact"
        />
      </div>
    </div>
  </div>
</template>

<script>
import { getContacts } from '@/api/contacts';

import { mapState } from 'vuex';

import HeaderPage from '@/components/HeaderPage';
import CategoryContacts from './CategoryContacts';

export default {
  name: 'Contacts',
  components: {
    HeaderPage,
    CategoryContacts,
  },
  data: () => ({
    page: {
      name: 'Контакты',
      imageId: 22,
    },
    contactsList: [],
  }),
  computed: {
    ...mapState('app', ['locale']),
  },
  watch: {
    locale() {
      getContacts().then(contactsList => this.setData(contactsList));
    },
  },
  beforeRouteEnter(to, from, next) {
    getContacts().then(contactsList => {
      next(vm => vm.setData(contactsList));
    });
  },
  methods: {
    setData(contactsList) {
      this.contactsList = [...contactsList];
    },
  },
};
</script>

<style lang="stylus" scoped>
.body-page {
  margin-top: 50px;
  margin-bottom: 50px;
}
</style>
