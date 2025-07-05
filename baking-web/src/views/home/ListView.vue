<!--List Page-->
<template>
  <div style="width: 1200px;margin: 0 auto;">
    <!--Cope HomeView four el-row -->
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in contentArr" style="margin-top: 10px;">
        <el-card>
          <router-link :to="'/detail?id='+item.id" style="text-decoration: none;color:#333;">
            <img :src="'http://localhost:8080'+item.imgUrl" style="width:100%;height:150px;">
            <p style="height:40px;">{{ item.title }}</p>
          </router-link>
          <el-row :gutter="10">
            <el-col :span="4"><el-avatar :src="'http://localhost:8080'+item.userImgUrl"></el-avatar></el-col>
            <el-col :span="13" style="font-size:20px;line-height:40px;">{{  item.nickname }}</el-col>
            <el-col :Span="7" style="line-height:40px;">{{ item.categoryName }}</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>

</style>

<script setup>
import {onMounted, ref} from "vue";
import axios from "axios";

const contentArr = ref([]);

onMounted(()=>{
  let type = new URLSearchParams(location.search).get('type');
  console.log(type);
  axios.get('http://localhost:8080/v1/contents/'+type+'/type').then((response)=>{
    if(response.data.code==2001){
      contentArr.value = response.data.data;
    }
  })
})
</script>