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
              <FormItem label="渠道编号：" prop="channelCode">
                <Input v-model="formDataNew.channelCode"  style="width:350px" placeholder="请输入渠道编号" :maxlength="50" :disabled="true" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="手续费模板：" prop="merFeeTemplateId">
                <i-input style="width: 350px;" v-model="choseText"  @on-focus="choseMerFeeTem" :placeholder=choseText>
                  <i-button slot="append" icon="ios-search" @click="choseMerFeeTem"></i-button>
                </i-input>
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
    <Modal v-model="funcModal" title="选择手续费模板" width="1000" :mask-closable="false">
      <func-list v-if="funcModalShow" v-on:pagByJson="pagByJson"  @checkFunc="checkFunc" @hideFunc="hideFunc" :selectedItem="this.selectedItem" :sureBtnDisabled=true></func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>import Cookies from 'js-cookie'
import funcList from './components/funcList.vue'
export default {
  name: "addChannelMerchant",
  components: {
    funcList: funcList
  },
  data () {
    return {
      choseText: '请选择手续费模板',
      joinTypeAry: [{name: '商户接入', value: '1'}, {name: '机构接入', value: '2'}],
      statusAry: [{name: '启用', value: '1'}, {name: '禁用', value: '0'}],
      productNoAry: [],
      chnFeeTemplateIdAry: [],
      channelNameAry: [],
      // funcTableColumns: [],
      funcModal: false,
      merNo: this.$route.params.merNo,
      funcModalShow: false, // 用来更新数据
      formDataNew: {
        channelCode: '',
        merFeeTemplateId: '',
        chnFeeTemplateId: '',
        merNo: this.$route.params.merNo,
        productNo: ''
      },
      ruleValidate: {
        channelCode: [
          {required: true, trigger: 'blur', message: '请选择渠道编号'}
        ],
        merNo: [
          {required: true, trigger: 'blur', message: '请选择商户'}
        ],
        merFeeTemplateId: [
          {required: true, trigger: 'change', message: '请选择手续费模板'}
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
    pagByJson: function (pagJson) {
      this.funcModal = pagJson.disPlay
      this.formDataNew.merFeeTemplateId = pagJson.merFeeTemplateId.toString()
      this.choseText = pagJson.name
      // this.funcModalShow = pagJson.disPlay
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
    merNoChange: function (val) {
      this.formDataNew.merNo = val
    },
    productNoChange: function (val) {
      this.formDataNew.productNo = val
      let that = this
      let query = {
        productNo: val
      }
      this.$axios.post('channelInfo/list', query).then(function (res) {
        if (res.data.length > 0) {
          that.formDataNew.channelCode = res.data[0].channelCode
          that.formDataNew.chnFeeTemplateId = res.data[0].chnFeeTemplateId
        } else {
          that.formDataNew.channelCode = ''
          that.$Message.error('请先为支付产品：' + that.formDataNew.productNo + '配置渠道信息！')
        }
      })
    },
    // merFeeTemplateIdChange: function (val) {
    //   this.formDataNew.merFeeTemplateId = val
    //   // this.selectedItem = row
    //   this.funcModalShow = true
    //   this.funcModal = !this.funcModal
    // },
    handleSubmit () {
      let that = this
      this.formDataNew.merNo = window.location.href.split('/')[(window.location.href.split('/').length - 1)]
      // this.formDataNew.merName = this.$route.params.merName
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          this.$axios.post('/channelMerchant', this.formDataNew).then(function (res) {
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
