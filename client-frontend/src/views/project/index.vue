<template>
  <div>
    <header-page :image="project.mainImage">
      <h1 class="project-title">{{ project.title }}</h1>
    </header-page>
    <div class="app-container my-3">
      <div class="row">
        <div class="col-12">
          <div class="project-body">
            <content-page
              v-if="contentWidth"
              v-resize="handleContent"
              :html="project.content"
              :width="contentWidth"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import store from '@/store';
import { mapState } from 'vuex';
import { Resize } from '@/directive/resize';
import HeaderPage from '@/components/HeaderPage';
import ContentPage from '@/components/ContentPage';

export default {
  name: 'Project',
  components: {
    HeaderPage,
    ContentPage,
  },
  directives: {
    Resize,
  },
  props: {
    id: {
      type: Number,
      default: 1,
    },
  },
  data: () => ({
    contentWidth: null,
  }),
  computed: {
    ...mapState({
      project: state => state.project.project,
    }),
  },
  beforeRouteEnter(to, from, next) {
    const { id } = to.params;
    store.dispatch('project/getProject', id).then(() => {
      next();
    });
  },
  beforeRouteUpdate(to, from, next) {
    const id = to.params.id;
    store.dispatch('project/getProject', id).then(() => {
      next();
    });
  },
  mounted() {
    this.handleContent();
  },
  destroyed() {
    store.dispatch('project/resetProject');
  },
  methods: {
    handleContent() {
      this.contentWidth = this.$el.querySelector('.project-body').clientWidth;
    },
  },
};
</script>

<style lang="stylus" scoped>
.project-title {
  margin-bottom: 1.5rem;
  line-height: 1.15;
}

.project-body {
  max-width: 900px;
  margin: 0 auto;
}

@media (max-width: 480px) {
  .project-title {
    font-size: 1.5rem;
  }
}

@media (min-width: 480px) {
  .project-title {
    font-size: 2.125rem;
  }
}

@media (min-width: 840px) {
  .project-title {
    font-size: 2.5rem;
  }
}
</style>
