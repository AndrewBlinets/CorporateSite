const path = require('path');

module.exports = {
  publicPath: '/',
  runtimeCompiler: true,
  devServer: {
    proxy: 'http://www.ipps.by:5454/',
  },
  outputDir: 'target/dist',
  assetsDir: 'static',
  chainWebpack: config => {
    const types = ['vue-modules', 'vue', 'normal-modules', 'normal'];
    types.forEach(type =>
      addStyleResource(config.module.rule('stylus').oneOf(type)),
    );
  },
};

function addStyleResource(rule) {
  rule
    .use('style-resource')
    .loader('style-resources-loader')
    .options({
      patterns: [path.resolve(__dirname, './src/styles/themes.styl')],
    });
}
