<!--User page-->
<template>
  <el-table :data="arr">
    <el-table-column type="index" label="index" width="100px"></el-table-column>
    <el-table-column prop="username" label="username"></el-table-column>
    <el-table-column prop="nickname" label="nickname"></el-table-column>
    <el-table-column label="head">
      <template #default="scope">
        <el-avatar :src="scope.row.imgUrl"></el-avatar>
      </template>
    </el-table-column>
    <el-table-column label="administrator">
      <template #default="scope">
        <el-switch v-model="scope.row.isAdmin"></el-switch>
      </template>
    </el-table-column>
    <el-table-column prop="createTime" label="createTime"></el-table-column>
    <el-table-column label="operation">
      <template #default="scope">
        <el-button type="danger" @click="del(scope.$index,scope.row)">delete</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>
import {ref} from "vue";
import {ElMessage} from "element-plus";
const arr = ref([
  {nickname: 'Tom', username:'tom',isAdmin:true,imgUrl:'/imgs/head.jpg',createTime:'2021/2/7 11:08:07'},
  {nickname: 'Jerry',username:'jerry',isAdmin:false,imgUrl:'imgs/a.jpg',createTime:'2022/03/11 15:43:19'},
  {nickname: 'Lucy',username:'lucy',isAdmin:true,imgUrl:'imgs/b.jpg',createTime:'2015/09/06 17:03:21'},
  {nickname: 'Lily',username:'lily',isAdmin:true,imgUrl:'imgs/c.jpg',createTime:'2023/07/18 08:53:09'},
]);
const del = (i,user)=>{
  if(confirm('Do you want to delete carousel picture'+user.nickname+"?")){
    arr.value.spice(i,1);
    ElMessage.success(user.nickname+'Deleted!');
  }
}

</script>
