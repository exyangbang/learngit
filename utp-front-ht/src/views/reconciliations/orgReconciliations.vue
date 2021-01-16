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
        <FormItem  label="清算日期：" prop="" >
          <Date-picker type="date" :editable="false" v-model="reconcileDate" placeholder="请选择清算日期" format="yyyyMMdd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem label="机构：" prop="orgCode" >
          <Select v-model="orgCode" class="input-width-170" @on-change="chanOrg">
            <Option v-for="item in orgData" :value="item.orgCode" :key="item.orgCode">{{ item.fullName }}</Option>
          </Select>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listTradeFlowCash">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <Button type="success" class="margin-left-10" @click="downLoad" :disabled = "disDownLoad">下载对账单</Button>
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
      <Table :columns="tableColumns" :data="tableData" border stripe ></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>export default {
  name: "orgReconciliations",
  data () {
    return {
      disDownLoad: true,
      isHidden: true,
      productNoAry: [],
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      reconcileDate: '',
      orgCode: '',
      merNo: '',
      formData: {},
      tableColumns: [],
      tableData: [],
      orgData: [],
      totalCount: 0,
      total: 0,
      totalMoney: 0,
      totalFee: 0,
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
      // if (this.orgCode) {
      //   this.disDownLoad = false
      // }
    },
    chanOrg (val) {
      this.orgCode = val
      // if (this.reconcileDate) {
      //   this.disDownLoad = false
      // }
    },
    init () {
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 150 * avg,
          title: '清算日期',
          key: 'reconcileDate',
          render: function (h, a, b) {
            let dateString = a.row.reconcileDate.split('')[0] + a.row.reconcileDate.split('')[1] + a.row.reconcileDate.split('')[2] + a.row.reconcileDate.split('')[3] + '-' + a.row.reconcileDate.split('')[4] + a.row.reconcileDate.split('')[5] + '-' + a.row.reconcileDate.split('')[6] + a.row.reconcileDate.split('')[7]
            return h('span', dateString)
          }
        },
        // {
        //   width: 150 * avg,
        //   title: '客户端流水号',
        //   key: 'clientTransId'
        // },
        // {
        //   width: 100 * avg,
        //   title: '服务端流水号',
        //   key: 'serverTransId'
        // },
        {
          width: 150 * avg,
          title: '机构编号',
          key: 'orgCode'
          // render: function (h) {
          //   return h('span', self.$contants.dictionary.bizTypeMap[this.row.bizType])
          // }
        },
        {
          width: 150 * avg,
          title: '商户号',
          key: 'merNo'
          // render: function (h) {
          //   return h('span', self.$contants.dictionary.txnTypeMap[this.row.txnType])
          // }
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
        // {
        //   width: 150 * avg,
        //   title: '交易时间',
        //   key: 'transTime'
        // },
        {
          width: 150 * avg,
          title: '产品类型',
          key: 'productCode'
        },
        {
          width: 100 * avg,
          title: '交易类型',
          key: 'tradeType'
        },
        {
          width: 180 * avg,
          title: '交易总笔数',
          key: 'totalCount'
          // render: function (h) {
          //   return h('span', self.$util.formatTXNTime(this.row.txnTime)) 35+42.5+40.5
          // }
        },
        {
          width: 120 * avg,
          title: '交易总金额',
          key: 'totalAmount',
          render (h, a, b) {
            return h('span', a.row.totalAmount / 100 + '元')
          }
        },
        {
          width: 120 * avg,
          title: '总手续费',
          key: 'totalFee',
          render (h, a, b) {
            return h('span', a.row.totalFee / 100 + '元')
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
      if (this.orgCode) {
        this.formData.orgCode = this.orgCode
      }
      if (this.reconcileDate) {
        this.formData.reconcileDate = this.reconcileDate
      }
      let query = {
        pageNo: self.pageNo,
        pageSize: self.pageSize,
        parameters: this.formData
      }
      this.$axios.post('/orgSettleSumInfo/list', query)
        .then(function (response) {
          self.tableData = response.data.page.list
          if (response.data.total !== null) {
            self.totalMoney = response.data.total.totalAmount / 100
          } else {
            self.totalMoney = 0
          }
          if (response.data.total !== null) {
            self.totalFee = response.data.total.totalFee / 100
          } else {
            self.totalFee = 0
          }
          if (response.data.total !== null) {
            self.totalCount = response.data.total.totalCount
          } else {
            self.totalCount = 0
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
      let self = this
      self.$axios({
        method: 'get',
        url: '/orgSettleSumInfo/download/' + this.reconcileDate + '/' + this.orgCode,
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
      let url = window.URL.createObjectURL(new Blob([data]))
      let link = document.createElement('a')
      link.style.display = 'none'
      link.href = url
      link.setAttribute('download', '机构对账单' + this.reconcileDate + '.xlsx')
      document.body.appendChild(link)
      link.click()
    },
    searchBtn () {
      this.pageNo = 1
      if (this.reconcileDate && this.orgCode) {
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
      this.orgCode = ''
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
