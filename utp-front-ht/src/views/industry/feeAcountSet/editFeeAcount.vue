<style lang="less">
  .footer-border {
    padding: 0;
    border: none;
  }
</style>
<template>
  <card>
    <Form :model="formData" ref="formData" :label-width="120" :rules="ruleValidate">
      <Row>
        <Col span="10" offset="">
          <h4 style="display:inline">编辑功能账户</h4>
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
                <i-select @on-change="orgChange" v-model="formData.orgCode" :label-in-value="true" style="width: 300px"
                          placeholder="请选择机构">
                  <i-option v-for="item in orgAry" :key="item.id" :value="item.orgCode">{{item.fullName}}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="功能账户名称：" prop="name">
                <Input v-model="formData.name" style="width: 300px" placeholder="请输入功能账户名称" :maxlength="nameSize"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="功能账户简称：" prop="simpleName">
                <Input v-model="formData.simpleName" style="width: 300px" placeholder="请输入功能账户简称"
                       :maxlength="nameSize"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="功能账户客户号：" prop="code">
                <Input v-model="formData.code" :disabled="true" style="width: 300px" placeholder="请输入功能账户客户号"
                       :maxlength="12"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="功能账户类型：" prop="industryType">
                <Select v-model="formData.industryType" :disabled="true" style="width: 300px" placeholder="请选择功能账户类型"
                        @on-change="chanStatus">
                  <Option value="4">手续费收益账户</Option>
                  <Option value="5">手续费支出账户</Option>
                  <Option value="6">手续费归集账户</Option>
                  <Option value="10">小额打款支出账户</Option>
                </Select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="选择资金账户：" prop="bankAccountNo">
                <i-select v-model="formData.bankAccountNo" @on-change="custAccountNoChange" :disabled="true"
                          :label-in-value="true" style="width: 300px" placeholder="请选择资金账号">
                  <i-option v-for="item in custAccountNoAry" key="id" :value="item.bankAccountNo">{{item.bankAccountNo}}
                    (户名:{{item.bankAccountName}})
                  </i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="清算行号：" prop="bankCode">
                <Input v-model="formData.bankCode" :disabled="true" style="width: 300px" placeholder="请输入清算行号"
                       :maxlength="12"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="户名：" prop="bankAccountName">
                <Input v-model="formData.bankAccountName" :disabled="true" :maxlength="nameSize" style="width: 300px"
                       placeholder="请输入户名"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="入金通知url：" prop="innerNoticeUrl">
                <Input v-model="formData.innerNoticeUrl" :maxlength="nameSize" style="width: 300px"
                       placeholder="请输入入金通知url"/>
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
  name: 'editFeeAcount',
  data () {
    return {
      orgAry: [],
      feeExpenditureAccountAry: [],
      processingFeeIncomeAccountAry: [],
      industryId: this.$route.params.id,
      userId: null,
      type: null,
      custAccountNoAry: [],
      currentPage: 1,
      roleList: [],
      formData: {
        id: this.industryId,
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
        bankAccountNo: '',
        feeExpenditureAccount: '',
        processingFeeIncomeAccount: ''
      },
      ruleValidate: {
        orgCode: [
          {required: true, trigger: 'blur', message: '请选择机构'}
        ],
        name: [
          {required: true, trigger: 'blur', message: '请输入功能账户名称'}
        ],
        bankAccountNo: [
          {required: true, trigger: 'blur', message: '请选择资金账号'}
        ],
        bankCode: [
          {required: false, trigger: 'blur', message: '请输入清算行号'}
          // {pattern: /^[0-9]*$/, message: '请输入客户账户！'}
        ],
        code: [
          {required: true, trigger: 'blur', message: '请输入功能账户客户号！'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入数字和字母！'}
        ],
        custAccountNo: [
          {required: true, trigger: 'blur', message: '请输入客户账户！'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        custAccountName: [
          {required: false, trigger: 'blur', message: '请输入功能账户户名'}
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
        industryType: [
          {required: true, trigger: 'change', message: '请选择功能账户类型'}
        ]
      },
      tree: [{}],
      // funcModal: false,
      funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init() {
      if (this.industryId) {
        this.getIndustryDetail()
      }
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      let self = this
      // this.$axios.post('/industry/pageList', query).then(function (res) {
      //
      //   res.data.list.forEach(function (e, i) {
      //     if (e.industryType === '4') {
      //       self.feeExpenditureAccountAry.push(e)
      //     }
      //     // self.feeExpenditureAccountAry.push(e)
      //
      //     if (e.industryType === '5') {
      //       self.processingFeeIncomeAccountAry.push(e)
      //     }
      //   })
      //   self.feeExpenditureAccountAry.unshift({
      //     id: '-1',
      //     name: '自己的账户'
      //   })
      //   // self.feeExpenditureAccountAry = res.data.list
      //   // self.processingFeeIncomeAccountAry = res.data.list
      // })
      this.$axios.post('/organization/list', query).then(function (res) {
        self.orgAry = res.data.list
      })
      this.$axios.post('/fundAccount/list', query).then(function (res) {
        self.custAccountNoAry = res.data.list
      })
    },
    orgChange: function (val) {
      this.formData.orgCode = val.value
      this.formData.orgName = val.label
    },
    custAccountNoChange: function (val) {
      let self = this
      let getId = ''
      this.custAccountNoAry.forEach(function (e, i) {
        if (e.bankAccountNo === val.value) {
          getId = e.id
        }
      })
      // this.formData.custAccountNo = val.label
      this.formData.custAccountNo = val.label.split(' ')[0]
      this.formData.custAccountName = val.label.split(' ')[1].split('(')[1].split(')')[0]
      this.$axios.get('/fundAccount/' + getId).then(function (res) {
        self.formData.account = res.data.accountNum
        self.formData.fundAccount = res.data.bankAccountNo
        self.formData.bankAccountName = res.data.bankAccountName
        self.formData.bankCode = res.data.bankCode
      })
    },
    feeExpenditureAccountChange: function (val) {
      this.formData.feeExpenditureAccount = val.toString()
    },
    processingFeeIncomeAccountChange: function (val) {
      this.formData.processingFeeIncomeAccount = val
    },
    getIndustryDetail: function () {
      let self = this
      this.$axios.get('/industry/' + this.industryId, {params: {exImage: 'exImage'}})
        .then(function (response) {
          self.formData = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    provinceChange: function (val) {
      var provinceId = val
      this.formData.provinceCode = val
      // this.getCity = '请选择城市'
      this.formData.cityCode = ''
      var that = this
      that.disCity = false
      that.disCounty = false
      this.provinceAry.forEach(function (e, i) {
        if (provinceId === e.id) {
          if (e.city.length > 0) {
            that.disCity = true
            that.cityAry = e.city
          } else {
            that.disCounty = true
            that.countyAry = e.city.county
            that.formData.countyCode = ''
          }
        }
      })
    },
    cityChange: function (val) {
      var cityId = val
      var that = this
      this.formData.cityCode = val
      this.formData.countyCode = ''
      this.cityAry.forEach(function (e, i) {
        if (cityId === e.id) {
          that.disCounty = true
          that.countyAry = e.county
          // that.countyChange(e.county[0].id)
        }
      })
    },
    countyChange: function (val) {
      this.formData.countyCode = val
    },
    chanStatus(val) {
      this.formData.industryType = val
    },
    handleSubmit() {
      let that = this
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.put('/industry', this.formData).then(function (res) {
            that.$Message.success('修改功能账户成功')
            that.goBack()
          })
        } else {
          that.$Message.error('请正确填写信息')
        }
      })
    },
    goBack() {
      this.$util.goBack(this)
    }
  },
  created() {
    // 用这个对象
    this.init()
  },
  mounted() {
  },
  computed: {
    headers() {
      if (!this.$store.state.app.token) {
        this.$store.commit('setToken', localStorage.getItem('token'))
      }
      return {
        'X-Requested-With': 'XMLHttpRequest',
        'X-Authorization': 'Bearer ' + this.$store.state.app.token
      }
    },
    nameSize() {
      return this.$contants.pageSet.nameSize
    },
    accountSize() {
      return this.$contants.pageSet.accountSize
    }
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'editFeeAcount', this.$route.params.id)
    if (this.industryId !== initParamVal) {
      this.industryId = initParamVal
      this.init()
    }
  }
}
</script>
