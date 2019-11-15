<template>
  <div>
    <div class="show">论文编辑</div>
    
    <el-form ref="form" :model="form" label-width="85px" label-position="left" class="postion">

      <el-form-item label="论文题目:" :required="true">
        <el-input v-model="form.tl_title"></el-input>
      </el-form-item>

      <el-form-item label="刊物名称:" :required="true">
        <el-input v-model="form.tl_journal"></el-input>
      </el-form-item>
      
      <el-form-item label="第一作者:" :required="true">
        <el-input v-model="form.tl_writer"></el-input>
      </el-form-item>

      <el-form-item label="发表年度:" :required="true">
        <el-date-picker type="year" placeholder="选择日期" v-model="form.tl_year" style="width: 100%;"></el-date-picker>
      </el-form-item>

      <el-form-item label="发表时间:" :required="true">
        <el-date-picker type="date" placeholder="选择日期" value-format="yyyy-MM-dd" v-model="form.tl_date" style="width: 100%;"></el-date-picker>
      </el-form-item>

      <el-radio class="postion" v-model="radio" label="1">自定义编辑</el-radio>

      <div id="id1">
        <tinymce ref="editor" v-model="form.tl_content"></tinymce>
      </div>

      <el-radio class="postion" v-model="radio" label="2">外部链接跳转</el-radio>
      <div id="id2">
        <el-input v-model="form.tl_url" placeholder></el-input>
      </div>

      <div class="postion">
        <el-button type="primary" @click="updataArticle" class="width">保存</el-button>
        <el-button type="primary" @click="updataArticlestate" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>
    </el-form>
  </div>
</template>
<script>
import tinymce from "@/components/tinymce.vue";
import {
  url_getArticleIndex,
  getArticleIndex,
  url_updataArticleIndex,
  updataArticleIndex,
  url_insertArticle,
  insertArticle
} from "@/api";
export default {
  data() {
    return {
      index: 0,
      radio: "1",
      form_type: [],
      form: {
        tl_id: -1,
        tl_state: 0,
        tl_writer: "",
        tl_journal: "",
        tl_title: "",
        tl_date: "",
        tl_year:"",
        tl_content: "",
        tl_url: ""
      }
    };
  },
  watch: {
    radio: function(val) {
      if (val == "1") {
        document.getElementById("id1").style.cssText = "";
        document.getElementById("id2").style.cssText = "pointer-events: none;";
        this.form.tl_url = "";
      } else {
        document.getElementById("id1").style.cssText = "pointer-events: none;";
        document.getElementById("id2").style.cssText = "";
        this.form.tl_content = "";
      }
    }
  },
  components: {
    tinymce
  },
  created() {
    this.index = this.$route.params.index;
    this.getArticle();
  },
  methods: {
    gobackpage() {
      this.$router.go(-1);
    },
    async updataArticlestate() {
      this.form.tl_state = 1;
      if (this.index == "-1") {
        this.form.tl_year = new Date(this.form.tl_year).getFullYear().toString();
        let a = await insertArticle(url_insertArticle, this.form, "post");
      } else {
        this.form.tl_year = new Date(this.form.tl_year).getFullYear().toString();
        let a = await updataArticleIndex(
          url_updataArticleIndex,
          this.form,
          "post"
        );
      }
      this.$router.go(-1);
    },
    async updataArticle() {
      if (this.index == "-1") {
        this.form.tl_year = new Date(this.form.tl_year).getFullYear().toString();
        let a = await insertArticle(url_insertArticle, this.form, "post");
      } else {
        this.form.tl_year = new Date(this.form.tl_year).getFullYear().toString();
        let a = await updataArticleIndex(
          url_updataArticleIndex,
          this.form,
          "post"
        );
      }
      this.$router.go(-1);
    },

    async getArticle() {
      let s = { id: this.$route.params.index };
      let a = await getArticleIndex(url_getArticleIndex, s);
      if (a.data.result != null) {
        this.form.tl_id = a.data.result.tl_id;
        this.form.tl_state = a.data.result.tl_state;
        this.form.tl_title = a.data.result.tl_title;
        this.form.tl_journal = a.data.result.tl_journal;
        this.form.tl_writer = a.data.result.tl_writer;
        this.form.tl_date = new Date(a.data.result.tl_date);
        this.form.tl_year = a.data.result.tl_year;
        this.form.tl_content = a.data.result.tl_content;
        this.form.tl_url = a.data.result.tl_url;
        if(this.form.tl_content === ""){
          this.radio = "2"
        }
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
  border-bottom: 2px solid green;
}
.postion {
  margin: 5px;
}
.width {
  width: 100px;
}
</style>