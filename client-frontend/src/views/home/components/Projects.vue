<template>
  <section id="projects" class="bgr-grey">
    <div class="grid-area">
      <div class="section-header">
        <div class="app-container">
          <h2>{{ $t('views.home.projects.title') }}</h2>
        </div>
      </div>
      <div class="section-body">
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
            <div class="button-item">
              <router-link :to="{ name: 'projects' }" class="btn btn-main">
                {{ $t('views.home.projects.allProjects') }}
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapState, mapActions } from 'vuex';
import ProjectCard from '@/components/ProjectCard';

export default {
  name: 'Projects',
  components: {
    ProjectCard,
  },
  data: () => ({
    params: { size: 3, page: 0 },
  }),
  computed: {
    ...mapState({
      locale: state => state.app.locale,
      projects: state => state.project.projectsList,
    }),
  },
  watch: {
    locale() {
      this.getProjects(this.params);
    },
  },
  mounted() {
    this.getProjects(this.params);
  },
  methods: {
    ...mapActions('project', ['getProjects']),
  },
};
</script>

<style lang="stylus" scoped>
.projects-container {
  margin-bottom: 3rem;
}
</style>
