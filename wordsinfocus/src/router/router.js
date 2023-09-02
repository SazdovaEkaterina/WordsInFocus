import { createRouter, createWebHistory } from 'vue-router'

const routes = [
    {
        path: "/:pathMatch(.*)*",
        name: "Page Not Found",
        component: () => import("../components/PageNotFoundComponent.vue"),
    },
    {
      path: "/",
      name: "Letters",
      component: () => import("../components/LettersComponent.vue"),
    
    },{
      path: "/letter/:l",
      name: "Letter",
      component: () => import("../components/LetterWithWordsComponent.vue"),
      props: true,
    }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router