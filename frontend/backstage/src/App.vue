<template>
  <el-container class="container-main">
    <el-header>
      <Header></Header>
    </el-header>

    <el-container>
      <el-aside>
        <Navmenuleft></Navmenuleft>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Header from "@/components/main/Header.vue";
import Navmenuleft from "@/components/main/Navmenuleft.vue";

export default {
  data() {
    return {
      header_image_whut: require("./assets/images/whutlogo.png")
    };
  },
  components: {
    Header,
    Navmenuleft
  }
};
</script>


<style>
.container-main {
  margin: 0px;
  padding: 0px;
  height: 100%;
}

.el-header,
.el-footer {
  width: 100%;
  height: 60px;
  color: black;
  text-align: center;
  background-color: #669933;
}

.el-aside {
  background-color: #f0ffff;
}

.el-main {
  background-color: white;
  color: #333;
  margin: 10px;
  border: 1px solid #c0c4cc;
}
</style>