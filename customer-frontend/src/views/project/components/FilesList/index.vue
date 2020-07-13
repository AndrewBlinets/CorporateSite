<template>
  <v-list>
    <file-item
      v-for="document in documents"
      :id="document.id"
      :key="document.id"
      :fileName="document.fileName"
      :size="document.size"
      :date="document.dti"
    ></file-item>
  </v-list>
</template>

<script>
import { getDocumentsAllByProject } from '@/api/document';
import { mapState } from 'vuex';
import FileItem from './FileItem';

export default {
  name: 'FilesList',
  components: {
    FileItem,
  },
  data: () => ({
    documents: [],
  }),
  computed: {
    ...mapState('project', ['project']),
  },
  mounted() {
    getDocumentsAllByProject(this.project.id).then(documents => {
      this.documents = [...documents];
    });
  },
};
</script>
