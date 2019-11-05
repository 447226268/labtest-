const path = require('path');

function resolve(dir) {
    return path.join(__dirname, dir)
}

module.exports = {
    css: {
        sourceMap: false
    },
    productionSourceMap: false,
    chainWebpack: (config) => {
        config.resolve.alias
            .set('@', resolve('src'))
            .set('@assets', resolve('src/assets'))
            .set('@components', resolve('src/components'))
            .set('@utils', resolve('src/layout'))
            .set('@views', resolve('src/base'))
    },
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080', // 填写后台接口
                ws: true,
                changOrigin: true, //允许跨域
                pathRewrite: {
                    '^/api': '' //请求的时候使用这个api就可以
                }
            }
        } 
    }
}