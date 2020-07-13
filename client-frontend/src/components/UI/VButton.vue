<template>
  <button
    :class="[classes]"
    :style="{ color: color, backgroundColor: color }"
    v-bind="$attrs"
    v-on="$listeners"
  >
    <span class="v-btn__content">
      <slot></slot>
    </span>
  </button>
</template>

<script>
export default {
  name: 'VButton',
  props: {
    color: String,
    dark: Boolean,
    fontSize: {
      type: String,
      default: 'default',
    },
    tag: {
      type: String,
      default: 'button',
    },
    text: Boolean,
    to: {
      type: Object,
      default: () => ({}),
    },
  },
  computed: {
    classes() {
      return {
        'v-btn': true,
        [`v-size--${this.fontSize}`]: true,
        'v-btn--contained': this.contained,
        'v-btn--text': this.text,
        'theme--dark': this.dark,
      };
    },
    contained() {
      return !this.isFlat;
    },
    isFlat() {
      return this.text;
    },
  },
};
</script>

<style lang="stylus" scoped>
.v-btn {
  position: relative;
  height: 36px;
  min-width: 36px;
  padding: 0 16px;
  border-radius: 4px;
  border-style: none;
  font-size: 16px;
  text-transform: capitalize;
  cursor: pointer;
  color: inherit;

  &::before {
    position: absolute;
    border-radius: inherit;
    bottom: 0;
    color: inherit;
    content: '';
    left: 0;
    opacity: 0;
    right: 0;
    top: 0;
    transition: opacity 0.2s cubic-bezier(0.4, 0, 0.6, 1);
    background-color: currentColor;
  }

  &:hover::before {
    opacity: 0.08;
  }

  &.v-btn--text {
    background-color: transparent;
  }

  &.v-btn--contained {
    box-shadow: 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);
  }

  &.theme--dark {
    color: #fff;
  }

  .v-btn__content {
    display: flex;
    align-items: center;
    color: inherit;
  }

  &.v-size--default {
    font-size: 1rem;
  }

  &.v-size--medium {
    font-size: 1.125rem;
  }

  &.v-size--large {
    font-size: 1.25rem;
  }
}
</style>
