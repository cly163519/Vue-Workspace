<!--Post Page-->
<template>
  <h1 style="color:orange;">{{ content.id == null?'Post Content Page':'Change Content Page' }}</h1>
  <el-form label-width="100px">
    <el-form-item label="article title">
      <el-input placeholder="Please enter the article title" v-model="content.title"></el-input>
    </el-form-item>
    <el-form-item label="article type">
      <!--@change="" Triggered when options change-->
      <!-- :disabled = "content.id!=null" id is not empty, which means that changing the article type is disabled during modification.  -->
      <el-radio-group :disabled="content.id!=null" @change="typeChange()" v-model="content.type">
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
      <!-- Note: The id value is only available when modifying. You need to display the cover image using v-if=“content.id!=null”.
            Newly published articles do not have values (id, cover image, etc.).
            &&fileList.length==0 Ensure that there is only one cover image.  -->
      <img v-if="content.id!=null&&fileList.length==0"
           :src="'http://localhost:8080'+content.imgUrl"
           style="width:145px;height:145px;margiin-right:10px;"
      >
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
    <!--Displayed only when modified
     videoList.length==0 -The original one is not displayed, only the newly modified one is displayed. Only one can be displayed at a time.-->
      <video v-if="content.id!=null&&videoList.length==0"
             :src="'http://localhost:8080'+content.videoUrl"
              style="width:300px;margin-right:10px;" type="video/mp4" controls></video>
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
    <!--v-show="content.type!=2" It only shows if it's not a video, it's a video that doesn't require an article to be uploaded -->
    <el-form-item label="Article content" v-show="content.type!=2">
    <!-- 4. In this div using a third-party rich text editor, ref=“editorDiv” lets the editorDiv variable point to this current div, that is, associating this div with the downloaded responsive variable editorDiv-->
      <div ref="editorDiv"></div>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="post()">{{ content.id==null?'Post Content':'Modify Content' }}</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup>
import {onMounted, ref} from 'vue';
import {Plus} from '@element-plus/icons-vue';
//1.Install the rich text editor, command: npm install wangeditor
//2.import rich text editor
import Editor from 'wangeditor';
import axios from "axios";
import {ElMessage} from "element-plus";
import qs from "qs";
import router from "@/router";

const catTypeArr = ref([]);
const catgoryArr = ref([]);
//Define variables to hold the title and type of the article, type 1 defaults to the baking recipe type
//Append a categoryId:'' attribute to the content object, default value is null
const content = ref({title:'',type:'1',categoryId:''})
//When the selected article type is changed, send a request to get the secondary category data corresponding to this type.
const typeChange = ()=>{
  //Prevent the original title from being carried over when switching sections.
  content.value.categoryId='';
  //Send a request to obtain data from the second-level classification.
  axios.get('http://localhost:8080/v1/categories/'+content.value.type+'/sub').then((response)=>{
    if(response.data.code==2001){
      catgoryArr.value = response.data.data;
    }
  })
}

onMounted(()=>{
  //The location contains information about the current URL
  //When a request parameter is passed in the url as get, the search attribute of the location can be used to advance the value of the parameter to ? and the following parameters
  if(location.search.includes('id')){
    let id = new URLSearchParams(location.search).get('id');//get()Get the first value of the specified search parameter
    axios.get('http://localhost:8080/v1/contents'+id+'/update').then((response)=>{
      if(response.data.code==2001){
        console.log(response.data.data)
        //Load the queried details of the specified id into the content to be displayed
        content.value = response.data.data;
        //Let the rich text editor display the article content
        editor.txt.html(content.value.content);
        //Send a request for secondary categorized data
        //Second-level categories cannot be displayed normally.
        //Reason: There are no other types of second-level categories in the current type 1.
        //Solution: Request the second-level categories corresponding to the current content object type again.
        //Copy the code for requesting second-level category data from the typeChange() method to this location.
        axios.get('http://localhost:8080/v1/categories/1/sub').then((response)=>{
          if(response.data.code == 2001){
            catgoryArr.value = response.data.data;
          }
        })
        //console.log(response.data.data)
        //Load the queried details of the specified id into the content to be displayed
        //content.value = response.data.data;
      }
    })
  }

  axios.get('http://localhost:8080/v1/categories/type').then((response)=>{
    if(response.data.code == 2001){
      catTypeArr.value = response.data.data;
    }
  })
})

