<template>
  <div class="home">
    <v-header :activeIndex='activeIndex+""'></v-header>

    <el-container style="background-color:white" >
      <!-- 左上图 -->
      <div >
        <div class="homepictures" >
          <el-carousel >
            <el-carousel-item v-for="item in news1Data" :key="item.nl_id">
              <div class="carousel-explain">
                <el-image
                  style="width: 460px; height: 360px"
                  :src="/api/+item.nl_graph"
                  :fit="'fill'"></el-image>
                <div class="picturetitle">
                  <p class="textp1">{{item.nl_title}}</p>
                </div>
              </div>

            </el-carousel-item>
          </el-carousel>
        </div>
      </div>

      <!-- 右上科研动态 -->
      <div class="news3home">
        <div class="news3title" style="margin:0 50px; height:50px;">
          <p width="400px" style="float: left;margin:0px 390px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">{{newsData[1].nl_nl_subType_name}}</p>
          <router-link to="/news3" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 >></router-link>
        </div>
        <el-table
          class="news3table"
          :data="news3Data"
          :show-header="false"
          style="width:600px;margin:0 50px 0 50px"
          @row-click="clicknewsTr">
            <el-table-column
              prop="nl_title"
              width="500" 
              >
            </el-table-column>
            <el-table-column
              prop="realTime"
              width="100">
            </el-table-column>>
        </el-table>
      </div>
    </el-container>

    <el-container style="background-color:white">
      <!-- 左中综合新闻 -->
      <div class="news2home">
        <div class="news2title" style="margin:0 50px; height:50px">
          <p width="400px" style="float: left;margin:0px 290px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">综合新闻</p>
          <router-link to="/news2" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 >></router-link>
        </div>
        <el-table
          class="news2table"
          :data="news2Data"
          :show-header="false"
          style="width:500px;margin:0 50px 0 50px"
          @row-click="clicknewsTr">
            <el-table-column
              prop="nl_title"
              width="400" 
              >
            </el-table-column>
            <el-table-column
              prop="realTime"
              width="100">
            </el-table-column>>
        </el-table>
      </div>

      <!-- 右中教育培养 -->
      <div class="notice2home">
        <div class="notice2title" style="margin:0 50px; height:50px">
          <p width="400px" style="float: left;margin:0px 290px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">教育培养</p>
          <router-link to="/notice2" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 >></router-link>
        </div>
        <el-table
          class="notice2table"
          :data="notice2Data"
          :show-header="false"
          style="width:500px;margin:0 50px 0 50px"
          @row-click="clicknoticeTr">
            <el-table-column
              prop="nl_title"
              width="400" 
              >
            </el-table-column>
            <el-table-column
              prop="realTime"
              width="100">
            </el-table-column>>
        </el-table>
      </div>
    </el-container>

    <el-container style="background-color:white">
      <!-- 左下学术动态 -->
      <div class="news4home">
        <div class="news4title" style="margin:0 50px; height:50px">
          <p width="400px" style="float: left;margin:0px 290px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">学术动态</p>
          <router-link to="/news4" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 >></router-link>
        </div>
        <el-table
          class="news4table"
          :data="news4Data"
          :show-header="false"
          style="width:500px;margin:0 50px 0 50px"
          @row-click="clicknewsTr">
            <el-table-column
              prop="nl_title"
              width="400" 
              >
            </el-table-column>
            <el-table-column
              prop="realTime"
              width="100">
            </el-table-column>>
        </el-table>
      </div>

      <!-- 右下招聘招生 -->
      <div class="notice3home">
        <div class="notice3title" style="margin:0 50px; height:50px">
          <p width="400px" style="float: left;margin:0px 290px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">招聘招生</p>
          <router-link to="/notice3" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 >></router-link>
        </div>
        <el-table
          class="notice3table"
          :data="notice3Data"
          :show-header="false"
          style="width:500px;margin:0 50px 0 50px"
          @row-click="clicknoticeTr">
            <el-table-column
              prop="nl_title"
              width="400" 
              >
            </el-table-column>
            <el-table-column
              prop="realTime"
              width="100">
            </el-table-column>>
        </el-table>
      </div>
    </el-container>
  
    <el-container style="background-color:white">
      <div class="resourcehome" width="1200px" >
        
        <el-container>
          <div v-for="item in resource1Data" :key="nl_id">
            <div class="resourcetitle" style="margin:0 50px; height:50px">
              <p width="1000px" style="float: left;margin:0px 890px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">资源发布</p>
              <router-link to="/resource" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 >></router-link>
            </div>
            <div class="resourcepicture">
              <el-image
                style="width: 200px; height: 100px; margin:20px"
                :src="/api/+item.nl_graph"
                :fit="'fill'">
              </el-image>
              

            </div>
          
          


          </div>
        </el-container>
      </div>
    </el-container>

    <el-container direction="vertical" style="background-color:white">
      <div class="link">
        <div class="resourcetitle"  style="margin:0 1030px 0 50px; height:50px;">
          <p width="1200px" style="float: left;margin:0px auto 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">友情链接</p>
        </div>
      </div>

      <el-container>
        <div class="linktable">
          <div class="linkitem" v-for="item in linklist" :key="item.lk_id" >
            <i class="el-icon-position"></i>
            <a :href="item.lk_url" style="text-decoration:none">{{item.lk_name}}</a>
          </div>
        </div>
      </el-container>
    </el-container>
    <v-footer></v-footer>
  </div>
</template>

<style scoped>

