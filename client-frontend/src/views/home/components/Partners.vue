<template>
  <section id="partners">
    <div class="partners-img">
      <app-image :id="21" name="Партнёры"></app-image>
    </div>
    <div class="app-container grid-area">
      <div class="section-header">
        <h2>Партнеры</h2>
      </div>
      <div class="section-body">
        <div class="partners-container mx-n3">
          <div v-for="partner in partners" :key="partner.id" class="px-3 mb-4">
            <div class="partner-item">
              <app-image
                :id="partner.image"
                :name="partner.name"
                backgroundColor="#ffffff00"
                class="img"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { getPartners } from '@/api/partners';
import AppImage from '@/components/AppImage';

export default {
  name: 'Partners',
  components: {
    AppImage,
  },
  data: () => ({
    partners: [],
  }),
  mounted() {
    getPartners().then(partners => {
      this.partners = [...partners];
    });
  },
};
</script>

<style lang="stylus" scoped>
#partners {
  position: relative;
  min-height: 620px;
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

  .partners-img {
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    z-index: -3;
  }

  .section-header {
    themify(
      $themes,
      @($theme) {
      color: $theme.$primary--light--color;
    }
    );

    h2::after {
      themify(
        $themes,
        @($theme) {
        border-bottom-color: $theme.$primary--light--color;
      }
      );
    }
  }
}

.partners-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;

  .partner-item {
    display: flex;
    align-items: center;
    width: 200px;
    min-height: 80px;

    img {
      themify(
        $themes,
        @($theme) {
        filter: $theme.$image--invert--filter;
      }
      );
    }
  }
}
</style>
