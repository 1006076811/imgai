<template>
    <el-row>
      <el-button type="primary" @click="tologin()" >登录</el-button>
      <el-button type="info" @click="toregister()">注册</el-button>
    </el-row>
</template>

<script>
    export default {
      methods:{
        tologin(){
          this.$router.push({path:"/login"});
        },
        toregister(){
          this.$router.push({path:"/register"});
        }
      }
    }
</script>

<style scoped>
</style>
