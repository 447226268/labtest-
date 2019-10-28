<template>
  <div>
    <div>
      <div class="show" style="margin-right:30px;border-bottom: 0px ; cursor:pointer" v-on:click="go2article">论文总览</div>
      <div class="show">学术会议</div>
    </div>
    <el-button type="primary" style="width : 100px; margin : 10px" @click="tableCreat">新增</el-button>
    <el-table :data="tableData" style="width: 100%">
       <el-table-column prop="nl_date" label="发布时间" width="180"></el-table-column>
      <el-table-column prop="nl_state" label="发布状态" width="180"></el-table-column>
      <el-table-column prop="nl_title" label="标题" width="400"></el-table-column>
      <el-table-column prop="nl_nl_subType_name" label="类型" width="180"></el-table-column>
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
import { getAcademicall, url_deleteAcademic, deleteAcademic } from "@/api/index.js";
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
    this.getAcademic();
  },
  methods: {
    go2article() {
      this.$router.push({
        path: "/scince/article/show"
      });
    },
    tableCreat() {
      this.$router.push({
        path: "/scince/academic/edit" + -1
      });
    },
    handleEdit(index, row) {
      this.$router.push({
        path:
          "/scince/academic/edit" +
          parseInt(
            this.alltableDate[(this.currentIndex - 1) * 10 + index].nl_id
          )
      });
    },
    async handleDelete(index, row) {
      let a = await deleteAcademic(
        url_deleteAcademic,
        {
          id: parseInt(
            this.alltableDate[(this.currentIndex - 1) * 10 + index].nl_id
          )
        },
        "get"
      );
      var arr = [(this.currentIndex - 1) * 10 + index + 1];
      this.alltableDate = [];
      this.getAcademic();
      if (this.currentIndex < Math.ceil(this.alltableDate.length() / 10)) {
        this.currentIndex -= 1;
      }
      this.currentChange(currentIndex);
    },
    currentChange(index) {
      this.currentIndex = index;
      this.tableData = this.alltableDate.slice((index - 1) * 10, index * 10);
    },
    async getAcademic() {
      let a = await getAcademicall();
      this.total = a.data.result.length;
      for (let i = 0; i < a.data.result.length; i++) {
        let s = {};
        s.nl_id = a.data.result[i].nl_id;
        s.nl_date = a.data.result[i].realTime;
        s.nl_nl_subType_name = a.data.result[i].nl_nl_subType_name;
        s.nl_state = this.state_string[parseInt(a.data.result[i].nl_state)];
        s.nl_title = a.data.result[i].nl_title;

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