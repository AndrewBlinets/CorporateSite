<template>
  <v-row class="project-conatainer ma-n3" no-gutters align="stretch">
    <v-col>
      <v-card flat height="100%" width="100%" color="blue lighten-5">
        <header-project></header-project>
        <v-divider></v-divider>
        <news-list></news-list>
      </v-card>
    </v-col>

    <sidebar-right></sidebar-right>
  </v-row>
</template>

<script>
import store from '@/store';
import HeaderProject from './components/HeaderProject';
import NewsList from './components/NewsList/index';
import SidebarRight from './components/SidebarRight/index';

export default {
  name: 'Project',
  components: {
    HeaderProject,
    NewsList,
    SidebarRight,
  },
  beforeRouteEnter(to, from, next) {
    const { id } = to.params;

    if (id) {
      store.dispatch('project/getProject', id).then(() => {
        next();
      });
    }
  },
  beforeRouteUpdate(to, from, next) {
    const { id } = to.params;

    if (id) {
      store.dispatch('project/getProject', id).then(() => {
        next();
      });
    }
  },
};
</script>

<style lang="scss" scoped>
.project-conatainer {
  height: 100%;
}

.project {
  display: flex;
  flex-direction: row;
  height: 100%;
}
</style>
