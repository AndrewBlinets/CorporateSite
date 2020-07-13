<template>
  <div class="page-container customer-container">
    <div class="title">
      <el-row type="flex" justify="space-between" class="title">
        <el-col>
          <h1>Проект</h1>
        </el-col>
        <el-col class="add-customer">
          <el-button type="success" @click="openAddMembers = true">
            + Добавить участников
          </el-button>
        </el-col>
      </el-row>
    </div>

    <el-row :gutter="20" type="flex" class="customer-body">
      <el-col :span="18">
        <news-project></news-project>
      </el-col>
      <el-col :span="6">
        <add-files></add-files>
      </el-col>
    </el-row>

    <members :open="openAddMembers" @close="openAddMembers = false"></members>
  </div>
</template>

<script>
import Members from './components/Members';
import AddFiles from './components/AddFiles';
import NewsProject from './components/NewsProject/index';

export default {
  name: 'CustomerProject',
  components: {
    Members,
    AddFiles,
    NewsProject,
  },
  data: () => ({
    openAddMembers: false,
  }),
};
</script>

<style lang="stylus" scoped>
.customer-container {
  height: 100%;
  overflow: hidden;

  .title {
    margin-bottom: 10px;
  }

  .customer-body {
    flex: 1;
    overflow: auto;
  }
}

.add-customer {
  display: flex;
  justify-content: flex-end;
}
</style>
