<!--detail page-->
<template>
  <el-row :gutter="10" style="width: 1200px;margin: 0 auto;">
    <el-col :span="18">
      <el-card>
        <h1 style="color:orange;text-align:center;">Fancy cream bread</h1>
        <p style="font-size:12px;color:#666;text-align:center;">
          Author：Michael | Release time: 2025/3/19 | Views： 37285
        </p>
        <hr>
        <el-card>
          <span style="color:#0aa1ed;font-weight:bold;">Abstract：</span>
          This is abstract
        </el-card>
        <p>This is the main part</p>
        <img src="/imgs/bread.jpg" style="width:100%;">
      </el-card>
      <!--Comments area-->
      <el-card style="margin-top:10px;">
        <p>Comments</p>
        <hr>
        <el-row :gutter="10">
          <el-col :span="22"><el-input placeholder="Please Enter"></el-input></el-col>
          <el-col ：span="2"><el-button>Release</el-button></el-col>
        </el-row>
        <el-row :gutter="10" v-for="item in 6" style="margin: 10px;">
          <el-col :span="2">
            <el-avatar style="margin:10px;"><img src="/imgs/head.jpg"></el-avatar>
          </el-col>
          <el-col :span="22">
            <p style="color:orange;font-weight:bold;margin: 0;font-size: 15px;">Michael</p>
            <p style="margin:2px 0;font-size: 13px;">Delicious</p>
            <p style="font-size:12px;color:#666;margin:0;">2025/3/19 09:74:38</p>
          </el-col>
        </el-row>
      </el-card>
    </el-col>

    <el-col :span="6">
      <el-card>
        <div id="head-div"></div>
        <div style="text-align:center;position:relative;bottom:45px;">
          <el-avatar :size="90" src="/imgs/head.jpg" style="border:5px solid #fff;"></el-avatar>
          <p style="font-size:20px;font-weight:bold;margin: 5px 0;">Michael</p>
          <el-icon class="head-icon"><Edit/></el-icon><span>Author</span>
          <br>
          <el-icon class="head-icon"><Clock/></el-icon><span>2025/03/19</span>
        </div>
      </el-card>

      <el-card style="margin-top:10px;">
        <h2>Articles</h2>
        <hr>
        <el-row :gutter="10" v-for="item in 4">
          <eo-col :span="10">
            <img src="/imgs/a.jpg" style="width:100%;">
          </eo-col>
          <el-col :span="14">
            <p style="height:40px;margin-top:0;">This is the topic</p>
            <p style="color:#666;font-size:12px;margin: 0;">2025/03/19</p>
          </el-col>
        </el-row>
      </el-card>
      <el-card style="margin-top:10px;">
        <h2>Other articles</h2>
        <hr>
        <el-row :gutter="10" v-for="item in 4">
          <el-col :span="10">
            <img src="/imgs/a.jpg" style="width:100%;">
          </el-col>
          <el-col :span="14">
            <p style="height:38px;margin-top:0;">This is the topic</p>
            <p style="color:#666;font-size:12px;margin:0;">2025/03/19</p>
          </el-col>
        </el-row>
      </el-card>

    </el-col>
  </el-row>
</template>

<script setup>

</script>

<style scoped>
#head-div {
  height: 90px;
  background-image: url("/public/imgs/avarbg.jpg");
}
.head-icon{
  font-weight:bold;
  color:orange;
  position:relative;
}
</style>
