import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui';
import router from './router'
import store from './store';
import axios from 'axios';
import 'element-ui/lib/theme-chalk/index.css';




// 挂载axios
Vue.prototype.$http = axios
Vue.use(ElementUI);
Vue.use(store);
// 设置访问根路径
axios.defaults.baseURL = "http://localhost:8081"



Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
