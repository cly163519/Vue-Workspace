<!--Personal info page-->
<template>
  <el-form label-width="100px" style="width: 500px;">
    <el-form-item label="head">


    </el-form-item>
    <el-form-item label="nickname">
      <el-input placeholder="Enter nickname"></el-input>
    </el-form-item>
    <el-form-item  label="username">
      <!-- Set the default value tom for the username input box and
      disable it (you can only view it but not change it)-->
      <el-input value="tom" disabled></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary">Save</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup>

</script>