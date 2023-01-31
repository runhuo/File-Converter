<template>
  <section>
    <a @click="move"><img src="../assets/icon/convert-bg.png" alt="bg" id="bg"></a>
<!--    <i id="location"></i>-->
  </section>
</template>

<script>
export default {
  name: "BG",
  methods:{
    move(){
      window.scrollTo({
        top:document.getElementById("bg").scrollHeight,
        behavior:'smooth'
      })
    }
  }
}
</script>

<style scoped>
section {
  width: 100%;
  min-width: 1170px;
}

section img {
  width: 100%;
}
/*#location {*/
/*  position: absolute;*/
/*  top: 105%;*/
/*}*/
</style>