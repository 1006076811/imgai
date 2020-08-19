<template>
  <div>
    <div class="background">
      <img :src="imgSrc" width="100%" height="100%" alt="" />
    </div>
    <div class="div1">
      <div class="div2">
        <el-row class="l_row">
          <label>注册</label>
        </el-row>
        <el-form ref="loginFormRef" :rules="loginRules" :model="LoginForm" class="login_form" label-width="0">
          <!--用户名-->
          <el-form-item prop="username">
            <el-input v-model="LoginForm.username" prefix-icon="iconfont icon-ziyuanxhdpi" placeholder="请输入你的用户名"></el-input>
          </el-form-item>
          <!--密码-->
          <el-form-item prop="password">
            <el-input v-model="LoginForm.password"prefix-icon="iconfont icon-mima" placeholder="请输入你的密码"type="password"></el-input>
          </el-form-item>
          <!--邮箱-->
          <el-form-item prop="email">
            <el-input v-model="LoginForm.email" prefix-icon="iconfont icon-youxiang" placeholder="请输入你的邮箱"></el-input>
          </el-form-item>
          <!--手机-->
          <el-form-item prop="phone">
            <el-input v-model="LoginForm.phone" prefix-icon="iconfont icon-shoujihao" placeholder="请输入你的电话"></el-input>
          </el-form-item>
          <!--按钮-->
          <el-form-item class="btns">
            <el-button type="primary" @click="register()">注册</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
      data(){
        return{
          //引入背景图
          imgSrc:require('../assets/img/r_back.jpg'),
          //表单数据
          LoginForm:{
            username:"",
            password:"",
            email:"",
            phone:""
          },
          //验证对象
          loginRules:{
            //校验用户名
            username:[
              {required:true, message:'请输入用户名称', trigger: 'blur'},
              {min: 5, max: 12,message: '长度在5到12个字符', trigger: 'blur'}
            ],
            //校验密码
            password:[
              {required:true, message:'请输入用户密码', trigger: 'blur'},
              {min: 6, max: 10,message: '长度在6到10个字符', trigger: 'blur'}
            ],
          }
        }
      },
      methods:{
        register(){

        }
      }
    }
</script>

<style scoped>
  .div1{
    z-index:1;
    position: absolute;
    margin-top: 10%;
    margin-left: 20%;
    height: 600px;
    width: 60%;
    background-color: rgba(255, 255, 255,0.6);
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  }
  .div2{
    padding-left: 150px;
    height: 100%;
    width: 70%;
  }
  .l_row{
    padding-top: 50px;
    padding-bottom: 15px;
    padding-left: 45%;
    font-size: 24px;
  }
  .login_form{
    padding-top: 50px;
    padding-left: 20%;
    width: 85%;
    box-sizing: border-box;
  }
  .btns{
    padding-top: 30px;
    padding-left: 40%;
  }
  .background{
    width:100%;
    height:100%;  /**宽高100%是为了图片铺满屏幕 */
    z-index:-1;
    position: absolute;
  }

</style>
