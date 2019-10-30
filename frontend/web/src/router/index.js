import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/login.vue";
import Notice from "../views/notice.vue";
import Notice2 from "../views/notice2.vue";
import Notice3 from "../views/notice3.vue";
import NoticeInfo from "../views/noticeInfo.vue";
import News from "../views/news.vue";
import News2 from "../views/news2.vue";
import News3 from "../views/news3.vue";
import News4 from "../views/news4.vue";
import NewsInfo from "../views/newsInfo.vue";

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
      path: "/notice",
      name: "notice",
      component: Notice
    },
    {
      path: "/notice2",
      name: "notice2",
      component: Notice2
    },
    {
      path: "/notice3",
      name: "notice3",
      component: Notice3
    },
    {
      path: "/noticeInfo",
      name: "noticeInfo",
      component:  NoticeInfo
    },
    {
      path: "/news",
      name: "news",
      component: News
    },
    {
      path: "/news2",
      name: "news2",
      component: News2
    },
    {
      path: "/news3",
      name: "news3",
      component: News3
    },
    {
      path: "/news4",
      name: "news4",
      component: News4
    },
    {
      path: "/newsInfo",
      name: "newsInfo",
      component:  NewsInfo
    },

    
  ]
});
