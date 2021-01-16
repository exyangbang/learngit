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
                <i-select v-model="industryCode" label-in-value @on-change="industryCodeChange" style="width: 300px">
                  <i-option v-for="item in industryCodeAry" :key="item.id" :value="item.code">{{item.name}}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="来款户名：" prop="accountName">
                <Input v-model="formDataNew.accountName"  style="width:350px" placeholder="请输入来款户名" :maxlength="nameSize"  />
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
  name: "addWhiteList",
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
        accountName: '',
        industryCode: '',
        merName: ''
      },
      ruleValidate: {
        industryCode: [
          {required: true, trigger: 'blur', message: '请选择客户号'}
        ],
        accountName: [
          {required: true, trigger: 'blur', message: '请输入来款户名'}
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

      query.parameters.industryType = '1'
      let that = this
      this.$axios.post('industry/pageList', query).then(function (res) {
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
    channelNameChange: function (value) {
      this.formDataNew.channelName = value.label
      // this.setChannelName(value.label)
      this.formDataNew.channelKey = value.value
    },
    industryCodeChange: function (val) {
      this.merName = val.label
      this.formDataNew.industryCode = val.value
    },
    handleSubmit () {
      let that = this
      this.formDataNew.merName = this.merName
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          this.$axios.post('/whiteList', this.formDataNew).then(function (res) {
            that.$Message.success('添加来款账户白名单成功')
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
