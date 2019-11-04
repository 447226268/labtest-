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
            <el-button
              size="mini"
              style="float:right"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
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
              <div v-for="(item, i) in type_string" :key="i">
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
import { getStaffall, getAllType, url_insertStaff, insertStaff} from "@/api";
export default {
  data() {
    return {
      dialogFormVisible: false,
      staffinsert:{
        type: "",
        name: "",
      },
      type_string_edit: [],
      type_string: [],
      allstaff: [],
      input: "123",
      
    };
  },
  
  components: {
    tinymce
  },
  created() {
    this.getStaff();
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
      this.type_string_edit.splice(tabindex, 1);
    },
    staffadd(){
      let s = {};
      s.name = "";
      s.flag = true;
      this.type_string_edit.push(s);
    },
    updatastafftype(){
      alert("123")
    },
    async insertstaff(){
      if(this.staffinsert.type !== "" && this.staffinsert.name !== ""){
        let a = await insertStaff(url_insertStaff, this.staffinsert,"post");
      }
      
    },
    handleEdit(index, row){
      this.$router.push({
          path: "/laboratory/team/staffedit"  + parseInt(row.id)
      });
    },
    async getStaff(){
      let t = await getAllType();
      for(let i = 0; i < t.data.result.length; i++){
        let s1 = {}, s2 = {};
        s1.name = t.data.result[i];
        s2.name = t.data.result[i];
        s2.flag = true;
        this.type_string.push(s1);
        this.type_string_edit.push(s2);
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