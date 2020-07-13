<template>
  <div class="page-container">
    <div class="title">
      <el-row type="flex" justify="space-between" class="mb-2">
        <el-col :span="12">
          <h1>Проект</h1>
        </el-col>
        <el-col v-if="form.status" :span="12" class="status">
          <span :class="statusClassName(form.status)">
            {{ form.status | pluralizationStatus }}
          </span>
        </el-col>
      </el-row>
      <el-button
        v-if="form.id"
        type="primary"
        @click="$router.push({ name: 'customer-priject' })"
      >
        Работа с заказчиками
      </el-button>

      <el-switch
        v-model="form.publicForClient"
        inactive-text="Публикация на портале"
        class="public-switch"
      ></el-switch>
    </div>

    <div class="form-container mb-2">
      <el-form ref="form" :model="form" label-width="190px">
        <el-form-item label="Изображение заголовка">
          <upload-file v-model="form.mainImage" />
        </el-form-item>

        <language-tabs :languageVersions="form.languageVersions">
          <template v-slot:language-version="{ version }">
            <content-project v-bind="version" @input="setLanguageVersion" />
          </template>
        </language-tabs>
      </el-form>
    </div>

    <el-row type="flex" justify="space-between">
      <el-col :span="12">
        <el-button type="success" @click="saveProject(1)">
          Сохранить
        </el-button>

        <el-button type="warning" plain @click="saveProject(3)">
          Сохранить как черновик
        </el-button>

        <el-button
          v-if="form.id"
          type="danger"
          plain
          @click="deleteProjectById"
        >
          Удалить
        </el-button>
      </el-col>

      <el-col :span="3" align="right">
        <el-button type="primary" @click="$router.push({ path: '/projects' })">
          Отмена
        </el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
// import { publicForClient } from '@/api/project';
import store from '@/store';
import { mapState, mapActions } from 'vuex';
import UploadFile from '@/components/UploadFile';
import LanguageTabs from '@/components/LanguageTabs';
import ContentProject from './components/ContentProject';

export default {
  name: 'Project',

  components: {
    UploadFile,
    LanguageTabs,
    ContentProject,
  },

  data: () => ({
    form: {
      languageVersions: [
        {
          codeLanguage: 'ru',
          title: '',
          shortTitle: '',
          content: '',
        },
        {
          codeLanguage: 'by',
          title: '',
          shortTitle: '',
          content: '',
        },
        {
          codeLanguage: 'en',
          title: '',
          shortTitle: '',
          content: '',
        },
      ],
      datePublic: '',
      mainImage: null,
      publicForClient: true,
    },
    dialogImageUrl: '',
    dialogVisible: false,
    disabled: false,
  }),

  computed: {
    ...mapState({
      project: state => state.project.project,
    }),
  },

  beforeRouteEnter(to, from, next) {
    const id = to.params.id;

    if (id) {
      store.dispatch('project/getProject', id).then(() => {
        next();
      });
    } else {
      next();
    }
  },

  beforeRouteUpdate(to, from, next) {
    const id = to.params.id;

    if (id) {
      store.dispatch('project/getProject', id).then(() => {
        next();
      });
    } else {
      this.resetProject().then(() => {
        next();
      });
    }
  },

  beforeRouteLeave(to, from, next) {
    this.resetProject().then(() => {
      next();
    });
  },

  created() {
    if (Object.keys(this.project).length !== 0) {
      Object.assign(this.form, this.project);
    }
  },

  destroy() {
    this.resetProject();
  },

  methods: {
    ...mapActions('project', [
      'createProject',
      'resetProject',
      'updateProject',
      'deleteProject',
    ]),

    setLanguageVersion(value) {
      const { codeLanguage, field } = value;

      this.form.languageVersions.find(
        item => item.codeLanguage === codeLanguage,
      )[field.name] = field.value;
    },

    saveProject(status) {
      this.form.status = status;
      if (this.form.id) {
        this.updateProject(this.form).then(() => {
          this.$message({
            type: 'success',
            message: 'Проект обновлен',
          });
          Object.assign(this.form, this.project);
        });
      } else {
        this.createProject(this.form).then(id => {
          this.$message({
            type: 'success',
            message: 'Проект сохранен',
          });
          this.$router.push({ name: 'project-id', params: { id } });
        });
      }
    },

    deleteProjectById() {
      this.$confirm('Вы точно хотите удалить?', {
        confirmButtonText: 'Подтвердить',
        cancelButtonText: 'Отменить',
        type: 'warning',
      })
        .then(() => {
          this.deleteProject(this.form.id).then(() => {
            this.$message({
              type: 'success',
              message: 'Новость удалина',
            });
            this.$router.push({ path: '/projects' });
          });
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: 'Удаление отменено',
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
  },
};
</script>

<style lang="stylus" scoped>
.el-upload.el-upload--picture-card {
  width: 100%;
  height: 150px;
}

.status {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  color: #409eff;

  .success {
    color: #67c23a;
  }

  .warning {
    color: #e6a23c;
  }

  .danger {
    color: #f56c6c;
  }
}

.public-switch {
  margin-left: 20px;
}
</style>
