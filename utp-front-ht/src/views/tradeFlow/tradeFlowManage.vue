<style lang="less">
  @import '../../styles/common.less';
  .hidden {
    display: none;
  }
</style>
<template>
  <card>
    <Form :label-width="120" ref="form" :model="formData.parameters" label-position="right" :inline="true" :rules="ruleValidate">
      <Row>
        <FormItem  label="交易开始日期：" prop="beginTradeDate1">
          <DatePicker :options="beginDateOption" v-model="beginTradeDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>
        </FormItem>
        <FormItem  label="交易开始时间：" prop="beginTransTime" >
          <Time-picker confirm placeholder="选择时间" :editable="false" v-model="beginTransTime"  style="width: 168px"></Time-picker>
          <!--<DatePicker :options="beginDateOption" v-model="formData.parameters.beginTradeDate" class="input-width-170" type="datetime"   format="yyyy-MM-dd HH:mm:ss" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>-->
        </FormItem>
        <FormItem label="交易结束日期：" prop="endTradeDate1" >
          <DatePicker :options="endDateOption" v-model="endTradeDate" class="input-width-170" type="date" :editable="false" format="yyyy-MM-dd" placeholder="请选择交易结束日期" @on-change="endTradeDateChange"></DatePicker>
        </FormItem>
        <FormItem label="交易结束时间：" prop="endTransTime" >
          <Time-picker confirm placeholder="选择时间" :editable="false" v-model="endTransTime" style="width: 168px"></Time-picker>
          <!--<DatePicker :options="endDateOption" v-model="formData.parameters.endTradeDate" class="input-width-170" type="datetime"  format="yyyy-MM-dd HH:mm:ss" placeholder="请选择交易结束日期" @on-change="endTradeDateChange"></DatePicker>-->
        </FormItem>
        <FormItem label="客户端流水号：" prop="clientTransId">
          <Input v-model="clientTransId" :maxlength="accountSize" class="input-width-170"/>
        </FormItem>
        <FormItem label="服务端流水号：" prop="serverTransId">
          <Input v-model="serverTransId" :maxlength="accountSize" class="input-width-170"/>
        </FormItem>
        <FormItem label="交易状态：" prop="transStatus">
          <Select v-model="transStatus" class="input-width-170" @on-change="chanStatus">
            <Option value="PRE_CREATE">创建订单</Option>
            <Option value="PROCESSING"> 处理中</Option>
            <Option value="TRADE_SUCCESS">交易成功</Option>
            <Option value="TRADE_FAILURE"> 交易失败</Option>
            <Option value="TRADE_ERROR">交易错误、不明确状态</Option>
          </Select>
        </FormItem>
        <!--<FormItem label="撤销标志：" prop="revokeStatus">-->
        <!--<Select v-model="revokeStatus" class="input-width-170" @on-change="chanRevokeStatus">-->
        <!--<Option value="0">未撤销</Option>-->
        <!--<Option value="1">已撤销</Option>-->
        <!--</Select>-->
        <!--</FormItem>-->
        <!--<FormItem label="退货标志：" prop="refundStatus">-->
        <!--<Select v-model="refundStatus" class="input-width-170" @on-change="chanRefundStatus">-->
        <!--<Option value="0">未退货</Option>-->
        <!--<Option value="1">部分退货</Option>-->
        <!--<Option value="2">已退货</Option>-->
        <!--</Select>-->
        <!--</FormItem>-->
        <FormItem label="产品类型：" prop="productCode" >
          <Select v-model="productCode" class="input-width-170" @on-change="chanProduct">
            <Option v-for="item in productNoAry" :value="item.code" :key="item.code">{{item.name}}</Option>
          </Select>
        </FormItem>
        <FormItem label="交易类型：" prop="tradeType">
          <Select v-model="tradeType" class="input-width-170" @on-change="chanTrade">
            <Option v-for="item in tradeTypeAry" :value="item.value" :key="item.value">{{item.name}}</Option>
          </Select>
          <!--<Select v-model="tradeType" class="input-width-170" @on-change="chanTrade">-->
            <!--<Option value="WITHDRAW">提现</Option>-->
            <!--<Option value="TRANSFER">平台转账</Option>-->
            <!--<Option value="TRANSFER_USER2USER">转账(用户-用户)</Option>-->
            <!--<Option value="TRANSFER_USER2INDUSTRY">转账(用户-代付客户平台)</Option>-->
            <!--<Option value="SGL_PAYMENT">单笔实时代付</Option>-->
            <!--<Option value="REFUND_ORDERID">订单退款</Option>-->
            <!--<Option value="UPLOAD_ACCOUNT_SETTLE">预付费卡清算</Option>-->
          <!--</Select>-->
        </FormItem>
        <FormItem label="客户号：" prop="industryCode" >
          <Input v-model="industryCode" :maxlength="12"  class="input-width-170"/>
        </FormItem>
        <FormItem label="虚拟账号：" prop="payerAccount">
          <Input v-model="payerAccount" :maxlength="accountSize" class="input-width-170"/>
        </FormItem>
        <!--<FormItem label="卡号：" prop="accNo">-->
        <!--<Input v-model="formData.parameters.accNo" class="input-width-170"/>-->
        <!--</FormItem>-->
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listTradeFlowCash">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <Button type="success" class="margin-left-10" @click="downLoad" v-access id="listTradeFlowCashDown" :disabled="disBtn">导出</Button>
        </FormItem>
      </Row>
      <!--<div style="margin-bottom:10px;left: 28%;position:relative;">-->
      <!--<a style="text-decoration:underline;color: #2b85e4;display: inline;margin-right: 3px" @click="switchSearch">{{switchTitle}}</a><Icon :type="switchType" :title="switchTitle" style="color:#2b85e4;:pointer;width: 13px" @click="switchSearch"/>-->
      <!--</div>-->
      <!--<div v-bind:class="{hidden:isHidden}">-->
    </Form>
    <Row style=" height: 40px; background: #9ea7b4; color: #fff; line-height: 40px; text-indent: 1.2em; width: 100%">
      <Col :span="6">
        <span>总笔数：{{totalCount}}</span>
      </Col>
      <Col :span="6">
        <span>总金额：{{totalMoney}}</span>
      </Col>
      <Col :span="6">
        <span>渠道交易总手续费：{{channelFeeTotal}}</span>
      </Col>
      <Col :span="6">
        <span>客户交易总手续费：{{merFeeTotal}}</span>
      </Col>
    </Row>
    <Row>
      <Table :columns="tableColumns" :data="tableData" border highlight-row stripe ></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
    <Modal
      title="详情"
      v-model="tradeFlowManageOrderDetail"
      @on-ok="thawReportOk"
      :mask-closable="false">
      <p>交易平台订单号：{{orderId}}</p>
      <br>
      <p>商品信息：{{summaryDescription}}</p>
      <br>
    </Modal>
  </card>
