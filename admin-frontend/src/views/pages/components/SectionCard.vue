<template>
  <el-card>
    <div slot="header">
      <el-row :gutter="30">
        <el-col :span="18">
          <div  v-if="!editName" class="title">
            <h3>{{ name }}</h3>
            <h5>{{ status  | pluralizationStatus}}</h5>
          </div>
          <div v-else>
            <el-input
              type="text"
              v-model="title"
              clearable
              maxlength="50"
              show-word-limit
              class="mb-1"
            />
            <el-select
              v-model="typeValue"
              clearable
              placeholder="Выбрать"
              size="mini"
            >
              <el-option
                v-for="item in typeOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              />
            </el-select>
          </div>
        </el-col>
        <el-col :span="5">
          <el-button
            v-if="editName"
            type="success"
            icon="el-icon-check"
            size="medium"
            circle
          />
          <el-button
            v-else
            icon="el-icon-edit"
            size="medium"
            circle
            @click="editName = true"
          />
          <el-button
            v-if="editName"
            icon="el-icon-close"
            size="medium"
            circle
            @click="editName = false"
          />
          <el-button
            v-else
            type="danger"
            icon="el-icon-delete"
            size="medium"
            circle
          />
        </el-col>
      </el-row>
    </div>
    <div class="card-body">
      <el-form
        label-width="150px"
        :label-position="'left'"
      >
        <el-form-item label="Тип секции">
          <el-select
            :value="type"
            clearable
            placeholder="Выбрать"
          >
            <el-option
              v-for="item in typeOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="Порядоковый номер">
          <el-input
            type="number"
            :value="index"
            placeholder="Please input"
          />
        </el-form-item>
      </el-form>
      
      <el-row type="flex" justify="center" class="mt-2">
        <el-col :span="6" >
          <el-button
            v-if="!id"
            type="success"
          >Сохранить</el-button>
          <el-button
            v-else
            type="primary"
            plain
          >Редактировать</el-button>
        </el-col>
      </el-row>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'SectionCard',
  props: {
    id: {
      type: Number,
      default: null
    },
    name: {
      type: String,
      default: 'Название секции'
    },
    type: {
      type: Number,
      default: 1
    },
    index: {
      type: Number,
      default: 1
    },
    status: {
      type: String,
      default: 'Черновик'
    }
  },
  data: () => ({
    typeOptions: [
      {
        value: 1,
        label: 'Текст'
      },
      {
        value: 2,
        label: 'Новости'
      },
      {
        value: 3,
        label: 'Ижображения'
      }
    ],
    typeValue: '',
    editName: false
  })
};
</script>


<style lang="stylus" scoped>
.title
  margin-bottom: 0
</style>