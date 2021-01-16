<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="客户端流水：" prop="clientTransId">
            <Input v-model="clientTransId" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="手续费客户号：" prop="industryCode">
            <Input v-model="industryCode" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="手续费客户名称：" prop="industryName">
            <Input v-model="industryName" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="手续费账户虚拟账号：" prop="account">
            <Input v-model="account" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="审核状态：" prop="auditStatus">
            <Select v-model="auditStatus" style="width: 180px" @on-change="objTypeChange">
              <Option value="0">待审核</Option>
              <Option value="1">审核通过</Option>
              <Option value="2">审核驳回</Option>
            </Select>
          </FormItem>
          <FormItem label="申请开始时间：" prop="gmtCreate">
            <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false"
                         placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange"
                         style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem label="申请结束时间：" prop="transEndDate">
            <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false"
                         placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="endTradeDateChange"
                         style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="getCashList" @click="searchBtn()" style="margin-right: 10px;">查询
            </Button>
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
    <Modal
      v-model="examineStatu"
      title="审核状态"
      width="350"
    >
      <Select v-model="formData.auditStatus" style="width: 180px" @on-change="objTypeChange">
        <Option value="1">审核通过</Option>
        <Option value="2">审核驳回</Option>
      </Select>

      <div slot="footer">
        <Button type="text" size="large" @click="cancel">取消</Button>
        <Button type="primary" size="large" @click="sumbitAccount">确定</Button>
      </div>
    </Modal>
  </card>
</template>

