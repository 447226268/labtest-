<template>
  <div>
    <div>
      <div class="show" style="border-bottom: 0px ; margin-right:30px ; cursor:pointer" v-on:click="go2introduction">实验室简介</div>
      <div class="show" style="margin-right:30px; ">研究方向</div>
      <div class="show" style="border-bottom: 0px ; margin-right:30px ; cursor:pointer" v-on:click="go2team" >研究团队</div>
      <div class="show" style="border-bottom: 0px ; margin-right:30px ; cursor:pointer" v-on:click="go2graduates">毕业生</div>
    </div>

    <el-form ref="form" :model="form" label-width="85px" label-position="left" class="postion">
      <el-form-item label="标题:" :required="true">
        <el-input v-model="form.nl_title"></el-input>
      </el-form-item>

      <div id="id1">
        <tinymce ref="editor" v-model="form.nl_content"></tinymce>
      </div>

      <div class="postion">
        <el-button type="primary" @click="updataNotice" class="width">保存</el-button>
        <el-button type="primary" @click="updataNoticestate" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>
    </el-form>
  </div>
</template>
<script>
import tinymce from "@/components/tinymce.vue";
import {
  url_getNoticetIndex,
  getNoticetIndex,
  url_updataNoticeIndex,
  updataNoticeIndex,
  url_insertNotice,
  insertNotice
} from "@/api";
export default {
  data() {
    return {
      form: {
        nl_state: 0,
        nl_title: "",
        nl_content: ""
      }
    };
  },

  components: {
    tinymce
  },
  created() {
    this.getNotification();
  },
  methods: {
    gobackpage() {
      this.$router.go(-1);
    },
    go2introduction() {
      this.$router.push({
          path: "/laboratory/introducution/"
      });
    },
    go2team() {
      this.$router.push({
          path: "/laboratory/team/"
      });
    },
    go2graduates() {},
    async updataNoticestate() {
      this.form.nl_state = 1;
      let a = await updataNoticeIndex(url_updataNoticeIndex, this.form, "post");
      this.$router.go(-1);
    },
    async updataNotice() {
      if (this.index == "-1") {
        let a = await insertNotice(url_insertNotice, this.form, "post");
      } else {
        let a = await updataNoticeIndex(
          url_updataNoticeIndex,
          this.form,
          "post"
        );
      }
      this.$router.go(-1);
    },

    async getNotification() {
      let a = await getNoticetIndex(url_getNoticetIndex, s);
      if (a.data.result.notice != null) {
        this.form.nl_id = a.data.result.notice.nl_id;
        this.form.nl_state = a.data.result.notice.nl_state;
        this.form.nl_subType_id = parseInt(a.data.result.notice.nl_subType_id);
        this.form.nl_title = a.data.result.notice.nl_title;
        this.form.nl_date = new Date(a.data.result.notice.nl_date);
        this.form.nl_content = a.data.result.notice.nl_content;
        this.form.nl_url = a.data.result.notice.nl_url;
        if (this.form.nl_content === "") {
          this.radio = "2";
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