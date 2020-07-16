<template>
  <section id="contacts">
    <div class="app-container grid-area">
      <div class="section-header">
        <h2>{{ $t('views.home.contacts.title') }}</h2>
      </div>
      <div class="section-body">
        <div class="row">
          <div class="col-lg-6 col-12 mb-lg-0 mb-5">
            <contact>
              <contact-info-list
                :address="$t('views.home.contacts.address')"
                phone="(8-017) 290-07-66"
                email="info@ipps.by"
              ></contact-info-list>

              <contact-note>
                <p>
                  {{ $t('views.home.contacts.hotline') }} - (8-017) 290-07-66
                </p>
                <div class="list">
                  <div class="header">
                    <p>{{ $t('views.home.contacts.hotlineInfo.title') }}</p>
                  </div>
                  <ul>
                    <li
                      v-for="(item, index) of $t(
                        'views.home.contacts.hotlineInfo.list',
                      )"
                      :key="index"
                    >
                      {{ item }}
                    </li>
                  </ul>
                </div>
                <div class="list">
                  <div class="header">
                    <p>
                      {{ $t('views.home.contacts.operatingModeHotline.title') }}
                    </p>
                  </div>
                  <ul>
                    <li
                      v-for="(item, index) of $t(
                        'views.home.contacts.operatingModeHotline.list',
                      )"
                      :key="index"
                    >
                      {{ item }}
                    </li>
                  </ul>
                </div>
              </contact-note>
            </contact>
          </div>

          <div class="col-lg-6 col-12 d-flex align-items-center">
            <yandex-map
              :settings="settings"
              :coords="[53.924555, 27.588861]"
              :controls="['zoomControl']"
              zoom="17"
            >
              <ymap-marker
                marker-id="123"
                :marker-type="'Placemark'"
                :coords="[53.924555, 27.588859]"
              />
            </yandex-map>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { yandexMap, ymapMarker } from 'vue-yandex-maps';
import Contact from '@/components/Contact/index.vue';
import ContactInfoList from '@/components/Contact/ContactInfoList.vue';
import ContactNote from '@/components/Contact/ContactNote.vue';

export default {
  name: 'Contacts',
  components: {
    Contact,
    ContactInfoList,
    ContactNote,
    yandexMap,
    ymapMarker,
  },
  data: () => ({
    settings: {
      lang: 'ru_RU',
      coordorder: 'latlong',
      version: '2.1',
    },
  }),
};
</script>

<style lang="stylus" scoped>
.ymap-container {
  width: 100%;
  height: 400px;
}
</style>
