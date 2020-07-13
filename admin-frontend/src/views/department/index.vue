<template>
  <div class="page-container">
    <div class="title">
      <h1>Отделы</h1>
    </div>

    <create-department
      v-if="createDepartment"
      @close="createDepartment = false"
    />
    <div
      v-if="!createDepartment"
      class="button-container"
    >
      <el-button
        type="success"
        icon="el-icon-plus"
        @click="createDepartment = true"
      >Создать</el-button>
    </div>

    <div class="table-container">
      <el-table
        :data="searchDepartments(search)"
        row-key="id"
        border
      >
        <el-table-column
          type="index"
          width="50"
        />
        <el-table-column
          prop="name"
          label="Название"
          sortable
        >
          <template slot-scope="scope">
            <el-input
              v-if="isEditing(scope.row.id)"
              v-model="scope.row.name"
              size="large"
              controls-position="right"
            />
            <span v-else>{{ scope.row.name }}</span>
          </template>
        </el-table-column>
        <el-table-column
          prop="code"
          label="Код"
          width="100"
          sortable
        >
          <template slot-scope="scope">
            <el-input
              v-if="isEditing(scope.row.id)"
              v-model="scope.row.code"
              size="large"
              controls-position="right"
            />
            <span v-else>{{ scope.row.code }}</span>
          </template>
        </el-table-column>
        <el-table-column align="right" width="150">
          <template slot-scope="scope">
            <el-button
              v-if="isEditing(scope.row.id)"
              @click="updateRow(scope.row)"
              size="large"
              icon="el-icon-check"
              type="success"
            />
            <el-button
              v-else
              size="large"
              icon="el-icon-edit"
              @click="addEditRow(scope.row.id)"
            />
            <el-button
              v-if="isEditing(scope.row.id)"
              @click="cancelEditRow(scope.row.id)"
              size="large"
              icon="el-icon-close"
              type="default"
            />
            <el-button
              v-else
              @click="deleteRow(scope.row.id)"
              size="large"
              icon="el-icon-delete"
              type="danger"
            />
          </template>
        </el-table-column>
      </el-table>

    </div>
  </div>
</template>

<script>
import store from '@/store';
import { mapGetters, mapActions } from 'vuex';
import CreateDepartment from './CreateDepartment';

export default {
  name: 'Department',
  components: {
    CreateDepartment
  },
  data: () => ({
    search: '',
    department: {
      name: '',
      code: ''
    },
    createDepartment: false,
    edit: []
  }),
  computed: {
    ...mapGetters({
      searchDepartments: 'department/searchDepartmens'
    }),
  },
  beforeRouteEnter(to, from, next) {
    store.dispatch('department/getDepartmentsList').then(() => {
      next();
    });
  },
  methods: {
    ...mapActions({
      updateDepartment: 'department/updateDepartment',
      deleteDepartment: 'department/deleteDepartment'
    }),
    toCreateArticle() {
      this.$router.push({ path: 'create'});
    },
    addEditRow(id) {
      this.edit.push(id);
    },
    cancelEditRow(id) {
      const index = this.edit.findIndex(item => item === id);
      this.edit.splice(index, 1);
    },
    updateRow(department) {
      const { id } = department;
      this.updateDepartment(department).then(() => {
        this.$message({
          type: 'success',
          message: 'Запись обновлена'
        });
      });
      this.cancelEditRow(id);
    },
    deleteRow(id) {
      this.$confirm('Вы точно хотите удалить?', {
          confirmButtonText: 'Подтвердить',
          cancelButtonText: 'Отменить',
          type: 'warning'
        }).then(() => {
          this.deleteDepartment(id).then(() => {
            this.$message({
              type: 'success',
              message: 'Запись удалина'
            });
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: 'Удаление отменено'
          });
        });
    },
    isEditing(id) {
      return this.edit.includes(id);
    }
  }
};
</script>
