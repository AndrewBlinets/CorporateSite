<template>
  <div class="social-links__container">
    <social-link-item
      v-for="socialLink in socialLinks"
      :key="socialLink.id"
      v-bind="socialLink"
    />
  </div>
</template>

<script>
import {
  faFacebookF,
  faVk,
  faTwitter,
  faYoutube,
} from '@fortawesome/free-brands-svg-icons';
import SocialLinkItem from './SocialLinkItem';

export default {
  name: 'SocialLinks',
  components: {
    SocialLinkItem,
  },
  data() {
    return {
      socialLinks: [
        {
          id: 1,
          url: 'https://vk.com/nirup_ipps',
          fortAwesomeIcon: faVk,
        },
        {
          id: 2,
          url: 'https://twitter.com/NIRYP_IPPS',
          fortAwesomeIcon: faTwitter,
        },
        {
          id: 3,
          url:
            'https://www.facebook.com/%D0%9D%D0%98%D0%A0%D0%A3%D0%9F-%D0%98%D0%9F%D0%9F%D0%A1-1770692979877907',
          fortAwesomeIcon: faFacebookF,
        },
        {
          id: 4,
          url: 'https://www.youtube.com/channel/UCvJ2djjv-vd-m44XAXDDxXA',
          fortAwesomeIcon: faYoutube,
        },
      ],
    };
  },
};
</script>

<style lang="stylus" scoped>
.social-links__container {
  display: flex;
}
</style>
