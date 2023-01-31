<template>
  <HomeHeader></HomeHeader>
  <HomeBG></HomeBG>
  <HomeMain></HomeMain>
  <HomeFooter></HomeFooter>

</template>

<script>
import HomeHeader from "@/components/Home-Header";
import HomeFooter from "@/components/Home-Footer";
import HomeMain from "@/components/Home-Main";
import HomeBG from "@/components/Home-BG";

export default {
  name: "HomePage",
  components: {
    HomeHeader,
    HomeFooter,
    HomeMain,
    HomeBG
  }
}
</script>

<style scoped>

</style>