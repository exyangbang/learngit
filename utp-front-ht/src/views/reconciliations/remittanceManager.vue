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
        <FormItem label="客户号：" prop="industryCode" >
          <Input v-model="industryCode" style="width: 300px" placeholder="请输入客户号" :maxlength="12" />
        </FormItem>
        <FormItem  label="交易日期：" prop="transDate" >
          <Date-picker type="date" v-model="transDate" :editable="false" placeholder="请选择清算日期" format="yyyyMMdd" @on-change="transDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem  label="清算日期：" prop="reconcileDate" >
          <Date-picker type="date" v-model="reconcileDate" :editable="false" placeholder="请选择清算日期" format="yyyyMMdd" @on-change="reconcileDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem label="收款方账号：" prop="payeeAcctNo" >
          <Input v-model="payeeAcctNo" style="width: 300px" placeholder="请输入收款方账号" :maxlength="accountSize" />
        </FormItem>
        <FormItem>
          <Button type="success" v-access id="addRemittance" @click="createBtn()" style="margin-right: 10px;">新增</Button>
          <Button type="primary" class="margin-left-10 " @click="searchBtn()" v-access id="remittanceList">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <Button type="success" class="margin-left-10" @click="downLoad" v-access id="downLoading" :disabled = "disDownLoad">导出</Button>
          <Button type="success" class="margin-left-10" v-access @click="remarkGoFun" id="remarkGoAgain" :disabled = "remarkGo">重新处理</Button>
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
      <Table :columns="tableColumns" :data="tableData" border @on-current-change="selectDataNew" highlight-row stripe ></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>export default {
  name: "remittanceManager",
  data () {
    return {
      totalCount: 0 + '笔',
      totalMoney: 0 + '元',
      runID: '',
      disDownLoad: true,
      remarkGo: true,
      isHidden: true,
      productNoAry: [],
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      reconcileDate: '',
      transDate: '',
      payeeAcctNo: '',
      orgCode: '',
      industryCode: '',
      formData: {
        // industryCode: '',
        // transDate: '',
        // reconcileDate: '',
        // payeeAcctNo: ''
      },
      tableColumns: [],
      tableData: [],
      orgData: [],
      total: 0,
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
    transDateChange (value) {
      this.transDate = value
    },
    reconcileDateChange (val) {
      this.reconcileDate = val
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
          width: 115 * avg,
          title: '客户号',
          key: 'industryCode'
        },
        {
          width: 115 * avg,
          title: '客户名称',
          key: 'industryName'
        },
        {
          width: 115 * avg,
          title: '客户端流水号',
          key: 'clientTransId'
        },
        {
          width: 120 * avg,
          title: '服务端流水号',
          key: 'serverTransId'
        },
        {
          width: 120 * avg,
          title: '交易日期',
          key: 'transDate',
          render: function (h, a, b) {
            let dateString = a.row.transDate.split('')[0] + a.row.transDate.split('')[1] + a.row.transDate.split('')[2] + a.row.transDate.split('')[3] + '-' + a.row.transDate.split('')[4] + a.row.transDate.split('')[5] + '-' + a.row.transDate.split('')[6] + a.row.transDate.split('')[7]
            return h('span', dateString)
          }
        },
        {
          width: 150 * avg,
          title: '清算日期',
          key: 'reconcileDate',
          render: function (h, a, b) {
            let dateString = a.row.reconcileDate.split('')[0] + a.row.reconcileDate.split('')[1] + a.row.reconcileDate.split('')[2] + a.row.reconcileDate.split('')[3] + '-' + a.row.reconcileDate.split('')[4] + a.row.reconcileDate.split('')[5] + '-' + a.row.reconcileDate.split('')[6] + a.row.reconcileDate.split('')[7]
            return h('span', dateString)
          }
        },
        {
          width: 150 * avg,
          title: '收款方户名',
          key: 'payeeName'
        },
        {
          width: 120 * avg,
          title: '收款方账号',
          key: 'payeeAcctNo'
        },
        {
          width: 120 * avg,
          title: '交易金额',
          key: 'transAmount',
          render: function (h, a, b) {
            return h('span', a.row.transAmount / 100 + '元')
          }
        },
        {
          width: 120 * avg,
          title: '处理状态',
          key: 'solveStatus',
          render (h, a, b) {
            return h('span', a.row.solveStatus == 0 ? '未处理' : '已处理')
          }
        },
        {
          width: 120 * avg,
          title: '操作员',
          key: 'userModified'
        },
        {
          width: 120 * avg,
          title: '最后操作时间',
          key: 'gmtModified',
          render: function (h, a, b) {
            if (this.row.gmtModified) {
              return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
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
      //     self.productNoAry.push(e)
      //   })
      // })
      // this.searchList()
      // this.searchOrg()
    },
    selectDataNew (currentRow) {

      if (currentRow.solveStatus === '0') {
        this.runID = currentRow.id
        this.remarkGo = false
      } else {
        this.remarkGo = true
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
    createBtn () {
      this.$router.push({
        name: 'addRemittance'
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
      if (this.transDate) {
        this.formData.transDate = this.transDate
      } else {
        delete this.formData.transDate
      }
      if (this.payeeAcctNo) {
        this.formData.payeeAcctNo = this.payeeAcctNo
      } else {
        delete this.formData.payeeAcctNo
      }
      let query = {
        pageNo: self.pageNo,
        pageSize: self.pageSize,
        parameters: this.formData
      }
      this.$axios.post('/transReexchange/list', query)
        .then(function (response) {
          self.tableData = []
          self.totalCount = response.data.total.totalCount + '笔'
          if (response.data.total.transAmount) {
            self.totalMoney = response.data.total.transAmount / 100 + '元'
          } else {
            self.totalMoney = 0 + '元'
          }
          self.tableData = response.data.page.list
          self.total = response.data.page.total

          if (response.data.total.totalCount >= 1) {
            self.disDownLoad = false
          } else {
            self.disDownLoad = true
            self.remarkGo = true
          }
        })
        .catch(function (error) {
          console.log(error)
        })
      // }
      //   })
    },
    remarkGoFun () {
      this.$Modal.confirm({
        title: '是否重新处理',
        content: '<p>是否重新处理</p>',
        onOk: () => {
          let self = this
          // let runQuery = {
          //   id: this.runID
          // }
          self.$axios.post('/transReexchange/' + this.runID).then(res => {
            if (res.status === 200) {
              self.$Message.success('重新处理成功！')
              self.searchList()
            }
          })
        },
        onCancel: () => {
          this.$Message.info('取消处理')
        }
      })
    },
    downLoad () {
      let self = this
      let query = {
        pageNo: self.pageNo,
        pageSize: self.pageSize,
        parameters: this.formData
      }
      self.$axios({
        method: 'post',
        url: '/transReexchange/download',
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
      let downName = '退汇对账单' + this.reconcileDate + '.xlsx' // 文件下载名称
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
        link.setAttribute('download', '退汇对账单' + this.reconcileDate + '.xlsx')
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
      this.searchList()
      // if (this.reconcileDate && this.industryCode) {
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
      this.transDate = ''
      this.industryCode = ''
      this.reconcileDate = ''
      this.payeeAcctNo = ''
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
