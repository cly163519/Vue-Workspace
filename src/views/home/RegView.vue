<!--Register page-->
<template>
  <div style="width: 1200px;margin: 0 auto;">
    <el-row :gutter="10">
      <!-- A card on leftside -->
      <el-col :span="12">
        <el-card>
          <img src="/imgs/reg.png" style="width:100%;">
        </el-card>
      </el-col>
      <!-- Rightside is a sheet-->
      <el-col :span="12">
        <el-form label-width="80px" style="margin-top:100px;">
          <el-form-item>
            <h1 style="width: 515px;font-size:40px;position: relative;">Register
              <router-link to="/login" style="font-size:20px;color:#0aa1ed;text-decoration:none;
              position: absolute;right:0;">
                Login
              </router-link>
            </h1>
          </el-form-item>
          <el-form-item label="Username">
            <el-input placeholder="Enter username"></el-input>
          </el-form-item>
          <el-form-item label="Password">
            <el-input placeholder="Enter Password" type="password"></el-input>
          </el-form-item>
          <el-form-item label="Nickname">
            <el-input placeholder="Enter Nickname"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" style="width:100%;">Register</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>

</template>


<script setup>

</script>