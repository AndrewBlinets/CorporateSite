<template>
  <v-card class="account-card" :class="{ 'card-column': edit }">
    <div class="account-info">
      <account-avatar></account-avatar>

      <account-info-list
        ref="info"
        :edit="edit"
        @cancel="toggleEdit"
      ></account-info-list>
    </div>

    <div v-if="edit" class="btn-group">
      <v-btn outlined class="ma-2" color="primary" @click="toggleEdit">
        Отменить
      </v-btn>
      <v-btn class="ma-2" color="success" @click="save">Сохранить</v-btn>
    </div>
    <v-btn v-else large color="primary" @click="toggleEdit">
      Изменить
    </v-btn>
  </v-card>
</template>

<script>
import AccountAvatar from './AccountAvatar';
import AccountInfoList from './AccountInfoList';

export default {
  name: 'AccountCard',
  components: {
    AccountAvatar,
    AccountInfoList,
  },
  data: () => ({
    edit: false,
  }),
  methods: {
    save() {
      this.$refs.info.handleSave();
    },
    toggleEdit() {
      this.edit = !this.edit;
    },
  },
};
</script>

<style lang="scss" scoped>
.account-card {
  display: flex;
  justify-content: space-between;
  padding: 16px;

  .account-info {
    display: flex;
  }

  &.card-column {
    flex-direction: column;
  }

  .btn-group {
    display: flex;
    justify-content: flex-end;
  }
}
</style>
