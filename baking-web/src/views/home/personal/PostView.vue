<!--Post Page-->
<template>
  <h1 style="color:orange;">Post page</h1>
  <el-form label-width="100px">
    <el-form-item label="article title">
      <el-input placeholder="Please enter the article title"></el-input>
    </el-form-item>
    <el-form-item label="article type">
      <el-radio-group>
        <el-radio-button label="1">Baking Recipe</el-radio-button>
        <el-radio-button label="2">Baking Video</el-radio-button>
        <el-radio-button label="3">Information</el-radio-button>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="Sub class">
      <el-select>
        <el-option label="Bread" value="1"></el-option>
        <el-option label="Snacks" value="2"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="Cover">
      <!-- Start of cover upload -->
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
        <img w-full :src="dialogImageUrl" alt="Preview Image"/>
      </el-dialog>
    </el-form-item>
  </el-form>
</template>

<script setup>
import {ref} from 'vue';
import {Plus} from '@element-plus/icons-vue';

const fileList = ref([])

const dialogImageUrl = ref('')
const dialogVisible = ref(false)

const handleRemove = (uploadFile,uploadFiles) =>{
  console.log(uploadFile, uploadFiles)
}

const handlePictureCardPreview = (uploadFile) =>{
  dialogImageUrl.value = uploadFile.url
  dialogVisible.value = true
}
</script>
