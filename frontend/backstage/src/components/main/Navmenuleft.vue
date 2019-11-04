<template>
  <el-col>
    <el-menu
      default-active="1"
      class
      background-color="#F0FFFF"
      active-text-color="#ffd04b"
      router="true"
    >
      <el-menu-item index="1" route="/home">
        <i class="el-icon-menu"></i>
        <span slot="title">首页管理</span>
      </el-menu-item>

      <el-menu-item index="2" route="/laboratory/introducution">
        <i class="el-icon-setting"></i>
        <span slot="title">实验室简介</span>
      </el-menu-item>

      <el-menu-item index="3" route="/news/show">
        <i class="el-icon-s-order"></i>
        <span slot="title">新闻动态</span>
      </el-menu-item>

      <el-menu-item index="4" route="/notice/show">
        <i class="el-icon-s-platform"></i>
        <span slot="title">通知公告</span>
      </el-menu-item>
      <el-menu-item index="5" route="/scince/article/show">
        <i class="el-icon-s-management"></i>
        <span slot="title">科研工作</span>
      </el-menu-item>

      <el-menu-item index="6" route="/source/show">
        <i class="el-icon-upload"></i>
        <span slot="title">资源发布</span>
      </el-menu-item>
    </el-menu>
    <el-menu class background-color="#F0FFFF" active-text-color="#ffd04b">
      <el-menu-item  @click="exit">
        <i class="el-icon-user-solid"></i>
        <span slot="title">退出登陆</span>
      </el-menu-item>
    </el-menu>
  </el-col>
</template>

<style>
.el-menu {
  width: 300px;
  height: 100%;
}
</style>

<script>
export default {
  methods: {
    exit() {
      this.$confirm("是否退出管理后台?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$router.push({path:"/"});
        }).catch(() => {
          this.$message({
            type: "info",
            message: "退出取消",
          });
        });  
    }
  }
};
</script>