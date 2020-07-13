<template>
  <el-form ref="form" label-width="75px">
    <el-form-item label="Логин">
      <el-input v-model="form.login"></el-input>
    </el-form-item>
    <el-form-item label="Пароль">
      <el-input v-model="form.password"></el-input>
    </el-form-item>

    <el-divider></el-divider>

    <el-form-item label="Фамилия">
      <el-input v-model="form.surName"></el-input>
    </el-form-item>
    <el-form-item label="Имя">
      <el-input v-model="form.name"></el-input>
    </el-form-item>
    <el-form-item label="Отчество">
      <el-input v-model="form.patronicName"></el-input>
    </el-form-item>
    <el-form-item label="Email">
      <el-input v-model="form.email"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="success" @click="handleCreate">Создать</el-button>
      <el-button @click="$emit('cancel')">Отмена</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { createCustomer } from '@/api/customer';

export default {
  name: 'CreateMember',
  data: () => ({
    form: {
      login: '',
      password: '',
      surName: '',
      name: '',
      patronicName: '',
      email: '',
    },
  }),
  methods: {
    handleCreate() {
      createCustomer(this.form).then(() => {
        this.$message({
          type: 'success',
          message: 'Участник создан',
        });
        this.$emit('cancel');
      });
    },
  },
};
</script>
