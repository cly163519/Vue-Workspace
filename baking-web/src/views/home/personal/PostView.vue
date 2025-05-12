<!--Post Page-->
<template>
  <h1 style="color:orange;">Post page</h1>
  <el-form label-width="100px">
    <el-form-item label="article title">
      <el-input placeholder="Please enter the article title" v-model="content.title"></el-input>
    </el-form-item>
    <el-form-item label="article type">
      <!--@change="" Triggered when options change-->
      <el-radio-group @change="typeChange()" v-model="content.type">
<!--        <el-radio-button label="1">Baking Recipe</el-radio-button>-->
<!--        <el-radio-button label="2">Baking Video</el-radio-button>-->
<!--        <el-radio-button label="3">Information</el-radio-button>-->
      <!-- Display types using iteration -->
      <el-radio-button v-for="c of catTypeArr" :label="c.type">{{c.name}}</el-radio-button>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="Sub class">
      <!-- Set up two-way binding and placeholder text for the dropdown menu -->
      <el-select v-model="content.categoryId" placeholder="Please select">
      <!-- <el-option label="Bread" value="1"></el-option>-->
      <!-- <el-option label="Snacks" value="2"></el-option>-->
        <el-option v-for = "c in catgoryArr" :label="c.name" :value="c.id"></el-option>
      </el-select>
    </el-form-item>
    <!-- Start of cover upload -->
    <el-form-item label="Cover">
      <!-- This part is the same as in InfoView and can be reused directly -->
      <el-upload
          v-model:file-list="fileList"
          action="http://localhost:8080/v1/upload"
          name="file"
          limit="1"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
      >
        <el-icon><Plus/></el-icon>
      </el-upload>
      <el-dialog v-model="dialogVisible">
        <img w-full :src="dialogImageUrl" alt="Preview Image"/>
      </el-dialog>
    </el-form-item>
    <!-- End of the cover upload -->

    <!--Cope the whole process of upload video-->
    <el-form-item label="video" v-show="content.type==2">
      <el-upload
          v-model:file-list="videoList"
          action="http://localhost:8080/v1/upload"
          name="file"
          limit="1"
          list-type="picture-card"
          accept="video/*"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove">
        <el-button type="warning">Click to upload</el-button>
        <div>(Only mp4 files no larger than 100 MB can be uploaded)</div>
      </el-upload>
      <el-dialog v-model="dialogVisible">
        <img v-full :src="dialogImageUrl" alt="Preview Image"/>
      </el-dialog>
    </el-form-item>
    <!--Upload video end-->
    <el-form-item label="Article content" v-show="content.type!=2">
      <div ref="editorDiv"></div>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="post()">Publish content</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup>
import {onMounted, ref} from 'vue';
import {Plus} from '@element-plus/icons-vue';
import Editor from 'wangeditor';
import axios from "axios";
import {ElMessage} from "element-plus";
import qs from "qs";
import router from "@/router";

const catTypeArr = ref([]);
const catgoryArr = ref([]);

const content = ref({title:'',type:'1',categoryId:''})

const typeChange = ()=>{
  content.value.categoryId='';
  axios.get('http://localhost:8080/v1/categories/'+content.value.type+'/sub').then((response)=>{
    if(response.data.code==2001){
      catgoryArr.value = response.data.data;
    }
  })
}

onMounted(()=>{
  axios.get('http://localhost:8080/v1/categories/1/sub').then((response)=>{
    if(response.data.code == 2001){
      catgoryArr.value = response.data.data;
    }
  })
  axios.get('http://localhost:8080/v1/categories/type').then((response)=>{
    if(response.data.code == 2001){
      catTypeArr.value = response.data.data;
    }
  })
})

const editorDiv = ref(null);
let editor = null;

onMounted(()=>{
  editor = new Editor(editorDiv.value);
  editor.config.placeholder = "Please enter the content";
  editor.create();
})

const videoList = ref([]);

const post = ()=> {
  let user = localStorage.user ? JSON.parse(localStorage.user) : null;
  if (user == null) {
    ElMessage.error('Please login')
    router.push('/login')
    return;
  }
  content.value.userId = user.id;
  if (content.value.title.trim() == '') {
    ElMessage.error('Please enter the topic');
    return;
  }
  if (content.value.categoryId == '') {
    ElMessage.error('Please choose the subclass');
    return;
  }
  if (fileList.value.length == 0) {
    ElMessage.error('Please choose the cover');
    return;
  }
  let imgUrl = fileList.value[0].response.data;
  content.value.imgUrl = imgUrl;
  if(content.value.type==2){
    if(videoList.value.length==0){
      ElMessage.error('Please select the video file');
      return;
    }
    let videoUrl = videoList.value[0].respons.data;
    content.value.videoUrl = videoUrl;
    }else{
  console.log('html=' + editor.txt.html());
  console.log('text=' + editor.txt.text());
  content.value.content = editor.txt.html();
  content.value.brief = editor.txt.text().slice(0, 30);
}
  let data = qs.stringify(content.value)
  axios.post('http://localhost:8080/v1/contents/add-new',data).then((response)=>{
    if(response.data.code==2001){
      ElMessage.success("Published successfully")
      router.push('/personal/management');
    }
  })
}

const fileList = ref([])

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

//The image deletion method
const handleRemove = (uploadFile, uploadFiles)=>{
  let imgUrl = uploadFile.response.data;
  axios.post('http://localhost:8080/v1/remove?imgUrl='+imgUrl).then((response)=>{
    if(response.data.code==2001){
      ElMessage.success('The server has deleted the file');
    }
  })
  console.log(uploadFile,uploadFiles)
}

const handlePictureCardPreview = (uploadFile) =>{
  dialogImageUrl.value = uploadFile.url
  dialogVisible.value = true
}
</script>
