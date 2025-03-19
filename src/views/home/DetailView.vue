<!--detail page-->
<template>
  <el-row :gutter="10" style="width: 1200px;margin: 0 auto;">
    <el-col :span="18">
      <el-card>
        <h1 style="color:orange;text-align:center;">花式奶油面包，隔壁小孩馋哭了</h1>
        <p style="font-size:12px;color:#666;text-align:center;">
          作者：传奇 | 发布时间2025/3/19 | 阅读次数： 37285
        </p>
        <hr>
        <el-card>
          <span style="color:#0aa1ed;font-weight:bold;">摘要：</span>
          这是文章的摘要内容
        </el-card>
        <p>这里是正文</p>
        <img src="/imgs/bread.jpg" style="width:100%;">
      </el-card>
      <!--评论区相关内容-->
      <el-card style="margin-top:10px;">
        <p>发一条友善的评论</p>
        <hr>
        <el-row :gutter="10">
          <el-col :span="22"><el-input placeholder="请输入"></el-input></el-col>
          <el-col ：span="2"><el-button>发布</el-button></el-col>
        </el-row>
        <el-row :gutter="10" v-for="item in 6" style="margin: 10px;">
          <el-col :span="2">
            <el-avatar style="margin:10px;"><img src="/imgs/head.jpg"></el-avatar>
          </el-col>
          <el-col :span="22">
            <p style="color:orange;font-weight:bold;margin: 0;font-size: 15px;">传奇</p>
            <p style="margin:2px 0;font-size: 13px;">看起来很好吃的样子</p>
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
          <p style="font-size:20px;font-weight:bold;margin: 5px 0;">传奇</p>
          <el-icon class="head-icon"><Edit/></el-icon><span>本文作者</span>
          <br>
          <el-icon class="head-icon"><Clock/></el-icon><span>2025/03/19</span>
        </div>
      </el-card>
      <el-card>
        <h2></h2>
        <hr>
        <el-row>
          <eo-col>
            <img src="" alt="">
          </eo-col>
          <el-col>
            <p></p>
            <p></p>
          </el-col>
        </el-row>
      </el-card>
      <el-card style="">
        <h2></h2>
        <hr>
        <el-row>
          <el-col>
            <img src="" alt="">
          </el-col>
          <el-col>
            <p></p>
            <p></p>
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
