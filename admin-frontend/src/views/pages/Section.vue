<template>
  <div class="page-container">
    <div class="title">
      <el-row type="flex" justify="space-between">
        <el-col :span="12">
          <h1>Секция</h1>
        </el-col>
        <el-col
          v-if="section.status"
          :span="6"
          class="status"
        >
          <span :class="statusClassName(section.status)">{{ section.status | pluralizationStatus }}</span>
        </el-col>
      </el-row>
    </div>
    
    <el-select
      v-model="form.type"
      clearable
      placeholder="Выбрать секцию"
      class="mb-2"
    >
      <el-option
        v-for="item in typeOptions"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      />
    </el-select>

    <language-tabs :languageVersions="form.languageVersions" >
      <template v-slot:language-version="{ version }">
        <el-row class="mb-2">

          <el-col :span="24" class="mb-1">
            <h3>Название</h3>
          </el-col>
          <el-col :span="12" class="mb-2">
            <el-input v-model="version.name"></el-input>
          </el-col>

          <el-col
            v-if="form.type === 1"
            :span="24"
          >
            <el-row>
              <el-col :span="24" class="mb-1">
                <h3>Блоки</h3>
              </el-col>
              <el-col v-if="hasAddBlock" :span="24" class="mb-2">
                <el-button
                  type="success"
                  plain
                  @click="addBlock"
                >+ Добавить Блок</el-button>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col
                v-for="(block, index) in version.blocks"
                :key="block.id"
                :span="spanCol"
                class=""
              >
                <el-button
                  v-if="indexBlock !== 2"
                  type="danger"
                  size="mini"
                  plain
                  class="mb-1"
                  @click="removeBlock(index)"
                >Удалить</el-button>
                <editor
                  :content="block.content"
                  @input="setLanguageVersion($event, index, version.codeLanguage)"
                />
              </el-col>
            </el-row>
          </el-col>

          <el-col
            v-if="form.type === 2 && form.id"
            :span="24"
          >
            <el-button
              type="primary"
              @click="$router.push({ name: 'news' })"
              >Создать новость</el-button>
          </el-col>

        </el-row>
      </template>
    </language-tabs>

    <el-row type="flex" justify="space-between">
      <el-col :span="12" >
        <el-button
          type="success"
          @click="saveSection(1)"
        >Опубликовать</el-button>
        <el-button
          type="warning"
          plain
          @click="saveSection(3)"
        >Сохранить как черновик</el-button>
        <el-button
          v-if="section.id"
          type="danger"
          plain
          @click="deleteSection"
        >Удалить</el-button>
      </el-col>
      <el-col :span="3" align="right">
        <el-button
          type="primary"
          @click="$router.go(-1)"
        >Отмена</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import store from '@/store';
import { mapState, mapActions } from 'vuex';
import LanguageTabs from '@/components/LanguageTabs';
import Editor from '@/components/Editor';

export default {
  name: 'Section',
  components: {
    LanguageTabs,
    Editor
  },
  data: () => ({
    form: {
      languageVersions: [
        {
          codeLanguage: 'ru',
          name: '',
          blocks: [
            {
              content: '',
              index: 1
            }
          ]
        },
        {
          codeLanguage: 'by',
          name: '',
          blocks: [
            {
              content: '',
              index: 1
            }
          ]
        },
        {
          codeLanguage: 'en',
          name: '',
          blocks: [
            {
              content: '',
              index: 1
            }
          ]
        }
      ]
    },
    typeOptions: [
      {
        value: 1,
        label: 'Текст'
      },
      {
        value: 2,
        label: 'Новости'
      },
      {
        value: 3,
        label: 'Ижображения'
      }
    ],
  }),
  computed: {
    ...mapState({
      section: state => state.section.section,
      pageId: state => state.section.pageId
    }),
    spanCol() {
      return 24 / this.form.languageVersions[0].blocks.length;
    },
    hasAddBlock() {
      return this.form.languageVersions[0].blocks.length < 3;
    },
    indexBlock() {
      return this.form.languageVersions[0].blocks.length + 1;
    }
  },
  beforeRouteEnter (to, from, next) {
    const { id, sectionId } = to.params;

    if (sectionId) {
      store.dispatch('section/getSection', sectionId).then(() => {
        next();
      });
    } else {
      store.commit('section/SET_PAGE_ID', id);
      next();
    }
  },
  beforeRouteUpdate (to, from, next) {
    // eslint-disable-next-line no-console
    console.log('beforeRouteUpdate');
    const { sectionId } = to.params;

    if (sectionId) {
      store.dispatch('section/getSection', sectionId).then(() => {
        next();
      });
    } else {
      this.resetSection().then(() => {
        next();
      });
    }
  },
  beforeRouteLeave (to, from, next) {
    this.resetSection().then(() => {
      next();
    });
  },
  created() {
    if (Object.keys(this.section).length !== 0) {
      Object.assign(this.form, this.section);
    }
  },
  destroy() {
    this.resetSection();
  },
  methods: {
    ...mapActions({
      createSection: 'section/createSection',
      updateSection: 'section/updateSection',
      deleleSection: 'section/deleteSection',
      resetSection: 'section/resetSection'
    }),
    saveSection(status) {
      if (this.section.id) {
        this.updateSection({ ...this.form, status }).then(() => {
          this.$message({
            type: 'success',
            message: 'Секция обновлена'
          });
        });
      } else {
        this.createSection({ ...this.form, status, page: this.pageId }).then((id) => {
          this.$message({
            type: 'success',
            message: 'Секция сохранена'
          });
          this.$router.push({ name: 'section-id', params: { sectionId: id } });
        });
      }
    },
    deleteSection() {
      this.$confirm('Вы точно хотите удалить?', {
          confirmButtonText: 'Подтвердить',
          cancelButtonText: 'Отменить',
          type: 'warning'
        }).then(() => {
          this.deleleSection(this.form.id).then(() => {
            this.$message({
              type: 'success',
              message: 'Секция удалина'
            });
            this.$router.go(-1);
          });
        });
    },
    setLanguageVersion(value, index, codeLanguage) {
      this.form.languageVersions.find(item => item.codeLanguage === codeLanguage)
        .blocks[index].content = value;
    },
    addBlock() {
      const index = this.indexBlock;
      this.form.languageVersions.map(item => item.blocks.push({ content: '', index }));
    },
    removeBlock(index) {
      this.form.languageVersions.map(item => {
        item.blocks.splice(index, 1);
        item.blocks.forEach((block, i)=> {
          block.index = (i + 1);
        });
      });
    },
    statusClassName(status) {
      if (status === 1) {
        return 'success';
      } else if (status === 3) {
        return 'warning';
      } else if (status === 4) {
        return 'danger';
      }
      return '';
    },
  }
};
</script>

<style lang="stylus" scoped>
.status
  display: flex
  align-items: center
  justify-content: flex-end
  color: #409eff
  .success
    color: #67c23a
  .warning
    color: #e6a23c
  .danger
    color: #f56c6c
</style>