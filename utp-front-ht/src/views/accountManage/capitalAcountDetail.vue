<style lang="less">
  @import '../../styles/common.less';
  .hidden {
    display: none;
  }
</style>
<template>
  <card>
    <Row style=" height: 40px; background: #9ea7b4; color: #fff; line-height: 40px; text-indent: 1.2em; width: 100%">
      <Col :span="8">
        <span>客户数量：{{userTotal}}</span>
      </Col>
      <Col :span="8">
        <span>总余额：{{totalAmount}}</span>
      </Col>
      <Col :span="8">
        <span>总冻结金额：{{totalBalance}}</span>
      </Col>
    </Row>
    <Row>
      <Table :columns="tableColumns" :data="tableData" border stripe ></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>export default {
  name: 'capitalAcountDetail',
  data () {
    return {
      userTotal: 0,
      totalAmount: 0,
      accountNo: '',
      totalBalance: 0,
      accountNum: '',
      bankAccountName: '',
      total: 0,
      formData: {},
      tableColumns: [],
      tableData: [],
      orgData: [],
      pageNo: 1,
      pageSize: 10,
      id: this.$route.params.id,
      bankAccountNo: this.$route.params.bankAccountNo
    }
  },
  methods: {
    init () {
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 250 * avg,
          title: '客户号',
          key: 'code'
        },
        {
          width: 250 * avg,
          title: '客户名称',
          key: 'name'
        },

        {
          width: 250 * avg,
          title: '创建时间',
          key: 'gmtCreate',
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '账户余额',
          key: 'balance',
          width: 250 * avg,
          render (h, a, b) {
            return h('span', a.row.balance / 100 + '元')
          }
        },
        {
          width: 250 * avg,
          title: '可用余额',
          key: 'availAmount',
          render (h, a, b) {
            if (a.row.availAmount === '0元' || a.row.availAmount === null) {
              return h('span', '')
            } else {
              return h('span', a.row.availAmount / 100 + '元')
            }
          }
        },
        {
          width: 250 * avg,
          title: '冻结金额',
          key: 'frozenAmount',
          render (h, a, b) {
            if (a.row.frozenAmount === '0元' || a.row.frozenAmount === null) {
              return h('span', '')
            } else {
              return h('span', a.row.frozenAmount / 100 + '元')
            }
          }
        }
      ]
      if (this.id){
        this.searchList()
      }
    },
    searchList () {
      let self = this
      // let id = localStorage.getItem('capitalAcountDetailID')
      // let bankAccountNo = localStorage.getItem('bankAccountNo')
      let query = {
        pageNo: self.pageNo,
        pageSize: self.pageSize,
        parameters: {
          id: this.id,
          bankAccountNo: this.bankAccountNo
        }
      }
      this.$axios.post('/fundAccount/listDeatil', query)
        .then(function (response) {
          self.tableData = ''
          self.tableData = response.data.page.list
          if (response.data.total.totalCount === '0') {
            self.userTotal = 0
          } else {
            self.userTotal = response.data.total.totalCount + '个'
          }
          if (response.data.total.totalAvailAmount) {
            self.totalAmount = response.data.total.totalAvailAmount / 100 + '元'
          } else {

          }
          if (response.data.total.totalFrozenAmount) {
            self.totalBalance = response.data.total.totalFrozenAmount / 100 + '元'
          }

          self.total = parseInt(response.data.page.total)
        })
        .catch(function (error) {
          console.log(error)
        })
      // }
      //   })
    },

    doDelete (row) {
      this.$axios.delete('/fundAccount/' + row.id)
        .then((res) => {
          if (res.status === 200) {
            this.$Message.success('删除成功！')
            this.searchList()
          } else {
            this.$Message.error('删除失败！')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
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
    let initParamVal = this.$util.getRefreshInitParam(this, 'capitalAcountDetailId', this.$route.params.id)
    let temBankAccountNo = this.$util.getRefreshInitParam(this, 'capitalAcountDetailBankAccountNo', this.$route.params.bankAccountNo)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.bankAccountNo = temBankAccountNo
      this.searchList()
    }
  }
}
</script>
