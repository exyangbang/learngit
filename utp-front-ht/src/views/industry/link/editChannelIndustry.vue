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
                <i-select v-model="formDataNew.productNo" style="width:350px" :disabled="true" @on-change="productNoChange">
                  <i-option v-for="item in productNoAry"  :key="item.id" :value="item.code">{{ item.name }}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="渠道名称：" prop="channelCode">
                <Input v-model="formDataNew.channelName"  style="width:350px" placeholder="请输入渠道编号" :maxlength="50" :disabled="true" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="通用手续费模板：" prop="indFeeTemplateName">
                <i-input style="width: 350px;" v-model="formDataNew.indFeeTemplateName"  @on-focus="choseMerFeeTem" placeholder="choseText">
                  <i-button slot="append" icon="ios-search" @click="choseMerFeeTem"></i-button>
                </i-input>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="渠道商户号：" v-if="channelMerNoDis" prop="channelMerNo">
                <Input v-model="formDataNew.channelMerNo" :disabled="true" style="width:350px" placeholder="请输入渠道商户号" :maxlength="accountSize" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="10">
              <FormItem label="对公手续费模板：" prop="publicFeeTemplateId">
                <i-input style="width: 350px;" v-model="formDataNew.publicFeeTemplateName"  @on-focus="publicChoseMerFeeTem" :placeholder=publicChoseText>
                  <i-button slot="append" icon="ios-search" @click="publicChoseMerFeeTem"></i-button>
                </i-input>
              </FormItem>
            </Col>
            <Col span="2">
              <Button type="primary" @click="publicChoseTextBtn()"  >清空</Button>
            </Col>
            <Col span="10">
              <FormItem label="对私手续费模板：" prop="privateFeeTemplateId">
                <i-input style="width: 350px;" v-model="formDataNew.privateFeeTemplateName"  @on-focus="privateChoseMerFeeTem" :placeholder=privateChoseText>
                  <i-button slot="append" icon="ios-search" @click="privateChoseMerFeeTem"></i-button>
                </i-input>
              </FormItem>
            </Col>
            <Col span="2">
              <Button type="primary" @click="privateChoseTextBtn()" style="margin-left: 2px" >清空</Button>
            </Col>
          </row>
          <row>
            <Col span="12"  v-if="channelMerNoDis">
              <FormItem label="商户名称：">
                <Input v-model="formDataNew.channelMerName" style="width:350px" :disabled="true" />
              </FormItem>
              <FormItem label="商户类别：" >
                <Input v-model="formDataNew.channelMerategory"  style="width:350px" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12"  v-if="channelMerNoDis">
              <FormItem label="商户简称：">
                <Input v-model="formDataNew.channelMerShortName" style="width:350px" :disabled="true" />
              </FormItem>
              <FormItem label="资金来源：">
                <Input v-model="formDataNew.channelCapitalSource"  style="width:350px" :disabled="true"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12"  v-if="channelMerNoDis">
              <FormItem label="银联渠道名称备注：">
                <Input v-model="formDataNew.channelMerNameDec"  style="width:350px" :disabled="true"/>
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
    <!-- 弹出商户选择框-->
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
  name: 'editChannelIndustry',
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
      channelMerchantTheId: this.$route.params.id,
      id: this.$route.params.id,
      industryCode: this.$route.params.industryCode,
      choseText: '请选择通用手续费模板',
      publicChoseText: '请选择对公手续费模板',
      privateChoseText: '请选择对私手续费模板',
      joinTypeAry: [{name: '平台接入', value: '1'}, {name: '机构接入', value: '2'}],
      statusAry: [{name: '启用', value: '1'}, {name: '禁用', value: '0'}],
      productNoAry: [],
      chnFeeTemplateIdAry: [],
      channelNameAry: [],
      // funcTableColumns: [],
      funcModal: false,
      publicFuncModal: false,
      privateFuncModal: false,
      funcModalShow: false, // 用来更新数据
      publicFuncModalShow: false, // 用来更新数据
      privateFuncModalShow: false, // 用来更新数据
      formDataNew: {
        channelCode: '',
        indFeeTemplateId: '',
        indFeeTemplateName: '',
        chnFeeTemplateId: '',
        industryCode: this.$route.params.industryCode,
        id: this.$route.params.id,
        productNo: '',
        privateFeeTemplateName: '',
        publicFeeTemplateName: ''
      },
      ruleValidate: {
        channelCode: [
          {required: true, trigger: 'blur', message: '请选择渠道编号'}
        ],
        productNo: [
          {required: true, trigger: 'blur', message: '请选择支付产品'}
        ],
        indFeeTemplateName: [
          {required: true, trigger: 'change', message: '请选择手续费模板'}
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
      disCounty: false
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
      })
      this.$axios.post('/feeTemplate/list', query).then(function (res) {
        res.data.list.forEach(function (e, i) {
          that.chnFeeTemplateIdAry.push(e)
        })
        if (that.channelMerchantTheId) {
          that.getOrganizationDetail()
        }
      })
    },
    channelMerNoChange (val) {
      this.formDataNew.channelMerNo = val
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('channelIndustry' + '/' + this.channelMerchantTheId)
        .then(function (response) {
          self.formDataNew = response.data
          if (response.data.channelMerNo) {
            self.channelMerNoDis = true
          }
          self.choseText = response.data.indFeeTemplateName
          self.formDataNew.indFeeTemplateName = response.data.indFeeTemplateName
          self.formDataNew.indFeeTemplateId = response.data.indFeeTemplateId

          self.formDataNew.channelCapitalSource = self.$contants.dictionary.fundResourcesDic[response.data.channelCapitalSource]
          // self.formDataNew.indFeeTemplateId = response.data.indFeeTemplateId
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
    privateChoseTextBtn () {
      this.formDataNew.privateFeeTemplateId = '0'
      this.formDataNew.privateFeeTemplateName = ''
    },
    publicChoseTextBtn () {
      this.formDataNew.publicFeeTemplateId = '0'
      this.formDataNew.publicFeeTemplateName = ''
    },
    pagByJson: function (pagJson) {
      this.funcModal = pagJson.disPlay
      this.formDataNew.indFeeTemplateId = pagJson.indFeeTemplateId
      this.choseText = pagJson.name
      this.formDataNew.indFeeTemplateName = pagJson.name
      // this.formDataNew.choseText = pagJson.name + '(模板ID:' + pagJson.indFeeTemplateId + ')'

      // this.funcModalShow = pagJson.disPlay
    },
    publicPagByJson: function (pagJson) {
      this.publicFuncModal = pagJson.disPlay
      this.formDataNew.publicFeeTemplateId = pagJson.indFeeTemplateId
      this.publicChoseText = pagJson.name
      this.formDataNew.publicFeeTemplateName = pagJson.name
    },
    privatePagByJson: function (pagJson) {
      this.privateFuncModal = pagJson.disPlay
      this.formDataNew.privateFeeTemplateId = pagJson.indFeeTemplateId
      this.privateChoseText = pagJson.name
      this.formDataNew.privateFeeTemplateName = pagJson.name
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
      // this.setChannelName(value.label)
      this.formDataNew.channelKey = value.value
    },
    industryCodeChange: function (val) {
      this.formDataNew.industryCode = val
    },
    clearBtnData () {
      this.formDataNew.privateFuncModal = ''
      this.formDataNew.publicFuncModal = ''
    },
    productNoChange: function (val) {
      this.formDataNew.productNo = val
      let that = this
      let query = {
        industryCode: this.industryCode,
        productNo: val
      }
      this.$axios.post('channelInfo/list', query).then(function (res) {
        if (res.data[0].channelCode) {
          that.formDataNew.channelCode = res.data[0].channelCode
          that.formDataNew.chnFeeTemplateId = res.data[0].chnFeeTemplateId
        } else {
          that.$Message.error('请先为商户号：' + that.industryCode + '支付产品：' + that.formData.productNo + '配置渠道信息！')
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
      this.formDataNew.industryCode = this.$route.params.industryCode
      // this.formDataNew.merName = this.$route.params.merName
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          this.$axios.put('/channelIndustry', this.formDataNew).then(function (res) {
            that.$Message.success('修改关联渠道成功')
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
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'editChannelIndustry', this.$route.params.id)
    if (this.channelMerchantTheId !== initParamVal) {
      this.channelMerchantTheId = initParamVal
      this.init()
    }
  }
}
</script>
