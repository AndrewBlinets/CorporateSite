module.exports = {
  transpileDependencies: ['vuetify'],
  publicPath: '/',
  devServer: {
    proxy:'http://www.ipps.by:8080'
  },
  runtimeCompiler: true,
  outputDir: 'target/dist',
  assetsDir: 'static'
};
