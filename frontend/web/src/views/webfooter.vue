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

          <div id="address" style="top:50px" v-for="item in tableData" :key="item.hf_id">
            <p>{{item.hf_text}}</p>
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

  import Axios from 'axios'

  export default {
    name : 'webfooter',

    data() {
      return {

        tableData: [],
      };
 
    },
    mounted() {
      this.getData();

    },    
    methods: {
      getData() {
        Axios.get('/api/footer/getFooters').then(response => {
            this.tableData=response.data.result;

              console.log(this.tableData);
        }, response => {
            console.log("error");
          });
      },
    },
  }
</script>