</template>
<script>
export default {
  name: "tradeFlows",
  data () {
    return {
      tradeTypeAry: this.$contants.dictionary.tradeType,
      disBtn: true,
      totalCount: '',
      totalMoney: '',
      channelFeeTotal: 0 + '元',
      merFeeTotal: 0 + '元',
      isHidden: true,
      productNoAry: [],
      productMap: {},
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      beginTradeDate: this.$moment(new Date()).format('YYYYMMDD'),
      beginTransTime: '00:00:00',
      endTradeDate: this.$moment(new Date()).format('YYYYMMDD'),
      endTransTime: '23:59:59',
      clientTransId: '',
      serverTransId: '',
      transStatus: '',
      productCode: '',
      tradeFlowManageOrderDetail: false,
      orderId: '',
      summaryDescription: '',
      tradeType: '',
      industryCode: '',
      payerAccount: '',
      formData: {
        parameters: {
        }
      },
      tableColumns: [],
      tableData: [],
      orgData: [],
      total: 0,
      pageNo: 1,
      pageSize: 10,
      beginDateOption: {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      },
      endDateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now()
        }
      },
      // beginDateOption: {
      //   disabledDate (date) {
      //     return (date && date.valueOf() > Date.now()) || (date && date.valueOf() < Date.now() - 86400000)
      //   }
      // },
      // endDateOption: {
      //   disabledDate (date) {
      //     return (date && date.valueOf() > Date.now()) || (date && date.valueOf() < Date.now() - 86400000)
      //   }
      // },
      ruleValidate: {
        beginTradeDate: [
          {required: true, trigger: 'blur', message: '请输入交易开始时间'}
        ],
        endTradeDate: [
          {required: true, trigger: 'blur', message: '请输入交易结束时间'}
        ]
      }
    }
  },
  methods: {
    beginTradeDateChange (value) {
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() < dateGet.valueOf() - 86400000)
        }
      }
      this.beginTransDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
    },
    endTradeDateChange (value) {
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf() - 86400000)
        }
      }
      this.endTransDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
    },
    init () {
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 150 * avg,
          title: '客户端流水号',
          key: 'clientTransId'
        },
        {
          width: 180 * avg,
          title: '服务端流水号',
          key: 'serverTransId'
        },
        {
          width: 120 * avg,
          title: '交易发起时间',
          key: 'transDate',
          render (h, a, b) {
            if (a.row.transDate !== 'null') {
              let newTime = a.row.transDate.split('')
              return h('span', newTime[0] + newTime[1] + newTime[2] + newTime[3] + '-' + newTime[4] + newTime[5] + '-' + newTime[6] + newTime[7] + ' ' + newTime[8] + newTime[9] + ':' + newTime[10] + newTime[11] + ':' + newTime[12] + newTime[13])
            }
          }
        },
        {
          width: 120 * avg,
          title: '清算日期',
          key: 'channelSettleDate',
          render (h, a, b) {
            if (a.row.channelSettleDate !== 'null' && a.row.channelSettleDate !== '') {
              let newTime = a.row.channelSettleDate.split('')
              return h('span', newTime[0] + newTime[1] + newTime[2] + newTime[3] + '-' + newTime[4] + newTime[5] + '-' + newTime[6] + newTime[7])
            }
          }
        },
        {
          width: 190 * avg,
          title: '客户名称',
          key: 'industryName'
        },
        {
          width: 150 * avg,
          title: '虚拟账号',
          key: 'payerAccount'
        },
        {
          width: 150 * avg,
          title: '收款人账号',
          key: 'showPayeeAccountNo'
        },
        {
          width: 150 * avg,
          title: '收款人户名',
          key: 'showPayeeAccountName'
        },
        {
          width: 100 * avg,
          title: '交易金额',
          key: 'transAmount',
          render (h, a, b) {
            return h('span', a.row.transAmount / 100 + '元')
          }
        },
        {
          width: 100 * avg,
          title: '客户手续费',
          key: 'merFee',
          render (h, a, b) {
            return h('span', a.row.merFee / 100 + '元')
          }
        },
        {
          width: 100 * avg,
          title: '渠道手续费',
          key: 'channelFee',
          render (h, a, b) {
            return h('span', a.row.channelFee / 100 + '元')
          }
        },
        {
          width: 100 * avg,
          title: '交易状态',
          key: 'transStatus',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.transStatus === 'PRE_CREATE') {
              getReslt = '创建订单'
            }
            if (a.row.transStatus === 'PROCESSING') {
              getReslt = '处理中'
            }
            if (a.row.transStatus === 'TRADE_SUCCESS') {
              getReslt = '交易成功'
            }
            if (a.row.transStatus === 'TRADE_FAILURE') {
              getReslt = '交易失败'
            }
            if (a.row.transStatus === 'TRADE_ERROR') {
              getReslt = '交易错误、不明确状态'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 100 * avg,
          title: '产品类型',
          key: 'productCode',
          render: function (h, a, b) {
            let getReslt = ''
            if (a.row.productCode === 'ACCOUNT') {
              getReslt = '代付'
            }
            if (a.row.productCode === 'PRECARD') {
              getReslt = '预付费卡'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 120 * avg,
          title: '交易类型',
          key: 'tradeType',
          render (h, a, b) {
            return h('span', self.$contants.dictionary.totalTradeTypeMap[a.row.tradeType])
          }
        },
        {
          width: 120 * avg,
          title: '渠道编号',
          key: 'channelCode'
        },
        {
          width: 120 * avg,
          title: '渠道名称',
          key: 'channelName',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.tradeType === 'SPLIT_PAYMENT') {
              getReslt = ''
            } else {
              getReslt = a.row.channelName
            }
            return h('span', getReslt)
          }
        },
        {
          width: 120 * avg,
          title: '渠道返回时间',
          key: 'channelRespTime'
        },
        {
          width: 120 * avg,
          title: '渠道返回码',
          key: 'channelRespCode'
        },
        // {
        //   width: 120 * avg,
        //   title: '渠道清算日期',
        //   key: 'channelSettleDate'
        // },
        {
          width: 120 * avg,
          title: '渠道返回信息',
          key: 'channelRespMsg',
          ellipsis: true,
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.channelRespMsg
                }
              }, params.row.channelRespMsg)
            ])
          }
        },
        {
          width: 120 * avg,
          title: '请求IP地址',
          key: 'remoteIp'
        },
        {
          title: '操作',
          key: 'action',
          align: 'left',
          width: 100 * avg,
          render: (h, params) => {
            if (params.row.tradeType === 'BALANCE_PAYMENT' || params.row.tradeType === 'REFUND_BALANCE_PAYMENT') {
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'tradeFlows',
                    title: '详情'
                  },
                  props: {
                    type: 'detail',
                    size: '16'
                  },
                  style: {
                    marginRight: '20px',
                    cursor: 'pointer'
                  },
                  directives: [{
                    name: 'access'
                  }],
                  on: {
                    click: () => {
                      this.orderId = params.row.orderId
                      this.summaryDescription = params.row.summaryDescription
                      this.accountReportBank()
                    }
                  }
                }, '详情')
              ])
            }
          }
        }
      ]
      let queryOld = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      this.$axios.post('/payProduct/list', queryOld).then(function (res) {
        res.data.list.forEach(function (e, i) {
          if (e.status !== '0') {
            self.productNoAry.push(e)
          }
          (e.code === '1000') && (self.productMap['COLLECTION'] = e.name);
          (e.code === '1001') && (self.productMap['ACCOUNT'] = e.name)
        })
      })
      this.searchList()
      // this.searchOrg()
    },
    accountReportBank () {
      this.tradeFlowManageOrderDetail = true
    },
    thawReportOk () {
      this.tradeFlowManageOrderDetail = false
    },
    downLoad () {
      let self = this
      let query = self.formData
      self.$axios({
        method: 'post',
        url: '/transFlowCurrent/download',
        data: query,
        responseType: 'blob'
      }).then(response => {
        self.downloadGo(response.data)
      }).catch((error) => {

      })
    },
    downloadGo (data) {
      if (!data) {
        return
      }
      let downName = '当前交易流水' + this.$moment(new Date()).format('YYYYMMDD') + '.xlsx' // 文件下载名称
      const blob = new Blob([data])
      if (window.navigator.msSaveOrOpenBlob) {
        // 兼容IE10
        navigator.msSaveBlob(blob, downName)
      } else {
        // chrome/firefox
        let url = window.URL.createObjectURL(new Blob([data]))
        let link = document.createElement('a')
        link.style.display = 'none'
        link.href = url
        link.setAttribute('download', '当前交易流水' + this.$moment(new Date()).format('YYYYMMDD') + '.xlsx')
        document.body.appendChild(link)
        link.click()
      }

    },
    searchOrg () {
      let self = this
      this.$axios.get(this.$contants.restful.organizations + '?pageNo=1&pageSize=1000')
        .then(function (response) {
          self.orgData = response.data.list
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    searchList () {
      let self = this
      let queryParams = {}
      queryParams.pageNo = self.pageNo
      queryParams.pageSize = self.pageSize
      let beginTransTime = this.beginTransTime.split(':')[0] + this.beginTransTime.split(':')[1] + this.beginTransTime.split(':')[2]
      let endTransTime = this.endTransTime.split(':')[0] + this.endTransTime.split(':')[1] + this.endTransTime.split(':')[2]
      if (this.beginTransDate === undefined) {
        this.beginTransDate = this.$moment(new Date()).format('YYYYMMDD')
      }
      if (this.endTransDate === undefined) {
        this.endTransDate = this.$moment(new Date()).format('YYYYMMDD')
      }
      this.formData.parameters.beginTransDatetime = this.beginTransDate + beginTransTime
      this.formData.parameters.endTransDatetime = this.endTransDate + endTransTime
      if (this.clientTransId) {
        this.formData.parameters.clientTransId = this.clientTransId
      } else {
        delete this.formData.parameters.clientTransId
      }
      if (this.serverTransId) {
        this.formData.parameters.serverTransId = this.serverTransId
      } else {
        delete this.formData.parameters.serverTransId
      }
      if (this.transStatus) {
        this.formData.parameters.transStatus = this.transStatus
      } else {
        delete this.formData.parameters.transStatus
      }
      if (this.productCode) {
        this.formData.parameters.productCode = this.productCode
      } else {
        delete this.formData.parameters.productCode
      }
      if (this.tradeType) {
        this.formData.parameters.tradeType = this.tradeType
      } else {
        delete this.formData.parameters.tradeType
      }
      if (this.industryCode) {
        this.formData.parameters.industryCode = this.industryCode
      } else {
        delete this.formData.parameters.industryCode
      }
      if (this.payerAccount) {
        this.formData.parameters.payerAccount = this.payerAccount
      } else {
        delete this.formData.parameters.payerAccount
      }
      this.formData.pageNo = self.pageNo
      this.formData.pageSize = self.pageSize
      let query = self.formData
      this.$axios.post('/transFlowCurrent/list', query)
        .then(function (response) {
          if (response.data.total.totalCount >= 1) {
            self.disBtn = false
          } else {
            self.disBtn = true
          }
          response.data.page.list.forEach(function (e, i) {
            e.transDate = e.transDate + e.transTime
          })
          self.tableData = response.data.page.list
          self.total = response.data.total.totalCount
          self.totalCount = response.data.total.totalCount + '笔'
          self.totalMoney = response.data.total.transAmount / 100 + '元'
          if (response.data.total.channelFeeTotal) {
            self.channelFeeTotal = response.data.total.channelFeeTotal / 100 + '元'
          }
          if (response.data.total.merFeeTotal) {
            self.merFeeTotal = response.data.total.merFeeTotal / 100 + '元'
          }
        })
        .catch(function (error) {
          console.log(error)
        })
      // }
      //   })
    },
    chanRefundStatus (val) {
      this.refundStatus = val
    },
    chanRevokeStatus (val) {
      this.revokeStatus = val
    },
    chanStatus (val) {
      this.transStatus = val
    },
    chanTrade (val) {
      this.tradeType = val
    },
    // chanOrg (val) {
    //   this.orgCode = val
    // },
    chanProduct (val) {
      this.productCode = val
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.pageNo = 1
      this.searchList()
    },
    resetBtn () {
      // this.beginDateOption = {}
      // this.endDateOption = {}
      // this.formData = {parameters: {beginTradeDate: this.$moment(new Date()).format('YYYY-MM-DD') + ' 00:00:00', endTradeDate: this.$moment(new Date()).format('YYYY-MM-DD') + ' 23:59:59'}}
      // this.beginTradeDateChange(this.formData.parameters.beginTradeDate)
      this.beginTransTime = '00:00:00'
      this.endTransTime = '23:59:59'
      this.beginTransDate = this.$moment(new Date()).format('YYYYMMDD')
      this.beginTradeDate = this.$moment(new Date()).format('YYYYMMDD')
      this.endTransDate = this.$moment(new Date()).format('YYYYMMDD')
      this.endTradeDate = this.$moment(new Date()).format('YYYYMMDD')
      this.formData.parameters = {}
      this.clientTransId = ''
      this.serverTransId = ''
      this.transStatus = ''
      this.refundStatus = ''
      this.revokeStatus = ''
      this.productCode = ''
      this.tradeType = ''
      this.industryCode = ''
      this.payerAccount = ''
      this.pageNo = 1
      this.beginDateOption = {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      }
      this.endDateOption = {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      }
      // this.searchOrg()
    }
  },
  mounted () {
    this.init()
  },
  beforeDestroy () {

  },
  created () {
  },
  computed: {
    nameSize () {
      return this.$contants.pageSet.nameSize
    },
    accountSize () {
      return this.$contants.pageSet.accountSize
    }
  },
  activated() {
      this.searchList()
  }
}
</script>
