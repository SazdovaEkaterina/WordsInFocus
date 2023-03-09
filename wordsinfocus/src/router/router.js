import { createRouter, createWebHistory } from "vue-router";

const routes = [
    {
        path: "/letter" +
            "/:l(^[а-џ]{1}$)" +
            "/:firstWord(^[а-џ]{1,}$)" +
            "/:lastWord(^[а-џ]{1,}$)" +
            "#:word(^[а-џ]{1,}$" +
            "/:type(^[а-џ]{0,}.$)",
        name: "MainWordComponent",
        component: () => import("../components/MainWordComponent"),
    },
    {
        path: "/:pathMatch(.*)*",
        name: "Page Not Found",
        component: () => import("../components/PageNotFoundComponent.vue"),
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
    scrollBehavior: function (_to, _from, savedPosition) {
        return savedPosition ? savedPosition : window.scrollTo(0, 0);
    },
});

export default router;