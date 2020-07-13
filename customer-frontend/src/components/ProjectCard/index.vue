<template>
  <v-card class="project-card" color="primary" height="200" dark>
    <v-card-title class="title">{{ title }}</v-card-title>

    <v-card-actions class="action-container">
      <v-btn text :to="{ name: 'project-id', params: { id } }">
        Посмотреть
      </v-btn>
      <v-btn icon @click="$emit('toggleFavorites', { id, favorites })">
        <v-icon v-if="favorites" color="yellow">mdi-star</v-icon>
        <v-icon v-else>mdi-star-outline</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: 'ProjectCard',
  props: {
    id: Number,
    title: {
      type: String,
      default: 'Test',
    },
    favorites: {
      type: Boolean,
      default: true,
    },
  },
};
</script>

<style lang="scss" scoped>
.project-card {
  display: flex;
  flex-direction: column;
  justify-content: space-between;

  .action-container {
    display: flex;
    justify-content: space-between;
  }
}
</style>
