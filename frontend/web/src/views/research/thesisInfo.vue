
<template>

  <div class="thesisInfo"> 
  


      <v-header :activeIndex='activeIndex+""'></v-header>

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

      <v-footer></v-footer>




  </div>  

</template>

<style>
  .thesisInfo {
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


   
  
</style>

<script >
  import Axios from 'axios'
  import header from "../header.vue";
  import footer from "../footer.vue";
  export default {
    name: 'thesisInfo',
    components:{    
      'v-header':header,
      'v-footer':footer,
    },
    data() {
      return {
        activeIndex:5,
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