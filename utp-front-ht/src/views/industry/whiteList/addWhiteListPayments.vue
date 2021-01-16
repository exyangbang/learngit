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
                <Input v-model="formDataNew.industryCode"  style="width:350px" placeholder="请输入出款户名" :maxlength="nameSize"  />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="收款方户名：" prop="receiverName">
                <Input v-model="formDataNew.receiverName"  style="width:350px" placeholder="请输入出款方户名" :maxlength="nameSize"  />
              </FormItem>
            </Col>
          <Col span="12">
            <FormItem label="收款方账号：" prop="receiverAccount">
              <Input v-model="formDataNew.receiverAccount"  style="width:350px" placeholder="请输入收款方账号" :maxlength="nameSize"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="生效日期：" prop="beginDate">
              <DatePicker :options="beginDateOption" v-model="formDataNew.beginDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择生效日期" @on-change="beginDateChange"></DatePicker>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="失效日期：" prop="endDate">
              <DatePicker :options="beginDateOption" v-model="formDataNew.endDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择生效日期" @on-change="endDateChange"></DatePicker>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="单日金额限额：" prop="oneDayTradingQuota">
              <Input v-model="formDataNew.oneDayTradingQuota"  style="width:350px" placeholder="请输入单日金额限额" :maxlength="nameSize"  />
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
  name: "addWhiteListPayments",
  data () {
    return {
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
        oneDayTradingQuota: '',
        beginDate: '',
        endDate: '',
        receiverName: '',
        receiverAccount: '',
        industryCode: ''
      },
      ruleValidate: {
        industryCode: [
          {required: true, trigger: 'blur', message: '请选择客户号'}
        ],
        receiverName: [
          {required: true, trigger: 'blur', message: '请输入收款方户名'}
        ],
        receiverAccount: [
          {required: true, trigger: 'blur', message: '请输入收款方账号'}
        ],
        beginDate: [
          {required: true, trigger: 'blur', message: '请选择生效日期'}
         ],
        endDate: [
          {required: true, trigger: 'blur', message: '请选择失效日期'}
        ],
        oneDayTradingQuota: [
          {required: true, trigger: 'blur', message: '请输入单日金额限额'}
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],
      beginDateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000
        }
      },
      endDateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000
        }
      },
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

      query.parameters.industryType = '1'
      let that = this
      this.$axios.post('industry/pageList', query).then(function (res) {
        that.industryCodeAry = res.data.list
      })
    },
    beginDateChange (value) {
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() < dateGet.valueOf() - 86400000)
        }
      }
      this.formDataNew.beginDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
    },
    endDateChange (value) {
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf() - 86400000)
        }
      }
      this.formDataNew.endDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
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
    // industryCodeChange: function (val) {
    //   this.merName = val.label
    //   this.formDataNew.industryCode = val.value
    // },
    handleSubmit () {
      let that = this
      if (this.formDataNew.oneDayTradingQuota) {
        this.formDataNew.oneDayTradingQuota = (this.formDataNew.oneDayTradingQuota * 100).toString()
      }
      this.formDataNew.operationType = '0'
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          this.$axios.post('/whiteListPaymentsAudit', this.formDataNew).then(function (res) {
            that.$Message.success('添加出款账户白名单成功')
            that.goBack()
          }).catch(function () {
            that.formDataNew = {}
          })
        } else {
          that.$Message.error('请正确填写信息')
          that.formDataNew = {}
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
