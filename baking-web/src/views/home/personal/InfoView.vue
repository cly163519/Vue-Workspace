<!--Personal info page-->
<template>
  <el-form label-width="100px" style="width: 500px;">
    <el-form-item label="head">
      <el-upload
        v-model:file-list="fileList"
        action="http://localhose:8080/v1/upload"
        limit="1"
        name="file"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
      >
        <el-icon><Plus/></el-icon>
      </el-upload>
      <el-dialog v-model="dialogVisible">
        <img w-full :src="dialogImageUrl" alt="Preview Image"/>
      </el-dialog>
    <!--End of avatar upload-->
    </el-form-item>
    <el-form-item label="nickname">
      <el-input placeholder="Enter nickname" v-model="user.nickname"></el-input>
    </el-form-item>
    <el-form-item  label="username">
      <!-- Set the default value tom for the username input box and
      disable it (you can only view it but not change it)-->
      <el-input placeholder="Please enter username"  :value="user.username" disabled></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="save()">Save</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup>
import { ref } from 'vue'
import {Plus} from '@element-plus/icons-vue'
import qs from "qs";
import axios from "axios";
import {ElMessage} from "element-plus";

const user = ref(localStorage.user?JSON.parse(localStorage.user):null);
const save = ()=>{
  let newUser = {id:user.value.id,nickname:user.value.nickname};
  if(fileList.value.length>0){
    let url = fileList.value[0].response.data;
    newUser.imgUrl = url;
    user.value.imgUrl = url;
  }
  let data = qs.stringify(newUser);
  axios.post('http://localhost:8080/v1/users/update',data).then((response)=>{
    if(response.data.code == 2001){
      ElMessage.success('Revise finished!');
      localStorage.user = JSON.stringify(user.value);
      location.reload();
    }
  })
}

const fileList = ref([])

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}

const handlePictureCardPreview = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url
  dialogVisible.value = true
}
</script>