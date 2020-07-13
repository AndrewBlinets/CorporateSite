<template>
  <div>
    <header-page :image="page.imageId">
      <h1>{{ page.name }}</h1>
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
  beforeRouteEnter(to, from, next) {
    getContacts().then(contactsList => {
      next(vm => vm.setData(contactsList));
      next();
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
