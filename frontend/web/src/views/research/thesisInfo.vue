
<template>

  <div class="thesisInfo"> 
    

    <el-form v-if="seen" label-width="80px" size="medium"
             class="formWrap">
      <el-form-item label="主题名称">
        <span>{{$route.params.themerow.bmtMastrNm}}</span>
      </el-form-item>
    </el-form>


    <el-container>

      <el-header height ="350px">

        <div id="labname" >
            武汉理工大学智能生物信息实验室
        </div>

        <div id="WUTBIOLAB" >
            <span style="color:yellow;">W</span>UTBIOLAB
        </div>
        
        <el-image class="lablogo"
            style="width: 270px;height: 100px;"
            :src="require('../../assets/images/Group8.png')"
            :fit="fill">
        </el-image>

        <el-menu
          :default-active="'5'"
          class="navigation"
          mode="horizontal"
          @select="handleSelect"
          background-color="#398ef3"
          text-color="#fff"
          active-text-color="yellow"
          router="true">
          <el-menu-item index="1" route="/">首页</el-menu-item>
          <el-menu-item index="2" route="/lab">实验室简介</el-menu-item>
          <el-menu-item index="3" route="/news">新闻动态</el-menu-item>
          <el-menu-item index="4" route="/notice">通知公告</el-menu-item>
          <el-menu-item index="5" route="/thesis">科研工作</el-menu-item>
          <el-menu-item index="6" route="/resource">资源发布</el-menu-item>
        </el-menu> 

      </el-header>

      <el-container class="mid" justify="center">

        <el-aside width="300px" style="background-color: white" >

          <div id="asidetitle" >
              科研工作
          </div>

          <el-menu
            default-active="1"
            class="asidemenu"
            @open="handleOpen"
            @close="handleClose"
            router="true">
            <el-menu-item index="1" route="/thesis">
              <span slot="title">论文发表</span>
            </el-menu-item>
            <el-menu-item index="2" route="/meeting">
              <span slot="title">学术会议</span>
            </el-menu-item>            
          </el-menu>

        </el-aside>

        <el-main width="900px">

          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/thesis' }">科研工作</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/thesis' }">论文发表</el-breadcrumb-item>
          </el-breadcrumb>
            
          <el-row class="artical" v-if="true">

            <div id="tltitle" >
              <h1>  {{newData.tl_title}}  </h1>
            </div>

            <div id="tldate" >       
              <h1 >  {{newData.tl_realtime}}  </h1>
            </div>

            <div id="tlcontent" >
              <h1 v-html = "newData.tl_content">  </h1>
            </div>

          </el-row>

        </el-main>

      </el-container>


      <el-container class="footer">  

        <el-col class="logoandname" width="600px" >

          <el-image class="lablogo"
              style="width: 70px;height: 70px;top: 75px"
              :src="require('../../assets/images/whutlogo.png')"
              :fit="fill">
          </el-image>

          <div id="whutname" >
            <p>武汉理工大学</p>
            <p>计算机科学与技术学院</p>
          </div>

        </el-col>

        <el-col class="foottest" width="600px" >

          <div id="address" style="top:50px">
            <p>武汉理工大学鉴湖第四教学楼14层</p>
            <p>yuanxiaohui(at)whut.edu.cn</p>
            <p>http://www.wutbiolab.com</p>
            <p>© Copyright 2019 武汉理工智能生物信息实验室</p>
          </div>

        </el-col>

      </el-container>


    </el-container>

  </div>  

</template>

<style>
  .thesisInfo {
    background-image:url('../../assets/images/banner2.png');
    background-repeat:no-repeat;
    background-size:100%;
    background-attachment:fixed
  }

  .el-header {
    background-image: url('../../assets/images/banner1.png');
    background-size:1200px 300px;
    background-repeat:no-repeat;
    background-attachment:fill;
    width: 1200px;
    position: relative;
    margin: auto;
  }

  #labname {
    width:800px;
    position: relative;
    left: 280px;
    top: 170px;
    height: 40px;
    font-size: 40px;
    font-weight: 400;
    color: white;
  }

  #WUTBIOLAB {
    width:400px;
    position: relative;
    left: 280px;
    top: 100px;
    height: 40px;
    font-size: 40px;
    font-weight: 400;
    color:white;
    white-space:nowrap; 
    font-family:"华文琥珀"
  }

  .lablogo {
    position: relative;
    left:10px;
    top: 50px;
  }
  
  .navigation{
    position:relative;
    width:1200px;
    left: -20px;
    top:110px;
  } 

  .el-menu-item{
    position:relative;
    left:312px;
  } 

  .mid{
    background-color:white;
    width: 1200px;
    position: relative;
    margin: auto;
  }

  .el-aside {
    position: relative;
    height: 550px;
  }

  #asidetitle {
    width:200px;
    position: relative;
    height: 40px;
    font-size: 30px;
    font-weight: 900;
    color: #666;
    left:50px;
    top:20px;
  }

  .asidemenu{
    width:270px;
    position: relative;
    height: 400px;
    top: 50px;
    color: #666;
    margin: auto;
    text-align: center;
  }

  .asidemenu .el-menu-item{
    width:200px;
    position: relative;
    height: 60px;
    font-size: 20px;
    font-weight: 900;
    color: #666;
    left:30px;
    margin: auto;
    text-align: center;
  }
  
  .el-main {
    position: relative;
    margin-right: 50px;
  }

  #tltitle{
    text-align: center;
    width: 800px;
    position: relative;
    font-size: 20px;
    color: #333;
    font-weight: 600;
    margin-top: 20px;
  }

  #tldate{
    text-align: center;
    width: 400px;
    position: relative;
    margin: auto;
    font-size: 15px;
    color: #333;
    font-weight: 400;
    margin-top: 20px;
    margin-bottom: 20px;
  }

  #nicontent{
    width: 750px;
    position: relative;
    font-size: 14px;
    color: #333;
    font-weight: 600;
    margin-left: 30px;
  }


  .footer{
    background-color: #398ef3;
    width: 1200px;
    height: 220px;
    position: relative;
    margin: auto;
  }
  
  #whutname{
    color: white;
    font-size: 30px;
    position: relative;
    left: 100px;
  }


  #address{
    color: white;
    font-size: 16px;
    position: relative;
    line-height:2;
  }
  
</style>

<script >
  import Axios from 'axios'
  export default {
    name: 'thesisInfo',
    data() {
      return {
        tableData:[],
        newData:{},
        tl_title:'标题',
        realTime:'日期',
        tl_content:'内容',
      };
    },
    mounted() {      
      this.getData();
      console.log(this.tableData.length);
    },    
    methods: {
      getData() {
        Axios.get('/api/thesis/findAll').then(response => {
            this.tableData=response.data.result;
              for(var i = 0;i<this.tableData.length;i++){
                if (this.tableData[i].tl_id==this.$route.query.tl_id){
                  console.log(this.tableData[i].tl_title);
                  this.newData=this.tableData[i]
                  console.log(this.newData);

                }
              }
              console.log(this.tableData);
              console.log(this.tableData.length);
        }, response => {
            console.log("error");
          });
      },
    },
  }
</script>