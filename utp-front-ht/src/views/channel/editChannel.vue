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
          <h4 style="display:inline">编辑渠道</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <i style="height: 10px"></i>
      <Row>
        <Col span="12">
          <FormItem label="选择渠道名称：" prop="channelKey">
            <i-select v-model="formData.channelKey"  style="width:300px"  :label-in-value = "true" @on-change="channelNameChange" :disabled="true">
              <i-option v-for="item in channelNameAry"  :key="item.key" :value="item.key">{{ item.value }}</i-option>
            </i-select>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="支付产品：" prop="productNo">
            <i-select v-model="formData.productNo" style="width:300px" @on-change="productNoChange">
              <i-option v-for="item in productNoAry"  :key="item.id" :value="item.code">{{ item.name }}</i-option>
            </i-select>
          </FormItem>
        </Col>
        <Col span="12" v-if="businessNumDis">
          <FormItem label="银联商户号：" prop="channelMerNo">
            <Input v-model="formData.channelMerNo" :disabled="true" @on-blur="channelMerNoBlure" style="width:300px" placeholder="请输入商户号" :maxlength=accountSize />
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="渠道编号：" prop="channelCode">
            <Input v-model="formData.channelCode" :disabled="true" style="width:300px" placeholder="请输入渠道编号" :maxlength="32" />
          </FormItem>
        </Col>
<!--        <Col span="12">-->
<!--          <FormItem label="前台地址：" prop="frontUrl">-->
<!--            <Input v-model="formData.frontUrl" style="width:300px" placeholder="请输入前台地址" :maxlength="nameSize" />-->
<!--          </FormItem>-->
<!--        </Col>-->
<!--        <Col span="12">-->
<!--          <FormItem label="后台地址：" prop="backUrl">-->
<!--            <Input v-model="formData.backUrl" style="width:300px" placeholder="请输入后台地址" :maxlength="nameSize" />-->
<!--          </FormItem>-->
<!--        </Col>-->
        <Col span="12">
          <FormItem label="是否可用：" prop="status">
            <i-select v-model="formData.status" style="width:300px" @on-change="statusChange" >
              <i-option v-for="item in statusAry" :value="item.value" :key="item.id">{{ item.name }}</i-option>
            </i-select>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="渠道额度：" prop="amount">
            <Input v-model="formData.amount" style="width:300px" @on-blur="quotalVailt" placeholder="请输入渠道额度" :maxlength="20" />
          </FormItem>
        </Col>
        <Col span="12"  v-if="businessNumDis">
          <FormItem label="商户名称：" prop="channelMerName">
            <Input v-model="formData.channelMerName"  @on-blur="channelMerNoBlure" style="width:300px" placeholder="请输入商户名称" :maxlength='nameSize' />
          </FormItem>
          <FormItem label="商户类别：" prop="channelMerategory">
            <Input v-model="formData.channelMerategory"  @on-blur="channelMerNoBlure" style="width:300px" placeholder="请输入商户类别" :maxlength='4' />
          </FormItem>
        </Col>
        <Col span="12"  v-if="businessNumDis">
          <FormItem label="商户简称：" prop="channelMerShortName">
            <Input v-model="formData.channelMerShortName"  @on-blur="channelMerNoBlure" style="width:300px" placeholder="请输入商户简称" :maxlength='nameSize' />
          </FormItem>
          <FormItem label="资金来源：" prop="channelCapitalSource">
            <Select v-model="formData.channelCapitalSource"  @on-change="channelCapitalSourceChange" style="width:300px" >
              <Option v-for="item in channelCapitalSourceArray" :value="item.value" :key="item.value">{{item.name}}</Option>
            </Select>
          </FormItem>
        </Col>
        <Col span="12" v-if="businessNumDis">
          <FormItem label="银联渠道名称备注：" prop="channelMerNameDec" >
            <Input v-model="formData.channelMerNameDec"  @on-blur="channelMerNoBlure" style="width:300px" placeholder="请输入银联渠道名称备注" :maxlength='nameSize' />
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="手续费模板：" prop="indFeeTemplateId">
            <i-input style="width: 300px;" v-model="choseText"  @on-focus="choseMerFeeTem" :placeholder=choseText>
              <i-button slot="append" icon="ios-search" @click="choseMerFeeTem"></i-button>
            </i-input>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="24" offset="2">
          <FormItem>
            <Button type="primary" @click="handleSubmit()">提交</Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
    <!-- 弹出手续费选择框-->
    <Modal v-model="funcModal" title="选择手续费模板" width="1000" :mask-closable="false">
      <func-list v-if="funcModalShow" v-on:pagByJson="pagByJson"></func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>import Cookies from 'js-cookie'
