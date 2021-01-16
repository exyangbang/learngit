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
              <FormItem label="手续费模板：" prop="choseText">
                <i-input style="width: 300px; float: left;" v-model="choseText"  @on-focus="choseMerFeeTem" :placeholder=choseText>
                  <i-button slot="append" icon="ios-search" @click="choseMerFeeTem"></i-button>
                </i-input>
                <Button type="primary" @click="clearBtnData()" style="margin-left: 10px" >清空</Button>
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
  name: 'setFee',
  components: {
    funcList: funcList
  },
  data () {
    return {
      choseText: '请选择手续费模板',
      chnFeeTemplateIdAry: [],
      channelNameAry: [],
      // funcTableColumns: [],
      funcModal: false,
      id: this.$route.params.industryCode,
      funcModalShow: false, // 用来更新数据
      formDataNew: {
        feeTemplateId: this.$route.params.feeTemplateId,
        // feeTemplateName: this.$route.params.feeTemplateName,
        id: this.$route.params.id
      },
      ruleValidate: {
        indFeeTemplateId: [
          {required: true, trigger: 'change', message: '请选择手续费模板'}
        ],
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
      let self = this
      if (this.$route.params.id) {
        sessionStorage.setItem('setFee', this.$route.params.feeTemplateId)
        sessionStorage.setItem('setFeeid', this.$route.params.id)
      } else {
        this.formDataNew.feeTemplateId = sessionStorage.getItem('setFee')
        this.formDataNew.id = sessionStorage.getItem('setFeeid')
      }
      if (this.formDataNew.feeTemplateId !== null && this.formDataNew.feeTemplateId !== 'null') {
        this.$axios.get('/feeTemplate/' + this.formDataNew.feeTemplateId).then(function (res) {
          self.choseText = res.data.name
        })
      } else {
        self.choseText = ''
      }
    },
    choseMerFeeTem: function (row) {
      this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    pagByJson: function (pagJson) {
      this.funcModal = pagJson.disPlay
      this.formDataNew.indFeeTemplateId = pagJson.indFeeTemplateId.toString()
      this.formDataNew.feeTemplateId = pagJson.indFeeTemplateId.toString()
      this.formDataNew.feeTemplateName = pagJson.name
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

    productNoChange: function (val) {
      this.formDataNew.productNo = val
      // let that = this
      // let query = {
      //   productNo: val
      // }
      // this.$axios.post('channelInfo/list', query).then(function (res) {
      //   if (res.data.length > 0) {
      //     that.formDataNew.channelCode = res.data[0].channelCode
      //     that.formDataNew.chnFeeTemplateId = res.data[0].chnFeeTemplateId.toString()
      //   } else {
      //     that.formDataNew.channelCode = ''
      //     that.$Message.error('请先为支付产品：' + that.formDataNew.productNo + '配置渠道信息！')
      //   }
      // })
    },
    channelCodeChange: function (val) {
      this.formDataNew.channelCode = val
    },
    // indFeeTemplateIdChange: function (val) {
    //   this.formDataNew.indFeeTemplateId = val
    //   // this.selectedItem = row
    //   this.funcModalShow = true
    //   this.funcModal = !this.funcModal
    // },
    handleSubmit () {
      let that = this
      if (this.formDataNew.feeTemplateId) {
        this.$refs['formDataNew'].validate((valid) => {
          if (valid) {
            this.$axios.put('/account', that.formDataNew).then(function (res) {
              that.$Message.success('设置手续费成功')
              that.goBack()
            })
          } else {
            that.$Message.error('请正确填写信息')
          }
        })
      } else {
        that.$Message.error('请选择手续费模板')
      }
    },
    clearBtnData () {
      this.formDataNew.feeTemplateIdRelieve = '-1'
      this.choseText = ''
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
    if (this.formDataNew.id !== this.$route.params.id) {
      this.formDataNew.id = this.$route.params.id
      this.formDataNew.feeTemplateId = this.$route.params.feeTemplateId
      this.init()
    }
  }
}
</script>
