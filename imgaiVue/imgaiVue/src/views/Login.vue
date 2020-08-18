<template>
  <div>
    <div class="background"></div>
   <div class="div1">
        <el-row class="l_row">
          <label>登录</label>
        </el-row>
        <el-form ref="loginFormRef" :rules="loginRules" :model="LoginForm" class="login_form" label-width="0">
          <!--用户名-->
          <el-form-item prop="username">
            <el-input v-model="LoginForm.username"></el-input>
          </el-form-item>
          <!--密码-->
          <el-form-item prop="password">
            <el-input v-model="LoginForm.password"  type="password"></el-input>
          </el-form-item>
          <!--验证码-->
          <el-form-item prop="code">
            <el-input v-model="LoginForm.code"></el-input>
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
        //表单数据
        LoginForm:{
          username:"admin",
          password:"123456",
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
  .div1{
    height: 400px;
    width: 25%;
    margin-left:65%;
    margin-top: 10%;
    background-color: #fcfcfc;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
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
