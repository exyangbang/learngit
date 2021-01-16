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
          <h4 style="display:inline">添加功能账户</h4>
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
              <i-select @on-change="orgChange" :label-in-value = "true" style="width: 300px" placeholder="请选择机构">
                <i-option v-for="item in orgAry" key="id" :value="item.orgCode">{{item.fullName}}</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="功能账户名称：" prop="name">
              <Input v-model="formData.name" style="width: 300px" placeholder="请输入功能账户名称" :maxlength="nameSize" />
            </FormItem>
          </Col>
          </row>
          <row>
          <Col span="12">
            <FormItem label="功能账户简称：" prop="simpleName">
              <Input v-model="formData.simpleName" style="width: 300px" placeholder="请输入功能账户简称" :maxlength="nameSize" />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="功能账户客户号：" prop="code">
              <Input v-model="formData.code" style="width: 300px" placeholder="请输入功能账户客户号" :maxlength="12" />
            </FormItem>
          </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="功能账户类型：" prop="industryType">
                <Select v-model="formData.industryType" style="width: 300px" placeholder="请选择功能账户类型"  @on-change="chanStatus">
                  <Option value="4">手续费收益账户</Option>
                  <Option value="5">手续费支出账户</Option>
                  <Option value="6">手续费归集账户</Option>
                  <Option value="10">小额打款支出账户</Option>
                </Select>
              </FormItem>
            </Col>
          <Col span="12">
            <FormItem label="选择资金账户：" prop="bankAccountNo">
              <i-select v-model="formData.bankAccountNo" @on-change="custAccountNoChange" :label-in-value = "true" style="width: 300px" placeholder="请选择资金账户">
                <i-option v-for="item in custAccountNoAry" key="id" :value="item.id">{{item.bankAccountNo}} (户名:{{item.bankAccountName}})</i-option>
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
          </row>
          <row>

          <Col span="12">
            <FormItem label="入金通知url：" prop="innerNoticeUrl">
              <Input v-model="formData.innerNoticeUrl" :maxlength="nameSize" style="width: 300px" placeholder="请输入入金通知url"/>
            </FormItem>
          </Col>
          </row>
          <row>

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
  name: "addFeeAcount",
  data () {
    return {
      orgAry: [],
      custAccountNoAry: [],
      userId: null,
      type: null,
      currentPage: 1,
      roleList: [],
      feeAccountAry: [],
      feeGetAccountAry: [],
      formData: {
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
        industryType: ''
      },
      ruleValidate: {
        orgCode: [
          {required: true, trigger: 'change', message: '请选择机构'}
        ],
        name: [
          {required: true, trigger: 'blur', message: '请输入功能账户名称'}
        ],
        bankAccountNo: [
          {required: true, trigger: 'change', message: '请选择资金账户'}
        ],
        bankCode: [
          {required: false, trigger: 'blur', message: '请输入清算行号'}
          // {pattern: /^[0-9]*$/, message: '请输入客户账户！'}
        ],
        code: [
          {required: true, trigger: 'blur', message: '请输入功能账户客户号'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入数字和字母'}
        ],
        custAccountNo: [
          {required: true, trigger: 'blur', message: '请输入客户账户'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字'}
        ],
        custAccountName: [
          {required: false, trigger: 'blur', message: '请输入功能账户户名'}
        ],
        innerNoticeUrl: [
          {required: true, trigger: 'blur', message: '请输入入金通知url'}
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
    init () {
      // this.provinceAry = this.cityList.China.province
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      let self = this
      this.$axios.post('/organization/list', query).then(function (res) {
        self.orgAry = res.data.list
      })
      // this.$axios.post('/fundAccount/list', query).then(function (res) {
      //   self.custAccountNoAry = res.data.list
      // })
    },
    chanStatus (val) {
      this.formData.bankAccountNo = ''
      this.formData.industryType = val
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      if (val === '6') {
        query.parameters.useType = 1
        let self = this
        this.$axios.post('/fundAccountScreen/list', query).then(function (res) {
          self.custAccountNoAry = res.data.list
        })
      } else {
        query.parameters.useType = 0
        let self = this
        this.$axios.post('/fundAccount/list', query).then(function (res) {
          self.custAccountNoAry = res.data.list
        })
      }
    },
    orgChange: function (val) {
      this.formData.orgCode = val.value
      this.formData.orgName = val.label
    },
    custAccountNoChange: function (val) {
      let self = this
      // this.formData.custAccountNo = val.label
      this.formData.custAccountNo = val.label.split(' ')[0]
      this.formData.custAccountName = val.label.split(' ')[1].split('(')[1].split(')')[0].split(':')[1]
      this.$axios.get('/fundAccount/' + val.value).then(function (res) {
        self.formData.account = ''
        self.formData.fundAccount = ''
        self.formData.bankAccountName = ''
        self.formData.bankCode = ''
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
    handleSubmit () {
      let that = this
      this.formData.custNumber = this.formData.custAccountNo
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.post('/industry', this.formData).then(function (res) {
            that.$Message.success('添加功能账户成功')
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
  }
}
</script>
