import Vue from 'vue';

Vue.component('auth-redirect', {
  created() {
    const hash = window.location.search.slice(1);

    if (window.localStorage) {
      window.localStorage.setItem('x-ipps-oauth-code', hash);
      window.close();
    }
  },
  render: function(h) {
    return h();
  },
});
