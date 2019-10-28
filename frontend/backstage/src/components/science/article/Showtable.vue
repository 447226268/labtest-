<template>
  <div>
    <div>
      <div class="show" style="margin-right:30px">论文总览</div>
      <div class="show" style="border-bottom: 0px ; cursor:pointer" v-on:click="go2academic">学术总论</div>
    </div>
    <el-button type="primary" style="width : 100px; margin : 10px" @click="tableCreat">新增</el-button>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="tl_date" label="发布时间" width="120"></el-table-column>
      <el-table-column prop="tl_state" label="发布状态" width="120"></el-table-column>
      <el-table-column prop="tl_title" label="论文标题" width="230"></el-table-column>
      <el-table-column prop="tl_journal" label="刊物名称" width="230"></el-table-column>
      <el-table-column prop="tl_writer" label="第一作者" width="120"></el-table-column>
      <el-table-column prop="tl_year" label="发表年度" width="120"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      layout="prev, pager, next"
      :total="total"
      class="postion"
      @current-change="currentChange"
    ></el-pagination>
  </div>
</template>

<script>
import { getArticleall, url_deleteArticle, deleteArticle } from "@/api/index.js";
export default {
  data() {
    return {
      currentIndex: 1,
      total: 0,
      state_string: ["未发布", "已发布"],
      tableData: [],
      alltableDate: []
    };
  },
  created() {
    this.getArticle();
  },
  methods: {
    go2academic() {
      this.$router.push({
        path: "/scince/academic/show"
      });
    },
    tableCreat() {
      this.$router.push({
        path: "/scince/article/edit" + -1
      });
    },
    handleEdit(index, row) {
      this.$router.push({
        path:
          "/scince/article/edit" +
          parseInt(
            this.alltableDate[(this.currentIndex - 1) * 10 + index].tl_id
          )
      });
    },
    async handleDelete(index, row) {
      let a = await deleteArticle(
        url_deleteArticle,
        {
          id: parseInt(
            this.alltableDate[(this.currentIndex - 1) * 10 + index].tl_id
          )
        },
        "get"
      );
      var arr = [(this.currentIndex - 1) * 10 + index + 1];
      this.alltableDate = [];
      this.getArticle();
      if (this.currentIndex < Math.ceil(this.alltableDate.length() / 10)) {
        this.currentIndex -= 1;
      }
      this.currentChange(currentIndex);
    },
    currentChange(index) {
      this.currentIndex = index;
      this.tableData = this.alltableDate.slice((index - 1) * 10, index * 10);
    },
    async getArticle() {
      let a = await getArticleall();
      this.total = a.data.result.length;
      for (let i = 0; i < a.data.result.length; i++) {
        let s = {};
        s.tl_id = a.data.result[i].tl_id;
        s.tl_date = a.data.result[i].tl_realtime;
        s.tl_year = a.data.result[i].tl_year;
        s.tl_journal = a.data.result[i].tl_journal;
        s.tl_writer = a.data.result[i].tl_journal;
        s.tl_state = this.state_string[parseInt(a.data.result[i].tl_state)];
        s.tl_title = a.data.result[i].tl_title;
        this.alltableDate.push(s);
      }
      this.currentChange(1);
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
  margin-right: 0px;
  margin-left: 60%;
}
</style>