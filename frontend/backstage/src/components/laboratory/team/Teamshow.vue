<template>
  <div>

  <div>
    <div class="show" style="border-bottom: 0px ; margin-right:30px ; cursor:pointer" v-on:click="go2introduction">实验室简介</div>
    <div class="show" style="border-bottom: 0px ; margin-right:30px ; cursor:pointer" v-on:click="go2direction">研究方向</div>
    <div class="show" style="margin-right:30px"  >研究团队</div>
    <div class="show" style="border-bottom: 0px ; margin-right:30px ; cursor:pointer" v-on:click="go2graduates">毕业生</div>
  </div>

  <el-row style="margin:10px">
    <el-button type="primary" class="width" @click="dialogFormVisible = true">编辑</el-button>
    <el-button type="primary" class="width">发布</el-button>
  </el-row>

  <el-collapse accordion class="collapse-main">
    
    <div  v-for="(items, index) in allstaff" v-bind:key="index">
        <el-collapse-item :title= items.type>
          <el-table
          :data="items.item"
          :show-header= false
          style="width: 100%;">
          <el-table-column
            prop=""
            width="50"
          >
          </el-table-column>
          <el-table-column
            prop="name"
            label="姓名"
            class="table-column"
          >
          </el-table-column>
          <el-table-column label="操作" >
          <template slot-scope="scope">
            <div style="float:right">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button
              size="mini"
              @click="handleDelete(scope.$index, scope.row, index)">删除</el-button>
          </div>
          </template>
          </el-table-column>
          <el-table-column
            prop=""
            width="50"
          >
          </el-table-column>

        </el-table>
        </el-collapse-item>
    </div>
    
  </el-collapse>
  
  
  <el-dialog title="人员修改" :visible.sync="dialogFormVisible">
    <el-tabs value="1">

      <el-tab-pane label="编辑纵向分类" name="1">
        <div v-for="(item, i) in type_string_edit" :key="i">
        <el-row :gutter="20">
          <el-col :span="20" style="margin-top:10px;">
            <el-input
              v-model="item.name"
              name= i
              style="width: 300px;"
              :disabled="item.flag">
            </el-input>
          </el-col>
          <el-col :span="4">
            <el-button type="primary" icon="el-icon-edit" circle @click="staffedit(i)"></el-button>
            <el-button type="danger" icon="el-icon-delete" circle @click="staffremove(i)"></el-button>
        </el-col>
        </el-row>
        </div>
        <el-button icon="el-icon-plus" style="margin-top:10px" circle @click="staffadd"></el-button>
        <div style="float:right; margin-top:80px">
          <el-button type="primary" @click="updatastafftype">保 存</el-button>
        </div>
      </el-tab-pane>




      <el-tab-pane label="新增人员名单" name="2">

      <el-form ref="form" :model="staffinsert" label-width="80px">

        <el-form-item label="类型选择:">
            <el-select v-model="staffinsert.type">
              <div v-for="(item, i) in type_string_edit" :key="i">
                <el-option :label= "item.name" :value="item.name"></el-option>
              </div>
            </el-select>
          </el-form-item>

          <el-form-item label="人员名单:">
            <el-input v-model="staffinsert.name"></el-input>
          </el-form-item>
        </el-form>

        <div style="float:right; margin-top:80px">
          <el-button type="primary" @click="insertstaff">保 存</el-button>
        </div>
      </el-tab-pane>
       
  </el-tabs>
  </el-dialog>
  </div>

