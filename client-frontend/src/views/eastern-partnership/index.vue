<template>
  <div>
    <header-page :image="19">
      <h1>{{ page.name }}</h1>
    </header-page>
    <div class="body-page">
      <section-component
        v-for="section in page.sections"
        :key="section.id"
        :page="page.id"
        :section="section"
      />
    </div>
  </div>
</template>

<script>
import store from '@/store';
import { mapState } from 'vuex';
import HeaderPage from '@/components/HeaderPage';
import SectionComponent from '@/components/Section';

export default {
  name: 'EasternPartnership',
  components: {
    HeaderPage,
    SectionComponent,
  },
  computed: {
    ...mapState({
      page: state => state.page.page,
      locale: state => state.app.locale,
    }),
  },
  watch: {
    locale() {
      store.dispatch('page/getPage', 2);
    },
  },
  beforeRouteEnter(to, from, next) {
    store.dispatch('page/getPage', 2).then(() => {
      next();
    });
  },
};
</script>
