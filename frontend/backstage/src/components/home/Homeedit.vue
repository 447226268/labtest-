<template>
  <div>
    <div name="图片上传">
      <div style="height:240px; float:left; position:relative">
        <div class="show">新闻动态配图</div>
        <el-upload
          style="margin:20px"
          ref="upload_news"
          action=""
          :auto-upload="false"
          list-type="picture-card"
          :limit=1
          :file-list="news_list"
          :on-change="on_change_news"
          :on-preview="handlePictureCardPreview_news"
          :on-remove="handleRemove_news"
        >
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="newsVisible">
          <img width="100%" :src="figure_form[0].hn_graph" alt />
        </el-dialog>
      </div>

      <div style="height:240px; margin-left: 500px; padding-bottom:10px; position:relative">
        <div class="show">学术活动配图</div>
        <el-upload
          style="margin:20px"
          action=""
          list-type="picture-card"
          :limit=1
          :auto-upload="false"
          :file-list="meeting_list"
          :on-change="on_change_meeting"
          :on-preview="handlePictureCardPreview_meeting"
          :on-remove="handleRemove_meeting"
        >
          <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="meetingVisible">
          <img width="100%" :src="figure_form[1].hn_graph" alt />
        </el-dialog>
      </div>

      <div class="postion">
        <el-button type="primary" @click="updataFigure" class="width">保存</el-button>
        <el-button type="primary" @click="updataFigurestate" class="width">发布</el-button>
        <el-button type="danger" @click="pagereflsh" class="width">取消</el-button>
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
import {
  getHomeFigure,
  url_insertHomeFigure,
  insertHomeFigure
} from "@/api/index.js";
export default {
  data() {
    return {
      figure_form:[
        {
          hn_graph: "",
          hn_id: 1,
          hn_state: 0,
        },
        {
          hn_graph: "",
          hn_id: 2,
          hn_state: 0,
        }
      ],
      news_list:[
      
      ],
      meeting_list:[
  
      ],
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
  created() {
    this.getAllFigure();
  },
  methods: {
    pagereflsh(){
      this.$router.go(0);
    },
    handleRemove_news(file, fileList) {
      this.figure_form[0].hn_graph = "";
      this.figure_form[0].hn_state = 0;
    },
    on_change_news(file){
      var reader = new FileReader()
      reader.readAsDataURL(file.raw)
      reader.onload = () => {
        this.figure_form[0].hn_graph = reader.result;
        this.figure_form[0].hn_state = 0;
      }
    },
    handlePictureCardPreview_news(file) {
      this.newsVisible = true;
    },
    handleRemove_meeting(file, fileList) {
      this.figure_form[1].hn_graph = "";
      this.figure_form[1].hn_state = 0;
    },
    on_change_meeting(file){
      var reader = new FileReader()
      reader.readAsDataURL(file.raw)
      reader.onload = () => {
        this.figure_form[1].hn_graph = reader.result;
        this.figure_form[1].hn_state = 0;
      }
    },
    handlePictureCardPreview_meeting(file) { 
      this.meetingVisible = true;
    },
    async updataFigure(){
      let a = await insertHomeFigure(url_insertHomeFigure, this.figure_form, "post");
      if(a.data.result === "插入成功"){
        this.$message({
          message: '恭喜你，图片上传成功!',
          type: 'success'
        });
        //this.$router.go(0);
      }
      else{
        this.$message.error('图片上传失败!');
        this.getAllFigure();
        //this.$router.go(0);
      }
    },
    async updataFigurestate(){
      this.figure_form[0].hn_state = 1;
      this.figure_form[1].hn_state = 1;
      let a = await insertHomeFigure(url_insertHomeFigure, this.figure_form, "post");
      if(a.data.result === "插入成功"){
        this.$message({
          message: '恭喜你，图片已发布!',
          type: 'success'
        });
        //this.$router.go(0);
      }
      else{
        this.$message.error('图片发布失败!');
        this.getAllFigure();
        //this.$router.go(0);
      }
    },
    async getAllFigure() {
      let a = await getHomeFigure();
      if (a.data.result !== null){
        for(let i = 0; i < a.data.result.length; i++){
          if(a.data.result[i].hn_id == 1 && a.data.result[i].hn_graph !== ""){
            this.figure_form[0].hn_graph = a.data.result[i].hn_graph;
            this.figure_form[0].hn_state = a.data.result[i].hn_state;
            this.news_list.push({url : a.data.result[i].hn_graph})
          }
          if(a.data.result[i].hn_id == 2 && a.data.result[i].hn_graph !== ""){
            this.figure_form[1].hn_graph = a.data.result[i].hn_graph;
            this.figure_form[1].hn_state = a.data.result[i].hn_state;
            this.meeting_list.push({url : a.data.result[i].hn_graph})
          }
        }
      }
    },
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