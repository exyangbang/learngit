<style lang="less">
  @import '../../styles/common.less';
  .hidden {
    display: none;
  }
</style>
<template>
  <card>
    <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true" :rules="ruleValidate">
      <Row>
        <FormItem label="客户号：" prop="industryCode" >
          <Input v-model="formData.industryCode" style="width: 300px" placeholder="请输入客户号" :maxlength="12" />
        </FormItem>
        <FormItem  label="交易日期：" prop="transDate" >
          <Date-picker :options="beginDateOption" type="date" v-model="formData.transDate" :editable="false" placeholder="请选择交易日期" format="yyyyMMdd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem label="客户端流水号：" prop="clientTransId" >
          <Input v-model="formData.clientTransId" style="width: 300px" placeholder="请输入客户端流水号" :maxlength="32" />
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listReportForm">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
        </FormItem>
      </Row>
    </Form>
    <Row>
      <Table :columns="tableColumns" :data="tableData" border highlight-row stripe></Table><br/>
<!--      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>-->
    </Row>
  </card>
</template>
<script>export default {
  data () {
    return {
      industryCode: '',
      transDate: this.$moment(new Date()).format('YYYYMMDD'),
      clientTransId: '',
      formData: {
        industryCode: '',
        clientTransId: '',
        transDate: this.$moment(new Date()).format('YYYY-MM-DD')
      },
      tableColumns: [],
      tableData: [],
      orgData: [],
      beginDateOption: {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      },
      ruleValidate: {
        // beginTradeDate: [
        //   {required: true, trigger: 'blur', message: '请输入交易开始时间'}
        // ],
        industryCode: [
          {required: true, trigger: 'blur',message: '客户号必填不能为空'}
        ],
        clientTransId: [
          {required: true, trigger: 'blur', message: '客户端流水号不能为空'}
        ]
      }
    }
  },
  methods: {
    beginTradeDateChange (value) {
      this.transDate = value
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
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 400 * avg,
          title: '交易类型',
          key: 'tradeType',
          render (h, a, b) {
            return h('span', self.$contants.dictionary.totalTradeTypeMap[a.row.tradeType])
          }
        },
        {
          width: 400 * avg,
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
          title: '交易状态',
          key: 'transStatus',
          width: 400 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.transStatus === 'TRADE_SUCCESS') {
              res = '交易成功'
            }
            if (a.row.transStatus === 'TRADE_FAILURE') {
              res = '交易失败'
            }
            if (a.row.transStatus === 'PROCESSING') {
              res = '交易处理中'
            }
            return h('span', res)
          }
        },
      ]
      // let queryOld = {
      //   pageNo: 1,
      //   pageSize: 100,
      //   parameters: {}
      // }
      // this.$axios.post('/singleTransactionFlow', queryOld).then(function (res) {
      //   res.data.list.forEach(function (e, i) {
      //     if (e.status !== '0') {
      //       self.productNoAry.push(e)
      //     }
      //     // (e.code === '1000') && (self.productMap['COLLECTION'] = e.name);
      //     // (e.code === '1001') && (self.productMap['ACCOUNT'] = e.name)
      //   })
      // })
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
    statusChange (val) {
      this.status = val
    },
    transStatusChange (val) {
      this.transStatus = val
    },
    searchList () {
      let self = this
      // if (this.industryCode) {
      //   this.formData.parameters.industryCode = this.industryCode
      // } else {
      //   this.formData.parameters.industryCode = ''
      // }
      // if (this.transDate) {
      //   this.formData.parameters.transDate = this.transDate
      // } else {
      //   this.formData.parameters.transDate = ''
      // }
      // if (this.clientTransId) {
      //   this.formData.parameters.clientTransId = this.clientTransId
      // } else {
      //   this.formData.parameters.clientTransId = ''
      // }
      this.formData.transDate = this.transDate
      let query = self.formData
      debugger
      this.$axios.post('/singleTransactionFlow', query)
        .then(function (response) {
          self.tableData = ''
          self.tableData = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
      // }
      //   })
    },

    searchBtn () {
      if (this.formData.industryCode && this.formData.transDate && this.formData.clientTransId) {
        this.searchList()
      } else {
        this.$Message.error('请完整输入三个查询条件')
      }
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    resetBtn () {
      this.formData.industryCode = ''
      this.formData.transDate = ''
      this.formData.clientTransId = ''
      this.beginDateOption = {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      }
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
