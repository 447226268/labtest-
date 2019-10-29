
<template>

  <div class="lab3"> 

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
          <el-menu-item index="5" route="/thesis">科研工作</el-menu-item>
          <el-menu-item index="6" route="/">资源发布</el-menu-item>
        </el-menu> 

      </el-header>

      <el-container class="mid" justify="center">

        <el-aside width="300px" style="background-color: white" >

          <div id="asidetitle" >
              实验室简介
          </div>

          <el-menu
            default-active="3"
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
            <el-breadcrumb-item :to="{ path: '/lab3' }">研究团队</el-breadcrumb-item>
          </el-breadcrumb>

          <div id="lititle" >
            <h1>  研究团队  </h1>
          </div>

          <div class="namelist">
            <div>
              <table border="1" class="nametable">
                  <thead><tr><th colspan="8">教授</th></tr></thead>
                  <tbody id="professor" v-html= "professorlist"></tbody>
              </table>
            </div>

            <div>
              <table border="1" class="nametable">
                  <thead><tr><th colspan="8">副教授</th></tr></thead>
                  <tbody id="AssProfessor" v-html= "AssProfessorlist"></tbody>
              </table>
            </div>

            <div >
              <table border="1" class="nametable">
                  <thead><tr><th colspan="8">博士后</th></tr></thead>
                  <tbody id="Postdoctoral" v-html= "Postdoctorallist"></tbody>
              </table>
            </div>

            <div>
              <table border="1" class="nametable">
                  <thead><tr><th colspan="8">博士</th></tr>
                  </thead><tbody id="Doctor" v-html= "Doctorlist"></tbody>
              </table>
            </div>

            <div>
              <table border="1" class="nametable">
                  <thead><tr><th colspan="8">硕士</th></tr></thead>
                  <tbody id="Master" v-html= "Masterlist"></tbody>
              </table>
            </div>

            <div>
              <table border="1" class="nametable">
                  <thead><tr><th colspan="8">其他</th></tr></thead>
                  <tbody id="Other" v-html= "Otherlist"></tbody>
              </table>
            </div>
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

