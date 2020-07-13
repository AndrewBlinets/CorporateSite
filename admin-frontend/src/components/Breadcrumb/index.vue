<template>
  <el-breadcrumb separator="/">
  </el-breadcrumb>
</template>

<script>
export default {
  name: 'Breadcrumb',
  watch: {
    $route(route) {
      // eslint-disable-next-line no-console
      console.log(route, this.$route);
    }
  }
};
</script>