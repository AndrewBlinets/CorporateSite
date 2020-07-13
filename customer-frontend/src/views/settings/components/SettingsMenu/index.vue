<template>
  <v-sheet color="#e3f2fd" class="settings-menu">
    <v-list color="#E3F2FD" width="250px">
      <v-subheader>НАСТРОЙКИ ПОЛЬЗОВАТЕЛЯ</v-subheader>
      <v-list-item-group color="primary">
        <settings-menu-item
          v-for="(item, index) in menu"
          :key="index"
          v-bind="item"
        />
      </v-list-item-group>
    </v-list>
  </v-sheet>
</template>

<script>
import SettingsMenuItem from './SettingsMenuItem';

export default {
  name: 'SettingsMenu',
  components: { SettingsMenuItem },
  data: () => ({
    menu: [
      {
        title: 'Моя учётная запись',
      },
    ],
  }),
};
</script>

<style lang="scss" scoped>
.settings-menu {
  height: 100%;
  display: flex;
  justify-content: flex-end;
}
</style>
