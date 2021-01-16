<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
    <card>
      <Form ref="form" :rules="ruleValidate" :model="formData" :label-width="150" label-position="right">
        <Row>
          <Col span="10" offset="4">
            <FormItem label="角色名称：" prop="rolename">
              <Input :maxlength="nameSize" v-model="formData.rolename"/>
            </FormItem>
            <FormItem label="角色权限：" prop="permissionList">
                <Tree ref="permissionTree" :data="menuList" v-model="formData.permissionList" show-checkbox @on-check-change="onChange" />
            </FormItem>
            <FormItem>
              <Button type="primary" @click="handleSubmit('form')" class="margin-top-20">保存</Button>
              <Button type="ghost" @click="goBack()" class="margin-top-20 margin-left-10">取消</Button>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </card>
</template>
<script>

export default {
  name: 'editRole',
  data () {
    return {
      id: this.$route.params.id,
      formData: {},
      ruleValidate: {
        rolename: [
          {required: true, trigger: 'blur', message: '请输入角色名称'},
          {pattern: /^[\u4e00-\u9fff\w]{1,200}$/, message: '角色名称为字母、数字、下划线或其组合、最大长度200！'}
        ],
        permissionList: [
          {required: true, trigger: 'blur', message: '请勾选权限', type: 'array'}
        ]
      },
      menuList: []
    }
  },
  computed: {
    nameSize () {
      return this.$contants.pageSet.nameSize
    },
    accountSize () {
      return this.$contants.pageSet.accountSize
    }
  },
  methods: {
    goBack () {
      this.$util.goBackByRouteName(this,"roleManage",false)
      // this.$router.push({
      //   name: 'roleManage'
      // })
    },
    handleSubmit (name) {
      let self = this
      self.formData.permissionList = self.$refs['permissionTree'].getCheckedNodes()
      self.$refs[name].validate((valid) => {
        if (valid) {
          this.$axios.put(self.$contants.restful.role, self.formData)
            .then(function () {
              self.$Message.success('修改成功！')
              // self.$util.goBack(self)
              self.$util.goBackByRouteName(self,"roleManage",true)
            })
            .catch(function (error) {
              console.log(error)
            })
        }
      })
    },
    onChange (checkedArr) {
      this.formData.permissionList = checkedArr
    },
    getData () {
      let self = this
      this.$axios.get(this.$contants.restful.role + '/' + this.id)
        .then(function (response) {
          if (response.data) {
            self.formData = response.data
            self.menuList = response.data.permissionList
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    init () {
      if (this.id) {
        this.getData()
      }
    }
  },
  beforeRouteLeave (to, from, next) {
    if (to.name === 'editRole') {
      to.meta.keepAlive = false
    }
    next()
  },
  mounted () {
    this.init()
  },
  activated() {
    if (this.id !== this.$route.params.id) {
        this.id = this.$route.params.id
        this.init()
    }
  }
}
</script>
