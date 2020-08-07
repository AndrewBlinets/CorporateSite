const requireLang = require.context('./', true, /\.json$/);

const messages = {};

for (const file of requireLang.keys()) {
  const path = file.replace(/(\.\/|\.json$)/g, '').split('/');

  path.reduce((object, prop, index) => {
    object[prop] =
      index + 1 === path.length ? requireLang(file) : object[prop] || {};

    return object[prop];
  }, messages);
}

export default messages;
