import axios from 'axios'
import iView from 'iview'
import store from '../store'
import router from '../router/index'
import constants from '../contants'

/** 设置axios */
axios.defaults.timeout = 200000
// axios.defaults.baseURL = constants.BaseUrl
axios.defaults.baseURL = window.g.ApiUrl
axios.defaults.headers.post['X-Requested-With'] = 'XMLHttpRequest'

/** 请求拦截器 */
axios.interceptors.request.use(function (config) {
  let token = ''
  if (store.state.app.token) {
    token = store.state.app.token
  } else {
    token = localStorage.getItem('token')
    store.commit('setToken', token)
  }
  if (token) {
    config.headers.common['X-Authorization'] = 'Bearer ' + token
  }
  // 开始请求
  iView.LoadingBar.start()
  return config
}, function (error) {
  iView.LoadingBar.finish()
  return Promise.reject(error)
})

/** 响应拦截器 */
axios.interceptors.response.use(function (response) {
  iView.LoadingBar.finish()
  if (response.data.errorCode) {
    iView.Message.error('错误码：' + response.data.errorCode + '; ' + response.data.message)
    return Promise.reject(response)
  }
  return response
}, function (error) {
  iView.LoadingBar.finish()
  if (error.response) {
    switch (error.response.status) {
      case 401:
        if (error.response.data.errorCode) {
          switch (error.response.data.errorCode) {
            case 'BSMSC002':
              error.response.data.message = '登录已过期，请重新登录'
              store.commit('logout')
              store.commit('clearOpenedSubmenu')
              router.push({
                name: 'login'
              })
              break
          }
        }
        break
    }
    if (error.response.data.message) {
      iView.Message.error(error.response.data.message)
    } else {
      if (error.response.data.byteLength) {
        iView.Message.error('无法下载电子回单')
      } else {
        if (error.response.config.url.indexOf('transFlowHistory/download') < 0) {
          iView.Message.error(error.message)
        }
      }
    }
  } else if (error.message) {
    iView.Message.error(error.message)
  }
  return Promise.reject(error)
})

export const http = axios