.el-table td{
  padding: 8px 0!important;
}

</style>
<style>
  .home {
    background-image:url('../assets/images/banner2.png');
    background-repeat:no-repeat;
    background-size:100%;
    background-attachment:fixed;
  }

  .el-container{
    margin:auto;
    width:1200px;
  }


  .homepictures{
    width:460px;
    margin: 20px;
  }

  /* 右上角科研动态 */
  .news3home{
    width:700px;
    min-height: 200px;
    margin: 0;
  }

  .news3table{
    width:700px;
    margin: 0;
  }

  /* 中左头条 */
  .news2home{
    width:600px;
    min-height: 200px;
    margin: 0;
  }

  .news2table{
    width:600px;
    margin: 0;
  }

    /* 中右公告 */
  .notice2home{

    width:600px;
    min-height: 200px;
    margin: 0;
  }

  .notice2table{
    width:600px;
    margin: 0;
  }

    /* 左下学术 */
  .news4home{
    width:600px;
    min-height: 200px;
    margin: 0;
  }

  .news4table{
    width:600px;
    margin: 0;
  }

    /* 右下招聘 */
  .notice3home{
    width:600px;
    min-height: 200px;
    margin: 0;
  }

  .notice3table{
    width:600px;
    margin: 0;
  }

  .resourcehome{
    width:1200px;
    margin: 0;
  }

.linktable{
  display: -webkit-flex;
  display: flex;
  -webkit-flex-wrap: wrap;
  flex-wrap: wrap;
  width: 1200px;
}

.linkitem {
  width: 380px;
  margin:10px 0 10px 20px;
}



  
</style>

<script>
  import Axios from 'axios';
  import header from "./header.vue";
  import footer from "./footer.vue";
  export default {
    name: "home",
    components:{    
      'v-header':header,
      'v-footer':footer,
    },

    data() {
      return {
        activeIndex:1,
        newsData:[],
        noticeData:[],
        resourceData:[],
        news1Data:[],
        news2Data:[],
        news3Data:[],
        news4Data:[],
        notice2Data:[],
        notice3Data:[],
        resource1Data:[],
        linklist:[
          {lk_id:1,lk_name:"武汉理工大学计算机科学与技术学院",lk_url:"http://cst.whut.edu.cn/"},
          {lk_id:2,lk_name:"吉林农业大学植物保护学院",lk_url:"https://zwbh.jlau.edu.cn/index.htm/"},
          {lk_id:3,lk_name:"华中农业大学动物科学技术学院动物医学院",lk_url:"http://my.hzau.edu.cn/"},
          {lk_id:4,lk_name:"中科院东北地理所",lk_url:"http://www.neigae.ac.cn/"},
          {lk_id:5,lk_name:"澳大利亚格里菲斯大学",lk_url:"https://www.griffith.edu.au/"},
        ],
      }
    },
    mounted() {
      this.getData();
    },  
    methods: {
      clicknewsTr(row, event, column){
        console.log(row.nl_id);
        this.$router.push({name:'newsInfo',query:{nl_id:row.nl_id}})
      },
      clicknoticeTr(row, event, column){
        console.log(row.nl_id);
        this.$router.push({name:'noticeInfo',query:{nl_id:row.nl_id}})
      },
      clickresourceTr(row, event, column){
        console.log(row.nl_id);
        this.$router.push({name:'resourceInfo',query:{nl_id:row.nl_id}})
      },
      getData() {
        Axios.get('/api/news/findAll').then(response => {
            this.newsData=response.data.result;
              for(var i = 0;i<this.newsData.length;i++){
                if (this.newsData[i].nl_nl_subType_name=="头条新闻"){
                  if(this.news1Data.length<5){this.news1Data.push(this.newsData[i])}
                }
                else if (this.newsData[i].nl_nl_subType_name=="综合新闻"){
                  if(this.news2Data.length<5){this.news2Data.push(this.newsData[i])}
                }
                else if (this.newsData[i].nl_nl_subType_name=="科研动态"){
                  if(this.news3Data.length<5){this.news3Data.push(this.newsData[i])}
                }
                else if (this.newsData[i].nl_nl_subType_name=="学术活动"){
                  if(this.news4Data.length<5){this.news4Data.push(this.newsData[i])}
                }
              }
              console.log("newsData");
              console.log(this.newsData);

        }, response => {
            console.log("error");
          });
        Axios.get('/api/notice/findAll').then(response => {
            this.noticeData=response.data.result;
              for(var i = 0;i<this.noticeData.length;i++){
                if (this.noticeData[i].nl_nl_subType_name=="教育培养"){
                  if(this.notice2Data.length<5){this.notice2Data.push(this.noticeData[i])}
                }
                else if (this.noticeData[i].nl_nl_subType_name=="招聘招生"){
                  if(this.notice3Data.length<5){this.notice3Data.push(this.noticeData[i])}
                }
              }
              console.log("noticeData");
              console.log(this.noticeData);
        }, response => {
            console.log("error");
          });
        Axios.get('/api/resource/findAll').then(response => {
            this.resourceData=response.data.result;
              for(var i = 0;i<this.resourceData.length;i++){
                if (this.resourceData[i].nl_nl_type_name=="资源"){
                  if(this.resource1Data.length<5){this.resource1Data.push(this.resourceData[i])}
                }
              }
              console.log("resourceData");
              console.log(this.resourceData);
        }, response => {
            console.log("error");
          });
      },
      
    }
  }
</script>
