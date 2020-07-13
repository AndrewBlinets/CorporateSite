<template>
  <v-navigation-drawer app clipped permanent>
    <v-list nav>
      <v-list-item-group color="primary">
        <sidebar-item
          v-for="(item, index) in menu"
          :key="index"
          v-bind="item"
        />

        <v-list-item color="#F44336" @click="logout">
          <v-list-item-icon>
            <v-icon>mdi-logout</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Выход</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import SidebarItem from './SidebarItem';

export default {
  name: 'Sidebar',
  components: { SidebarItem },
  computed: {
    menu() {
      return [
        {
          icon: 'mdi-view-dashboard',
          title: 'Dashboard',
          to: { name: 'dashboard' },
        },
        {
          icon: 'mdi-folder',
          title: 'Проекты',
          to: { name: 'projects' },
        },
        {
          icon: 'mdi-cogs',
          title: 'Настройки',
          to: { name: 'settings' },
        },
      ];
    },
  },
  methods: {
    logout() {
      this.$store.dispatch('user/logout').then(() => {
        this.$router.push(`/login?redirect=${this.$route.fullPath}`);
      });
    },
  },
};
</script>
