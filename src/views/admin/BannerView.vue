<!--Carousel Admin Page-->
<template>
  <el-table>
    <el-table-column></el-table-column>
    <el-table-column></el-table-column>
    <el-table-column></el-table-column>
    <el-table-column></el-table-column>
  </el-table>
</template>

<script setup>
import {ref} from "vue";
import {ElMessage} from "element-plus";
const arr = ref([
  {imgUrl:'/imgs/banner1.jpg',creatTime:'2025/03/22'},
  {imgUrl:'/imgs/banner2.jpg',creatTime:'2025/03/22'},
  {imgUrl:'/imgs/banner3.jpg',creatTime:'2025/03/22'},
]);
</script>