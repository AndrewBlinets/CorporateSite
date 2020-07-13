<template>
  <div class="members-container">
    <el-input class="input-with-select">
      <i slot="prefix" class="el-input__icon el-icon-search"></i>
    </el-input>

    <el-divider></el-divider>

    <el-checkbox-group v-model="checkedMembers" class="members-list">
      <el-checkbox
        v-for="customer in customers"
        :key="customer.id"
        :label="customer.id"
        class="member"
      >
        {{ customer.surName }} {{ customer.name }}
      </el-checkbox>
    </el-checkbox-group>
  </div>
</template>

<script>
import { getCustomersByProject } from '@/api/customer';

export default {
  name: 'MembersList',
  props: {
    value: Array,
  },
  data: () => ({
    customers: [],
  }),
  computed: {
    checkedMembers: {
      get: function () {
        return this.value;
      },
      set: function (value) {
        this.$emit('input', value);
      },
    },
  },
  mounted() {
    this.getCustomers();
  },
  methods: {
    getCustomers() {
      const { id } = this.$route.params;
      getCustomersByProject(id).then(data => {
        this.customers = data;
      });
    },
  },
};
</script>

<style lang="stylus" scoped>
.members-list {
  display: flex;
  flex-direction: column;
}

.member {
  font-size: 16px;
}
</style>
