
<template>

  <div class="lab3"> 



      <v-header :activeIndex='activeIndex+""'></v-header>

      <el-container class="mid" justify="center">

        <el-aside width="300px" style="background-color: white" >

          <div id="asidetitle" >
              实验室简介
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

          <!-- 路径导航 -->
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/lab1' }">实验室简介</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/lab3' }">研究团队</el-breadcrumb-item>
          </el-breadcrumb>

          <div id="lititle" >
            <h1>  研究团队  </h1>
          </div>

          <div class="namelist" >

            <table class="nametable" border="1" v-for="item in typelist" :key="item.typeid">
              <thead>
                <tr >
                  <th class="nametitle" colspan="8">{{item.type}}</th>
                </tr>
              </thead>
              <tbody>
                <tr class="name8" >
                  <div v-for="staff in tableData" :key="staff.type">
                    <td class="namecontent"  v-if="staff.type==item.type&&staff.info==null">{{staff.name}}</td>

                    <td class="namecontent"  v-if="staff.type==item.type&&staff.info!=null">
                      <routerLink :to="'lab3Info?id='+staff.id" style="text-decoration:none">{{staff.name}}</routerLink>
                    </td>
                  </div>
                </tr>
              </tbody>
            </table>
          </div>



          


        </el-main>

      </el-container>

      <v-footer></v-footer>


   

  </div>  

</template>

<style>
  .lab3 {
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

  .namelist{
    width: 720px;
    margin: auto;
  }

  .nametable{
    border: 1px solid #cad9ea;
    width: 720px;
    position: relative;
    font-size: 20px;
    color: #333;
    font-weight: 500;
    margin: 20px 0 ;
  }



  .nametitle{
    background-color: rgb(57, 142, 243);
    text-align: center;
    width: 720px;
    position: relative;
    font-size: 20px;
    color: #333;
    font-weight: 600;
  }

  .name8{
    width: 720px;
    display: -webkit-flex;
    display: flex;
    -webkit-flex-wrap: wrap;
    flex-wrap: wrap;
  }

  .namecontent{
    text-align: center;
    width: 90px;
    position: relative;
    font-size: 20px;
    color: #333;
    font-weight: 500;
  }


   


  
</style>

<script >
  import Axios from 'axios'
  import Lab3Info from './lab3Info.vue'
  import webheader from "../webheader.vue";
  import webfooter from "../webfooter.vue";
  export default {
    name : 'lab3',
    components:{    
      'v-header':webheader,
      'v-footer':webfooter,
      Lab3Info
    },

    data() {
      return {
        activeIndex:2,
        tableData: [],
        totalcount:0,
        currentPage:1,
        pagesize:10,
        professorlist:[],
        AssProfessorlist:[],
        Postdoctorallist:[],
        Doctorlist:[],
        Masterlist:[],
        Otherlist:[],
        typelist:[],
        typeobj:{},
      };
 
    },
    mounted() {
      this.getData();
    },    
    methods: {
      
      handle(row,column,event,cell){
        console.log(row)
        console.log(column)
        console.log(event)
        console.log(cell)
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
        Axios.get('/api/staff/getAllStaff').then(response => {
            this.tableData=response.data.result;
            for(var i = 0;i<this.tableData.length;i++){
              var typeobj={type:this.tableData[i].type,type_id:this.tableData[i].type_id}
              console.log(typeobj);
              console.log(this.typelist);
              var flag = true;
              for(var j=0;j<this.typelist.length;j++){
                if(this.typelist[j].type == typeobj.type){
                  flag = false;
                };
              }; 　　
              if(flag){this.typelist.push(typeobj);};
                console.log(typeobj);
                console.log(this.typelist);
                console.log(this.typelist.indexOf(typeobj));
            };
            console.log(this.typelist);
            console.log(this.tableData);
        }, response => {
            console.log("error");
          });
      },

    },
  }

</script>