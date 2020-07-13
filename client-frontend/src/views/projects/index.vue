<template>
  <div>
    <header-page :image="imagePageId">
      <h1>Проекты</h1>
    </header-page>
    <div class="body-page">
      <div class="app-container">
        <div class="row mx-md-n4">
          <div
            v-for="item in projects"
            :key="item.id"
            class="col-lg-4 col-sm-6 px-md-4 mb-5"
          >
            <project-card
              :id="item.id"
              :title="item.shortTitle"
              :image="item.mainImage"
            />
          </div>
        </div>

        <div class="button-container">
          <div v-if="!hasProjectsFull" class="button-item">
            <div class="btn btn-main" @click="loadMore">
              Загрузить ещё
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import store from '@/store';
import { mapState, mapGetters } from 'vuex';
import HeaderPage from '@/components/HeaderPage';
import ProjectCard from '@/components/ProjectCard';

export default {
  name: 'Projects',
  components: {
    HeaderPage,
    ProjectCard,
  },
  data: () => ({
    titlePage: 'Проекты',
    imagePageId: 17,
  }),
  computed: {
    ...mapState({
      projects: state => state.project.projectsList,
      hasProjectsFull: state => state.project.hasProjectsFull,
    }),
    ...mapGetters({
      page: 'project/page',
    }),
  },
  beforeRouteEnter(to, from, next) {
    store.dispatch('project/getProjects', { size: 9, page: 0 }).then(() => {
      next();
    });
  },
  destroyed() {
    store.dispatch('project/resetProjects');
  },
  methods: {
    loadMore() {
      store.dispatch('project/getProjects', { page: this.page + 1 });
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
