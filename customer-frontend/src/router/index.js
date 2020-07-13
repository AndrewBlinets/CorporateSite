import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

import Layout from '@/layout';

export const constantRoutes = [
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard'),
        name: 'dashboard',
      },
      {
        path: 'settings',
        component: () => import('@/views/settings'),
        name: 'settings',
      },
      {
        path: 'projects',
        component: () => import('@/views/projects'),
        name: 'projects',
      },
      {
        path: 'projects/:id',
        component: () => import('@/views/project'),
        name: 'project-id',
        props: true,
      },
    ],
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/login'),
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/authRedirect'),
  },
];

export const asyncRoutes = [];

const createRouter = () =>
  new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes,
  });

const router = createRouter();

export function resetRouter() {
  const newRouter = createRouter();
  router.matcher = newRouter.matcher;
}

export default router;
