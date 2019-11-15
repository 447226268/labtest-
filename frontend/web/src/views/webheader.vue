<template>    
    <div class="webheader">
      <el-header height ="350px" >

        <div id="labname" >
            武汉理工大学智能生物信息实验室
        </div>

        <div id="WUTBIOLAB" >
            <span style="color:yellow;">W</span>UTBIOLAB
        </div>
        
        <el-image class="lablogo"
            style="width: 270px;height: 100px;"
            :src="require('../assets/images/Group8.png')"
            :fit="'fill'">
        </el-image>

        <el-menu
          :default-active="activeIndex"
          class="navigation"
          mode="horizontal"
          background-color="#398ef3"
          text-color="#fff"
          active-text-color="yellow"
          router>
          <el-menu-item index="1" route="/">首页</el-menu-item>
          <el-menu-item index="2" route="/lab1">实验室简介</el-menu-item>
          <el-menu-item index="3" route="/news1">新闻动态</el-menu-item>
          <el-menu-item index="4" route="/notice1">通知公告</el-menu-item>
          <el-menu-item index="5" route="/thesis">科研工作</el-menu-item>
          <el-menu-item index="6" route="/resource1">资源发布</el-menu-item>
        </el-menu> 

      </el-header>
    </div>
</template>

<style>
  .el-header {
    background-image: url('../assets/images/banner1.png');
    background-size:1200px 300px;
    background-repeat:no-repeat;
    background-attachment:fill;
    width: 1200px;
    position: relative;
    margin:auto;
    margin-top:0;
    margin-bottom:0;
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
    top:105px;
    margin: auto
  } 

  el-menu-item{
    font-size:20px;
  }

  navigation el-menu--horizontal el-menu{
    margin: auto
  }
</style>

<script>
export default {
  name: "webheader",
  data (){
    return {

    }
  },
  props: ['activeIndex'],
};
</script>