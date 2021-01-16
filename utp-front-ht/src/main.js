import Vue from 'vue'
import App from './App'
import 'es6-promise/auto'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import Vuex from 'vuex'
import router from './router/index'
import {appRouter} from './router/router'
import store from './store'
import i18n from './i18n'
import constants from './contants'
import Util from './libs/util'
import {http} from './libs/axios'
import Cookies from 'js-cookie'
import 'babel-polyfill'
import moment from 'vue-moment'
import './icons'
Vue.use(iView)
Vue.use(Vuex)
Vue.use(moment)
/* 固定常量 */
Vue.prototype.$contants = constants
Vue.prototype.$axios = http
Vue.prototype.$util = Util
Vue.prototype.$cookies = Cookies
/* 全局注册权限检查指令 */
Vue.directive('access', {
  // 当被绑定的元素插入到 DOM 中时……
  inserted: function (el) {
    if (el.id) {
      let id = el.id
      let access = constants.resourceAccessMap[id]
      let accessList = localStorage.getItem('accessList')
      if (accessList && accessList.indexOf(access) !== -1) {
        el.style.display = 'display'
      } else {
        if (access) {
          el.style.display = 'none'
        } else {
          el.style.display = 'display'
        }
      }
    }
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router: router,
  store: store,
  i18n,
  render: h => h(App),
  data: {
    currentPageName: ''
  },
  mounted () {
    this.currentPageName = this.$route.name
    // 显示打开的页面的列表
    this.$store.commit('setOpenedList')
    this.$store.commit('initCachepage')
    // 权限菜单过滤相关
    // this.$store.commit('updateMenulist')
  },
  created () {
    let tagsList = []
    appRouter.map((item) => {
      if (item.children.length <= 1) {
        tagsList.push(item.children[0])
      } else {
        tagsList.push(...item.children)
      }
    })
    this.$store.commit('setTagsList', tagsList)
  }
})
