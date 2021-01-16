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
      <Row>
        <Col span="24">
          <row>
            <Col span="12">
              <FormItem label="支付产品：" prop="productNo">
                <i-select v-model="formDataNew.productNo" disabled style="width:350px" @on-change="productNoChange">
                  <i-option v-for="item in productNoAry"  :key="item.id" :value="item.code">{{ item.name }}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="渠道编号：" prop="channelCode">
                <Input v-model="formDataNew.channelCode" placeholder="请输入渠道编号" :maxlength="50" :disabled="true" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="手续费模板：" prop="merFeeTemplateId">
                <i-select v-model="formDataNew.merFeeTemplateId" style="width:350px" @on-change="chnFeeTemplateIdChange">
                  <i-option v-for="item in chnFeeTemplateIdAry"  :key="item.id" :value="item.id">{{ item.name }}</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
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
  // props: {
  //   merId: '',
  //   merName: '',
  //   merNo: '',
  //   productNoAry: '',
  //   chnFeeTemplateIdAry: ''
  // },
  data () {
    return {
      channelMerchantTheId: this.$route.params.id,
      productNoAry: [],
      chnFeeTemplateIdAry: [],
      channelNameAry: [],
      formDataNew: {
        channelCode: '',
        chnFeeTemplateId: 1,
        merFeeTemplateId: '',
        merNo: this.$route.params.merNo,
        merName: this.$route.params.merName,
        productNo: ''
      },
      ruleValidate: {
        channelCode: [
          {required: true, trigger: 'blur', message: '请选择渠道编号'}
        ],
        merFeeTemplateId: [
          {required: true, trigger: 'blur', message: '请选择商户手续费模板'}
        ],
        merNo: [
          {required: true, trigger: 'blur', message: '请选择商户'}
        ],
        productNo: [
          {required: true, trigger: 'blur', message: '请选择支付产品'}
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
      let channelAry = JSON.parse(Cookies.get('channelDictions'))

      let that = this
      channelAry.forEach(function (e, i) {
        if (e.type === 'channel') {
          that.channelNameAry.push(e)
        }
      })

      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }

      that.$axios.post('/payProduct/list', query).then(function (res) {
        res.data.list.forEach(function (e, i) {
          that.productNoAry.push(e)
        })
        that.$axios.post('/feeTemplate/list', query).then(function (res) {
          res.data.list.forEach(function (e, i) {
            that.chnFeeTemplateIdAry.push(e)
          })
          if (that.channelMerchantTheId) {
            that.getOrganizationDetail()
          }
        })
      })
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('channelMerchant' + '/' + this.channelMerchantTheId)
        .then(function (response) {
          self.formDataNew = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    channelNameChange: function (value) {
      this.formDataNew.channelName = value.label
      // this.setChannelName(value.label)
      this.formDataNew.channelKey = value.value
    },
    merNoChange: function (val) {
      this.formDataNew.merNo = val
    },
    productNoChange: function (val) {
      this.formDataNew.productNo = val
      let that = this
      let query = {
        merNo: this.merNo,
        productNo: val
      }
      this.$axios.post('channelInfo/list', query).then(function (res) {
        if (res.data[0].channelCode) {
          that.formDataNew.channelCode = res.data[0].channelCode
          that.formDataNew.chnFeeTemplateId = res.data[0].chnFeeTemplateId
        } else {
          that.$Message.error('请先为商户号：' + that.merNo + '支付产品：' + that.formData.productNo + '配置渠道信息！')
        }
      })
    },
    chnFeeTemplateIdChange: function (val) {
      this.formDataNew.merFeeTemplateId = val
    },
    handleSubmit () {
      let that = this
      this.formDataNew.merNo = this.$route.params.merNo
      this.formDataNew.merName = this.$route.params.merName

      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          this.$axios.post('/channelMerchant', this.formDataNew).then(function (res) {
            that.$Message.success('添加渠道成功')
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
    }
  }
}
</script>
