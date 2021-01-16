let util = {}
util.title = function (title) {
  title = title || '华通簿记开放平台V2.5.5'
  window.document.title = title
}

util.inOf = function (arr, targetArr) {
  let res = true
  arr.forEach(item => {
    if (targetArr.indexOf(item) < 0) {
      res = false
    }
  })
  return res
}

util.oneOf = function (ele, targetArr) {
  if (targetArr.indexOf(ele) >= 0) {
    return true
  } else {
    return false
  }
}

util.showThisRoute = function (itAccess, currentAccess) {
  if (typeof itAccess === 'object' && Array.isArray(itAccess)) {
    return util.oneOf(currentAccess, itAccess)
  } else {
    return itAccess === currentAccess
  }
}

util.getRouterObjByName = function (routers, name) {
  if (!name || !routers || !routers.length) {
    return null
  }
  let routerObj = null
  for (let item of routers) {
    if (item.name === name) {
      return item
    }
    routerObj = util.getRouterObjByName(item.children, name)
    if (routerObj) {
      return routerObj
    }
  }
  return null
}

util.handleTitle = function (vm, item) {
  if (typeof item.title === 'object') {
    return vm.$t(item.title.i18n)
  } else {
    return item.title
  }
}

util.setCurrentPath = function (vm, name) {
  let title = ''
  let isOtherRouter = false
  vm.$store.state.app.routers.forEach(item => {
    if (item.children.length === 1) {
      if (item.children[0].name === name) {
        title = util.handleTitle(vm, item)
        if (item.name === 'otherRouter') {
          isOtherRouter = true
        }
      }
    } else {
      item.children.forEach(child => {
        if (child.name === name) {
          title = util.handleTitle(vm, child)
          if (item.name === 'otherRouter') {
            isOtherRouter = true
          }
        }
      })
    }
  })
  let currentPathArr = []
  if (name === 'home_index') {
    currentPathArr = [
      {
        title: util.handleTitle(vm, util.getRouterObjByName(vm.$store.state.app.routers, 'home_index')),
        path: '',
        name: 'home_index'
      }
    ]
  } else if ((name.indexOf('_index') >= 0 || isOtherRouter) && name !== 'home_index') {
    currentPathArr = [
      {
        title: util.handleTitle(vm, util.getRouterObjByName(vm.$store.state.app.routers, 'home_index')),
        path: '/home',
        name: 'home_index'
      },
      {
        title: title,
        path: '',
        name: name
      }
    ]
  } else {
    let currentPathObj = vm.$store.state.app.routers.filter(item => {
      if (item.children.length <= 1) {
        return item.children[0].name === name
      } else {
        let i = 0
        let childArr = item.children
        let len = childArr.length
        while (i < len) {
          if (childArr[i].name === name) {
            return true
          }
          i++
        }
        return false
      }
    })[0]
    if (currentPathObj.children.length <= 1 && currentPathObj.name === 'home') {
      currentPathArr = [
        {
          title: '首页',
          path: '',
          name: 'home_index'
        }
      ]
    } else if (currentPathObj.children.length <= 1 && currentPathObj.name !== 'home') {
      currentPathArr = [
        {
          title: '首页',
          path: '/home',
          name: 'home_index'
        },
        {
          title: currentPathObj.title,
          path: '',
          name: name
        }
      ]
    } else {
      let childObj = currentPathObj.children.filter((child) => {
        return child.name === name
      })[0]
      currentPathArr = [
        {
          title: '首页',
          path: '/home',
          name: 'home_index'
        },
        {
          title: currentPathObj.title,
          path: '',
          name: currentPathObj.name
        },
        {
          title: childObj.title,
          path: currentPathObj.path + '/' + childObj.path,
          name: name
        }
      ]
    }
  }
  vm.$store.commit('setCurrentPath', currentPathArr)

  return currentPathArr
}

util.openNewPage = function (vm, name, argu, query) {
  let pageOpenedList = vm.$store.state.app.pageOpenedList
  let openedPageLen = pageOpenedList.length
  let i = 0
  let tagHasOpened = false
  while (i < openedPageLen) {
    if (name === pageOpenedList[i].name) { // 页面已经打开
      vm.$store.commit('pageOpenedList', {
        index: i,
        argu: argu,
        query: query
      })
      tagHasOpened = true
      break
    }
    i++
  }
  if (!tagHasOpened) {
    let tag = vm.$store.state.app.tagsList.filter((item) => {
      if (item.children) {
        return name === item.children[0].name
      } else {
        return name === item.name
      }
    })
    tag = tag[0]
    if (tag) {
      tag = tag.children ? tag.children[0] : tag
      if (argu) {
        tag.argu = argu
      }
      if (query) {
        tag.query = query
      }
      vm.$store.commit('increateTag', tag)
    }
  }
  vm.$store.commit('setCurrentPageName', name)
}

util.toDefaultPage = function (routers, name, route, next) {
  let len = routers.length
  let i = 0
  let notHandle = true
  while (i < len) {
    if (routers[i].name === name && routers[i].children && routers[i].redirect === undefined) {
      route.replace({
        name: routers[i].children[0].name
      })
      notHandle = false
      next()
      break
    }
    i++
  }
  if (notHandle) {
    next()
  }
}

