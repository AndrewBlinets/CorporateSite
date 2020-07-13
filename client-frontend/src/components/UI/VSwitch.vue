<template>
  <div class="switch-control" :class="{ 'switch-on': switchValue }">
    <input v-model="switchValue" type="checkbox" />
    <div class="switch__track"></div>
    <div class="switch__thumb"></div>
  </div>
</template>

<script>
export default {
  name: 'VSwitch',
  props: {
    value: {
      type: Boolean,
      default: false,
    },
  },
  computed: {
    switchValue: {
      get: function() {
        return this.value;
      },
      set: function(value) {
        this.$emit('input', value);
      },
    },
  },
};
</script>

<style lang="stylus" scoped>
.switch-control {
  position: relative;
  height: 24px;
  width: 38px;
  color: inherit;
  transition: 0.3s cubic-bezier(0.25, 0.8, 0.5, 1);

  input {
    position: relative;
    width: 100%;
    height: 100%;
    cursor: pointer;
    opacity: 0;
    z-index: 1;
  }

  .switch__track {
    position: absolute;
    border-radius: 8px;
    width: 34px;
    height: 14px;
    left: 2px;
    opacity: 0.6;
    right: 2px;
    top: calc(50% - 7px);
    color: rgba(0, 0, 0, 0.38);
    transition: 0.3s cubic-bezier(0.25, 0.8, 0.5, 1);
  }

  .switch__thumb {
    position: absolute;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
    top: calc(50% - 10px);
    height: 20px;
    width: 20px;
    color: #ffffff;
    transition: 0.3s cubic-bezier(0.25, 0.8, 0.5, 1);
    box-shadow: 0 2px 4px -1px rgba(0, 0, 0, 0.2), 0 4px 5px 0 rgba(0, 0, 0, 0.14), 0 1px 10px 0 rgba(0, 0, 0, 0.12);
  }

  .switch__track, .switch__thumb {
    background-color: currentColor;
  }

  &.switch-on {
    .switch__thumb {
      transform: translate(20px);
    }

    .switch__track, .switch__thumb {
      color: #1461ff;
    }
  }
}
</style>