</template>
<script>
import tinymce from "@/components/tinymce.vue";
import { getStaffall, getAllType, url_updataStaffType, updataStaffType, url_insertStaff, insertStaff, url_deletestaffIndex, deletestaffIndex} from "@/api";
export default {
  data() {
    return {
      dialogFormVisible: false,
      staffinsert:{
        type: "",
        name: "",
      },
      type_string_edit: [],
      allstaff: [],
    };
  },
  
  components: {
    tinymce
  },
  created() {
    this.getStaff();
  },
  watch: {
    dialogFormVisible: function(newD, oldD){
      if(newD === false){
        this.staffinsert = {
        type: "",
        name: "",
      };
      this.type_string_edit=[];
      this.allstaff= [];
      this.getStaff();
      for(let i = 0; i < this.type_string_edit.length; i++){
        this.type_string_edit[i].flag = true;
      }
      }
    }
  },
  methods: {
    go2introduction() {
      this.$router.push({
          path: "/laboratory/introducution/"
      });
    },
    go2direction() {
      this.$router.push({
          path: "/laboratory/direction/"
      });
    },
    go2graduates() {
      this.$router.push({
          path: "/laboratory/graduates/"
      });
    },
    staffedit(tabindex){
      this.type_string_edit[tabindex].flag = false;
    },
    staffremove(tabindex){
      for(let i = 0; i < this.allstaff.length; i++){
        if(this.allstaff[i].type === this.type_string_edit[tabindex].name){
          this.$message.error("无法删除该条目!");
          return;
        }
      }
      this.type_string_edit.splice(tabindex, 1);
    },
    startSet(){
      this.type_string_edit = [];
      this.allstaff = [];
    },
    staffadd(){
      let s = {};
      s.name = "";
      s.flag = true;
      this.type_string_edit.push(s);
    },
    async updatastafftype(){
      let s = [];
      for(let i = 0; i < this.type_string_edit.length; i++){
        s.push(this.type_string_edit[i].name);
      }
      let a = await updataStaffType(url_updataStaffType, {requestment: s}, "post");
      if(a.data.result === "success!"){
        this.$message({
          message: "更新成功！",
          type: "success"
        });
      }
      else{
        this.$message.error("更新失败!");
      }
    },
    async insertstaff(){
      if(this.staffinsert.type !== "" && this.staffinsert.name !== ""){
        let a = await insertStaff(url_insertStaff, this.staffinsert,"post");
        if(a.data.result === "success!"){
          this.$message({
            message: "上传成功!",
            type: "success",
          });
          this.startSet();
          this.getStaff();
        }
        else{
          this.$message.error("上传失败!");
        }
      }
      
    },
    handleEdit(index, row){
      this.$router.push({
          path: "/laboratory/team/staffedit"  + parseInt(row.id)
      });
    },
    async handleDelete(index, row, i){
      let a = await deletestaffIndex(url_deletestaffIndex + row.id, {}, "delete");
      if(a.data.result === "success!"){
        this.allstaff[i].item.splice(index, 1);
        if(this.allstaff[i].item.length === 0){
          this.allstaff.splice(i, 1);
        }
      }
    },
    async getStaff(){
      let t = await getAllType();
      for(let i = 0; i < t.data.result.length; i++){
        let s = {};
        s.name = t.data.result[i].st_name;
        s.flag = true;
        this.type_string_edit.push(s);
      }

      let a = await getStaffall();
      var map = {};
      for(let i =0; i < a.data.result.length; i++){
        var ai = a.data.result[i];
        if(!map[ai.type]){
          this.allstaff.push({
            type: ai.type,
            item: [ai]
          });
          map[ai.type] = ai;
        }
        else{
          for (var j = 0; j < this.allstaff.length; j++){
            var dj = this.allstaff[j];
            if(dj.type == ai.type){
              dj.item.push(ai);
              break;
            }
          }
        }
      }
    },
  }
};
</script>

<style lang = "scss">
.show {
  text-align: center;
  padding-bottom: 10px;
  margin: 5px;
  width: 80px;
  display: inline-block;
  border-bottom: 2px solid green;
}
.width {
  width: 100px;
}
.collapse-main{
  margin-top:40px;
  width: 100%;
  .el-collapse-item__content{
    padding-bottom: 0px;
  };
  .el-collapse-item__header{
    padding-left: 40px;
    font-size: 15px; 
  };
  .el-collapse-item__wrap{
    border-top:1px solid #EBEEF5; 
    border-bottom: 0;
  };
}
.table-column{
  height: 48px;
  margin-left: 50px;
}

</style>