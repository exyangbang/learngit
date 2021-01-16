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
              <Input v-model="formDataNew.industryCode" :disabled="true" style="width:350px"  placeholder="请输入客户号" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="对公单笔提现/代付限额(元)：" prop="publicIndividualAmt">
              <Input v-model="formDataNew.publicIndividualAmt" @on-blur="limitsOfficialDocumentsBlure" style="width:350px" placeholder="请输入对公单笔提现/代付限额" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="对私单笔提现/代付限额(元)：" prop="privateIndividualAmt">
              <Input v-model="formDataNew.privateIndividualAmt"  style="width:350px" @on-blur="privateIndividualQuotaBlure" placeholder="请输入对私单笔提现/代付限额" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="单位结算卡单笔提现/代付限额(元)：" prop="unitIndividualAmt">
              <Input v-model="formDataNew.unitIndividualAmt"  style="width:350px" placeholder="请输入单位结算卡单笔提现/代付限额" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="客户号单日提现/代付限额(元)：" prop="industryDateAmt">
              <Input v-model="formDataNew.industryDateAmt"  style="width:350px"  placeholder="请输入客户号单日提现/代付限额" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="对私子账户提现/代付单日限额(元)：" prop="subaccountsDateAmt">
              <Input v-model="formDataNew.subaccountsDateAmt"  style="width:350px" placeholder="请输入对私子账户提现/代付单日限额" :maxlength="15"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="对公子账户提现/代付单日限额(元)：" prop="publicSubaccountsDateAmt">
              <Input v-model="formDataNew.publicSubaccountsDateAmt" style="width:350px" @on-blur="publicSubaccountsDateAmtBlure" placeholder="请输入对公子账户提现/代付单日限额" :maxlength="15"/>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="客户号余额支付单日限额(元)：" prop="industryBalanceDateAmt">
              <Input v-model="formDataNew.industryBalanceDateAmt" style="width:350px" @on-blur="industryBalanceDateAmtBlure" placeholder="请输入客户号余额支付单日限额" :maxlength="15"/>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="对私子账户余额支付单日限额(元)：" prop="privateSubaccountsBalanceDateAmt">
              <Input v-model="formDataNew.privateSubaccountsBalanceDateAmt" style="width:350px" @on-blur="privateSubaccountsBalanceDateAmtBlure" placeholder="请输入对私子账户余额支付单日限额" :maxlength="15"/>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="对公子账户余额支付单日限额(元)：" prop="publicSubaccountsBalanceDateAmt">
              <Input v-model="formDataNew.publicSubaccountsBalanceDateAmt" style="width:350px" @on-blur="publicSubaccountsBalanceDateAmtBlure" placeholder="请输入对公子账户余额支付单日限额" :maxlength="15"/>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="相同订单最大分账数量：" prop="sameOrderMaxSpeAmt">
              <Input v-model="formDataNew.sameOrderMaxSpeAmt"  style="width:350px" @on-blur="privateIndividualQuotaBlure" placeholder="请输入相同订单最大分账数量" :maxlength="7"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="相同用户连续提现相同金额最大次数：" prop="sameCashMaxAmt">
              <Input v-model="formDataNew.sameCashMaxAmt"  style="width:350px" @on-blur="privateIndividualQuotaBlure" placeholder="请输入相同提现金额最大次数" :maxlength="5"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="一分钟内最大提现交易笔数：" prop="minuteMaxCashTranAmt">
              <Input v-model="formDataNew.minuteMaxCashTranAmt"  style="width:350px" @on-blur="privateIndividualQuotaBlure" placeholder="请输入一分钟内最大提现交易笔数" :maxlength="5"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="备注：" prop="remark">
              <Input v-model="formDataNew.remark"  style="width:350px" placeholder="请输入备注" :maxlength="1000"  />
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
  name: 'editQuotaExaApproval',
  data () {
    const sameOrderMaxSpeAmtVaildator = (rule, value, callback) => {
      if (value > 0 && value <= 1000000) {
        callback()
      } else {
        callback(new Error('最大值100万'));
      }
    };
    return {
      id: this.$route.params.id,
      productNoAry: [],
      chnFeeTemplateIdAry: [],
      channelNameAry: [],
      // funcTableColumns: [],
      funcModal: false,
      industryCodeAry: [],
      // id: this.$route.params.industryCode,
      merName: '',
      funcModalShow: false, // 用来更新数据
      formDataNew: {
        publicIndividualQuota: '',
        industryCode: '',
        privateIndividualQuota: ''
      },
      ruleValidate: {
        industryCode: [
          {required: true, trigger: 'blur', message: '请输入客户号'}
        ],
        publicIndividualAmt: [
          {required: true, trigger: 'blur', message: '请输入对公单笔提现/代付限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        privateIndividualAmt: [
          {required: true, trigger: 'blur', message: '请输入对私单笔提现/代付限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        unitIndividualAmt: [
          {required: true, trigger: 'blur', message: '请输入单位结算卡单笔提现/代付限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        industryDateAmt: [
          {required: true, trigger: 'blur', message: '请输入客户号单日提现/代付限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        subaccountsDateAmt: [
          {required: true, trigger: 'blur', message: '请输入对私子账户提现/代付单日限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        publicSubaccountsDateAmt: [
          {required: true, trigger: 'blur', message: '请输入对公子账户提现/代付单日限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        industryBalanceDateAmt: [
          {required: true, trigger: 'blur', message: '请输入客户号余额支付单日限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        privateSubaccountsBalanceDateAmt: [
          {required: true, trigger: 'blur', message: '请输入对私子账户余额支付单日限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        publicSubaccountsBalanceDateAmt: [
          {required: true, trigger: 'blur', message: '请输入对公子账户余额支付单日限额'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
        ],
        sameOrderMaxSpeAmt: [
          {required: true, trigger: 'blur', message: '请输入相同订单最大分账数量'},
          {pattern: /^[1-9]\d*$/, message: '请输入大于0的整数'},
          { validator: sameOrderMaxSpeAmtVaildator, trigger: 'blur' }
        ],
        sameCashMaxAmt: [
          {required: true, trigger: 'blur', message: '请输入相同提现金额最大次数'},
          {pattern: /^[1-9]\d*$/, message: '请输入大于0的整数'}
        ],
        minuteMaxCashTranAmt: [
          {required: true, trigger: 'blur', message: '请输入一分钟内最大提现交易笔数'},
          {pattern: /^[1-9]\d*$/, message: '请输入大于0的整数'}
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
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {

        }
      }
      if (this.id) {
        this.getDetail()
      }
    },
    getDetail () {
      let self = this
      this.$axios.get('/industryAmLimitApproval' + '/' + this.id)
        .then(function (response) {
          response.data.publicIndividualAmt = (response.data.publicIndividualAmt / 100).toString()
          response.data.privateIndividualAmt = (response.data.privateIndividualAmt / 100).toString()
          response.data.unitIndividualAmt = (response.data.unitIndividualAmt / 100).toString()
          response.data.industryDateAmt = (response.data.industryDateAmt / 100).toString()
          response.data.subaccountsDateAmt = (response.data.subaccountsDateAmt / 100).toString()
          response.data.publicSubaccountsDateAmt = (response.data.publicSubaccountsDateAmt / 100).toString()
          response.data.industryBalanceDateAmt = (response.data.industryBalanceDateAmt / 100).toString()
          response.data.privateSubaccountsBalanceDateAmt = (response.data.privateSubaccountsBalanceDateAmt / 100).toString()
          response.data.publicSubaccountsBalanceDateAmt = (response.data.publicSubaccountsBalanceDateAmt / 100).toString()
          if (response.data.sameOrderMaxSpeAmt === 'null') {
            response.data.sameOrderMaxSpeAmt = '5'
          }
          if (response.data.sameCashMaxAmt === 'null') {
            response.data.sameCashMaxAmt = '3'
          }
          if (response.data.minuteMaxCashTranAmt === 'null') {
            response.data.minuteMaxCashTranAmt = '60'
          }
          self.formDataNew = response.data
        })
        .catch(function (error) {
          console.log(error)
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
    limitsOfficialDocumentsBlure: function () {
      if (this.formDataNew.publicIndividualQuota.indexOf('.') > 0) {
        if (this.formDataNew.publicIndividualQuota.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.publicIndividualQuota = ''
          return false
        }
      }
    },
    privateIndividualQuotaBlure: function () {
      if (this.formDataNew.privateIndividualQuota.indexOf('.') > 0) {
        if (this.formDataNew.privateIndividualQuota.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.privateIndividualQuota = ''
          return false
        }
      }
    },
    publicSubaccountsDateAmtBlure: function () {
      if (this.formDataNew.publicSubaccountsDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.publicSubaccountsDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.publicSubaccountsDateAmt = ''
          return false
        }
      }
    },
    industryBalanceDateAmtBlure: function () {
      if (this.formDataNew.industryBalanceDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.industryBalanceDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.industryBalanceDateAmt = ''
          return false
        }
      }
    },
    privateSubaccountsBalanceDateAmtBlure: function () {
      if (this.formDataNew.privateSubaccountsBalanceDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.privateSubaccountsBalanceDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.privateSubaccountsBalanceDateAmt = ''
          return false
        }
      }
    },
    publicSubaccountsBalanceDateAmtBlure: function () {
      if (this.formDataNew.publicSubaccountsBalanceDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.publicSubaccountsBalanceDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.publicSubaccountsBalanceDateAmt = ''
          return false
        }
      }
    },
    channelNameChange: function (value) {
      this.formDataNew.channelName = value.label
      // this.setChannelName(value.label)
      this.formDataNew.channelKey = value.value
    },
    // industryCodeChange: function (val) {
    //   this.merName = val.label
    //   this.formDataNew.industryCode = val.value
    // },
    handleSubmit () {
      let that = this
      if (parseFloat(this.formDataNew.industryDateAmt) <= parseFloat(this.formDataNew.publicIndividualAmt) 
      || parseFloat(this.formDataNew.industryDateAmt) <= parseFloat(this.formDataNew.privateIndividualAmt) 
      || parseFloat(this.formDataNew.industryDateAmt) <= parseFloat(this.formDataNew.unitIndividualAmt) 
      || parseFloat(this.formDataNew.industryDateAmt) <= parseFloat(this.formDataNew.subaccountsDateAmt)
      || parseFloat(this.formDataNew.industryDateAmt) <= parseFloat(this.formDataNew.publicSubaccountsDateAmt)) {
        this.$Message.error('客户号单日提现/代付限额要最大')
        this.formDataNew.industryDateAmt = ''
        return false
      }
      if (parseFloat(this.formDataNew.industryBalanceDateAmt) <= parseFloat(this.formDataNew.privateSubaccountsBalanceDateAmt) || parseFloat(this.formDataNew.industryBalanceDateAmt) <= parseFloat(this.formDataNew.publicSubaccountsBalanceDateAmt)) {
        this.$Message.error('客户号余额支付单日限额要最大')
        this.formDataNew.industryBalanceDateAmt = ''
        return false
      }
      if (this.formDataNew.publicIndividualAmt) {
        this.formDataNew.publicIndividualAmt = this.$util.formatYuanToFen(this.formDataNew.publicIndividualAmt).toString()
      }
      if (this.formDataNew.privateIndividualAmt) {
        this.formDataNew.privateIndividualAmt = this.$util.formatYuanToFen(this.formDataNew.privateIndividualAmt).toString()
      }
      if (this.formDataNew.unitIndividualAmt) {
        this.formDataNew.unitIndividualAmt = this.$util.formatYuanToFen(this.formDataNew.unitIndividualAmt).toString()
      }
      if (this.formDataNew.industryDateAmt) {
        this.formDataNew.industryDateAmt = this.$util.formatYuanToFen(this.formDataNew.industryDateAmt).toString()
      }
      // if (this.formDataNew.subaccountsIndividualAmt) {
      //   this.formDataNew.subaccountsIndividualAmt = (this.formDataNew.subaccountsIndividualAmt * 100).toString()
      // }
      if (this.formDataNew.subaccountsDateAmt) {
        this.formDataNew.subaccountsDateAmt = (this.formDataNew.subaccountsDateAmt * 100).toString()
      }
      if (this.formDataNew.publicSubaccountsDateAmt) {
        this.formDataNew.publicSubaccountsDateAmt = this.$util.formatYuanToFen(this.formDataNew.publicSubaccountsDateAmt).toString()
      }
      if (this.formDataNew.industryBalanceDateAmt) {
        this.formDataNew.industryBalanceDateAmt = this.$util.formatYuanToFen(this.formDataNew.industryBalanceDateAmt).toString()
      }
      if (this.formDataNew.privateSubaccountsBalanceDateAmt) {
        this.formDataNew.privateSubaccountsBalanceDateAmt = this.$util.formatYuanToFen(this.formDataNew.privateSubaccountsBalanceDateAmt).toString()
      }
      if (this.formDataNew.publicSubaccountsBalanceDateAmt) {
        this.formDataNew.publicSubaccountsBalanceDateAmt = this.$util.formatYuanToFen(this.formDataNew.publicSubaccountsBalanceDateAmt).toString()
      }
      this.formDataNew.operationType = '1'
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          that.$axios.post('/industryAmLimitApproval', this.formDataNew).then(function (res) {
            that.$Message.success('编辑交易限额成功')
            that.goBack()
          }).catch(function () {
            if (that.formDataNew.publicIndividualAmt) {
              that.formDataNew.publicIndividualAmt = (that.formDataNew.publicIndividualAmt / 100).toString()
            }
            if (that.formDataNew.privateIndividualAmt) {
              that.formDataNew.privateIndividualAmt = (that.formDataNew.privateIndividualAmt / 100).toString()
            }
            if (that.formDataNew.unitIndividualAmt) {
              that.formDataNew.unitIndividualAmt = (that.formDataNew.unitIndividualAmt / 100).toString()
            }
            if (that.formDataNew.industryDateAmt) {
              that.formDataNew.industryDateAmt = (that.formDataNew.industryDateAmt / 100).toString()
            }
            if (that.formDataNew.subaccountsDateAmt) {
              that.formDataNew.subaccountsDateAmt = (that.formDataNew.subaccountsDateAmt / 100).toString()
            }
            if (that.formDataNew.publicSubaccountsDateAmt) {
              that.formDataNew.publicSubaccountsDateAmt = (that.formDataNew.publicSubaccountsDateAmt / 100).toString()
            }
            if (that.formDataNew.industryBalanceDateAmt) {
              that.formDataNew.industryBalanceDateAmt = (that.formDataNew.industryBalanceDateAmt / 100).toString()
            }
            if (that.formDataNew.privateSubaccountsBalanceDateAmt) {
              that.formDataNew.privateSubaccountsBalanceDateAmt = (that.formDataNew.privateSubaccountsBalanceDateAmt / 100).toString()
            }
            if (that.formDataNew.publicSubaccountsBalanceDateAmt) {
              that.formDataNew.publicSubaccountsBalanceDateAmt = (that.formDataNew.publicSubaccountsBalanceDateAmt / 100).toString()
            }
            that.$Message.error('编辑交易限额失败')
          })
        } else {
          if (that.formDataNew.publicIndividualAmt) {
            that.formDataNew.publicIndividualAmt = (that.formDataNew.publicIndividualAmt / 100).toString()
          }
          if (that.formDataNew.privateIndividualAmt) {
            that.formDataNew.privateIndividualAmt = (that.formDataNew.privateIndividualAmt / 100).toString()
          }
          if (that.formDataNew.unitIndividualAmt) {
            that.formDataNew.unitIndividualAmt = (that.formDataNew.unitIndividualAmt / 100).toString()
          }
          if (that.formDataNew.industryDateAmt) {
            that.formDataNew.industryDateAmt = (that.formDataNew.industryDateAmt / 100).toString()
          }
          if (that.formDataNew.subaccountsDateAmt) {
            that.formDataNew.subaccountsDateAmt = (that.formDataNew.subaccountsDateAmt / 100).toString()
          }
          if (that.formDataNew.publicSubaccountsDateAmt) {
              that.formDataNew.publicSubaccountsDateAmt = (that.formDataNew.publicSubaccountsDateAmt / 100).toString()
            }
            if (that.formDataNew.industryBalanceDateAmt) {
              that.formDataNew.industryBalanceDateAmt = (that.formDataNew.industryBalanceDateAmt / 100).toString()
            }
            if (that.formDataNew.privateSubaccountsBalanceDateAmt) {
              that.formDataNew.privateSubaccountsBalanceDateAmt = (that.formDataNew.privateSubaccountsBalanceDateAmt / 100).toString()
            }
            if (that.formDataNew.publicSubaccountsBalanceDateAmt) {
              that.formDataNew.publicSubaccountsBalanceDateAmt = (that.formDataNew.publicSubaccountsBalanceDateAmt / 100).toString()
            }
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
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'editQuotaExaApproval', this.$route.params.id)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.init()
    }
  }
}
</script>
