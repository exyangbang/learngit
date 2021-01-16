<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form  :model="formData"  ref="formData" :label-width="120" :rules="ruleValidate">
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
          <Col span="12">
            <FormItem label="选择机构：" prop="orgCode">
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
          <Col span="12">
            <FormItem label="客户简称：" prop="simpleName">
              <Input v-model="formData.simpleName" style="width: 300px" placeholder="请输入客户简称" :maxlength="nameSize" />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="客户号：" prop="code">
              <Input v-model="formData.code" style="width: 300px" placeholder="请输入客户号" :maxlength="12" />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="资金账号：" prop="bankAccountNo">
              <i-select v-model="formData.bankAccountNo" @on-change="custAccountNoChange" :label-in-value = "true" style="width: 300px" placeholder="请选择资金账号">
                <i-option v-for="item in custAccountNoAry" key="id" :value="item.bankAccountNo">{{item.id}} (户名:{{item.bankAccountNo}})</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="清算行号：" prop="bankCode">
              <Input v-model="formData.bankCode" :disabled="true" style="width: 300px" placeholder="请输入清算行号" :maxlength="12" />
            </FormItem>
          </Col>
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
          <Col span="12">
            <FormItem label="手续费支出账户：" prop="feeExpenditureAccount">
              <i-select v-model="formData.feeExpenditureAccount" style="width:300px" @on-change="feeExpenditureAccountChange" placeholder="请选择手续费支出账户">
                <i-option v-for="item in feeExpenditureAccountAry"  :key="item.id" :value="item.id">{{ item.name }}</i-option>
              </i-select>
            </FormItem>
          </Col>

          <Col span="12">
            <FormItem label="手续费收益账户：" prop="processingFeeIncomeAccount">
              <i-select v-model="formData.processingFeeIncomeAccount"  style="width:300px" @on-change="processingFeeIncomeAccountChange" placeholder="请选择手续费收益账户">
                <i-option v-for="item in processingFeeIncomeAccountAry"  key="id" :value="item.id">{{ item.name }}</i-option>
              </i-select>
            </FormItem>
          </Col>
          <FormItem label="二级账户是否对外接款：" prop="whetherExternal">
            <i-select v-model="formData.whetherExternal"  style="width:300px" @on-change="whetherExternalChange" placeholder="请选择是否对外接款">
              <i-option value="1">是</i-option>
              <i-option value="0">否</i-option>
            </i-select>
          </FormItem>
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
  data () {
    return {
      orgAry: [],
      feeExpenditureAccountAry: [],
      processingFeeIncomeAccountAry: [],
      inductryId: this.$route.params.id,
      userId: null,
      type: null,
      custAccountNoAry: [],
      currentPage: 1,
      roleList: [],
      query: {
        pageNo: 1,
        pageSize: 100,
        parameters: {
          fundAccount: '',
          accountSelf: '',
          industryType: '5'
        }
      },
      formData: {
        id: this.inductryId,
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
        processingFeeIncomeAccount: '',
        whetherExternal: ''
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
        whetherExternal: [
          {required: true, trigger: 'change', message: '请选择是否对外接款'}
        ]
      },
      tree: [{}],
      // funcModal: false,
      funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init () {
      if (this.inductryId) {
        this.getIndustryDetail()
      }
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {

        }
      }
      let self = this
      this.$axios.post('/industry/list', query).then(function (res) {
        self.feeExpenditureAccountAry = []
        res.data.forEach(function (e, i) {
          if (e.industryType === '4') {
            self.feeExpenditureAccountAry.push(e)
          }
          if (e.industryType === '5') {
            self.processingFeeIncomeAccountAry.push(e)
          }
        })
        self.feeExpenditureAccountAry.unshift({
          id: '-1',
          name: '自己的账户'
        })

      })
      this.$axios.post('/organization/list', query).then(function (res) {
        self.orgAry = res.data.list
      })
      this.$axios.post('/fundAccount/list', query).then(function (res) {
        self.custAccountNoAry = res.data.list
      })
    },
    custAccountNoChange: function (val) {
      let self = this
      let idNew = val.label.split(':')[0].split('(')[0]
      this.formData.custAccountNo = val.value
      this.$axios.get('/fundAccount/' + idNew).then(function (res) {
        self.formData.account = res.data.accountNum
        self.formData.fundAccount = res.data.bankAccountNo
        self.formData.bankAccountName = res.data.bankAccountName
        self.formData.bankCode = res.data.bankCode
        if (self.query.parameters.fundAccount) {
          self.query.parameters.fundAccount = self.formData.fundAccount
          self.$axios.post('/industry/pageList', self.query).then(function (res) {
            self.processingFeeIncomeAccountAry = []
            res.data.list.forEach(function (e, i) {
              self.processingFeeIncomeAccountAry.push(e)
            })
            if (self.processingFeeIncomeAccountAry) {
              self.accountFeeProfit = false
            }
          })
        }
      })
    },
    feeExpenditureAccountChange: function (val) {
      let self = this
      this.formData.feeExpenditureAccount = val.toString()
      if (this.formData.feeExpenditureAccount === '-1') {
        this.query.parameters.fundAccount = this.formData.fundAccount
        this.query.parameters.accountSelf = '-1'
      } else {
        this.query.parameters.fundAccount = this.formData.feeExpenditureAccount
        this.query.parameters.accountSelf = '1'
      }
      this.$axios.post('/industry/pageList', this.query).then(function (res) {
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
    },
    getIndustryDetail: function () {
      let self = this
      this.$axios.get('/industry/' + this.inductryId)
        .then(function (response) {
          self.formData = response.data
          // if (!response.data.provinceCode) {
          //   self.getProvince = '请选择省份'
          // }
          // self.provinceAry.forEach(function (e, i) {
          //   let that = self
          //   if (e.id === response.data.provinceCode) {
          //     that.getProvince = e.name
          //     if (response.data.cityCode && response.data.cityCode !== '0') {
          //       that.disCity = true
          //       that.cityAry = that.provinceAry[i].city
          //       that.provinceAry[i].city.forEach(function (e, i) {
          //         if (e.id === response.data.cityCode) {
          //           that.disCounty = true
          //           that.getCity = e.name
          //           that.countyAry = e.county
          //           e.county.forEach(function (e, i) {
          //             if (response.data.countyCode === e.id) {
          //               that.getCounty = e.name
          //             }
          //           })
          //         }
          //       })
          //     } else {
          //       that.disCounty = true
          //       that.countyAry = that.provinceAry[i].city.county
          //       that.provinceAry[i].city.county.forEach(function (e, i) {
          //         if (response.data.countyCode === e.id) {
          //           that.getCounty = e.name
          //         }
          //       })
          //     }
          //   }
          // })
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
    handleSubmit () {
      let that = this
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.put('/industry', this.formData).then(function (res) {
            that.$Message.success('修改客户成功')
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
    // 用这个对象
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
