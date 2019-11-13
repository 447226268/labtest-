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

      <el-form ref="form" label-width="80px">
        <div class="link_input" v-for="(items, i) in links_form" :key="i">
          <el-input v-model="items.hl_text" style="width:300px; float:left"></el-input>
          <el-input v-model="items.hl_url" style="width:500px; margin-left:200px"></el-input>
          <el-button type="danger" icon="el-icon-delete" style="margin-left:40px" circle  @click="deleteLink(i)"></el-button>
        </div>
        <el-button icon="el-icon-plus" class="link_input_ico" circle @click="addLink"></el-button>
      </el-form>

      <div class="postion">
        <el-button type="primary" @click="updataLink" class="width">保存</el-button>
        <el-button type="primary" @click="updataLink" class="width">发布</el-button>
        <el-button type="danger" @click="pagereflsh" class="width">取消</el-button>
      </div>

    </div>

    <div name="页脚设置" class="link_main">
      <div class="show">页脚设置</div>

      <el-form ref="form" label-width="80px">
        <div class="link_input">
          <el-form-item label="输入框：" v-for="(items, i) in footer_form" :key="i">
            <el-input style="width: 700px;" v-model="items.hf_text"></el-input>
            <el-button type="danger" icon="el-icon-delete" style="margin-left:40px" circle  @click="deleteFooter(i)"></el-button>
        </el-form-item>
        </div>
        <el-button icon="el-icon-plus" class="link_input_ico" circle @click="addFooter"></el-button>
      </el-form>

      <div class="postion">
        <el-button type="primary" @click="updataFooterall" class="width">保存</el-button>
        <el-button type="primary" @click="updataFooterall" class="width">发布</el-button>
        <el-button type="danger" @click="pagereflsh" class="width">取消</el-button>
      </div>

    </div>


  </div>
</template>

<script>
import {
  getHomeFigure,
  url_insertHomeFigure,
  insertHomeFigure,
  getLinkall,
  url_updataLink,
  updataLink,
  getFooterall,
  url_updataFooter,
  updataFooter,
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
      news_list:[],
      meeting_list:[],
      newsVisible: false,
      meetingVisible: false,
      links_form:[],
      footer_form:[],
    };
  },
  created() {
    this.getAllFigure();
    this.getAllLink();
    this.getAllFooter();
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
    async getAllLink(){
      let a = await getLinkall();
      for(let i = 0; i < a.data.result.length; i++){
        let s = {};
        s.hl_id = a.data.result[i].hl_id;
        s.hl_text = a.data.result[i].hl_text;
        s.hl_url = a.data.result[i].hl_url;
        this.links_form.push(s);
      }
    },
    addLink(){
      let s ={};
      s.hl_id = -1;
      s.hl_text = "";
      s.hl_url = "";
      this.links_form.push(s);
    },
    deleteLink(i){
      this.links_form.splice(i, 1);
    },
    async updataLink(){

      let a = await updataLink(url_updataLink, this.links_form, "post");
      console.log(a);
      if(a.data.result === "插入成功"){
        this.$message({
          message: '恭喜你，链接设置成功!',
          type: 'success'
          });
          //this.$router.go(0);
      }
      else{
        this.$message.error('链接设置失败!');
        this.$router.go(0); 
      }
    },
    async getAllFooter(){
      let a = await getFooterall();
      for(let i = 0; i < a.data.result.length; i++){
        let s ={};
        s.hf_id = a.data.result[i].hf_id;
        s.hf_text = a.data.result[i].hf_text;
        this.footer_form.push(s);
      }
    },
    addFooter(){
      if(this.footer_form.length < 5)
      {
        let s = {};
        s.hf_id = -1;
        s.hf_text = "";
        this.footer_form.push(s);  
      }
      else{
        this.$message.error("最多添加5条页脚！");
      } 
    },
    deleteFooter(i){
      this.footer_form.splice(i, 1);
    },
    async updataFooterall(){
      let a = await updataFooter(url_updataFooter, this.footer_form, "post");
      if(a.data.result === "插入成功"){
        this.$message({
          message: "恭喜你，插入成功!",
          type: "success"
        });
      }
      else{
        this.$message.error("插入失败！");
        this.$router.go(0);
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