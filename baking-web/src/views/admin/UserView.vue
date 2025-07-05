<!--User page-->
<template>
  <el-table :data="arr">
    <el-table-column type="index" label="index" width="100px"></el-table-column>
    <el-table-column prop="username" label="username"></el-table-column>
    <el-table-column prop="nickname" label="nickname"></el-table-column>
    <el-table-column label="head">
      <template #default="scope">
        <el-avatar :src="'http://localhost:8080'+scope.row.imgUrl"></el-avatar>
      </template>
    </el-table-column>
    <el-table-column label="administrator">
      <template #default="scope">
        <el-switch v-model="scope.row.isAdmin" :active-value="1" :inactive-value="0"
        @change="changeAdmin(scope.row)"></el-switch>
      </template>
    </el-table-column>
    <el-table-column prop="createTime" label="createTime"></el-table-column>
    <el-table-column label="operation">
      <template #default="scope">
        <el-button type="danger" @click="del(scope.$index,scope.row)">delete</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-button type="primary" @click="dialogVisible=true" style="width:100%;margin-top:15px;font-weight:bold;">Add users</el-button>
  <el-dialog title="Add users" v-model="dialogVisible" style="padding-right:60px;border-radius:10px;">
    <el-form label-width="100px">
      <el-form-item label="username">
        <el-input placeholder="username" v-model="user.username"></el-input>
      </el-form-item>
      <el-form-item label="password">
        <el-input placeholder="password" v-model="user.password" type="password"></el-input>
      </el-form-item>
      <el-form-item label="nickname">
        <el-input placeholder="nickname" v-model="user.nickname"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:100%;" @click="add()">Add</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script setup>
import {onMounted, ref} from "vue";
import {ElMessage} from "element-plus";
import axios from "axios";
import qs from "qs";

const dialogVisible = ref(false);
const user = ref({username:'',password:'',nickname:''})
const add = ()=>{
  dialogVisible.value=false;
  let data = qs.stringify(user.value);
  axios.post('http://localhost:8080/v1/users/reg',data).then((response)=>{
    if(response.data.code==2001){
      ElMessage.success('Add success!');
      loadData();
      user.value={username:'',password:'',nickname:''};
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}


/*const arr = ref([
  {nickname: 'Tom', username:'tom',isAdmin:true,imgUrl:'/imgs/head.jpg',createTime:'2021/2/7 11:08:07'},
  {nickname: 'Jerry',username:'jerry',isAdmin:false,imgUrl:'imgs/a.jpg',createTime:'2022/03/11 15:43:19'},
  {nickname: 'Lucy',username:'lucy',isAdmin:true,imgUrl:'imgs/b.jpg',createTime:'2015/09/06 17:03:21'},
  {nickname: 'Lily',username:'lily',isAdmin:true,imgUrl:'imgs/c.jpg',createTime:'2023/07/18 08:53:09'},
]);
 */

const changeAdmin = (user)=>{
  let data = qs.stringify({id:user.id,isAdmin:user.isAdmin});
  axios.post('http://localhost:8080/v1/users/update',data).then((response)=>{
    if(response.data.code==2001){
      ElMessage.success('Modification completed!');
    }
  })
}

const arr = ref([]);
const loadData = ()=>{
  axios.get('http:localhost:8080/v1/users/admin').then((response)=>{
    if(response.data.code==2001){
      arr.value = response.data.data;
      //console.log(arr.value);
    }
  })
}
onMounted(()=>{
  loadData();
})
const del = (i,user)=>{
  if(confirm('Do you want to delete'+user.nickname+"?")){
    axios.post('http://localhost:8080/v1/users'+user.id+'/delete').then((response)=>{
      if(response.data.code==2001){
        ElMessage.success('Delete success!');
        arr.value.splice(i,1);
      }
    })
    //The first time to write ElMessage, you need to manually write the import statement.
    //ElMessage.success(user.nickname+'Deleted!');
  }
}

</script>
