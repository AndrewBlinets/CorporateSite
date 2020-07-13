<template>
  <div class="header">
    <breadcrumb />

    <div class="user-name">{{ fullName }}</div>
    <el-button type="danger" plain @click="logout">Выход</el-button>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import Breadcrumb from '@/components/Breadcrumb';

export default {
  name: 'Navbar',
  components: {
    Breadcrumb,
  },
  computed: {
    ...mapState('user', ['name', 'surname']),
    fullName() {
      return `${this.name} ${this.surname}`;
    },
  },
  methods: {
    async logout() {
      await this.$store.dispatch('user/logout');
      this.$router.push(`/login?redirect=${this.$route.fullPath}`);
    },
  },
};
</script>

<style lang="stylus" scoped>
.header {
  position: relative;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;
  width: 100%;
  min-height: 50px;
  padding: 10px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);

  .user-name {
    font-size: 18px;
    letter-spacing: 1.375px;
    margin-right: 20px;
  }
}
</style>
