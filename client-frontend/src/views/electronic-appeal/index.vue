<template>
  <div>
    <header-page :image="18">
      <h1>Электронное Обращение</h1>
    </header-page>
    <div class="app-container body-page">
      <div class="row">
        <div class="col-lg-5 col-12 mb-lg-0 mb-5">
          <form-appeal></form-appeal>
        </div>
        <div class="col-lg-7 col-12">
          <description></description>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HeaderPage from '@/components/HeaderPage';
import FormAppeal from './components/FormAppeal';
import Description from './components/Description';

export default {
  name: 'ElectronicAppeal',
  components: {
    HeaderPage,
    FormAppeal,
    Description,
  },
};
</script>

<style lang="stylus" scoped>
.body-page {
  margin-top: 50px;
  margin-bottom: 50px;
}
</style>
