<template>
  <div class="layout">
    <div class="sidebar">
      <sidebar />
    </div>
    <main>
      <navbar />
      <app-main />
    </main>
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
    Sidebar
  }
};
</script>
