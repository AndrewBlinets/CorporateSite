<template>
  <footer>
    <div class="footer-container">
      <div class="app-container">
        <div class="links">
          <a
            href="http://xn----7sbgfh2alwzdhpc0c.xn--90ais/RatingPortal"
            target="_blank"
          >
            <img src="../../assets/baner.png" alt="" />
          </a>
          <a href="http://mpt.gov.by/ru/" target="_blank">
            <img :src="getImage(3)" alt="" class="img-filter" />
          </a>
          <a href="http://portal.gov.by/" target="_blank">
            <img :src="getImage(1)" alt="" class="img-filter" />
          </a>
          <a href="https://www.reestr-zalogov.by/" target="_blank">
            <img src="../../assets/reestr_imush.png" alt="" />
          </a>
        </div>
      </div>

      <div class="app-container flex-container flex-md-row">
        <div class="content mb-md-0 mb-3">
          <div class="logo">
            <app-image :id="142" name="ИППС" backgroundColor="#ffffff00" />
          </div>
          <p>© {{ $t('meta.footer.copyright') }}</p>
        </div>
        <social-links />
      </div>
    </div>
  </footer>
</template>

<script>
import { getImage } from '@/api/index';
import AppImage from '@/components/AppImage/index.vue';
import SocialLinks from '@/components/SocialLinks';

export default {
  name: 'Footer',
  components: {
    AppImage,
    SocialLinks,
  },
  methods: {
    getImage(id) {
      return getImage(id);
    },
  },
};
</script>

<style lang="stylus" scoped>
footer {
  margin: auto 0 0;
  themify(
    $themes,
    @($theme) {
    background: $theme.$background--footer--color;
    border-top: 2px solid $theme.$secondary--dark--color;
  }
  );

  .links-item {
    display: flex;
    align-items: flex-start;
    width: 100%;
    height: 100%;
  }

  .links-item {
    border-right: 1px solid #ffffff50;
  }

  .footer-container {
    padding: 30px 0;

    .flex-container {
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      align-items: center;
    }

    .content {
      display: flex;
      align-items: center;

      .logo {
        margin-right: 15px;

        img {
          width: 50px;
          height: 50px;
        }
      }

      p {
        themify(
          $themes,
          @($theme) {
          color: $theme.$primary--light--color;
        }
        );
      }
    }
  }
}

.links {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  margin-bottom: 2rem;

  a {
    height: 96px;
    width: 200px;
    margin: 0 10px;
  }

  img {
    width: 100%;
    height: 100%;
    object-fit: contain;
    object-position: center center;
    themify(
      $themes,
      @($theme) {
      filter: $theme.$image--grayscale--filter;
    }
    );

    &.img-filter {
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
