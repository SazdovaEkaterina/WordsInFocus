const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '^/letters': {
        target: 'http://localhost:9090/',
        ws: true,
        changeOrigin: true
      },
    }
  }
})
