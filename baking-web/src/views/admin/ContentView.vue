<!--Content Page-->
<template>
<el-table :data="arr">
  <el-table-column type="index" label="index" width="80" align="center"></el-table-column>
  <el-table-column prop="title" label="title" width="120" align="center"></el-table-column>
  <el-table-column label="cover" widty="140" align="center">
    <template #default="scope">
      <img :src="BASE_URL+scope.row.imgUrl" style="width:100%;">
    </template>
  </el-table-column>
  <el-table-column prop="brief" label="brief" width="280" align="center"></el-table-column>
  <el-table-column prop="categoryName" label="category" width="80" align="center"></el-table-column>
  <el-table-column prop="viewCount" label="view"  width="60" align="center"></el-table-column>
  <el-table-column prop="commentCount" label="comment" width="60" align="center"></el-table-column>
  <el-table-column prop="createTime" label="createTime" width="120" align="center"></el-table-column>
  <el-table-column label="operation" align="center">
    <template #default="scope">
      <el-button type="success" @click="edit(scope.row)">Edit</el-button>
      <el-button type="danger" @click="del(scope.$index,scope.row)">Delete</el-button>
    </template>
  </el-table-column>
</el-table>
</template>

<script setup>
import {onMounted, ref} from "vue";
import {ElMessage} from "element-plus";
import axios from "axios";
import router from "@router";

const edit = (content)=>{
  localStorage.from="admin";
  router.push('/personal/post?id='+content.id)
}

//3. Add a click-triggered function to the button
const del = (i, content)=>{
  if(confirm('Confirm deletion of this content?')){
    axios.post(BASE_URL+'/v1/contents/'+content.id+'/delete').then((response)=>{
      if(response.data.code==2001){
        arr.value.splice(i,1);
        ElMessage.success('Deleted!')
      }
    })
  }
}
//1.Prepare Javascript Arr/Delete the fake data
const arr = ref([]);
//2.Send request to retrieve data
onMounted(()=>{
  axios.get(BASE_URL+'/v1/contents/admin').then((response)=>{
    if(response.data.code==2001){
      arr.value = response.data.data
    }
  })
})

</script>
