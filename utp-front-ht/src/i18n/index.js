import Vue from 'vue'
import VueI18n from 'vue-i18n'

Vue.use(VueI18n)

// 国际化配置常量
const messages = {
  cn: {
    home: '首页',
    hello: '你好，世界'
  },
  ja: {
    home: 'home',
    hello: 'こんにちは、世界'
  }
}
// 创建国际化实例
const i18n = new VueI18n({
  locale: 'cn', // 设置本地语言
  messages // 配置
})

export default i18n
