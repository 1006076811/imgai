import Vue from 'vue'
import VueRouter from 'vue-router'
//引入组件
import Home from '../views/Home.vue';
import Login from '../views/Login.vue';
import Register from '../views/Register.vue';


Vue.use(VueRouter)

const routes = [
  {
    path:"/",
    redirect:"/index"
  },
  {
    path: "/index",
    component: Home
  },
  {
    path:"/login",
    component:Login
  },
  {
    path:"/register",
    component:Register
  }
]

const router = new VueRouter({
  routes
})

// //出现问题时使用
// const originalPush = VueRouter.prototype.push
// VueRouter.prototype.push=function push(location,onResolve,onReject){
//   if (onResolve || onReject) return originalPush.call(this,location,onResolve,onReject)
//   return originalPush.call(this,location).catch(err => err)
// }
//
//
// // 挂载路由导航守卫
// router.beforeEach((to,from,next)=>{
//   // to 将要访问
//   // from 从哪访问
//   // next 接着干 next(url) 从定向到url上 next() 继续访问to路径
//   if (to.path=='/login') return next();
//   //获取user
//   const userFlag = window.sessionStorage.getItem("user");
//   if (!userFlag) return next('/login');
//   next();
//
// })

export default router
