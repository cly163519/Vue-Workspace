<!--Content Page-->
<template>
<el-table :data="arr">
  <el-table-column type="index" label="index" width="80" align="center"></el-table-column>
  <el-table-column prop="title" label="title" width="120" align="center"></el-table-column>
  <el-table-column label="cover" widty="140" align="center">
    <template #default="scope">
      <img :src="scope.row.imgUrl" style="width:100%;">
    </template>
  </el-table-column>
  <el-table-column prop="brief" label="brief" width="280" align="center"></el-table-column>
  <el-table-column prop="categoryName" label="category" width="80" align="center"></el-table-column>
  <el-table-column prop="viewCount" label="view"  width="60" align="center"></el-table-column>
  <el-table-column prop="commentCount" label="comment" width="60" align="center"></el-table-column>
  <el-table-column prop="createTime" label="createTime" width="120" align="center"></el-table-column>
  <el-table-column label="operation" align="center">
    <template #default="scope">
      <el-button type="success">Edit</el-button>
      <el-button type="danger" @click="del(scope.$index)">Delete</el-button>
    </template>
  </el-table-column>
</el-table>
</template>

<script setup>
import {ref} from "vue";
import {ElMessage} from "element-plus";

//3. Add a click-triggered function to the button
const del = (i)=>{
  if(confirm('Confirm deletion of this content?')){
    arr.value.splice(i,1);
    ElMessage.success('Deleted!')
  }
}
//1.Prepare Javascript Arr
const arr = ref([
  {
    "id":11,
    "title":"Shortbread",
    "brief":"Peanut butter + peanut oil = super rich peanut flavor. " +
        "No powdered sugar, white sugar is used. It is crispy in the mouth, " +
        "but there is a little graininess left after the crispness. Rich peanut flavor",
    "imgUrl":"/imgs/a.jpg",
    "type":1,
    "categoryName":"Homemade Dishes",
    "viewCount":8,
    "commentCount":0,
    "createTime":"2023/03/27 19:51:45"
  },
  {
    "id":12,
    "title":"Date paste fancy bread, delicious",
    "brief":"I made jujube paste stuffing before, and paired it with fancy bread, " +
        "it was delicious. Ingredients for jujube paste fancy bread Meat floss bread dough. " +
        "See the meat floss bread recipe, jujube paste",
    "imgUrl":"/imgs/b.jpg",
    "type":1,
    "categoryName":"Bread",
    "viewCount":1,
    "commentCount":0,
    "createTime":"2023/03/28 16:12:42"
  },
  {
    "id":13,
    "title":"Cheese roll",
    "brief":"The bacon that everyone loves is usually put in toast to make sandwiches. " +
        "Today, bacon is going to show up. Hahaha. Simple, quick, " +
        "crispy and delicious bacon toast cheese",
    "imgUrl":"/imgs/c.jpg",
    "type":1,
    "categoryName":"Homemade Dishes",
    "viewCount":1,
    "commentCount":0,
    "createTime":"2023/03/28 16:15:43"
  },
  {
    "id":14,
    "title":"Open sandwich, a quick and refreshing breakfast",
    "brief":" There was a terrible downpour last night, and the mint " +
        "on the desk shook its leaves slightly in the morning. " +
        "A small fresh and quick breakfast makes life simple but not simple. ",
    "imgUrl":"/imgs/d.jpg",
    "type":1,
    "categoryName":"Snacks",
    "viewCount":1,
    "commentCount":0,
    "createTime":"2023/03/28 16:16:24"

  },
  {
    "id":15,
    "title":"Walnut Raisin Soft Meatballs: Cranberry Seed Noodles",
    "brief":"Walnuts are a treasure, and there are too many benefits " +
        "to list one by one! Ingredients for cranberry dough: main dough, cranberry",
    "imgUrl":"/imgs/a.jpg",
    "type":1,
    "categoryName":"Bread",
    "viewCount":2,
    "commentCount":0,
    "createTime":"2023/03/28 16:16:56"

  },
  {
    "id":16,
    "title":"Cranberry mung bean cake, tastes good and worth a try!",
    "brief":"My whole family loves to eat mung bean cakes, " +
        "but the mung bean cakes in the dessert shop downstairs are too sweet, " +
        "so I decided to make them myself. I have tried to make mung bean cakes " +
        "with the skin on before, but the color didn’t come out right.",
    "imgUrl":"/imgs/b.jpg",
    "type":1,
    "categoryName":"Bread",
    "viewCount":4,
    "commentCount":0,
    "createTime":"2023/03/28 16:17:35"

  },
  {
    "id":17,
    "title":"Heart-shaped dragon fruit and coconut bread, no one can resist it",
    "brief":"No one can resist the aroma of coconut flakes. " +
        "I happened to have half a red dragon fruit left, " +
        "so I made it into a very tender little heart-shaped bread. " +
        "It is cute and delicious, and you can make 9 of them. ",
    "imgUrl":"/imgs/c.jpg",
    "type":1,
    "categoryName":"Snacks",
    "viewCount":15,
    "commentCount":1,
    "createTime":"2023/03/28 16:18:12"

  },
  {
    "id":18,
    "title":"Exploding Matcha Donut Bread, a Sweet Treat That Brings a Sense of Happiness",
    "brief":"The bursting matcha donut bread is delicious. " +
        "The bursting matcha donut is wrapped in matcha from the inside out. " +
        "It is a sweet little dessert with a sense of happiness. " +
        "Matcha lovers will definitely love it.",
    "imgUrl":"/imgs/d.jpg",
    "type":1,
    "categoryName":"Homemade Dishes",
    "viewCount":15,
    "commentCount":1,
    "createTime":"2023/03/28 16:20:26"

  },

]);

</script>
