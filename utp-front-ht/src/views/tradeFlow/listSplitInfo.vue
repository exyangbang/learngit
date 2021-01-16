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
        <FormItem  label="清算开始日期：" prop="beginDateOption" >
          <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem  label="清算结束日期：" prop="transEndDate" >
          <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem label="客户号：" prop="industryCode" >
          <Input v-model="industryCode" style="width: 300px" placeholder="请输入客户号" :maxlength="12" />
        </FormItem>
        <FormItem label="用户虚拟账户：" prop="userAccount" >
          <Input v-model="userAccount" style="width: 300px" placeholder="请输入用户虚拟账户" :maxlength="32" />
        </FormItem>
        <FormItem label="批次号：" prop="batchId">
          <Input v-model="batchId" :maxlength="accountSize" class="input-width-170"/>
        </FormItem>
        <FormItem label="入账状态：" prop="status">
          <Select v-model="status" style="width: 180px"  @on-change="statusChange">
            <i-option value="0">未入账</i-option>
            <i-option value="1">已入账</i-option>
          </Select>
        </FormItem>
        <FormItem label="交易状态：" prop="transStatus">
          <Select v-model="transStatus" style="width: 180px"  @on-change="transStatusChange">
            <i-option value="PRE_CREATE">创建订单</i-option>
            <i-option value="PROCESSING">处理中</i-option>
            <i-option value="TRADE_SUCCESS">交易成功</i-option>
            <i-option value="TRADE_FAILURE">交易失败</i-option>
            <i-option value="TRADE_ERROR">处理异常</i-option>
          </Select>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listReportForm">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <Button type="success" class="margin-left-10" v-access id="listReportFormDownLoad" @click="downLoad" :disabled = "disDownLoad">导出</Button>
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
      <!--<Col :span="6">-->
        <!--<span>渠道交易总手续费：{{totalChannelFee}}</span>-->
      <!--</Col>-->
      <!--<Col :span="6">-->
        <!--<span>客户交易总手续费：{{totalIndustryFee}}</span>-->
      <!--</Col>-->
    </Row>
    <Row>
      <Table :columns="tableColumns" :data="tableData" border highlight-row stripe></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>export default {
  name: "listSplitInfo",
  data () {
    return {
      transStatus: '',
      status: '',
      batchId: '',
      disDownLoad: true,
      isHidden: true,
      year: new Date().getFullYear(),
      month: new Date().getMonth(),
      day: new Date().getDay(),
      // transBeginDate: this.$moment(new Date()).format('YYYY-MM-DD'),
      // transEndDate: this.$moment(new Date()).format('YYYY-MM-DD'),
      productNoAry: [],
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      reconcileDate: '',
      orgCode: '',
      industryCode: '',
      userAccount: '',
      productCode: '',
      formData: {
        parameters: {
        }
      },
      tableColumns: [],
      tableData: [],
      orgData: [],
      totalCount: 0 + '笔',
      total: 0,
      totalMoney: 0 + '元',
      totalFee: 0,
      totalChannelFee: 0,
      totalIndustryFee: 0,
      pageNo: 1,
      pageSize: 10,
      endTransDatetime: '',
      beginTransDatetime: '',
      beginDateOption: {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      },
      endDateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000
        }
      },
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
      this.beginTransDatetime = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return date && date.valueOf() < dateGet.valueOf() - 86400000
        }
      }
    },
    endTradeDateChange (value) {
      this.endTransDatetime = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
        }
      }
    },
    getDateStr (AddDayCount) {
      var dd = new Date()
      dd.setDate(dd.getDate() + AddDayCount)
      var year = dd.getFullYear()
      var mon = dd.getMonth() + 1
      var day = dd.getDate()
      return year + '' + mon + '' + day
    },
    chanProduct (val) {
      this.productCode = val
    },
    // chanMer () {
    //   if (this.reconcileDate) {
    //     this.disDownLoad = false
    //   }
    // },
    init () {
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 100 * avg,
          title: '批次号',
          key: 'batchId'
        },
        {
          width: 150 * avg,
          title: '清算日期',
          key: 'settleDate'
        },
        {
          width: 150 * avg,
          title: '客户号',
          key: 'industryCode'
        },
        {
          width: 150 * avg,
          title: '客户名称',
          key: 'industryName'
        },
        {
          width: 150 * avg,
          title: '客户端流水号',
          key: 'clientTransId'
        },
        {
          width: 150 * avg,
          title: '用户账户',
          key: 'userAccount'
        },
        {
          width: 150 * avg,
          title: '用户户名',
          key: 'objName'
        },
        {
          width: 150 * avg,
          title: '金额',
          key: 'clientTransId',
          render: function (h, a, b) {
            let getReslt = ''
            if (a.row.amount) {
              getReslt = a.row.amount / 100
            }
            return h('span', getReslt + '元')
          }
        },
        {
          width: 150 * avg,
          title: '结算方式',
          key: 'settleMode',
          render: function (h, a, b) {
            let getReslt = ''
            if (a.row.settleMode === '0') {
              getReslt = '代付结算'
            }
            if (a.row.settleMode === '1') {
              getReslt = '记账结算'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 150 * avg,
          title: '账期',
          key: 'splitDate'
          // render (h, a, b) {
          //   return h('span', a.row.totalAmount / 100 + '元')
          // }
        },
        {
          width: 150 * avg,
          title: '入账状态',
          key: 'status',
          render: function (h, a, b) {
            let getReslt = ''
            if (a.row.status === '0') {
              getReslt = '未入账'
            }
            if (a.row.status === '1') {
              getReslt = '已入账'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 150 * avg,
          title: '交易状态',
          key: 'transStatus',
          render: function (h, a, b) {
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
              getReslt = '处理异常'
            }
            return h('span', getReslt)
          }
        },
        {
          title: '提现结果描述',
          key: 'transDesc',
          width: 150 * avg,
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
                  title: params.row.transDesc
                }
              }, params.row.transDesc)
            ])
          }
        },
        {
          width: 150 * avg,
          title: '备注说明',
          key: 'remark'
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 150 * avg,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'detailProduct',
                  title: '关联支付流水'
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
                    this.showDetail(params.row)
                  }
                }
              }, '关联支付流水')
            ])
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
      //     self.productNoAry.push(e)
      //   })
      // })
      this.$axios.post('/payProduct/list', queryOld).then(function (res) {
        res.data.list.forEach(function (e, i) {
          if (e.status !== '0') {
            self.productNoAry.push(e)
          }
          // (e.code === '1000') && (self.productMap['COLLECTION'] = e.name);
          // (e.code === '1001') && (self.productMap['ACCOUNT'] = e.name)
        })
      })
      this.searchList()
      // this.searchOrg()
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

    showDetail (row) {
      this.$router.push({
        name: 'listSplitInfoDetail',
        params: {
          transOrderId: row.extend_1
        }
      })
    },
    statusChange (val) {
      this.status = val
    },
    transStatusChange (val) {
      this.transStatus = val
    },
    searchList () {
      let self = this
      if (this.beginTransDatetime) {
        this.formData.parameters.beginTransDatetime = this.beginTransDatetime
      } else {
        delete this.formData.parameters.beginTransDatetime
      }
      if (this.batchId) {
        this.formData.parameters.batchId = this.batchId
      } else {
        delete this.formData.parameters.batchId
      }
      if (this.endTransDatetime) {
        this.formData.parameters.endTransDatetime = this.endTransDatetime
      } else {
        delete this.formData.parameters.endTransDatetime
      }
      if (this.industryCode) {
        this.formData.parameters.industryCode = this.industryCode
      } else {
        delete this.formData.parameters.industryCode
      }
      if (this.userAccount) {
        this.formData.parameters.userAccount = this.userAccount
      } else {
        delete this.formData.parameters.userAccount
      }
      if (this.status) {
        this.formData.parameters.status = this.status
      } else {
        delete this.formData.parameters.status
      }
      if (this.transStatus) {
        this.formData.parameters.transStatus = this.transStatus
      } else {
        delete this.formData.parameters.transStatus
      }
      this.formData.pageNo = self.pageNo
      this.formData.pageSize = self.pageSize
      let query = self.formData
      this.$axios.post('/splitInfo/list', query)
        .then(function (response) {
          self.tableData = ''
          self.tableData = response.data.page.list
          self.total = response.data.page.total
          self.totalCount = response.data.total.totalCount
          self.totalMoney = response.data.total.inTotalAmount / 100 + '元'
          if (self.tableData.length > 0) {
            self.disDownLoad = false
          } else {
            self.disDownLoad = true
          }
        })
        .catch(function (error) {
          console.log(error)
        })
      // }
      //   })
    },

    downLoad () {
      let self = this
      let query = this.formData
      self.$axios({
        method: 'post',
        url: '/splitInfo/download',
        data: query,
        responseType: 'blob'
      }).then(response => {
        self.download(response.data)
      }).catch((error) => {

      })
    },
    download (data) {
      if (!data) {
        return
      }
      // let dateLast = this.$moment(this.transEndDate).format('YYYYMMDD')
      let downName = '平台分账信息' + '.xlsx' // 文件下载名称
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
        // let dateLast = this.$moment(this.transEndDate).format('YYYYMMDD')
        link.setAttribute('download', '平台分账信息' + '.xlsx')
        document.body.appendChild(link)
        link.click()
      }

    },
    searchBtn () {
      this.pageNo = 1
      this.searchList()
      // if (this.reconcileDate && this.merNo) {
      //   this.searchList()
      // } else {
      //   this.$Message.error('请完整输入两个查询条件')
      // }
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    resetBtn () {
      this.transStatus = ''
      this.status = ''
      this.batchId = ''
      this.industryCode = ''
      this.userAccount = ''
      this.transBeginDate = ''
      this.transEndDate = ''
      this.beginTransDatetime = ''
      this.endTransDatetime = ''
      this.beginDateOption = {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      }
      this.endDateOption = {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000
        }
      }
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
  },
  activated() {
      this.searchList()
  }
}
</script>
