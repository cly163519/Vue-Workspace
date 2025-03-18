<!-- front page-->
<template>
  <!--1.设置首页 -->
  <div style="width: 1200px;margin: 0 auto;">
    <!--2.添加轮播图-->
    <el-carousel>
      <!--3.每个轮播项为一张图 -->
      <el-carousel-item v-for="item in 3">
        <img :src="'/imgs/banner'+item+'.jpg'" style="width: 100%;height: 100%;">
      </el-carousel-item>
    </el-carousel>
      <!--  烘焙食谱-->
    <el-row :gutter="10" style="background-color:#fff;margin-top:10px;">
      <el-col :span="3">
        <p style="font-size:28px;margin:10px;">烘焙食谱</p>
      </el-col>
      <el-col :span="21">
        <!--default-active="1",表示模式激活的是第一项“全部”-->
        <el-menu mode="horizontal" active-text-color="orange" default-active="1">
          <el-menu-item index="1">全部</el-menu-item>
          <el-menu-item index="2">面包</el-menu-item>
          <el-menu-item index="3">小食</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in 4" style="margin-top: 10px;">
        <el-card>
          <!--7 每张卡片点击跳转到详情页-->
          <router-link to="/detail" style="text-decoration: none;color:#333;">
            <img src="/imgs/a.jpg" style="width:100%;height:150px;">
            <p style="height: 40px;">奶油面包</p>
          </router-link>
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size:20px;line-height:40px;">传奇</el-col>
            <el-col :span="4" style="line-height:40px;">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin:10px;">
      <!--  点击按钮，跳转ListView页面-->
      <el-button @click="router.push('/list')">点击加载更多</el-button>
    </div>
<!--   4. 烘焙食谱结束-->
<!--   5. 烘焙视频开始-->
    <el-row :gutter="10" style="background-color:#fff;margin-top:10px;">
      <el-col :span="3">
        <p style="font-size:28px;margin:10px;">烘焙视频</p>
      </el-col>
      <el-col :span="21">
        <el-menu mode="horizontal" active-text-color="orange" default-active="1">
          <el-menu-item index="1">全部</el-menu-item>
          <el-menu-item index="2">面包</el-menu-item>
          <el-menu-item index="3">小食</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in 4" style="margin-top: 10px;">
        <el-card>
        <!--  7跳转详情页-->
        <router-link to="/detail" style="text-decoration: none;color:#333;">
          <img src="/imgs/a.jpg" style="widt:100%;height:150px;">
          <p style="height: 40px;">奶油面包</p>
        </router-link>
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size:20px;line-height: 40px;">传奇</el-col>
            <el-col :span="4" style="line-height:40px;">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center; margin:10px;">
      <!--  8跳转listview列表-->
      <el-button @click="router.push('/list')">点击加载更多</el-button>
    </div>
      <!-- 5烘焙视频结束-->
      <!-- 6行业资讯开始-->
    <el-row :gutter="10" style="background-color:#fff;margin-top:10px;">
      <el-col :span="3">
        <p style="font-size:28px;margin:10px;">行业资讯</p>
      </el-col>
      <el-col :span="21">
        <el-menu mode="horizontal" active-text-color="orange" default-active="1">
          <el-menu-item index="1">全部</el-menu-item>
          <el-menu-item index="2">面包</el-menu-item>
          <el-menu-item index="3">小食</el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in 4" style="margin-top: 10px;">
        <el-card>
          <router-link to="/detail" style="text-decoration: none;color:#333;">
            <img src="/imgs/a.jpg" style="width:100%;height:150px;">
            <p style="height: 40px;">奶油面包</p>
          </router-link>
          <el-row :gutter="10">
            <el-col :span="4">
              <el-avatar src="/imgs/head.jpg"></el-avatar>
            </el-col>
            <el-col :span="16" style="font-size:20px;line-height: 40px;">传奇</el-col>
            <el-col :span="4" style="line-height: 40px;">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <div style="text-align: center;margin:10px;">
      <!--8点击跳转-->
      <el-button @click="router.push('/list')">点击加载更多</el-button>
    </div>
    <!--6行业资讯结束-->
  </div>
</template>

<script setup>
import router from "@/router";
</script>


<style scoped>

</style>