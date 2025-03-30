<!-- login page  -->
<template>
  <div id="main-div">
    <el-card style="width: 500px;height:300px;margin: 0 auto;
    position: relative;top:100px;">
      <el-form label-width="60px">
        <el-form-item label="Username" style="margin-top: 60px;">
          <el-input placeholder="Please enter username" v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item label="password">
          <el-input placeholder="Please enter password" type="password" v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100px;margin-left: 120px;" @click="login()">Login</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>
import {ref} from "vue";
import qs from "qs";
import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router";

const user = ref({username:'',password:''});
const login = ()=>{
  let data = qs.stringify(user.value);
  axios.post('http://localhost:8080/v1/users/login',data).then((response)=>{
    if(response.data.code==2001){
      ElMessage.success("Login success!");
      let user = response.data.data;
      localStorage.user = JSON.stringify(user);
      //router.push('/');
      location.href='/';
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}

</script>

<style scoped>
  #main-div{
    height: 500px;
    background-image: url('/public/imgs/loginbg.gif');
    background-size: cover;
    background-position: center;
  }
</style>