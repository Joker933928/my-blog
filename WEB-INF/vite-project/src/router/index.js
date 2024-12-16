import { createRouter,createWebHistory } from 'vue-router'
import Login from '@/components/Login.vue'
import Home from '@/components/Home.vue'

const router = createRouter({
    history:createWebHistory(), // 路由器的工作模式
    routes:[
        {
            path:'/login',
            name:'Login',
            component: Login
        },
        {
            path:'/home',
            name:'Home',
            component: Home
        }
    ]
})

// 暴露出去router
export default router