<template>
  <div>
    <h2>Проекты</h2>
    <v-row>
      <v-col
        v-for="project in projects"
        :key="project.id"
        xl="3"
        lg="4"
        md="6"
        cols="12"
      >
        <project-card v-bind="project" @toggleFavorites="updateProjects" />
      </v-col>
    </v-row>
  </div>
</template>

<script>
import { getProjectsAll } from '@/api/project';
import { mapActions } from 'vuex';
import ProjectCard from '@/components/ProjectCard';

export default {
  name: 'Projects',
  components: {
    ProjectCard,
  },
  data: () => ({
    projects: [],
  }),
  mounted() {
    this.getProjects();
  },
  methods: {
    ...mapActions('project', ['toggleProjectFavorites', 'updateFieldProject']),
    async getProjects() {
      this.projects = await getProjectsAll();
    },
    updateProjects(project) {
      this.toggleProjectFavorites(project).then(() => {
        this.getProjects();
      });
    },
  },
};
</script>
