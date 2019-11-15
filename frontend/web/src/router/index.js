import Vue from "vue";

import Router from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/login.vue";

import Lab1 from "../views/lab/lab1.vue";
import Lab2 from "../views/lab/lab2.vue";
import Lab3 from "../views/lab/lab3.vue";
import Lab3Info from "../views/lab/lab3Info.vue";
import Lab4 from "../views/lab/lab4.vue";
import Lab4Info from "../views/lab/lab4Info.vue";


import News1copy from "../views/news/news1 copy.vue";
import News1 from "../views/news/news1.vue";
import News2 from "../views/news/news2.vue";
import News3 from "../views/news/news3.vue";
import News4 from "../views/news/news4.vue";
import NewsInfo from "../views/news/newsInfo.vue";

import Notice1 from "../views/notice/notice1.vue";
import Notice2 from "../views/notice/notice2.vue";
import Notice3 from "../views/notice/notice3.vue";
import NoticeInfo from "../views/notice/noticeInfo.vue";

import Thesis from "../views/research/thesis.vue";
import ThesisInfo from "../views/research/thesisInfo.vue";
import Meeting from "../views/research/meeting.vue";
import MeetingInfo from "../views/research/meetingInfo.vue";

import Resource1 from "../views/resource/resource1.vue";
import Resource2 from "../views/resource/resource2.vue";
import Resource3 from "../views/resource/resource3.vue";
import ResourceInfo from "../views/resource/resourceInfo.vue";


Vue.use(Router);

export default new Router({
  mode: "history",
  // base: process.env.VUE_APP_TEST,
  routes: [
    {
      path: "/news1copy",
      name: "news1copy",
      component: News1copy, 
    },

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
      path: "/lab1",
      name: "lab1",
      component: Lab1, alias: '/lab'
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
      path: "/lab3Info",
      name: "lab3Info",
      component:  Lab3Info
    },
    {
      path: "/lab4",
      name: "lab4",
      component: Lab4
    },
    {
      path: "/lab4Info",
      name: "lab4Info",
      component:  Lab4Info
    },

    {
      path: "/news1",
      name: "news1",
      component: News1, alias: '/news'
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
      path: "/notice1",
      name: "notice1",
      component: Notice1, alias: '/notice'
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
      path: "/thesis",
      name: "thesis",
      component: Thesis
    },
    {
      path: "/thesisInfo",
      name: "thesisInfo",
      component:  ThesisInfo
    },
    {
      path: "/meeting",
      name: "meeting",
      component: Meeting
    },
    {
      path: "/meetingInfo",
      name: "meetingInfo",
      component:  MeetingInfo
    },

    {
      path: "/resource1",
      name: "resource1",
      component: Resource1, alias: '/resource'
    },
    {
      path: "/resource2",
      name: "resource2",
      component: Resource2
    },
    {
      path: "/resource3",
      name: "resource3",
      component: Resource3
    },
    {
      path: "/resourceInfo",
      name: "resourceInfo",
      component:  ResourceInfo
    },
  ]
});
