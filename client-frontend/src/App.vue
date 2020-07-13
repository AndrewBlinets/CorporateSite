<template>
  <div id="app" :class="[theme, fontSize]">
    <router-view />
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
  name: 'App',
  computed: {
    ...mapState('app', ['theme', 'fontSize']),
    isMobile() {
      return (
        /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(
          navigator.userAgent,
        ) || window.innerWidth < 1178
      );
    },
  },
  created() {
    this.hasMobileDevice(this.isMobile);
  },
  methods: {
    ...mapActions('app', ['hasMobileDevice']),
  },
};
</script>
