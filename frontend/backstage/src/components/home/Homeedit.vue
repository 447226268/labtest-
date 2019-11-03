<template>
  <div>
    <div name="图片上传">
      <div style="height:240px; float:left; position:relative">
        <div class="show">新闻动态配图</div>
        <el-upload
          style="margin:20px"
          action="https://jsonplaceholder.typicode.com/posts/"
          list-type="picture-card"
          limit="1"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
        >
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="newsVisible">
          <img width="100%" :src="newsImageUrl" alt />
        </el-dialog>
      </div>

      <div style="height:240px; margin-left: 500px; padding-bottom:10px; position:relative">
        <div class="show">学术活动配图</div>
        <el-upload
          style="margin:20px"
          action="https://jsonplaceholder.typicode.com/posts/"
          list-type="picture-card"
          limit="1"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
        >
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="meetingVisible">
          <img width="100%" :src="meetingImageUrl" alt />
        </el-dialog>
      </div>

      <div class="postion">
        <el-button type="primary" @click="updataNotice" class="width">保存</el-button>
        <el-button type="primary" @click="updataNoticestate" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>
    </div>

    <div name="友情链接" class="link_main">
      <div class="show">友情链接</div>

      <el-form ref="form" :model="form_links" label-width="80px">
        <div class="link_input">
          <el-input v-model="form_links.name" style="width:300px; float:left"></el-input>
          <el-input v-model="form_links.name" style="width:500px; margin-left:200px"></el-input>
        </div>
        <el-button icon="el-icon-plus" class="link_input_ico" circle></el-button>
      </el-form>

      <div class="postion">
        <el-button type="primary" @click="updataNotice" class="width">保存</el-button>
        <el-button type="primary" @click="updataNoticestate" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>

    </div>

    <div name="页脚设置" class="link_main">
      <div class="show">页脚设置</div>

      <el-form ref="form" :model="form_footer" label-width="80px">
        <div class="link_input">
          <el-form-item label="输入框1：">
            <el-input style="width: 700px;" v-model="form_footer.url"></el-input>
        </el-form-item>
        </div>
        <el-button icon="el-icon-plus" class="link_input_ico" circle></el-button>
      </el-form>

      <div class="postion">
        <el-button type="primary" @click="updataNotice" class="width">保存</el-button>
        <el-button type="primary" @click="updataNoticestate" class="width">发布</el-button>
        <el-button type="danger" @click="gobackpage" class="width">取消</el-button>
      </div>

    </div>


  </div>
</template>

<script>
import {} from "@/api/index.js";
export default {
  data() {
    return {
      newsImageUrl: "",
      newsVisible: false,
      meetingImageUrl: "",
      meetingVisible: false,
      form_links: {
        name: "www.baidu.com"
      },
      form_footer: {
        url: "武汉理工大学"
      }
    };
  },
  created() {},
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.newsImageUrl = file.url;
      this.newsVisible = true;
    }
  }
};
</script>

<style scoped>
.show {
  text-align: center;
  padding-bottom: 10px;
  margin: 5px;
  width: 100px;
  border-bottom: 2px solid green;
}
.postion {
  margin: 5px;
  float: right;
  position: relative;
}
.width {
  width: 100px;
}
.link_main {
  margin-top: 60px;
}
.link_input {
  margin: 10px;
}
.link_input_ico{
    margin-left: 80%;
    margin-bottom: 10px;
}
</style>