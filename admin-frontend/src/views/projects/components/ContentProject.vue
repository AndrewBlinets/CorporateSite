<template>
  <div class="row-content">
    <el-form-item label="Заголовок">
      <el-input :value="title" @input="inputArticle('title', $event)" />
    </el-form-item>

    <el-form-item label="Краткий заголовок">
      <el-input
        :value="shortTitle"
        @input="inputArticle('shortTitle', $event)"
      />
    </el-form-item>

    <el-form-item label="Содержание">
      <editor :content="content" @input="inputArticle('content', $event)" />
    </el-form-item>
  </div>
</template>

<script>
import Editor from '@/components/Editor';

export default {
  name: 'ContentProject',
  components: {
    Editor,
  },
  props: {
    codeLanguage: {
      type: String,
      default: '',
    },
    title: {
      type: String,
      default: '',
    },
    shortTitle: {
      type: String,
      default: '',
    },
    content: {
      type: String,
      default: '',
    },
  },
  methods: {
    inputArticle(fieldName, value) {
      this.$emit('input', {
        codeLanguage: this.codeLanguage,
        field: {
          name: fieldName,
          value: value,
        },
      });
    },
  },
};
</script>

<style lang="stylus" scoped>
.row-content {
  margin-left: -16px;
}
</style>
