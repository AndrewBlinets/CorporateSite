(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-9804761c"],{"25a3":function(t,e,s){},"34cb":function(t,e,s){"use strict";var a=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("router-link",{staticClass:"news-card",attrs:{to:{path:"/news/"+t.id},tag:"div"}},[s("div",{staticClass:"news-title",style:{height:t.height}},[s("div",{staticClass:"image"},[s("app-image",{attrs:{id:t.image,name:t.title}})],1),s("div",{staticClass:"title-details"},[s("news-details",{attrs:{date:t.datePublish,shadow:""}})],1),s("h5",{staticClass:"title"},[t._v(t._s(t.title))])]),t.text?s("div",{staticClass:"news-text"},[t._v(t._s(t.text))]):t._e()])},i=[],n=(s("c5f6"),s("11d3")),r=s("6cb5"),c={name:"CardNews",components:{AppImage:n["default"],NewsDetails:r["a"]},props:{id:Number,title:String,views:Number,datePublish:String,height:{type:String,default:"200px"},image:{type:Number,default:15},text:{type:String,default:""}}},l=c,o=(s("86a7"),s("2877")),u=Object(o["a"])(l,a,i,!1,null,null,null);e["a"]=u.exports},"512e":function(t,e,s){"use strict";var a=s("25a3"),i=s.n(a);i.a},"6cb5":function(t,e,s){"use strict";var a=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"details-container"},[t.views?s("div",{staticClass:"views-block"},[s("font-awesome-icon",{attrs:{icon:["fas","eye"]}}),s("span",[t._v(t._s(t.views))])],1):t._e(),s("div",{staticClass:"publish-date"},[s("span",{class:{"text--shadow":t.shadow}},[t._v(t._s(t._f("formatDate")(t.date)))])])])},i=[],n=(s("c5f6"),{name:"NewsDetails",props:{views:{type:Number,default:0},date:String,shadow:{type:Boolean,default:!1}}}),r=n,c=(s("512e"),s("2877")),l=Object(c["a"])(r,a,i,!1,null,"a63cb8d2",null);e["a"]=l.exports},"86a7":function(t,e,s){"use strict";var a=s("a7e6"),i=s.n(a);i.a},a7e6:function(t,e,s){},b0da:function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"row mx-md-n4"},t._l(t.news,(function(t){return s("div",{key:t.id,staticClass:"col-lg-4 col-sm-6 px-md-4 mb-5"},[s("news-card",{attrs:{id:t.id,heightTitle:250,image:t.mainImage,title:t.shortTitle,views:t.countView,datePublish:t.datePublic,text:t.entrySpeech}})],1)})),0)},i=[],n=(s("8e6e"),s("ac6a"),s("456d"),s("ade3")),r=(s("c5f6"),s("2f62")),c=s("34cb");function l(t,e){var s=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),s.push.apply(s,a)}return s}function o(t){for(var e=1;e<arguments.length;e++){var s=null!=arguments[e]?arguments[e]:{};e%2?l(Object(s),!0).forEach((function(e){Object(n["a"])(t,e,s[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(s)):l(Object(s)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(s,e))}))}return t}var u={name:"News",components:{NewsCard:c["a"]},props:{pageId:Number},computed:o(o({},Object(r["c"])(["news"])),{},{lastIndex:function(){return this.news.length-1}}),created:function(){this.$store.dispatch("news/getNews",{pageId:this.pageId,size:3})}},d=u,p=s("2877"),f=Object(p["a"])(d,a,i,!1,null,null,null);e["default"]=f.exports}}]);
//# sourceMappingURL=chunk-9804761c.2a402f78.js.map