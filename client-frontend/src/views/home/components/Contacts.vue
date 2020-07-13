<template>
  <section id="contacts">
    <div class="app-container grid-area">
      <div class="section-header">
        <h2>Контакты</h2>
      </div>
      <div class="section-body">
        <div class="row">
          <div class="col-lg-6 col-12 mb-lg-0 mb-5">
            <contact>
              <contact-info-list
                address="220013 г. Минск, ул.Беломорская, 18"
                phone="(8-017) 290-07-66"
                email="info@ipps.by"
              ></contact-info-list>

              <contact-note>
                <p>Телефон «горячей линии» - (8-017) 290-07-66</p>
                <div class="list">
                  <div class="header">
                    <p>По номеру «горячей линии» можно обратиться:</p>
                  </div>
                  <ul>
                    <li>
                      по вопросам справочно-консультационного характера,
                      связанного с направлениями деятельности организации;
                    </li>
                    <li>
                      по вопросам выявления фактов вымогательства,
                      взяточничества и других проявлений коррупции со стороны
                      работников организации;
                    </li>
                    <li>
                      по вопросам записи на личный прием к руководству
                      организации.
                    </li>
                  </ul>
                </div>
                <div class="list">
                  <div class="header">
                    <p>Режим работы горячей линии:</p>
                  </div>
                  <ul>
                    <li>понедельник – четверг: с 9-00 до 18-00;</li>
                    <li>обеденный перерыв: с 13-00 до 13-45;</li>
                    <li>пятница: с 9-00 до 16-20;</li>
                    <li>обеденный перерыв: с 13-00 до 13-20;</li>
                    <li>выходной: суббота, воскресенье.</li>
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
