<template>
  <div>
     <div>
      <div class="show" style="border-bottom: 0px ; margin-right:30px ; cursor:pointer" v-on:click="go2introduction">实验室简介</div>
      <div class="show" style="border-bottom: 0px ; margin-right:30px ; cursor:pointer"   v-on:click="go2direction">研究方向</div>
      <div class="show" style="border-bottom: 0px ; margin-right:30px ; cursor:pointer" v-on:click="go2team" >研究团队</div>
      <div class="show" style="margin-right:30px;">毕业生</div>
    </div>

    <el-button type="primary" style="width : 100px; margin : 10px" @click="tableCreat">新增</el-button>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="date" label="发布时间" width="180"></el-table-column>
      <el-table-column prop="state" label="发布状态" width="180"></el-table-column>
      <el-table-column prop="title" label="标题" width="400"></el-table-column>
      <el-table-column prop="type" label="类型" width="180"></el-table-column>
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
import { getGraduateall, url_deleteGraduate, deleteGraduate } from "@/api/index.js";
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
    this.getGraduate();
  },
  methods: {
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
    go2direction(){
      this.$router.push({
          path: "/laboratory/direction/"
      });
    },

    tableCreat() {
      this.$router.push({
        path: "/laboratory/graduates/edit" + -1
      });
    },
    handleEdit(index, row) {
      this.$router.push({
        path:
          "/laboratory/graduates/edit" +
          parseInt(
            this.alltableDate[(this.currentIndex - 1) * 10 + index].id
          )
      });
    },
    async handleDelete(index, row) {
      let a = await deleteGraduate(
        url_deleteGraduate,
        {
          id: parseInt(
            this.alltableDate[(this.currentIndex - 1) * 10 + index].id
          )
        },
        "get"
      );
      var arr = [(this.currentIndex - 1) * 10 + index + 1];
      this.alltableDate = [];
      this.getGraduate();
      if (this.currentIndex < Math.ceil(this.alltableDate.length() / 10)) {
        this.currentIndex -= 1;
      }
      this.currentChange(currentIndex);
    },
    currentChange(index) {
      this.currentIndex = index;
      this.tableData = this.alltableDate.slice((index - 1) * 10, index * 10);
    },
    async getGraduate() {
      let a = await getGraduateall();
      this.total = a.data.result.length;
      for (let i = 0; i < a.data.result.length; i++) {
        let s = {};
        s.id = a.data.result[i].id;
        s.state = this.state_string[a.data.result[1].state];
        s.date = a.data.result[i].date;
        s.type = a.data.result[i].type;
        s.title = a.data.result[i].title;
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