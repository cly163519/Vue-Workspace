<!--Manuscript management Page-->
<template>
<el-radio-group v-model="type" @change="loadContents()">
  <el-radio-button v-for="c in catTypeArr" :label="c.type">{{c.name}}</el-radio-button>
<!--  <el-radio-button label="1">Baking Recipe</el-radio-button>-->
<!--  <el-radio-button label="2">Baking Video</el-radio-button>-->
<!--  <el-radio-button label="3">Information</el-radio-button>-->
</el-radio-group>
<!--Click Post button to jump to the publishing page. Note:import router from '@/router';-->
  <el-button type="primary" style="margin-left:20px;margin-top:7px;" @click="router.push('/personal/post')">
    Post
  </el-button>
  <el-table :data="arr">
    <el-table-column type="index" label="index" width="80" align="center"></el-table-column>
    <el-table-column prop="title" label="title" width="290" align="center"></el-table-column>
    <el-table-column prop="categoryName" label="category" width="80" align="center"></el-table-column>
    <el-table-column prop="viewCount" label="view" width="80" align="center"></el-table-column>
    <el-table-column prop="commentCount" label="comment" width="80" align="center"></el-table-column>
    <el-table-column prop="createTime" label="create" width="120" align="center"></el-table-column>
    <el-table-column label="operate" align="center">
      <template #default="scope">
        <el-button-group>
          <el-button type="success" size="small">Edit</el-button>
          <el-button type="danger" @click="del(scope.$index, scope.row)" size="small">Delete</el-button>
        </el-button-group>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup>
import {ref, onMounted } from "vue";
import {ElMessage} from "element-plus";
import router from '@/router';
import axios from 'axios';
import qs from 'qs';

const del = (i, c)=>{
  if(confirm("Delete it?")){
    axios.post('http://localhost:8080/v1/contents/'+c.id+'/delete').then((response)=>{
      if(response.data.code==2001){
        arr.value.splice(i,1);
        ElMessage.success("Deleted!");
      }
    })

  }
}

const arr = ref([]);
const type = ref('1');
const catTypeArr = ref([]);

onMounted(()=> {
  axios.get('http://localhost:8080/v1/categories/type').then((response) => {
    if (response.data.code == 2001) {
      catTypeArr.value = response.data.data;
    }
  })
  loadContents()
})
const loadContents = ()=>{

  let user = localStorage.user?JSON.parse(localStorage.user):null;
  let data = qs.stringify({userId:user.id,type:type.value});
  axios.get('http://localhost:8080/v1/contents/management?'+data).then((response)=>{
    if(response.data.code==2001){
      arr.value = response.data.data;
    }
  })

}
</script>