<!--A common header and a left sidebar, with a variable (dynamic) area on the right.-->
<template>
  <div class="common-layout">
    <el-container>
      <!--1.Edit shared header -->
      <el-header style="background-color:#368;line-height:60px;">
        <h1 style="color:#fff;font-size:30px;margin:0;">
          Baking Web Admin System
          <el-button style="float:right;margin:14px 0 0 5px;" @click="logout()">Logout</el-button>
          <span style="font-size:20px;float:right;">Welcome back, {{ user.nickname }}!</span>
        </h1>
      </el-header>
      <el-container>
        <!--2.Edit left side bar-->
        <el-aside width="200px">
          <el-menu router active-text-color="orange" default-active="/admin/user" style="height:100%;">
            <img src="/imgs/icon.png" style="width: 150px;margin:20px;">
            <el-menu-item index="/admin/user">
              <el-icon><User></User></el-icon>User Admin</el-menu-item>
            <el-menu-item index="/admin/banner">
              <el-icon><Picture></Picture></el-icon>Carousel Admin</el-menu-item>
            <el-menu-item index="/admin/content">
              <el-icon><ChatDotSquare></ChatDotSquare></el-icon>Content Admin</el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>

</style>

<script setup>
import {ref} from "vue";
import router from "@/router";

const user = ref(localStorage.user?JSON.parse(localStorage.user):null);
const logout = ()=>{
  if(confirm('Are you sure logout?')){
    localStorage.clear();
    router.push('/');
  }
}
</script>