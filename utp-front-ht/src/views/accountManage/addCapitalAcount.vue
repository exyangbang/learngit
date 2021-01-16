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
              <FormItem label="资金账号：" prop="bankAccountNo">
                <Input v-model="formDataNew.bankAccountNo"  style="width:350px" placeholder="请输入资金账号" :maxlength="accountSize"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="户名：" prop="bankAccountName">
              <Input v-model="formDataNew.bankAccountName"  style="width:350px" placeholder="请输入户名" :maxlength="nameSize"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="清算行号：" prop="bankCode">
              <Input v-model="formDataNew.bankCode"  style="width:350px" placeholder="请输入清算行号" :maxlength="12"  />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="资金账号类型：" prop="accountType">
              <i-select v-model="formDataNew.accountType"  style="width:300px" @on-change="accountTypeChange" placeholder="请选择资金账号类型">
                <i-option value="2">一般户</i-option>
                <i-option value="1">内部户</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="账户用途：" prop="useType">
              <i-select v-model="formDataNew.useType"  style="width:300px" @on-change="useTypeChange" placeholder="请选择使用类型">
                <i-option value="0">代付分账</i-option>
                <i-option value="1">手续费归集</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="是否共享资金账户：" prop="shareFlag">
              <i-select v-model="formDataNew.shareFlag"  style="width:300px" @on-change="shareFlagChange" placeholder="请选择是否与其他系统共享实体账户">
                <i-option value="0">否</i-option>
                <i-option value="1">是</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="是否报送反洗钱：" prop="reportAmlFlag">
              <i-select v-model="formDataNew.reportAmlFlag"  style="width:300px" placeholder="请选择是否是否报送反洗钱">
                <i-option value="0">否</i-option>
                <i-option value="1">是</i-option>
              </i-select>
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
  name: "addCapitalAcount",
  data () {
    return {
      funcModalShow: false, // 用来更新数据
      formDataNew: {
        bankAccountNo: '',
        bankAccountName: '',
        bankCode: '',
        useType: '0',
        shareFlag: '0',
        reportAmlFlag: '0'
      },
      ruleValidate: {
        bankAccountNo: [
          {required: true, trigger: 'blur', message: '请输入资金账号'}
        ],
        bankAccountName: [
          {required: true, trigger: 'blur', message: '请输入户名'}
        ],
        bankCode: [
          {required: true, trigger: 'blur', message: '请输入清算行号'}
        ],
        accountType: [
          {required: true, trigger: 'blur', message: '请选择资金账号类型'}
        ],
        useType: [
          {required: true, trigger: 'blur', message: '请选择使用类型'}
        ],
        reportAmlFlag: [
          {required: true, trigger: 'blur', message: '请选择是否报送反洗钱'}
        ]
      }
    }
  },
  methods: {
    init () {
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      let that = this
      this.$axios.post('/industry/list', query).then(function (res) {
        that.industryCodeAry = res.data
      })
    },
    handleSubmit () {
      let that = this
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          this.$axios.post('/fundAccount', this.formDataNew).then(function (res) {
            that.$Message.success('新增资金账户成功')
            that.goBack()
          })
        } else {
          that.$Message.error('请正确填写信息')
        }
      })
    },
    useTypeChange (val) {
      this.formDataNew.useType = val
    },
    shareFlagChange (val) {
      this.formDataNew.shareFlag = val
    },
    accountTypeChange (val) {
      this.formDataNew.accountType = val
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
