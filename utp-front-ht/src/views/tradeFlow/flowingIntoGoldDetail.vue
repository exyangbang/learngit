<style lang="less">
  @import '../../styles/common.less';
  .hidden {
    display: none;
  }
</style>
<template>
  <card>
    <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true" >
      <Row>
        <FormItem  label="交易开始日期：" prop="beginTransDate" >
          <DatePicker :options="beginDateOption" v-model="beginTransDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>
        </FormItem>
        <FormItem label="交易开始时间：" prop="beginTransTime" >
          <Time-picker type="time" placeholder="请选择时间" :editable="false" v-model="beginTransTime"  @on-change="beginTransTimeChange" style="width: 168px"></Time-picker>
        </FormItem>
        <FormItem label="交易结束日期：" prop="endTradeDate" >
          <DatePicker :options="endDateOption" v-model="endTradeDate" class="input-width-170" type="date" :editable="false" format="yyyy-MM-dd" placeholder="请选择交易结束日期" @on-change="endTradeDateChange"></DatePicker>
        </FormItem>
        <FormItem label="交易结束时间：" prop="endTransTime" >
          <Time-picker type="time" placeholder="请选择时间" :editable="false" v-model="endTransTime" @on-change="endTransTimeChange"  style="width: 168px"></Time-picker>
        </FormItem>
        <FormItem label="交易商户号：" prop="merNo">
          <Input v-model="merNo" :maxlength="accountSize" class="input-width-170"/>
        </FormItem>
        <FormItem label="客户号：" prop="industryCode">
          <Input v-model="industryCode" :maxlength="accountSize" class="input-width-170"/>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listHisTradeFlowCash">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <!--<Button type="success" class="margin-left-10" v-access id="listReportFormDownLoad" @click="transFlowHistoryDownLoad" :disabled = "disAction">下载回单</Button>-->
          <Button type="success" class="margin-left-10" @click="downLoad" v-access id="listHisTradeFlowCashDown" :disabled="disBtn">导出</Button>
        </FormItem>
      </Row>
    </Form>
    <Row style=" height: 40px; background: #9ea7b4; color: #fff; line-height: 40px; text-indent: 1.2em; width: 100%">
      <Col :span="6">
        <span>总笔数：{{totalCount}}</span>
      </Col>
      <Col :span="6">
        <span>总金额：{{totalMoney}}</span>
      </Col>
    </Row>
    <Row>
      <Table :columns="tableColumns" :data="tableData" @on-current-change="selectDataGo" highlight-row border stripe ></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>export default {
  name: 'flowingIntoGoldDetail',
  data () {
    return {
      payFlowIds: this.$route.params.payFlowIds,
      payerAccount: '',
      disBtn: true,
      totalCount: '',
      totalMoney: '',
      selectDataId: '',
      disAction: true,
      isHidden: true,
      productNoAry: [],
      productMap: {},
      tradeTypeAry: this.$contants.dictionary.tradeType,
      serverTransId: '',
      beginTradeDate: '',
      endTradeDate: '',
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      beginTransDate: '',
      endTransDate: '',
      beginTransTime: '',
      endTransTime: '',
      // revokeStatus: '',
      // refundStatus: '',
      clientTransId: '',
      transStatus: '',
      productCode: '',
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
      }
    }
  },
  methods: {
    beginTradeDateChange (value) {
      this.beginTransDate = value.split('-').join('')
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() < dateGet.valueOf() - 86400000)
        }
      }
      this.beginTransDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
      // this.beginTransTime = value.split(' ')[1].split(':')[0] + value.split(' ')[1].split(':')[1] + value.split(' ')[1].split(':')[2]
    },
    beginTransTimeChange (value) {
      this.beginTransTime = value.split(':').join('')
    },
    endTradeDateChange (value) {
      this.endTradeDate = value.split('-').join('')
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
        }
      }
      this.endTransDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
    },
    endTransTimeChange (value) {
      this.endTransTime = value.split(':').join('')
    },
    init () {
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 150 * avg,
          title: '交易日期',
          key: 'transDate'
        },
        {
          width: 180 * avg,
          title: '交易时间',
          key: 'transTime'
        },
        {
          width: 180 * avg,
          title: '支付订单号',
          key: 'transOrderId'
        },
        {
          width: 120 * avg,
          title: '客户号',
          key: 'industryCode'
        },
        {
          width: 190 * avg,
          title: '交易商户号',
          key: 'merNo'
        },
        {
          width: 150 * avg,
          title: '交易金额',
          key: 'transAmount',
          render: function (h, a, b) {
            let getReslt = ''
            if (a.row.transAmount) {
              getReslt = a.row.transAmount / 100
            }
            return h('span', getReslt + '元')
          }
        },
        {
          width: 150 * avg,
          title: '卖方名称',
          key: 'sellerName'
        },
        {
          width: 150 * avg,
          title: '买方名称',
          key: 'buyerName'
        },
        {
          width: 150 * avg,
          title: '商品信息',
          key: 'goodsInfo'
        },
        {
          width: 130 * avg,
          title: '支付方式',
          key: 'payMode',
          render: function (h, a, b) {
            let getReslt = ''
            if (a.row.payMode === '0') {
              getReslt = '支付宝'
            }
            if (a.row.payMode === '1') {
              getReslt = '微信'
            }
            if (a.row.payMode === '2') {
              getReslt = '银联'
            }
            if (a.row.payMode === '3') {
              getReslt = '无正向支付流水'
            }
            if (a.row.payMode === '9') {
              getReslt = '其他支付方式'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 150 * avg,
          title: '备注说明',
          align: 'center',
          key: 'remark',
          render (h, a, b) {
            if (a.row.payMode === '3') {
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'editIndustry',
                    title: '查看详情'
                  },
                  props: {
                    type: 'downLoad',
                    size: '16'
                  },
                  style: {
                    marginRight: '0',
                    cursor: 'pointer'
                  },
                  directives: [{
                    name: 'access'
                  }],
                  on: {
                    click: () => {
                      self.transFlowHistoryDownLoadNew(a.row)
                    }
                  }
                }, '查看详情')
              ])
            } else {
              return h('div', a.row.remark)
            }
          }
        }
      ]
      let queryOld = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      // this.$axios.post('/payProduct/list', queryOld).then(function (res) {
      //   res.data.list.forEach(function (e, i) {
      //     if (e.status !== '0') {
      //       self.productNoAry.push(e)
      //     }
      //     (e.code === '1000') && (self.productMap['COLLECTION'] = e.name);
      //     (e.code === '1001') && (self.productMap['ACCOUNT'] = e.name)
      //   })
      // })
      // if (this.$route.params.payFlowIds) {
      //   if (this.$route.params.payFlowIds !== sessionStorage.getItem('flowingIntoGoldDetail.payFlowIds')){
      //     sessionStorage.setItem('flowingIntoGoldDetail.payFlowIds', this.$route.params.payFlowIds)
      //   }
      // } else {
      //   this.$route.params.payFlowIds = sessionStorage.getItem('flowingIntoGoldDetail.payFlowIds')
      // }
      if (this.payFlowIds) {
        this.searchList()
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
    transFlowHistoryDownLoadNew (row) {
      this.goodsInfo = row.goodsInfo
      let self = this
      // let query = self.formData
      self.$axios({
        method: 'get',
        url: 'outsideTransOrder/' + row.id,
        // data: query,
        responseType: 'arraybuffer'
      }).then(response => {
        self.transFlowHistoryDownLoadGoNew(response.data)
      }).catch((error) => {

      })
    },
    transFlowHistoryDownLoadGoNew (data) {
      if (!data) {
        return
      }
      let downName = this.goodsInfo + '.pdf' // 文件下载名称
      const blob = new Blob([data])
      if (window.navigator.msSaveOrOpenBlob) {
        // 兼容IE
        navigator.msSaveBlob(blob, downName)
      } else {
        let url = window.URL.createObjectURL(new Blob([data]))
        let link = document.createElement('a')
        link.style.display = 'none'
        link.href = url
        link.setAttribute('download', this.goodsInfo + '.pdf')
        document.body.appendChild(link)
        link.click()
      }
      // let url = window.URL.createObjectURL(new Blob([data]))
      // let link = document.createElement('a')
      // link.style.display = 'none'
      // link.href = url
      // link.setAttribute('download', '电子回单' + '.pdf')
      // document.body.appendChild(link)
      // link.click()
    },
    transFlowHistoryDownLoad () {
      let self = this
      // let query = self.formData
      self.$axios({
        method: 'get',
        url: '/transFlowHistory/download/' + this.selectDataId,
        // data: query,
        responseType: 'arraybuffer'
      }).then(response => {
        self.transFlowHistoryDownLoadGo(response.data)
      }).catch((error) => {

      })
    },
    transFlowHistoryDownLoadGo (data) {
      if (!data) {
        return
      }
      let downName = '电子回单.pdf' // 文件下载名称
      const blob = new Blob([data])
      if (window.navigator.msSaveOrOpenBlob) {
        // 兼容IE
        navigator.msSaveBlob(blob, downName)
      } else {
        let url = window.URL.createObjectURL(new Blob([data]))
        let link = document.createElement('a')
        link.style.display = 'none'
        link.href = url
        link.setAttribute('download', '电子回单' + '.pdf')
        document.body.appendChild(link)
        link.click()
      }
    },
    searchList () {
      let self = this
      this.formData.pageNo = self.pageNo
      this.formData.pageSize = self.pageSize
      if (this.beginTransDate) {
        this.formData.parameters.beginTransDate = this.beginTransDate
      } else {
        delete this.formData.parameters.beginTransDate
      }
      if (this.beginTransTime) {
        this.formData.parameters.beginTransTime = this.beginTransTime
      } else {
        delete this.formData.parameters.beginTransTime
      }
      if (this.endTransDate) {
        this.formData.parameters.endTransDate = this.endTransDate
      } else {
        delete this.formData.parameters.endTransDate
      }
      if (this.endTransTime) {
        this.formData.parameters.endTransTime = this.endTransTime
      } else {
        delete this.formData.parameters.endTransTime
      }
      // if (this.transOrderId) {
      //   this.formData.parameters.transOrderId = this.transOrderId
      // } else {
      //   delete this.formData.parameters.transOrderId
      // }
      if (this.merNo) {
        this.formData.parameters.merNo = this.merNo
      } else {
        delete this.formData.parameters.merNo
      }
      if (this.industryCode) {
        this.formData.parameters.industryCode = this.industryCode
      } else {
        delete this.formData.parameters.industryCode
      }
      this.formData.pageNo = self.pageNo
      this.formData.pageSize = self.pageSize
      self.formData.parameters.flowTransOrderId = this.payFlowIds
      let query = self.formData
      this.$axios.post('/outsideTransOrder/list', query)
        .then(function (response) {
          if (response.data.total.totalCount >= 1) {
            self.disBtn = false
          } else {
            self.disBtn = true
          }
          // response.data.page.list.forEach(function (e, i) {
          //   e.transDate = e.transDate + ' ' + e.transTime
          // })
          self.tableData = response.data.page.list
          self.total = response.data.total.totalCount.value
          self.totalCount = response.data.total.totalCount + '笔'
          self.disAction = true
          if (response.data.total.inTotalAmount) {
            self.totalMoney = response.data.total.inTotalAmount / 100 + '元'
          } else {
            self.totalMoney = 0 + '元'
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    selectDataGo (currentRow) {
      this.selectDataId = currentRow.serverTransId
      this.disAction = false
    },
    downLoad () {
      let self = this
      let query = self.formData
      self.$axios({
        method: 'post',
        url: '/outsideTransOrder/download',
        data: query,
        responseType: 'blob'
      }).then(response => {
        self.downloadGo(response.data)
      }).catch(function (err) {
        if (err.response.status === 500) {
          self.$Message.error('数据过多，请输入更多条件')
        }
      })
    },
    downloadGo (data) {
      if (!data) {
        return
      }
      let downName = '入金关联支付流水.xlsx' // 文件下载名称
      const blob = new Blob([data])
      if (window.navigator.msSaveOrOpenBlob) {
        // 兼容IE10
        navigator.msSaveBlob(blob, downName)
      } else {
        let url = window.URL.createObjectURL(new Blob([data]))
        let link = document.createElement('a')
        link.style.display = 'none'
        link.href = url
        link.setAttribute('download', '入金关联支付流水' + '.xlsx')
        document.body.appendChild(link)
        link.click()
      }
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
      this.beginTransDate = ''
      this.beginTransTime = ''
      this.endTransDate = ''
      this.endTradeDate = ''
      this.endTransTime = ''
      // this.transOrderId = ''
      this.industryCode = ''
      this.merNo = ''
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
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'flowingIntoGoldDetail', this.$route.params.payFlowIds)
    if (this.payFlowIds !== initParamVal) {
      this.payFlowIds = initParamVal
      this.init()
    }
  }

}
</script>
