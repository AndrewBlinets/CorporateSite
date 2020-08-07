<template>
  <div>
    <p
      v-for="(item, index) of $t('views.e-appeal.description.entryList')"
      :key="index"
    >
      {{ item }}
    </p>
    <h5 class="mb-3">
      {{ $t('views.e-appeal.description.criteriaAppeal.title') }}
    </h5>
    <div class="list mb-3">
      <ul>
        <li
          v-for="(item, index) of $t(
            'views.e-appeal.description.criteriaAppeal.list',
          )"
          :key="index + 10"
        >
          {{ item }}
        </li>
      </ul>
    </div>

    <p
      v-for="(item, index) of $t('views.e-appeal.description.endList')"
      :key="index + 100"
    >
      {{ item }}
    </p>
  </div>
</template>

<script>
export default {
  name: 'Description',
};
</script>
