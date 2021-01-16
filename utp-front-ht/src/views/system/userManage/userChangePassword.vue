<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form ref="formValidate" :model="formData" :rules="ruleValidate" :label-width="120">
      <Row>
        <Col span="10" offset="2">
          <FormItem prop="oldPwd" label="旧密码：">
            <Input type="password"
                   v-model="formData.oldPwd"
                   placeholder="请输入旧密码"
                   min="6"
                   max="20"
                   onpaste="return false"
                   oncontextmenu="return false"
                   oncopy="return false"
                   oncut="return false" />
          </FormItem>
          <FormItem prop="newPwd" label="新密码：">
            <Input
              type="password"
              v-model="formData.newPwd"
              placeholder="请输入新密码(6-20位)"
              min="6"
              max="20"
              onpaste="return false"
              oncontextmenu="return false"
              oncopy="return false"
              oncut="return false"/>
          </FormItem>
          <FormItem prop="sureNewPwd" label="确认新密码：">
            <Input
              type="password"
              v-model="formData.sureNewPwd"
              :min="6"
              :max="20"
              placeholder="请确认新密码"
              onpaste="return false"
              oncontextmenu="return false"
              oncopy="return false"
              oncut="return false"/>
          </FormItem>

          <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">提交</Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>

        </Col>
      </Row>
    </Form>
  </card>
</template>
<script>
import Crypto from 'crypto'
import iconv from 'iconv-lite'
export default {
  name:"changeUserPassword",
  data () {
    return {
      username: this.$route.params.username,
      formData: {},
      ruleValidate: {
        oldPwd: [
          {required: true, trigger: 'blur', message: '请输入旧密码'}
        ],
        newPwd: [
          {required: true, trigger: 'blur', message: '请输入新密码'},
          { type: 'string', pattern: /^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d]{6,20}$/, message: '输入6-20位密码(字母和数字的组合)', trigger: 'blur' }
        ],
        sureNewPwd: [
          {required: true, trigger: 'blur', message: '请确认新密码'},
          { type: 'string', pattern: /^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d]{6,20}$/, message: '输入6-20位密码(字母和数字的组合)', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    init () {
      this.username = this.$route.params.username
    },
    handleSubmit (name) {
      let self = this
      this.$refs[name].validate((valid) => {
        if (valid) {
          if (self.formData.newPwd !== self.formData.sureNewPwd) {
            self.$Message.error('新密码两次输入不一样')
            return
          }
          var param = {}

          if (!self.$util.validPassword(self.formData.newPwd)) {
            this.$Message.error('新密码不合法!')
            return
          }
          let md5 = Crypto.createHash('sha256')
          let sha256 = Crypto.createHash('sha256')
          let newPwdStr = self.formData.newPwd + '{' + self.username + '}'
          let oldPwdStr = self.formData.oldPwd + '{' + self.username + '}'
          newPwdStr = iconv.decode(newPwdStr, 'gbk')
          oldPwdStr = iconv.decode(oldPwdStr, 'gbk')
          md5.update(newPwdStr)
          sha256.update(oldPwdStr)
          let newPwd = md5.digest('hex').toUpperCase()
          let oldPwd = sha256.digest('hex').toUpperCase()
          param.password = newPwd
          param.rawpassword = oldPwd
          param.username = self.username
          // let md51 = crypto.createHash('md5')
          // md51.update(self.formData.newPwd)
          // let newPwd = md51.digest('hex')
          // param.password = newPwd
          // param.username = self.username
          self.$axios.put(self.$contants.restful.userChangePwd, param)
            .then(() => {
              self.$Message.success('修改密码成功')
              self.goBack()
            })
            .catch((error) => {
              console.log(error)
            })
        }
      })
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    this.init()
  },
  computed: {

  },
  mounted () {
  }
}
</script>
