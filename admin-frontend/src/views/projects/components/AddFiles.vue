<template>
  <el-upload
    action="#"
    :http-request="uploadFileServer"
    :on-remove="deleteFile"
    :file-list="fileList"
  >
    <el-button type="primary">Добавить файл</el-button>
  </el-upload>
</template>

<script>
import { uploadFile } from '@/api/file';
import {
  getDocumentsByProject,
  createDocumentByProject,
  deleteDocument,
} from '@/api/document';

export default {
  name: 'AddFiles',
  data: () => ({
    fileList: [],
  }),
  mounted() {
    this.getDocument();
  },
  methods: {
    getDocument() {
      const { id } = this.$route.params;
      getDocumentsByProject(id).then(data => {
        this.fileList = [
          ...data.map(item => ({ id: item.id, name: item.fileName })),
        ];
      });
    },
    uploadFileServer(value) {
      const { file } = value;
      const formData = new FormData();
      const projectId = this.$route.params.id;
      formData.append('file', file);

      uploadFile(formData).then(id => {
        createDocumentByProject({
          fileManager: { id },
          project: { id: projectId },
        }).then(() => {
          this.$message({
            type: 'success',
            message: 'Файл добавлен',
          });
        });
      });
    },
    deleteFile(file) {
      const { id } = file;
      deleteDocument(id).then(() => {
        this.$message({
          type: 'success',
          message: 'Файл удалён',
        });
      });
    },
  },
};
</script>
