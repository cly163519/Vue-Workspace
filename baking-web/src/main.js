/*
整体流程：
1、导入工具
2、创建应用
3、注册组件
4、配置应用
5、渲染页面

 */
//导入工具
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

//创建应用
const app = createApp(App)

//注册组件
for (const[key, component] of Object.entries(ElementPlusIconsVue)){
    app.component(key, component)
}
//配置应用
//渲染页面
app.use(ElementPlus).use(store).use(router).mount('#app')
