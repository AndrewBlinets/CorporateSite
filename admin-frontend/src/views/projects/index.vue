<template>
  <div class="page-container">
    <div class="title">
      <h1>Проекты</h1>
    </div>

    <div class="button-container">
      <el-button
        type="success"
        icon="el-icon-plus"
        @click="$router.push({ name: 'create-project' })"
      >
        Создать
      </el-button>
    </div>

    <div class="table-container mb-1">
      <el-table
        ref="multipleTable"
        :data="projects"
        :row-class-name="tableRowClassName"
        border
        @sort-change="tableSortProp"
      >
        <el-table-column type="index" :index="indexMethod" />

        <el-table-column label="ID" prop="id" width="80" sortable="custom" />

        <el-table-column label="Название" prop="shortTitle" />

        <el-table-column
          label="Дата создания"
          prop="dti"
          width="115"
          label-class-name="date"
          sortable="custom"
        >
          <template slot-scope="scope">
            {{ scope.row.dti | formatDate }}
          </template>
        </el-table-column>

        <el-table-column
          prop="datePublic"
          label="Дата публикации"
          width="130"
          label-class-name="date"
          sortable="custom"
        >
          <template slot-scope="scope">
            {{ scope.row.datePublic | formatDate }}
          </template>
        </el-table-column>

        <el-table-column label="Статус" width="155">
          <template slot-scope="scope">
            {{ scope.row.status | pluralizationStatus }}
          </template>
        </el-table-column>

        <el-table-column label="Операции" fixed="right" width="150">
          <template slot-scope="scope">
            <el-button
              icon="el-icon-edit"
              size="medium"
              @click="
                $router.push({
                  name: 'project-id',
                  params: { id: scope.row.id },
                })
              "
            />

            <el-button
              icon="el-icon-delete"
              size="medium"
              type="danger"
              @click="deleteRow(scope.row.id)"
            />
          </template>
        </el-table-column>
      </el-table>
    </div>

    <el-pagination
      layout="total, sizes, prev, pager, next, jumper"
      :current-page.sync="page"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="size"
      :total="totalElements"
      @size-change="tableSizeChange"
      @current-change="tableCurrentChange"
    ></el-pagination>
  </div>
</template>

<script>
import { getProjectsList, deleteProject } from '@/api/project';

export default {
  name: 'Projects',

  data: () => ({
    projects: [],
    page: null,
    size: null,
    totalElements: null,
    params: {},
  }),

  beforeRouteEnter(to, from, next) {
    getProjectsList().then(data => {
      next(vm => vm.setData(data));
    });
  },

  methods: {
    getData(params) {
      this.params = { ...this.params, ...params };
      getProjectsList(this.params).then(data => this.setData(data));
    },

    setData(data) {
      const { content, number, size, totalElements } = data;

      this.projects = [...content];
      this.page = number + 1;
      this.size = size;
      this.totalElements = totalElements;
    },

    indexMethod(index) {
      return index + 1 + (this.page - 1) * this.size;
    },

    tableSizeChange(size) {
      this.getData({ size });
    },

    tableCurrentChange(value) {
      this.getData({ page: value - 1 });
    },

    tableRowClassName({ row }) {
      if (row.status === 2) {
        return 'brand-row';
      } else if (row.status === 3) {
        return 'warning-row';
      } else if (row.status === 4) {
        return 'error-row';
      }
      return '';
    },

    tableSortProp(value) {
      if (value.order) {
        const order = value.order.replace('ending', '');
        const sort = `${value.prop},${order}`;
        this.getData({ sort });
      } else {
        delete this.params.sort;
        this.getData();
      }
    },

    deleteRow(id) {
      this.$confirm('Вы точно хотите удалить?', {
        confirmButtonText: 'Подтвердить',
        cancelButtonText: 'Отменить',
        type: 'warning',
      })
        .then(() => {
          deleteProject(id).then(() => {
            this.$message({
              type: 'success',
              message: 'Запись удалина',
            });
            this.getData();
          });
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: 'Удаление отменено',
          });
        });
    },
  },
};
</script>
