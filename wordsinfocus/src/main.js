import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router'
// import { BootstrapVue } from 'bootstrap-vue'
// import 'bootstrap/dist/css/bootstrap.css'
// import 'bootstrap-vue/dist/bootstrap-vue.css'
import { configureCompat } from 'vue'


createApp(App)
  .use(router)
  .mount('#app')

  configureCompat({
    MODE: 3,
    FEATURE_ID_A: false,
    FEATURE_ID_B: false
  })