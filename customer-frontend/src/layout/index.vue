<template>
  <div class="layout">
    <sidebar></sidebar>
    <navbar></navbar>

    <app-main></app-main>
  </div>
</template>

<script>
import AppMain from './components/AppMain';
import Navbar from './components/Navbar';
import Sidebar from './components/Sidebar/index';

export default {
  name: 'Layout',
  components: {
    AppMain,
    Navbar,
    Sidebar,
  },
};
</script>

<style lang="scss" scoped>
.layout {
  width: 100%;
  height: 100%;
}
</style>
