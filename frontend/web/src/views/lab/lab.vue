
<template>

  <div class="lab"> 


      <v-header :activeIndex='activeIndex+""'></v-header>

      <el-container class="mid" justify="center">

        <el-aside width="300px" style="background-color: white" >

          <div id="asidetitle" >
              实验室简介
          </div>

          <el-menu
            default-active="1"
            class="asidemenu"
            @open="handleOpen"
            @close="handleClose"
            router="true">
            <el-menu-item index="1" route="/lab">
              <span slot="title">机构概况</span>
            </el-menu-item>
            <el-menu-item index="2" route="/lab2">
              <span slot="title">研究方向</span>
            </el-menu-item>            
            <el-menu-item index="3" route="/lab3">
              <span slot="title">研究团队</span>
            </el-menu-item>
            <el-menu-item index="4" route="/lab4">
              <span slot="title">毕业生</span>
            </el-menu-item>
          </el-menu>

        </el-aside>

        <el-main width="900px">

          <!-- 路径导航 -->
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/lab' }">实验室简介</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/lab' }">机构概况</el-breadcrumb-item>
          </el-breadcrumb>

          <el-row class="artical" >

            <div id="lititle" >
              <h1>  武汉理工大学智能生物信息实验室  </h1>
            </div>

            <div id="licontent" >
              <h1 style="line-height:200%;" v-html = "tableData.li_overview">  </h1>
            </div>

          </el-row>


        </el-main>

      </el-container>

      <v-footer></v-footer>

  </div>  

</template>

<style>
  .lab {
    background-image:url('../../assets/images/banner2.png');
    background-repeat:no-repeat;
    background-size:100%;
    background-attachment:fixed
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

  #lititle{
    text-align: center;
    width: 750px;
    position: relative;
    font-size: 30px;
    color:rgb(57, 142, 243);
    font-weight: 600;
    margin: 20px;
  }

  #licontent{
    width: 750px;
    position: relative;
    font-size: 18px;
    color: #333;
    font-weight: 600;
    margin: auto;
  }

  
  
</style>

<script >
  import Axios from 'axios'
  import webheader from "../header.vue";
  import webfooter from "../footer.vue";
  export default {
    name : 'lab',
    components:{    
      'v-header':webheader,
      'v-footer':webfooter,
    },
    data() {
      return {
        activeIndex:2,
        tableData: [],
        newData:[],
        totalcount:0,
        currentPage:1,
        pagesize:10,
      };
 
    },
    mounted() {
      this.getData();
      this.getnewData();
    },    
    methods: {
      handle(row,column,event,cell){
        console.log(row)
        console.log(column)
        console.log(event)
        console.log(cell)
      },
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      handleSizeChange: function (size) {
              this.pagesize = size;
              console.log(this.pagesize)  //每页下拉显示数据
      },
      handleCurrentChange: function(currentPage){
              this.currentPage = currentPage;
              console.log(this.currentPage)  //点击第几页
      },
      getData() {
        Axios.get('/api/lab/getLabIntro').then(response => {
            this.tableData=response.data.result;
              
              console.log(this.tableData);
        }, response => {
            console.log("error");
          });
      },
    },
  }

</script>