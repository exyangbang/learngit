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
                <i-select v-model="formDataNew.productNo" style="width:350px" @on-change="productNoChange">
                  <i-option v-for="item in productNoAry"  :key="item.id" :value="item.code">{{ item.name }}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="渠道名称：" prop="channelCodeNew">
                <!--<Input v-model="formDataNew.channelCode"  style="width:350px" placeholder="请输入渠道编号" :maxlength="50" :disabled="true" />-->
                <i-select v-model="formDataNew.channelCodeNew" style="width:350px" @on-change="channelCodeChange" :disabled="disChose">
                  <i-option v-for="item in channelCodeAry"  :key="item.id" :value="item.channelCode">{{ item.channelName }}</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="通用手续费模板：" prop="indFeeTemplateId">
                <i-input style="width: 350px;" v-model="choseText"  @on-focus="choseMerFeeTem" :placeholder=choseText>
                  <i-button slot="append" icon="ios-search" @click="choseMerFeeTem"></i-button>
                </i-input>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="渠道商户号：" v-if="channelMerNoDis" prop="channelMerNo">
                <i-select v-model="formDataNew.channelMerNo" style="width:350px" @on-change="channelMerNoChange">
                  <i-option v-for="item in channelMerNoAry"  :key="item.id" :value="item.channelMerNo">{{ item.channelMerNo }}</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="10">
              <FormItem label="对公手续费模板：" prop="publicFeeTemplateId">
                <i-input style="width: 350px;" v-model="publicChoseText"  @on-focus="publicChoseMerFeeTem" :placeholder=publicChoseText>
                  <i-button slot="append" icon="ios-search" @click="publicChoseMerFeeTem"></i-button>
                </i-input>
              </FormItem>
            </Col>
            <Col span="2">
              <Button type="primary" @click="publicChoseTextBtn()" style="margin-left: 0px" >清空</Button>
            </Col>
            <Col span="10">
              <FormItem label="对私手续费模板：" prop="privateFeeTemplateId">
                <i-input style="width: 350px;" v-model="privateChoseText"  @on-focus="privateChoseMerFeeTem" :placeholder=privateChoseText>
                  <i-button slot="append" icon="ios-search" @click="privateChoseMerFeeTem"></i-button>
                </i-input>
              </FormItem>
            </Col>
            <Col span="2">
              <Button type="primary" @click="privateChoseTextBtn()" >清空</Button>
            </Col>
          </row>
          <row>
            <Col span="12"  v-if="businessNumDis">
              <FormItem label="商户名称：">
                <Input v-model="channelMerName" style="width:350px" :disabled="true" />
              </FormItem>
              <FormItem label="商户类别：" >
                <Input v-model="channelMerategory"  style="width:350px" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12"  v-if="businessNumDis">
              <FormItem label="商户简称：">
                <Input v-model="channelMerShortName" style="width:350px" :disabled="true" />
              </FormItem>
              <FormItem label="资金来源：">
                <Input v-model="channelCapitalSource"  style="width:350px" :disabled="true"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12"  v-if="businessNumDis">
              <FormItem label="银联渠道名称备注：">
                <Input v-model="channelMerNameDec"  style="width:350px" :disabled="true"/>
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
    <!-- 弹出手续费选择框-->
    <Modal v-model="funcModal" title="选择通用手续费模板" width="1000" :mask-closable="false">
      <func-list v-if="funcModalShow" v-on:pagByJson="pagByJson"  @checkFunc="checkFunc" @hideFunc="hideFunc" :selectedItem="this.selectedItem" :sureBtnDisabled=true></func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>

    <Modal v-model="publicFuncModal" title="选择对公手续费模板" width="1000" :mask-closable="false">
      <func-list v-if="publicFuncModalShow" v-on:pagByJson="publicPagByJson"  @checkFunc="publicCheckFunc" @hideFunc="publicHideFunc" :selectedItem="this.selectedItem" :sureBtnDisabled=true></func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>

    <Modal v-model="privateFuncModal" title="选择对私手续费模板" width="1000" :mask-closable="false">
      <func-list v-if="privateFuncModalShow" v-on:pagByJson="privatePagByJson"  @checkFunc="privateCheckFunc" @hideFunc="privateHideFunc" :selectedItem="this.selectedItem" :sureBtnDisabled=true></func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>import Cookies from 'js-cookie'
