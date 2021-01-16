<style lang="less">
  .footer-border {
    padding: 0;
    border: none;
  }
</style>
<template>
  <card>
    <Form ref="formValidate" :model="formData" :label-width="120" :rules="ruleValidate">
      <Row>
        <Col span="10" offset="1">
          <h4>基本信息</h4>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="10" offset="1">
          <FormItem label="姓名：" prop="name">
            <Input v-model="formData.name" placeholder="请输入姓名" :maxlength="20" disabled/>
          </FormItem>
          <FormItem label="登录账号：" prop="username">
            <Input v-model="formData.username" placeholder="请输入登录账号(最大40位，不能包含特殊字符)" :maxlength="40" disabled/>
          </FormItem>
          <FormItem label="电话号码：" prop="mobileNo">
            <Input v-model="formData.mobileNo" placeholder="请输入电话号码" :maxlength="20"/>
          </FormItem>
          <FormItem label="邮箱：" prop="email">
            <Input v-model="formData.email" placeholder="请输入邮箱" :maxlength="50"/>
          </FormItem>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="10" offset="1">
          <h4>关联的角色</h4>
        </Col>
      </Row>
      <br>
      <Row>
        <Col span="10" offset="1">
          <FormItem label="">
            <Button type="ghost" icon="ios-plus-empty" @click="openFuncModal()">选择</Button>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="20" offset="1">
          <FormItem label="">
            <Table :columns="funcTableColumns" :data="funcTableData"></Table>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="10" offset="1">
          <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">提交</Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
    <!-- 弹出角色选择框-->
    <Modal v-model="funcModal" title="选择关联角色" width="700" :mask-closable="false">
      <func-list v-if="funcModalShow" :selectedData="funcTableData" :sureBtnDisabled=true :mydate=Date()
                 @checkFunc="checkFunc" @hideFunc="hideFunc"></func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>
import funcList from './components/funcList.vue'
export default {
  name: 'editUser',
  components: {
    funcList: funcList
  },
  data() {
    return {
      userId: this.$route.params.id,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {},
      ruleValidate: {
        mobileNo: [
          {required: true, trigger: 'blur', message: '请输入电话号码(5-20位数字)', min: 5, max: 20},
          {pattern: /\+?[\d]{3,20}(-?)[\d]{2,20}$/, trigger: 'blur', message: '请输入正确电话号码(5-20位数字)'}
        ],
        email: [
          {required: true, trigger: 'blur', message: '请输入邮箱', max: 50},
          {
            pattern: /^[a-zA-Z0-9]+([._\\-]*[a-zA-Z0-9])*@([a-zA-Z0-9]+[-a-zA-Z0-9]*[a-zA-Z0-9]+.){1,63}[a-zA-Z0-9]+$/,
            message: '请输入正确邮箱！'
          }
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],

      funcModal: false,
      funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init() {
      // 角色列表
      this.funcTableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 60
        },
        {
          title: '角色名称',
          key: 'rolename'
        }
      ]

      if (this.userId) {
        this.getUserDetail()
      }
    },
    getUserDetail() {
      let self = this
      let url = this.$contants.restful.user + '/' + this.userId
      url = encodeURI(url)
      this.$axios.get(url)
        .then(function (response) {
          self.formData = response.data
          self.funcTableData = response.data.roleList
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    goBack() {
      this.$util.goBack(this)
    },
    handleSubmit(name) {
      let self = this
      self.$refs[name].validate((valid) => {
        if (valid) {
          let params = {}
          params = Object.assign(params, this.formData)
          params.roleList = this.funcTableData
          params.id = this.userId
          if (params.roleList.length <= 0) {
            this.$Message.error('请先选择要关联的角色')
            return
          }
          this.$axios.put(this.$contants.restful.user, params)
            .then(function (response) {
              self.$Message.success('更新成功')
              // self.goBack()
              self.$util.goBackByRouteName(self,'userManage', true)
            })
            .catch(function (error) {
              console.log(error)
            })
        }
      })
    },
    // 打开功能点选择
    openFuncModal() {
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    // 获取到选中的数据
    checkFunc(data) {
      // 监听子组件funcList的事件，接收data
      this.funcTableData = data
      this.funcModal = !this.funcModal
    },
    hideFunc () {
      this.funcModal = !this.funcModal
      this.funcModalShow = false
    }
  },
  created() {
    this.init()
  },
  computed: {},
  mounted() {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'editUser', this.$route.params.id)
    if (this.userId !== initParamVal) {
      this.userId = initParamVal
      this.init()
    }
  }
}
</script>
