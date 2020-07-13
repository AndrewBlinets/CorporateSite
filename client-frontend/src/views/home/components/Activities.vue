<template>
  <section id="activities" class="bgr-grey">
    <div class="app-container grid-area">
      <div class="section-header">
        <h2>Направления Деятельности</h2>
      </div>
      <div class="section-body">
        <div class="services-container">
          <div class="services-img">
            <app-image :id="143" name="направления-деятельности"></app-image>
          </div>
          <div class="row no-gutters">
            <div
              v-for="(activity, index) in activities"
              :key="index"
              class="col"
            >
              <div class="service-item">
                <h5>{{ activity }}</h5>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import AppImage from '@/components/AppImage';

export default {
  name: 'Activities',
  components: {
    AppImage,
  },
  data: () => ({
    activities: [
      'Анализ, проектирование и программное обеспечение информационных систем',
      'Обработка данных с применением ПО третьего лица или собственного ПО',
      'Фундаментальные и прикладные исследования, экспериментальные разработки в области естественных и технических наук',
      'Техническая и (или) криптографическая защита информации',
      'Анализ информационных потребностей юридических лиц и индивидуальных предпринимателей',
      'Консультирование по вопросам использования информационных технологий в целях инновации бизнес-процессов',
      'Оказание автоматизированных услуг по поиску, отбору, обработке и сортировке данных',
      'Услуги центров обработки данных',
    ],
  }),
};
</script>

<style lang="stylus" scoped>
.col {
  min-width: auto;
}

.services-container {
  display: flex;
  flex-wrap: wrap;
  position: relative;
  overflow: hidden;
  z-index: 0;

  &:before {
    content: '';
    position: absolute;
    right: 0;
    bottom: 0;
    width: 100%;
    height: 100%;
    z-index: -1;
    themify(
      $themes,
      @($theme) {
      background: $theme.$gradient--primary--color;
    }
    );
  }

  .services-img {
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    z-index: -2;
  }
}

.service-item {
  display: flex;
  min-width: 310px;
  height: 250px;
  padding: 20px;
  align-items: center;
  transition: all 0.4s cubic-bezier(0.4, 0, 0.6, 1);
  themify(
    $themes,
    @($theme) {
    border-right: 2px solid $theme.$primary--light--color;
    border-bottom: 2px solid $theme.$primary--light--color;
  }
  );

  h5 {
    themify(
      $themes,
      @($theme) {
      color: $theme.$primary--light--color;
    }
    );
    transition: all 0.4s cubic-bezier(0.4, 0, 0.6, 1);
  }

  &:hover {
    themify(
      $themes,
      @($theme) {
      background-color: $theme.$secondary--light--color;
    }
    );

    h5 {
      transform: translateY(-7px);
    }
  }
}

@media (max-width: 649px) {
  .service-item {
    height: 150px;
  }
}
</style>