<style scoped>
  .lab3 {
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
    text-align: center;
    width: 720px;
    position: relative;
    font-size: 14px;
    color: #333;
    font-weight: 500;
    margin-left: 30px;
  }

  .nametable{
    border: 1px solid #cad9ea;
    text-align: center;
    width: 720px;
    position: relative;
    font-size: 20px;
    color: #333;
    font-weight: 500;
    margin: 50px 25px 50px 20px;
  }

  #professorlist,#AssProfessorlist,#Postdoctorallist,#Doctorlist,#Masterlist,#Otherlist{
    text-align: center;
    width: 90px;
    position: relative;
    font-size: 20px;
    color: #333;
    font-weight: 500;
    margin: 50px 25px 50px 20px;
  }

  th{
    background-color: rgb(57, 142, 243);
    text-align: center;
    width: 720px;
    position: relative;
    font-size: 20px;
    color: #333;
    font-weight: 600;
    margin: 50px 25px 50px 20px;
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
  import  Lab3Info from './lab3Info.vue'
  export default {
    name : 'lab3',
    components:{
      Lab3Info
    },
    data() {
      return {
        tableData: [],
        newData:[],
        totalcount:0,
        currentPage:1,
        pagesize:30,
        professorlist:"" ,
        AssProfessorlist:"",
        Postdoctorallist:"",
        Doctorlist:"",
        Masterlist:"",
        Otherlist:"",



      };
 
    },
    mounted() {
      this.getData();
      this.getnewData();
    },    
    methods: {
      
      clickTr(row, event, column){
        console.log(row.id);
        this.$router.push({name:'labInfo',query:{id:row.id}})
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
        Axios.get('/api/staff/getAllStaff').then(response => {
            this.tableData=response.data.result;
            console.log(this.tableData);
            this.professorlist+="<tr>";
            this.AssProfessorlist+="<tr>";
            this.Postdoctorallist+="<tr>";
            this.Doctorlist+="<tr>";
            this.Masterlist+="<tr>";
            this.Otherlist+="<tr >";
            console.log(this.professorlist);
            var count1 = 0;
            var count2 = 0;
            var count3 = 0;
            var count4 = 0;
            var count5 = 0;
            var count6 = 0;
            
            for(var i = 0;i<this.tableData.length;i++){
              console.log(this.tableData[i].type);
              console.log(this.tableData[i]);
                if(this.tableData[i].type=="教授"){
                  if(this.tableData[i].info!=null){
                    this.professorlist+='<td><a style="color:rgb(57, 142, 243)" href="/lab3Info?'
                    this.professorlist+=this.tableData[i].id;
                    this.professorlist+='">';
                    this.professorlist+=this.tableData[i].name;
                    this.professorlist+='</a>';
                  }
                  else{this.professorlist+="<td>";
                  this.professorlist+=this.tableData[i].name};
                  this.professorlist+="</td>";
                  count1++;
                  if(count1==8){count1=0;this.professorlist+="</tr><tr>"}
                }
                else if(this.tableData[i].type=="副教授"){
                  if(this.tableData[i].info!=null){
                    this.AssProfessorlist+='<td sytle="width:90px"><a style="color:rgb(57, 142, 243)" href="/lab3Info?'
                    this.AssProfessorlist+=this.tableData[i].id;
                    this.AssProfessorlist+='">';
                    this.AssProfessorlist+=this.tableData[i].name;
                    this.AssProfessorlist+='</a>';
                  }
                  else{this.AssProfessorlist+="<td sytle='width:90px'>";
                  this.AssProfessorlist+=this.tableData[i].name};
                  this.AssProfessorlist+="</td>";
                  count2++;
                  if(count2==8){this.AssProfessorlist+="</tr><tr>"}
                }
                else if(this.tableData[i].type=="博士后"){
                  if(this.tableData[i].info!=null){
                    this.Postdoctorallist+='<td><a style="color:rgb(57, 142, 243)" href="/lab3Info?'
                    this.Postdoctorallist+=this.tableData[i].id;
                    this.Postdoctorallist+='">';
                    this.Postdoctorallist+=this.tableData[i].name;
                    this.Postdoctorallist+='</a>';
                  }
                  else{this.Postdoctorallist+="<td>";
                  this.Postdoctorallist+=this.tableData[i].name};
                  this.Postdoctorallist+="</td>";
                  count3++;
                  if(count3==8){this.Postdoctorallist+="</tr><tr>"}
                }
                else if(this.tableData[i].type=="博士"){
                  if(this.tableData[i].info!=null){
                    this.Doctorlist+='<td sytle="width:90px"><a style="color:rgb(57, 142, 243)" href="/lab3Info?'
                    this.Doctorlist+=this.tableData[i].id;
                    this.Doctorlist+='">';
                    this.Doctorlist+=this.tableData[i].name;
                    this.Doctorlist+='</a>';
                  }
                  else{this.Doctorlist+="<td sytle='width:90px'>";
                  this.Doctorlist+=this.tableData[i].name};
                  this.Doctorlist+="</td>";
                  count4++;
                  if(count4==8){this.Doctorlist+="</tr><tr>"}
                }
                else if(this.tableData[i].type=="硕士"){
                  if(this.tableData[i].info!=null){
                    this.Masterlist+='<td><a style="color:rgb(57, 142, 243)" href="/lab3Info?'
                    this.Masterlist+=this.tableData[i].id;
                    this.Masterlist+='">';
                    this.Masterlist+=this.tableData[i].name;
                    this.Masterlist+='</a>';
                  }
                  else{this.Masterlist+="<td>";
                  this.Masterlist+=this.tableData[i].name};
                  this.Masterlist+="</td>";
                  count5++;
                  if(count5==8){this.Masterlist+="</tr><tr>"}
                }
                else{
                  if(this.tableData[i].info!=null){
                    this.Otherlist+='<td><a style="color:rgb(57, 142, 243)" href="/lab3Info?'
                    this.Otherlist+=this.tableData[i].id;
                    this.Otherlist+='">';
                    this.Otherlist+=this.tableData[i].name;
                    this.Otherlist+='</a>';
                  }
                  else{this.Otherlist+="<td>";
                  this.Otherlist+=this.tableData[i].name};
                  this.Otherlist+="</td>";
                  count6++;
                  if(count6==8){this.Otherlist+="</tr><td>"}
                }
                
            };
            this.professorlist+=new Array(9-count1).join("<td></td>")+"</tr>";
            this.AssProfessorlist+=new Array(9-count2).join("<td></td>")+"</tr>";
            this.Postdoctorallist+=new Array(9-count3).join("<td></td>")+"</tr>";
            this.Doctorlist+=new Array(9-count4).join("<td></td>")+"</tr>";
            this.Masterlist+=new Array(9-count5).join("<td></td>")+"</tr>";
            this.Otherlist+=new Array(9-count6).join("<td></td>")+"</tr>";

            console.log(this.professorlist);
            console.log(this.AssProfessorlist);
              
        }, response => {
            console.log("error");
          });
        // professorlist:"<tr ><td>单元格1</td><td> 单元格2</td><td> 单元格3</td><td>单元格4</td><td> 单元格5</td><td> 单元格6</td><td>单元格7</td><td> 单元格8</td></td>"      ,
      },

    },
  }

</script>