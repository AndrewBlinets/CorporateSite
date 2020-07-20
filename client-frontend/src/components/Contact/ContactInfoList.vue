<template>
  <div class="contact__info">
    <contact-info-item
      v-for="(item, index) in contactInfo"
      :key="index"
      :icon="item.icon"
      :title="$t(`meta.contactInfoList.${item.title}`)"
      :value="item.value"
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
          title: 'address',
          value: this.address,
        });

      this.room &&
        infoList.push({
          icon: faMapMarkerAlt,
          title: 'cabinet',
          value: `№${this.room}`,
        });

      this.phone &&
        infoList.push({
          icon: faPhoneAlt,
          title: 'phone',
          value: this.phone,
        });

      this.email &&
        infoList.push({
          icon: faEnvelope,
          title: 'email',
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
