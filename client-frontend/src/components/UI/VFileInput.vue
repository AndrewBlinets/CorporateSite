<template>
  <div class="v-input">
    <div class="v-input__control">
      <div :class="classes" @click="clickInputSlot">
        <div class="v-text-field__slot">
          <div class="v-file-input__text" @click="selectFile">
            <span v-if="!value">{{ fileName }}</span>
            <span v-else class="v-chip">{{ fileName }}</span>
          </div>
          <input
            ref="input"
            type="file"
            @input="onInput"
            @change="onInput"
            @focus="hasFocus = true"
            @blur="hasFocus = false"
          />
        </div>

        <div class="v-input__append-inner">
          <button v-if="value" class="clear-icon" @click="clearInput">
            <font-awesome-icon :icon="clearIcon" />
          </button>
        </div>
      </div>

      <transition name="slide-fade">
        <div v-if="hasErrors" class="v-text-field__details">
          <div :class="classesMessages">
            <div class="v-messages__wraper">
              <div class="v-messages__message">{{ lastMessageError }}</div>
            </div>
          </div>
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
import { faTimes } from '@fortawesome/free-solid-svg-icons';

export default {
  name: 'VFileInput',
  props: {
    value: {
      type: File,
      default: undefined,
    },
    ['error-messages']: {
      type: Array,
      default: () => [],
    },
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
    classesMessages() {
      return {
        'v-messages': true,
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
    fileName() {
      if (this.value) {
        return this.value.name;
      }

      return 'Выберите файл';
    },
    clearIcon() {
      return faTimes;
    },
  },
  methods: {
    clickInputSlot() {
      this.$refs.input.focus();
    },
    onInput(event) {
      const target = event.target;
      this.badInput = target.validity && target.validity.badInput;

      this.$emit('input', target.files[0] ? target.files[0] : null);
    },
    selectFile() {
      this.$refs.input.click();
    },
    clearInput() {
      this.$emit('input', null);
    },
  },
};
</script>

<style lang="stylus" scoped>
.v-input {
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
        position: relative;
        display: flex;
        align-items: center;
        align-self: stretch;
        flex: 1 1 auto;
        padding: 6px 0;
        min-height: 32px;

        .v-file-input__text {
          display: flex;
          align-items: center;
          align-self: stretch;
          width: 100%;

          .v-chip {
            display: inline-flex;
            align-items: center;
            line-height: 20px;
            padding: 0 12px;
            white-space: nowrap;
            margin: 4px;
            font-size: 12px;
            height: 24px;
            border-radius: 4px;
            themify(
              $themes,
              @($theme) {
              color: $theme.$button--color;
              background-color: $theme.$secondary--dark--color;
            }
            );
          }
        }
      }

      .v-input__append-inner {
        margin-left: auto;
        padding-left: 4px;

        .clear-icon {
          height: 24px;
          width: 24px;
          cursor: pointer;
          border-style: none;
          background-color: transparent;
          font-size: 18px;
          display: flex;
          justify-content: center;
          align-items: center;
          themify(
            $themes,
            @($theme) {
            color: $theme.$third--light--color;
          }
          );
        }
      }
    }

    .v-text-field__details {
      max-width: 100%;
      min-height: 14px;
      overflow: hidden;
      margin-top: 8px;

      .v-messages {
        position: relative;
        min-height: 14px;
        font-size: 12px;
        font-family: Roboto, sans-serif;

        &.text--error {
          color: #ff5252;
        }

        .v-messages__message {
          line-height: 12px;
          word-break: break-word;
          word-wrap: break-word;
        }
      }
    }
  }

  input[type='file'] {
    position: absolute;
    opacity: 0;
    max-width: 0;
    width: 0;
    left: 0;
    max-height: 32px;
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
