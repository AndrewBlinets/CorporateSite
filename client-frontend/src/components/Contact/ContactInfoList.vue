<template>
  <div class="contact__info">
    <contact-info-item
      v-for="(item, index) in contactInfo"
      :key="index"
      v-bind="item"
    ></contact-info-item>
  </div>
</template>

<script>
import {
  faMapMarkerAlt,
  faPhoneAlt,
  faEnvelope,
} from '@fortawesome/free-solid-svg-icons';
import ContactInfoItem from './ContactInfoItem.vue';

export default {
  name: 'ContactInfoList',
  components: {
    ContactInfoItem,
  },
  props: {
    address: String,
    room: String,
    phone: String,
    email: String,
  },
  computed: {
    contactInfo() {
      const infoList = [];

      this.address &&
        infoList.push({
          icon: faMapMarkerAlt,
          title: 'Адрес',
          value: this.address,
        });

      this.room &&
        infoList.push({
          icon: faMapMarkerAlt,
          title: 'Кабинет',
          value: `№${this.room}`,
        });

      this.phone &&
        infoList.push({
          icon: faPhoneAlt,
          title: 'Телефон',
          value: this.phone,
        });

      this.email &&
        infoList.push({
          icon: faEnvelope,
          title: 'Email',
          value: this.email,
        });

      return infoList;
    },
  },
};
</script>

<style lang="stylus" scoped>
.contact__info > * {
  margin: 0.5rem 0;
}
</style>
