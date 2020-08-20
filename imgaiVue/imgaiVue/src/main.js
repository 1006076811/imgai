import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui';
import router from './router'
import store from './store';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/font/iconfont.css'


Vue.config.productionTip = false


Vue.use(ElementUI);
Vue.use(store);
// 设置访问根路径
axios.defaults.baseURL = "http://localhost:8081"

import {postRequest} from './utils/AxiosApi';
import {getRequest} from "./utils/AxiosApi";
import {putRequest} from "./utils/AxiosApi";
import {deleteRequest} from "./utils/AxiosApi";
Vue.prototype.postRequest = postRequest;
Vue.prototype.getRequest = getRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.deleteRequest = deleteRequest;

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
