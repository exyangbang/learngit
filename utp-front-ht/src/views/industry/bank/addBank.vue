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
              <FormItem label="来款账号：" prop="accountNo">
                <Input v-model="formDataNew.accountNo"  style="width:350px" placeholder="请输入来款账号" :maxlength="accountSize" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="来款户名：" prop="accountName">
                <Input v-model="formDataNew.accountName"  style="width:350px" placeholder="请输入来款户名" :maxlength="nameSize"  />
              </FormItem>
            </Col>
          </row>
          <!--<row>-->
            <!--<Col span="12">-->
              <!--<FormItem label="银行开户行：" prop="bankName">-->
                <!--<Input v-model="formDataNew.bankName"  style="width:350px" placeholder="请输入银行开户行" :maxlength="300" />-->
              <!--</FormItem>-->
            <!--</Col>-->
            <!--<Col span="12">-->
              <!--<FormItem label="银行开户行行号：" prop="bankCode">-->
                <!--<Input v-model="formDataNew.bankCode"  style="width:350px" placeholder="请输入银行开户行行号" :maxlength="32"  />-->
              <!--</FormItem>-->
            <!--</Col>-->
          <!--</row>-->
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
  name: "addBank",
  data () {
    return {
      productNoAry: [],
      chnFeeTemplateIdAry: [],
      channelNameAry: [],
      // funcTableColumns: [],
      funcModal: false,
      industryCode: this.$route.params.industryCode,
      funcModalShow: false, // 用来更新数据
      formDataNew: {
        channelCode: '',
        indFeeTemplateId: '',
        chnFeeTemplateId: '',
        industryCode: this.$route.params.industryCode,
        productNo: ''
      },
      ruleValidate: {
        accountNo: [
          { type: 'string', required: true, message: '请输入来款账号', trigger: 'blur', pattern: /^[0-9]*$/ }
        ],
        accountName: [
          {required: true, trigger: 'blur', message: '请输入来款户名'}
        ]
        // bankName: [
        //   {required: true, trigger: 'blur', message: '请输入银行开户行'}
        // ],
        // bankCode: [
        //   {required: true, trigger: 'blur', message: '请输入银行开户行行号'},
        //   { type: 'string', message: '请输入数字', trigger: 'blur', pattern: /^[0-9]*$/ }
        // ]
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

    // indFeeTemplateIdChange: function (val) {
    //   this.formDataNew.indFeeTemplateId = val
    //   // this.selectedItem = row
    //   this.funcModalShow = true
    //   this.funcModal = !this.funcModal
    // },
    handleSubmit () {
      let that = this
      this.formDataNew.industryCode = window.location.href.split('/')[(window.location.href.split('/').length - 1)]
      this.formDataNew.industryType = '1'
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          this.$axios.post('/industryAccountInfo', this.formDataNew).then(function (res) {
            that.$Message.success('添加来款账户成功')
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
    }
  }
}
</script>
