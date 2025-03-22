<!--Personal info page-->
<template>
  <el-form label-width="100px" style="width: 500px;">
    <el-form-item label="head">
      <el-upload
        v-model:file-list="fileList"
        action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
      >
        <el-icon><Plus/></el-icon>
      </el-upload>
      <el-dialog v-model="dialogVisible">
        <img w-full :src="dialogImageUrl" alt="Preview Image">
      </el-dialog>
    <!--End of avatar upload-->
    </el-form-item>
    <el-form-item label="nickname">
      <el-input placeholder="Enter nickname"></el-input>
    </el-form-item>
    <el-form-item  label="username">
      <!-- Set the default value tom for the username input box and
      disable it (you can only view it but not change it)-->
      <el-input placeholder="Please enter username"  value="tom" disabled></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary">Save</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup>
import { ref } from 'vue'
import {Plus} from '@element-plus/icons-vue'

const fileList = ref([

])

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