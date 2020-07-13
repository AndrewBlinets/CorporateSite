<template>
  <div>
    <header-page :image="19">
      <h1>Ошибка 404. Страница не найдена!</h1>
    </header-page>
  </div>
</template>

<script>
import HeaderPage from '@/components/HeaderPage';

export default {
  name: 'NotFound',
  components: {
    HeaderPage,
  },
};
</script>
