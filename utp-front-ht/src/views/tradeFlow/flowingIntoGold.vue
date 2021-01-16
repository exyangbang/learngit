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
        <FormItem label="入金流水号：" prop="coreNo" >
          <Input v-model="coreNo" style="width: 300px" placeholder="请输入入金流水号" :maxlength="50" />
        </FormItem>
        <FormItem label="客户号：" prop="industryCode" >
          <Input v-model="industryCode" style="width: 300px" placeholder="请输入客户号" :maxlength="30" />
        </FormItem>
        <FormItem label="客户名称：" prop="industryName" >
          <Input v-model="industryName" style="width: 300px" placeholder="请输入客户名称" :maxlength="90" />
        </FormItem>
        <FormItem label="收款人账号：" prop="autoPayeeAcctAo" >
          <Input v-model="autoPayeeAcctAo" style="width: 300px" placeholder="请输入收款人账号" :maxlength="32" />
        </FormItem>
        <FormItem label="收款人名称：" prop="autoPayeeAcctName" >
          <Input v-model="autoPayeeAcctName" style="width: 300px" placeholder="请输入收款人名称" :maxlength="32" />
        </FormItem>
        <FormItem  label="开始日期：" prop="beginDateOption" >
          <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false" placeholder="请选择开始日期" format="yyyyMMdd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem  label="结束日期：" prop="transEndDate" >
          <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false" placeholder="请选择结束日期" format="yyyyMMdd" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listReportForm">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
<!--          <Button type="success" class="margin-left-10" v-access id="listReportFormDownLoad" @click="downLoad" :disabled = "disDownLoad">导出</Button>-->
        </FormItem>
      </Row>
    </Form>
    <Row>
      <Table :columns="tableColumns" :data="tableData" border highlight-row stripe></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>export default {
  // name: "listSplitInfo",
  data () {
    return {
      coreNo: '',
      industryCode: '',
      industryName: '',
      autoPayeeAcctAo: '',
      autoPayeeAcctName: '',
      transBeginDate: this.$moment(new Date()).format('YYYYMMDD'),
      transEndDate: this.$moment(new Date()).format('YYYYMMDD'),
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
      this.transBeginDate = value
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return date && date.valueOf() < dateGet.valueOf() - 86400000
        }
      }
    },
    endTradeDateChange (value) {
      this.transEndDate = value
     // this.endTransDatetime = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
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
    init () {
      // let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 150 * avg,
          title: '入金流水号',
          key: 'coreNo'
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
          title: '收款人账号',
          key: 'autoPayeeAcctAo'
        },
        {
          width: 150 * avg,
          title: '收款人名称',
          key: 'autoPayeeAcctName'
        },
        {
          width: 150 * avg,
          title: '付款人账号',
          key: 'exAcctNo'
        },
        {
          width: 150 * avg,
          title: '付款人名称',
          key: 'exAcctName'
        },
        {
          width: 150 * avg,
          title: '交易金额',
          key: 'amt',
          render: function (h, a, b) {
            let getReslt = ''
            if (a.row.amt) {
              getReslt = a.row.amt / 100
            }
            return h('span', getReslt + '元')
          }
        },
        {
          width: 150 * avg,
          title: '交易日期',
          key: 'tranDate'
          // render (h, a, b) {
          //   return h('span', a.row.totalAmount / 100 + '元')
          // }
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
                  title: '查看关联支付流水'
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
              }, '查看关联支付流水')
            ])
          }
        }
      ]
      this.searchList()
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
      if (row.incomeFlowId !== null) {
        this.$router.push({
          name: 'flowingIntoGoldDetail',
          params: {
            payFlowIds: row.incomeFlowId
          }
        })
      } else {
        this.$Message.error('关联支付流水不存在')
      }
    },
    statusChange (val) {
      this.status = val
    },
    transStatusChange (val) {
      this.transStatus = val
    },
    searchList () {
      let self = this
      if (this.transBeginDate.length === 8) {
        this.formData.parameters.transBeginDate = this.transBeginDate
      } else {
        this.formData.parameters.transBeginDate = this.$moment(this.transBeginDate).format("YYYYMMDD")
      }
      if (this.transEndDate.length === 8) {
        this.formData.parameters.transEndDate = this.transEndDate
      } else {
        this.formData.parameters.transEndDate = this.$moment(this.transEndDate).format("YYYYMMDD")
      }
      if (this.coreNo) {
        this.formData.parameters.coreNo = this.coreNo
      } else {
        delete this.formData.parameters.coreNo
      }
      if (this.industryCode) {
        this.formData.parameters.industryCode = this.industryCode
      } else {
        delete this.formData.parameters.industryCode
      }
      if (this.industryName) {
        this.formData.parameters.industryName = this.industryName
      } else {
        delete this.formData.parameters.name
      }
      if (this.autoPayeeAcctAo) {
        this.formData.parameters.autoPayeeAcctAo = this.autoPayeeAcctAo
      } else {
        delete this.formData.parameters.autoPayeeAcctAo
      }
      if (this.autoPayeeAcctName) {
        this.formData.parameters.autoPayeeAcctName = this.autoPayeeAcctName
      } else {
        delete this.formData.parameters.autoPayeeAcctName
      }
      this.formData.pageNo = self.pageNo
      this.formData.pageSize = self.pageSize
      let query = self.formData
      this.$axios.post('/flowingIntoGold/list', query)
        .then(function (response) {
          self.tableData = ''
          self.tableData = response.data.list
          self.total = response.data.total
          self.totalCount = parseInt(response.data.pages)
        })
        .catch(function (error) {
          console.log(error)
        })
      // }
      //   })
    },
    searchBtn () {
      this.pageNo = 1
      this.searchList()
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    resetBtn () {
      this.coreNo = ''
      this.industryCode = ''
      this.industryName = ''
      this.autoPayeeAcctAo = ''
      this.autoPayeeAcctName = ''
      this.transBeginDate = this.$moment(new Date()).format('YYYYMMDD')
      this.transEndDate = this.$moment(new Date()).format('YYYYMMDD')
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
  activated () {
    this.searchList()
  }
}
</script>
