<template>
  <div>
    <div class="background">
      <img :src="imgSrc" width="100%" height="100%" alt="" />
    </div>
   <div class="div1">
        <el-row class="l_row">
          <label>登录</label>
        </el-row>
        <el-form ref="loginFormRef" :rules="loginRules" :model="LoginForm" class="login_form" label-width="0">
          <!--用户名-->
          <el-form-item prop="username">
            <el-input v-model="LoginForm.username" prefix-icon="iconfont icon-ziyuanxhdpi" placeholder="请输入你的用户名"></el-input>
          </el-form-item>
          <!--密码-->
          <el-form-item prop="password">
            <el-input v-model="LoginForm.password" prefix-icon="iconfont icon-mima" placeholder="请输入你的密码"  type="password"></el-input>
          </el-form-item>
          <!--验证码-->
          <el-form-item prop="code">
            <el-input v-model="LoginForm.code" prefix-icon="iconfont icon-yanzhengma" placeholder="请输入验证码"></el-input>
          </el-form-item>
          <!--按钮-->
          <el-form-item class="btns">
            <el-button type="info" @click="toregister()">注册</el-button>
            <el-button type="primary" @click="login()" >登录</el-button>
          </el-form-item>
        </el-form>
      </div>
  </div>


</template>

<script>
  export default {
    data(){
      return{
        //引入背景图
        imgSrc:require('../assets/img/l_back.jpg'),
        //表单数据
        LoginForm:{
          username:"",
          password:"",
          code:""
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
          //校验验证码
          code:[
            {required:true, message:'请输入验证码', trigger: 'blur'},
            {min: 4, max: 4,message: '长度在4', trigger: 'blur'}
          ],
        },
      }
    },
    methods:{
      login(){

      },
      toregister(){
        this.$router.push({path:"/register"});
      }
    }
  }
</script>

<style scoped>
  .background{
    width:100%;
    height:100%;  /**宽高100%是为了图片铺满屏幕 */
    z-index:-1;
    position: absolute;
  }
  .div1{
    z-index:1;
    position: absolute;
    height: 400px;
    width: 25%;
    margin-left:65%;
    margin-top: 10%;
    background-color: rgba(255, 255, 255, 0.3);
    box-shadow: 0 2px 12px 0 rgba(238, 231, 231, 0.09);
  }
  .l_row{
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 40%;
    font-size: 24px;
  }
  .login_form{
    padding-top: 20px;
    padding-left:50px;
    width: 90%;
    box-sizing: border-box;
  }
  .btns{
    padding-top: 30px;
  }
</style>
