<template>
  <div class="common-layout">
    <el-container>
      <el-header style="height: 80px;background-color:#fff;">
        <el-row :gutter="20" style="width: 1200px;margin: 0 auto;">
          <el-col :span="6">
            <!--click logo，return to homepage-->
            <router-link to="/">
              <img src="/imgs/icon.png" style="width: 200px; height: 80px;">
            </router-link>
          </el-col >
          <el-col :span="8">
            <el-menu mode="horizontal" active-text-color="orange" style="height: 70px;" @select="handleSelect">
              <el-menu-item index="1">Recipe</el-menu-item>
              <el-menu-item index="2">Videos</el-menu-item>
              <el-menu-item index="3">Information</el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="6">
            <el-input placeholder="Typing contents" style="margin-top: 25px;">
              <template #append>
                <el-button :icon="Search"></el-button>
              </template>
            </el-input>
          </el-col>
          <el-col :span="2">
            <el-popover title="Welcome baking web">
              <template #reference>
                <router-link to="/personal">
                  <el-icon siza="35" style="margin-top: 30px;" color="#666"><User></User></el-icon>
                </router-link>
              </template>
              <div style="text-aligh: center;">
                <el-button type="info" size="small" @click="router.push('/reg')">Register</el-button>
                <el-button type="warning" size="small" @click="router.push('/login')">Login</el-button>
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
import {Search} from '@element-plus/icons-vue';
import router from '@/router';

const handleSelect = (key,keyPath)=>{
  router.push('/list');
}
</script>

<style>
footer h3{
  color: #fff;
}
#footer-center p{
  margin: 5px 0;
}
</style>
