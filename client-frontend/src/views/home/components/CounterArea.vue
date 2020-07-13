<template>
  <section id="counter-area" class="section-padding">
    <div class="banner-img">
      <app-image :id="18"></app-image>
    </div>
    <div class="app-container counter-area__content">
      <div class="row">
        <div v-for="(counter, index) in counters" :key="index" class="col">
          <div class="single-counter">
            <div class="icon">
              <font-awesome-icon :icon="counter.icon" size="2x" />
            </div>
            <span class="counter">{{ counter.count }}</span>
            <h5>{{ counter.title }}</h5>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import {
  faUserTie,
  faBriefcase,
  faClock,
} from '@fortawesome/free-solid-svg-icons';
import AppImage from '@/components/AppImage';

export default {
  name: 'CounterArea',
  components: {
    AppImage,
  },
  data: () => ({
    counters: [
      {
        icon: faUserTie,
        count: '300+',
        title: 'Клиентов',
      },
      {
        icon: faBriefcase,
        count: '100+',
        title: 'Проектов',
      },
      {
        icon: faClock,
        count: '40+',
        title: 'Лет на рынке',
      },
    ],
  }),
};
</script>

<style lang="stylus" scoped>
#counter-area {
  position: relative;
  overflow: hidden;
  z-index: 0;

  &:before {
    position: absolute;
    content: '';
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 3;
    themify(
      $themes,
      @($theme) {
      background: $theme.$gradient--primary--color;
    }
    );
  }

  &:after {
    position: absolute;
    content: '';
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 2;
    themify(
      $themes,
      @($theme) {
      background: $theme.$gradient--secondary--color;
    }
    );
  }

  .banner-img {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 1;
  }
}

.section-padding {
  padding: 100px 0;
}

.counter-area__content {
  position: relative;
  z-index: 4;

  .single-counter {
    text-align: center;
    themify(
      $themes,
      @($theme) {
      color: $theme.$primary--light--color;
    }
    );

    .icon {
      margin-bottom: 25px;
    }

    .counter {
      font-size: 36px;
      font-style: italic;
      font-weight: 300;
      margin-bottom: 10px;
    }

    h5 {
      margin-top: 10px;
      word-wrap: normal;
    }
  }
}
</style>
