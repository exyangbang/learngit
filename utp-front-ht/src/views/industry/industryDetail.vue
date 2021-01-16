<style lang="less">
  .footer-border {
    padding: 0;
    border: none;
  }
</style>
<template>
  <card>
    <Form :label-width="150">
      <Row>
        <Col span="10" offset="">
          <h4 style="display:inline">客户详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="24">
          <Col span="12">
            <FormItem label="所属机构：" prop="orgName">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.orgName }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="客户名称：" prop="name">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.name }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="客户简称：" prop="simpleName">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.simpleName }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="客户号：" prop="code">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.code }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="清算行号：" prop="bankCode">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.bankCode }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="资金账号：" prop="countyCode">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.custAccountNo }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="户名：" prop="bankAccountName">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.bankAccountName }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="入金通知url：" prop="innerNoticeUrl">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.innerNoticeUrl }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费支出账户：" prop="feeExpenditureAccount">
              <span> {{ formData.feeExpenditureAccountName }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费收益账户：" prop="processingFeeIncomeAccount">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.processingFeeIncomeAccountName }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="二级账户是否对外接款：" prop="whetherExternal">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.whetherExternal == '1' ? '是' : '否' }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="开通业务：" prop="businessType">
              <span
                style="width: 80%; word-wrap: break-word"> {{ formData.businessType == '2' ? '代付业务' : '分账业务' }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="证书DN：" prop="dn">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.dn }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="鉴权方式：" prop="authenticationMode">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.authenticationMode=='3'? '三要素认证' : '四要素认证' }}</span>
            </FormItem>
          </Col>
          <Col span="12" v-if="formData.businessType != '2'">
            <FormItem label="平台最大佣金比例：" prop="maxBrokerageRate">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.maxBrokerageRate / 1000}}%</span>
            </FormItem>
          </Col>
          <Col span="12" v-if="formData.businessType != '2'">
            <FormItem label="是否开通双账户：" prop="isOpneDoubleAcc">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.isOpneDoubleAcc=='1'? '是' : '否' }}</span>
            </FormItem>
          </Col>
          <Col span="12" v-if="formData.businessType != '2'">
            <FormItem label="是否开通余额支付：" prop="isOpneBalancePay">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.isOpneBalancePay=='1'? '是' : '否' }}</span>
            </FormItem>
          </Col>
          <Col span="12" v-if="formData.isOpneBalancePay != '2'">
            <FormItem label="余额支付账期：" prop="balancePayPeriod">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.balancePayPeriod }}</span>
            </FormItem>
          </Col>
        </Col>
      </Row>
      <Row>
      </Row>
    </Form>
  </card>
</template>
<script>import cityList from '../../libs/content'

export default {
  name: 'industryDetail',
  data() {
    return {
      industryId: this.$route.params.id,
      danWei: '',
      currentPage: 1,
      roleList: [],
      formData: {},
      provinceAry: [],
      cityAry: [],
      disCity: false,
      disCounty: false
    }
  },
methods: {
    init() {
      this.provinceAry = this.cityList.China.province
      if (this.industryId) {
        this.getOrganizationDetail()
      }
    },
    getOrganizationDetail() {
      let self = this
      this.$axios.get('/industry/' + this.industryId)
        .then(function (response) {
          if (response.data.feeExpenditureAccount === '-1') {
            response.data.feeExpenditureAccountName = '自己的账户'
          }
          self.formData = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
  goBack() {
      this.$util.goBack(this)
  }
},
  created() {
    this.cityList = cityList
    this.init()
  },
  computed: {},
  mounted() {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'industryDetail', this.$route.params.id)
    if (this.industryId !== initParamVal) {
      this.industryId = initParamVal
      this.init()
    }
  }
}
</script>
