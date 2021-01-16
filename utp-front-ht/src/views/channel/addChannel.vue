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
          <h4 style="display:inline">添加渠道</h4>
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
          <FormItem label="选择渠道名称：" prop="channelKey">
            <i-select v-model="formData.channelKey"  style="width:300px"  :label-in-value = "true" @on-change="channelNameChange">
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
            <Col span="12"  >
              <FormItem label="银联商户号：" prop="channelMerNo" v-if="businessNumDis">
                <Input v-model="formData.channelMerNo"  @on-blur="channelMerNoBlure" style="width:300px" placeholder="请输入商户号" :maxlength='15' />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="渠道编号：" prop="channelCode">
                <Input v-model="formData.channelCode" style="width:300px" :disabled="true" placeholder="请输入渠道编号" :maxlength=accountSize />
              </FormItem>
            </Col>
<!--            <Col span="12">-->
<!--              <FormItem label="前台地址：" prop="frontUrl">-->
<!--                <Input v-model="formData.frontUrl" style="width:300px" placeholder="请输入前台地址" :maxlength="nameSize" />-->
<!--              </FormItem>-->
<!--            </Col>-->
<!--          <Col span="12">-->
<!--            <FormItem label="后台地址：" prop="backUrl">-->
<!--              <Input v-model="formData.backUrl" style="width:300px" placeholder="请输入后台地址" :maxlength="nameSize" />-->
<!--            </FormItem>-->
<!--          </Col>-->
          <Col span="12">
            <FormItem label="是否可用：" prop="status">
              <i-select v-model="formData.status" style="width:300px" @on-change="statusChange" >
                <i-option v-for="item in statusAry" :value="item.value" :key="item.id">{{ item.name }}</i-option>
              </i-select>
            </FormItem>
          </Col>
            <Col span="12">
              <FormItem label="渠道额度：" prop="amount">
                <Input v-model="formData.amount" style="width:300px" @on-blur="quotalVailt" placeholder="请输入渠道额度" :maxlength="12" />
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
    <!-- 弹出手续费选择框-->
    <Modal v-model="funcModal" title="选择手续费模板" width="1000" :mask-closable="false">
      <func-list v-if="funcModalShow" v-on:pagByJson="pagByJson"></func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>import Cookies from 'js-cookie'
import funcList from '../industry/link/components/funcList.vue'
export default {
  name: 'addChannel',
  components: {
    funcList: funcList
  },
  data () {
    return {
      businessNumDis: false,
      channelNameAry: [],
      funcModal: false,
      funcModalShow: false, // 用来更新数据
      choseText: '请选择手续费模板',
      productNoAry: [],
      channelCapitalSourceArray: this.$contants.dictionary.fundResourcesArray,
      orgCodeAry: [],
      amountNew: '',
      chnFeeTemplateIdAry: [],
      joinTypeAry: [{name: '平台接入', value: '1'}, {name: '机构接入', value: '2'}],
      statusAry: [{name: '启用', value: '1'}, {name: '禁用', value: '0'}],
      uploadUrl: this.$contants.UploadImageUrl,
      userId: null,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {
        channelMerNo: '',
        // backUrl: '',
        channelCode: '',
        channelKey: '',
        channelName: '',
        chnFeeTemplateId: '',
        // frontUrl: '',
        amount: '',
        // id: 0,
        joinType: '1',
        orgCode: '',
        productNo: '',
        status: '1',
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
        indFeeTemplateId: [
          {required: true, trigger: 'change', message: '请选择手续费模板'}
        ],
        amount: [
          {required: true, trigger: 'blur', message: '请输入渠道额度'},
          {pattern: /^\d+(\.{0,1}\d+){0,1}$/, message: '请输入非负数字'}
        ],
        channelKey: [
          {required: true, trigger: 'change', message: '请选择渠道名称'}
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
      // this.$axios.get('/organizations?pageNo=1&&pageSize=100').then(function (res) {
      //   res.data.list.forEach(function (e, i) {
      //     that.orgCodeAry.push(e)
      //   })
      // })
      this.$axios.post('/feeTemplate/list', query).then(function (res) {
        res.data.list.forEach(function (e, i) {
          that.chnFeeTemplateIdAry.push(e)
        })
      })
    },
    quotalVailt: function (val) {
      if (this.formData.amount.indexOf('.') > 0) {
        if (this.formData.amount.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formData.amount = ''
          return false
        }
      }
    },
    choseMerFeeTem: function (row) {
      this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    pagByJson: function (pagJson) {
      this.funcModal = pagJson.disPlay
      this.formData.indFeeTemplateId = pagJson.indFeeTemplateId.toString()
      this.formData.chnFeeTemplateId = pagJson.indFeeTemplateId.toString()
      this.choseText = pagJson.name
      // this.funcModalShow = pagJson.disPlay
    },
    channelNameChange: function (value) {
      if (value.value === '0004' || value.value === '0002') {
        this.businessNumDis = true
        this.ruleValidate.channelMerNo = [
          {required: true, trigger: 'change', message: '请输入银联商户号'},
          {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字，且最大长度15！'}
        ]
        this.ruleValidate.channelMerName = [
          {required: true, trigger: 'change', message: '请输入商户名称'}
        ]
        this.ruleValidate.channelMerategory = [
          {required: true, trigger: 'change', message: '请输入商户简称'}
        ]
        this.ruleValidate.channelMerShortName = [
          {required: true, trigger: 'change', message: '请输入商户类别'}
        ]
        this.ruleValidate.channelCapitalSource = [
          {required: true, trigger: 'change', message: '请选择资金来源'},
          {pattern: /^[0-9]+$/, message: '只能输入数字，且最大长度4！'}
        ]
        this.ruleValidate.channelMerNameDec = [
          {required: true, trigger: 'change', message: '请输入银联渠道名称备注'}
        ]
      } else {
        this.businessNumDis = false
        this.formData.channelMerNo = ''
        this.ruleValidate.channelMerNo = [
          {required: false, trigger: 'change', message: '请输入商户号'},
          {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字，且最大长度15！'}
        ]
      }
      this.formData.channelName = value.label
      // this.setChannelName(value.label)
      this.formData.channelKey = value.value.toString()
      this.getChannelCode()
    },
    objTypeChange: function (val) {
      this.formData.channelCapitalSource = val
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
    getChannelCode: function () {
      if (this.formData.channelKey && this.formData.productNo) {
        this.formData.channelCode = this.formData.channelKey + this.formData.productNo
      }
      if (this.formData.channelKey && this.formData.productNo && this.formData.channelMerNo) {
        this.formData.channelCode = this.formData.channelKey + this.formData.productNo + this.formData.channelMerNo
      }
    },
    handleSubmit () {
      let that = this
      if (this.formData.channelKey === '0002' || this.formData.channelKey === '0004') { // 银联代付(实时划账)”、“银联代付(事后划账)”

      } else {
        this.formData.channelMerName = ''
        this.formData.channelMerategory = ''
        this.formData.channelMerShortName = ''
        this.formData.channelCapitalSource = ''
      }

      if (this.formData.amount === '') {
        this.$Message.error('请输入渠道额度')
        return false
      } else {
        this.formData.amount = (parseFloat(this.formData.amount * 100).toFixed(0)).toString()
        this.$refs['formData'].validate((valid) => {
          if (valid) {
            this.$axios.post('/channelInfo', this.formData).then(function (res) {
              that.$Message.success('添加渠道成功')
              that.goBack()
            }).catch(function (err) {
              that.formData.amount = ''
            })
          } else {
            that.$Message.error('请正确填写信息')
            that.formData.amount = ''
          }
        })
      }
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
