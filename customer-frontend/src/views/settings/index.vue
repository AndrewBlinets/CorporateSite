<template>
  <v-row class="settings-container ma-n3" align="stretch" no-gutters>
    <v-col cols="3">
      <settings-menu></settings-menu>
    </v-col>
    <v-col cols="7" class="pa-10">
      <account></account>
    </v-col>
  </v-row>
</template>

<script>
import Account from './components/Account/index';
import SettingsMenu from './components/SettingsMenu';

export default {
  name: 'Settings',
  components: {
    Account,
    SettingsMenu,
  },
};
</script>

<style lang="scss" scoped>
.settings-container {
  height: 100%;
}
</style>