util.fullscreenEvent = function (vm) {
  vm.$store.commit('initCachepage')
  // 权限菜单过滤相关
  // vm.$store.commit('updateMenulist')
  // 全屏相关
}

util.goBack = function (vm) {
  vm.$store.commit('removeTag', vm.$router.history.current.name)
  window.history.length > 1
    ? vm.$router.go(-1)
    : vm.$router.push('/')
}

util.validMobile = function (mobile) {
  var re = /^[1][3,4,5,7,8][0-9]{9}$/
  if (re.test(mobile)) {
    return true
  } else {
    return false
  }
}

util.validEmail = function (email) {
  var re = /^[a-zA-Z0-9]+([._\\-]*[a-zA-Z0-9])*@([a-zA-Z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/
  if (re.test(email)) {
    return true
  } else {
    return false
  }
}

util.validUserName = function (userName) {
  var re = /^[a-zA-Z0-9_-]{1,20}$/ // 可以包含字母、数字下划线中划线
  if (re.test(userName)) {
    return true
  } else {
    return false
  }
}

// 登录密码
util.validPassword = function (password) {
  var re = /^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d]{6,20}$/ // 6-20位 （字母+数字） 组合
  // var re = /^(\w){6,20}$/ // 6-20位字母、数字、下划线
  if (re.test(password)) {
    return true
  } else {
    return false
  }
}

// 证书密码
util.validPasswordPrivatekey = function (password) {
  var re = /^[a-z0-9]{6,8}$/ // 6-8位字母或数字
  if (re.test(password)) {
    return true
  } else {
    return false
  }
}
// 时间戳转时间
util.timestampToTime = function (timestamp) {
  var date = new Date(timestamp)
  var Y = date.getFullYear() + '-'
  var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-'
  var D = date.getDate() + ' '
  var h = date.getHours() + ':'
  var m = date.getMinutes() + ':'
  var s = date.getSeconds()
  return Y + M + D + h + m + s
}
util.checkRate = function (input) {
  var re = /^[0-9]+.?[0-9]*/
  if (!re.test(input)) {
    return false
  }
  return true
}

util.formatTXNTime = function (input) {
  if (input && typeof input === 'string' && input.length === 14) {
    let year = input.substring(0, 4)
    let month = input.substring(4, 6)
    let day = input.substring(6, 8)
    let hour = input.substring(8, 10)
    let min = input.substring(10, 12)
    let sec = input.substring(12, 14)
    let result = year + '-' + month + '-' + day + ' ' + hour + ':' + min + ':' + sec
    return result
  }
  return input
}
util.getRespDesc = function (input) {
  if (input) {
    switch (input) {
      case '00':
      case 'A6':
        return '交易成功'
      case '03':
      case '04':
      case '05':
        return '未知状态'
    }
  }
  return '交易失败'
}

util.goBackByRouteName = function (vm, routeName, isRefresh) {
  vm.$store.commit('removeTag', vm.$router.history.current.name)
  window.history.length > 1
    ? vm.$router.push({name: routeName, params: {refresh: isRefresh}})
    : vm.$router.push('/')
}

util.isRefresh = function (vm) {
  return vm.$route.params.refresh ? true : false
}

util.setSearchFormCache = function (vm, searchForm) {
  let params = {
    name: vm.$options.name,
    searchForm: searchForm
  }
  vm.$store.commit('setSearchForm', params)
}

util.getSearchFormCache = function (vm) {
  let searchFormCache
  if (vm.$options.name && vm.$store.state.app.searchFormCache[vm.$options.name]) {
    searchFormCache = JSON.parse(vm.$store.state.app.searchFormCache[vm.$options.name])
  }
  return searchFormCache
}

util.getRefreshInitParam = function (vm, sAttrId, inputParamVal) {
  let initParamVal = inputParamVal
  let sessionAttrId = vm.$options.name + '.' + sAttrId
  if (inputParamVal === undefined) {
    // 页面刷新处理
    initParamVal = sessionStorage.getItem(sessionAttrId)
  } else if (inputParamVal) {
    // 是否 新入参值
    let oldParamVal = sessionStorage.getItem(sessionAttrId)
    if (oldParamVal !== inputParamVal) {
      initParamVal = inputParamVal
      sessionStorage.setItem(sessionAttrId, inputParamVal)
    }
  } else {
    initParamVal = sessionStorage.getItem(sessionAttrId)
  }
  return initParamVal
}

util.formatYuanToFen = function(amount) {
  let m = 0, s1 = amount.toString(), s2 = "100".toString()
  try {
      if (s1.indexOf(".") != -1) {
          m += s1.split(".")[1].length;
      }
  } catch(e) {
      console.error(e)
  }
  try {
      if (s2.indexOf(".") != -1) {
          m += s2.split(".")[1].length
      }
  } catch(e) {
      console.error(e)
  }
  return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
}
util.formatFenToYuan = function(amount) {
  let num = amount
  num = amount * 0.01
  num += ''
  var reg = num.indexOf('.') >-1 ? /(\d{1,3})(?=(?:\d{3})+\.)/g : /(\d{1,3})(?=(?:\d{3})+$)/g
  num = num.replace(reg,'$1')
  num = parseFloat(num).toFixed(2)
  return num
}
export default util
