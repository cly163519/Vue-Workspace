<!--List Page-->
<template>
  <div style="width: 1200px;margin: 0 auto;">
    <!--Cope HomeView four el-row -->
    <el-row :gutter="10">
      <el-col :span="6" v-for="item in 4" style="margin-top: 10px;">
        <el-card>
          <router-link to="/detail" style="text-decoration: none;color:#333;">
            <img src="/imgs/a.jpg" style="width:100%;height:150px;">
            <p style="height:40px;">Cream Bread</p>
          </router-link>
          <el-row :gutter="10">
            <el-col :span="4"><el-avatar src="/imgs/head.jpg"></el-avatar></el-col>
            <el-col :span="16" style="font-size:20px;line-height:40px;">Michael</el-col>
            <el-col :Span="4" style="line-height:40px;">欧包</el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>

</style>

<script setup>

</script>