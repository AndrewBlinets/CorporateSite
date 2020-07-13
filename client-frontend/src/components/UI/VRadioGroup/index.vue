<template>
  <div class="v-radiogroup" @input="onInput">
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: 'VRadioGroup',
  props: {
    value: {
      default: null,
    },
  },
  provide() {
    return {
      _radioGroup: () => `radiogroup-${Math.ceil(Math.random() * 1000)}`,
      _value: () => this.value,
    };
  },
  methods: {
    onInput(event) {
      const value = event.target.value;
      this.$emit('input', value);
    },
  },
};
</script>

<style lang="stylus" scoped>
.v-radiogroup {
  display: flex;
  flex-direction: column;
}
</style>
