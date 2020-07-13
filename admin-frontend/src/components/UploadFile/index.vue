<template>
  <div>
    <el-upload
      action="#"
      :http-request="uploadFileServer"
      :file-list="fileList"
      list-type="picture-card"
      :auto-upload="true"
      :limit="1"
    >
      <i slot="default" class="el-icon-plus" />
      <div slot="file" slot-scope="{ file }" class="file">
        <img class="el-upload-list__item-thumbnail" :src="url" alt="" />
        <span class="el-upload-list__item-actions">
          <span
            class="el-upload-list__item-preview"
            @click="handlePictureCardPreview(file)"
          >
            <i class="el-icon-zoom-in" />
          </span>

          <span
            v-if="!disabled"
            class="el-upload-list__item-delete"
            @click="handleDownload(file)"
          >
            <i class="el-icon-download" />
          </span>

          <span
            v-if="!disabled"
            class="el-upload-list__item-delete"
            @click="handleRemove()"
          >
            <i class="el-icon-delete" />
          </span>
        </span>
      </div>
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="dialogImageUrl" alt="" />
    </el-dialog>
  </div>
</template>

<script>
import { getFile, uploadFile } from '@/api/file';

export default {
  name: 'UploadFile',

  props: {
    value: {
      type: Number,
    },
  },

  data: () => ({
    dialogImageUrl: '',
    dialogVisible: false,
    disabled: false,
  }),

  computed: {
    url() {
      return this.value ? getFile(this.value) : '';
    },
    fileList: {
      get: function () {
        const list = [];
        this.value && list.push({ name: this.value, url: getFile(this.value) });
        return list;
      },
      set: function (value) {
        this.$emit('input', value);
      },
    },
  },

  methods: {
    uploadFileServer(value) {
      const { file } = value;
      const formData = new FormData();
      formData.append('file', file);

      uploadFile(formData).then(id => {
        this.$emit('input', id);
      });
    },
    handleRemove() {
      this.$emit('input', null);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    handleDownload(file) {
      const link = document.createElement('a');
      link.href = file.url;
      link.click();
    },
  },
};
</script>

<style lang="stylus" scoped>
.file {
  width: 100%;
  height: 100%;

  .el-upload-list__item-thumbnail {
    object-fit: cover;
    object-position: center center;
  }
}
</style>
