(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6bc3401a"],{"0f62":function(t,e,a){"use strict";var r=a("40f2"),n=a.n(r);n.a},"40f2":function(t,e,a){},"615b":function(t,e,a){},9406:function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-row",[a("v-col",{attrs:{cols:"12"}},[a("favorites-project")],1)],1)},n=[],o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-card",[a("v-card-title",{staticClass:"title"},[t._v("Избранные проекты")]),a("v-card-text",[a("v-row",t._l(t.projects,(function(e){return a("v-col",{key:e.item,attrs:{xl:"3",lg:"4",md:"6",cols:"12"}},[a("project-card",t._b({on:{toggleFavorites:t.updateProjects}},"project-card",e,!1))],1)})),1)],1)],1)},s=[],c=(a("96cf"),a("1da1")),i=a("5530"),l=a("24d2"),d=a("2f62"),u=a("a6fe"),v={name:"FavoritesProject",components:{ProjectCard:u["a"]},data:function(){return{projects:[]}},mounted:function(){this.getProjects()},methods:Object(i["a"])({},Object(d["b"])("project",["toggleProjectFavorites","updateFieldProject"]),{getProjects:function(){var t=this;return Object(c["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(l["c"])();case 2:t.projects=e.sent;case 3:case"end":return e.stop()}}),e)})))()},updateProjects:function(t){var e=this;this.toggleProjectFavorites(t).then((function(){e.getProjects()}))}})},f=v,p=a("2877"),h=a("6544"),g=a.n(h),b=a("b0af"),j=a("99d9"),m=a("62ad"),_=a("0fd9"),C=Object(p["a"])(f,o,s,!1,null,null,null),k=C.exports;g()(C,{VCard:b["a"],VCardText:j["c"],VCardTitle:j["d"],VCol:m["a"],VRow:_["a"]});var P={name:"Dashboard",components:{FavoritesProject:k}},w=P,O=Object(p["a"])(w,r,n,!1,null,null,null);e["default"]=O.exports;g()(O,{VCol:m["a"],VRow:_["a"]})},"99d9":function(t,e,a){"use strict";a.d(e,"a",(function(){return o})),a.d(e,"b",(function(){return s})),a.d(e,"c",(function(){return c})),a.d(e,"d",(function(){return i}));var r=a("b0af"),n=a("80d2"),o=Object(n["g"])("v-card__actions"),s=Object(n["g"])("v-card__subtitle"),c=Object(n["g"])("v-card__text"),i=Object(n["g"])("v-card__title");r["a"]},a6fe:function(t,e,a){"use strict";var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-card",{staticClass:"project-card",attrs:{color:"primary",height:"200",dark:""}},[a("v-card-title",{staticClass:"title"},[t._v(t._s(t.title))]),a("v-card-actions",{staticClass:"action-container"},[a("v-btn",{attrs:{text:"",to:{name:"project-id",params:{id:t.id}}}},[t._v(" Посмотреть ")]),a("v-btn",{attrs:{icon:""},on:{click:function(e){return t.$emit("toggleFavorites",{id:t.id,favorites:t.favorites})}}},[t.favorites?a("v-icon",{attrs:{color:"yellow"}},[t._v("mdi-star")]):a("v-icon",[t._v("mdi-star-outline")])],1)],1)],1)},n=[],o=(a("a9e3"),{name:"ProjectCard",props:{id:Number,title:{type:String,default:"Test"},favorites:{type:Boolean,default:!0}}}),s=o,c=(a("0f62"),a("2877")),i=a("6544"),l=a.n(i),d=a("8336"),u=a("b0af"),v=a("99d9"),f=a("132d"),p=Object(c["a"])(s,r,n,!1,null,"7a485260",null);e["a"]=p.exports;l()(p,{VBtn:d["a"],VCard:u["a"],VCardActions:v["a"],VCardTitle:v["d"],VIcon:f["a"]})},b0af:function(t,e,a){"use strict";a("0481"),a("4069"),a("a9e3");var r=a("5530"),n=(a("615b"),a("10d2")),o=a("297c"),s=a("1c87"),c=a("58df");e["a"]=Object(c["a"])(o["a"],s["a"],n["a"]).extend({name:"v-card",props:{flat:Boolean,hover:Boolean,img:String,link:Boolean,loaderHeight:{type:[Number,String],default:4},outlined:Boolean,raised:Boolean,shaped:Boolean},computed:{classes:function(){return Object(r["a"])({"v-card":!0},s["a"].options.computed.classes.call(this),{"v-card--flat":this.flat,"v-card--hover":this.hover,"v-card--link":this.isClickable,"v-card--loading":this.loading,"v-card--disabled":this.disabled,"v-card--outlined":this.outlined,"v-card--raised":this.raised,"v-card--shaped":this.shaped},n["a"].options.computed.classes.call(this))},styles:function(){var t=Object(r["a"])({},n["a"].options.computed.styles.call(this));return this.img&&(t.background='url("'.concat(this.img,'") center center / cover no-repeat')),t}},methods:{genProgress:function(){var t=o["a"].options.methods.genProgress.call(this);return t?this.$createElement("div",{staticClass:"v-card__progress",key:"progress"},[t]):null}},render:function(t){var e=this.generateRouteLink(),a=e.tag,r=e.data;return r.style=this.styles,this.isClickable&&(r.attrs=r.attrs||{},r.attrs.tabindex=0),t(a,this.setBackgroundColor(this.color,r),[this.genProgress(),this.$slots.default])}})}}]);
//# sourceMappingURL=chunk-6bc3401a.cec71e4d.js.map