const getters = {
  permissionRoutes: state => state.permission.routes,
  roles: state => state.user.roles,
  token: state => state.user.token,
  loading: state => state.app.loading
};

export default getters;