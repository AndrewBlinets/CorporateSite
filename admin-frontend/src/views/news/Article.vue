<template>
  <div class="page-container">
    <div class="title">
      <el-row type="flex" justify="space-between">
        <el-col :span="12">
          <h1>Новость</h1>
        </el-col>
        <el-col
          v-if="form.status"
          :span="6"
          class="status"
        >
          <span :class="statusClassName(form.status)">{{ form.status | pluralizationStatus }}</span>
        </el-col>
      </el-row>
    </div>
    <el-row class="mb-2">
      <el-col :lg="24" :xl="16">

        <el-form ref="form" :model="form" label-width="190px">
          <el-form-item label="Изображение заголовка">
            <upload-file v-model="form.mainImage" />
          </el-form-item>
          <language-tabs :languageVersions="form.languageVersions" />
          <el-form-item label="Дата публикации">
            <el-col :span="8">
              <el-date-picker type="date" placeholder="Выберите дату" v-model="form.datePublic" />
            </el-col>
            <el-col :span="8">
              <el-time-picker placeholder="Выберите время" v-model="form.datePublic" />
            </el-col>
          </el-form-item>
        </el-form>

      </el-col>
    </el-row>
    <el-row type="flex" justify="space-between">
      <el-col :span="12" >
        <el-button
          type="success"
          @click="saveArticle(1)"
        >Опубликовать</el-button>
        <el-button
          type="warning"
          plain
          @click="saveArticle(3)"
        >Сохранить как черновик</el-button>
        <el-button
          v-if="form.id"
          type="danger"
          plain
          @click="deleteArticle"
        >Удалить</el-button>
      </el-col>
      <el-col :span="3" align="right">
        <el-button
          type="primary"
          @click="$router.push({ path: '/news' })"
        >Отмена</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import store from '@/store';
import { mapState, mapActions } from 'vuex';
import UploadFile from '@/components/UploadFile';
import LanguageTabs from './components/LanguageTabs';

export default {
  name: 'Article',
  components: {
    UploadFile,
    LanguageTabs
  },
  data() {
    return {
      form: {
        languageVersions: [
          {
            codeLanguage: 'ru',
            title: '',
            shortTitle: '',
            entrySpeech: '',
            content: ''
          },
          {
            codeLanguage: 'by',
            title: '',
            shortTitle: '',
            entrySpeech: '',
            content: ''
          },
          {
            codeLanguage: 'en',
            title: '',
            shortTitle: '',
            entrySpeech: '',
            content: ''
          }
        ],
        datePublic: '',
        mainImage: null
      },
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false
    };
  },
  computed: {
    ...mapState({
      news: state => state.news.news
    }),
  },
  beforeRouteEnter (to, from, next) {
    // eslint-disable-next-line no-console
    console.log('beforeRouteEnter');
    const id = to.params.id;

    if (id) {
      store.dispatch('news/getNews', id).then(() => {
        next();
      });
    } else {
      next();
    }
  },
  beforeRouteUpdate (to, from, next) {
    // eslint-disable-next-line no-console
    console.log('beforeRouteUpdate');
    const id = to.params.id;

    if (id) {
      store.dispatch('news/getNews', id).then(() => {
        next();
      });
    } else {
      this.resetNews().then(() => {
        next();
      });
    }
  },
  beforeRouteLeave (to, from, next) {
    // eslint-disable-next-line no-console
    console.log('beforeRouteLeave');
    this.resetNews().then(() => {
      next();
    });
  },
  created() {
    if (Object.keys(this.news).length !== 0) {
      Object.assign(this.form, this.news);
    }
  },
  destroy() {
    this.resetNews();
  },
  methods: {
    ...mapActions({
      createNews: 'news/createNews',
      resetNews: 'news/resetNews',
      updateNews: 'news/updateNews',
      deleteNews: 'news/deleteNews'
    }),
    saveArticle(status) {
      this.form.status = status;
      if (this.form.id) {
        this.updateNews(this.form).then(() => {
          this.$message({
            type: 'success',
            message: 'Новость обновлена'
          });
          Object.assign(this.form, this.news);
        });
      } else {
        this.createNews(this.form).then((id) => {
          this.$message({
            type: 'success',
            message: 'Новость сохранена'
          });
          this.$router.push({ name: 'news-id', params: { id } });
        });
      }
    },
    deleteArticle() {
      this.$confirm('Вы точно хотите удалить?', {
          confirmButtonText: 'Подтвердить',
          cancelButtonText: 'Отменить',
          type: 'warning'
        }).then(() => {
          this.deleteNews(this.form.id).then(() => {
            this.$message({
              type: 'success',
              message: 'Новость удалина'
            });
            this.$router.push({ path: '/news' });
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: 'Удаление отменино'
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
.el-upload.el-upload--picture-card
  width: 100%
  height: 150px

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