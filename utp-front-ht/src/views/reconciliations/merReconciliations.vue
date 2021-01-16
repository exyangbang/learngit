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
        <FormItem  label="清算日期：" prop="reconcileDate" >
          <!--<Time-picker confirm placeholder="选择时间" v-model="beginTransTime"  style="width: 168px"></Time-picker>-->
          <Date-picker type="date" v-model="reconcileDate" :editable="false" placeholder="请选择清算日期" format="yyyyMMdd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
          <!--<DatePicker :options="beginDateOption" v-model="settleDate" class="input-width-170" type="datetime"   format="yyyy-MM-dd HH:mm:ss" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>-->
        </FormItem>
        <FormItem label="客户号：" prop="industryCode" >
          <Input v-model="industryCode" style="width: 300px" placeholder="请输入客户号" :maxlength="12" />
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="merReconcileRecord">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <Button type="success" class="margin-left-10" @click="downLoad" v-access id="merReconcileRecordDownLoad" :disabled = "disDownLoad">下载对账单</Button>
        </FormItem>
      </Row>
    </Form>
    <Row style=" height: 40px; background: #9ea7b4; color: #fff; line-height: 40px; text-indent: 1.2em">
      <Col :span="4">
        <span>总笔数：{{totalCount}}</span>
      </Col>
      <Col :span="6">
        <span>总金额：{{totalMoney}}</span>
      </Col>
      <Col :span="4">
        <span>总手续费：{{totalFee}}</span>
      </Col>
    </Row>
    <Row>
      <Table :columns="tableColumns" :data="tableData" border highlight-row stripe></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>export default {
  name: "merReconciliations",
  data () {
    return {
      disDownLoad: true,
      isHidden: true,
      productNoAry: [],
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      reconcileDate: '',
      orgCode: '',
      industryCode: '',
      formData: {},
      tableColumns: [],
      tableData: [],
      orgData: [],
      totalCount: 0 + '笔',
      total: 0,
      totalMoney: 0 + '元',
      totalFee: 0 + '元',
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
      this.reconcileDate = value
      // if (this.merNo) {
      //   this.disDownLoad = false
      // }
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
          title: '清算日期',
          key: 'reconcileDate'
        },
        {
          width: 100 * avg,
          title: '客户端流水号',
          key: 'clientTransId'
        },
        {
          width: 100 * avg,
          title: '服务端流水号',
          key: 'serverTransId'
        },
        // {
        //   width: 100 * avg,
        //   title: '机构编号',
        //   key: 'orgCode'
        //   render: function (h) {
        //     return h('span', self.$contants.dictionary.bizTypeMap[this.row.bizType])
        //   }
        // },
        {
          width: 100 * avg,
          title: '收款人账户名称',
          key: 'payeeName'
        },
        {
          width: 100 * avg,
          title: '收款人账号',
          key: 'payeeAcctNo'
        },
        {
          width: 150 * avg,
          title: '交易日期',
          key: 'transDate',
          render: function (h, a, b) {
            let dateString = a.row.transDate.split('')[0] + a.row.transDate.split('')[1] + a.row.transDate.split('')[2] + a.row.transDate.split('')[3] + '-' + a.row.transDate.split('')[4] + a.row.transDate.split('')[5] + '-' + a.row.transDate.split('')[6] + a.row.transDate.split('')[7]
            return h('span', dateString)
          }
        },
        {
          width: 150 * avg,
          title: '交易时间',
          key: 'transTime',
          render: function (h, a, b) {
            let timeString = a.row.transTime.split('')[0] + a.row.transTime.split('')[1] + ':' + a.row.transTime.split('')[2] + a.row.transTime.split('')[3] + ':' + a.row.transTime.split('')[4] + a.row.transTime.split('')[5]
            return h('span', timeString)
          }
        },
        {
          width: 100 * avg,
          title: '产品类型',
          key: 'productCode'
          // render: function (h, a, b) {
          //   let getReslt = ''
          //   if (a.row.productCode === 'ACCOUNT') {
          //     getReslt = '代付'
          //   }
          //   return h('span', getReslt)
          // }
        },
        {
          width: 100 * avg,
          title: '交易类型',
          key: 'tradeType',
          render (h, a, b) {
            return h('span', self.$contants.dictionary.totalTradeTypeMap[a.row.tradeType])
          }

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
          title: '手续费',
          key: 'merFee',
          render (h, a, b) {
            return h('span', a.row.merFee / 100 + '元')
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
          self.productNoAry.push(e)
        })
      })
      // this.searchList()
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
    searchList () {
      let self = this
      this.formData = {}
      if (this.industryCode) {
        this.formData.industryCode = this.industryCode
      } else {
        delete this.formData.industryCode
      }
      if (this.reconcileDate) {
        this.formData.reconcileDate = this.reconcileDate
      } else {
        delete this.formData.reconcileDate
      }
      let query = {
        pageNo: self.pageNo,
        pageSize: self.pageSize,
        parameters: this.formData
      }
      this.$axios.post('/indSettleSumInfo/list', query)
        .then(function (response) {
          self.tableData = ''
          self.tableData = response.data.page.list
          if (response.data.total !== null) {
            self.totalMoney = response.data.total.totalAmount / 100 + '元'
          } else {
            self.totalMoney = 0 + '元'
          }
          if (response.data.total !== null) {
            self.totalFee = response.data.total.totalFee / 100 + '元'
          } else {
            self.totalFee = 0 + '元'
          }
          if (response.data.total !== null) {
            self.totalCount = response.data.page.total + '笔'
          } else {
            self.totalCount = 0 + '笔'
          }
          self.total = response.data.page.total
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
      if (!this.reconcileDate && !this.industryCode) {
        this.$Message.error('请完整输入两个查询条件')
        return
      }
      let self = this
      self.$axios({
        method: 'get',
        url: '/indSettleSumInfo/download/' + this.reconcileDate + '/' + this.industryCode,
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
      let downName = '客户对账单' + this.reconcileDate + '.xlsx' // 文件下载名称
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
        link.setAttribute('download', '客户对账单' + this.reconcileDate + '.xlsx')
        document.body.appendChild(link)
        link.click()
        // let aTag = document.createElement('a')
        // aTag.download = downName
        // aTag.href = URL.createObjectURL(blob)
        // aTag.click()
        // URL.revokeObjectURL(aTag.href)
      }

    },
    searchBtn () {
      this.pageNo = 1
      if (this.reconcileDate && this.industryCode) {
        this.searchList()
      } else {
        this.$Message.error('请完整输入两个查询条件')
      }
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    resetBtn () {
      this.industryCode = ''
      this.reconcileDate = ''
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
  activated() {
      this.searchList()
  }
}
</script>
