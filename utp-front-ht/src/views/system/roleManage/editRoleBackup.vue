<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
    <card>
      <Form ref="form" :rules="ruleValidate" :model="formData" :label-width="150" label-position="right">
        <Row>
          <Col span="10" offset="4">
            <FormItem label="角色名称：" prop="rolename">
              <Input v-model="formData.rolename"/>
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
  data () {
    return {
      pathArray: [],
      id: this.$route.params.id,
      formData: {},
      ruleValidate: {
        rolename: [
          {required: true, trigger: 'blur', message: '请输入角色名称', type: 'string'}
        ],
        permissionList: [
          {required: true, trigger: 'blur', message: '请勾选权限', type: 'array'}
        ]
      },
      menuList: [],
      menuListCopy: [],
      checkedArr: []
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
              self.$util.goBack(self)
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
    getPermissions () {
      return this.$axios.get(this.$contants.restful.permissions)
    },
    getRole () {
      return this.$axios.get(this.$contants.restful.role + '/' + this.id)
    },
    getData () {
      let self = this
      this.$axios.all([this.getPermissions(), this.getRole()])
        .then(this.$axios.spread(function (permissionsRes, roleRes) {
          if (permissionsRes.data) {
            permissionsRes.data[0].expand = true
            self.menuListCopy = permissionsRes.data[0]
          }
          if (roleRes.data) {
            self.pathArray = roleRes.data.permissionList.map(function (obj) { return obj.path })
            self.formData = roleRes.data
            self.checkTree(self.menuListCopy)
            self.menuList = [self.menuListCopy]
            if (self.menuList) {
              console.log(self.menuList)
            }
          }
        })).catch(function (error) {
          console.log(error)
        })
    },
    // getPermissions () {
    //   let self = this
    //   this.$axios.get(this.$contants.restful.permissions)
    //     .then(function (response) {
    //       if (response.data) {
    //         response.data[0].expand = true
    //         self.menuList = response.data
    //       }
    //     })
    //     .catch(function (error) {
    //       console.log(error)
    //     })
    // },
    // getRole () {
    //   let self = this
    //   this.$axios.get(this.$contants.restful.role + '/' + this.id)
    //     .then(function (response) {
    //       if (response.data) {
    //         self.formData = response.data
    //         self.checkTree(self.menuList)
    //       }
    //     })
    //     .catch(function (error) {
    //       console.log(error)
    //     })
    // },
    checkNode (menu) {
      if (this.pathArray.indexOf(menu.path) !== -1) {
        menu.checked = true
      } else {
        menu.checked = false
      }
    },
    checkTree (tree) {
      if (!tree) {
        return 0
      }
      this.checkNode(tree)
      if (tree.children && tree.children.length > 0) {
        for (let i = 0; i < tree.children.length; i++) {
          this.checkTree(tree.children[i])
        }
      }
    },
    init () {
      if (this.id) {
        this.getData()
      }
    }
  },

  computed: {},
  mounted () {
    this.init()
  }
}
</script>
