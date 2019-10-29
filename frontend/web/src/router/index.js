import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/login.vue";
import Notice from "../views/notice/notice.vue";
import Notice2 from "../views/notice/notice2.vue";
import Notice3 from "../views/notice/notice3.vue";
import NoticeInfo from "../views/notice/noticeInfo.vue";
import News from "../views/news/news.vue";
import News2 from "../views/news/news2.vue";
import News3 from "../views/news/news3.vue";
import News4 from "../views/news/news4.vue";
import NewsInfo from "../views/news/newsInfo.vue";
import Lab from "../views/lab/lab.vue";
import Lab2 from "../views/lab/lab2.vue";
import Lab3 from "../views/lab/lab3.vue";
import Lab4 from "../views/lab/lab4.vue";
import Lab3Info from "../views/lab/lab3Info.vue";
import Lab4Info from "../views/lab/lab4Info.vue";
import Thesis from "../views/research/thesis.vue";
import ThesisInfo from "../views/research/thesisInfo.vue";
import Meeting from "../views/research/meeting.vue";
import MeetingInfo from "../views/research/meetingInfo.vue";


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
    {
      path: "/lab",
      name: "lab",
      component: Lab
    },
    {
      path: "/lab2",
      name: "lab2",
      component: Lab2
    },
    {
      path: "/lab3",
      name: "lab3",
      component: Lab3
    },
    {
      path: "/lab4",
      name: "lab4",
      component: Lab4
    },
    {
      path: "/lab3Info",
      name: "lab3Info",
      component:  Lab3Info
    },
    {
      path: "/lab4Info",
      name: "lab4Info",
      component:  Lab4Info
    },
    {
      path: "/thesis",
      name: "thesis",
      component: Thesis
    },
    {
      path: "/thesisInfo",
      name: "thesisInfo",
      component:  ThesisInfo
    },    {
      path: "/meeting",
      name: "meeting",
      component: Meeting
    },
    {
      path: "/meetingInfo",
      name: "meetingInfo",
      component:  MeetingInfo
    },

    
  ]
});
