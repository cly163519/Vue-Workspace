<!--Personal Page-->
<!--1.left side,shared area-->
<template>
  <el-row :gutter="10" style="width:1200px;margin: 0 auto;">
    <el-col :span="4">
      <el-card style="height:100%;">
        <el-menu router active-text-color="orange" default-active="/personal/info">
          <el-menu-item index="/personal/info">Personal info</el-menu-item>
          <el-menu-item index="/personal/management">Post Management</el-menu-item>
        </el-menu>
      </el-card>
    </el-col>
<!--2.right side,variable region -->
    <el-col :span="20">
      <el-card>
        <router-view/>
      </el-card>
    </el-col>
  </el-row>
</template>

<script setup>

</script>