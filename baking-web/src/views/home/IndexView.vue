<!-- front page-->
<template>
  <!--1.Main page -->
  <div style="width: 1200px;margin: 0 auto;">
    <!--2.Add carousel pictures-->
    <el-carousel>
      <!--3.Carousel -->
      <el-carousel-item v-for="item in 3">
        <img :src="'/imgs/banner'+item+'.jpg'" style="width: 100%;height: 100%;">
      </el-carousel-item>
    </el-carousel>
      <!-- Recipe -->
    <el-row :gutter="10" style="background-color:#fff;margin-top:10px;">
      <el-col :span="3">
        <p style="font-size:28px;margin:10px;">Baking Recipe</p>
      </el-col>
      <el-col :span="21">
        <!--default-active="1",first item-->
        <el-menu mode="horizontal" active-text-color="orange" default-active="0" @select="selectRecipe">
          <el-menu-item index="0">All</el-menu-item>
          <el-menu-item v-for="c in recipeCatArr" :index="c.id">{{c.name}}</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in recipeArr" style="margin-top: 10px;">
        <el-card>
          <!--7 Click every card turn to detail page -->
          <router-link to="/detail" style="text-decoration: none;color:#333;">
            <img :src="'http://localhost:8080'+item.imgUrl" style="width:100%;height:150px;">
            <p style="height: 40px;text-decoration: none;">{{ item.title }}</p>
          </router-link>
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar :src="'http://localhost:8080'+item.userImgUrl"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size:20px;line-height:40px;">{{item.nickname}}</el-col>
            <el-col :span="4" style="line-height:40px;">{{ item.categoryName }}</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin:10px;">
      <!--  点击按钮，跳转ListView页面-->
      <el-button @click="router.push('/list')">Click more</el-button>
    </div>
<!--   4. 烘焙食谱结束-->
<!--   5. 烘焙视频开始-->
    <el-row :gutter="10" style="background-color:#fff;margin-top:10px;">
      <el-col :span="3">
        <p style="font-size:28px;margin:10px;">Baking videos</p>
      </el-col>
      <el-col :span="21">
        <el-menu mode="horizontal" active-text-color="orange" default-active="0" @select="selectVideo">
          <el-menu-item index="">All</el-menu-item>
          <el-menu-item v-for="c in videoCatArr" :index="c.id">{{c.name}}</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in videoArr" style="margin-top: 10px;">
        <el-card>
        <!--  7Jump to contentview-->
        <router-link to="/detail" style="text-decoration: none;color:#333;">
          <img :src="'http://localhost:8080'+item.imgUrl" style="widt:100%;height:150px;">
          <p style="height: 40px;text-decoration:none;">{{  item.title }}</p>
        </router-link>
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar :src="'http://localhost:8080'+item.userImgUrl"></el-avatar>
            </el-col>
            <el-col :span="13" style="font-size:20px;line-height: 40px;">{{item.nickname}}</el-col>
            <el-col :span="7" style="line-height:40px;">{{item.categoryName}}</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center; margin:10px;">
      <!--  8跳转listview列表-->
      <el-button @click="router.push('/list')">Click more</el-button>
    </div>
      <!-- 5烘焙视频结束-->
      <!-- 6行业资讯开始-->
    <el-row :gutter="10" style="background-color:#fff;margin-top:10px;">
      <el-col :span="3">
        <p style="font-size:28px;margin:10px;">Information</p>
      </el-col>
      <el-col :span="21">
        <el-menu mode="horizontal" active-text-color="orange" default-active="0" @select="selectInfo">
          <el-menu-item index="0">All</el-menu-item>
          <el-menu-item v-for="c in infoCatArr" :index="c.id">{{c.name}}</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in infoArr" style="margin-top: 10px;">
        <el-card>
          <router-link to="/detail" style="text-decoration: none;color:#333;">
            <img :src="'http://localhost:8080'+item.imgUrl" style="width:100%;height:150px;">
            <p style="height: 40px;text-decoration:none;">{{item.title}}</p>
          </router-link>
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar :src="'http://localhost:8080'+item.userImgUrl"></el-avatar>
            </el-col>
            <el-col :span="13" style="font-size:20px;line-height: 40px;">{{ item.nickname }}</el-col>
            <el-col :span="7" style="line-height: 40px;">{{item.categoryName}}</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin:10px;">
      <!--8点击跳转-->
      <el-button @click="router.push('/list')">Click more</el-button>
    </div>
    <!--6行业资讯结束-->
  </div>
</template>

<script setup>
import router from "@/router";
import {onMounted, ref} from "vue";
import axios from "axios";
import qs from "qs";
//1.Define three secondary classification arrays
const recipeCatArr = ref([]);
const videoCatArr = ref([]);
const infoCatArr = ref([]);
//2.Execute immediately
onMounted(()=>{
  //3.1 Send a request to obtain the secondary classification of recipes.
  axios.get('http://localhost:8080/v1/categories/1/sub').then((response)=>{
    if(response.data.code==2001){
      recipeCattArr.value = response.data.data;
    }
  })
  //3.2 Send a request to obtain the secondary classification of videos.
  axios.get('http://localhost:8080/v1/categories/2/sub').then((response)=>{
    if(response.data.code==2001){
      videoCatArr.value = response.data.data;
    }
  })
  //3.3 Send a request to obtain information on secondary categories
  axios.get('http://localhost:8080/v1/categories/3/sub').then((response)=>{
    if(response.data.code==2001){
      infoCatArr.value = response.data.data;
    }
  })
  //6.Request all data for the three types, with all category IDs set to 0.
  loadContents(1,0);
  loadContents(2,0);
  loadContents(3,0);
})
//4.Define three content arrays
const recipeArr = ref([]);
const videoArr = ref([]);
const infoArr = ref([]);
//5.Define method for loading contents
const loadContents = (type,categoryId)=>{
  let data = qs.stringify({type,categoryId:categoryId});//Convert request parameters to query string format
  axios.get('http://localhost:8080/v1/contents/index?'+data).then((response)=>{//Get request need ? to connect
  if(response.data.code==2001){
    switch(type){
      case 1:recipeArr.value = response.data.data;break;
      case 2:videoArr.value = response.data.data;break;
      case 3:infoArr.value = response.data.data;break;
      }
    }
  })
}
//Choose the sub category,trigger this function
//index is the subclass id:index="c.id"
const selectRecipe = (index)=>{
  //The type of recipe is 1
  loadContents(1,index)
}
const selectVideo = (index)=>{
  loadContents(2,index)
}
const selectInfo = (index)=>{
  loadContents(3,index)
}

</script>


<style scoped>
p {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>