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
          <h4 style="display:inline">编辑商户</h4>
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
              <FormItem label="商户名称：" prop="merName">
                <Input v-model="formData.merName" style="width: 300px" placeholder="请输入商户名称" :maxlength="200" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="商户号：" prop="merNo">
                <Input v-model="formData.merNo" :disabled="true" style="width: 300px" placeholder="请输入商户号" :maxlength="20" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="所属收单机构：" prop="orgCode">
                <i-select v-model="formData.orgCode" style="width:300px" :label-in-value = "true" @on-change="orgCodeChange">
                  <i-option v-for="item in orgCodeAry"  :key="item.id" :value="item.orgCode">{{ item.fullName }}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="所属平台：" prop="industryCode">
                <i-select v-model="formData.industryCode" style="width: 300px" :label-in-value = "true" @on-change="industryNameChange">
                  <i-option v-for="item in industryNameAry"  :key="item.code" :value="item.code">{{ item.name }}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <!--<Col span="12">-->
            <!--<FormItem label="商户类型：" prop="accountType">-->
            <!--<i-select v-model="formData.accountType" style="width: 300px" :label-in-value = "true" @on-change="accountTypeChange">-->
            <!--<i-option value="public" label="对公">对公</i-option>-->
            <!--<i-option value="private" label="对私">对私</i-option>-->
            <!--</i-select>-->
            <!--</FormItem>-->
            <!--</Col>-->
            <!--<Col span="12">-->
            <!--<FormItem label="开户行名称：" prop="bankName">-->
            <!--<Input v-model="formData.bankName" style="width: 300px" placeholder="请输入开户名称" :maxlength="200" />-->
            <!--</FormItem>-->
            <!--</Col>-->
            <!--<Col span="12">-->
            <!--<FormItem label="开户行行号：" prop="bankCode">-->
            <!--<Input v-model="formData.bankCode" style="width: 300px" placeholder="请输入开户行行号" :maxlength="20" />-->
            <!--</FormItem>-->
            <!--</Col>-->
            <!--<Col span="12">-->
            <!--<FormItem label="账户名称：" prop="accountName">-->
            <!--<Input v-model="formData.accountName" style="width: 300px" placeholder="请输入开户行行号" :maxlength="200" />-->
            <!--</FormItem>-->
            <!--</Col>-->
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
  name: "editMerchant",
  data () {
    return {
      constantsImg: this.$contants.BaseImageUrl,
      orgCodeAry: [],
      userId: null,
      type: null,
      marchantId: this.$route.params.id,
      currentPage: 1,
      roleList: [],
      formData: {
        id: this.$route.params.id,
        merName: '',
        merNo: '',
        orgCode: '',
        orgName: '',
        bankName: '',
        bankCode: '',
        industryName: '',
        industryCode: '',
        accountType: '',
        accountName: ''
      },
      ruleValidate: {
        merName: [
          {required: true, trigger: 'blur', message: '请输入商户名称'}
        ],
        merNo: [
          {required: true, trigger: 'blur', message: '请输入商户号'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        orgCode: [
          {required: true, trigger: 'blur', message: '请选择所属收单机构'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字，且长度不超过20！'}
        ],
        orgName: [
          {required: true, trigger: 'blur', message: '请输入机构名称！'}
        ],
        industryName: [
          {required: true, trigger: 'blur', message: '请选择平台！'}
        ],
        industryCode: [
          {required: true, trigger: 'blur', message: '请选择平台！'}
        ]
        // accountType: [
        //   {required: true, trigger: 'blur', message: '请选择商户类型！'}
        // ],
        // accountName: [
        //   {required: true, trigger: 'blur', message: '请输入开户账号名称！'}
        // ],
        // bankCode: [
        //   {required: true, trigger: 'blur', message: '请输入开户账号名称！'}
        // ],
        // bankName: [
        //   {required: true, trigger: 'blur', message: '请输入开户行名称！'}
        // ]
      },
      industryNameAry: [],
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
      let that = this
      this.$axios.get('/organizations?pageNo=1&&pageSize=100').then(function (res) {
        res.data.list.forEach(function (e, i) {
          that.orgCodeAry.push(e)
        })
      })
      let query = {
        pageNo: 1,
        pageSize: 100
      }
      this.$axios.post('/industry/list', query).then(function (res) {
        res.data.forEach(function (e, i) {
          that.industryNameAry.push(e)
        })
      })
      if (this.marchantId) {
        this.getOrganizationDetail()
      }
    },
    statusChange: function (val) {
      this.formData.status = val
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('merchantInfo' + '/' + this.marchantId)
        .then(function (response) {
          self.formData = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    // accountTypeChange: function (val) {
    //   this.formData.accountType = val.value
    // },
    industryNameChange: function (val) {
      this.formData.industryName = val.label
      this.formData.industryCode = val.value
    },
    orgCodeChange: function (val) {
      this.formData.orgCode = val.value
      this.formData.orgName = val.label
    },
    handleSubmit () {
      let that = this
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.put('/merchantInfo', this.formData).then(function (res) {
            that.$Message.success('修改商户成功')
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
    }
  }
}
</script>
