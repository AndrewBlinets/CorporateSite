<template>
  <v-list-item :to="to">
    <v-list-item-icon>
      <v-icon>{{ icon }}</v-icon>
    </v-list-item-icon>
    <v-list-item-content>
      <v-list-item-title>{{ title }}</v-list-item-title>
    </v-list-item-content>
  </v-list-item>
</template>

<script>
export default {
  name: 'SidebarItem',
  props: {
    icon: String,
    title: String,
    to: Object,
  },
};
</script>
