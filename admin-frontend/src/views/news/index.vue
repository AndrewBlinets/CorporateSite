<template>
  <div class="page-container">
    <div class="title">
      <h1>Новости</h1>
    </div>
    <div class="button-container">
      <el-button
        type="success"
        icon="el-icon-plus"
        @click="$router.push({ name: 'create-news' })"
      >Создать</el-button>
    </div>
    <div class="table-container mb-1">
      <el-table
        ref="multipleTable"
        :data="newsList"
        :row-class-name="tableRowClassName"
        border
        @sort-change="tableSortProp"
      >
        <el-table-column
          type="index"
          :index="indexMethod"
        />
        <el-table-column
          prop="id"
          label="ID"
          width="80"
          sortable="custom"
        />
        <el-table-column
          prop="shortTitle"
          label="Название"
        />
        <el-table-column
          prop="dti"
          label="Дата создания"
          width="115"
          label-class-name="date"
          sortable="custom"
        >
          <template slot-scope="scope">{{ scope.row.dti | formatDate }}</template>
        </el-table-column>
        <el-table-column
          prop="datePublic"
          label="Дата публикации"
          width="130"
          label-class-name="date"
          sortable="custom"
        >
          <template slot-scope="scope">{{ scope.row.datePublic | formatDate }}</template>
        </el-table-column>
        <el-table-column
          label="Статус"
          width="155"
        >
          <template slot-scope="scope">{{ scope.row.status | pluralizationStatus }}</template>
        </el-table-column>
        <el-table-column
          fixed="right"
          label="Операции"
          width="150"
        >
          <template slot-scope="scope">
            <!-- <el-button size="medium" icon="el-icon-view" /> -->
            <el-button
              @click="$router.push({ name: 'news-id', params: { id: scope.row.id } })"
              size="medium"
              icon="el-icon-edit"
            />
            <el-button
              @click="deleteRow(scope.row.id)"
              size="medium"
              icon="el-icon-delete"
              type="danger"
            />
          </template>
        </el-table-column>
      </el-table>
    </div>

    <el-pagination
      @size-change="tableSizeChange"
      @current-change="tableCurrentChange"
      :current-page.sync="page"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>

  </div>
</template>

<script>
import store from '@/store';
import { mapState, mapGetters, mapActions } from 'vuex';

export default {
  name: 'News',
  computed: {
    ...mapState({
      size: state => state.news.params.size
    }),
    ...mapGetters({
      newsList: 'news/newsListData',
      total: 'news/newsListTotal'
    }),
    page: {
      get: function() {
        return store.state.news.params.page + 1;
      },
      set: function(value) {
        store.commit('news/ADD_PARAMS', { page: value - 1});
      }
    }
  },
  beforeRouteEnter(to, from, next) {
    store.dispatch('news/getNewsList').then(() => {
      next();
    });
  },
  methods: {
    ...mapActions({
      deleteNews: 'news/deleteNews'
    }),
    indexMethod(index) {
      return (index + 1) + (store.state.news.params.page * this.size);
    },
    tableSizeChange(value) {
      store.dispatch('news/getNewsList', { size: value });
    },
    tableCurrentChange(value) {
      store.dispatch('news/getNewsList', { page: value - 1 });
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
        store.commit('news/ADD_PARAMS', { sort: `${value.prop},${order}`, page: 0 });
        store.dispatch('news/getNewsList');
      } else {
        store.commit('news/REMOVE_PARAMS', 'sort');
        store.dispatch('news/getNewsList', { page: 0 });
      }
    },
    deleteRow(id) {
      this.$confirm('Вы точно хотите удалить?', {
          confirmButtonText: 'Подтвердить',
          cancelButtonText: 'Отменить',
          type: 'warning'
        }).then(() => {
          this.deleteNews(id).then(() => {
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
    }
  }
};
</script>

<style lang="stylus" scoped>

</style>
