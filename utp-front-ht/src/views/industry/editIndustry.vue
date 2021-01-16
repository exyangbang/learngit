<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form  :model="formData"  ref="formData" :label-width="150" :rules="ruleValidate">
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">编辑客户</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <i style="height: 10px"></i>
      <Row>
        <Col span="24">
          <row>
          <Col span="12">
            <FormItem label="所属机构：" prop="orgCode">
              <i-select @on-change="orgChange" v-model="formData.orgCode" :label-in-value = "true" style="width: 300px" placeholder="请选择机构">
                <i-option v-for="item in orgAry" :key="item.id" :value="item.orgCode">{{item.fullName}}</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="客户名称：" prop="name">
              <Input v-model="formData.name" style="width: 300px" placeholder="请输入客户名称" :maxlength="nameSize" />
            </FormItem>
          </Col>
          </row>
          <row>
          <Col span="12">
            <FormItem label="客户简称：" prop="simpleName">
              <Input v-model="formData.simpleName" style="width: 300px" placeholder="请输入客户简称" :maxlength="nameSize" />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="客户号：" prop="code">
              <Input v-model="formData.code" :disabled="true" style="width: 300px" placeholder="请输入客户号" :maxlength="12" />
            </FormItem>
          </Col>
          </row>
          <row>
          <Col span="12">
            <FormItem label="资金账号：" prop="bankAccountNo">
              <i-select v-model="formData.bankAccountNo" @on-change="custAccountNoChange" :disabled="bankAccountNoDis"  :label-in-value = "true" style="width: 300px" placeholder="请选择资金账号">
                <i-option v-for="item in custAccountNoAry" :key="item.id" :value="item.bankAccountNo">{{item.bankAccountNo}} (户名:{{item.bankAccountName}})</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="清算行号：" prop="bankCode">
              <Input v-model="formData.bankCode" :disabled="true" style="width: 300px" placeholder="请输入清算行号" :maxlength="12" />
            </FormItem>
          </Col>
          </row>
          <row>
          <Col span="12">
            <FormItem label="户名：" prop="bankAccountName">
              <Input v-model="formData.bankAccountName" :disabled="true"  :maxlength="nameSize" style="width: 300px" placeholder="请输入户名"/>
            </FormItem>
          </Col>

          <Col span="12">
            <FormItem label="入金通知url：" prop="innerNoticeUrl">
              <Input v-model="formData.innerNoticeUrl" :maxlength="nameSize" style="width: 300px" placeholder="请输入入金通知url"/>
            </FormItem>
          </Col>
          </row>
          <row>
          <Col span="12">
            <FormItem label="手续费支出账户：" prop="feeExpenditureAccount">
              <i-select v-model="formData.feeExpenditureAccount" style="width:300px" @on-change="feeExpenditureAccountChange" :disabled="accountFeeExpenditure" placeholder="请选择手续费支出账户">
                <i-option v-for="item in feeExpenditureAccountAry"  :key="item.id" :value="item.id">{{ item.name }}</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费收益账户：" prop="processingFeeIncomeAccount">
              <i-select v-model="formData.processingFeeIncomeAccount"  style="width:300px" @on-change="processingFeeIncomeAccountChange" :disabled="accountFeeProfit"  placeholder="请选择手续费收益账户">
                <i-option v-for="item in processingFeeIncomeAccountAry"  :key="item.id" :value="item.id">{{ item.name }}</i-option>
              </i-select>
            </FormItem>
          </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="手续费归集账户：" prop="collectionIndustryId">
                <i-select v-model="formData.collectionIndustryId"  style="width:300px" @on-change="collectionAccountChange" placeholder="请选择手续费归集账户">
                  <i-option v-for="item in collectionAccountAccountAry"  :key="item.id" :value="item.id">{{ item.name }}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="平台上账条件：" prop="industryIncomeType">
                <i-select v-model="formData.industryIncomeType"  style="width:300px"  placeholder="请选择平台上账条件" :disabled="true">
                  <i-option value="0">根据来款账户上账</i-option>
                  <i-option value="1">无限制的来款上账</i-option>
                </i-select>
              </FormItem>
            </Col>
          <Col span="12">
            <FormItem label="二级账户是否对外接款：" prop="whetherExternal">
              <i-select v-model="formData.whetherExternal"  style="width:300px" @on-change="whetherExternalChange" placeholder="请选择是否对外接款" :disabled="whetherExternalDis">
                <i-option value="1">是</i-option>
                <i-option value="0">否</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12" v-if="whetherExternalGo">
              <FormItem label="二级账户入金类型：" prop="subIncomeType">
                <i-select style="width:300px" v-model="formData.subIncomeType">
                  <i-option v-for="item in this.$contants.dictionary.subIncomeTypeArray" :key="item.value" :value="item.value">{{item.name}}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="证书DN：" prop="dn">
                <Input v-model="formData.dn"  :maxlength="200" style="width: 300px" placeholder="请输入证书DN"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="鉴权方式：" prop="authenticationMode">
                <i-select v-model="formData.authenticationMode"  style="width:300px" @on-change="authenticationModeChange" placeholder="请选择开通业务">
                  <i-option value="3">三要素认证</i-option>
                  <i-option value="4">四要素认证</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="是否对公打款验证：" prop="needPublicAuthAmt">
                <i-select v-model="formData.needPublicAuthAmt"  style="width:300px" @on-change="needPublicAuthAmtChange" :disabled="bankAccountNoDis" placeholder="请选择是否对公打款验证">
                  <i-option value="1">是</i-option>
                  <i-option value="0">否</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12" v-if="needPublicAuthAmtGo">
              <FormItem label="小额打款支出账户：" prop="authPaymentAccountId">
                <i-select v-model="formData.authPaymentAccountId"  style="width:300px"  placeholder="请选择小额打款支出账户">
                  <i-option v-for="item in authPaymentAccountAry"  :key="item.id" :value="item.id">{{ item.name }}</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="是否支持绑定多张同名卡：" prop="ableBindMultiCard">
                <i-select v-model="formData.ableBindMultiCard"  style="width:300px" @on-change="ableBindMultiCardChange" placeholder="请选择是否对公打款验证">
                  <i-option value="1">是</i-option>
                  <i-option value="0">否</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="对账文件方式：" prop="reconciliationMode">
                <i-select v-model="formData.reconciliationMode"  style="width:300px" placeholder="请选择对账文件方式">
                  <i-option value="0">T+1日普通对账方式</i-option>
                  <i-option value="1">D+1日特殊对账方式</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="开通业务：" prop="businessType">
                <i-select v-model="formData.businessType" :disabled="businessTypeDis" style="width:300px" @on-change="businessTypeChange" placeholder="请选择开通业务">
                  <i-option value="1">分账业务</i-option>
                  <i-option value="2">代付业务</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="是否支持自定义显示付款账号及户名：" prop="openShowCustomFlag">
                <i-select v-model="formData.openShowCustomFlag"  style="width:300px" placeholder="请选择是否支持自定义显示付款账号及户名">
                  <i-option value="0">否</i-option>
                  <i-option value="1">是</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12" v-if="maxBrokerageRateGo">
              <FormItem label="是否支持支付流水初始化：" prop="ableTransOrderInit">
                <i-select v-model="formData.ableTransOrderInit"  style="width:300px" placeholder="请选择是否支持支付流水初始化">
                  <i-option value="0">否</i-option>
                  <i-option value="1">是</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12" v-if="maxBrokerageRateGo">
              <FormItem label="相同证件的二级账户最大开立数量：" prop="subAccountOpenMax">
                <Input-number v-model="formData.subAccountOpenMax" :max="99" :min="1" style="width: 300px" placeholder="请输入相同证件的二级账户最大开立数量"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12" v-if="maxBrokerageRateGo">
              <FormItem label="平台最大佣金比例(%)：" prop="maxBrokerageRate">
                <Input v-model="formData.maxBrokerageRate" @on-blur="maxBrokerageRateBlure"  :disabled="maxBrokerageRateDis" :maxlength="nameSize" style="width: 300px" placeholder="请输入平台最大佣金比例"/>
              </FormItem>
            </Col>
            <Col span="12" v-if="maxBrokerageRateGo">
              <FormItem label="是否开通双账户：" prop="isOpneDoubleAcc">
                <i-select v-model="formData.isOpneDoubleAcc"  style="width:300px"  placeholder="请选择是否开通双账户">
                  <i-option value="1">是</i-option>
                  <i-option value="2">否</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12" v-if="maxBrokerageRateGo">
              <FormItem label="是否开通余额支付：" prop="isOpneBalancePay">
                <i-select v-model="formData.isOpneBalancePay"  style="width:300px" @on-change="isOpneBalancePay" placeholder="请选择是否开通余额支付">
                  <i-option value="1">是</i-option>
                  <i-option value="2">否</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12" v-if="formData.isOpneBalancePay==='1' && maxBrokerageRateGo"><!-- “T0”、“T1”，默认值“T1”isOpneBalancePayGo-->
              <FormItem label="余额支付账期：" prop="balancePayPeriod">
                <i-select v-model="formData.balancePayPeriod"  style="width:300px"  placeholder="请选择余额支付账期">
                  <i-option value="T1">T1</i-option>
                  <i-option value="T0">T0</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12" v-if="maxBrokerageRateGo">
              <FormItem label="是否开通子账户单笔付款功能：" prop="openSubSinglePay">
                <i-select v-model="formData.openSubSinglePay"  style="width:300px" @on-change="openSubSinglePayChange" placeholder="请选择是否开通子账户单笔付款功能">
                  <i-option value="1">是</i-option>
                  <i-option value="0">否</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12" v-if="maxBrokerageRateGo">
              <FormItem label="是否允许下载子账户日终余额对账单：" prop="ableDownloadDailyBalance">
                <i-select v-model="formData.ableDownloadDailyBalance"  style="width:300px" placeholder="请选择是否允许下载子账户日终余额对账单">
                  <i-option value="0">否</i-option>
                  <i-option value="1">是</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12" v-if="maxBrokerageRateGo">
              <FormItem label="开户模式：" prop="openAccountMode">
                <i-select v-model="formData.openAccountMode"  style="width:300px" placeholder="请选择开户模式" :disabled="openAccountModeDisable">
                  <i-option value="0">鉴权绑卡时上传图片资料(旧)</i-option>
                  <i-option value="1">开户时上传图片资料(新)</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12" v-if="openSubSinglePayGo">
              <FormItem label="付款子账户类型：" prop="payerSubTypeList">
                <i-select v-model="formData.payerSubTypeList" multiple style="width:300px" @on-change="payerSubTypeChange" placeholder="请选择付款子账户类型">
                  <i-option value="2">企业账户</i-option>
                  <i-option value="3">个人账户</i-option>
                  <i-option value="8">个体工商户账户</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12" v-if="openSubSinglePayGo">
              <FormItem label="是否校验收款人开通虚户标志：" prop="verifyPayeeAccountSign">
                <i-select v-model="formData.verifyPayeeAccountSign"  style="width:300px" @on-change="verifyPayeeAccountSignChange" placeholder="请选择是否校验收款人开通虚户标志">
                  <i-option value="1">是</i-option>
                  <i-option value="0">否</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12" v-if="verifyPayeeAccountSignGo">
              <FormItem label="是否校验收款人白名单：" prop="verifyPayeeWhiteListSign">
                <i-select v-model="formData.verifyPayeeWhiteListSign"  style="width:300px" @on-change="verifyPayeeWhiteListSignChange" placeholder="请选择是否校验收款人白名单">
                  <i-option value="1">是</i-option>
                  <i-option value="0">否</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
        </Col>
      </Row>
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
<script>
export default {
  // name: "editIndustry",
  data () {
    return {
      payerSubTypeList: [],
      maxBrokerageRateGo: true,
      businessTypeDis: true,
      maxBrokerageRateDis: true,
      bankAccountNoDis: true,
      accountFeeExpenditure: false,
      accountFeeProfit: false,
      needPublicAuthAmtGo: false,
      openSubSinglePayGo: false,
      verifyPayeeAccountSignGo: false,
      whetherExternalGo: false,
      openAccountModeDisable: false,
      whetherExternalDis: false,
      industryId: this.$route.params.id,
      orgAry: [],
      custAccountNoAry: [],
      feeExpenditureAccountAry: [],
      processingFeeIncomeAccountAry: [],
      collectionAccountAccountAry: [],
      authPaymentAccountAry: [],
      userId: null,
      type: null,
      currentPage: 1,
      roleList: [],
      feeAccountAry: [],
      feeGetAccountAry: [],
      query: {
        pageNo: 1,
        pageSize: 100,
        parameters: {
          fundAccount: '',
          accountSelf: '',
          industryType: '5'
        }
      },
      smallQuery: {
        pageNo: 1,
        pageSize: 1000,
        parameters: {
          accountSelf: '',
          industryType: '10'
        }
      },
      queryShou: {
        pageNo: 1,
        pageSize: 100,
        parameters: {
          fundAccount: '',
          accountSelf: '',
          industryType: '4'
        }
      },
      formData: {
        id: this.industryId,
        dn: '',
        industryType: '1',
        account: '',
        name: '',
        code: '',
        orgCode: '',
        orgName: '',
        bankCode: '',
        fundAccount: '',
        custAccountNo: '',
        custNumber: '',
        innerNoticeUrl: '',
        custAccountName: '',
        feeExpenditureAccount: '',
        processingFeeIncomeAccount: '',
        collectionIndustryId: '',
        authPaymentAccountId: '',
        whetherExternal: '',
        businessType: '',
        authenticationMode: '',
        needPublicAuthAmt: '0',
        ableBindMultiCard: '0',
        isOpneDoubleAcc: '2',
        openSubSinglePay: '',
        payerSubType: '',
        verifyPayeeAccountSign: '',
        verifyPayeeWhiteListSign: '',
        payerSubTypeList: [],
        ableTransOrderInit: '0',
        subAccountOpenMax: 2,
        reconciliationMode: '0',
        ableDownloadDailyBalance: '0',
        openAccountMode: '0',
        industryIncomeType: '0',
        openShowCustomFlag: '0'
      },
      ruleValidate: {
        orgCode: [
          {required: true, trigger: 'blur', message: '请选择机构'}
        ],
        name: [
          {required: true, trigger: 'blur', message: '请输入客户名称'}
        ],
        bankAccountNo: [
          {required: true, trigger: 'blur', message: '请选择资金账号'}
        ],
        bankCode: [
          {required: false, trigger: 'blur', message: '请输入清算行号'}
          // {pattern: /^[0-9]*$/, message: '请输入客户账户！'}
        ],
        dn: [
          {required: true, trigger: 'blur', message: '请输入证书DN'},
          {pattern: /^.{6,200}$/, message: '最少6位字符！'}
        ],
        code: [
          {required: true, trigger: 'blur', message: '请输入客户号！'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入数字和字母！'}
        ],
        custAccountNo: [
          {required: true, trigger: 'blur', message: '请输入客户账户！'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        custAccountName: [
          {required: false, trigger: 'blur', message: '请输入户名'}
        ],
        innerNoticeUrl: [
          {required: true, trigger: 'blur', message: '请输入入金通知url'}
        ],
        feeExpenditureAccount: [
          {required: true, trigger: 'change', message: '请选择手续费支出账户'}
        ],
        processingFeeIncomeAccount: [
          {required: true, trigger: 'change', message: '请选择手续费收益账户'}
        ],
        collectionIndustryId: [
          {required: false, trigger: 'change', message: '请选择手续费归集账户'}
        ],
        whetherExternal: [
          {required: true, trigger: 'change', message: '请选择是否对外接款'}
        ],
        businessType: [
          {required: true, trigger: 'change', message: '请选择开通业务'}
        ],
        needPublicAuthAmt: [
          {required: true, trigger: 'change', message: '请选择是否对公打款'}
        ],
        reconciliationMode: [
          {required: true, trigger: 'change', message: '请选择对账文件方式'}
        ],
        ableBindMultiCard: [
          {required: true, trigger: 'change', message: '请选择是否支持绑定多张同名卡'}
        ],
        maxBrokerageRate: [
          {required: true, trigger: 'blur', message: '请输入平台最大佣金比例'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入0-100的数字'}
        ],
        subIncomeType: [
          {required: true, trigger: 'change', message: '请选择二级账户入金类型'}
        ],
        ableTransOrderInit: [
          {required: true, trigger: 'change', message: '请选择是否支持支付流水初始化'}
        ],
        subAccountOpenMax: [
          {required: true, trigger: 'blur', message: '请输入相同证件的二级账户最大开立数量', type: 'number'},
          {pattern: /^([1-9]\d|[1-9])$/, message: '请输入1-99的数字'}
        ],
        ableDownloadDailyBalance: [
          {required: true, trigger: 'change', message: '请选择是否允许下载子账户日终余额对账单'}
        ],
        openAccountMode: [
          {required: true, trigger: 'change', message: '请选择开户模式'}
        ],
        industryIncomeType: [
          {required: true, trigger: 'change', message: '请选择平台上账条件'}
        ],
        openShowCustomFlag: [
          {required: true, trigger: 'change', message: '请选择是否支持自定义显示付款账号及户名'}
        ],
      },
      tree: [{}],
      // funcModal: false,
      funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init () {
      if (this.industryId) {
        this.getIndustryDetail()
      }
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      let queryIndu = {
        pageNo: 1,
        pageSize: 100,
        parameters: {
          industryType: '6',
          collectionFundAccount: this.formData.fundAccount
        }
      }
      let self = this
      self.collectionAccountAccountAry = []
      this.$axios.post('/industry/list', queryIndu).then(function (res) {
        self.collectionAccountAccountAry = res.data
      })
      this.$axios.post('/organization/list', query).then(function (res) {
        self.orgAry = res.data.list
      })
      this.$axios.post('/fundAccount/list', query).then(function (res) {
        self.custAccountNoAry = res.data.list
      })
    },
    whetherExternalChange: function (val) {
      this.formData.whetherExternal = val.toString()
      if (val === '1') {
        this.whetherExternalGo = true
      } else {
        this.whetherExternalGo = false
      }
    },
    maxBrokerageRateBlure: function () {
      if (this.formData.maxBrokerageRate <= 100) {
        if (this.formData.maxBrokerageRate.indexOf('.') > 0) {
          if (this.formData.maxBrokerageRate.split('.')[1].length > 3) {
            this.$Message.error('请保留三位小数')
            this.formData.maxBrokerageRate = ''
            return false
          }
        }
      } else {
        this.$Message.error('请输入请输入0-100的数字')
        this.formData.maxBrokerageRate = ''
        return false
      }
    },
    authenticationModeChange (val) {
      this.formData.authenticationMode = val
    },
    needPublicAuthAmtChange: function (val) {
      this.formData.needPublicAuthAmt = val
      if (val === '1') {
        this.needPublicAuthAmtGo = true
      } else {
        this.needPublicAuthAmtGo = false
      }
    },
    ableBindMultiCardChange: function (val) {
      this.formData.ableBindMultiCard = val
    },
    businessTypeChange (val) {
      this.formData.businessType = val
      this.verifyPayeeAccountSignGo = false
      this.openSubSinglePayGo = false
      this.formData.openSubSinglePay = '0'
      this.formData.payerSubType = ''
      this.formData.verifyPayeeAccountSign = ''
      this.formData.verifyPayeeWhiteListSign = ''
      if (val === '2') {
        this.maxBrokerageRateDis = true
        delete this.$refs.formData.rules.maxBrokerageRate
        this.formData.maxBrokerageRate = '0'
        this.maxBrokerageRateGo = false
        this.formData.isOpneBalancePay = '2'
      }
      if (val === '1') {
        this.maxBrokerageRateGo = true
        this.maxBrokerageRateDis = false
        this.$refs.formData.rules.maxBrokerageRate = [
          {required: true, trigger: 'blur', message: '请输入平台最大佣金比例！'},
          {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入0-100的数字'}
        ]
        this.formData.maxBrokerageRate = ''
        this.formData.isOpneDoubleAcc = '2'
        this.formData.isOpneBalancePay = '2'
        this.formData.balancePayPeriod = 'T1'
      }
    },
    openSubSinglePayChange (val) {
      // 是否开通子账户单笔付款功能
      this.formData.openSubSinglePay = val
      this.formData.payerSubType = ''
      this.formData.verifyPayeeAccountSign = '1'
      this.formData.verifyPayeeWhiteListSign = '0'
      this.verifyPayeeAccountSignGo = false
      if (val === '1') {
        this.openSubSinglePayGo = true
      } else {
        this.formData.verifyPayeeAccountSign = ''
        this.formData.verifyPayeeWhiteListSign = ''
        this.openSubSinglePayGo = false
      }
    },
    payerSubTypeChange (val) {
      // 付款子账户类型
      this.payerSubTypeList = val
    },
    verifyPayeeAccountSignChange (val) {
      this.formData.verifyPayeeAccountSign = val
      this.formData.verifyPayeeWhiteListSign = '0'
      // 是否校验收款人开通虚户标志
      if (val === '0') {
        this.verifyPayeeAccountSignGo = true
      } else {
        this.verifyPayeeAccountSignGo = false
      }
    },
    verifyPayeeWhiteListSignChange (val) {
      // 是否校验收款人白名单
      this.formData.verifyPayeeWhiteListSign = val
    },
    isOpneBalancePay (val) {
      this.formData.isOpneBalancePay = val
      if (val === '2') {
        this.formData.balancePayPeriod = 'T1'
      }
    },
    orgChange: function (val) {
      this.formData.orgCode = val.value
      this.formData.orgName = val.label
    },
    isOpneDoubleAccChange: function (val) {
      this.formData.isOpneDoubleAcc = val.value
    },
    custAccountNoChange: function (val) {
      // let self = this
      // this.formData.feeExpenditureAccount = ''
      // this.formData.processingFeeIncomeAccount = ''
      // this.formData.custAccountName = val.label.split(' ')[1].split('(')[1].split(')')[0].split(':')[1]
      // let idNew = ''
      // this.custAccountNoAry.forEach(function (e, i) {
      //   if (val.value === e.bankAccountNo) {
      //     idNew = e.id
      //   }
      // })
      // this.formData.custAccountNo = val.value
      // this.$axios.get('/fundAccount/' + idNew).then(function (res) {
      //   self.formData.account = res.data.accountNum
      //   self.formData.fundAccount = res.data.bankAccountNo
      //   self.formData.bankAccountName = res.data.bankAccountName
      //   self.formData.bankCode = res.data.bankCode
      //   if (self.query.parameters.fundAccount === '') {
      //     // 手续费支出账户
      //     self.query.parameters.fundAccount = self.formData.fundAccount
      //     self.$axios.post('/industry/pageListFeeAndAuthAccount', self.query).then(function (res) {
      //       self.feeExpenditureAccountAry = []
      //       res.data.list.forEach(function (e, i) {
      //         self.feeExpenditureAccountAry.push(e)
      //       })
      //       self.feeExpenditureAccountAry.unshift({
      //         id: '-1',
      //         name: '自己的账户'
      //       })
      //     })
      //   }
      //   // 小额打款支出账户
      //   self.formData.authPaymentAccountId = ''
      //   self.authPaymentAccountAry = []
      //   self.smallQuery = res.data.authPaymentAccountId
      //   self.$axios.post('/industry/pageListFeeAndAuthAccount', self.smallQuery).then(function (res) {
      //     res.data.list.forEach(function (e, i) {
      //       self.authPaymentAccountAry.push(e)
      //     })
      //   })
      // })
      // this.accountFeeProfit = true
      // this.accountFeeExpenditure = false
    },
    feeExpenditureAccountChange: function (val) {
      let self = this
      this.formData.feeExpenditureAccount = val.toString()
      if (this.formData.feeExpenditureAccount === '-1') {
        this.queryShou.parameters.fundAccount = this.formData.fundAccount
        this.queryShou.parameters.accountSelf = '-1'
      } else {
        this.feeExpenditureAccountAry.forEach(function (e, i) {
          if (e.id === val) {
            self.queryShou.parameters.fundAccount = e.fundAccount
          }
        })
        // this.queryShou.parameters.fundAccount = this.formData.feeExpenditureAccount
        this.queryShou.parameters.accountSelf = '1'
      }
      this.$axios.post('/industry/pageList', this.queryShou).then(function (res) {
        self.processingFeeIncomeAccountAry = []
        self.formData.processingFeeIncomeAccount = ''
        res.data.list.forEach(function (e, i) {
          self.processingFeeIncomeAccountAry.push(e)
        })
        if (self.processingFeeIncomeAccountAry) {
          self.accountFeeProfit = false
        }
      })
    },
    processingFeeIncomeAccountChange: function (val) {
      this.formData.processingFeeIncomeAccount = val
      this.formData.collectionIndustryId = ''

      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {
          processingFeeIncomeAccount: val,
          collectionFundAccount: this.formData.fundAccount
        }
      }
      let self = this
      this.$axios.post('industry/pageCollectionList', query).then(function (res) {
        if (res.data.list.length === 1) {
          self.collectionAccountAccountAry = res.data.list
          self.formData.collectionIndustryId = res.data.list[0].id
        } else {
          self.collectionAccountAccountAry = res.data.list
        }
      })
    },
    collectionAccountChange: function (val) {
      this.formData.collectionIndustryId = val
    },
    getIndustryDetail: function () {
      let self = this
      this.$axios.get('/industry/' + this.industryId + '?exImage=exImage')
        .then(function (response) {
          self.formData = response.data
          let queryGo = {
            pageNo: 1,
            pageSize: 100,
            parameters: {
              processingFeeIncomeAccount: response.data.processingFeeIncomeAccount,
              collectionFundAccount: response.fundAccount
            }
          }
          if (self.formData.openSubSinglePay === '1') {
            self.openSubSinglePayGo = true
            if (self.formData.verifyPayeeAccountSign === '0') {
              self.verifyPayeeAccountSignGo = true
            }
            self.formData.payerSubTypeList = self.formData.payerSubType.split(',')
          }
          if (self.formData.whetherExternal === '1') {
            self.whetherExternalGo = true
          }
          if (!self.formData.reconciliationMode) {
            self.formData.reconciliationMode = '0'
          }
          if (self.formData.auditStatus === '1' && self.formData.openAccountMode === '1') {
            self.openAccountModeDisable = true
          }
          if (self.formData.industryIncomeType === '1') {
            self.whetherExternalDis = true
          }
          self.$axios.post('industry/pageCollectionList', queryGo).then(function (res) {
            if (res.data.list.length === 1) {
              self.collectionAccountAccountAry = res.data.list
              self.formData.collectionIndustryId = res.data.list[0].id
            } else {
              self.collectionAccountAccountAry = res.data.list
            }
          })
          self.businessTypeDis = false
          // `audit_status` varchar(2) DEFAULT NULL COMMENT '状态（0-待审核 1-审核通过 2-审核驳回）',//true 显示 （“1分账业务”、“2代付业务”）
          if (response.data.auditStatus === '0') {
            if (response.data.businessType === '2') {
              self.maxBrokerageRateGo = false
              self.maxBrokerageRateDis = true
              self.formData.maxBrokerageRate = '0'
              self.$refs.formData.rules.maxBrokerageRate = [
                // {required: true, trigger: 'blur', message: '请输入平台最大佣金比例！'}
                // {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
              ]
            }
            if (response.data.businessType === '1') {
              self.maxBrokerageRateGo = true
              self.maxBrokerageRateDis = false
              self.formData.maxBrokerageRate = response.data.maxBrokerageRate
            }
          } else {
            self.businessTypeDis = true
            if (response.data.businessType === '2') {
              self.maxBrokerageRateGo = false
              self.maxBrokerageRateDis = true
              self.formData.maxBrokerageRate = '0'
              self.$refs.formData.rules.maxBrokerageRate = [
                // {required: true, trigger: 'blur', message: '请输入平台最大佣金比例！'}
                // {pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/, message: '请输入大于0的数字'}
              ]
            }
            if (response.data.businessType === '1') {
              self.maxBrokerageRateGo = true
              self.maxBrokerageRateDis = false
              self.formData.maxBrokerageRate = response.data.maxBrokerageRate
            }
          }
          response.data.maxBrokerageRate = parseFloat(response.data.maxBrokerageRate / 1000).toString()
          // response.data.maxBrokerageRate = response.data.maxBrokerageRate / 100
          self.formData = response.data
          if (self.formData.auditStatus === '1') {
            self.bankAccountNoDis = true
          }
          let query = {
            pageNo: 1,
            pageSize: 1000,
            parameters: {
              fundAccount: response.data.fundAccount,
              accountSelf: '',
              industryType: '5',
              id: response.data.id
            }
          }
          // 手续费支出账户
          self.$axios.post('/industry/pageListFeeAndAuthAccount', query).then(function (res) {
            self.feeExpenditureAccountAry = []
            res.data.list.forEach(function (e, i) {
              self.feeExpenditureAccountAry.push(e)
            })
            self.feeExpenditureAccountAry.unshift({
              id: '-1',
              name: '自己的账户'
            })
            if (self.feeExpenditureAccountAry) {
              self.accountFeeProfit = false
            }
          })
          let queryShou = {
            pageNo: 1,
            pageSize: 100,
            parameters: {
              fundAccount: response.data.fundAccount,
              accountSelf: '',
              industryType: '4'
            }
          }
          self.$axios.post('/industry/pageList', queryShou).then(function (res) {
            // self.processingFeeIncomeAccountAry = []
            res.data.list.forEach(function (e, i) {
              self.processingFeeIncomeAccountAry.push(e)
            })
            if (self.processingFeeIncomeAccountAry) {
              self.accountFeeProfit = false
            }
          })
          // 判断是否对公打款如果是的话 显示 小额打款支出账户
          if (response.data.needPublicAuthAmt === '1') {
            self.needPublicAuthAmtGo = true
            // 小额打款支出账户
            self.formData.authPaymentAccountId = response.data.authPaymentAccountId
            self.formData.id = response.data.id
            self.authPaymentAccountAry = []
            self.smallQuery.parameters.id = response.data.id
            self.smallQuery.parameters.fundAccount = response.data.fundAccount
            self.$axios.post('/industry/pageListFeeAndAuthAccount', self.smallQuery).then(function (res) {
              res.data.list.forEach(function (e, i) {
                self.authPaymentAccountAry.push(e)
              })
              // debugger
              // self.authPaymentAccountAry = res.data.list
            })
          }
        })
        .catch(function (error) {
          console.log(error)
        })

    },
    handleSubmit () {
      let that = this
      this.formData.payerSubType = this.payerSubTypeList.join(',')
      if (this.formData.openSubSinglePay === '1') {
        if (this.formData.payerSubType.length === 0) {
          that.$Message.error('请选择付款子账户类型')
          return
        }
      }
      this.formData.custNumber = this.formData.custAccountNo
      if (this.formData.businessType === '1') {
        if (this.formData.maxBrokerageRate !== '') {
          this.formData.maxBrokerageRate = (parseFloat(this.formData.maxBrokerageRate * 1000).toFixed(0)).toString()
        }
      }
      if (this.formData.subAccountOpenMax) {
        this.formData.subAccountOpenMax = Number(this.formData.subAccountOpenMax)
      }
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.put('/industry', this.formData).then(function (res) {
            that.$Message.success('编辑代付客户成功')
            that.goBack()
          }).catch(function (res) {
            that.formData.maxBrokerageRate = (parseFloat(that.formData.maxBrokerageRate / 1000).toFixed(0)).toString()
          })
        } else {
          that.formData.maxBrokerageRate = (parseFloat(that.formData.maxBrokerageRate / 1000).toFixed(0)).toString()
          that.$Message.error('请正确填写信息')
        }
      })
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    // 用这个对象
    // this.cityList = cityList
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
    let initParamVal = this.$util.getRefreshInitParam(this, 'editIndustry', this.$route.params.id)
    if (this.industryId !== initParamVal) {
      this.industryId = initParamVal
      this.init()
    }
  }
  // activated() {
  //   if(this.industryId !== this.$route.params.id){
  //     this.industryId = this.$route.params.id
  //     this.init()
  //   }
  // }
}
</script>
