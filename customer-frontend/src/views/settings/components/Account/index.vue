<template>
  <div>
    <h2 class="title mb-5">МОЯ УЧЁТНАЯ ЗАПИСЬ</h2>
    <account-card></account-card>
  </div>
</template>

<script>
import AccountCard from './AccountCard/index';

export default {
  name: 'Account',
  components: { AccountCard },
};
</script>
