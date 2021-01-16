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
            <!--<Col span="12">-->
              <!--<FormItem label="代付客户号：" prop="industryCode">-->
                <!--<i-select v-model="industryCode" label-in-value @on-change="industryCodeChange" style="width: 300px">-->
                  <!--<i-option v-for="item in industryCodeAry" :key="item.id" :value="item.code">{{item.name}}</i-option>-->
                <!--</i-select>-->
              <!--</FormItem>-->
            <!--</Col>-->
          <Col span="12">
            <FormItem label="客户号：" prop="industryCode">
              <i-select v-model="formDataNew.industryCode" label-in-value @on-change="industryCodeChange" style="width: 300px">
                <i-option v-for="item in industryCodeAry" :key="item.id" :value="item.code">{{item.name}}</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="子账户账号：" prop="subAccount">
              <i-select filterable  v-model="formDataNew.subAccount" @on-change="subAccountChange" style="width: 300px">
                <Option v-for="item in subAccountArry"  :value="item.account" :key="item.id">
                  {{item.account}}
                </Option>
              </i-select>
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
  name: "addSubaccounts",
  data () {
    return {
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
          {required: true, trigger: 'change', message: '请选择客户号'}
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
        parameters: {

        }
      }

      // query.parameters.industryType = '1'
      let that = this
      this.$axios.post('/industry/industryListOnlyAccountSplittingBusiness', query).then(function (res) {
        that.industryCodeAry = res.data.list
      })
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
      that.formDataNew.subObjName = ''
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
    // subaccountsIndividualAmtBlure: function () {
    //   if (this.formDataNew.subaccountsIndividualAmt.indexOf('.') > 0) {
    //     if (this.formDataNew.subaccountsIndividualAmt.split('.')[1].length > 2) {
    //       this.$Message.error('请保留两位小数')
    //       this.formDataNew.subaccountsIndividualAmt = ''
    //       return false
    //     }
    //   }
    // },
    subaccountsDateAmtBlure: function () {
      if (this.formDataNew.subaccountsDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.subaccountsDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.subaccountsDateAmt = ''
          return false
        }
      }
    },
    // industryCodeChange: function (val) { subaccountsIndividualAmtBlure
    //   this.merName = val.label
    //   this.formDataNew.industryCode = val.value
    // },
    handleSubmit () {
      let that = this
      if (this.formDataNew.subaccountsIndividualAmt) {
        this.formDataNew.subaccountsIndividualAmt = (this.formDataNew.subaccountsIndividualAmt * 100).toString()
      }
      if (this.formDataNew.subaccountsDateAmt) {
        this.formDataNew.subaccountsDateAmt = (this.formDataNew.subaccountsDateAmt * 100).toString()
      }
      this.formDataNew.operationType = '2'

      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          that.$axios.post('/subaccountsmtALimitApproval', this.formDataNew).then(function (res) {
            that.$Message.success('新增子账户交易限额成功')
            that.goBack()
          }).catch(function () {
            if (that.formDataNew.subaccountsIndividualAmt) {
              that.formDataNew.subaccountsIndividualAmt = that.formDataNew.subaccountsIndividualAmt / 100
            }
            if (that.formDataNew.subaccountsDateAmt) {
              that.formDataNew.subaccountsDateAmt = that.formDataNew.subaccountsDateAmt / 100
            }
          })
        } else {
          that.$Message.error('请正确填写信息')
          if (that.formDataNew.subaccountsIndividualAmt) {
            that.formDataNew.subaccountsIndividualAmt = that.formDataNew.subaccountsIndividualAmt / 100
          }
          if (that.formDataNew.subaccountsDateAmt) {
            that.formDataNew.subaccountsDateAmt = that.formDataNew.subaccountsDateAmt / 100
          }
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
