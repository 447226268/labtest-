<template>
  <div>
    <div class="show">新闻编辑</div>

    <el-form ref="form" :model="form" label-width="85px" label-position="left" class="postion">
      <el-form-item label="类型选择:" :required="true">
        <el-select v-model="form.nl_subType_id">
          <el-option
            v-for="(item, i) in form_type"
            :key="i"
            :label="item.ns_name"
            :value="item.ns_id"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="标题:" :required="true">
        <el-input v-model="form.nl_title"></el-input>
      </el-form-item>

      <el-form-item label="活动时间:" :required="true">
        <el-date-picker type="date" placeholder="选择日期"  value-format="yyyy-MM-dd" v-model="form.nl_date" style="width: 100%;"></el-date-picker>
      </el-form-item>

      <el-form-item label="封面上传:">
        <el-upload
          class="upload"
          :action="url"
          :multiple="false"
          :auto-upload="false"
          name="file"
          ref="upload"
          :limit="1"
          :file-list="filelist"
          :on-change="on_change"
          :on-remove="removeimg"
        >
          <i class="el-icon-plus plus"></i>
        </el-upload>

        <el-dialog :visible.sync="dialogVisible" size="tiny">
          <img width="100%" :src="dialogImageUrl" alt="" />
        </el-dialog>
        <el-button type="primary" @click="showpic" class="width">预览图片</el-button>
      </el-form-item>

      <el-radio class="postion" v-model="radio" label="1">自定义编辑</el-radio>

      <div id="id1">
        <tinymce ref="editor" v-model="form.nl_content"></tinymce>
      </div>

      <el-radio class="postion" v-model="radio" label="2">外部链接跳转</el-radio>
      <div id="id2">
        <el-input v-model="form.nl_url" placeholder></el-input>
      </div>

      <div class="postion">
        <el-button type="primary" @click="updataNews" class="width">保存</el-button>
        <el-button type="primary" @click="updataNewsstate" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>
    </el-form>
  </div>
</template>
<script>
import tinymce from "@/components/tinymce.vue";
import {
  url_getNewsIndex,
  getNewsIndex,
  url_updataNewsIndex,
  updataNewsIndex,
  url_insertNews,
  insertNews,
  url_uploadPic
} from "@/api";
export default {
  data() {
    return {
      index: 0,
      radio: "1",
      url: "",
      filelist:[],
      dialogImageUrl:"",
      dialogVisible: false,
      form_type: [],
      form: {
        nl_id: -1,
        nl_state: 0,
        nl_subType_id: -1,
        nl_title: "",
        nl_date: "",
        nl_content: "",
        nl_url: "",
        nl_graph: ""
      }
    };
  },
  watch: {
    radio: function(val) {
      if (val == "1") {
        document.getElementById("id1").style.cssText = "";
        document.getElementById("id2").style.cssText = "pointer-events: none;";
        this.form.nl_url = "";
      } else {
        document.getElementById("id1").style.cssText = "pointer-events: none;";
        document.getElementById("id2").style.cssText = "";
        this.form.nl_content = "";
      }
    }
  },
  components: {
    tinymce
  },
  created() {
    this.index = this.$route.params.index;
    this.getNews();
  },
  methods: {
    gobackpage() {
      this.$router.go(-1);
    },
    on_change(file){
       var reader = new FileReader()
      reader.readAsDataURL(file.raw)
      reader.onload = () => {
        this.form.nl_graph = reader.result;
        let s = {name: file.name, url: reader.result};
        this.filelist.push(s);
        this.dialogImageUrl = reader.result;
      }
    },
    removeimg(){
      this.dialogImageUrl = "";
      this.form.nl_graph = "";
      this.filelist.splice(0, 1);
      this.dialogVisible = false;
    },
    showpic(){
      this.dialogVisible = true;
    },
    async updataNewsstate() {
      this.form.nl_state = 1;
      let a = await updataNewsIndex(url_updataNewsIndex, this.form, "post");
      this.$router.go(-1);
    },
    async updataNews() {
      if (this.index == "-1") {
        let a = await insertNews(url_insertNews, this.form, "post");
      } else {
        let a = await updataNewsIndex(url_updataNewsIndex, this.form, "post");
      }
      this.$router.go(-1);
    },
    async getNews() {
      let s = { id: this.$route.params.index };
      let a = await getNewsIndex(url_getNewsIndex, s);
      if (a.data.result.notice != null) {
        this.form.nl_id = a.data.result.notice.nl_id;
        this.form.nl_state = a.data.result.notice.nl_state;
        this.form.nl_subType_id = parseInt(a.data.result.notice.nl_subType_id);
        this.form.nl_title = a.data.result.notice.nl_title;
        this.form.nl_date = new Date(a.data.result.notice.nl_date);
        this.form.nl_content = a.data.result.notice.nl_content;
        this.form.nl_url = a.data.result.notice.nl_url;
        this.form.nl_graph = a.data.result.notice.nl_graph;
        if (this.form.nl_content === "") {
          this.radio = "2";
        }
        if(this.form.nl_graph !== ""){
          this.dialogImageUrl = this.form.nl_graph;
          let s = {name: "图片", url: this.form.nl_graph};
          this.filelist.push(s);
        }
      }
      for (let i = 0; i < a.data.result.type.length; i++) {
        this.form_type.push(a.data.result.type[i]);
      }
      if (this.form.nl_subType_id == -1) {
        this.form.nl_subType_id = this.form_type[0].ns_id;
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
.upload {
  height: 100px;
  width: 300px;
  border: 1px solid #c0c4cc;
  margin-bottom: 40px;
}
.plus {
  font-size: 50px;
  text-align: center;
  width: 300px;
  margin-top: 20px;
  margin-bottom: 30px;
}
</style>