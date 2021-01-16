<style lang="less">
  .ivu-table-row-highlight td {
    background-color: #B6E2FC!important;
  }
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem  label="交易开始日期：" prop="beginTradeDate" >
            <DatePicker :options="beginDateOption" v-model="beginTradeDate" :clearable="false" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>
          </FormItem>
          <FormItem label="交易开始时间：" prop="beginTransTime">
            <Time-picker type="time" placeholder="请选择时间" :clearable="false" :editable="false" v-model="beginTransTime" @on-change="beginTimeFun" style="width: 168px"></Time-picker>
          </FormItem>
          <FormItem label="交易结束日期：" prop="endTradeDate" >
            <DatePicker :options="endDateOption" v-model="endTradeDate" :clearable="false" class="input-width-170" type="date" :editable="false" format="yyyy-MM-dd" placeholder="请选择交易结束日期" @on-change="endTradeDateChange"></DatePicker>
          </FormItem>
          <FormItem label="交易结束时间：" prop="endTransTime" >
            <Time-picker type="time" placeholder="请选择时间" :clearable="false" :editable="false" v-model="endTransTime" @on-change="endTimeFun"  style="width: 168px"></Time-picker>
          </FormItem>
          <FormItem label="资金操作：" prop="operateType">
            <Select v-model="operateType" style="width: 180px"  @on-change="operateTypeChange">
              <Option value="01">入金</Option>
              <Option value="02">冻结</Option>
              <Option value="03">解冻</Option>
              <Option value="04">出金</Option>
              <Option value="05">冻结金额入金</Option>
            </Select>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="accountDetail" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" highlight-row stripe></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
    </Row>
  </card>
</template>

