<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="配图上传" name="0"></el-tab-pane>
    <el-tab-pane label="友情链接管理" name="1"></el-tab-pane>
    <el-tab-pane label="页脚设置管理" name="2"></el-tab-pane>
    <router-view></router-view>
  </el-tabs>
</template>
<script>
export default {
  data() {
    return {
      labels: ["配图上传", "友情链接管理", "页脚设置管理"],
      activeName: "0"
    };
  },
  methods: {
    handleClick(tab, event) {
      this.$router.push({
        path: "/首页管理/" + this.labels[parseInt(this.activeName) - 0]
      });
    }
  }
};
</script>