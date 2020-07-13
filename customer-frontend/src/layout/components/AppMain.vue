<template>
  <v-content>
    <v-container class="main-container" fluid>
      <router-view></router-view>
    </v-container>
  </v-content>
</template>

<script>
export default {
  name: 'AppMain',
};
</script>

<style lang="scss" scoped>
.main-container {
  height: 100%;
}
</style>
