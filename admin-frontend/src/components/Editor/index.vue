<template>
  <div class="editor-container">
    <ckeditor
      :value="content"
      @input="$emit('input', $event)"
      :editor="editor"
      :config="editorConfig"
      :disabled="editorDisabled"
    />
  </div>
</template>

<script>
import ClassicEditor from '@ckeditor/ckeditor5-editor-classic/src/classiceditor';
import { EditorConfig } from './editorConfig.js';

export default {
  name: 'Editor',
  props: {
    content: {
      type: String,
      default: ''
    }
  },
  data: () => ({
    editor: ClassicEditor,
    editorConfig: EditorConfig,
    editorDisabled: false
  }),
};
</script>

<style lang="stylus" scoped>
.editor-container
  h2, h3, h4
    margin-bottom: 2rem
  p
    line-height: 1.5rem
    margin-bottom: 1rem
</style>