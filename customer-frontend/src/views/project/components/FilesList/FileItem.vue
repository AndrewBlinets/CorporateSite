<template>
  <v-list-item three-line>
    <v-list-item-avatar>
      <v-icon :class="[iconClass]">{{ icon }}</v-icon>
    </v-list-item-avatar>

    <v-list-item-content>
      <v-list-item-title>{{ fileName }}</v-list-item-title>

      <v-list-item-subtitle>
        {{ date | formatDate }}
      </v-list-item-subtitle>

      <v-list-item-subtitle>
        <span v-if="!loading">{{ fileSize }}</span>

        <v-progress-linear
          v-else
          color="primary"
          rounded
          height="6"
          :value="loaded"
        ></v-progress-linear>
      </v-list-item-subtitle>
    </v-list-item-content>

    <v-list-item-action>
      <v-btn icon @click="handleDownload">
        <v-icon color="grey lighten-1">mdi-download</v-icon>
      </v-btn>
    </v-list-item-action>
  </v-list-item>
</template>

<script>
import request from '@/utils/request';

export default {
  name: 'FileItem',
  props: {
    id: Number,
    fileName: String,
    size: Number,
    date: String,
  },
  data: () => ({
    icon: 'mdi-file',
    iconClass: 'blue white--text',
    multiples: ['К', 'М', 'Г'],
    loading: false,
    loaded: 0,
  }),
  computed: {
    fileSize() {
      let output = `${this.size} `;
      for (
        let multiple = 0, approx = this.size / 1024;
        approx > 1;
        approx /= 1024, multiple++
      ) {
        output = approx.toFixed(3) + ' ' + this.multiples[multiple];
      }

      return output + 'Байт';
    },
  },
  watch: {
    file() {
      console.log(2);
    },
  },
  methods: {
    handleDownload() {
      this.loading = true;
      request({
        url: `/document/download/${this.id}`,
        methods: 'GET',
        responseType: 'blob',
        onDownloadProgress: progressEvent => {
          const { loaded } = progressEvent;
          this.loaded = Math.round((loaded * 100) / this.size);
        },
      })
        .then(data => {
          const blob = new Blob([data]);
          const url = window.URL.createObjectURL(blob);
          const link = document.createElement('a');

          link.href = url;
          link.download = this.fileName;
          link.click();
          window.URL.revokeObjectURL(url);
          this.loading = false;
        })
        .catch(() => {
          this.loading = false;
        });
    },
  },
};
</script>
