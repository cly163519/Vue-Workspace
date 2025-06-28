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
        <el-menu mode="horizontal" active-text-color="orange" default-active="0">
          <el-menu-item index="0">All</el-menu-item>
          <el-menu-item v-for="c in recipeCatArr" :index="c.id">{{c.name}}</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in 4" style="margin-top: 10px;">
        <el-card>
          <!--7 Click every card turn to detail page -->
          <router-link to="/detail" style="text-decoration: none;color:#333;">
            <img src="/imgs/a.jpg" style="width:100%;height:150px;">
            <p style="height: 40px;">Creamy bread</p>
          </router-link>
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size:20px;line-height:40px;">Michael</el-col>
            <el-col :span="4" style="line-height:40px;">Big Bread</el-col>
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
        <el-menu mode="horizontal" active-text-color="orange" default-active="0">
          <el-menu-item index="">All</el-menu-item>
          <el-menu-item v-for="c in videoCatArr" :index="c.id">{{c.name}}</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in 4" style="margin-top: 10px;">
        <el-card>
        <!--  7跳转详情页-->
        <router-link to="/detail" style="text-decoration: none;color:#333;">
          <img src="/imgs/a.jpg" style="widt:100%;height:150px;">
          <p style="height: 40px;">Creamy bread</p>
        </router-link>
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size:20px;line-height: 40px;">Michael</el-col>
            <el-col :span="4" style="line-height:40px;">Big Bread</el-col>
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
        <el-menu mode="horizontal" active-text-color="orange" default-active="0">
          <el-menu-item index="0">All</el-menu-item>
          <el-menu-item v-for="c in infoCatArr" :index="c.id">{{c.name}}</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in 4" style="margin-top: 10px;">
        <el-card>
          <router-link to="/detail" style="text-decoration: none;color:#333;">
            <img src="/imgs/a.jpg" style="width:100%;height:150px;">
            <p style="height: 40px;">Creamy bread</p>
          </router-link>
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size:20px;line-height: 40px;">Michael</el-col>
            <el-col :span="4" style="line-height: 40px;">Big Bread</el-col>
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




</script>


<style scoped>

</style>