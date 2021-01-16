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
            <FormItem label="类型：" prop="objType">
              <i-select v-model="formDataNew.objType"  style="width:350px" @on-change="objTypeChange" placeholder="请选择类型">
                <i-option value="1">个人</i-option>
                <i-option value="2">企业</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12" v-if="objTypeGr">
            <FormItem label="姓名：" prop="name">
              <Input v-model="formDataNew.name" style="width:350px" placeholder="请输入姓名" :maxlength="100"  />
            </FormItem>
          </Col>
          <Col span="12" v-if="objTypeGr">
            <FormItem label="身份证号：" prop="idCode">
              <Input v-model="formDataNew.idCode" style="width:350px" :maxlength="18" placeholder="请输入身份证号" />
            </FormItem>
          </Col>
          <Col span="12" v-if="objTypeQy">
            <FormItem label="企业名称：" prop="entName">
              <Input v-model="formDataNew.entName" style="width:350px" placeholder="请输入企业名称" :maxlength="200"  />
            </FormItem>
          </Col>
          <Col span="12" v-if="objTypeQy">
            <FormItem label="营业执照编号：" prop="busLicCode">
              <Input v-model="formDataNew.busLicCode" style="width:350px" :maxlength="32" placeholder="请输入营业执照编号" />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="备注：" prop="remark">
              <Input v-model="formDataNew.remark"  style="width:350px" placeholder="请输入备注" :maxlength="1000"  />
            </FormItem>
          </Col>
        </Col>
      </row>
      <Row>
        <Col span="10" offset="2">
          <FormItem>
            <Button v-if="canSave" type="primary" @click="handleSubmit()">提交</Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
  </card>
</template>
<script>
export default {
  name: "addblacklist",
  data () {
    return {
      canSave: true,
      objTypeGr: true,
      objTypeQy: false,
      // name: '',
      // busLicCode: '',
      // remark: '',
      funcModal: false,
      // id: this.$route.params.industryCode,
      funcModalShow: false, // 用来更新数据
      formDataNew: {
        idCode: '',
        entName: '',
        objType: '1',
        name: '',
        busLicCode: '',
        remark: ''
      },
      ruleValidate: {
        objType: [
          {required: true, trigger: 'change', message: '请选择类型'}
        ],
        name: [
          {required: true, trigger: 'change', message: '请输入姓名'}
        ],
        idCode: [
          {required: true, trigger: 'change', message: '请输入身份证号'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字'}
        ],
        entName: [
          {required: false, trigger: 'change', message: '请输入企业名称'}
        ],
        busLicCode: [
          {required: false, trigger: 'change', message: '请输入营业执照编号'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字'}
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}]
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

      // query.parameters.industryType = '1'
      let that = this
      this.$axios.post('/industry/industryListOnlyAccountSplittingBusiness', query).then(function (res) {
        that.industryCodeAry = res.data.list
      })
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
    industryCodeChange: function (val) {

      let that = this
      // this.merName = val.label
      // this.formDataNew.industryCode = val.value
      let query = {
        parameters: {industryCode: val.value},
        pageNo: 1,
        pageSize: 100
      }
      that.subAccountArry = []
      that.formDataNew.subAccount = ''
      that.formDataNew.subObjName = ''
      this.$axios.post('/merchantInfo/listUnUserType', query).then(function (res) {
        that.subAccountArry = res.data.list
      })
    },
    subAccountChange: function (val) {
      let that = this
      // this.formDataNew.subObjName = val.value
      this.formDataNew.subAccount = val
      this.subAccountArry.forEach(function (e, i) {
        if (e.account === val) {
          that.formDataNew.subObjName = e.realName
        }
      })
    },
    channelNameChange: function (value) {
      this.formDataNew.channelName = value.label
      // this.setChannelName(value.label)
      this.formDataNew.channelKey = value.value
    },
    subaccountsIndividualAmtBlure: function () {
      if (this.formDataNew.subaccountsIndividualAmt.indexOf('.') > 0) {
        if (this.formDataNew.subaccountsIndividualAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.subaccountsIndividualAmt = ''
          return false
        }
      }
    },
    privateIndividualQuotaBlure: function () {
      if (this.formDataNew.subaccountsDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.subaccountsDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.subaccountsDateAmt = ''
          return false
        }
      }
    },
    unitIndividualAmtBlure: function () {
      if (this.formDataNew.nitIndividualAmt.indexOf('.') > 0) {
        if (this.formDataNew.nitIndividualAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.nitIndividualAmt = ''
          return false
        }
      }
    },
    industryDateAmtBlure: function () {
      if (this.formDataNew.industryDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.industryDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.industryDateAmt = ''
          return false
        }
      }
    },
    // subaccountsIndividualAmtBlure: function () {
    //   if (this.formDataNew.subaccountsIndividualAmt.indexOf('.') > 0) {
    //     if (this.formDataNew.subaccountsIndividualAmt.split('.')[1].length > 2) {
    //       this.$Message.error('请保留两位小数')
    //       this.formDataNew.subaccountsIndividualAmt = ''
    //       return false
    //     }
    //   }
    // },
    subaccountsDateAmtBlure: function () {
      if (this.formDataNew.subaccountsDateAmt.indexOf('.') > 0) {
        if (this.formDataNew.subaccountsDateAmt.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formDataNew.subaccountsDateAmt = ''
          return false
        }
      }
    },
    objTypeChange (val) {
      this.$refs['formDataNew'].resetFields() // 正则验证重置
      this.formDataNew.objType = val
      if (val === '1') {
        this.objTypeGr = true
        this.objTypeQy = false
        this.$refs.formDataNew.rules.name = [{required: true, trigger: 'blur', message: '请输入姓名'}]
        this.$refs.formDataNew.rules.idCode = [{required: true, trigger: 'blur', message: '请输入身份证号'}, {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字'}]
        this.$refs.formDataNew.rules.entName = [{required: false, trigger: 'blur', message: '请输入企业名称'}]
        this.$refs.formDataNew.rules.busLicCode = [{required: false, trigger: 'blur', message: '请输入营业执照号'}, {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字'}]
      }
      if (val === '2') {
        this.objTypeGr = false
        this.objTypeQy = true
        this.$refs.formDataNew.rules.name = [{required: false, trigger: 'blur', message: '请输入姓名'}]
        this.$refs.formDataNew.rules.idCode = [{required: false, trigger: 'blur', message: '请输入身份证号'}, {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字'}]
        this.$refs.formDataNew.rules.entName = [{required: true, trigger: 'blur', message: '请输入企业名称'}]
        this.$refs.formDataNew.rules.busLicCode = [{required: true, trigger: 'blur', message: '请输入营业执照号'}, {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字'}]
      }

      // this.$refs['formDataNew'].resetFields() // 正则验证重置
    },
    handleSubmit () {
      if (!this.canSave) {
        return
      }
      this.canSave = false
      let that = this
      this.formDataNew.operationType = '2'
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          that.$axios.post('/blacklistApr', this.formDataNew).then(function (res) {
            that.$Message.success('新增分账黑名单成功')
            that.goBack()
            that.canSave = true
          }).catch(function () {
            // that.$Message.success('新增分账黑名单失败')
          })
        } else {
          that.$Message.error('请正确填写信息')
          that.canSave = true
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
