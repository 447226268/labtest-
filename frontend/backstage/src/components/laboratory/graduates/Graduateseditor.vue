<template>
  <div>
    <div class="show">毕业生编辑</div>
      
      <el-form ref="form" :model="form" label-width="85px" label-position="left" class="postion">
        <el-form-item label="类型选择:" :required="true">
          <el-select v-model="form.type_id">
            <el-option
              v-for="(item, i) in form_type"
              :key="i"
              :label="item.name"
              :value="item.id"
            ></el-option>
          </el-select>
        </el-form-item>

      <el-form-item label="标题:" :required="true">
        <el-input v-model="form.title"></el-input>
      </el-form-item>

      <el-form-item label="活动时间:" :required="true">
        <el-date-picker type="date" placeholder="选择日期" value-format="yyyy-MM-dd" v-model="form.date" style="width: 100%;"></el-date-picker>
      </el-form-item>

      <el-radio class="postion" v-model="radio" label="1">自定义编辑</el-radio>

      <div id="id1">
        <tinymce ref="editor" v-model="form.content"></tinymce>
      </div>

      <el-radio class="postion" v-model="radio" label="2">外部链接跳转</el-radio>
      <div id="id2">
        <el-input v-model="form.url" placeholder></el-input>
      </div>

      <div class="postion">
        <el-button type="primary" @click="updataGraduate" class="width">保存</el-button>
        <el-button type="primary" @click="updataGraduatestate" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>
    </el-form>
  </div>
</template>
<script>
import tinymce from "@/components/tinymce.vue";
import {
  url_getGraduateIndex,
  getGraduateIndex,
  url_updataGraduateIndex,
  updataGraduateIndex,
  url_insertGraduate,
  insertGraduate
} from "@/api";
export default {
  data() {
    return {
      index: 0,
      radio: "1",
      form_type:[],
      form: {
        id: -1,
        type_id: 1,
        type: "毕业生",
        state: 0,
        title: "",
        date: "",
        content: "",
        url: ""
      }
    };
  },
  watch: {
    radio: function(val) {
      if (val == "1") {
        document.getElementById("id1").style.cssText = "";
        document.getElementById("id2").style.cssText = "pointer-events: none;";
        this.form.url = "";
      } else {
        document.getElementById("id1").style.cssText = "pointer-events: none;";
        document.getElementById("id2").style.cssText = "";
        this.form.content = "";
      }
    }
  },
  components: {
    tinymce
  },
  created() {
    this.index = this.$route.params.index;
    this.getGraduate();
  },
  methods: {
    gobackpage() {
      this.$router.go(-1);
    },
    async updataGraduatestate() {
      this.form.nl_state = 1;
      let a = await updataGraduateIndex(url_updataGraduateIndex, this.form, "post");
      this.$router.go(-1);
    },
    async updataGraduate() {
      if (this.index == "-1") {
        let a = await insertGraduate(url_insertGraduate, this.form, "post");
      } else {
        let a = await updataGraduateIndex(
          url_updataGraduateIndex,
          this.form,
          "post"
        );
      }
      this.$router.go(-1);
    },

    async getGraduate() {
      let s = { id: this.$route.params.index };
      let a = await getGraduateIndex(url_getGraduateIndex, s);
      if (a.data.result.postgraduate != null) {
        this.form.id = a.data.result.postgraduate.id;
        this.form.state = a.data.result.postgraduate.state;
        this.form.nl_subType_id = parseInt(a.data.result.notice.nl_subType_id);
        this.form.title = a.data.result.postgraduate.title;
        this.form.date = new Date(a.data.result.postgraduate.date);
        this.form.content = a.data.result.postgraduate.content;
        this.form.url = a.data.result.postgraduate.url;
        if(this.form.content === ""){
          this.radio = "2"
        }
        for (let i = 0; i < a.data.result.type.length; i++) {
          this.form_type.push(a.data.result.type[i]);
        }
        if(this.form.type_id == -1){
          this.form.type_id = this.form_type[0].id;
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