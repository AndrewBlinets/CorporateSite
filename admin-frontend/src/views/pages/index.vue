<template>
  <div class="page-container">
    <div class="title">
      <h1>Страницы</h1>
    </div>
    <div class="table-container mb-1">
      <el-table
        ref="multipleTable"
        :data="pages"
        border
      >
        <el-table-column
          type="index"
        />
        <el-table-column
          prop="id"
          label="ID"
          width="80"
          sortable
        />
        <el-table-column
          prop="name"
          label="Название"
        />
        <el-table-column
          fixed="right"
          label="Операции"
          width="150"
        >
          <template slot-scope="scope">
            <el-button
              size="medium"
              icon="el-icon-edit"
              @click="$router.push({ name: 'page-id', params: { id: scope.row.id } })"
            />
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import store from '@/store';
import { mapState } from 'vuex';

export default {
  name: 'Pages',
  data: () => ({
    pageId: null
  }),
  computed: {
    ...mapState({
      pages: state => state.page.pagesList
    })
  },
  beforeRouteEnter (to, from, next) {
    store.dispatch('page/getPagesList').then(() => {
      next();
    });
  }
};
</script>