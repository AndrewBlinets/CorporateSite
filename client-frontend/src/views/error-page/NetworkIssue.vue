<template>
  <div>
    <header-page :image="19">
      <h1>Проблемы с сетью!</h1>
    </header-page>
  </div>
</template>

<script>
import HeaderPage from '@/components/HeaderPage';

export default {
  name: 'NetworkIssue',
  components: {
    HeaderPage
  }
};
</script>