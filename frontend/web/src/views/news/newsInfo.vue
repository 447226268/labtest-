
<template>

  <div class="newsInfo"> 



      <v-header :activeIndex='activeIndex+""'></v-header>

      <el-container class="mid" justify="center">

        <el-aside width="300px" style="background-color: white" >

          <div id="asidetitle" >
              通知公告
          </div>

          <el-menu
            default-active="1"
            class="asidemenu"
            :router="true">
            <el-menu-item index="1" route="/news1">
              <span slot="title">头条新闻</span>
            </el-menu-item>
            <el-menu-item index="2" route="/news2">
              <span slot="title">综合新闻</span>
            </el-menu-item>            
            <el-menu-item index="3" route="/news3">
              <span slot="title">科研动态</span>
            </el-menu-item>
            <el-menu-item index="4" route="/news4">
              <span slot="title">学术活动</span>
            </el-menu-item>
          </el-menu>

        </el-aside>

        <el-main width="900px">

          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/news1' }">新闻动态</el-breadcrumb-item>
            <el-breadcrumb-item >{{newData.nl_nl_subType_name}}</el-breadcrumb-item>
          </el-breadcrumb>
            
          <el-row class="artical" >

            <div id="nltitle" >
              <h1>  {{newData.nl_title}}  </h1>
            </div>

            <div id="nldate" >       
              <h1 >  {{newData.realTime}}  </h1>
            </div>

            <div class="nlimage">
              <div class="block" >
                <el-image
                  v-if="newData.nl_graph!=''"
                  style="margin:auto 50px auto 50px"
                  :src="newData.nl_graph"
                  :fit="'contain'"></el-image>
              </div>
            </div>

            <div id="nlcontent" >
              <h1 v-html = "newData.nl_content">  </h1>
            </div>

            <div id="nlpage" >
              
                <a v-if="lastData.nl_title!=undefined" :href="'newsInfo?nl_id='+lastData.nl_id">上一篇：  {{lastData.nl_title}}</a>
             
              <br>
              
                <a v-if="nextData.nl_title!=undefined" :href="'newsInfo?nl_id='+nextData.nl_id">下一篇：  {{nextData.nl_title}}</a>
              
            </div>


          </el-row>

        </el-main>

      </el-container>

      <v-footer></v-footer>




  </div>  

</template>

<style>
  .newsInfo {
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

 

  .block{
    display: flex;
    justify-content: center;
  }

  #nltitle{
    text-align: center;
    width: 800px;
    position: relative;
    font-size: 20px;
    color: #333;
    font-weight: 600;
    margin-top: 20px;
  }

  #nldate{
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


  
  
</style>

<script >
  import Axios from 'axios'
  import webheader from "../webheader.vue";
  import webfooter from "../webfooter.vue";
  export default {
    name: 'newsInfo',
    components:{    
      'v-header':webheader,
      'v-footer':webfooter,
    },
    data() {
      return {
        activeIndex:3,
        tableData:[],
        newData:{},
        lastData:{},
        nextData:{},
        thispapernum:null,
        nl_title:'标题',
        realTime:'日期',
        nl_graph:'图片',
        nl_content:'内容',
        showtable:true,
        showtext:false,
      };
    },
    mounted() {      
      this.getData();
      console.log(this.tableData.length);
    },    
    methods: {
      getData() {
        Axios.get('/api/news/findAll').then(response => {
            this.tableData=response.data.result;
              for(var i = 0;i<this.tableData.length;i++){
                if (this.tableData[i].nl_id==this.$route.query.nl_id){
                  console.log(this.tableData[i].nl_title);
                  this.newData=this.tableData[i];
                  console.log(this.newData);
                  this.thispapernum=i;
                  console.log(this.thispapernum);
                }
              };
              for(var j = 0;j<this.thispapernum;j++){
                if(this.newData.nl_nl_subType_name==this.tableData[j].nl_nl_subType_name&&this.tableData[j].nl_state==1){
                  this.lastData=this.tableData[j];
                }            
              };
              for(var k = this.thispapernum+1;k<this.tableData.length;k++){            
                if(this.newData.nl_nl_subType_name==this.tableData[k].nl_nl_subType_name&&this.tableData[k].nl_state==1){
                  this.nextData=this.tableData[k];
                  break;
                }    
              };
              console.log(this.tableData);
              console.log(this.lastData);
              console.log(this.nextData);
              console.log(this.lastData.nl_title);
              console.log(this.nextData.nl_title);
        }, response => {
            console.log("error");
          });
      },
    
      handle(row,column,event,cell){
        console.log(row)
        console.log(column)
        console.log(event)
        console.log(cell)
      },
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      },

    },
  }
</script>