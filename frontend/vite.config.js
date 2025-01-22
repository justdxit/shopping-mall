import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  define: {
    'process.env': {
      BASE_URL: process.env.VITE_API_BASE_URL,
    }
  }
})
