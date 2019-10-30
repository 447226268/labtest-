import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/login.vue";

import HomepagemanagementPage from "../components/HomepagemanagementPage.vue";
import Uploadingmap from "../components/Uploadingmap.vue";

//新闻动态 news
import Showtable_news from "../components/news/Showtable.vue"
import Newseditor from "../components/news/Newseditor.vue"

//通知公告 notice
import Showtable_notice from "../components/notice/Showtable.vue"
import Notificationeditor from "../components/notice/Notificationeditor.vue"

//科研工作 scince
//论文分布
import Showtable_article from "../components/science/article/Showtable.vue"
import Articleeditor from "../components/science/article/Articleeditor.vue"
//论文分布
import Showtable_academic from "../components/science/academic/Showtable.vue"
import Academiceditor from "../components/science/academic/Academiceditor.vue"

//资源发布 source
//论文分布
import Showtable_source from "../components/source/Showtable.vue"
import Sourceeditor from "../components/source/Sourceeditor.vue"

Vue.use(Router);

export default new Router({
  mode: "history",
  // base: process.env.VUE_APP_TEST,
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/login",
      name: "login",
      component: Login
    },

    {
      path: "/首页管理",
      name: "homepagemanagementPage",
      component: HomepagemanagementPage,
      children :[
        {
          path: "/首页管理/配图上传",
          name: "uploadingmap",
          component: Uploadingmap
        },
      ]
    },

    //新闻动态
    {
      path: "/news/show",
      name: "showtable_news",
      component: Showtable_news,
    },
    {
      path: "/news/edit:index",
      name: "newseditor",
      component: Newseditor,
    },

    //通知公告
    {
      path: "/notice/show",
      name: "showtable_notice",
      component: Showtable_notice,
    },
    {
      path: "/notice/edit:index",
      name: "notificationeditor",
      component: Notificationeditor,
    },

    //科研工作
    {
      path: "/scince/article/show",
      name: "showtable_article",
      component: Showtable_article,
    },
    {
      path: "/scince/article/edit:index",
      name: "articleeditor",
      component: Articleeditor,
    },
    {
      path: "/scince/academic/show",
      name: "showtable_academic",
      component: Showtable_academic,
    },
    {
      path: "/scince/academic/edit:index",
      name: "academiceditor",
      component: Academiceditor,
    },

    //资源发布
    {
      path: "/source/show",
      name: "showtable_source",
      component: Showtable_source,
    },
    {
      path: "/source/edit:index",
      name: "sourceeditor",
      component: Sourceeditor,
    },
    
  ]
});
