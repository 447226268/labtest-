<template>
  <div class="footer">
    <el-container class="foot">  
      <el-col class="logoandname" width="600px" >

          <el-image class="lablogo"
            style="width: 70px;height: 70px;top: 75px"
            :src="require('../assets/images/whutlogo.png')"
            :fit="'fill'">
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
  </div>
</template>

<style>
  .foot{
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

<script>
export default {
  name: "footer",
  data (){
    return {}
  },
};
</script>