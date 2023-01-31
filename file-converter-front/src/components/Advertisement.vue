<template>
  <section>
  <div class="advert">
    <div class="advert-items">
      <p class="advert-items-title">免费</p>
      <p class="advert-describe">本网站所有功能都免费，不收取任何费用。免费帮你将PFD文件转换成Word、Excel、PPT等格式的文件。</p>
    </div>
    <div class="advert-items">
      <p class="advert-items-title">简便</p>
      <p class="advert-describe">一键完成文件格式之间的转换，无须多余的操作，能让你更快的入门，为您提供工作或者学习上的便利。</p>
    </div>
    <div class="advert-items">
      <p class="advert-items-title">快速</p>
      <p class="advert-describe">快速实现在线将PDF文件转成您想要的文档格式，无需下载安装任何程序或者插件，让您随时随地都可以使用。</p>
    </div>
    <div class="advert-items">
      <p class="advert-items-title">多平台</p>
      <p class="advert-describe">支持Windows、MasOS、Linux等多平台，只要您拥有浏览器，即可使用该转换器，为您提供便利。</p>
    </div>
  </div>
  </section>
</template>

<script>
export default {
  name: "Advertisement"
}
</script>

<style scoped>
section{
  min-width: 1170px;
  background: #ffffff;
  height: 520px;
  border-bottom: solid 1px #aeaeae;
}
.advert{
  width: 1050px;
  margin: 0 auto;
}
.advert-items{
  display: inline-block;
  width: 420px;
  height: 200px;
  margin: 30px 50px;
  vertical-align: top;
}

.advert-items-title{
  font-size: 30px;
  text-align: center;
  font-family: "Microsoft YaHei UI", serif;
  font-weight: 600;
  color: #333333;
}
.advert-describe{
  width: 380px;
  margin: 20px auto;
  text-align: center;
  font-family: "Microsoft YaHei UI", serif;
  color: #666666;
}
</style>