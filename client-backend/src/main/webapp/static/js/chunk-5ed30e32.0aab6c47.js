(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5ed30e32"],{"1d75":function(t,e,a){"use strict";var s=a("4189"),i=a.n(s);i.a},"25a3":function(t,e,a){},"34cb":function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("router-link",{staticClass:"news-card",attrs:{to:{path:"/news/"+t.id},tag:"div"}},[a("div",{staticClass:"news-title",style:{height:t.height}},[a("div",{staticClass:"image"},[a("app-image",{attrs:{id:t.image,name:t.title}})],1),a("div",{staticClass:"title-details"},[a("news-details",{attrs:{date:t.datePublish,shadow:""}})],1),a("h5",{staticClass:"title"},[t._v(t._s(t.title))])]),t.text?a("div",{staticClass:"news-text"},[t._v(t._s(t.text))]):t._e()])},i=[],n=(a("c5f6"),a("11d3")),c=a("6cb5"),r={name:"CardNews",components:{AppImage:n["default"],NewsDetails:c["a"]},props:{id:Number,title:String,views:Number,datePublish:String,height:{type:String,default:"200px"},image:{type:Number,default:15},text:{type:String,default:""}}},l=r,o=(a("86a7"),a("2877")),d=Object(o["a"])(l,s,i,!1,null,null,null);e["a"]=d.exports},4189:function(t,e,a){},"512e":function(t,e,a){"use strict";var s=a("25a3"),i=a.n(s);i.a},"6cb5":function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"details-container"},[t.views?a("div",{staticClass:"views-block"},[a("font-awesome-icon",{attrs:{icon:["fas","eye"]}}),a("span",[t._v(t._s(t.views))])],1):t._e(),a("div",{staticClass:"publish-date"},[a("span",{class:{"text--shadow":t.shadow}},[t._v(t._s(t._f("formatDate")(t.date)))])])])},i=[],n=(a("c5f6"),{name:"NewsDetails",props:{views:{type:Number,default:0},date:String,shadow:{type:Boolean,default:!1}}}),c=n,r=(a("512e"),a("2877")),l=Object(r["a"])(c,s,i,!1,null,"a63cb8d2",null);e["a"]=l.exports},"7c64":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("header-page",{attrs:{image:t.imagePageId}},[a("h1",[t._v(t._s(t.titlePage))])]),a("div",{staticClass:"body-page"},[a("div",{staticClass:"app-container"},[a("div",{staticClass:"row mx-md-n4"},t._l(t.news,(function(t){return a("div",{key:t.id,staticClass:"col-lg-4 col-sm-6 px-md-4 mb-5"},[a("news-card",{attrs:{id:t.id,heightTitle:250,image:t.mainImage,title:t.shortTitle,views:t.countView,datePublish:t.datePublic,text:t.entrySpeech}})],1)})),0),a("div",{staticClass:"button-container"},[t.hasNewsFull?t._e():a("div",{staticClass:"button-item"},[a("div",{staticClass:"btn btn-main",on:{click:t.loadMore}},[t._v("Загрузить ещё")])])])])])],1)},i=[],n=(a("8e6e"),a("ac6a"),a("456d"),a("ade3")),c=a("4360"),r=a("2f62"),l=a("db41"),o=a("34cb");function d(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(t);e&&(s=s.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,s)}return a}function u(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?d(Object(a),!0).forEach((function(e){Object(n["a"])(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):d(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}var p={name:"News",components:{HeaderPage:l["a"],NewsCard:o["a"]},computed:u(u({},Object(r["d"])({news:function(t){return t.news.newsList},hasNewsFull:function(t){return t.news.hasNewsFull}})),Object(r["c"])("news",["page"])),data:function(){return{titlePage:"Новости",imagePageId:16}},beforeRouteEnter:function(t,e,a){c["a"].dispatch("news/getNews",{size:9,page:0}).then((function(){a()}))},destroyed:function(){c["a"].dispatch("news/resetNews")},methods:{loadMore:function(){c["a"].dispatch("news/getNews",{page:this.page+1})}}},f=p,w=(a("1d75"),a("2877")),b=Object(w["a"])(f,s,i,!1,null,"e001d59e",null);e["default"]=b.exports},"86a7":function(t,e,a){"use strict";var s=a("a7e6"),i=a.n(s);i.a},9106:function(t,e,a){},a7e6:function(t,e,a){},cb26:function(t,e,a){"use strict";var s=a("9106"),i=a.n(s);i.a},db41:function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"header-page"},[a("div",{staticClass:"img-container"},[a("app-image",{attrs:{id:t.image}})],1),a("div",{staticClass:"app-container"},[a("div",{staticClass:"title"},[t._t("default")],2)])])},i=[],n=(a("c5f6"),a("11d3")),c={name:"HeaderPage",props:{image:{type:Number,default:16}},components:{AppImage:n["default"]}},r=c,l=(a("cb26"),a("2877")),o=Object(l["a"])(r,s,i,!1,null,"67508c57",null);e["a"]=o.exports}}]);
//# sourceMappingURL=chunk-5ed30e32.0aab6c47.js.map