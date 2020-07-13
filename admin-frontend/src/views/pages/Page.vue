<template>
  <div class="page-container">
    <div class="title">
      <h1>{{ page.name }}</h1>
    </div>
    <div class="button-container">
      <el-button
        type="success"
        icon="el-icon-plus"
        @click="$router.push({ name: 'create-section' })"
      >Создать секцию</el-button>
    </div>
    <div class="table-container mb-1">
      <el-table
        ref="multipleTable"
        :data="sections"
        border
      >
        <el-table-column
          type="index"
          prop="index"
        />
        <el-table-column
          prop="id"
          label="ID"
          width="80"
          sortable="custom"
        />
        <el-table-column
          prop="name"
          label="Название"
        />
        <el-table-column
          prop="type"
          label="Тип"
          width="120"
        >
          <template slot-scope="scope">{{ scope.row.type | pluralizationType }}</template>
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
              @click="$router.push({ name: 'section-id', params: { sectionId: scope.row.id } })"
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
  </div>
</template>

<script>
import store from '@/store';
import { mapState, mapGetters, mapActions } from 'vuex';

export default {
  name: 'Page',
  props: {
    id: {
      type: Number,
      default: null
    }
  },
  computed: {
    ...mapState({
      page: state => state.page.page
    }),
    ...mapGetters({
      sections: 'page/sections'
    })
  },
  beforeRouteEnter (to, from, next) {
    const { id } = to.params;
    
    if (id) {
      store.dispatch('page/getPage', id).then(() => {
        next();
      });
    } else {
      next();
    }
  },
  beforeRouteUpdate (to, from, next) {
    const { id } = to.params;

    if (id) {
      store.dispatch('page/getPage', id).then(() => {
        next();
      });
    } else {
      next();
    }
  },
  methods: {
    ...mapActions({
      deleleSection: 'section/deleteSection'
    }),
    deleteRow(id) {
      this.$confirm('Вы точно хотите удалить?', {
          confirmButtonText: 'Подтвердить',
          cancelButtonText: 'Отменить',
          type: 'warning'
        }).then(() => {
          this.deleleSection(id).then(() => {
            this.$message({
              type: 'success',
              message: 'Секция удалина'
            });
          });
        });
    }
  }
};
</script>