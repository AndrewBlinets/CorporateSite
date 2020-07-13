<template>
  <div class="row align-items-center">
    <div class="col">
      <div class="card">
        <app-image :id="17" :name="shortTitle" />
      </div>
    </div>
    <div class="col">
      <div class="card">
        <app-image :id="17" :name="shortTitle" />
      </div>
    </div>
    <div class="col">
      <div class="card">
        <app-image :id="17" :name="shortTitle" />
      </div>
    </div>
  </div>
</template>

<script>
import AppImage from '@/components/AppImage';

export default {
  name: 'Images',
  components: {
    AppImage,
  },
};
</script>
