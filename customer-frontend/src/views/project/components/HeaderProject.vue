<template>
  <v-toolbar flat>
    <v-btn icon @click="toProject">
      <v-icon>mdi-arrow-left</v-icon>
    </v-btn>

    <v-toolbar-title>
      <h2 class="title">{{ project.title }}</h2>
      <h3 class="caption">{{ countMembers }} участников</h3>
    </v-toolbar-title>

    <v-spacer></v-spacer>

    <v-btn icon @click="toggleFavorites">
      <v-icon v-if="project.favorites" color="yellow">mdi-star</v-icon>
      <v-icon v-else>mdi-star-outline</v-icon>
    </v-btn>

    <v-btn :color="colorButtonRightPanel" icon @click="toggleRightPanel">
      <v-icon>mdi-view-split-vertical</v-icon>
    </v-btn>

    <v-btn v-if="false" icon>
      <v-icon>mdi-dots-vertical</v-icon>
    </v-btn>
  </v-toolbar>
</template>

<script>
import { mapState, mapGetters, mapActions } from 'vuex';

export default {
  name: 'HeaderProject',
  computed: {
    ...mapState('project', ['project', 'rightPanel']),
    ...mapGetters('project', ['countMembers']),
    colorButtonRightPanel() {
      return this.rightPanel ? 'primary' : '';
    },
  },
  methods: {
    ...mapActions('project', ['toggleRightPanel', 'toggleProjectFavorites']),
    toProject() {
      this.$router.push({ name: 'projects' });
    },
    toggleFavorites() {
      this.toggleProjectFavorites(this.project);
    },
  },
};
</script>
