import {createApp} from 'vue'
import App from './App.vue'
import router from './router/index'
import ElementUI from "element-plus";
import 'element-plus/theme-chalk/index.css'
import {ElMessage} from 'element-plus'
import request from "@/utils/request";

const vue = createApp(App);
vue.use(ElementUI)
vue.config.globalProperties.$message = ElMessage
vue.config.globalProperties.$http = request
vue.use(router).mount('#app')
