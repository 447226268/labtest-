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

  ]
});
