<template>
  <v-list-item>
    <v-list-item-content>
      <v-list-item-title>{{ title }}</v-list-item-title>
    </v-list-item-content>
  </v-list-item>
</template>

<script>
export default {
  name: 'SettingsMenuItem',
  props: {
    title: String,
  },
};
</script>
