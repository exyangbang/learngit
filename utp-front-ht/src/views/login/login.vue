<style lang="less">
    @import 'login';
</style>

<template>
    <div class="login">
        <div class="login-con">
            <img src="../../images/logo.png" style="margin-bottom: 15px"/>
            <Card :bordered="false">
                <p class="title-con">华通簿记开放平台V2.5.5</p>
                <div class="form-con">
                    <Form ref="loginForm" :model="form" :rules="ruleInline" @keydown.enter.native="handleSubmit('loginForm')">
                        <FormItem prop="username">
                            <Input v-model="form.username" placeholder="请输入用户名">
                                <span slot="prepend">
                                    <svg-icon :size="14" type="username"></svg-icon>
                                </span>
                            </Input>
                        </FormItem>
                        <FormItem prop="password">
                            <Input type="password" v-model="form.password" placeholder="请输入密码" onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false">
                                <span slot="prepend">
                                    <svg-icon :size="14" type="pwd"></svg-icon>
                                </span>
                            </Input>
                        </FormItem>
                        <FormItem>
                            <Button class="submit-con" @click="handleSubmit('loginForm')" type="primary" >登录</Button>
                        </FormItem>
                    </Form>
                </div>
            </Card>
        </div>
    </div>
</template>
<script>
import Cookies from 'js-cookie'
import Crypto from 'crypto'
import iconv from 'iconv-lite'
export default {
  data () {
    return {
      changeShowUrl: false,
      isAle: false,
      form: {
        // username: 'admin',
        // password: '123456'
      },
      ruleInline: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur', max: 20, type: 'string'},
          {max: 20, message: '最大长度20'}
        ],
        password: [
          {required: true, message: '请输入登录密码', trigger: 'blur'},
          {max: 20, message: '最大长度20'}
        ]
      }
    }
  },
  methods: {
    handleSubmit (name) {
      let self = this
      // self.$router.push({
      //   name: 'home_index'
      // })
      self.$refs[name].validate((valid) => {
        if (valid) {
          let pwd = self.form.password
          let sha = Crypto.createHash('sha256')
          let str = pwd + '{' + self.form.username + '}'
          str = iconv.decode(str, 'gbk')
          sha.update(str)
          let pwdSha = sha.digest('hex').toUpperCase()
          let subForm = {}
          subForm.username = self.form.username
          subForm.password = pwdSha
          this.$axios.post(this.$contants.restful.login, subForm)
            .then(function (response) {
              self.$store.commit('setAvator', '')
              Cookies.set('user', self.form.username)
              Cookies.set('pwd', self.form.password)
              localStorage.removeItem('token')
              localStorage.setItem('token', response.data.token)
              self.$store.commit('setToken', response.data.token)
              self.getPermission()
              self.$axios.post('/reconcileRecord/reconcileStatus').then(function (res) {
                if (res.data > 0) {
                  // self.changeShowUrl = true
                  self.$store.commit('changeShowUrl', true)
                } else {
                  // self.changeShowUrl = false
                  self.$store.commit('changeShowUrl', false)
                }
              })
            })
            .catch(function (error) {
              console.log(error)
            })
        }
      })
    },
    getPermission () {
      let self = this
      this.$axios.get(this.$contants.restful.userPermission).then(function (response) {
        let channelAry = response.data
        channelAry.forEach(function (e) {
          if (e === '/reconcileRecord/read') {
            // self.isAle = true
            self.$store.commit('isAle', true)
          }
        })
        self.$router.push({
          name: 'home_index',
          params: {
            changeShowUrl: self.changeShowUrl,
            isAle: self.isAle
          }
        })
        self.$store.commit('updateMenuList', response.data)
      })
        .catch(function (error) {
          console.log(error)
        })
      this.$axios.get('/dictionaries').then(function (response) {
        Cookies.set('channelDictions', response.data.channel)
        self.$store.commit('setDictionaries', response.data.channel)
      })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>

<style>

</style>
