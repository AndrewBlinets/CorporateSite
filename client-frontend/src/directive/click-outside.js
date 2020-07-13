import Vue from 'vue';

export const ClickOutside = {
  bind: function(el, binding, vnode) {
    el.event = event => {
      event.stopPropagation();

      if (!(el == event.target || el.contains(event.target))) {
        vnode.context[binding.expression](event);
      }
    };

    document.addEventListener('click', el.event);
    document.addEventListener('touchstart', el.event);
  },
  unbind: function(el) {
    document.removeEventListener('click', el.event);
    document.removeEventListener('touchstart', el.event);
  },
};

Vue.directive('click-outside', ClickOutside);
