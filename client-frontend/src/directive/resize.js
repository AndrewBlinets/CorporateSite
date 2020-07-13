import Vue from 'vue';

export const Resize = {
  inserted(el, binding) {
    const f = evt => {
      if (binding.value(evt, el)) {
        window.removeEventListener('resize', f);
      }
    };
    window.addEventListener('resize', f);
  },
};

Vue.directive('resize', Resize);
