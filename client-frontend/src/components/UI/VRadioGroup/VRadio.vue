<template>
  <div class="v-radio" @click="onClick">
    <div
      class="v-input--section-controls__input"
      :class="{ 'v-radio__active': value === computedValue }"
    >
      <input
        :id="computedId"
        :value="value"
        :name="computedName"
        type="radio"
      />
    </div>
    <label :for="computedId" class="v-label">{{ label }}</label>
  </div>
</template>

<script>
export default {
  name: 'VRadio',
  inject: ['_radioGroup', '_value'],
  props: {
    label: {
      type: String,
    },
    value: {
      default: null,
    },
  },
  computed: {
    computedId() {
      return `input-${Math.ceil(Math.random() * 1000)}`;
    },
    computedName() {
      return this._radioGroup();
    },
    computedValue() {
      return this._value();
    },
  },
  methods: {
    onClick() {
      this.$parent.$emit('input', this.value);
    },
  },
};
</script>

<style lang="stylus" scoped>
.v-radio {
  display: flex;
  align-items: center;
  margin-bottom: 8px;
  cursor: pointer;

  .v-input--section-controls__input {
    position: relative;
    height: 24px;
    width: 24px;
    margin-right: 8px;

    &::after, &::before {
      content: '';
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      border-radius: 50%;
    }

    &::after {
      width: 20px;
      height: 20px;
      background-color: transparent;
      border-width: 2px;
      border-style: solid;
      themify(
        $themes,
        @($theme) {
        border-color: $theme.$third--light--color;
      }
      );
    }

    &.v-radio__active::after {
      themify(
        $themes,
        @($theme) {
        border-color: $theme.$secondary--dark--color;
      }
      );
    }

    &::before {
      display: none;
      width: 10px;
      height: 10px;
      themify(
        $themes,
        @($theme) {
        background-color: $theme.$secondary--dark--color;
      }
      );
    }

    &.v-radio__active::before {
      display: block;
    }

    input {
      position: absolute;
      cursor: pointer;
      width: 100%;
      height: 100%;
      opacity: 0;
    }
  }

  .v-label {
    line-height: 20px;
    width: 100%;
    cursor: pointer;
  }
}
</style>
