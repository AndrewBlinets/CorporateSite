<template>
  <section id="about-us">
    <div class="app-container grid-area">
      <div class="section-header">
        <h2>{{ $t('views.home.aboutUs.title') }}</h2>
      </div>
      <div class="section-body">
        <div class="row align-items-center mb-5">
          <div class="col">
            <div class="information">
              <p
                v-for="(item, index) of $t('views.home.aboutUs.infoList')"
                :key="index"
              >
                {{ item }}
              </p>
            </div>
          </div>
          <div class="col-12 col-sm-6 mt-sm-0 mt-5">
            <div class="information-statistic">
              <h4>{{ $t('views.home.aboutUs.quote') }}</h4>
            </div>
          </div>
        </div>
        <div class="button-container">
          <div class="button-item">
            <router-link :to="{ name: 'about-us' }" class="btn btn-main">
              {{ $t('views.home.aboutUs.more') }}
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
