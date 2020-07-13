import Vue from 'vue';

export const Scroll = {
  inserted(el, binding) {
    const f = evt => {
      if (binding.value(evt, el)) {
        window.removeEventListener('scroll', f);
      }
    };
    window.addEventListener('scroll', f);
  },
};

Vue.directive('scroll', Scroll);
