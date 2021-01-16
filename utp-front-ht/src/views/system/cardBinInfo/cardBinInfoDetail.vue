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
          <h4 style="display:inline">任务详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <row>
        <Col span="12">
          <FormItem label="卡BIN号：" prop="binnum">
            <span style="width: 80%; word-wrap: break-word"> {{formData.binnum}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="所属行行名称：" prop="bankname">
            <span style="width: 80%; word-wrap: break-word"> {{formData.bankname}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="所属行行号：" prop="bankcode">
            <span style="width: 80%; word-wrap: break-word"> {{formData.bankcode}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="所属行分类标识：" prop="banktypeflag">
            <span style="width: 80%; word-wrap: break-word"> {{formData.banktypeflag}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="卡BIN长度：" prop="binlen">
            <span style="width: 80%; word-wrap: break-word"> {{formData.binlen}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="卡BIN起始字节：" prop="binstartpos">
            <span style="width: 80%; word-wrap: break-word"> {{formData.binstartpos}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="主账号长度：" prop="cardnolen">
            <span style="width: 80%; word-wrap: break-word"> {{formData.cardnolen}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="主账号起始字节：" prop="cardnostartPos">
            <span style="width: 80%; word-wrap: break-word"> {{formData.cardnostartPos}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="人行清算行行名：" prop="clearbankname">
            <span style="width: 80%; word-wrap: break-word"> {{formData.clearbankname}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="人行清算行行号：" prop="clearbankno">
            <span style="width: 80%; word-wrap: break-word"> {{formData.clearbankno}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="是否银联卡品牌：" prop="cuplogoflag">
            <span style="width: 80%; word-wrap: break-word"> {{formData.cuplogoflag}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="卡种：" prop="debitcreditflag">
            <span style="width: 80%; word-wrap: break-word"> {{formData.debitcreditflag}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="发卡行机构代码：" prop="issuercode">
            <span style="width: 80%; word-wrap: break-word"> {{formData.issuercode}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="发卡机构名称：" prop="issuername">
            <span style="width: 80%; word-wrap: break-word"> {{formData.issuername}} </span>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="状态：" prop="status">
            <span style="width: 80%; word-wrap: break-word"> {{formData.status}} </span>
          </FormItem>
        </Col>
      </row>
      <Row>
      </Row>
    </Form>
  </card>
</template>
<script>
export default {
  name: 'cardBinInfoDetail',
  data () {
    return {
      id: this.$route.params.id,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {}
    }
  },
  methods: {
    init () {
      if (this.id) {
        this.getCardBinInfoDetail()
      }
    },
    getCardBinInfoDetail () {
      let self = this
      this.$axios.get('cardBinInfo' + '/' + this.id)
        .then(function (response) {
          if (response.data.debitcreditflag === 'D') {
            response.data.debitcreditflag = '借记卡'
          }
          if (response.data.debitcreditflag === 'C') {
            response.data.debitcreditflag = '贷记卡'
          }
          if (response.data.debitcreditflag === 'Z') {
            response.data.debitcreditflag = '准贷记卡'
          }
          if (response.data.debitcreditflag === 'Y') {
            response.data.debitcreditflag = '预付卡'
          }
          if (response.data.banktypeflag === '0') {
            response.data.banktypeflag = '一般银行'
          }
          if (response.data.banktypeflag === '1') {
            response.data.banktypeflag = '村镇银行'
          }
          if (response.data.banktypeflag === '2') {
            response.data.banktypeflag = '港澳外资银行'
          }
          if (response.data.cuplogoflag === '0') {
            response.data.cuplogoflag = '否'
          }
          if (response.data.cuplogoflag === '1') {
            response.data.cuplogoflag = '是'
          }
          if (response.data.status === '0') {
            response.data.status = '禁用'
          }
          if (response.data.status === '1') {
            response.data.status = '启用'
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
  computed: {
  },
  mounted () {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'cardBinInfoDetail', this.$route.params.id)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.init()
    }
  }
}
</script>
