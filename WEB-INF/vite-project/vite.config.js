import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import {resolve} from 'path'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': resolve(__dirname,'src'), //配置路径别名
    },
  },
  server: {
    host: 'localhost',
    port: 8082,
    https:false,
    proxy: {
      '/api': {
        target: 'http://localhost:8081/',
        changeOrigin:true,
        rewrite: path => path.replace(/^\/api/,'') 
      },
    }
  }
})
