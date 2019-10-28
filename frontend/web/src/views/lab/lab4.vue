
<template>

  <div class="lab4"> 

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
          :default-active="'2'"
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
          <el-menu-item index="5" route="/">科研工作</el-menu-item>
          <el-menu-item index="6" route="/">资源发布</el-menu-item>
        </el-menu> 

      </el-header>

      <el-container class="mid" justify="center">

        <el-aside width="300px" style="background-color: white" >

          <div id="asidetitle" >
              实验室简介
          </div>

          <el-menu
            default-active="4"
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
            <el-breadcrumb-item :to="{ path: '/lab4' }">毕业生</el-breadcrumb-item>
          </el-breadcrumb>

          <template>
            <el-table
              ref="multipleTable"
              :data="newData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              stripe
              style="width: 100%" 
              @selection-change="handleSelectionChange"
              @row-click="clickTr">
              <el-table-column
                prop="title"
                width="650" 
               >
              </el-table-column>
              <el-table-column
                prop="date"
                width="150">
              </el-table-column>
            </el-table>
          </template>

          <!-- 分页 -->
          <div class="block" v-if="true"  >
            <el-pagination
              background 
              small="true"
              pager-count="5"
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="currentPage"
              :page-sizes="[10, 20, 30, 40]"
              :page-size="pagesize"
              layout="total, prev, pager, next, sizes"
              :total="totalcount">
            </el-pagination>
          </div>



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
            <p>{{message}}</p>
          </div>

        </el-col>

      </el-container>


    </el-container>

  </div>  

</template>

<style>
  .lab4 {
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

  .tablerow {
    box-shadow: 0 0px 3px 0 rgba(0, 0, 0, 0.1) ;
    height:40px;
    position: relative;
    margin: auto;
    width:100%;
    padding: 12px 0;
  }

  .block{
    display: flex;
    justify-content: center;
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

  body > .el-container {
    margin-bottom: 40px;
    text-align: center;
    margin: auto;
  }
  
</style>

<script >
  import Axios from 'axios'
  import  Lab4Info from './lab4Info.vue'
  export default {
    name : 'lab4',
    components:{
      Lab4Info
    },
    data() {
      return {
        tableData: [],
        newData:[],
        totalcount:0,
        currentPage:1,
        pagesize:30,
      };
 
    },
    mounted() {
      this.getData();
      this.getnewData();
    },    
    methods: {
      clickTr(row, event, column){
        console.log(row.id);
        this.$router.push({name:'lab4Info',query:{id:row.id}})
      },
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
        Axios.get('/api/postgraduate/getAllPostgraduate').then(response => {
            this.tableData=response.data.result;
              for(var i = 0;i<this.tableData.length;i++){
                
                  console.log(this.tableData[i].title);
                  this.newData.push(this.tableData[i]);
                  this.totalcount=this.newData.length;
                  console.log(this.totalcount);
                  console.log(this.newData);
                
              }
              console.log(this.tableData);
        }, response => {
            console.log("error");
          });
      },
    },
  }

</script>