<script>
export default {
  name: 'accountDetail',
  data () {
    return {
      countNew: 0,
      account: this.$route.params.id,
      beginDatetime: '',
      endDatetime: '',
      beginTradeDate: '',
      beginTransTime: '',
      endTradeDate: '',
      endTransTime: '',
      operateType: '',
      beginNew: '',
      endNew: '',
      formData: {},
      query: {
        parameters: {
        }
      },
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}],
      mySelectedData: this.selectedItem,
      selectedMerchant: [],
      selectedMerchId: [],
      beginDateOption: {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      },
      endDateOption: {
        disabledDate (date) {
          // return date && date.valueOf() < Date.now() - 86400000
        }
      }
    }
  },
  methods: {
    init () {
      // 设置
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 70
        },
        // {
        //   title: '商户号',
        //   key: 'objNo',
        //   width: 142 * avg,
        //   ellipsis: true
        // },
        // {
        //   title: '商户名称',
        //   width: 150 * avg,
        //   key: 'objName'
        // },
        {
          title: '账户类型',
          width: 120 * avg,
          key: 'accountType',
          render (h, a, b) {
            return h('span', self.$contants.dictionary.accountTypeMap[a.row.accountType])
          }
        },
        {
          title: '账号',
          width: 150 * avg,
          key: 'account'
        },
        {
          title: '对方账户',
          width: 150 * avg,
          key: 'peerAccNo'
          // render (h, params) {
          //   let reslut = ''
          //   if (params.row.userType === '0') {
          //     reslut = params.row.realName
          //   }
          //   if (params.row.userType === '1') {
          //     reslut = params.row.entName
          //   }
          //   return h('span', reslut)
          // }
        },
        {
          title: '对方账户名称',
          width: 150 * avg,
          key: 'peerAccName'
        },
        {
          title: '子操作类型',
          width: 120 * avg,
          key: 'operateSubType',
          render (h, a, b) {
            let relut = ''
            if (a.row.operateSubType === '1') {
              relut = '打款'
            }
            if (a.row.operateSubType === '2') {
              relut = '代付'
            }
            if (a.row.operateSubType === '3') {
              relut = '转账'
            }
            if (a.row.operateSubType === '4') {
              relut = '手续费'
            }
            if (a.row.operateSubType === '5') {
              relut = '退款'
            }
            if (a.row.operateSubType === '6') {
              relut = '退汇'
            }
            if (a.row.operateSubType === '7') {
              relut = '订单通知入金'
            }
            if (a.row.operateSubType === '8') {
              relut = '手工入账'
            }
            if (a.row.operateSubType === '9') {
              relut = '其他操作'
            }
            if (a.row.operateSubType === '10') {
              relut = '归集划转'
            }
            return h('span', relut)
          }
        },
        {
          title: '资金操作',
          width: 120 * avg,
          key: 'operateType',
          render (h, a, b) {
            let relut = ''
            if (a.row.operateType === '01') {
              relut = '入金'
            }
            if (a.row.operateType === '02') {
              relut = '冻结'
            }
            if (a.row.operateType === '03') {
              relut = '解冻'
            }
            if (a.row.operateType === '04') {
              relut = '出金'
            }
            if (a.row.operateType === '05') {
              relut = '冻结金额入金'
            }
            return h('span', relut)
          }
        },
        {
          title: '金额',
          width: 120 * avg,
          key: 'amount',
          render (h, a, b) {
            return h('span', a.row.amount / 100 + '元')
          }
        },
        {
          title: '变动前账户余额',
          width: 120 * avg,
          key: 'beforeBalance',
          render (h, a, b) {
            return h('span', a.row.beforeBalance / 100 + '元')
          }
        },
        {
          title: '变动后账户余额',
          width: 120 * avg,
          key: 'afterBalance',
          render (h, a, b) {
            return h('span', a.row.afterBalance / 100 + '元')
          }
        },
        {
          title: '账户明细序号',
          width: 150 * avg,
          key: 'seqNo'
        },
        {
          title: '记录时间',
          width: 150 * avg,
          key: 'recordTime',
          render (h, a, b) {
            return h('div', self.$moment(this.row.recordTime).format('YYYY-MM-DD HH:mm:ss'))
          }
        }
      ]
      // 查询信息
      if (this.account) {
        this.searchList()
      }

    },
    goBack () {
      this.$util.goBack(this)
    },
    searchList (param) {
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/accountDetail/pageList')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.account) {
        this.query.parameters.account = this.account
      } else {
        delete this.query.parameters.account
      }
      if (this.beginNew) {
        if (this.beginTransTime) {
          this.beginDatetime = this.beginNew + ' ' + this.beginTransTime
        } else {
          this.beginDatetime = this.beginNew + ' ' + '00:00:00'
        }
      }
      if (this.endNew) {
        if (this.endTransTime) {
          this.endDatetime = this.endNew + ' ' + this.endTransTime
        } else {
          this.endDatetime = this.endNew + ' ' + '23:59:59'
        }
      }
      if (this.beginDatetime) {
        this.query.parameters.beginDatetime = this.beginDatetime
      } else {
        delete this.query.parameters.beginDatetime
      }
      if (this.endDatetime) {
        this.query.parameters.endDatetime = this.endDatetime
      } else {
        delete this.query.parameters.endDatetime
      }
      if (this.operateType) {
        this.query.parameters.operateType = this.operateType
      } else {
        delete this.query.parameters.operateType
      }
      // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          this.tableData = response.data.list
          this.total = response.data.total
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    operateTypeChange (val) {
      this.operateType = val
    },
    beginTradeDateChange (value) {
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return date && date.valueOf() < dateGet.valueOf() - 86400000
        }
      }
      this.beginNew = value
    },
    beginTimeFun (val) {
      if (this.beginNew === this.endNew) {
        if (this.endTransTime) {
          if (val > this.endTransTime) {
            this.$Message.error('开始时间不能大于结束时间！')
            this.beginTransTime = ''
          }
        }
      }
    },
    endTradeDateChange (value) {
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
        }
      }
      this.endNew = value
    },
    endTimeFun (val) {
    },
    objTypeChange (val) {
      this.objType = val
    },
    cancel () {
      this.modalAccount = false
    },
    changePage (index) {
      // 分页点击事件
      this.currentPage = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      if (this.beginNew === this.endNew && this.beginNew !== '' && this.endNew !== '') {
        if (this.beginTransTime) {
          if (this.endTransTime) {
            if (this.endTransTime < this.beginTransTime) {
              this.endTransTime = ''
              this.$Message.error('结束时间不能小于开始时间！')
              return false
            }
          }
        }
      }
      this.countNew = 0
      if (this.beginTradeDate) {
        this.countNew += 1
      }
      if (this.beginTransTime) {
        this.countNew += 1
      }
      if (this.endTradeDate) {
        this.countNew += 1
      }
      if (this.endTransTime) {
        this.countNew += 1
      }
      if (this.countNew === 0 || this.countNew === 4) {
        this.currentPage = 1
        this.searchList()
      } else {
        this.$Message.error('请正确填写时间和日期！')
      }
    },
    clearBtn () {
      this.beginTradeDate = ''
      this.beginTransTime = ''
      this.beginDateOption = {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      }
      this.endDateOption = {
        disabledDate (date) {
          // return date && date.valueOf() > Date.now()
        }
      }
      this.endTradeDate = ''
      this.endTransTime = ''
      this.endDatetime = ''
      this.beginDatetime = ''
      this.endTradeDate = ''
      this.beginNew = ''
      this.endNew = ''
      this.operateType = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addIndustry'
      })
    },
    doDelete (row) {
      this.$axios.delete('/industry' + '/' + row.id)
        .then((res) => {
          if (res.status === 200) {
            this.$Message.success('删除成功！')
            this.searchList()
          } else {
            this.$Message.success('删除失败！')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    update (row) {
      this.$router.push({
        name: 'editIndustry',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'industryDetail',
        params: {
          id: row.id
        }
      })
    },
    changePassword (row) {
      this.$router.push({
        name: 'changeUserPassword',
        params: {
          username: row.username
        }
      })
    }
  },
  created () {
    this.init()
  },
  computed: {},
  // activated () {
  //   if (this.account !== this.$route.params.id) {
  //     this.account = this.$route.params.id
  //     this.init()
  //     this.clearBtn()
  //   }
  // }
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'accountDetail', this.$route.params.id)
    if (this.account !== initParamVal) {
      this.account = initParamVal
      this.init()
    }
  }
}
</script>
