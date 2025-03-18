<!-- login page  -->
<template>
  <div id="main-div">
    <el-card style="width: 500px;height:300px;margin: 0 auto;
    position: relative;top:100px;">
      <el-form label-width="60px">
        <el-form-item label="用户名" style="margin-top: 60px;">
          <el-input placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input placeholder="请输入密码" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100px;margin-left: 120px;">登录</el-button>
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