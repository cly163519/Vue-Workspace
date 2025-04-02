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
              <router-link to="/login" style="font-size:20px;color:#0aa1ed;position: absolute;right:0;text-decoration:none;">
                Login
              </router-link>
            </h1>
          </el-form-item>
          <el-form-item label="Username">
            <el-input placeholder="Enter username" v-model="user.username"></el-input>
          </el-form-item>
          <el-form-item label="Password">
            <el-input placeholder="Enter Password" type="password" v-model="user.password"></el-input>
          </el-form-item>
          <el-form-item label="Nickname">
            <el-input placeholder="Enter Nickname" v-model="user.nickname"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" style="width:100%;" @click="reg()">Register</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import {ref} from "vue";
import qs from "qs";
import axios from "axios";
import {ElMessage} from "element-plus";
import router from "@/router";

const user = ref({username:'',password:'',nickname:''});
const reg = ()=>{
  let data = qs.stringify(user.value);
  axios.post('http://localhost:8080/v1/users/reg',data).then((response)=>{
    if(response.data.code==2001){
      ElMessage.success("Register success!");
      router.push('/login');
    }else{
      ElMessage.error(response.data.msg);
    }
  })
}
// let name = {name: tom, age: 30};
</script>