<template>
  <el-tabs type="border-card">
    <el-tab-pane
      v-for="version in languageVersions"
      :label="mapLanguage.get(version.codeLanguage)"
      :key="version.codeLanguage"
    >
      <slot name="language-version" :version="version"/>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
export default {
  name: 'LanguageTabs',
  props: {
    languageVersions: {
      type: Array,
      default: function() {
        return [];
      }
    }
  },
  data: () => ({
    mapLanguage: new Map([
      ['ru', 'Русский'],
      ['by', 'Беларускі'],
      ['en', 'English']
    ])
  }),
  methods: {
    inputContentLangueage(value) {
      const keys = Object.keys(value);
      this.languageVersions
        .filter(item => item.codeLanguage === value[keys[0]])[0][keys[1]] = value[keys[1]];
      
      return this.languageVersions;
    }
  }
};
</script>

<style lang="stylus" scoped>
.el-tabs
  margin-bottom: 22px
  >.el-tabs__content
    padding-left: 0
</style>