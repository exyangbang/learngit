<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form :label-width="150">
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">功能账户详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="24">
          <Col span="12">
            <FormItem label="所属机构："  prop="orgName">
              <span> {{ formData.orgName }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费账户名称：" prop="name">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.name }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费账户简称：" prop="simpleName">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.simpleName }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="客户号：" prop="code">
              <span> {{ formData.code }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="清算行号："  prop="bankCode">
              <span> {{ formData.bankCode }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="资金账号：" prop="countyCode">
              <span> {{ formData.custAccountNo }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="户名：" prop="custAccountName">
              <span> {{ formData.custAccountName }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="入金通知url：" prop="innerNoticeUrl">
              <span> {{ formData.innerNoticeUrl }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费账户类型：" prop="innerNoticeUrl">
              <span> {{ formData.industryType }}</span>
            </FormItem>
          </Col>
        </Col>
      </Row>
      <Row>
      </Row>
    </Form>
  </card>
</template>
<script>
export default {
  name: 'feeAcountDetail',
  data () {
    return {
      id: this.$route.params.id,
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
    init () {
      if (this.id) {
        this.getOrganizationDetail()
      }
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('/industry/' + this.id, {params: {exImage: 'exImage'}})
        .then(function (response) {
          if (response.data.industryType === '4') {
            response.data.industryType = '手续费收益账户'
          }
          if (response.data.industryType === '5') {
            response.data.industryType = '手续费支出账户'
          }
          if (response.data.industryType === '6') {
            response.data.industryType = '手续费归集账户'
          }
          if (response.data.industryType === '10') {
            response.data.industryType = '小额打款支出账户'
          }
          self.formData = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    this.init()
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'feeAcountDetail', this.$route.params.id)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.init()
    }
  },
  computed: {
  },
  mounted () {
  }
}
</script>
