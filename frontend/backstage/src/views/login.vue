<template>
  <div id="login">
    <div class="login_title">武汉理工生物信息实验室后台</div>
    <el-form class="login_show" ref="form" :model="form" label-width="80px" label-position="left">
      <el-form-item label="用户名：">
        <el-input placeholder="请输入账号" v-model="form.name" style="width:300px;"></el-input>
      </el-form-item>
      <el-form-item label="密码：">
        <el-input placeholder="请输入密码" style="width:300px;" v-model="form.password" show-password></el-input>
      </el-form-item>
      <el-row>
          <el-button class="login_submit" @click="login">登陆</el-button>
        </el-row>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        name: "",
        password: ""
      }
    };
  },
  methods: {
    login(){
      if(this.form.name === "admin" && this.form.password == "123"){
        this.$router.push({path:"/home"});
      }
      else{
        this.$message.error('账号或密码错误！');
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.login_title {
  font-size: 30px;
  margin-left: 40%;
  margin-top: 10%;
}
.login_show {
  width: 400px;
  border: 1.5px solid #fff8dc;
  background-color: #fff8dc;
  padding-top: 20px;
  padding-left: 10px;
  padding-right: 10px;
  margin-left: 40%;
  margin-top: 2%;
}
.login_submit {
  width: 350px;
  margin-top: 30px;
  margin-left:10px;
  margin-bottom: 10px;
}
</style>
