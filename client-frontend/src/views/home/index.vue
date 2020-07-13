<template>
  <div>
    <div class="main-banner">
      <div class="banner-image">
        <app-image :id="18"></app-image>
      </div>
      <div class="app-container grid grid-header">
        <div class="banner-content">
          <h4>НИРУП</h4>
          <h1>Институт прикладных программных систем</h1>
          <p>
            Современная, динамично развивающаяся компания в области
            научно-методического обеспечения процессов развития информатизации,
            бизнес-анализа, создания информационных систем электронного
            правительства и предоставления услуг в области IT.
          </p>
          <social-links />
        </div>
      </div>
    </div>

    <about-us></about-us>
    <activities></activities>
    <counter-area></counter-area>
    <news></news>
    <projects></projects>
    <partners></partners>
    <contacts></contacts>
  </div>
</template>

<script>
import AppImage from '@/components/AppImage';
import AboutUs from './components/AboutUs';
import Activities from './components/Activities';
import Contacts from './components/Contacts';
import CounterArea from './components/CounterArea';
import News from './components/News';
import Partners from './components/Partners';
import Projects from './components/Projects';
import SocialLinks from '@/components/SocialLinks';

export default {
  name: 'Home',
  components: {
    AppImage,
    AboutUs,
    Activities,
    Contacts,
    CounterArea,
    News,
    Partners,
    Projects,
    SocialLinks,
  },
};
</script>

<style lang="stylus" scoped>
.main-banner {
  position: relative;
  height: 700px;
  overflow: hidden;

  &:before {
    content: '';
    position: absolute;
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

  .banner-image {
    position: absolute;
    width: 100%;
    height: 100%;
    z-index: 1;
  }

  .banner-content {
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: baseline;
    justify-content: center;
    height: 100%;
    z-index: 4;

    h1 {
      margin-bottom: 3rem;
    }

    h4 {
      padding: 4px 18px;
      border-radius: 5px;
      margin-bottom: 1.5rem;
      themify(
        $themes,
        @($theme) {
        color: $theme.$secondary--light--color;
        background: $theme.$primary--light--color;
      }
      );
    }

    h1, p {
      themify(
        $themes,
        @($theme) {
        color: $theme.$primary--light--color;
      }
      );
    }
  }
}
</style>
