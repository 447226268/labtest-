<template>
  <div class="webaside">
    <el-aside width="300px" style="background-color: white" >

        <div id="asidetitle" >
            {{asidetitle}}
        </div>

        <el-menu
        :default-active="asideActive"
        class="asidemenu"
        :router="true">
        <el-menu-item v-for="item in typelist" :key="item.nl_subType_id" :index="item.index"  :route="'/'+routertype+item.index">
            <span slot="title">{{item.nl_nl_subType_name}}</span>
        </el-menu-item>
        </el-menu>

    </el-aside>
  </div>
</template>

<style scope>
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

</style>

<script>
export default {
  name: "webaside",
  data (){
    return {
    }
  },
  props: {asideActive:String,asidetitle:String,typelist:Array,routertype:String},

};
</script>