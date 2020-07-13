<template>
  <el-menu-item v-if="!item.hidden" :index="index" :route="{ path: basePath }">
    <i class="el-icon-news"></i>
    <span>{{ item.meta.title }}</span>
  </el-menu-item>
</template>

<script>
export default {
  name: 'SidebarItem',
  props: {
    index: {
      type: String,
      default: '',
    },
    item: {
      type: Object,
      required: true,
    },
    basePath: {
      type: String,
      default: '',
    },
  },
};
</script>
