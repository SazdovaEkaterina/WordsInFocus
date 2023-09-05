<template>
  <div>
    <HeaderComponent />
    <router-view v-slot="{ Component }">
      <keep-alive :max="5">
        <component :is="Component" :key="$route.fullPath" />
      </keep-alive>
    </router-view>
    <!-- <LettersComponent/> -->
    <FooterComponent />
  </div>
</template>

<script>

import FooterComponent from "@/components/FooterComponent";
import HeaderComponent from "@/components/HeaderComponent";
import LettersComponent from "@/components/LettersComponent.vue"



export default {
  name: 'App',
  components: {
    HeaderComponent,
    FooterComponent,
    LettersComponent,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
  height: 96vh;
  
}

html{
   background-color: #d2bd91; 

}

</style>
