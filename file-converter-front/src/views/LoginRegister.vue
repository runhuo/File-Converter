<template>
  <main>
    <div class="login-container">
      <div class="login-module" v-show="isLogin">
        <p>登录</p>
        <div class="login-item">
          <input type="text" v-model="account" placeholder="请输入账号" class="account login-input">
          <input type="password" v-model="password" placeholder="请输入密码" class="password login-input">
          <div class="image-captcha">
            <input type="text" placeholder="验证码" class="captcha-input" v-model="captcha">
            <img :src="image" alt="验证码" @click="getImageCaptcha" style="cursor: pointer;">
          </div>
          <input type="button" value="登录" class="login-btn" @click="login">
          <div class="login-other">
            <a class="change-password" href="">忘记密码？</a>
            <a class="register-link" @click="changeStatus">没有账号，去注册！</a>
          </div>
          <a class="homePage" @click="toHomePage">首页</a>
        </div>
      </div>
      <div class="register-module" v-show="!isLogin">
        <p>注册</p>
        <div class="login-item">
          <input type="text" placeholder="请输入手机号码" class="account login-input" v-model="account1">
          <input type="password" placeholder="密码，由数字和字母组成且长度8-16" class="password login-input"
                 v-model="password1">
          <input type="password" placeholder="请输入确认密码" v-model="password2"
                 class="confirm-password login-input">
          <div class="captcha-module">
            <input type="text" v-model="captcha1" placeholder="验证码" class="captcha">
            <input type="button" :disabled="!isClick" v-model="captcha_btn" class="captcha-btn" @click="getSmsCaptcha">
          </div>
          <input type="button" value="注册" class="login-btn" @click="register">

          <div class="login-other">
            <a class="register-link" @click="changeStatus">已有账号，去登录！</a>
          </div>
          <a class="homePage" @click="toHomePage">首页</a>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: "LoginRegister",
  data() {
    return {
      isLogin: true,
      image: '',
      text: '',
      //登录模块，分开实现避免出现bug
      account: '',
      password: '',
      captcha: '',
      //注册模块
      account1: '',
      password1: '',
      password2: '',
      captcha1: '',
      //验证码按钮计时
      captcha_btn: '验证码',
      time: 61,
      isClick:true
    }
  },
  mounted() {
    this.getImageCaptcha();
  },
  methods: {
    changeStatus() {
      this.isLogin = !this.isLogin;
    },
    toHomePage() {
      this.$router.push("/");
    },
    getImageCaptcha() {
      this.$http.get("/captcha/image").then(res => {
        this.image = res.data.data.image;
        this.text = res.data.data.text;
      })
    },
    getSmsCaptcha() {
      if (this.account1 === '' || this.account1.length !== 11) {
        this.$message.error("请输入正确的手机号码！");
      } else {
        if (this.time > 0) {
          this.time--;
          this.captcha_btn = this.time + "s";
          this.isClick=false;
          setTimeout(this.getSmsCaptcha, 1000);
        } else {
          this.time = 61;
          this.captcha_btn = '验证码';
          this.isClick=true;
        }
      }
    },
    login() {
      if (this.text !== this.captcha) {
        this.$message.error("验证码错误，请注意大小写！")
      } else if (this.account === '' || this.password === '') {
        this.$message.error("请账号或密码！")
      } else {
        this.$http.post("/user/login/"+this.account+"/"+this.password).then(res => {
          if (res.data.code === 200) {
            this.$message.success("登录成功");
            //将token存到local storage
            window.localStorage.setItem("user_token", res.data.data);
            //自动切换到主页
            setTimeout(function () {
              this.$router.push("/");
            }, 1500)
          } else {
            this.$message.error(res.data.data);
          }
        })
      }
    },
    register() {
      var re = /^[0-9a-zA-Z]*$/;
      if (this.account1 === '' || this.account1.length !== 11) {
        this.$message.error("请输入正确的手机号码！");
      } else if (!re.test(this.password1) || this.password1.length < 8 || this.password1.length > 16) {
        this.$message.error("密码不符合规范！");
      } else if (this.password1.length === 0 || this.password2.length === 0) {
        this.$message.error("请输入密码或确认密码！");
      } else if (this.password1 !== this.password2) {
        this.$message.error("密码与确认密码不一致！");
      } else if (this.captcha1.length !== 4) {
        this.$message.error("验证码长度错误！");
      }else {
        this.$http.post("/user/register/"+this.account1+"/"+this.password1+"/"+this.captcha1).then(res=>{
          console.log(res);
        })
      }
    }
  }
}
</script>

<style scoped>
main {
  width: 100vw;
  height: 100vh;
  min-height: 650px;
  background: url("../assets/icon/login-bg.png") repeat;
  background-size: cover;
  min-width: 1170px;
}

input {
  border-radius: 5px;
}

.login-module, .register-module {
  float: right;
  margin-top: 12%;
  margin-right: 15vw;
  width: 400px;
  background: rgba(255, 255, 255, 0.8);
  border-radius: 5px;
}

.login-module p, .register-module p {
  font-family: "Microsoft YaHei UI", serif;
  font-size: 35px;
  margin: 0;
  letter-spacing: 3px;
  font-weight: 600;
  color: #666666;
  text-align: center;
  padding-bottom: 20px;
  padding-top: 30px;
  border-bottom: solid 1px #dddddd;

}

.login-item {
  width: 400px;
  padding: 20px 0;
}

.login-input {
  width: 300px;
  height: 25px;
  margin: 15px 45px;
  outline: none;
  border: solid 2px #dddddd;
  font-family: "Microsoft YaHei UI", serif;
  font-size: 16px;
}

.captcha-input {
  width: 150px;
  height: 25px;
  margin-top: 15px;
  margin-bottom: 15px;
  margin-left: 45px;
  vertical-align: middle;
  outline: none;
  border: solid 2px #dddddd;
  font-family: "Microsoft YaHei UI", serif;
  font-size: 16px;
}

.image-captcha img {
  vertical-align: middle;
  width: 120px;
  height: 40px;
  margin-left: 20px;
}

.login-btn {
  width: 300px;
  height: 32px;
  margin: 15px 47px;
  background: #007bff;
  border: solid 1px #007bff;
  color: #ffffff;
  letter-spacing: 1px;
  border-radius: 5px;
}

.login-btn:hover {
  background: #58A7FA;
  border: solid 1px #58A7FA;
  cursor: pointer;
}

.login-other {
  width: 300px;
  margin: 20px auto;
  padding-bottom: 20px;
}

.change-password {
  float: left;
  text-decoration: none;
  color: #58A7FA;
}

.register-link {
  float: right;
  text-decoration: none;
  color: #58A7FA;
}

.captcha-module {
  width: 310px;
  margin: 20px auto;
}

.captcha {
  width: 150px;
  height: 25px;
  outline: none;
  border: solid 2px #dddddd;
  font-family: "Microsoft YaHei UI", serif;
  font-size: 16px;
  vertical-align: middle;
  margin-right: 20px;
}

.captcha-btn {
  width: 125px;
  height: 31px;
  background: #007bff;
  border: solid 1px #007bff;
  color: #ffffff;
  border-radius: 3px;
}

.captcha-btn:hover {
  background: #58A7FA;
  border: solid 1px #58A7FA;
  cursor: pointer;
}

.login-other a:hover {
  cursor: pointer;
}

.homePage {
  display: block;
  width: 50px;
  color: #007bff;
  margin: 0 auto;
}

.homePage:hover {
  cursor: pointer;
  color: #58A7FA;
}
</style>