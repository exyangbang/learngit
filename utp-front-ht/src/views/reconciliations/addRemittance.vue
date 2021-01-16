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
          <h4 style="display:inline">新增退汇</h4>
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
              <FormItem label="服务端流水号：" prop="serverTransId">
                <Input v-model="formData.serverTransId" style="width: 300px;" placeholder="请输入服务端流水号" :maxlength="accountSize" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="交易日期：" prop="transDate">
                <Date-picker type="date" v-model="transDate" :editable="false" placeholder="请选择交易日期" format="yyyyMMdd" @on-change="transDateChange" style="width: 200px"></Date-picker>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="清算日期：" prop="reconcileDate">
                <Date-picker type="date" v-model="reconcileDate" :editable="false" placeholder="请选择清算日期" format="yyyyMMdd" @on-change="reconcileDateChange" style="width: 200px"></Date-picker>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="收款方户名：" prop="payeeName">
                <Input v-model="formData.payeeName" style="width: 300px;" placeholder="请输入收款方户名" :maxlength="nameSize" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="收款方账号：" prop="payeeAcctNo">
                <Input v-model="formData.payeeAcctNo" style="width: 300px;" placeholder="请输入收款方账号" :maxlength="accountSize" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="交易金额：" prop="realAmount">
                <Input v-model="formData.realAmount" style="width: 300px;" placeholder="请输入交易金额" :maxlength="20" />
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
  name: "addRemittance",
  data () {
    return {
      idStartData: {},
      idEndData: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000
        }
      },
      setupStartData: {},
      setupEndData: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000
        }
      },
      currentPage: 1,
      roleList: [],
      formData: {
        serverTransId: '',
        transDate: '',
        reconcileDate: '',
        payeeAcctNo: '',
        payeeName: '',
        realAmount: ''
      },
      realAmount: '',
      ruleValidate: {
        serverTransId: [
          {required: true, trigger: 'blur', message: '请输入服务端流水号'},
          {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字！'}
        ],
        transDate: [
          {required: true, trigger: 'blur', message: '请选择交易日期！'}
        ],
        reconcileDate: [
          {required: true, trigger: 'blur', message: '请选择清算日期'}
        ],
        payeeAcctNo: [
          {required: true, trigger: 'blur', message: '请输入收款方账号！'}
        ],
        payeeName: [
          {required: true, trigger: 'blur', message: '请输收款方户名！'}
        ],
        realAmount: [
          {required: true, trigger: 'blur', message: '请输入交易金额！'}
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],
      provinceAry: [],
      cityAry: [],
      countyAry: [],
      disCity: false,
      disCounty: false,
      // funcModal: false,
      funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init () {
      // this.provinceAry = this.cityList.China.province
      // if (this.organizationId) {
      //   this.getOrganizationDetail()
      // }
    },
    transDateChange (value) {
      this.formData.transDate = value
    },
    reconcileDateChange (val) {
      this.formData.reconcileDate = val
    },
    handleSubmit () {
      let that = this
      if (this.formData.realAmount.indexOf('.') > 0) {
        if (this.formData.realAmount.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formData.realAmount = ''
          return false
        } else {
          this.formData.realAmount = (this.formData.realAmount * 100).toFixed(0).toString()
        }
      } else {
        if (that.formData.realAmount !== '0' && that.formData.realAmount !== '') {
          this.formData.realAmount = (this.formData.realAmount * 100).toFixed(0).toString()
        }

      }

      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.post('/transReexchange', this.formData).then(function (res) {
            that.$Message.success('添加退汇成功')
            that.goBack()
          }).catch(function (err) {
            that.formData.realAmount = (that.formData.realAmount / 100).toString()
          })
        } else {
          if (that.formData.realAmount !== '0' && that.formData.realAmount !== '') {
            that.formData.realAmount = (that.formData.realAmount / 100).toString()
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
