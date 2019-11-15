
<template>

  <div class="lab3Info"> 



      <v-header :activeIndex='activeIndex+""'></v-header>

      <el-container class="mid" justify="center">

        <el-aside width="300px" style="background-color: white" >

          <div id="asidetitle" >
              通知公告
          </div>

          <el-menu
            default-active="3"
            class="asidemenu"
            :router="true">
            <el-menu-item index="1" route="/lab1">
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

          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/lab1' }">实验室简介</el-breadcrumb-item>
            <el-breadcrumb-item >研究团队</el-breadcrumb-item>
          </el-breadcrumb>
            
          <el-row class="artical" >

            <div id="lititle" >
              <h1>  {{newData.name}}  </h1>
            </div>

            <div id="lidate" >       
              <h1 >  {{newData.date}}  </h1>
            </div>

            <div class="liimage">
              <div class="staffblock" >
                <el-image
                  :src="newData.info.si_graph"
                  :fit="contain"></el-image>
              </div>
            </div>

            <div id="licontent" >
              <h1 v-html = "newData.info.si_content">  </h1>
            </div>



          </el-row>

        </el-main>

      </el-container>


      <v-footer></v-footer>




  </div>  

</template>

<style>
  .lab3Info {
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

 

  .staffblock{
    margin: 30px auto;
    width: 300px;
    height: 400px;
    display: flex;
    justify-content: center;
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

  #lidate{
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
    name: 'lab3Info',
    components:{    
      'v-header':webheader,
      'v-footer':webfooter,
    },
    data() {
      return {
        activeIndex:2,
        tableData:[],
        newData:{},
        title:'标题',
        realTime:'日期',
        graph:'图片',
        content:'内容',
        showtable:true,
        showtext:false,
        search:0
      };
    },
    mounted() {      
      this.getData();
 

    },    
    methods: {
      getData() {
        this.search=window.location.search.substr(1);
        console.log(this.search);
        Axios.get('/api/staff/getAllStaff').then(response => {
            this.tableData=response.data.result;
              for(var i = 0;i<this.tableData.length;i++){
                if (this.tableData[i].id==this.search){
                  console.log(this.tableData[i].title);
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