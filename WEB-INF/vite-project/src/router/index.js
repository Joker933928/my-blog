import { createRouter,createWebHistory } from 'vue-router'
import Login from '@/components/Login.vue'
import FindPassword from '@/components/FindPassword.vue'
import Register from '@/components/Register.vue'

const router = createRouter({
    history:createWebHistory(), // 路由器的工作模式
    routes:[
        {
            path:'/login',
            name:'Login',
            component: Login
        },
        {
            path:'/register',
            name:'Register',
            component: Register
        },
        {
            path:'/password',
            name:'FindPassword',
            component: FindPassword
        },
    ]
})

// 暴露出去router
export default router