import funcList from '../merchant/link/components/funcList.vue'
export default {
  name: 'editChannel',
  components: {
    funcList: funcList
  },
  data () {
    return {
      businessNumDis: false,
      channelId: this.$route.params.id,
      channelNameAry: [],
      funcModal: false,
      funcModalShow: false, // 用来更新数据
      choseText: '请选择手续费模板',
      productNoAry: [],
      channelCapitalSourceArray: this.$contants.dictionary.fundResourcesArray,
      productNoAryOld: [],
      orgCodeAry: [],
      chnFeeTemplateIdAry: [],
      joinTypeAry: [{name: '平台接入', value: '1'}, {name: '机构接入', value: '2'}],
      statusAry: [{name: '启用', value: '1'}, {name: '禁用', value: '0'}],
      organizationId: this.$route.params.id,
      uploadUrl: this.$contants.UploadImageUrl,
      userId: null,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {
        channelMerNo: '',
        // backUrl: '',
        channelCode: '',
        amount: '',
        channelKey: '',
        channelName: '',
        chnFeeTemplateId: '',
        // frontUrl: '',
        // id: 0,
        joinType: '',
        orgCode: '',
        productNo: '',
        status: '',
        trid: '',
        trtp: '',
        accNo: '',
        userCode: '',
        channelMerName: '',
        channelMerategory: '',
        channelMerShortName: '',
        channelCapitalSource: '',
        channelMerNameDec: ''
      },
      ruleValidate: {
        chnFeeTemplateId: [
          {required: true, trigger: 'change', message: '请选择手续费模板'}
        ],
        amount: [
          {required: true, trigger: 'blur', message: '请输入渠道额度'},
          {pattern: /^\d+(\.{0,1}\d+){0,1}$/, message: '请输入非负数字'}
        ],
        channelKey: [
          {required: true, trigger: 'change', message: '请输入渠道编号'}
        ],
        joinType: [
          {required: true, trigger: 'change', message: '请选择接入类型'}
        ],
        orgCode: [
          {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字，且最大长度10！'}
        ],
        productNo: [
          {required: true, trigger: 'change', message: '请选择支付产品'}
        ],
        status: [
          {required: true, trigger: 'change', message: '请选择状态'}
        ],
        trid: [
          {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字，且最大长度20！'}
        ],
        trtp: [
          {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字，且最大长度20！'}
        ],
        accNo: [
          {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字，且最大长度20！'}
        ],
        userCode: [
          {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字，且最大长度20！'}
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

      this.$axios.post('/payProduct/list', query).then(function (res) {
        res.data.list.forEach(function (e, i) {
          if (e.status !== '0') {
            that.productNoAry.push(e)
          }
        })
      })
      // that.$axios.get('/organizations?pageNo=1&&pageSize=100').then(function (res) {
      //   res.data.list.forEach(function (e, i) {
      //     that.orgCodeAry.push(e)
      //   })
      // })
      this.$axios.post('/feeTemplate/list', query).then(function (res) {
        res.data.list.forEach(function (e, i) {
          that.chnFeeTemplateIdAry.push(e)
        })
        if (that.channelId) {
          that.getChannelDetail()
        }
      })
    },
    quotalVailt: function () {
      if (this.formData.amount.indexOf('.') > 0) {
        if (this.formData.amount.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formData.amount = ''
          return false
        }
      }
    },
    getChannelDetail () {
      let self = this
      this.$axios.get('channelInfo' + '/' + this.channelId)
        .then(function (response) {
          if (response.data.channelMerNo) {
            self.businessNumDis = true
          }
          response.data.chnFeeTemplateId = response.data.chnFeeTemplateId.toString()
          response.data.amount = (response.data.amount / 100).toString()
          self.choseText = response.data.chnFeeTemplateName
          self.formData = response.data
          if (self.formData.channelKey === '0004' || self.formData.channelKey === '0002') {
            self.ruleValidate.channelMerNo = [
              {required: true, trigger: 'change', message: '请输入银联商户号'},
              {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字，且最大长度15！'}
            ]
            self.ruleValidate.channelMerName = [
              {required: true, trigger: 'change', message: '请输入商户名称'}
            ]
            self.ruleValidate.channelMerategory = [
              {required: true, trigger: 'change', message: '请输入商户简称'}
            ]
            self.ruleValidate.channelMerShortName = [
              {required: true, trigger: 'change', message: '请输入商户类别'}
            ]
            self.ruleValidate.channelCapitalSource = [
              {required: true, trigger: 'change', message: '请选择资金来源'},
              {pattern: /^[0-9]+$/, message: '只能输入数字，且最大长度4！'}
            ]
            self.ruleValidate.channelMerNameDec = [
              {required: true, trigger: 'change', message: '请输入银联渠道名称备注'}
            ]
          }

        })
        .catch(function (error) {
          console.log(error)
        })
    },
    choseMerFeeTem: function (row) {
      this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    pagByJson: function (pagJson) {
      this.funcModal = pagJson.disPlay
      this.formData.chnFeeTemplateId = pagJson.merFeeTemplateId.toString()
      this.choseText = pagJson.name
      // this.funcModalShow = pagJson.disPlay
    },
    channelNameChange: function (value) {
      this.formData.channelName = value.label
      // this.setChannelName(value.label)
      this.formData.channelKey = value.value
      this.getChannelCode()
    },

    getChannelCode: function () {
      if (this.formData.channelKey  && this.formData.productNo) {
        this.formData.channelCode = this.formData.channelKey + this.formData.productNo
      }
      if (this.formData.channelKey  && this.formData.productNo && this.formData.channelMerNo) {
        this.formData.channelCode = this.formData.channelKey + this.formData.productNo + this.formData.channelMerNo
      }
    },

    productNoChange: function (val) {
      this.formData.productNo = val
      this.getChannelCode()
    },
    channelMerNoBlure () {
      this.getChannelCode()
    },
    joinTypeChange: function (val) {
      this.formData.joinType = val
    },
    orgCodeChange: function (val) {
      this.formData.orgCode = val
    },
    // chnFeeTemplateIdChange: function (val) {
    //   this.formData.chnFeeTemplateId = parseInt(val)
    //
    // },
    statusChange: function (val) {
      this.formData.status = val
    },
    handleSubmit () {
      let that = this
      this.formData.amount = (parseFloat(this.formData.amount * 100).toFixed(0)).toString()
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.put('/channelInfo', this.formData).then(function (res) {
            that.$Message.success('编辑渠道成功')
            that.goBack()
          }).catch(function (err) {
            // that.formData.amount = (that.formData.amount / 100).toString()
            that.formData.amount = ''
          })
        } else {
          that.$Message.error('请正确填写信息')
          // that.formData.amount = (that.formData.amount / 100).toString()
          that.formData.amount = ''
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
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'editChannel', this.$route.params.id)
    if (this.channelId !== initParamVal) {
      this.channelId = initParamVal
      this.init()
    }
  }
}
</script>
