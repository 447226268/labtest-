import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/login.vue";

//首页管理
import Homeedit from "../components/home/Homeedit.vue"

//实验室动态 laboratory
//实验室简介
import Introductioneditor from "../components/laboratory/introduction/Introductioneditor.vue"
//研究方向
import Directioneditor from "../components/laboratory/direction/Directioneditor.vue"
//研究团队
import Teamshow from "../components/laboratory/team/Teamshow.vue"
import Staffedit from "../components/laboratory/team/staffeditor.vue"
//毕业生
import Graduatesshow from "../components/laboratory/graduates/Showtable.vue"
import Graduateseditor from "../components/laboratory/graduates/Graduateseditor.vue"

//新闻动态 news
import Showtable_news from "../components/news/Showtable.vue"
import Newseditor from "../components/news/Newseditor.vue"

//通知公告 notice
import Showtable_notice from "../components/notice/Showtable.vue"
import Notificationeditor from "../components/notice/Notificationeditor.vue"

//科研工作 scince
//论文发布
import Showtable_article from "../components/science/article/Showtable.vue"
import Articleeditor from "../components/science/article/Articleeditor.vue"
//学术发布
import Showtable_academic from "../components/science/academic/Showtable.vue"
import Academiceditor from "../components/science/academic/Academiceditor.vue"

//资源发布 source
//资源分布
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
      component: Home,
      redirect: "/login",
      children:[
        //首页管理
        {
          path: "/home",
          name: "homeedit",
          component: Homeedit,
        },

        //实验室动态
        //实验室简介
        {
          path: "/laboratory/introducution/",
          name: "introductioneditor",
          component: Introductioneditor,
        },
        //研究方向
        {
          path: "/laboratory/direction/",
          name: "directioneditor",
          component: Directioneditor,
        },
        //研究团队
        {
          path: "/laboratory/team/",
          name: "teamshow",
          component: Teamshow,
        },
        //个人信息修改
        {
          path: "/laboratory/team/staffedit:index",
          name: "staffedit",
          component: Staffedit,
        },

        //毕业生
        //显示
        {
          path: "/laboratory/graduates/",
          name: "graduatesshow",
          component: Graduatesshow,
        },
        //编辑
        {
          path: "/laboratory/graduates/edit:index",
          name: "graduateseditor",
          component: Graduateseditor,
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
    },

    {
      path: "/login",
      name: "login",
      component: Login
    },
  ]
});
