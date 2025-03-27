<!-- login page  -->
<template>
  <div id="main-div">
    <el-card style="width: 500px;height:300px;margin: 0 auto;
    position: relative;top:100px;">
      <el-form label-width="60px">
        <el-form-item label="Username" style="margin-top: 60px;">
          <el-input placeholder="Please enter username"></el-input>
        </el-form-item>
        <el-form-item label="password">
          <el-input placeholder="Please enter password" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100px;margin-left: 120px;">Login</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>

</script>

<style scoped>
  #main-div{
    height: 500px;
    background-image: url('/public/imgs/loginbg.gif');
    background-size: cover;
    background-position: center;
  }
</style>