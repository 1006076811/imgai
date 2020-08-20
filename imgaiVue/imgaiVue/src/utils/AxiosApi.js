import Vue from 'vue'
import axios from 'axios'
import {Message} from "element-ui";

Vue.prototype.axios = axios

axios.interceptors.response.use(respSuccess=>{//响应拦截器，成功的话做的事儿
  //这几个判断条件，前两个是拦截器的响应成功，后两个是后端传过来的数据的状态
  if(respSuccess.status && respSuccess.status==200 && respSuccess.data.status!=200 && respSuccess.data.status!=null){
    Message.error({message: respSuccess.data.msg});
    return;
  }
  if(respSuccess.data.msg){ //能走到这，后端传过来的数据必然是200
    Message.success({message: respSuccess.data.msg});
    return respSuccess.data;
  }
  return respSuccess.data;
},error=>{//错误的话做的事儿
  if(error.response.status== 504 || error.response.status == 404){
    Message.error({message: "页面不小心走失了( ╯□╰ )"})
  }else if(error.response.status == 403){
    Message.error({message: "您暂无权限访问此页面哦"})
  }else if(error.response.status == 401){
    if(error.response.data.msg){
      Message.error({message: error.response.data.msg})
    }else {
      Message.error({message: "尚未登录，请登录"})
    }
    //router重定向
  }else {
    if(error.response.data.msg){
      Message.error({message: error.response.data.msg})
    }else {
      Message.error({message: "未知错误"})
    }
  }
  return;
})

//post异步请求
export const postRequest = (url, params) => {
  return axios({
    method: "post",
    url: `${url}`,//具体为什么我也不知道，可能是空串拼接有什么问题， 就像java里 String = int类型+"" ??
    data: params
  })
}

//get异步请求
export const getRequest = (url,params) => {
  return axios({
    method: "get",
    url: `${url}`,//具体为什么我也不知道，可能是空串拼接有什么问题， 就像java里 String = int类型+"" ??
    data: params
  })
}
//put异步请求
export const putRequest = (url,params) => {
  return axios({
    method: "put",
    url: `${url}`,//具体为什么我也不知道，可能是空串拼接有什么问题， 就像java里 String = int类型+"" ??
    data: params
  })
}
//delete异步请求
export const deleteRequest = (url,params) => {
  return axios({
    method: "delete",
    url: `${url}`,//具体为什么我也不知道，可能是空串拼接有什么问题， 就像java里 String = int类型+"" ??
    data: params
  })
}
