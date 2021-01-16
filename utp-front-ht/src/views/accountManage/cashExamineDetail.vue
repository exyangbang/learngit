<style lang="less">
  @import '../../styles/common.less';
  .hidden {
    display: none;
  }
</style>
<template>
  <card>
    <Row>
      <Table :columns="tableColumns" :data="tableData" border stripe ></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>
export default {
  name: "cashExamineDetail",
  data () {
    return {
      totalCount: '',
      totalMoney: '',
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
      // revokeStatus: '',
      // refundStatus: '',
      tradeType: '',
      industryCode: '',
      merNo: '',
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
          return date && date.valueOf() > Date.now()
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
      // this.beginTransTime = value.split(' ')[1].split(':')[0] + value.split(' ')[1].split(':')[1] + value.split(' ')[1].split(':')[2]
    },
    endTradeDateChange (value) {
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf() - 86400000)
        }
      }
      this.endTransDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
      // this.endTransTime = value.split(' ')[1].split(':')[0] + value.split(' ')[1].split(':')[1] + value.split(' ')[1].split(':')[2]
    },
    init () {
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 100 * avg,
          title: '客户名称',
          key: 'industryName'
        },
        {
          width: 150 * avg,
          title: '虚拟账号',
          key: 'merNo'
        },
        {
          width: 150 * avg,
          title: '收款人账号',
          key: 'payeeAcctNo'
        },
        {
          width: 150 * avg,
          title: '收款人名称',
          key: 'payeeName'
        },
        // {
        //   width: 100 * avg,
        //   title: '商户名称',
        //   key: 'merName'
        // },
        {
          width: 100 * avg,
          title: '产品类型',
          key: 'productCode',
          render: function (h, a, b) {
            let getReslt = ''
            if (a.row.productCode === 'ACCOUNT') {
              getReslt = '代付'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 80 * avg,
          title: '交易类型',
          key: 'tradeType',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.tradeType === 'WITHDRAW') {
              getReslt = '提现'
            }
            if (a.row.tradeType === 'TRANSFER') {
              getReslt = '转账'
            }
            if (a.row.tradeType === 'REFUND') {
              getReslt = '(非签约)退货'
            }
            if (a.row.tradeType === 'PRIVATE') {
              getReslt = '单笔实时代收'
            }
            if (a.row.tradeType === 'QUERY_PRIVATE') {
              getReslt = '单笔实时代收状态查询'
            }
            if (a.row.tradeType === 'BG_VALIDATE') {
              getReslt = '业务鉴权'
            }
            if (a.row.tradeType === 'BATCH_UPLOAD') {
              getReslt = '批量代收文件上送'
            }
            if (a.row.tradeType === 'QUERY_BATCH') {
              getReslt = '批量代收状态查询'
            }
            if (a.row.tradeType === 'DOWNLOAD_BATCH_DATA') {
              getReslt = '批量代收回执'
            }
            if (a.row.tradeType === 'DOWNLOAD_SETTLE_DATA') {
              getReslt = '对账单下载'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 150 * avg,
          title: '客户端流水号',
          key: 'clientTransId'
        },
        {
          width: 150 * avg,
          title: '服务端流水号',
          key: 'serverTransId'
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
              getReslt = '处理中'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 120 * avg,
          title: '交易发起时间',
          key: 'transDate',
          render (h, a, b) {
            let newTime = a.row.transDate.split('')
            return h('span', newTime[0] + newTime[1] + newTime[2] + newTime[3] + '-' + newTime[4] + newTime[5] + '-' + newTime[6] + newTime[7] + ' ' + newTime[8] + newTime[9] + ':' + newTime[10] + newTime[11] + ':' + newTime[12] + newTime[13])
          }
        },
        {
          width: 120 * avg,
          title: '清算日期',
          key: 'reconcileDate',
          render (h, a, b) {
            let newTime = a.row.reconcileDate.split('')
            return h('span', newTime[0] + newTime[1] + newTime[2] + newTime[3] + '-' + newTime[4] + newTime[5] + '-' + newTime[6] + newTime[7])
          }
        },
        {
          width: 120 * avg,
          title: '渠道清算日期',
          key: 'channelSettleDate'
        },
        {
          width: 120 * avg,
          title: '渠道编号',
          key: 'channelCode'
        },
        {
          width: 120 * avg,
          title: '渠道名称',
          key: 'channelName'
        },
        {
          width: 120 * avg,
          title: '渠道返回时间',
          key: 'channelRespTime'
        },
        {
          width: 120 * avg,
          title: '渠道返回代码',
          key: 'channelRespCode'
        },
        {
          width: 120 * avg,
          title: '渠道返回信息',
          key: 'channelRespMsg',
          ellipsis: true
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
    downLoad () {
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
      // this.formData.parameters.beginTransDate = beginTransDate
      // this.formData.parameters.endTransDate = endTransDate
      // this.formData.parameters.beginTransTime = beginTransTime
      // this.formData.parameters.endTransTime = endTransTime
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
      }
      // if (this.refundStatus) {
      //   this.formData.parameters.refundStatus = this.refundStatus
      // }
      // if (this.revokeStatus) {
      //   this.formData.parameters.revokeStatus = this.revokeStatus
      // }
      if (this.productCode) {
        this.formData.parameters.productCode = this.productCode
      }
      if (this.tradeType) {
        this.formData.parameters.tradeType = this.tradeType
      }
      if (this.industryCode) {
        this.formData.parameters.industryCode = this.industryCode
      }
      if (this.merNo) {
        this.formData.parameters.merNo = this.merNo
      } else {
        delete this.formData.parameters.merNo
      }
      this.formData.pageNo = self.pageNo
      this.formData.pageSize = self.pageSize
      let query = self.formData
      this.$axios.post('/transFlowCurrent/list', query)
        .then(function (response) {
          response.data.page.list.forEach(function (e, i) {
            e.transDate = e.transDate + e.transTime
          })
          self.tableData = response.data.page.list
          self.total = response.data.total.totalCount
          self.totalCount = response.data.total.totalCount + '笔'
          self.totalMoney = response.data.total.transAmount / 100 + '元'
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
      this.merNo = ''
      this.pageNo = 1
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
  }
}
</script>
