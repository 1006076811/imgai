import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui';
import router from './router'
import store from './store';
import axios from 'axios';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/font/iconfont.css'





// 挂载axios
Vue.prototype.$http = axios
Vue.use(ElementUI);
Vue.use(store);

//axios的工具方法，之后用异步请求，直接用 this.xxx即可
import {postRequest} from './utils/AxiosApi';
import {getRequest} from "./utils/AxiosApi";
import {putRequest} from "./utils/AxiosApi";
import {deleteRequest} from "./utils/AxiosApi";

Vue.prototype.postRequest = postRequest;
Vue.prototype.getRequest = getRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.deleteRequest = deleteRequest;
// 设置访问根路径
axios.defaults.baseURL = "http://localhost:8081"



Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
