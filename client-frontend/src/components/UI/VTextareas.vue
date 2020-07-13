<template>
  <div class="v-textarea">
    <div class="v-input__control">
      <div :class="classes" @click="clickInputSlot">
        <div class="v-text-field__slot">
          <textarea
            ref="textarea"
            :value="value"
            @input="onInput"
            @focus="hasFocus = true"
            @blur="hasFocus = false"
          />
        </div>
      </div>

      <transition name="slide-fade">
        <div v-if="hasErrors || counter" :class="classesDetails">
          <div class="v-messages">
            <div class="v-messages__wraper">
              <div class="v-messages__message">{{ lastMessageError }}</div>
            </div>
          </div>
          <div class="v-counter">{{ valueLength }}</div>
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
export default {
  name: 'VTextareas',
  props: {
    value: String,
    ['error-messages']: {
      type: Array,
      default: () => [],
    },
    counter: Boolean,
  },
  data: () => ({
    hasFocus: false,
    badInput: false,
  }),
  computed: {
    classes() {
      return {
        'v-input__slot': true,
        'v-input__active': this.active,
        'v-input__errors': this.hasErrors,
      };
    },
    classesDetails() {
      return {
        'v-text-field__details': true,
        'text--error': this.hasErrors,
      };
    },
    active() {
      return this.hasFocus && !this.hasErrors;
    },
    hasErrors() {
      return Boolean(this.errorMessages.length);
    },
    lastMessageError() {
      return this.errorMessages[this.errorMessages.length - 1];
    },
    valueLength() {
      return this.counter && this.value.length;
    },
  },
  methods: {
    clickInputSlot() {
      this.$refs.textarea.focus();
    },
    onInput(event) {
      const target = event.target;
      this.badInput = target.validity && target.validity.badInput;
      this.$emit('input', target.value);
    },
  },
};
</script>

<style lang="stylus" scoped>
.v-textarea {
  border-radius: 4px;

  .v-input__control {
    border-radius: inherit;

    &:hover .v-input__slot {
      border-color: currentcolor;
    }

    .v-input__slot {
      position: relative;
      display: flex;
      align-items: center;
      min-height: 56px;
      width: 100%;
      padding: 0 12px;
      background: transparent;
      cursor: text;
      border-radius: inherit;
      transition: border 0.3s cubic-bezier(0.25, 0.8, 0.5, 1);
      themify(
        $themes,
        @($theme) {
        border: 1px solid $theme.$third--light--color;
      }
      );

      &.v-input__active {
        border-width: 2px;
        themify(
          $themes,
          @($theme) {
          border-color: $theme.$secondary--dark--color;
        }
        );
      }

      &.v-input__errors {
        border-width: 2px;
        border-color: #ff5252;
        caret-color: #ff5252;
      }

      .v-text-field__slot {
        display: flex;
        flex: 1 1 auto;
        align-self: stretch;
        margin-right: -12px;
      }
    }

    .v-text-field__details {
      display: flex;
      flex: 1 0 auto;
      max-width: 100%;
      min-height: 14px;
      overflow: hidden;
      margin-top: 8px;

      &.text--error {
        color: #ff5252;
      }

      .v-messages {
        position: relative;
        flex: 1 1 auto;
        min-height: 14px;
        font-size: 12px;
        font-family: Roboto, sans-serif;

        .v-messages__message {
          line-height: 12px;
          word-break: break-word;
          word-wrap: break-word;
        }
      }

      .v-counter {
        color: inherit;
        margin-left: 8px;
        flex: 0 1 auto;
        font-size: 12px;
        min-height: 12px;
        line-height: 12px;
      }
    }
  }

  textarea {
    min-height: 44px;
    height: 140px;
    max-width: 100%;
    line-height: 1.75rem;
    width: 100%;
    background: transparent;
    border-style: none;
    font: inherit;
    color: inherit;
    caret-color: inherit;
    overflow: auto;
    resize: vertical;
    margin-top: 10px;
    padding-right: 12px;
  }
}

.slide-fade-enter-active, .slide-fade-leave-active {
  transition: all 0.3s cubic-bezier(0.694, 0, 0.335, 1);
}

.slide-fade-enter, .slide-fade-leave-to {
  transform: translateY(-4px);
  opacity: 0;
}
</style>
