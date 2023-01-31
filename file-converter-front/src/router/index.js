import {createRouter, createWebHistory} from "vue-router";

const routes = [
    //主页
    {
        name: 'home',
        path: '',
        component: () => import("@/views/HomePage")
    },
    //登录页面
    {
        name: 'login-register',
        path: '/login-register',
        component: () => import("@/views/LoginRegister")
    },
    {
        name: 'file-Converter',
        path: '/file-Converter/:type/',
        component: () => import("@/views/Converter")

    },

    {
        name: '404',
        path: '/404',
        component: () => import("@/views/NotFound")
    },
    {
        path: '/:pathMatch(.*)',
        redirect: '/404',
        name: 'not found',
        hidden: true
    }
]
const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router