import funcList from './components/funcList.vue'
export default {
  name: 'addChannelIndustry',
  components: {
    funcList: funcList
  },
  data () {
    return {
      businessNumDis: false,
      channelMerName: '',
      channelMerShortName: '',
      channelMerategory: '',
      channelCapitalSource: '',
      channelMerNameDec: '',
      channelMerNoAry: [],
      channelMerNoDis: false,
      disChose: true,
      choseText: '请选择通用手续费模板',
      publicChoseText: '请选择对公手续费模板',
      privateChoseText: '请选择对私手续费模板',
      joinTypeAry: [{name: '商户接入', value: '1'}, {name: '机构接入', value: '2'}],
      statusAry: [{name: '启用', value: '1'}, {name: '禁用', value: '0'}],
      productNoAry: [],
      channelCodeAry: [],
      chnFeeTemplateIdAry: [],
      channelNameAry: [],
      // funcTableColumns: [],
      funcModal: false,
      publicFuncModal: false,
      privateFuncModal: false,
      industryCode: this.$route.params.industryCode,
      funcModalShow: false, // 用来更新数据
      publicFuncModalShow: false, // 用来更新数据
      privateFuncModalShow: false, // 用来更新数据
      channelCode: '',
      formDataNew: {
        channelCodeNew: '',
        channelKey: '',
        channelCode: '',
        indFeeTemplateId: '',
        chnFeeTemplateId: '',
        industryCode: this.$route.params.industryCode,
        productNo: '',
        channelMerNo: '',
        publicFeeTemplateId: '',
        privateFeeTemplateId: ''
      },
      ruleValidate: {
        channelCodeNew: [
          {required: true, trigger: 'change', message: '请选择渠道名称'}
        ],
        industryCode: [
          {required: true, trigger: 'change', message: '请选择商户'}
        ],
        indFeeTemplateId: [
          {required: true, trigger: 'change', message: '请选择通用手续费模板'}
        ],
        productNo: [
          {required: true, trigger: 'change', message: '请选择支付产品'}
        ],
        channelMerNo: [
          {required: false, trigger: 'change', message: '请选择渠道商户号'}
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
      that.$axios.post('/payProduct/list', query).then(function (res) {
        res.data.list.forEach(function (e, i) {
          if (e.status === '1') {
            that.productNoAry.push(e)
          }
        })
      })
      // that.$axios.post('/channelInfo/list', query).then(function (res) {
      //   that.channelCodeAry = res.data
      // })
      this.$axios.post('/feeTemplate/list', query).then(function (res) {
        res.data.list.forEach(function (e, i) {
          that.chnFeeTemplateIdAry.push(e)
        })
      })
    },
    choseMerFeeTem: function (row) {
      this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    publicChoseMerFeeTem: function (row) {
      this.selectedItem = row
      this.publicFuncModalShow = true
      this.publicFuncModal = !this.funcModal
    },
    privateChoseMerFeeTem: function (row) {
      this.selectedItem = row
      this.privateFuncModalShow = true
      this.privateFuncModal = !this.funcModal
    },
    channelMerNoChange (val) {
      debugger
      self = this
      this.channelMerNoAry.forEach(function (e, i) {
        if (e.channelMerNo === val) {
          self.businessNumDis = true
          self.channelMerName = e.channelMerName
          self.channelMerShortName = e.channelMerShortName
          self.channelMerategory = e.channelMerategory
          // self.channelCapitalSource = e.channelCapitalSource

          self.channelCapitalSource = self.$contants.dictionary.fundResourcesDic[e.channelCapitalSource]
          self.channelMerNameDec = e.channelMerNameDec
        }
      })
      this.formDataNew.channelMerNo = val
    },
    privateChoseTextBtn () {
      this.formDataNew.privateFeeTemplateId = '0'
      this.privateChoseText = ''
    },
    publicChoseTextBtn () {
      this.formDataNew.publicFeeTemplateId = '0'
      this.publicChoseText = ''
    },
    pagByJson: function (pagJson) {
      this.funcModal = pagJson.disPlay
      this.formDataNew.indFeeTemplateId = pagJson.indFeeTemplateId.toString()
      this.choseText = pagJson.name
    },
    publicPagByJson: function (pagJson) {
      this.publicFuncModal = pagJson.disPlay
      this.formDataNew.publicFeeTemplateId = pagJson.indFeeTemplateId.toString()
      this.publicChoseText = pagJson.name
    },
    privatePagByJson: function (pagJson) {

      this.privateFuncModal = pagJson.disPlay
      this.formDataNew.privateFeeTemplateId = pagJson.indFeeTemplateId.toString()
      this.privateChoseText = pagJson.name
    },
    checkFunc (data) {
      this.funcModal = !this.funcModal
      this.funcModalShow = false
    },
    publicCheckFunc (data) {
      this.publicFuncModal = !this.funcModal
      this.publicFuncModalShow = false
    },
    privateCheckFunc (data) {
      this.privateFuncModal = !this.funcModal
      this.privateFuncModalShow = false
    },
    hideFunc: function () {
      this.funcModal = false
    },
    publicHideFunc: function () {
      this.publicFuncModal = false
    },
    privateHideFunc: function () {
      this.privateFuncModal = false
    },
    showRelateMerchant (row) {
      this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    channelNameChange: function (value) {
      this.formDataNew.channelName = value.label
      this.formDataNew.channelKey = value.value
    },
    industryCodeChange: function (val) {
      this.formDataNew.industryCode = val
    },
    productNoChange: function (val) {
      this.businessNumDis = false
      this.channelMerName = ''
      this.channelMerShortName = ''
      this.channelMerategory = ''
      this.channelCapitalSource = ''
      this.channelMerNameDec = ''
      this.formDataNew.channelCodeNew = ''
      this.formDataNew.productNo = val
      let that = this
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {productNo: val, industryCode: localStorage.getItem('industryCodeGuan')}
      }
      this.channelCodeAry = []
      this.disChose = true
      this.$axios.post('/channelInfo/filterList', query).then(function (res) {
        that.channelCodeAry = res.data
        that.disChose = false
        // if (res.data.length > 0) {
        //   that.formDataNew.channelCode = res.data[0].channelCode
        //   that.formDataNew.chnFeeTemplateId = res.data[0].chnFeeTemplateId.toString()
        // } else {
        //   that.formDataNew.channelCode = ''
        //   that.$Message.error('请先为支付产品：' + that.formDataNew.productNo + '配置渠道信息！')
        // }
      })
    },
    channelCodeChange: function (val) {
      let that = this
      this.channelMerNoAry = []
      this.formDataNew.channelMerNo = ''
      this.formDataNew.channelCode = val
      this.formDataNew.channelCodeNew = val
      this.channelCodeAry.forEach(function (e, i) {
        if (e.channelCode === val) {
          that.formDataNew.chnFeeTemplateId = e.chnFeeTemplateId
          that.formDataNew.channelKey = e.channelKey
          if (e.channelKey === '0004' || e.channelKey === '0002') {
            that.channelMerNoDis = true
            that.ruleValidate.channelMerNo[0].required = true
            let query = {
              pageNo: 1,
              pageSize: 100,
              parameters: { productNo: that.formDataNew.productNo, industryCode: localStorage.getItem('industryCodeGuan'), channelKey: e.channelKey }
            }
            that.$axios.post('/channelInfo/channelMerNoList', query).then(function (res) {
              that.channelMerNoAry = res.data
              that.disChose = false
            })
          } else {
            that.channelMerNoDis = false
            that.ruleValidate.channelMerNo[0].required = false
          }
        }
      })
    },
    // indFeeTemplateIdChange: function (val) {
    //   this.formDataNew.indFeeTemplateId = val
    //   // this.selectedItem = row
    //   this.funcModalShow = true
    //   this.funcModal = !this.funcModal
    // },
    handleSubmit () {
      let that = this
      this.formDataNew.industryCode = window.location.href.split('/')[(window.location.href.split('/').length - 1)]
      // this.formDataNew.merName = this.$route.params.merName
      if (this.formDataNew.channelKey === '0004') {
        if (this.formDataNew.channelMerNo === '') {
          this.$Message.error('请选择渠道商户号')
          return false
        }
      }
      if (this.channelMerNoAry.length > 0) {
          this.channelMerNoAry.forEach(function (e, i) {
              if (that.formDataNew.channelMerNo === e.channelMerNo) {
                  that.formDataNew.channelCode = e.channelCode
              }
          })
      }
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          this.$axios.post('/channelIndustry', this.formDataNew).then(function (res) {
            that.$Message.success('添加关联渠道成功')
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
