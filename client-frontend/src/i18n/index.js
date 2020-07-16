import Vue from 'vue';
import VueI18n from 'vue-i18n';

Vue.use(VueI18n);

import ru from '@/lang/ru';
import by from '@/lang/by';
import en from '@/lang/en';

export function createI18n(store, router) {
  const hasDocument = typeof document !== 'undefined';
  const loadedLanguages = [];
  const globalLanguages = {};

  const i18n = new VueI18n({
    locale: 'ru',
    fallbackLocale: 'ru',
    messages: { ru, by, en },
  });

  function setI18nLanguage(lang) {
    i18n.locale = lang;

    if (hasDocument) {
      document.querySelector('html').setAttribute('lang', lang);
    }

    return lang;
  }

  function loadLanguageAsync(lang) {
    if (!loadedLanguages.includes(lang)) {
      return import(`@/lang/${lang}`).then(msgs => {
        loadedLanguages.push(lang);
        globalLanguages[lang] = msgs.default;
        i18n.setLocaleMessage(lang, globalLanguages[lang]);

        return Promise.resolve(setI18nLanguage(lang));
      });
    }

    return Promise.resolve(setI18nLanguage(lang));
  }

  router.beforeEach((to, from, next) => {
    const storageString = localStorage.getItem('ipps-site') || '{}';
    const stateLocal = JSON.parse(storageString);

    if (Object.keys(stateLocal).length) {
      const { locale } = stateLocal;
      locale && store.dispatch('app/setLocale', locale);

      loadLanguageAsync(locale).then(() => next());
    } else {
      next();
    }
  });

  return i18n;
}
