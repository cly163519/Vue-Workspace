<!--detail page-->
<template>
  <el-row :gutter="10" style="width: 1200px;margin: 0 auto;">
    <el-col :span="18">
      <el-card>
        <h1 style="color:orange;text-align:center;">{{ content.title }}</h1>
        <p style="font-size:12px;color:#666;text-align:center;">
          Author：{{ content.nickname }} | Release time: {{ content.createTime }} | Views： {{ content.viewCount }}
        </p>
        <hr>
        <div  v-if="content.type!=2">
        <el-card>
          <span style="color:#0aa1ed;font-weight:bold;">Abstract：</span>
          {{ content.brief }}
        </el-card>
          <img src="/imgs/bread.jpg" style="width:100%;">
          <div v-html="content.content"></div>
        </div>
        <div v-else>
          <video :src="'http://localhost:8080'+content.videoUrl" controls type="video/mp4" style="width:100%;"></video>
        </div>
        <p>This is the main part</p>
        <img src="/imgs/bread.jpg" style="width:100%;">
      </el-card>
      <!--Comments area-->
      <el-card style="margin-top:10px;">
        <p>Comments</p>
        <hr>
        <el-row :gutter="10">
          <el-col :span="22"><el-input placeholder="Please Enter" v-model="comment.content"></el-input></el-col>
          <el-col ：span="2"><el-button @click="post()">Release</el-button></el-col>
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
          <el-avatar :size="90" :src="'http://localhost:8080'+content.userImgUrl" style="border:5px solid #fff;"></el-avatar>
          <p style="font-size:20px;font-weight:bold;margin: 5px 0;">{{ content.nickname }}</p>
          <el-icon class="head-icon"><Edit/></el-icon><span>Author</span>
          <br>
          <el-icon class="head-icon"><Clock/></el-icon><span>{{ content.createTime }}</span>
        </div>
      </el-card>

      <el-card style="margin-top:10px;">
        <h2>Articles</h2>
        <hr>
        <el-row :gutter="10" v-for="item in hotArr">
          <eo-col :span="10">
            <router-link :to="'/detail?id='+item.id"><img :src="'http://localhost:8080'+item.imgUrl" style="width:100%;"></router-link>
          </eo-col>
          <el-col :span="14">
            <router-link :to="'/detail?id='+item.id"><p class="title_p">{{ item.title }}</p></router-link>
            <p style="color:#666;font-size:12px;margin: 0;">{{ item.createTime }}</p>
          </el-col>
        </el-row>
      </el-card>
      <el-card style="margin-top:10px;">
        <h2>Other articles</h2>
        <hr>
        <el-row :gutter="10" v-for="item in otherArr">
          <el-col :span="10">
            <router-link :to="'/detail?id='+item.id">
            <img :src="'http://localhost:8080'+item.imgUrl" style="width:100%;"></router-link>
          </el-col>
          <el-col :span="14">
            <router-link :to="'/detail?id='+item.id">
            <p class="title_p">{{ item.title }}</p></router-link>
            <p style="color:#666;font-size:12px;margin:0;">{{ item.createTime }}</p>
          </el-col>
        </el-row>
      </el-card>

    </el-col>
  </el-row>
</template>

<script setup>
import {onBeforeUpdate, onMounted, ref} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import qs from "qs";

//1.Define object and save content details
const content = ref({});
const otherArr = ref([]);
const hotArr = ref([]);
const comment = ref({content: '',userId:'',contentId:''});

const post = ()=>{
  let user = localStorage.user?JSON.parse(localStorage.user):null;
  if(user==null){
    alert('Please login!');
    return;
  }
  comment.value.userId = user.id;
  comment.value.contentId = content.value.id;
  let data = qs.stringify(comment.value);
  axios.post('http://localhost:8080/v1/comments/add-new',data).then((response)=>{
    if(response.data.code == 2001){
      ElMessage.success('Finished comment!');
    }
  })
}

//6.Define the method of initial data
const initData = ()=>{
  //3.Get the id's address
  let id = new URLSearchParams(location.search).get('id');
  //4.Send query to backend
  axios.get('http://localhost:8080/v1/contents/'+id+'/detail').then((response)=>{
    if(response.data.code == 2001){
      content.value = response.data.data;
      axios.get('http://localhost:8080/v1/contents'+content.value.userId + '/other').then((response)=>{
        if(response.data.code ==2001){
          otherArr.value = response.data.data;
        }
      })
    }
  })
  //5.Query for popular articles
  axios.get('http://localhost:8080/v1/contents/hot').then((response)=>{
  if(response.data.code == 2001){
    hotArr.value = response.data.data;
  }
  })
}
//2.Jump and execute instantly
onMounted(()=> {
  initData();
})
//8.Opposite of onMounted()
onBeforeUpdate(()=>{
  initData();
})
</script>


<style scoped>
.title_p{
  height: 40px;
  margin-top:0px;
  overflow:hidden;
  display:-webkit-box;
  -webkit-line-clamp:2;
  -webkit-box-orient:vertical;
  color:orange;

}
a {
  color:#333;
  text-decoration:none;
}
a:hover{
  font-weight: bold;
  color: orange;
}
#head-div {
  height: 90px;
  background-image: url("/public/imgs/avarbg.jpg");
}
.head-icon{
  font-weight:bold;
  color:orange;
  position:relative;
  top: 3px;
  right: 5px;
}
</style>
