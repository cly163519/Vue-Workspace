<!--Carousel Admin Page-->
<template>
  <el-table :data="arr">
    <el-table-column type="index" label="index" width="120px" align="center"></el-table-column>
    <el-table-column label="carousel" width="450" align="center">
      <template #default="scope">
        <img :src="scope.row.imgUrl" style="width:100%;">
      </template>
    </el-table-column>
    <el-table-column prop="createTime" label="createTime" align="center"></el-table-column>
    <el-table-column label="operation" align="center">
      <template #default="scope">
        <el-button type="danger" @click="del(scope.$index)">delete</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>
import {ref} from "vue";
import {ElMessage} from "element-plus";
const arr = ref([
  {imgUrl:'/imgs/banner1.jpg',createTime:'2025/03/22'},
  {imgUrl:'/imgs/banner2.jpg',createTime:'2025/03/22'},
  {imgUrl:'/imgs/banner3.jpg',createTime:'2025/03/22'},
]);
const del = (i) =>{
  if(confirm('Do you want to delete carousel picture?')){
    arr.value.splice(i,1);
    ElMessage.success('删除成功！')
  }
}
</script>