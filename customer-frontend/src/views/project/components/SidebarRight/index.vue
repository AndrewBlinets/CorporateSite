<template>
  <v-navigation-drawer :value="rightPanel" app clipped right width="380">
    <file-list></file-list>
  </v-navigation-drawer>
</template>

<script>
import { mapState } from 'vuex';
import FileList from '../FilesList/index';

export default {
  name: 'SidebarRight',
  components: {
    FileList,
  },
  computed: {
    ...mapState('project', ['rightPanel']),
  },
};
</script>
