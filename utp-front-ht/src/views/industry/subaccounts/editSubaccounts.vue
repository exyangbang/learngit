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
      <row>
        <Col span="24">
          <Col span="12">
            <FormItem label="客户号：" prop="industryCode">
              <Input v-model="formDataNew.industryCode" :disabled="true" style="width:350px" placeholder="" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="子账户账号：" prop="subAccount">
              <Input v-model="formDataNew.subAccount" :disabled="true" style="width:350px" placeholder="" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="子账户名称：" prop="subObjName">
              <Input v-model="formDataNew.subObjName" :disabled="true" style="width:350px" placeholder="请输入子账户名称" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="子账户单笔限额(元)：" prop="subaccountsIndividualAmt">
              <Input v-model="formDataNew.subaccountsIndividualAmt" @on-blur="subaccountsIndividualAmtBlure" style="width:350px" placeholder="请输入子账户单笔限额" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="子账户单日限额(元)：" prop="subaccountsDateAmt">
              <Input v-model="formDataNew.subaccountsDateAmt"  style="width:350px" @on-blur="privateIndividualQuotaBlure" placeholder="请输入子账户单日限额" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="备注：" prop="remark">
              <Input v-model="formDataNew.remark"  style="width:350px" placeholder="请输入备注" :maxlength="nameSize"  />
            </FormItem>
          </Col>
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
  name: "editSubaccounts",
  data () {
    return {
      id: this.$route.params.id,
      industryCodeAry: [],
      subAccountArry: [], // 子账户
      productNoAry: [],
      chnFeeTemplateIdAry: [],
      channelNameAry: [],
      // funcTableColumns: [],
      funcModal: false,
      // id: this.$route.params.industryCode,
      merName: '',
      funcModalShow: false, // 用来更新数据
      formDataNew: {
        subObjName: '',
        subAccount: '',
        industryCode: '',
        industryDateAmt: '',
        // subaccountsIndividualAmt: '',
        subaccountsDateAmt: ''
      },
      ruleValidate: {
        industryCode: [
          {required: true, trigger: 'blur', message: '请选择客户号'}
        ],
        subAccount: [
          {required: true, trigger: 'change', message: '请选择子账户'}
        ],
        subaccountsIndividualAmt: [
          {required: true, trigger: 'blur', message: '请输入子账户单笔限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        subaccountsDateAmt: [
          {required: true, trigger: 'blur', message: '请输入子账户单日限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        // industryDateAmt: [
        //   {required: true, trigger: 'blur', message: '请输入客户号单日限额'},
        //   {pattern: /^\d+(\.{0,1}\d+){0,1}$/, message: '请输入非负数字'}
        // ],
        // subaccountsIndividualAmt: [
        //   {required: true, trigger: 'blur', message: '请输入子账户单笔限额'},
        //   {pattern: /^\d+(\.{0,1}\d+){0,1}$/, message: '请输入非负数字'}
        // ],
        // subaccountsDateAmt: [
        //   {required: true, trigger: 'blur', message: '请输入子账户单日限额'},
        //   {pattern: /^\d+(\.{0,1}\d+){0,1}$/, message: '请输入非负数字'}
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
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }

      if (this.id) {
        this.getDetail()
      }
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
    getDetail () {
      let self = this
      this.$axios.get('/subaccountsmtALimitApproval' + '/' + this.id)
        .then(function (response) {
          response.data.subaccountsIndividualAmt = (response.data.subaccountsIndividualAmt / 100).toString()
          response.data.subaccountsDateAmt = (response.data.subaccountsDateAmt / 100).toString()
          let query = {
            parameters: {industryCode: response.data.industryCode},
            pageNo: 1,
            pageSize: 100
          }
          self.$axios.post('/merchantInfo/listUnUserType', query).then(function (res) {
            self.subAccountArry = res.data.list
          })
          self.formDataNew = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    industryCodeChange: function (val) {

      let that = this
      // this.merName = val.label
      // this.formDataNew.industryCode = val.value
      let query = {
        parameters: {industryCode: val.value},
        pageNo: 1,
        pageSize: 100
      }
      that.subAccountArry = []
      that.formDataNew.subAccount = ''
      this.$axios.post('/merchantInfo/listUnUserType', query).then(function (res) {
        that.subAccountArry = res.data.list
      })
    },
    subAccountChange: function (val) {
      let that = this
      // this.formDataNew.subObjName = val.value
      this.formDataNew.subAccount = val
      this.subAccountArry.forEach(function (e, i) {
        if (e.account === val) {
          that.formDataNew.subObjName = e.realName
        }
      })
    },
    channelNameChange: function (value) {
      this.formDataNew.channelName = value.label
      // this.setChannelName(value.label)
      this.formDataNew.channelKey = value.value
    },
    subaccountsIndividualAmtBlure: function () {
      if (this.formDataNew.subaccountsIndividualAmt.indexOf('.') > 0) {
        if (this.formDataNew.subaccountsIndividualAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.subaccountsIndividualAmt = ''
          return false
        }
      }
    },
    privateIndividualQuotaBlure: function () {
      if (this.formDataNew.subaccountsDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.subaccountsDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.subaccountsDateAmt = ''
          return false
        }
      }
    },
    // subaccountsDateAmtBlure: function () {
    //   if (this.formDataNew.subaccountsDateAmt.indexOf('.') > 0) {
    //     if (this.formDataNew.subaccountsDateAmt.split('.')[1].length > 2) {
    //       this.$Message.error('请保留两位小数')
    //       this.formDataNew.subaccountsDateAmt = ''
    //       return false
    //     }
    //   }
    // },
    unitIndividualAmtBlure: function () {
      if (this.formDataNew.nitIndividualAmt.indexOf('.') > 0) {
        if (this.formDataNew.nitIndividualAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.nitIndividualAmt = ''
          return false
        }
      }
    },
    industryDateAmtBlure: function () {
      if (this.formDataNew.industryDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.industryDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.industryDateAmt = ''
          return false
        }
      }
    },
    subaccountsDateAmtBlure: function () {
      if (this.formDataNew.subaccountsDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.subaccountsDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.subaccountsDateAmt = ''
          return false
        }
      }
    },
    handleSubmit () {
      let that = this
      if (this.formDataNew.subaccountsIndividualAmt) {
        this.formDataNew.subaccountsIndividualAmt = (this.formDataNew.subaccountsIndividualAmt * 100).toString()
      }
      if (this.formDataNew.subaccountsDateAmt) {
        this.formDataNew.subaccountsDateAmt = (this.formDataNew.subaccountsDateAmt * 100).toString()
      }
      this.formDataNew.operationType = '1'
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          that.$axios.post('/subaccountsmtALimitApproval', this.formDataNew).then(function (res) {
            that.$Message.success('新增子账户交易限额成功')
            that.goBack()
          }).catch(function () {
            that.formDataNew.subaccountsIndividualAmt = ''
            that.formDataNew.subaccountsDateAmt = ''
            // that.formDataNew.subaccountsIndividualAmt = (that.formDataNew.subaccountsIndividualAmt / 100).toString()
            // that.formDataNew.subaccountsDateAmt = (that.formDataNew.subaccountsDateAmt / 100).toString()
          })
        } else {
          that.$Message.error('请正确填写信息')
          that.formDataNew.subaccountsIndividualAmt = ''
          that.formDataNew.subaccountsDateAmt = ''
          // that.formDataNew.subaccountsIndividualAmt = (that.formDataNew.subaccountsIndividualAmt / 100).toString()
          // that.formDataNew.subaccountsDateAmt = (that.formDataNew.subaccountsDateAmt / 100).toString()
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
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'editSubaccounts', this.$route.params.id)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.init()
    }
  }
}
</script>
