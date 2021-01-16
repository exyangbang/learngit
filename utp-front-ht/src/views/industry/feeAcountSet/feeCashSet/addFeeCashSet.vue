<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form  :model="formDataNew"  ref="formDataNew" :label-width="120" :rules="ruleValidate">
      <i style="height: 10px"></i>
      <Row>
        <Col span="24">
          <row>
            <Col span="12">
              <FormItem label="收款方账号：" prop="accountNo">
                <Input v-model="formDataNew.accountNo"  style="width:350px" placeholder="请输入收款方账号" :maxlength="accountSize" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="收款方户名：" prop="accountName">
                <Input v-model="formDataNew.accountName"  style="width:350px" placeholder="请输入收款方户名" :maxlength="nameSize"  />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="清算行号：" prop="payeeOpbk">
                <Input v-model="formDataNew.payeeOpbk"  style="width:350px" placeholder="请输入清算行号" :maxlength="twelveSize"  />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="开户行号：" prop="opBankCode">
                <Input v-model="formDataNew.opBankCode"  style="width:350px" placeholder="请输入开户行号" :maxlength="accountSize"  />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="开户行名称：" prop="opBankName">
                <Input v-model="formDataNew.opBankName"  style="width:350px" placeholder="请输入开户行名称" :maxlength="nameSize"  />
              </FormItem>
            </Col>
          </row>
        </Col>
      </row>
      <Row>
        <Col span="10" offset="2">
          <FormItem>
            <Button type="primary" @click="handleSubmit()">提交</Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
  </card>
</template>
<script>import Cookies from 'js-cookie'

export default {
  name: "addFeeCashSet",
  data () {
    return {
      productNoAry: [],
      chnFeeTemplateIdAry: [],
      channelNameAry: [],
      // funcTableColumns: [],
      funcModal: false,
      industryCode: this.$route.params.industryCode,
      id: this.$route.params.industryCode,
      funcModalShow: false, // 用来更新数据
      formDataNew: {
        accountName: '',
        accountNo: '',
        payeeOpbk: '',
        opBankCode: '',
        opBankName: ''
      },
      ruleValidate: {
        accountNo: [
          {required: true, trigger: 'blur', message: '请输入收款方账号'},
          { type: 'string', message: '请输入数字', trigger: 'blur', pattern: /^[0-9]*$/ }
        ],
        accountName: [
          {required: true, trigger: 'blur', message: '请输入收款方户名'},
          {pattern: /^\S+$/, message: '不能输入空格'}
        ],
        payeeOpbk: [
          {required: true, trigger: 'blur', message: '请输入清算行号'},
          { type: 'string', message: '请输入数字', trigger: 'blur', pattern: /^[0-9]*$/ }
        ],
        opBankCode: [
          {required: true, trigger: 'blur', message: '请输入开户行号'},
          { type: 'string', message: '请输入数字', trigger: 'blur', pattern: /^[0-9]*$/ }
        ],
        opBankName: [
          {required: true, trigger: 'blur', message: '请输入开户行名称'}
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}]
    }
  },
  methods: {
    init () {
    },
    checkFunc (data) {
      this.funcModal = !this.funcModal
      this.funcModalShow = false
    },
    hideFunc: function () {
      this.funcModal = false
    },
    showRelateMerchant (row) {
      this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    channelNameChange: function (value) {
      this.formDataNew.channelName = value.label
      // this.setChannelName(value.label)
      this.formDataNew.channelKey = value.value
    },
    industryCodeChange: function (val) {
      this.formDataNew.industryCode = val
    },
    handleSubmit () {
      let that = this
      this.formDataNew.industryId = localStorage.getItem('industryIdCash')
      this.formDataNew.fundAccount = localStorage.getItem('fundAccountCash')
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          this.$axios.post('/withdrawCashAccount', this.formDataNew).then(function (res) {
            that.$Message.success('添加提现账户成功')
            that.goBack()
          })
        } else {
          that.$Message.error('请正确填写信息')
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
  mounted () {},
  computed: {
    headers () {
      if (!this.$store.state.app.token) {
        this.$store.commit('setToken', localStorage.getItem('token'))
      }
      return {
        'X-Requested-With': 'XMLHttpRequest',
        'X-Authorization': 'Bearer ' + this.$store.state.app.token
      }
    },
    nameSize () {
      return this.$contants.pageSet.nameSize
    },
    accountSize () {
      return this.$contants.pageSet.accountSize
    },
    twelveSize () {
      return this.$contants.pageSet.twelveSize
    }
  }
}
</script>
