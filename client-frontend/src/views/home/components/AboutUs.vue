<template>
  <section id="about-us">
    <div class="app-container grid-area">
      <div class="section-header">
        <h2>О Нас</h2>
      </div>
      <div class="section-body">
        <div class="row align-items-center mb-5">
          <div class="col">
            <div class="information">
              <p>
                Большинство разработанных НИРУП «ИППС» продуктов относятся к
                глобальным, эффективно применяемым на общегосударственном
                уровне.
              </p>
              <p>
                Предприятие выполняет заказы более 300 организаций, органов
                государственного управления, учреждений и предприятий в
                Республике Беларусь и Российской Федерации.
              </p>
              <p>
                Мы предлагаем сотрудничество по разработке программного
                обеспечения, созданию корпоративных систем, автоматизации
                бухгалтерского учета непроизводственной сферы, комплексной
                автоматизации органов государственного управления и других
                структур.
              </p>
            </div>
          </div>
          <div class="col-12 col-sm-6 mt-sm-0 mt-5">
            <div class="information-statistic">
              <h4>
                Наша миссия - способствовать развитию информационного общества
                Республики Беларусь для обеспечения взаимодействия населения,
                государства и бизнеса на базе информационных технологий
              </h4>
            </div>
          </div>
        </div>
        <div class="button-container">
          <div class="button-item">
            <router-link :to="{ name: 'about-us' }" class="btn btn-main">
              Подробнее
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'AboutUs',
};
</script>

<style lang="stylus" scoped>
.information-statistic {
  h4 {
    padding-left: 10px;
    color: #222;
    line-height: 2.2rem;
    text-align: center;
    font-style: italic;
    themify(
      $themes,
      @($theme) {
      color: $theme.$primary--dark--color;
      border-left: 4px solid $theme.$secondary--dark--color;
    }
    );
  }
}
</style>
