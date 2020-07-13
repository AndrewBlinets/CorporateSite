<template>
  <el-dialog
    title="Добавить участников"
    width="400px"
    :visible.sync="dialogVisible"
    :before-close="handleClose"
  >
    <create-member
      v-if="createMember"
      @cancel="createMember = false"
    ></create-member>

    <div v-else>
      <el-button type="success" class="mb-1" @click="createMember = true">
        Создать участника
      </el-button>

      <members-list v-model="addCustomers" class="mb-2"></members-list>

      <span slot="footer" class="dialog-footer">
        <el-button @click="handleClose">Отмена</el-button>
        <el-button type="primary" @click="setMembers">Добавить</el-button>
      </span>
    </div>
  </el-dialog>
</template>

<script>
import { setCustomers } from '@/api/project';
import CreateMember from './CreateMember';
import MembersList from './MembersList';

export default {
  name: 'Members',
  components: {
    CreateMember,
    MembersList,
  },
  props: {
    projectId: {
      type: Number,
    },
    open: {
      type: Boolean,
      default: false,
    },
  },
  data: () => ({
    addCustomers: [],
    createMember: false,
  }),
  computed: {
    dialogVisible() {
      return this.open;
    },
  },
  methods: {
    handleClose() {
      this.$emit('close');
    },
    setMembers() {
      const { id } = this.$route.params;
      setCustomers(id, this.addCustomers).then(() => {
        this.$message({
          type: 'success',
          message: 'Участники добавлены',
        });
      });
    },
  },
};
</script>
