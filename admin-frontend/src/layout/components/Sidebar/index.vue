<template>
  <el-menu
    background-color="#304156"
    text-color="#bfcbd9"
    mode="vertical"
    router
  >
    <sidebar-item
      v-for="(route, index) in permissionRoutes"
      :key="route.path"
      :index="`${index}`"
      :item="route"
      :base-path="route.path"
    />
  </el-menu>
</template>

<script>
import { mapGetters } from 'vuex';
import SidebarItem from './SidebarItem';

export default {
  name: 'Sidebar',
  components: {
    SidebarItem,
  },
  computed: {
    ...mapGetters(['permissionRoutes']),
  },
};
</script>

<style lang="stylus" scoped>
.el-menu {
  height: 100%;
}

.icon {
  margin-right: 5px;
  width: 24px;
  text-align: center;
  font-size: 18px;
  vertical-align: middle;
  color: #909399;
}

.link-menu {
  color: rgb(191, 203, 217);
}
</style>
