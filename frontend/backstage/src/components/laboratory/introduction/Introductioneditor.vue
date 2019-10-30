<template>
  <div>
    <div>
      <div class="show" style="margin-right:30px">实验室简介</div>
      <div class="show" style="border-bottom: 0px ; margin-right:30px; cursor:pointer" v-on:click="go2direction">研究方向</div>
      <div class="show" style="border-bottom: 0px ; margin-right:30px; cursor:pointer" v-on:click="go2team">研究团队</div>
      <div class="show" style="border-bottom: 0px ; margin-right:30px; cursor:pointer" v-on:click="go2graduates">毕业生</div>
    </div>

    <el-form ref="form" :model="form" label-width="85px" label-position="left" class="postion">

      <el-form-item label="标题:" :required="true">
        <el-input v-model="form.li_overview_title"></el-input>
      </el-form-item>

      <div id="id1">
        <tinymce ref="editor" v-model="form.li_overview"></tinymce>
      </div>

      <div class="postion">
        <el-button type="primary" @click="updataIntro" class="width">保存</el-button>
        <el-button type="primary" @click="updataIntro" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>
    </el-form>
  </div>
</template>
<script>
import tinymce from "@/components/tinymce.vue";
import {
  getLabIntroduction,
  url_updataIntroduction,
  updataIntroduction,
} from "@/api";
export default {
  data() {
    return {
      form: {
        li_id: 0,
        li_overview: "",
        li_overview_title: "",
      }
    };
  },
  
  components: {
    tinymce
  },
  created() {
    this.getIntroduction();
  },
  methods: {
    gobackpage() {
      this.$router.go(-1);
    },
    go2direction(){
      this.$router.push({
          path: "/laboratory/direction/"
      });
    },
    go2team(){
      this.$router.push({
          path: "/laboratory/team/"
      });
    },
    go2graduates(){
       this.$router.push({
          path: "/laboratory/graduates/"
      });
    },
    async updataIntro() {
      let a = await updataIntroduction(
        url_updataIntroduction,
        this.form,
        "post"
        );
      this.$router.go(0);
    },

    async getIntroduction() {
      let a = await getLabIntroduction();
      if (a.data.result != null) {
        this.form.li_id = a.data.result.li_id;
        this.form.li_overview_title = a.data.result.li_overview_title;
        this.form.li_overview = a.data.result.li_overview;
      }
    }
  }
};
</script>

<style>
.show {
  text-align: center;
  padding-bottom: 10px;
  margin: 5px;
  width: 80px;
  display: inline-block;
  border-bottom: 2px solid green;
}
.postion {
  margin: 5px;
}
.width {
  width: 100px;
}
</style>