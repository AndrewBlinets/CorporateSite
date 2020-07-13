<template>
  <v-app-bar color="#fff" elevation="1" app clipped-left clipped-right>
    <v-toolbar-title>ИППС</v-toolbar-title>

    <v-spacer></v-spacer>

    <v-avatar color="#1461ff" class="mr-2">
      <span class="white--text">{{ nameAvatar }}</span>
    </v-avatar>

    <span>{{ shortName }}</span>
  </v-app-bar>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'Navbar',
  computed: {
    ...mapGetters('user', ['shortName', 'nameAvatar']),
  },
};
</script>
