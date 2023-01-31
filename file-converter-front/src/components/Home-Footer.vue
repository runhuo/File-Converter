<template>
  <footer id="footer">
    <div class="container">
      <div class="foot-left">
        <ul class="foot-subnav">
          <li title="请点击右方CSDN或者Github">关于我们</li>
          <li title="QQ:1984045322">联系方式</li>
        </ul>
        <a href="https://beian.miit.gov.cn/#/Integrated/index">粤ICP备2022020485号</a>
      </div>
      <div class="foot-right">
        <ul class="social-link">
          <li title="CSDN"><a href="https://blog.csdn.net/m0_73845616"><i class="csdn foot-icon"></i></a></li>
          <li title="Github"><a href="https://github.com/runhuo1"><i class="github foot-icon"></i></a></li>
          <li title="Gitee"><a href="https://gitee.com/runhuo"><i class="gitee foot-icon"></i></a></li>
        </ul>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: "Home-Footer"
}
</script>

<style scoped>
#footer {
  height: 80px;
  background: #ffffff;
}

.container {
  width: 1000px;
  margin: 0 auto;
}

.foot-left {
  float: left;
  margin-left: 50px;
  vertical-align: top;

}
.foot-left a{
  text-decoration: none;
  color: #000000;
  margin-left:55px;
}

.foot-right {
  float: right;
  margin-right: 50px;
  vertical-align: top;

}
.foot-subnav{
 margin-bottom: 5px;
}
.foot-subnav li {

  display: inline-block;
  width: 100px;
  text-align: center;
  font-family: "Microsoft YaHei UI", serif;
}
.foot-subnav li{
  cursor: pointer;
}
.social-link li {
  display: inline-block;
  width: 50px;
}

.foot-subnav li:hover,.foot-left a:hover{
  color: #007bff;
}

.foot-icon {
  display: block;
  width: 25px;
  height: 25px;
}

.csdn {
  content: url("../assets/icon/csdn.png");
}

.github {
  content: url("../assets/icon/github.png");
}

.gitee {
  content: url("../assets/icon/gitee.png");
}
</style>