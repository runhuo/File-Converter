<template>
 <nav>
   <div id="head-container">
      <div class="head-left">
        <span class="web-title">文件转换器</span>
        <a class="blog" href="https://blog.csdn.net/m0_73845616?spm=1018.2226.3001.5343">技术博客</a>
      </div>
     <div class="head-right">
        <a @click="loginAndRegister">登录/注册</a>
     </div>
   </div>
 </nav>
</template>

<script>
export default {
  name: "Home-Header",
  methods:{
    loginAndRegister(){
      this.$router.push("/login-register");
    }
  }
}
</script>

<style scoped>
nav{
  height: 80px;
  background: rgba(255,255,255,0.5);
  position: absolute;
  width: 100%;
  min-width: 1170px;
}

#head-container{
  width: 80vw;

  margin: 0 auto;
  min-width: 1170px;
}
.head-left{
  float: left;
  margin-top: 20px;
}
.web-title{
  font-family: "Microsoft YaHei UI", serif;
  font-size: 30px;
  color: #666666;
}
/*添加logo*/
/*.web-title:before{*/
/*  content: url("../assets/logo.png");*/
/*  width: 30px;*/
/*}*/
.blog{
  margin-left: 30px;
  text-decoration: none;
  color: #000000;
}
.blog:hover{
  color: #007bff;
}

.head-right{
  float: right;
  margin-top: 30px;
}

.head-right a{
  text-decoration: none;
  color: #000000;
}
.head-right a:hover{
  color: #007bff;
  cursor: pointer;
}
</style>