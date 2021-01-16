<style lang="less">
  @import '../../styles/common.less';
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="起始月份：" prop="gmtCreate">
            <Date-picker type="month" placeholder="选择年月" format="yyyyMM" v-model="begStatMonth" :editable="false" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem label="结束月份：" prop="endStatMonth">
            <Date-picker type="month" placeholder="选择年月" format="yyyyMM" v-model="endStatMonth" :editable="false" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem label="手续费收益账号：" prop="account">
            <Input v-model="account" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="手续费收益账户名称：" prop="name">
            <Input v-model="name" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="归集划款状态：" prop="collectionStatus">
            <Select v-model="collectionStatus" style="width: 180px" @on-change="objTypeChange">
              <Option value="0">未划转</Option>
              <Option value="1">已划转</Option>
              <Option value="9">人工核查</Option>
            </Select>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="getCashList" @click="searchBtn()" style="margin-right: 10px;">查询
            </Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" class="margin-left-10" v-access id="feeIncomeAccountMonthStatGuiJiBtn" :disabled = "disActionGuiJi" @click="feeIncomeAccountAg()">重新归集</Button>
            <Button type="success" style="margin-left: 10px" v-access id="feeIncomeAccountMonthStatHuaZhangBtn" :disabled = "disActionHuaZhang" @click="feeIncomeAccountHz()">重新划账</Button>
          </FormItem>
        </Form>
        <Row style=" height: 40px; background: #9ea7b4; color: #fff; line-height: 40px; text-indent: 1.2em; width: 100%">
          <Col :span="6">
            <span>归集总笔数：{{totalCount}}</span>
          </Col>
          <Col :span="6">
            <span>归集总金额：{{totalMoney}}</span>
          </Col>
        </Row>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" @on-select="selectDataGo" @on-select-cancel="selectCancel" @on-selection-change="handleSelectRow"  highlight-row stripe></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
    </Row>
    <Modal
      title="归集查询"
      v-model="feeManualVerificationMsk"
      @on-ok="frozenOk"
      :mask-closable="false">
      <p> 查询结果：{{displayData.message}}</p>
      <p>账户：{{displayData.account}}</p>
      <p>交易结果：{{displayData.transDesc}}</p>
    </Modal>
    <Modal
      v-model="feeManualVerificationBtnMask"
      title="人工核查"
      width="350"
      :mask-closable="false"
    >
      <i-input type="textarea"  v-model="remark" placeholder="请输入备注"></i-input>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelAuditStatus">取消</Button>
        <Button type="primary" size="large" @click="sumbitAuditStatus">确定</Button>
      </div>
    </Modal>
  </card>
</template>

