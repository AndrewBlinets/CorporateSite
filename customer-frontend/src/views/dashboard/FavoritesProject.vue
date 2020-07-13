<template>
  <v-card>
    <v-card-title class="title">Избранные проекты</v-card-title>

    <v-card-text>
      <v-row>
        <v-col
          v-for="project in projects"
          :key="project.item"
          xl="3"
          lg="4"
          md="6"
          cols="12"
        >
          <project-card v-bind="project" @toggleFavorites="updateProjects" />
        </v-col>
      </v-row>
    </v-card-text>
  </v-card>
</template>

<script>
import { getFavoritesProjects } from '@/api/project';
import { mapActions } from 'vuex';
import ProjectCard from '@/components/ProjectCard';

export default {
  name: 'FavoritesProject',
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
      this.projects = await getFavoritesProjects();
    },
    updateProjects(project) {
      this.toggleProjectFavorites(project).then(() => {
        this.getProjects();
      });
    },
  },
};
</script>
