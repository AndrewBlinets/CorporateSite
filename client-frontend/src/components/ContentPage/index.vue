<template>
  <v-runtime-template :template="content"></v-runtime-template>
</template>

<script>
import { getIdFromURL } from 'vue-youtube-embed';
import VRuntimeTemplate from 'v-runtime-template';

export default {
  name: 'ContentPage',
  components: {
    // eslint-disable-next-line vue/no-unused-components
    AppImage: () => import('@/components/AppImage'),
    VRuntimeTemplate,
  },
  props: {
    html: {
      type: String,
      default: '',
    },
    width: {
      type: Number,
      default: 900,
    },
  },
  data: () => ({
    videoId: new Map(),
  }),
  computed: {
    playerWidth() {
      return this.width;
    },
    playerHeight() {
      return Math.round(this.width / 1.78);
    },
    content() {
      let contentHtml = '';
      contentHtml = this.replaceImages(this.html);
      contentHtml = this.replaceYouTube(contentHtml);

      return `<div class="content-page">${contentHtml}</div>`;
    },
  },
  methods: {
    replaceImages(content) {
      const regexp = /<img src="http:\/\/www.ipps.by:5454\/client-api\/image\/(?<id>\d+)">/g;
      const replaceContent = content.replace(regexp, (...match) => {
        let groups = match.pop();

        return `<app-image :id="${groups.id}" />`;
      });

      return replaceContent;
    },
    replaceYouTube(content) {
      // eslint-disable-next-line no-useless-escape
      const regexp = /<oembed url="(?<url>(?:http(s)?:\/\/)?[\w.-]+(?:\.[\w\.-]+)+[\w\-\._~:/?#[\]@!\$&'\(\)\*\+,;=.]+)"><\/oembed>/g;
      const replaceContent = content.replace(regexp, (...match) => {
        let groups = match.pop();
        this.videoId.set(groups.url, getIdFromURL(groups.url));

        return `<youtube
                  :video-id="videoId.get('${groups.url}')"
                  :player-width="playerWidth"
                  :player-height="playerHeight"
                />`;
      });

      return replaceContent;
    },
  },
};
</script>

<style lang="stylus">
.content-page {
  h2 {
    font-weight: 800;
    font-size: 1.75rem;
  }

  h3 {
    font-weight: 800;
    font-size: 1.5rem;
  }

  h4 {
    font-weight: 800;
    font-size: 1.25rem;
  }

  p, li {
    line-height: 1.572;
    text-align: left;
  }

  a {
    font-weight: 600;
    themify(
      $themes,
      @($theme) {
      color: $theme.$secondary--dark--color;
      text-decoration: $theme.$content--text--decoration;
    }
    );

    &:hover {
      themify(
        $themes,
        @($theme) {
        text-decoration: $theme.$content--text--decoration__hover;
      }
      );
    }
  }

  ul, ol {
    margin-left: 1.3rem;
    margin-top: -1.2rem;
  }

  ul {
    li:before {
      content: '\2022';
      font-weight: bold;
      display: inline-block;
      width: 1em;
      margin-left: -1em;
      themify(
        $themes,
        @($theme) {
        color: $theme.$secondary--dark--color;
      }
      );
    }
  }

  .image {
    width: 100%;
    overflow: hidden;

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      object-position: center center;
    }
  }

  .image, .media {
    margin-top: 3rem;
    margin-bottom: 3rem;
  }

  h2, h3, h4, p, ul, ol {
    margin-bottom: 1.5rem;
  }
}

@media (max-width: 480px) {
  .article-body {
    h2 {
      font-size: 1.5rem;
    }

    p, li {
      font-size: 14px;
    }

    ul, ol {
      margin-top: -0.6rem;
    }

    h2, p, ul, ol {
      margin-bottom: 0.75rem;
    }

    .image, .media {
      margin-top: 1.5rem;
      margin-bottom: 1.5rem;
    }
  }
}
</style>