<script>
export default {
  name: "feeIncomeAccountMonthStat",
  data() {
    return {
      remark: '',
      feeManualVerificationId: '',
      feeManualVerificationMsk: false,
      feeManualVerificationBtnMask: false,
      displayData: {},
      list: [],
      frozenMask: false,
      disActionGuiJi: true,
      disActionHuaZhang: true,
      name: '',
      collectionStatus: '',
      totalCount: 0 + '笔',
      totalMoney: 0 + '元',
      examineStatu: false,
      clientTransId: '',
      industryCode: '',
      industryName: '',
      account: '',
      auditStatus: '',
      begStatMonth: '',
      endStatMonth: '',
      formData: {
        auditStatus: '',
        id: ''
      },
      query: {
        parameters: {}
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
          return date && date.valueOf() < Date.now() - 86400000
        }
      }
    }
  },
  methods: {
    init() {
      // 设置

      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          type: 'selection',
          width: 60,
          align: 'center'
        },
        {
          title: '统计月份',
          key: 'statMonth',
          width: 180 * avg
        },
        {
          title: '手续费收益账户号',
          key: 'account',
          width: 180 * avg
        },
        {
          title: '手续费收益账户名称',
          key: 'name',
          width: 150 * avg
        },
        {
          title: '归集账号',
          key: 'collAccount',
          width: 150 * avg
        },
        {
          title: '归集账户名称',
          key: 'collName',
          width: 150 * avg
        },
        {
          title: '归集金额',
          key: 'totalAmount',
          width: 185 * avg,
          render(h, a, b) {
            return h('span', a.row.totalAmount / 100 + '元')
          }
        },
        {
          title: '归集划款状态',
          key: 'collectionStatus',
          width: 200 * avg,
          render(h, a, b) {
            let getReslt = ''
            if (a.row.collectionStatus === '0') {
              getReslt = '未划转'
            }
            if (a.row.collectionStatus === '1') {
              getReslt = '已划转'
            }
            if (a.row.collectionStatus === '9') {
              getReslt = '人工核查'
            }
            return h('span', getReslt)
          }
        },
        {
          title: '处理状态',
          key: 'transStatus',
          width: 200 * avg,
          render(h, a, b) {
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
          title: '交易状态描述',
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
          title: '备注',
          key: 'remark',
          width: 150 * avg
        },
        {
          title: '创建时间',
          key: 'gmtCreate',
          width: 200 * avg,
          ellipsis: true,
          render(h, a, b) {
            return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '更新时间',
          key: 'gmtModified',
          width: 200 * avg,
          ellipsis: true,
          render(h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '操作用户',
          key: 'userModified',
          width: 200 * avg,
          align: 'left'
        },
        {
          title: '操作',
          key: 'action',
          width: 120 * avg,
          align: 'center',
          render: (h, params) => {
            if (params.row.totalAmount <= '0') {
              if (params.row.transStatus !== null && params.row.transStatus !== 'TRADE_SUCCESS') {
                return h('div', [
                  h('svg-icon', {
                    attrs: {
                      id: 'feeManualVerificationBtn',
                      title: '人工核查'
                    },
                    props: {
                      type: 'data',
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
                        this.feeManualVerification(params.row)
                      }
                    }
                  }, '人工核查'),
                  h('svg-icon', {
                    attrs: {
                      id: 'getTranZhuang',
                      title: '获取交易状态'
                    },
                    props: {
                      type: 'reset-pwd',
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
                        this.getTranZhuang(params.row)
                      }
                    }
                  }, '获取交易状态')
                ])
              }
            }else{
              if (params.row.transStatus !== null && params.row.transStatus !== 'TRADE_SUCCESS') {
                return h('div', [
                  h('svg-icon', {
                    attrs: {
                      id: 'getTranZhuang',
                      title: '获取交易状态'
                    },
                    props: {
                      type: 'reset-pwd',
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
                        this.getTranZhuang(params.row)
                      }
                    }
                  }, '获取交易状态')
                ])
              }
            }

            // if (params.row.transStatus !== null && params.row.transStatus !== 'TRADE_SUCCESS' && params.row.totalAmount === 0) {
            //
            // }
            // if (params.row.collectionStatus === '9') {
            //   return h('div', [
            //     h('svg-icon', {
            //       attrs: {
            //         id: 'feeManualVerificationBtn',
            //         title: '人工核查'
            //       },
            //       props: {
            //         type: 'data',
            //         size: '16'
            //       },
            //       style: {
            //         marginRight: '20px',
            //         cursor: 'pointer'
            //       },
            //       directives: [{
            //         name: 'access'
            //       }],
            //       on: {
            //         click: () => {
            //           this.feeManualVerification(params.row)
            //         }
            //       }
            //     }, '人工核查')
            //   ])
            // }
            // if (params.row.auditStatus === '1') {
            //   if (params.row.transStatus !== 'TRADE_SUCCESS') {
            //     return h('div', [
            //       h('svg-icon', {
            //         attrs: {
            //           id: 'getTranZhuang',
            //           title: '获取交易状态'
            //         },
            //         props: {
            //           type: 'reset-pwd',
            //           size: '16'
            //         },
            //         style: {
            //           marginRight: '20px',
            //           cursor: 'pointer'
            //         },
            //         directives: [{
            //           name: 'access'
            //         }],
            //         on: {
            //           click: () => {
            //             this.getTranZhuang(params.row)
            //           }
            //         }
            //       }, '获取交易状态')
            //     ])
            //   }
            // }
            }
          }
      ]
      // 查询信息
      let self = this
      // this.$axios.get('/dictionaries').then(function (res) {
      //   self.bankNameAry = res.data.bank
      // })
      this.searchList()
    },
    searchList(param) {
      let that = this
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/feeIncomeAccountMonthStat/list')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.account) {
        this.query.parameters.account = this.account
      } else {
        delete this.query.parameters.account
      }
      if (this.name) {
        this.query.parameters.name = this.name
      } else {
        delete this.query.parameters.name
      }
      if (this.collectionStatus) {
        this.query.parameters.collectionStatus = this.collectionStatus
      } else {
        delete this.query.parameters.collectionStatus
      }
      if (this.begStatMonth) {
        this.query.parameters.begStatMonth = this.begStatMonth
      } else {
        delete this.query.parameters.begStatMonth
      }
      if (this.endStatMonth) {
        this.query.parameters.endStatMonth = this.endStatMonth
      } else {
        delete this.query.parameters.endStatMonth
      }
      // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          that.list = []
          that.disActionGuiJi = true
          that.disActionHuaZhang = true
          response.data.page.list.forEach(function (e, i) {
            if (e.collectionStatus === '1') {
              e._disabled = true
            }
          })
          that.tableData = response.data.page.list
          that.total = response.data.page.total
          if (response.data.total.totalCount) {
            that.totalCount = response.data.total.totalCount
          }
          if (response.data.total.totalAmount) {
            that.totalMoney = response.data.total.totalAmount / 100 + '元'
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },

    objTypeChange(val) {
      this.formData.collectionStatus = val
    },
    selectDataGo (currentRow, row) {
      this.list.push(row.id)
      this.disActionGuiJi = false
      this.disActionHuaZhang = false
    },
    handleSelectRow (selection, index) {
      let self = this
      if (selection.length > 0) {
        self.disActionGuiJi = false
        self.disActionHuaZhang = false
        selection.forEach(function (e, i) {
          self.list.push(e.id)
        })
      } else {
        self.list = []
        self.disActionGuiJi = true
        self.disActionHuaZhang = true
      }
    },
    quChong () {  // 去重
      let listGo = []
      for (let i = 0; i < this.list.length; i++) {
        if (listGo.indexOf(this.list[i]) === -1) {
          listGo.push(this.list[i])
        }
      }
      this.list = listGo
    },
    selectCancel (selection, row) {
      if (this.list.length > 0) {
        for (let i = 0; i < this.list.length; i++) {
          if (this.list[i] === row.id) {
            this.list.splice(i, 1)
          }
        }
      }
      if (this.list.length === 0) {
        this.disActionGuiJi = true
        this.disActionHuaZhang = true
      }
    },
    beginTradeDateChange(value) {
      this.begStatMonth = value
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate(date) {
          return date && date.valueOf() < dateGet.valueOf() - 86400000
        }
      }
    },
    endTradeDateChange(value) {
      this.endStatMonth = value
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate(date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
        }
      }
    },
    sumbitAccount () {
      let that = this
      this.$axios.put('/withdrawalsRecord', this.formData).then(function (res) {
        that.searchList()
        that.$Message.success('提款审核成功')
      }).catch(function () {
      })
      this.examineStatu = false
    },
    feeIncomeAccountAg () {
      this.quChong()
      let self = this
      this.$axios.put('/feeIncomeAccountMonthStat', this.list).then(function (res) {
        self.$Message.success('重新归集成功')
        self.searchList()
      })
    },
    feeIncomeAccountHz () {
      let self = this
      this.quChong()
      this.$axios.put('/feeIncomeAccountMonthStatReturn', this.list).then(function (res) {
        self.$Message.success('处理中')
        self.disActionHuaZhang = true
        self.disActionGuiJi = true
        self.searchList()
      }).catch(function (err) {
      })
    },
    cancelAuditStatus () {
      this.feeManualVerificationBtnMask = false
    },
    sumbitAuditStatus () {
      let self = this
      if (this.remark === '') {
        self.$Message.error('请填写备注信息')
      } else {
        let query = {
          id: this.feeManualVerificationId,
          remark: this.remark
        }
        this.$axios.put('/feeManualVerification', query).then(function (res) {
          self.$Message.success('人工核查成功')
          self.feeManualVerificationBtnMask = false
          self.id = ''
          self.remark = ''
          self.searchList()
        }).catch(function (err) {
          self.feeManualVerificationBtnMask = false
          self.id = ''
          self.remark = ''
        })
      }
    },
    cancel () {
      this.examineStatu = false
    },
    changePage (index) {
      // 分页点击事件
      this.currentPage = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.currentPage = 1
      this.searchList()
    },
    clearBtn () {
      this.collectionStatus = ''
      this.account = ''
      this.name = ''
      this.begStatMonth = ''
      this.endStatMonth = ''
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
    },
    createBtn() {
      this.$router.push({
        name: 'addIndustry'
      })
    },
    doDelete(row) {
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
    feeManualVerification (row) {
      this.feeManualVerificationBtnMask = true
      this.feeManualVerificationId = row.id
    },
    getTranZhuang(row) {
      let that = this
      this.$axios.post('/queryFeeIncomeAccountMonthCollection', row).then(function (res) {
        that.$Message.success('获取交易状态成功')
        // <i-option value="PRE_CREATE">创建订单</i-option>
        //   <i-option value="PROCESSING">处理中</i-option>
        //   <i-option value="TRADE_SUCCESS">交易成功</i-option>
        //   <i-option value="TRADE_FAILURE">交易失败</i-option>
        //   <i-option value="TRADE_ERROR">处理异常</i-option>
        let reslut = ''
        if (res.data.transStatus === 'PRE_CREATE') {
          reslut = '创建订单'
        }
        if (res.data.transStatus === 'PROCESSING') {
          reslut = '处理中'
        }
        if (res.data.transStatus === 'TRADE_SUCCESS') {
          reslut = '交易成功'
        }
        if (res.data.transStatus === 'TRADE_FAILURE') {
          reslut = '交易失败'
        }
        if (res.data.transStatus === 'TRADE_ERROR') {
          reslut = '处理异常'
        }
        that.$Modal.info({
          title: '获取交易状态',
          content: '<p>提现客户端流水号:' + res.data.origClientTradeId + '</p><p>交易状态：' + reslut + '</p><p>交易描述：' + res.data.transDesc + '</p>'
        })
      })
    },
    getCashApply (row) {
      let self = this
      let query = {
        id: row.id
      }
      this.$axios.post('/queryFeeIncomeAccountMonthCollection', query)
        .then((response) => {
          self.displayData = response.data
          self.frozenMask = true
        })
    }
  },
  created () {
    this.init()
  },
  computed: {
    nameSize() {
      return this.$contants.pageSet.nameSize
    },
    accountSize() {
      return this.$contants.pageSet.accountSize
    }
  },
  activated() {
      this.searchList()
  }
}
</script>
