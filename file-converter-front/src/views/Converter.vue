<template>
  <HomeHeader></HomeHeader>
  <ConverterModule></ConverterModule>
  <Advertisement></Advertisement>
  <HomeFooter></HomeFooter>
</template>

<script>
import HomeHeader from "@/components/Home-Header";
import HomeFooter from "@/components/Home-Footer";
import ConverterModule from "@/components/Converter-Module";
import Advertisement from "@/components/Advertisement";
export default {
  name: "Converter",
  components: {
    HomeHeader,
    HomeFooter,
    ConverterModule,
    Advertisement
  }

}
</script>

<style scoped>

</style>