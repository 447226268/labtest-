<template>
  <div class="home">
    <v-header :activeIndex='activeIndex+""'></v-header>

    <el-container style="background-color:white" >
      <!-- 左上图 -->
      <div >
        <div class="homepictures" >
          <el-carousel >
            <div v-for="item in news1Data" :key="item.nl_id">
              <el-carousel-item  v-if="item.nl_graph!=''">
                <div class="carousel-explain" >
                  <router-link :to="'newsInfo?nl_id='+item.nl_id" >
                    <el-image
                      style="width: 460px; height: 300px; margin:0 "
                      :src="item.nl_graph"
                      :fit="'fill'">
                    </el-image>
                    <a   class="picturetext"  >{{item.nl_title}}</a>
                  </router-link>
                </div>

              </el-carousel-item>
            </div>
          </el-carousel>
        </div>
      </div>

      <!-- 右上科研动态 -->
      <div class="news3home">
        <div class="news3title" style="margin:0 50px; height:50px;">
          <p width="400px" style="float: left;margin:0px 400px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">科研动态</p>
          <router-link to="/news3" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多  </router-link>
          <i class="el-icon-right"></i>
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
          <p width="500px" style="float: left;margin:0px 400px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">综合新闻</p>
          <router-link to="/news2" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多  </router-link>
          <i class="el-icon-right"></i>
        </div>

        <el-container>      
          <div class="news2picture">
            <el-image
              v-if="figureData[0].hn_graph!=''"
              style="width: 260px; height: 200px; margin:20px"
              :src="figureData[0].hn_graph"
              :fit="'fill'">
            </el-image>
          </div>

          <el-table
            class="news2table"
            :data="news2Data"
            :show-header="false"
            style="width:400px;margin:0 20px 0 20px"
            @row-click="clicknewsTr">
              <el-table-column
                prop="nl_title"
                width="260" 
                >
              </el-table-column>
              <el-table-column
                prop="realTime"
                width="100">
              </el-table-column>>
          </el-table>
         </el-container>
      </div>

      <!-- 右中教育培养 -->
      <div class="notice2home">
        <div class="notice2title" style="margin:0 50px; height:50px">
          <p width="400px" style="float: left;margin:0px 200px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">教育培养</p>
          <router-link to="/notice2" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 </router-link>
          <i class="el-icon-right"></i>
        </div>


        <el-table
          class="notice2table"
          :data="notice2Data"
          :show-header="false"
          style="width:460px;margin:0 20px 0 20px"
          @row-click="clicknoticeTr">
            <el-table-column
              prop="nl_title"
              width="360" 
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
          <p width="500px" style="float: left;margin:0px 400px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">学术活动</p>
          <router-link to="/news4" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 </router-link>
          <i class="el-icon-right"></i>
        </div>

        <el-container>      
          <div class="news4picture">
            <el-image
              v-if="figureData[1].hn_graph!=''"
              style="width: 260px; height: 200px; margin:20px"
              :src="figureData[1].hn_graph"
              :fit="'fill'">
            </el-image>
          </div>

          <el-table
            class="news4table"
            :data="news4Data"
            :show-header="false"
            style="width:400px;margin:0 20px 0 20px"
            @row-click="clicknewsTr">
              <el-table-column
                prop="nl_title"
                width="260" 
                >
              </el-table-column>
              <el-table-column
                prop="realTime"
                width="100">
              </el-table-column>>
          </el-table>
         </el-container>
      </div>

      <!-- 右下教育培养 -->
      <div class="notice3home">
        <div class="notice3title" style="margin:0 50px; height:50px">
          <p width="400px" style="float: left;margin:0px 200px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">招聘招生</p>
          <router-link to="/notice3" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 </router-link>
          <i class="el-icon-right"></i>
        </div>



        <el-table
          class="notice3table"
          :data="notice3Data"
          :show-header="false"
          style="width:460px;margin:0 20px 0 20px"
          @row-click="clicknoticeTr">
            <el-table-column
              prop="nl_title"
              width="360" 
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
          <div >
            <div class="resourcetitle" style="margin:0 50px; height:50px">
              <p width="1000px" style="float: left;margin:0px 890px 0 0; font-size: 30px; font-weight: 600; color:#386CCA ">资源发布</p>
              <router-link to="/resource" width="200px" height="50px"  style="margin-top:10px;font-size: 20px; font-weight: 400;  color:#386CCA "> 更多 </router-link>
              <i class="el-icon-right"></i>
            </div>
            <el-container class="resourcepicture">
              <div v-for="item in resource1Data" :key="item.nl_id">
                <el-image
                   
                  style="width: 200px; height: 100px; margin:20px 20px 0 20px"
                  :src="figureData[0].hn_graph"
                  :fit="'fill'">
                </el-image>
                <a   class="resourcetext" :href="'resourceInfo?nl_id='+item.nl_id" style="text-decoration:none">{{item.nl_title}}</a>
              </div>
            </el-container>
          
          


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
          <div class="linkitem" v-for="item in linklist" :key="item.hl_id" >
            <i class="el-icon-position"></i>
            <a :href="item.hl_url" style="text-decoration:none">{{item.hl_text}}</a>
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

  .picturetext{
    width: 460px;
    display: block;
    margin: 0;
    line-height: 80px;
    text-align: center;
    background-color: rgba(255,255,255,0.2);  
    /* background-color: #333; */
    opacity: 0.8;
    color: black;
    font-size: 18px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    position: relative;
    bottom: 80px;
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
    width:700px;
    min-height: 200px;
    margin: 0;
  }

  .news2table{
    width:400px;
    margin: 0;
  }

    /* 中右公告 */
  .notice2home{

    width:500px;
    min-height: 200px;
    margin: 0;
  }

  .notice2table{
    width:500px;
    margin: 0;
  }

    /* 左下学术 */
  .news4home{
    width:700px;
    min-height: 200px;
    margin: 0;
  }

  .news4table{
    width:400px;
    margin: 0;
  }

    /* 右下招聘 */
  .notice3home{
    width:500px;
    min-height: 200px;
    margin: 0;
  }

  .notice3table{
    width:500px;
    margin: 0;
  }

  .resourcehome{
    width:1200px;
    margin: 0;
  }

  .resourcetext{
    width: 200px;
    display: block;
    margin: 0 20px;
    line-height: 40px;
    text-align: center;
    background-color: rgba(255,255,255,0.2);  
    /* background-color: #333; */
    opacity: 0.8;
    color: black;
    font-size: 18px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    position: relative;
    bottom: 40px;
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
  import webheader from "./header.vue";
  import webfooter from "./footer.vue";
  export default {
    name: "home",
    components:{    
      'v-header':webheader,
      'v-footer':webfooter,
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
        figureData:[],
        linklist:[],
      }
    },
    mounted() {
      this.getData();
    },  
    methods: {
      clicknewsTr(row, event, column){
        console.log(row.nl_id);
        if(row.nl_url==""){
          this.$router.push({name:'newsInfo',query:{nl_id:row.nl_id}})
        }
        else{
          window.location.href = row.nl_url
        }
      },
      clicknoticeTr(row, event, column){
        console.log(row.nl_id);
        if(row.nl_url==""){
          this.$router.push({name:'noticeInfo',query:{nl_id:row.nl_id}})
        }
        else{
          window.location.href = row.nl_url
        }
      },
      clickresourceTr(row, event, column){
        console.log(row.nl_id);
        if(row.nl_url==""){
          this.$router.push({name:'resourceInfo',query:{nl_id:row.nl_id}})
        }
        else{
          window.location.href = row.nl_url
        }
      },
      getData() {
        Axios.get('/api/news/findAll').then(response => {
            this.newsData=response.data.result;
              for(var i = 0;i<this.newsData.length;i++){
                if (this.newsData[i].nl_nl_subType_name=="头条新闻"&&this.newsData[i].nl_state==1){
                  if(this.news1Data.length<5){this.news1Data.push(this.newsData[i])}
                }
                else if (this.newsData[i].nl_nl_subType_name=="综合新闻"&&this.newsData[i].nl_state==1){
                  if(this.news2Data.length<5){this.news2Data.push(this.newsData[i])}
                }
                else if (this.newsData[i].nl_nl_subType_name=="科研动态"&&this.newsData[i].nl_state==1){
                  if(this.news3Data.length<5){this.news3Data.push(this.newsData[i])}
                }
                else if (this.newsData[i].nl_nl_subType_name=="学术活动"&&this.newsData[i].nl_state==1){
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
                if (this.noticeData[i].nl_nl_subType_name=="教育培养"&&this.noticeData[i].nl_state==1){
                  if(this.notice2Data.length<5){this.notice2Data.push(this.noticeData[i])}
                }
                else if (this.noticeData[i].nl_nl_subType_name=="招聘招生"&&this.noticeData[i].nl_state==1){
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
                if (this.resourceData[i].nl_nl_type_name=="资源"&&this.resourceData[i].nl_state==1){
                  if(this.resource1Data.length<5){this.resource1Data.push(this.resourceData[i])}
                }
              }
              console.log("resourceData");
              console.log(this.resourceData);
        }, response => {
            console.log("error");
          });
        Axios.get('/api/figure/getFigure').then(response => {
            this.figureData=response.data.result;
              console.log("figureData");
              console.log(this.figureData);
        }, response => {
            console.log("error");
          });
        Axios.get('/api/link/getLinks').then(response => {
            this.linklist=response.data.result;
              console.log("linklist");
              console.log(this.linklist);
        }, response => {
            console.log("error");
          });
      },
      
    }
  }
</script>
