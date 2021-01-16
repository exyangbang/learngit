<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <!-- 3-个人/2-企业商户企业/8-个体工商户账户7-佣金账户 有绑卡-->
<!--    <Row  v-if="this.objType == 3||this.objType == 2||this.objType == 8 ||this.objType == 7">-->
      <Col>
        <Table border :columns="tableColumns" :data="tableData" highlight-row stripe></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
<!--    </Row>-->
  </card>
</template>
<script>
export default {
  name: 'accountBankCardList',
  data () {
    return {
      id: this.$route.params.id,
      account: this.$route.params.account,
      bindStatus: this.$route.params.bindStatus,
      danWei: '',
      total: 0,
      currentPage: 1,
      roleList: [],
      formData: {},
      provinceAry: [],
      cityAry: [],
      disCity: false,
      disCounty: false,
      tableColumns: [],
      tableData: [],
      parameters: {
        account: '',
        bindStatus: ''
      }
    }
  },
  methods: {
    init () {
      let self = this
      if (this.id) {
        let avg = (document.body.clientWidth) / 1440
        this.tableColumns = [
          {
            title: '序号',
            type: 'index',
            width: 100
          },
          {
            title: '户名',
            key: 'accountName',
            width: 200 * avg
          },
          {
            title: '银行账号',
            key: 'accountNo',
            width: 200 * avg
          },
          {
            title: '开户行号',
            key: 'bankCode',
            width: 200 * avg
          },
          {
            title: '开户行名称',
            key: 'bankName',
            width: 200 * avg
          },
          {
            title: '清算行号',
            key: 'receiveBankCode',
            width: 200 * avg
          },
          {
            title: '绑定状态',
            key: 'bindStatus',
            width: 200 * avg,
            render (h, a, b) {
              let res = ''
              if (a.row.bindStatus === '0') {
                res = '正常'
              }
              if (a.row.bindStatus === '1') {
                res = '打款处理中'
              }
              if (a.row.bindStatus === '2') {
                res = '打款失败'
              }
              if (a.row.bindStatus === '3') {
                res = '打款成功待验证'
              }
              if (a.row.bindStatus === '4') {
                res = '验证失败'
              }
              if (a.row.bindStatus === '5') {
                res = '冻结'
              }
              if (a.row.bindStatus === '6') {
                res = '解绑'
              }
              return h('span', res)
            }
          },
          {
            title: '最新操作时间',
            key: 'gmtModified',
            width: 200 * avg,
            render (h, a, b) {
              if (this.row.gmtModified) {
                return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
              }
            }
          }
        ]
        // if (this.account) {
        //   sessionStorage.setItem('accountBankCardList.account', this.$route.params.account)
        //   sessionStorage.setItem('accountBankCardList.bindStatus', this.$route.params.bindStatus)
        // } else {
        //   this.account = sessionStorage.getItem('accountBankCardList.account')
        //   this.account = sessionStorage.getItem('accountBankCardList.bindStatus')
        // }
        if (this.account) {
          this.getOrganizationDetail()
        }
      }
    },
    getOrganizationDetail (param) {
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      let self = this
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      this.parameters.account = this.account
      this.parameters.bindStatus = this.bindStatus === '0' ? '0' : null
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/merchantAccountInfo/list')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: this.parameters}

      this.$axios.post(uri, this.query)
        .then(function (response) {
          self.formData = response.data
          self.tableData = response.data.list
          self.total = parseInt(response.data.total)

        })
        .catch(function (error) {
          console.log(error)
        })
    },
    changePage (index) {
      // 分页点击事件
      this.currentPage = parseInt(index)
      this.getOrganizationDetail()
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    this.init()
  },
  computed: {
  },
  mounted () {
  },
  activated () {
    let tempid = this.$util.getRefreshInitParam(this, 'accountBankCardListid', this.$route.params.id)
    let tempaccount = this.$util.getRefreshInitParam(this, 'accountBankCardListaccount', this.$route.params.account)
    let tempidbindStatus = this.$util.getRefreshInitParam(this, 'accountBankCardListbindStatus', this.$route.params.bindStatus)
    if (tempid !== null) {
      this.id = tempid
      this.account = tempaccount
      this.bindStatus = tempidbindStatus
      this.init()
    }
  }
}
</script>
