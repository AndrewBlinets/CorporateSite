(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a4a48b5c"],{"0069":function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"contact__info"},t._l(t.contactInfo,(function(e,a){return n("contact-info-item",t._b({key:a},"contact-info-item",e,!1))})),1)},r=[],i=n("c074"),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"contact__info-item"},[n("font-awesome-icon",{staticClass:"icon",attrs:{icon:t.icon}}),n("span",{staticClass:"info-item-title"},[t._v(t._s(t.title))]),n("span",[t._v(": "+t._s(t.value))])],1)},s=[],c={name:"ContactInfoItem",props:{icon:Object,title:String,value:String}},l=c,u=(n("bb0d"),n("2877")),d=Object(u["a"])(l,o,s,!1,null,"60a7a79d",null),p=d.exports,m={name:"ContactInfoList",components:{ContactInfoItem:p},props:{address:String,room:String,phone:String,email:String},computed:{contactInfo:function(){var t=[];return this.address&&t.push({icon:i["g"],title:"Адрес",value:this.address}),this.room&&t.push({icon:i["g"],title:"Кабинет",value:"№".concat(this.room)}),this.phone&&t.push({icon:i["h"],title:"Телефон",value:this.phone}),this.email&&t.push({icon:i["f"],title:"Email",value:this.email}),t}}},f=m,h=(n("d68b"),Object(u["a"])(f,a,r,!1,null,"376ddf08",null));e["a"]=h.exports},"033e":function(t,e,n){},"06c5":function(t,e,n){"use strict";n.d(e,"a",(function(){return r}));var a=n("6b75");function r(t,e){if(t){if("string"===typeof t)return Object(a["a"])(t,e);var n=Object.prototype.toString.call(t).slice(8,-1);return"Object"===n&&t.constructor&&(n=t.constructor.name),"Map"===n||"Set"===n?Array.from(t):"Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)?Object(a["a"])(t,e):void 0}}},"08f1":function(t,e,n){"use strict";var a=n("3209"),r=n.n(a);r.a},1308:function(t,e,n){"use strict";var a=n("7b29"),r=n.n(a);r.a},"25a3":function(t,e,n){},2909:function(t,e,n){"use strict";n.d(e,"a",(function(){return c}));var a=n("6b75");function r(t){if(Array.isArray(t))return Object(a["a"])(t)}function i(t){if("undefined"!==typeof Symbol&&Symbol.iterator in Object(t))return Array.from(t)}var o=n("06c5");function s(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}function c(t){return r(t)||i(t)||Object(o["a"])(t)||s()}},2936:function(t,e,n){"use strict";var a=n("37bd"),r=n.n(a);r.a},"2ba0":function(t,e,n){},3209:function(t,e,n){},"34cb":function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("router-link",{staticClass:"news-card",attrs:{to:{path:"/news/"+t.id},tag:"div"}},[n("div",{staticClass:"news-title",style:{height:t.height}},[n("div",{staticClass:"image"},[n("app-image",{attrs:{id:t.image,name:t.title}})],1),n("div",{staticClass:"title-details"},[n("news-details",{attrs:{date:t.datePublish,shadow:""}})],1),n("h5",{staticClass:"title"},[t._v(t._s(t.title))])]),t.text?n("div",{staticClass:"news-text"},[t._v(t._s(t.text))]):t._e()])},r=[],i=(n("c5f6"),n("11d3")),o=n("6cb5"),s={name:"CardNews",components:{AppImage:i["default"],NewsDetails:o["a"]},props:{id:Number,title:String,views:Number,datePublish:String,height:{type:String,default:"200px"},image:{type:Number,default:15},text:{type:String,default:""}}},c=s,l=(n("86a7"),n("2877")),u=Object(l["a"])(c,a,r,!1,null,null,null);e["a"]=u.exports},"355a":function(t,e,n){"use strict";var a=n("b603"),r=n.n(a);r.a},"37bd":function(t,e,n){},"413e":function(t,e,n){},"512e":function(t,e,n){"use strict";var a=n("25a3"),r=n.n(a);r.a},5393:function(t,e,n){"use strict";var a=n("033e"),r=n.n(a);r.a},"58fd":function(t,e,n){},"5a64":function(t,e,n){"use strict";var a=n("a423"),r=n.n(a);r.a},"5ae8":function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[t._t("default")],2)},r=[],i={name:"Contact"},o=i,s=n("2877"),c=Object(s["a"])(o,a,r,!1,null,null,null);e["a"]=c.exports},"6b75":function(t,e,n){"use strict";function a(t,e){(null==e||e>t.length)&&(e=t.length);for(var n=0,a=new Array(e);n<e;n++)a[n]=t[n];return a}n.d(e,"a",(function(){return a}))},"6cb5":function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"details-container"},[t.views?n("div",{staticClass:"views-block"},[n("font-awesome-icon",{attrs:{icon:["fas","eye"]}}),n("span",[t._v(t._s(t.views))])],1):t._e(),n("div",{staticClass:"publish-date"},[n("span",{class:{"text--shadow":t.shadow}},[t._v(t._s(t._f("formatDate")(t.date)))])])])},r=[],i=(n("c5f6"),{name:"NewsDetails",props:{views:{type:Number,default:0},date:String,shadow:{type:Boolean,default:!1}}}),o=i,s=(n("512e"),n("2877")),c=Object(s["a"])(o,a,r,!1,null,"a63cb8d2",null);e["a"]=c.exports},"7abe":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("div",{staticClass:"main-banner"},[n("div",{staticClass:"banner-image"},[n("app-image",{attrs:{id:18}})],1),n("div",{staticClass:"app-container grid grid-header"},[n("div",{staticClass:"banner-content"},[n("h4",[t._v("НИРУП")]),n("h1",[t._v("Институт прикладных программных систем")]),n("p",[t._v(" Современная, динамично развивающаяся компания в области научно-методического обеспечения процессов развития информатизации, бизнес-анализа, создания информационных систем электронного правительства и предоставления услуг в области IT. ")]),n("social-links")],1)])]),n("about-us"),n("activities"),n("counter-area"),n("news"),n("projects"),n("partners"),n("contacts")],1)},r=[],i=n("11d3"),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{attrs:{id:"about-us"}},[n("div",{staticClass:"app-container grid-area"},[t._m(0),n("div",{staticClass:"section-body"},[t._m(1),n("div",{staticClass:"button-container"},[n("div",{staticClass:"button-item"},[n("router-link",{staticClass:"btn btn-main",attrs:{to:{name:"about-us"}}},[t._v(" Подробнее ")])],1)])])])])},s=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"section-header"},[n("h2",[t._v("О Нас")])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"row align-items-center mb-5"},[n("div",{staticClass:"col"},[n("div",{staticClass:"information"},[n("p",[t._v(" Большинство разработанных НИРУП «ИППС» продуктов относятся к глобальным, эффективно применяемым на общегосударственном уровне. ")]),n("p",[t._v(" Предприятие выполняет заказы более 300 организаций, органов государственного управления, учреждений и предприятий в Республике Беларусь и Российской Федерации. ")]),n("p",[t._v(" Мы предлагаем сотрудничество по разработке программного обеспечения, созданию корпоративных систем, автоматизации бухгалтерского учета непроизводственной сферы, комплексной автоматизации органов государственного управления и других структур. ")])])]),n("div",{staticClass:"col-12 col-sm-6 mt-sm-0 mt-5"},[n("div",{staticClass:"information-statistic"},[n("h4",[t._v(" Наша миссия - способствовать развитию информационного общества Республики Беларусь для обеспечения взаимодействия населения, государства и бизнеса на базе информационных технологий ")])])])])}],c={name:"AboutUs"},l=c,u=(n("2936"),n("2877")),d=Object(u["a"])(l,o,s,!1,null,"6bd9e98b",null),p=d.exports,m=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"bgr-grey",attrs:{id:"activities"}},[n("div",{staticClass:"app-container grid-area"},[t._m(0),n("div",{staticClass:"section-body"},[n("div",{staticClass:"services-container"},[n("div",{staticClass:"services-img"},[n("app-image",{attrs:{id:143,name:"направления-деятельности"}})],1),n("div",{staticClass:"row no-gutters"},t._l(t.activities,(function(e,a){return n("div",{key:a,staticClass:"col"},[n("div",{staticClass:"service-item"},[n("h5",[t._v(t._s(e))])])])})),0)])])])])},f=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"section-header"},[n("h2",[t._v("Направления Деятельности")])])}],h={name:"Activities",components:{AppImage:i["default"]},data:function(){return{activities:["Анализ, проектирование и программное обеспечение информационных систем","Обработка данных с применением ПО третьего лица или собственного ПО","Фундаментальные и прикладные исследования, экспериментальные разработки в области естественных и технических наук","Техническая и (или) криптографическая защита информации","Анализ информационных потребностей юридических лиц и индивидуальных предпринимателей","Консультирование по вопросам использования информационных технологий в целях инновации бизнес-процессов","Оказание автоматизированных услуг по поиску, отбору, обработке и сортировке данных","Услуги центров обработки данных"]}}},b=h,v=(n("e713"),Object(u["a"])(b,m,f,!1,null,"35baa7dd",null)),y=v.exports,g=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{attrs:{id:"contacts"}},[n("div",{staticClass:"app-container grid-area"},[t._m(0),n("div",{staticClass:"section-body"},[n("div",{staticClass:"row"},[n("div",{staticClass:"col-lg-6 col-12 mb-lg-0 mb-5"},[n("contact",[n("contact-info-list",{attrs:{address:"220013 г. Минск, ул.Беломорская, 18",phone:"(8-017) 290-07-66",email:"info@ipps.by"}}),n("contact-note",[n("p",[t._v("Телефон «горячей линии» - (8-017) 290-07-66")]),n("div",{staticClass:"list"},[n("div",{staticClass:"header"},[n("p",[t._v("По номеру «горячей линии» можно обратиться:")])]),n("ul",[n("li",[t._v(" по вопросам справочно-консультационного характера, связанного с направлениями деятельности организации; ")]),n("li",[t._v(" по вопросам выявления фактов вымогательства, взяточничества и других проявлений коррупции со стороны работников организации; ")]),n("li",[t._v(" по вопросам записи на личный прием к руководству организации. ")])])]),n("div",{staticClass:"list"},[n("div",{staticClass:"header"},[n("p",[t._v("Режим работы горячей линии:")])]),n("ul",[n("li",[t._v("понедельник – четверг: с 9-00 до 18-00;")]),n("li",[t._v("обеденный перерыв: с 13-00 до 13-45;")]),n("li",[t._v("пятница: с 9-00 до 16-20;")]),n("li",[t._v("обеденный перерыв: с 13-00 до 13-20;")]),n("li",[t._v("выходной: суббота, воскресенье.")])])])])],1)],1),n("div",{staticClass:"col-lg-6 col-12 d-flex align-items-center"},[n("yandex-map",{attrs:{settings:t.settings,coords:[53.924555,27.588861],controls:["zoomControl"],zoom:"17"}},[n("ymap-marker",{attrs:{"marker-id":"123","marker-type":"Placemark",coords:[53.924555,27.588859]}})],1)],1)])])])])},C=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"section-header"},[n("h2",[t._v("Контакты")])])}];function O(t){return(O="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}function k(t,e){for(var n=0;n<e.length;n++){var a=e[n];a.enumerable=a.enumerable||!1,a.configurable=!0,"value"in a&&(a.writable=!0),Object.defineProperty(t,a.key,a)}}function j(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function _(t){return function(t){if(Array.isArray(t)){for(var e=0,n=new Array(t.length);e<t.length;e++)n[e]=t[e];return n}}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance")}()}function w(t,e){var n=e.options,a=e.callbacks,r=e.map,i=e.useObjectManager,o=e.objectManagerClusterize,s={},c=[];if(t.forEach((function(t){t.clusterName?s[t.clusterName]=s[t.clusterName]?[].concat(_(s[t.clusterName]),[t]):[t]:c.push(t)})),Object.keys(s).forEach((function(t){var e=n[t]||{},c=a[t]||{},l=e.layout||"\n      <div>{{ properties.balloonContentHeader }}</div>\n      <div>{{ properties.balloonContentBody }}</div>\n      <div>{{ properties.balloonContentFooter }}</div>\n    ";e.clusterBalloonItemContentLayout=ymaps.templateLayoutFactory.createClass(l);var u=e.clusterBalloonLayout||e.clusterLayout;delete e.clusterBalloonLayout;var d=u?ymaps.templateLayoutFactory.createClass(u):e.clusterBalloonContentLayout||"cluster#balloonTwoColumns";e.clusterBalloonContentLayout=d;var p=e.clusterIconContentLayout;if(e.clusterIconContentLayout=p&&ymaps.templateLayoutFactory.createClass(p),i){var m=new ymaps.ObjectManager(Object.assign({clusterize:o},e));Object.keys(c).forEach((function(t){m.clusters.events.add(t,c[t])})),m.add(s[t]),r.geoObjects.add(m)}else{var f=new ymaps.Clusterer(e);Object.keys(c).forEach((function(t){f.events.add(t,c[t])})),e.createCluster&&(f.createCluster=e.createCluster),f.add(s[t]),r.geoObjects.add(f)}})),c.length){var l=i?new ymaps.ObjectManager({clusterize:!1}):new ymaps.GeoObjectCollection;c.forEach((function(t){return l.add(t)})),r.geoObjects.add(l)}}function M(t){return t.charAt(0).toUpperCase()+t.slice(1)}function S(t){return(t.icon.color||"blue")+(t.icon.glyph?M(t.icon.glyph):t.icon.content?"Stretchy":"")}function I(t){return t.map((function(t){return Array.isArray(t)?I(t):+t}))}function $(t,e){var n=[];return function t(e,a){if(e===a)return!0;if(e instanceof Date&&a instanceof Date)return+e==+a;if("object"!==O(e)||"object"!==O(a))return!1;if(function(t,e){for(var a=n.length;a--;)if(!(n[a][0]!==t&&n[a][0]!==e||n[a][1]!==e&&n[a][1]!==t))return!0;return!1}(e,a))return!0;n.push([e,a]);var r=Object.keys(e),i=r.length;if(Object.keys(a).length!==i)return!1;for(;i--;)if(!t(e[r[i]],a[r[i]]))return!1;return!0}(t,e)}var E=new(function(){function t(){!function(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}(this,t),this.events={},this.ymapReady=!1,this.scriptIsNotAttached=!0}var e,n,a;return e=t,(n=[{key:"$on",value:function(t,e){var n=this;return this.events[t]||(this.events[t]=[]),this.events[t].push(e),function(){n.events[t]=n.events[t].filter((function(t){return e!==t}))}}},{key:"$emit",value:function(t,e){var n=this.events[t];n&&n.forEach((function(t){return t(e)}))}}])&&k(e.prototype,n),a&&k(e,a),t}()),A=["fullscreenControl","geolocationControl","routeEditor","rulerControl","searchControl","trafficControl","typeSelector","zoomControl","routePanelControl"];function x(t){return 0===t.filter((function(t){return![].concat(A,["default"]).includes(t)})).length}function L(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{};return new Promise((function(e,n){if(window.ymaps||document.getElementById("vue-yandex-maps"))return e();var a=document.createElement("SCRIPT"),r=t.apiKey,i=void 0===r?"":r,o=t.lang,s=void 0===o?"ru_RU":o,c=t.version,l=void 0===c?"2.1":c,u=t.coordorder,d=void 0===u?"latlong":u,p=t.debug,m=void 0!==p&&p?"debug":"release",f="lang=".concat(s).concat(i&&"&apikey=".concat(i),"&mode=").concat(m,"&coordorder=").concat(d),h="https://api-maps.yandex.ru/".concat(l,"/?").concat(f);a.setAttribute("src",h),a.setAttribute("async",""),a.setAttribute("defer",""),a.setAttribute("id","vue-yandex-maps"),document.head.appendChild(a),E.scriptIsNotAttached=!1,a.onload=function(){ymaps.ready((function(){E.ymapReady=!0,E.$emit("scriptIsLoaded"),e()}))},a.onerror=n}))}var P=E,N=["actionend","balloonclose","balloonopen","click","contextmenu","dblclick","destroy","hintclose","hintopen","optionschange","sizechange","typechange"],T={pluginOptions:{},provide:function(){var t,e,n=this,a=[],r=[];return{useObjectManager:this.useObjectManager,addMarker:this.addMarker,deleteMarker:function(e){n.myMap.geoObjects&&(a.push(e),t&&clearTimeout(t),t=setTimeout((function(){n.deleteMarkers(a),a=[]}),0))},compareValues:function(t){var a=t.newVal,i=t.oldVal,o=t.marker;$(a,i)||(r.push(o),e&&clearTimeout(e),e=setTimeout((function(){n.setMarkers(r),r=[]}),0))}}},data:function(){return{ymapId:"yandexMap".concat(Math.round(1e5*Math.random())),myMap:{},style:this.ymapClass?"":"width: 100%; height: 100%;",isReady:!1,debounce:null,markers:[]}},props:{coords:{type:Array,required:!0},zoom:{validator:function(t){return!Number.isNaN(t)},default:18},bounds:Array,clusterOptions:{type:Object,default:function(){return{}}},clusterCallbacks:{type:Object,default:function(){return{}}},behaviors:{type:Array,default:function(){return["default"]}},controls:{type:Array,default:function(){return["default"]},validator:function(t){return x(t)}},detailedControls:{type:Object,validator:function(t){return x(Object.keys(t))}},scrollZoom:{type:Boolean,default:!0},mapType:{type:String,default:"map",validator:function(t){return["map","satellite","hybrid"].includes(t)}},placemarks:{type:Array,default:function(){return[]}},useObjectManager:{type:Boolean,default:!1},objectManagerClusterize:{type:Boolean,default:!0},ymapClass:String,initWithoutMarkers:{type:Boolean,default:!0},debug:{type:Boolean,default:!1},settings:{type:Object,default:function(){return{}}},options:{type:Object,default:function(){return{}}},showAllMarkers:Boolean},computed:{coordinates:function(){return this.coords.map((function(t){return+t}))}},methods:{init:function(){var t=this;window.ymaps&&ymaps.GeoObjectCollection&&(this.initWithoutMarkers||this.$slots.default||this.placemarks.length)&&(this.$emit("map-initialization-started"),this.myMap=new ymaps.Map(this.ymapId,{center:this.coordinates,zoom:+this.zoom,bounds:this.bounds,behaviors:this.behaviors,controls:this.controls,type:"yandex#".concat(this.mapType)},this.options),N.forEach((function(e){return t.myMap.events.add(e,(function(n){return t.$emit(e,n)}))})),this.myMap.events.add("boundschange",(function(e){var n=e.originalEvent,a=n.newZoom,r=n.newCenter,i=n.newBounds;t.$emit("boundschange",e),t.$emit("update:zoom",a),t.$emit("update:coords",r),t.$emit("update:bounds",i)})),this.detailedControls&&Object.keys(this.detailedControls).forEach((function(e){t.myMap.controls.remove(e),t.myMap.controls.add(e,t.detailedControls[e])})),!1===this.scrollZoom&&this.myMap.behaviors.disable("scrollZoom"),this.isReady=!0,this.$emit("map-was-initialized",this.myMap))},addMarker:function(t){var e=this;this.markers.push(t),this.debounce&&clearTimeout(this.debounce),this.debounce=setTimeout((function(){e.setMarkers(e.markers)}),0)},setMarkers:function(t){var e=this,n={options:this.clusterOptions,callbacks:this.clusterCallbacks,map:this.myMap,useObjectManager:this.useObjectManager,objectManagerClusterize:this.objectManagerClusterize};if(this.markers!==t){var a=t.map((function(t){return e.useObjectManager?t.id:t.properties.get("markerId")}));this.deleteMarkers(a),w(t,n),this.$emit("markers-was-change",a)}else w(t,n);this.markers=[],this.showAllMarkers&&this.myMap.setBounds(this.myMap.geoObjects.getBounds())},deleteMarkers:function(t){var e=this;this.myMap.geoObjects.each((function(n){var a=[];if(e.useObjectManager)n.remove(t);else{var r,i=function(e){var n=e.properties.get("markerId");t.includes(n)&&a.push(e)};if(n.each)n.each(i),r=n.getLength();else if(n.getGeoObjects){var o=n.getGeoObjects();o.forEach(i),r=o.length}0===r||r===a.length?e.myMap.geoObjects.remove(n):a.length&&a.forEach((function(t){return n.remove(t)}))}})),this.$emit("markers-was-delete",t)}},watch:{coordinates:function(t){this.myMap.panTo&&this.myMap.getZoom()&&this.myMap.panTo(t)},zoom:function(){this.myMap.setZoom(this.zoom)},bounds:function(t){this.myMap.setBounds&&this.myMap.setBounds(t)}},render:function(t){return t("section",{class:"ymap-container",ref:"mapContainer"},[t("div",{attrs:{id:this.ymapId,class:this.ymapClass,style:this.style}}),this.isReady&&t("div",{ref:"markersContainer",attrs:{class:"ymap-markers"}},[this.$slots.default])])},mounted:function(){var t=this;if(this.$attrs["map-link"]||this.$attrs.mapLink)throw new Error("Vue-yandex-maps: Attribute mapLink is not supported. Use settings.");if(this.placemarks&&this.placemarks.length)throw new Error("Vue-yandex-maps: Attribute placemarks is not supported. Use marker component.");this.mapObserver=new MutationObserver((function(){t.myMap.container&&t.myMap.container.fitToViewport()}));var e=this.$refs.mapContainer;if(this.mapObserver.observe(e,{attributes:!0,childList:!0,characterData:!0,subtree:!1}),P.scriptIsNotAttached){var n=this.debug;L(function(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{},a=Object.keys(n);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(n).filter((function(t){return Object.getOwnPropertyDescriptor(n,t).enumerable})))),a.forEach((function(e){j(t,e,n[e])}))}return t}({},this.$options.pluginOptions,this.settings,{debug:n}))}P.ymapReady?ymaps.ready(this.init):P.$on("scriptIsLoaded",(function(){ymaps.ready(t.init)}))},beforeDestroy:function(){this.myMap.geoObjects&&this.myMap.geoObjects.removeAll()}},z=["placemark","polyline","rectangle","polygon","circle"],F=["balloonclose","balloonopen","click","contextmenu","dblclick","drag","dragend","dragstart","hintclose","hintopen","mouseenter","mouseleave"],B={inject:["useObjectManager","addMarker","deleteMarker","compareValues"],props:{coords:Array,hintContent:String,icon:Object,balloon:Object,markerType:{type:String,validator:function(t){return z.includes(t.toLowerCase())},default:"placemark"},markerFill:Object,markerStroke:Object,clusterName:[String,Number],circleRadius:{validator:function(t){return!Number.isNaN(t)},default:1e3},balloonTemplate:String,markerId:{type:[String,Number],required:!0},properties:Object,options:Object},data:function(){return{unwatchArr:[]}},render:function(t){return this.$slots.balloon&&t("div",{style:"display: none;"},[this.$slots.balloon])},mounted:function(){var t=this;Object.keys(this.$props).forEach((function(e){t.unwatchArr.push(t.$watch(e,(function(e,n){return t.compareValues({newVal:e,oldVal:n,marker:t.defineMarker()})})))})),this.addMarker(this.defineMarker())},methods:{defineMarker:function(){var t=this,e={};this.balloonTemplate&&(e={balloonContentLayout:ymaps.templateLayoutFactory.createClass(this.balloonTemplate)}),this.$slots.balloon&&(e={balloonContentLayout:ymaps.templateLayoutFactory.createClass(this.$slots.balloon[0].elm.outerHTML)});var n={markerId:this.markerId,markerType:this.markerType||"placemark",coords:I(this.coords),hintContent:this.hintContent,markerFill:this.markerFill,circleRadius:+this.circleRadius,clusterName:this.clusterName,markerStroke:this.markerStroke,balloon:this.balloon,properties:this.properties,options:this.options,balloonOptions:e};this.icon&&["default#image","default#imageWithContent"].includes(this.icon.layout)?(n.iconContent=this.icon.content,n.iconLayout=this.icon.layout,n.iconImageHref=this.icon.imageHref,n.iconImageSize=this.icon.imageSize,n.iconImageOffset=this.icon.imageOffset,n.iconContentOffset=this.icon.contentOffset,this.icon.contentLayout&&"string"==typeof this.icon.contentLayout&&(n.iconContentLayout=ymaps.templateLayoutFactory.createClass(this.icon.contentLayout))):n.icon=this.icon;var a=function(t,e){var n=M(t);if(!e)return n;switch(n){case"Placemark":return"Point";case"Polyline":return"LineString";default:return n}}(n.markerType,this.useObjectManager),r={hintContent:n.hintContent,iconContent:n.icon?n.icon.content:n.iconContent,markerId:n.markerId},i=n.balloon?{balloonContentHeader:n.balloon.header,balloonContentBody:n.balloon.body,balloonContentFooter:n.balloon.footer}:{},o=Object.assign(r,i,n.properties),s=n.iconLayout?{iconLayout:n.iconLayout,iconImageHref:n.iconImageHref,iconImageSize:n.iconImageSize,iconImageOffset:n.iconImageOffset,iconContentOffset:n.iconContentOffset,iconContentLayout:n.iconContentLayout}:{preset:n.icon&&"islands#".concat(S(n),"Icon")},c=n.markerStroke?{strokeColor:n.markerStroke.color||"0066ffff",strokeOpacity:parseFloat(n.markerStroke.opacity)>=0?parseFloat(n.markerStroke.opacity):1,strokeStyle:n.markerStroke.style,strokeWidth:parseFloat(n.markerStroke.width)>=0?parseFloat(n.markerStroke.width):1}:{},l=n.markerFill?{fill:n.markerFill.enabled||!0,fillColor:n.markerFill.color||"0066ff99",fillOpacity:parseFloat(n.markerFill.opacity)>=0?parseFloat(n.markerFill.opacity):1,fillImageHref:n.markerFill.imageHref||""}:{},u=Object.assign(s,c,l,n.balloonOptions,n.options);"Circle"===a&&(n.coords=[n.coords,n.circleRadius]);var d=function(t,e){var n=e?{type:"Feature",id:t.properties.markerId,geometry:{type:t.markerType,coordinates:t.coords},properties:t.properties,options:t.options}:new ymaps[t.markerType](t.coords,t.properties,t.options);return n.clusterName=t.clusterName,n}({properties:o,options:u,markerType:a,coords:n.coords,clusterName:n.clusterName},this.useObjectManager,this.$emit);return this.useObjectManager||F.forEach((function(e){return d.events.add(e,(function(n){return t.$emit(e,n)}))})),d}},beforeDestroy:function(){this.unwatchArr.forEach((function(t){return t()})),this.deleteMarker(this.markerId)}};T.install=function t(e){var n=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};t.installed||(t.installed=!0,T.pluginOptions=n,e.component("yandex-map",T),e.component("ymap-marker",B))},"undefined"!=typeof window&&window.Vue&&window.Vue.use(T);var D=T,R=B,V=n("5ae8"),H=n("0069"),U=n("c8f8"),Z={name:"Contacts",components:{Contact:V["a"],ContactInfoList:H["a"],ContactNote:U["a"],yandexMap:D,ymapMarker:R},data:function(){return{settings:{lang:"ru_RU",coordorder:"latlong",version:"2.1"}}}},G=Z,W=(n("5393"),Object(u["a"])(G,g,C,!1,null,"35c9f444",null)),q=W.exports,J=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"section-padding",attrs:{id:"counter-area"}},[n("div",{staticClass:"banner-img"},[n("app-image",{attrs:{id:18}})],1),n("div",{staticClass:"app-container counter-area__content"},[n("div",{staticClass:"row"},t._l(t.counters,(function(e,a){return n("div",{key:a,staticClass:"col"},[n("div",{staticClass:"single-counter"},[n("div",{staticClass:"icon"},[n("font-awesome-icon",{attrs:{icon:e.icon,size:"2x"}})],1),n("span",{staticClass:"counter"},[t._v(t._s(e.count))]),n("h5",[t._v(t._s(e.title))])])])})),0)])])},K=[],Q=n("c074"),X={name:"CounterArea",components:{AppImage:i["default"]},data:function(){return{counters:[{icon:Q["j"],count:"300+",title:"Клиентов"},{icon:Q["b"],count:"100+",title:"Проектов"},{icon:Q["d"],count:"40+",title:"Лет на рынке"}]}}},Y=X,tt=(n("355a"),Object(u["a"])(Y,J,K,!1,null,"0dc69faf",null)),et=tt.exports,nt=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{attrs:{id:"news"}},[n("div",{staticClass:"app-container grid-area"},[t._m(0),n("div",{staticClass:"section-body"},[n("div",{staticClass:"row mx-md-n4"},t._l(t.newsList,(function(t){return n("div",{key:t.id,staticClass:"col-lg-4 col-sm-6 px-md-4 mb-5"},[n("news-card",{attrs:{id:t.id,heightTitle:250,image:t.mainImage,title:t.shortTitle,views:t.countView,datePublish:t.datePublic,text:t.entrySpeech}})],1)})),0),n("div",{staticClass:"button-container"},[n("div",{staticClass:"button-item"},[n("router-link",{staticClass:"btn btn-main",attrs:{to:{name:"news"}}},[t._v(" Все Новости ")])],1)])])])])},at=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"section-header"},[n("h2",[t._v("Новости")])])}],rt=(n("8e6e"),n("ac6a"),n("456d"),n("ade3")),it=n("2f62"),ot=n("34cb");function st(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,a)}return n}function ct(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?st(Object(n),!0).forEach((function(e){Object(rt["a"])(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):st(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}var lt={name:"News",components:{NewsCard:ot["a"]},computed:ct({},Object(it["d"])("news",["newsList"])),mounted:function(){this.$store.dispatch("news/getNews",{size:3,page:0})}},ut=lt,dt=Object(u["a"])(ut,nt,at,!1,null,null,null),pt=dt.exports,mt=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{attrs:{id:"partners"}},[n("div",{staticClass:"partners-img"},[n("app-image",{attrs:{id:21,name:"Партнёры"}})],1),n("div",{staticClass:"app-container grid-area"},[t._m(0),n("div",{staticClass:"section-body"},[n("div",{staticClass:"partners-container mx-n3"},t._l(t.partners,(function(t){return n("div",{key:t.id,staticClass:"px-3 mb-4"},[n("div",{staticClass:"partner-item"},[n("app-image",{staticClass:"img",attrs:{id:t.image,name:t.name,backgroundColor:"#ffffff00"}})],1)])})),0)])])])},ft=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"section-header"},[n("h2",[t._v("Партнеры")])])}],ht=n("2909"),bt=n("b775");function vt(){return Object(bt["a"])({url:"/partners",method:"get"})}var yt={name:"Partners",components:{AppImage:i["default"]},data:function(){return{partners:[]}},mounted:function(){var t=this;vt().then((function(e){t.partners=Object(ht["a"])(e)}))}},gt=yt,Ct=(n("5a64"),Object(u["a"])(gt,mt,ft,!1,null,"594962cf",null)),Ot=Ct.exports,kt=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"bgr-grey",attrs:{id:"projects"}},[n("div",{staticClass:"grid-area"},[t._m(0),n("div",{staticClass:"section-body"},[n("div",{staticClass:"app-container"},[n("div",{staticClass:"row mx-md-n4"},t._l(t.projects,(function(t){return n("div",{key:t.id,staticClass:"col-lg-4 col-sm-6 px-md-4 mb-5"},[n("project-card",{attrs:{id:t.id,title:t.shortTitle,image:t.mainImage}})],1)})),0),n("div",{staticClass:"button-container"},[n("div",{staticClass:"button-item"},[n("router-link",{staticClass:"btn btn-main",attrs:{to:{name:"projects"}}},[t._v(" Все Проекты ")])],1)])])])])])},jt=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"section-header"},[n("div",{staticClass:"app-container"},[n("h2",[t._v("Проекты")])])])}],_t=n("a6fe");function wt(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,a)}return n}function Mt(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?wt(Object(n),!0).forEach((function(e){Object(rt["a"])(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):wt(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}var St={name:"Projects",components:{ProjectCard:_t["a"]},computed:Mt({},Object(it["d"])({projects:function(t){return t.project.projectsList}})),created:function(){this.$store.dispatch("project/getProjects",{size:3,page:0})}},It=St,$t=(n("08f1"),Object(u["a"])(It,kt,jt,!1,null,"63b739aa",null)),Et=$t.exports,At=n("943b"),xt={name:"Home",components:{AppImage:i["default"],AboutUs:p,Activities:y,Contacts:q,CounterArea:et,News:pt,Partners:Ot,Projects:Et,SocialLinks:At["a"]}},Lt=xt,Pt=(n("c3ac"),Object(u["a"])(Lt,a,r,!1,null,"25f73d6e",null));e["default"]=Pt.exports},"7b29":function(t,e,n){},"86a7":function(t,e,n){"use strict";var a=n("a7e6"),r=n.n(a);r.a},9203:function(t,e,n){"use strict";var a=n("e3f1"),r=n.n(a);r.a},a423:function(t,e,n){},a6fe:function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("router-link",{staticClass:"project-card",style:{height:t.height},attrs:{to:{path:"/projects/"+t.id},tag:"div"}},[n("div",{staticClass:"image"},[n("app-image",{attrs:{id:t.image,name:t.title}})],1),n("div",{staticClass:"project-title"},[n("h5",{staticClass:"title"},[t._v(t._s(t.title))])])])},r=[],i=(n("c5f6"),n("11d3")),o={name:"ProjectCard",components:{AppImage:i["default"]},props:{id:Number,title:String,height:{type:String,default:"250px"},image:{type:Number,default:15}}},s=o,c=(n("1308"),n("2877")),l=Object(c["a"])(s,a,r,!1,null,"6653d404",null);e["a"]=l.exports},a7e6:function(t,e,n){},b587:function(t,e,n){},b603:function(t,e,n){},bb0d:function(t,e,n){"use strict";var a=n("58fd"),r=n.n(a);r.a},c3ac:function(t,e,n){"use strict";var a=n("413e"),r=n.n(a);r.a},c8f8:function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"contact__note"},[t._t("default")],2)},r=[],i={name:"ContactNote"},o=i,s=(n("9203"),n("2877")),c=Object(s["a"])(o,a,r,!1,null,"d21ed3be",null);e["a"]=c.exports},d68b:function(t,e,n){"use strict";var a=n("b587"),r=n.n(a);r.a},e3f1:function(t,e,n){},e713:function(t,e,n){"use strict";var a=n("2ba0"),r=n.n(a);r.a}}]);
//# sourceMappingURL=chunk-a4a48b5c.08183e3d.js.map