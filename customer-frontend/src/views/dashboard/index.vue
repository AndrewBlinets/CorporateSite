<template>
  <v-row>
    <v-col cols="12">
      <favorites-project></favorites-project>
    </v-col>
  </v-row>
</template>

<script>
import FavoritesProject from './FavoritesProject';

export default {
  name: 'Dashboard',
  components: {
    FavoritesProject,
  },
};
</script>
