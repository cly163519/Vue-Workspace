<template>
<!--  1.Element-Plus, Container template, top-middle-bottom structure-->
  <div class="common-layout">
    <el-container>
      <!-- 2.Edit header -->
      <el-header style="height: 80px;background-color:#fff;">
      <!-- 3.Layout column -->
        <el-row :gutter="20" style="width: 1200px;margin: 0 auto;">
          <el-col :span="6">
            <!--4.click logo，return to homepage-->
            <router-link to="/">
              <img src="/imgs/icon.png" style="width: 200px; height: 80px;">
            </router-link>
          </el-col >
          <el-col :span="8">
            <!--  Header navigation bar -->
            <el-menu mode="horizontal" active-text-color="orange" style="height: 70px;" @select="handleSelect">
              <el-menu-item index="1">Recipe</el-menu-item>
              <el-menu-item index="2">Videos</el-menu-item>
              <el-menu-item index="3">Information</el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="6">
            <el-input placeholder="Typing contents" style="margin-top: 25px;" v-model="wd" @keydown.enter="serach()">
              <template #append>
                <el-button :icon="Search" @click="search()"></el-button>
              </template>
            </el-input>
          </el-col>
          <el-col :span="2">
            <el-popover title="Welcome baking web" v-if="user==null" popper-style="text-align:center;">
              <template #reference>
                  <el-icon size="35" style="margin-top: 30px;" color="#666"><User></User></el-icon>
              </template>
              <el-avatar :src="'http://localhost:8080'+user.imgUrl"></el-avatar>
              <div style="text-align: center;">
                <el-button type="info" size="small" @click="router.push('/reg')">Register</el-button>
                <el-button type="warning" size="small" @click="router.push('/login')">Login</el-button>
              </div>
            </el-popover>
            <el-popover v-else :title="'welcome'+user.nickname+'back'" :width="200" popper-style="text-align:center;">
              <template #reference><el-icon size="25" style="margin-top: 30px;" color="#666"><User/></el-icon></template>
              <div style="text-align: center;">
                <el-button type="success" size="small" @click="router.push('/personal')">Personal Center</el-button>
                <el-button type="danger" size="small" @click="logout()">Logout</el-button>
                <br>
                <el-button v-if="user.isAdmin==1"
                type="primary" style="width:158px;margin-top:8px;" size="small"
                @click="router.push('/admin')">Back-end management page</el-button>
              </div>
            </el-popover>
          </el-col>
        </el-row>
      </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
        <el-footer style="background-color: rgb(50,50,50);color:#666;height:300px;padding:50px;text-align:center;">
          <div style="width: 1200px;margin: 0 auto;">
            <el-row :gutter="10">
              <el-col :span="6" style="text-align: left;">
                <img src="/imgs/icon.png" style="width:200px;">
                <p>More ideas on baking web</p>
                <p>Baking industry networking community</p>
                <p>Job vacancies waiting for you</p>
              </el-col>
              <el-col :span="12" id="footer-center" style="text-align: left;">
                <el-row :gutter="10">
                  <el-col :span="8">
                    <h3>About us</h3>
                    <p>Baking Academy</p>
                    <p>Baking Recipe</p>
                    <p>Information</p>
                    <p>Job opportunities</p>
                    <p>Communication</p>
                  </el-col>
                  <el-col :span="8">
                    <h3>Service & Support</h3>
                    <p>Contacts</p>
                    <p>Advertisement</p>
                    <p>Agreement</p>
                    <p>Links</p>
                    <p>Feedbacks</p>
                  </el-col>
                  <el-col :span="8">
                    <h3>Navigation</h3>
                    <p>Archiver</p>
                    <p>Mobile</p>
                    <p>Blacklist</p>
                  </el-col>
                </el-row>
              </el-col>
              <el-col :span="6">
                <p style="font-size: 60px;color:#666;margin: 10px 0;">
                  <span style="color:orange;">Bakery</span>
                </p>
                <p>Baking community</p>
              </el-col>
            </el-row>
          </div>
        </el-footer>
    </el-container>
  </div>
</template>

<script setup>
//The magnifying glass icon on the button in the search box is imported here.
import {Search} from '@element-plus/icons-vue';
//Reg button need to be imported here./reg
import router from '@/router';
import {onMounted, ref} from "vue";
import axios from "axios";

const wd = ref('');
const search = ()=>{
  //Carry search keywords to the list page
  router.push('/list?wd='+wd.value);
}
//1.Retrieve saved user information
const user = ref(localStorage.user?JSON.parse(localStorage.user):null);
//2.Implement the exit function
const logout=()=>{
  if(confirm("Are you sure to logout?")){
    localStorage.clear();
    user.value=null;//Let the page change accordingly
    router.push('/');//Jump to homepage
  }
}
//Add a jump function to the top navigation bar to jump to the ListView

const handleSelect = (index)=>{
  router.push('/list?type='+index);
}
</script>

<style>
/* Here, the text title colour in the middle of the footer is set to white,
and the text content has outer spacing.*/
footer h3{
  color: #fff;
}
#footer-center p{
  margin: 5px 0;
}
</style>