const fileList = ref([])
const dialogImageUrl = ref('')
const dialogVisible = ref(false)
//The image deletion method
const handleRemove = (uploadFile, uploadFiles)=>{
  //Get the url of the picture
  let imgUrl = uploadFile.response.data;
  //Sent a request to delete a file
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

//3. Create a responsive variable editorDiv, which points to a div in the page (the div is used here to hold the rich text editor component), and bind the value of the variable to the div.
const editorDiv = ref(null);
//5. Create variables that are then used to save the created rich text editor object.
let editor = null;
//6. onMounted() is a VUE lifecycle method (a method that is automatically called when a VUE instance is created and destroyed).
//Mounted means that the VUE instance needs to be mounted with the elements in the page when the page is built and initialized.
onMounted(()=>{//
  // The rich text editor here must be initialized after mounting; only after mounting can editorDiv be correctly linked to the div above
  //7.Initialize the rich text editor (needs to be mounted to the div above)
  editor = new Editor(editorDiv.value);
  //8.Configure the placeholder text in the rich text edito
  editor.config.placeholder = "Please enter the content";
  //9.Create the rich text editor based on the configuration above
  editor.create();
})
//Define the video list array
const videoList = ref([]);
//Complete the post function
const post = ()=> {
  //Must ensure the user is logged in before posting
  let user = localStorage.user ? JSON.parse(localStorage.user) : null;
  if (user == null) {
    ElMessage.error('Please login')
    router.push('/login')
    return;
  }
  //Save user id into content
  content.value.userId = user.id;
  //Before posting, process the content to ensure it's not empty
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
  //Put the path of the successfully uploaded image into the content object.
  let imgUrl = fileList.value[0].response.data;
  content.value.imgUrl = imgUrl;
  //Determine whether to publish or modify. Publishing requires selecting a cover, while modifying can use the old cover.
  if(content.value.id==null){//Publish
    //No image uploaded at the time of publication
    if(fileList.value.length==0){ElMessage.error('Please select the cover!');return;}
    let imgUrl = fileList.value[0].response.data;
    content.value.imgUrl = imgUrl;
  }else{//Modify
    //When editing, if no image was uploaded, use the old image. If an image was uploaded, place the uploaded image in the content.
    if(fileList.value.length>0){
      let imgUrl = fileList.value[0].response.data;
      content.value.imgUrl = imgUrl;
    }
  }
  //Determine if it's a video or an article
  if(content.value.type==2) {//Video
    //Determine whether to publish or modify. Publishing requires selecting a video, while modifying can use an old video.
    if (content.value.id == null) {
      if (videoList.value.length == 0) {
        ElMessage.error('Please select the video file');
      }
      let videoUrl = videoList.value[0].response.data;
      content.value.videoUrl = videoUrl;
    } else {
      if (videoList.value.length > 0) {
        let videoUrl = videoList.value[0].response.data;
        content.value.videoUrl = videoUrl;
      }
    }

  }else{
    //If it's an article or information, then set article content and summary
    //Get content from the rich text editor object. The two methods below are different:
  console.log('html=' + editor.txt.html());//html = <p>This is <i><b>test text</b></i></p> (includes formatting)
  console.log('text=' + editor.txt.text());//text = This is tested text (plain text without formatting)
    //Set article content
  content.value.content = editor.txt.html();
  //Set article summary – extract the first 30 characters from the plain text
  content.value.brief = editor.txt.text().slice(0, 30);
  //Use this for testing to see if the complete article data is captured
}

  //Send request
  let data = qs.stringify(content.value)
  axios.post('http://localhost:8080/v1/contents/add-new',data).then((response)=>{
    if(response.data.code==2001){
      ElMessage.success(content.value.id==null?"Published successfully":"Modified successfully!")
      //After publishing successfully, jump to the manuscript management page
      router.push('/personal/management');
    }
  })
}



</script>