<script>
export default {
  name: "withdrawalsRecord",
  data() {
    return {
      examineStatu: false,
      clientTransId: '',
      industryCode: '',
      industryName: '',
      account: '',
      auditStatus: '',
      transBeginDate: '',
      transEndDate: '',
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
          title: '序号',
          type: 'index',
          width: 70
        },
        {
          title: '提现客户端流水号',
          key: 'clientTransId',
          width: 180 * avg
        },
        {
          title: '手续费客户号',
          key: 'industryCode',
          width: 180 * avg
        },
        {
          title: '手续费客户名称',
          key: 'industryName',
          width: 150 * avg
        },
        {
          title: '手续费账户虚拟账号',
          key: 'account',
          width: 150 * avg
        },
        {
          title: '资金账号',
          key: 'fundAccountNo',
          width: 150 * avg
        },
        {
          title: '资金账户户名',
          key: 'fundAccountName',
          width: 185 * avg
        },
        {
          title: '提现金额',
          key: 'amount',
          width: 200 * avg,
          render(h, a, b) {
            return h('span', a.row.amount / 100 + '元')
          }
        },
        {
          title: '收款方账号',
          key: 'reciveAccountNo',
          width: 200 * avg,
          ellipsis: true
        },
        {
          title: '收款方户名',
          key: 'reciveAccountName',
          width: 200 * avg,
          ellipsis: true,
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: '50%',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.reciveAccountName
                }
              }, params.row.reciveAccountName)
            ])
          }
        },
        {
          title: '申请时间',
          key: 'gmtCreate',
          width: 200 * avg,
          align: 'left',
          render(h, a, b) {
            return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '审核状态',
          key: 'auditStatus',
          width: 200 * avg,
          render(h, a, b) {
            let getReslt = ''
            if (a.row.auditStatus === '0') {
              getReslt = '待审核'
            }
            if (a.row.auditStatus === '1') {
              getReslt = '审核通过'
            }
            if (a.row.auditStatus === '2') {
              getReslt = '审核驳回'
            }
            return h('span', getReslt)
          }
        },
        {
          title: '交易状态',
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
          title: '审核时间',
          key: 'gmtModified',
          width: 200 * avg,
          render(h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '审核人员',
          key: 'userModified',
          width: 200 * avg
        },
        {
          title: '操作',
          key: 'action',
          width: 120 * avg,
          align: 'center',
          render: (h, params) => {
            if (params.row.auditStatus === '0') {
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'getCashExamine',
                    title: '审核'
                  },
                  props: {
                    type: 'modify-pwd',
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
                      this.getCashApply(params.row)
                    }
                  }
                }, '审核')
              ])
            }
            if (params.row.transStatus === 'PRE_CREATE' ||
                params.row.transStatus === 'TRADE_SUCCESS' ||
                params.row.transStatus === 'TRADE_FAILURE') {
              if (params.row.transStatus === 'PRE_CREATE') { // 创建订单
                return h('div', [])
              }
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'getDetail',
                    title: '查看详情'
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
                      this.getDetail(params.row)
                    }
                  }
                }, '查看详情')
              ])
            } else {
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
                }, '刷新额度')
              ])
          }
            // if (params.row.transStatus === 'PROCESSING' || params.row.transStatus === 'TRADE_ERROR') {
            //
            // } else {
            //
            // }
            if (params.row.auditStatus === '2') {
              return h('div', [])
            }
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
      let uri = encodeURI('/withdrawalsRecord/list')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.clientTransId) {
        this.query.parameters.clientTransId = this.clientTransId
      } else {
        delete this.query.parameters.clientTransId
      }
      if (this.industryCode) {
        this.query.parameters.industryCode = this.industryCode
      } else {
        delete this.query.parameters.industryCode
      }
      if (this.industryName) {
        this.query.parameters.industryName = this.industryName
      } else {
        delete this.query.parameters.industryName
      }
      if (this.account) {
        this.query.parameters.account = this.account
      } else {
        delete this.query.parameters.account
      }
      if (this.auditStatus) {
        this.query.parameters.auditStatus = this.auditStatus
      } else {
        delete this.query.parameters.auditStatus
      }
      if (this.transBeginDate) {
        this.query.parameters.transBeginDate = this.transBeginDate
      } else {
        delete this.query.parameters.transBeginDate
      }
      if (this.transEndDate) {
        this.query.parameters.transEndDate = this.transEndDate
      } else {
        delete this.query.parameters.transEndDate
      }
      // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          that.tableData = response.data.list
          that.total = response.data.total
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    setAccount(row) {
      let self = this
      this.modalAccount = true
      this.countData.account = row.account
      this.countData.accountName = row.accountName
      this.countData.bankName = row.bankName
      this.countData.bankCode = row.bankCode
      this.countData.code = row.code
      this.countData.id = row.id
      this.countData.name = row.name
      this.countData.simpleName = row.simpleName
      this.countData.status = row.status
      this.countData.countyCode = row.countyCode
      this.provinceAry.forEach(function (e, i) {
        if (e.name === row.provinceCode) {
          self.countData.provinceCode = e.id
          if (e.city.length > 0) {
            e.city.forEach(function (event, index) {
              if (event.name === row.cityCode) {
                self.countData.cityCode = event.id
              }
            })
          }
        }
      })
    },
    objTypeChange(val) {
      this.formData.auditStatus = val
    },
    beginTradeDateChange(value) {
      // thins.transBeginDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]

      this.transBeginDate = value + ' 00:00:00'
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate(date) {
          return date && date.valueOf() < dateGet.valueOf() - 86400000
        }
      }
    },
    endTradeDateChange(value) {
      // this.transEndDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
      this.transEndDate = value + ' 23:59:59'
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate(date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
        }
      }
    },
    sumbitAccount () {
      let that = this
      if (this.formData.auditStatus) {
        this.$axios.put('/withdrawalsRecord', this.formData).then(function (res) {
          that.searchList()
          that.$Message.success('提款审核成功')
          that.examineStatu = false
        }).catch(function () {
        })
      } else {
        that.$Message.error('请选择审核状态')
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
      this.clientTransId = ''
      this.industryCode = ''
      this.industryName = ''
      this.account = ''
      this.auditStatus = ''
      this.transBeginDate = ''
      this.transEndDate = ''
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
    getTranZhuang(row) {
      let that = this
      this.$axios.post('/withdrawalsRecordRefresh', row).then(function (res) {
        that.$Message.success('获取交易状态成功')
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
          content: '<p>提现客户端流水号:' + res.data.origClientTradeId + '</p><p>交易状态：' + reslut + '</p><p>交易描述：' + res.data.transDesc + '</p>',
          onOk: () => {
            that.searchList()
          }
        })


      })
    },
    getDetail (row) {
      let that = this
      this.$axios.get('/withdrawalsRecord' + '/' + row.id).then(function (res) {
            // that.$Message.success('获取交易状态成功')
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
            if (res.data.transDesc === null) {
                res.data.transDesc = ''
            }
            that.$Modal.info({
                title: '获取交易详情',
                content: '<p>提现客户端流水号:' + res.data.clientTransId + '</p><p>交易状态：' + reslut + '</p><p>交易描述：' + res.data.transDesc + '</p>',
                onOk: () => {
                    that.searchList()
                }
            })
          })
      },
    getCashApply(row) {
      this.formData = {}
      this.examineStatu = true
      this.formData.id = row.id
    },
    showDetail(row) {
      this.$router.push({
        name: 'cashExamineDetail',
        params: {
          id: row.clientTransId
        }
      })
    },
    changePassword(row) {
      this.$router.push({
        name: 'changeUserPassword',
        params: {
          username: row.username
        }
      })
    },
    resetPassword(row) {
      let self = this
      let param = {}
      param.id = row.id
      param.password = '123456'
      this.$axios.put(this.$contants.restful.userResetPwd, param)
        .then(function (response) {
          self.$Message.success('重置密码成功')
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },
  created() {
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
