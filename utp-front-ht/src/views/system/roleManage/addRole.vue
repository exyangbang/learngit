<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
    <card>
      <Form ref="form" :rules="ruleValidate" :model="formData" :label-width="150" label-position="right">
        <Row>
          <Col span="10" offset="4">
            <FormItem label="角色名称：" prop="rolename">
              <Input :maxlength="nameSize" v-model="formData.rolename" />
            </FormItem>
            <FormItem label="勾选权限：" prop="permissionList">
                <Tree :data="menuList" v-model="formData.permissionList" show-checkbox @on-check-change="onChange" />
            </FormItem>
            <FormItem>
              <Button type="primary" @click="handleSubmit('form')" class="margin-top-20">保存</Button>
              <Button type="ghost" @click="goBack()" class="margin-top-20 margin-left-10">返回</Button>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </card>
</template>
<script>
export default {
    name: 'addRole',
  data () {
    return {
      formData: {},
      ruleValidate: {
        rolename: [
          {required: true, trigger: 'blur', message: '请输入角色名称', type: 'string'},
          {pattern: /^[\u4e00-\u9fff\w]{1,200}$/, message: '角色名称为字母、数字、下划线或其组合(最大长度200)！'}
        ],
        permissionList: [
          {required: true, trigger: 'blur', message: '请勾选权限', type: 'array'}
        ]
      },
      menuList: [],
      checkedArr: []
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
      this.$util.goBack(this)
    },
    handleSubmit (name) {
      let self = this
      self.$refs[name].validate((valid) => {
        if (valid) {
          this.$axios.post(self.$contants.restful.role, self.formData)
            .then(function () {
              self.$Message.success('创建角色成功！')
              // self.goBack()
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
    init () {
      let self = this
      this.$axios.get(this.$contants.restful.permissions)
        .then(function (response) {
          if (response.data) {
            response.data[0].expand = true
            self.menuList = response.data
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },
  created () {},
  mounted () {
    this.init()
  }
}
</script>
