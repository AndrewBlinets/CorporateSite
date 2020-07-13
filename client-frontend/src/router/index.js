import Vue from 'vue';
import Router from 'vue-router';
import store from '@/store';

Vue.use(Router);

import Layout from '@/layout';

export const constantRoutes = [
  {
    path: '/',
    component: Layout,
    children: [
      {
        path: '',
        name: 'home',
        component: () => import('@/views/home'),
      },
      {
        path: 'contacts',
        name: 'contacts',
        component: () => import('@/views/contacts'),
      },
      {
        path: 'news',
        name: 'news',
        component: () => import('@/views/news'),
      },
      {
        path: 'news/:id',
        name: 'article',
        component: () => import('@/views/article'),
      },
      {
        path: 'projects',
        name: 'projects',
        component: () => import('@/views/projects'),
      },
      {
        path: 'projects/:id',
        name: 'projectsById',
        component: () => import('@/views/project'),
      },
      {
        path: 'eastern-partnership',
        name: 'eastern-partnership',
        component: () => import('@/views/eastern-partnership'),
      },
      {
        path: 'technical-committee',
        name: 'technical-committee',
        component: () => import('@/views/technical-committee'),
      },
      {
        path: 'about-us',
        name: 'about-us',
        component: () => import('@/views/about-us'),
      },
      {
        path: 'electronic-appeal',
        name: 'electronic-appeal',
        component: () => import('@/views/electronic-appeal'),
      },
      {
        path: '404',
        name: '404',
        component: () => import('@/views/error-page/NotFound'),
      },
    ],
  },
  {
    path: '*',
    redirect: { name: 404 },
  },
];

const createRouter = () =>
  new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes,
  });

const router = createRouter();

router.beforeEach((to, from, next) => {
  const storageString = localStorage.getItem('ipps-site') || '{}';
  const stateLocal = JSON.parse(storageString);

  if (Object.keys(stateLocal).length) {
    const { theme, fontSize } = stateLocal;

    theme && store.dispatch('app/setThemeApp', theme);
    fontSize && store.dispatch('app/setFontSize', fontSize);
  }
  next();
});

export default router;
