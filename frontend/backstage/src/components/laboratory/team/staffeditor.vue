<template>
  <div>
    <div class="show">个人信息</div>

    <el-form ref="form" :model="form" label-width="85px" label-position="left" class="postion">

      <el-form-item label="姓名:" :required="true">
        <div>{{form.name}}</div>
      </el-form-item>

      <el-form-item label="封面上传:">
        <el-upload
          class="upload"
          :action="url"
          :multiple="false"
          name="file"
          ref="upload"
          :limit="1"
          :file-list="filelist"
          :on-success="success"
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
        <tinymce ref="editor" v-model="form.info.si_content"></tinymce>
      </div>

      <el-radio class="postion" v-model="radio" label="2">外部链接跳转</el-radio>
      <div id="id2">
        <el-input v-model="form.info.si_url" placeholder></el-input>
      </div>

      <div class="postion">
        <el-button type="primary" @click="updataStaff" class="width">保存</el-button>
        <el-button type="primary" @click="updataStaffstate" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>
    </el-form>
  </div>
</template>
<script>
import tinymce from "@/components/tinymce.vue";
import {
  url_getStaffIndex,
  getStaffIndex,
  url_updataStaffIntroIndex,
  updataStaffIntroIndex,
  url_insertNews,
  insertNews,
  url_uploadPic
} from "@/api";
export default {
  data() {
    return {
      index: 0,
      radio: "1",
      url: url_uploadPic,
      filelist:[],
      dialogImageUrl:"",
      dialogVisible: false,
      form: {
        id: -1,
        name: "",
        type: "",
        type_id: 0,
        info:{
          si_content: "",
          si_graph: "",
          si_id: -1,
          si_state: 0,
          si_uid: 0,
          si_url: "",
          },
      },
      
    };
  },
  watch: {
    radio: function(val) {
      if (val == "1") {
        document.getElementById("id1").style.cssText = "";
        document.getElementById("id2").style.cssText = "pointer-events: none;";
        this.form.info.si_url = "";
      } else {
        document.getElementById("id1").style.cssText = "pointer-events: none;";
        document.getElementById("id2").style.cssText = "";
        this.form.info.si_content = "";
      }
    }
  },
  components: {
    tinymce
  },
  mounted() {
    this.index = this.$route.params.index;
    this.getStaff();
  },
  methods: {
    gobackpage() {
      this.$router.go(-1);
    },
    success(res, file){
      this.dialogImageUrl = URL.createObjectURL(file.raw);
      this.form.info.si_graph = process.env.VUE_APP_BASE_API + res.result;
      let s = {name: file.name, url: URL.createObjectURL(file.raw)};
      this.filelist.push(s);
    },
    removeimg(){
      this.dialogImageUrl = "";
      this.form.info.si_graph = "";
      this.filelist.splice(0, 1);
      this.dialogVisible = false;
    },
    showpic(){
      this.dialogVisible = true;
    },
    async updataStaffstate() {
      if(this.form.info.si_id !== -1)
      {
        this.form.info.si_state = 1;
        let a = await updataStaffIntroIndex(url_updataStaffIntroIndex, this.form, "post");
        this.$router.go(-1);
      }
    },
    async updataStaff() {
      if(this.form.info.si_id !== -1)
      {
        let a = await updataStaffIntroIndex(url_updataStaffIntroIndex, this.form, "post");
        this.$router.go(-1);
      }
    },
    async getStaff() {
      let a = await getStaffIndex( url_getStaffIndex + "/" + this.$route.params.index , {});
      if (a.data.result != null) {
        this.form.id = a.data.result.id;
        this.form.name = a.data.result.name;
        this.form.type = a.data.result.type;
        this.form.type_id = a.data.result.type_id;
        this.form.info.si_content= a.data.result.info.si_content;
        this.form.info.si_graph= a.data.result.info.si_graph;
        this.form.info.si_id= a.data.result.info.si_id;
        this.form.info.si_state= a.data.result.info.si_state;
        this.form.info.si_uid= a.data.result.info.si_uid;
        this.form.info.si_url= a.data.result.info.si_url;
                
      if(this.form.info.si_content === "") {
          this.radio = "2";
        }
        if(this.form.info.si_graph !== ""){
          this.dialogImageUrl = this.form.info.si_graph;
          let s = {name: this.form.info.si_graph, url: this.form.info.si_graph};
          this.filelist.push(s);
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