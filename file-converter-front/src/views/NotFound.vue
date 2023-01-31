<template>
<div id="not-found">
  <img src="../assets/icon/404.png" alt="404">
  <div>
    <p>{{time+1}}秒后自动跳转到主页</p>
    <a @click="go_back">[root@runhuo /404]$ cd /</a>
  </div>
</div>
</template>

<script>
export default {
  name: "NotFound",
  data(){
    return{
      time:5
    }
  },
  mounted() {
    this.redirect();
  },
  methods:{
    redirect(){
      if (this.time>0){
        this.time--;
        setTimeout(this.redirect,1000);
      }
      else {
        this.$router.push("/");
      }
    },
    go_back(){
      this.$router.push("/");
    }
  }
}
</script>

<style scoped>
#not-found{
  width: 600px;
  margin: 50px auto;
}
#not-found p{
  padding-top: 60px;
  text-align: center;
  font-family: "Microsoft YaHei UI", serif;
  font-size: 20px;
  color: #666666;
}
#not-found a{
  display: block;
  width: 230px;
  margin: 80px auto;
  font-family: "Microsoft YaHei UI", serif;
  font-size: 17px;
  font-weight: 600;
}
#not-found a:hover{
  cursor: pointer;
}
</style>