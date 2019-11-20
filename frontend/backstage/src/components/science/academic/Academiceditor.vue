<template>
  <div>
    <div class="show">学术编辑</div>

    <el-form ref="form" :model="form" label-width="100px" label-position="left" class="postion">
      
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

      <el-form-item label="发布时间:" :required="true">
        <el-date-picker type="date" placeholder="选择日期" value-format="yyyy-MM-dd" v-model="form.nl_date" style="width: 100%;"></el-date-picker>
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
        <el-button type="primary" @click="updataAcademic" class="width">保存</el-button>
        <el-button type="primary" @click="updataAcademicstate" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>
    </el-form>
  </div>
</template>
<script>
import tinymce from "@/components/tinymce.vue";
import {
  url_getAcademicIndex,
  getAcademicIndex,
  url_updataAcademicIndex,
  updataAcademicIndex,
  url_insertAcademic,
  insertAcademic
} from "@/api";
export default {
  data() {
    return {
      index: 0,
      radio: "1",
      form_type: [],
      form: {
        nl_id: -1,
        nl_state: 0,
        nl_subType_id: -1,
        nl_title: "",
        nl_date: "",
        nl_content: "",
        nl_url: ""
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
    this.getAcademic();
  },
  methods: {
    gobackpage() {
      this.$router.go(-1);
    },
    async updataAcademicstate() {
      this.form.nl_state = 1;
      if (this.index == "-1") {
        let a = await insertAcademic(url_insertAcademic, this.form, "post");
      } else {
        let a = await updataAcademicIndex(
          url_updataAcademicIndex,
          this.form,
          "post"
        );
      }
      this.$router.go(-1);
    },
    async updataAcademic() {
      if (this.index == "-1") {
        let a = await insertAcademic(url_insertAcademic, this.form, "post");
      } else {
        let a = await updataAcademicIndex(
          url_updataAcademicIndex,
          this.form,
          "post"
        );
      }
      this.$router.go(-1);
    },

    async getAcademic() {
      let s = { id: this.$route.params.index };
      let a = await getAcademicIndex(url_getAcademicIndex, s);
      if (a.data.result.meeting != null) {
        this.form.nl_id = a.data.result.meeting.nl_id;
        this.form.nl_state = a.data.result.meeting.nl_state;
        this.form.nl_subType_id = parseInt(a.data.result.meeting.nl_subType_id);
        this.form.nl_title = a.data.result.meeting.nl_title;
        this.form.nl_date = new Date(a.data.result.meeting.nl_date);
        this.form.nl_content = a.data.result.meeting.nl_content;
        this.form.nl_url = a.data.result.meeting.nl_url;
        if (this.form.nl_content === "") {
          this.radio = "2";
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
</style>