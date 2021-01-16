<style lang="less">
  @import '../../styles/common.less';
  .hidden {
    display: none;
  }
</style>
<template>
  <card>
    <Form :label-width="120" ref="form" :model="formData.parameters" label-position="right" :inline="true">
      <Row>
        <FormItem label="资金账号：" prop="bankAccountNo" >
          <Input v-model="bankAccountNo" style="width: 300px" placeholder="请输入资金账号" :maxlength="accountSize" />
        </FormItem>
        <FormItem label="户名：" prop="bankAccountName" >
          <Input v-model="bankAccountName" style="width: 300px" placeholder="请输入户名" :maxlength="nameSize" />
        </FormItem>
        <FormItem label="是否共享资金账户：" prop="shareFlag">
          <Select v-model="shareFlag" style="width: 180px">
            <Option value="ALL">全部</Option>
            <Option value="0">否</Option>
            <Option value="1">是</Option>
          </Select>
        </FormItem>
        <FormItem label="是否报送反洗钱：" prop="reportAmlFlag">
          <Select v-model="reportAmlFlag" style="width: 180px">
            <Option value="ALL">全部</Option>
            <Option value="0">否</Option>
            <Option value="1">是</Option>
          </Select>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listCapitalAcount">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <Button type="success" v-access id="addFeeAcount" @click="createBtn()" style="margin-right: 10px;">新增</Button>
        </FormItem>
      </Row>
    </Form>
    <!--<Row style=" height: 40px; background: #9ea7b4; color: #fff; line-height: 40px; text-indent: 1.2em; width: 100%">-->
      <!--<Col :span="8">-->
        <!--<span>客户数量：{{userTotal}}</span>-->
      <!--</Col>-->
      <!--<Col :span="8">-->
        <!--<span>总余额：{{totalAmount}}</span>-->
      <!--</Col>-->
      <!--<Col :span="8">-->
        <!--<span>总冻结金额：{{totalBalance}}</span>-->
      <!--</Col>-->
    <!--</Row>-->
    <Row>
      <Table :columns="tableColumns" :data="tableData" highlight-row border stripe></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
    <Modal
      v-model="modalData"
      title="重置日期"
      @on-ok = "getSetData"
      width="300"
    >
      <Date-picker  @on-change="dataChange" v-model="lastDate" format="yyyyMMdd" type="date" placeholder="选择日期"></Date-picker>
    </Modal>
  </card>
</template>
<script>export default {
  name: "capitalAcountSearchList",
  data () {
    return {
      fundAccountNo: '',
      modalData: false,
      userTotal: '',
      totalAmount: '',
      accountNo: '',
      totalBalance: '',
      accountNum: '',
      bankAccountName: '',
      bankAccountNo: '',
      reportAmlFlag: '',
      shareFlag: '',
      total: '',
      formData: {},
      tableColumns: [],
      tableData: [],
      orgData: [],
      pageNo: 1,
      pageSize: 10
    }
  },
  methods: {
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
              width: 120 * avg,
              title: '资金账户类型',
              key: 'accountType',
              ellipsis: true,
              render: (h, params) => {
                  let res = ''
                  if (params.row.accountType === '1') {
                    res = '内部户'
                  } else {
                    res = '一般户'
                  }
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
                              title: params.row.accountType
                          }
                      }, res)
                  ])
              }
          },
          {
              width: 120 * avg,
              title: '账户用途',
              key: 'bankAccountNo',
              ellipsis: true,
              render: (h, params) => {
                  let res = ''
                  if (params.row.useType === '0') {
                      res = '代付分账'
                  } else {
                      res = '手续费归集'
                  }
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
                              title: params.row.useType
                          }
                      }, res)
                  ])
              }
          },
        {
          width: 120 * avg,
          title: '资金账号',
          key: 'bankAccountNo',
          ellipsis: true,
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
                  title: params.row.bankAccountNo
                }
              }, params.row.bankAccountNo)
            ])
          }
        },
        {
          width: 140 * avg,
          title: '户名',
          key: 'bankAccountName',
          ellipsis: true,
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
                  title: params.row.bankAccountName
                }
              }, params.row.bankAccountName)
            ])
          }
        },

        {
          width: 150 * avg,
          title: '清算行号',
          key: 'bankCode'
        },
          {
              width: 150 * avg,
              title: '是否共享',
              key: 'shareFlag',
              render (h, a, b) {
                  let res = ''
                  if (a.row.shareFlag === '0' || a.row.shareFlag === null) {
                      res = '否'
                  }
                  if (a.row.shareFlag === '1') {
                      res = '是'
                  }
                  return h('span', res)
              }
          },
        {
          width: 150 * avg,
          title: '是否报送反洗钱',
          key: 'reportAmlFlag',
          render (h, a, b) {
            let res = ''
            if (a.row.reportAmlFlag === '0' || a.row.reportAmlFlag === null) {
              res = '否'
            } else if (a.row.reportAmlFlag === '1') {
              res = '是'
            }
             return h('span', res)
          }
        },
        {
          width: 180 * avg,
          title: '创建时间',
          key: 'gmtCreate',
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          width: 180 * avg,
          title: '当前余额',
          key: 'currentBalance',
          render (h, a, b) {
            if (a.row.currentBalance === '0元' || a.row.currentBalance === null) {
              return h('span', '')
            } else {
              return h('span', a.row.currentBalance / 100 + '元')
            }
          }
        },
        {
          width: 180 * avg,
          title: '最新同步时间',
          key: 'synchronizationTime',
          render (h, a, b) {
            if (this.row.synchronizationTime) {
              return h('div', self.$moment(this.row.synchronizationTime).format('YYYY-MM-DD HH:mm:ss'))
            }
          }
        },
        // {
        //   width: 150 * avg,
        //   title: '最新修改人',
        //   key: 'userModified'
        // },
        {
          title: '操作',
          key: 'action',
          width: 178 * avg,
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'editFeeAcount',
                  title: '编辑'
                },
                props: {
                  type: 'edit',
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
                    this.update(params.row)
                  }
                }
              }, '编辑'),
              h('svg-icon', {
                attrs: {
                  id: 'resetDate',
                  title: '日期重置'
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
                    this.resetData(params.row)
                  }
                }
              }, '日期重置'),
              h('svg-icon', {
                attrs: {
                  id: 'detailFeeAcount',
                  title: '详情'
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
              }, '详情'),
              h('Poptip', {
                props: {
                  confirm: true,
                  title: '您确定要删除这条数据吗?',
                  transfer: true
                },
                on: {
                  'on-ok': () => {
                    this.doDelete(params.row)
                  }
                }
              }, [
                h('svg-icon', {
                  attrs: {
                    id: 'deleteFeeAcount',
                    title: '删除'
                  },
                  directives: [{
                    name: 'access'
                  }],
                  style: {
                    cursor: 'pointer'
                  },
                  props: {
                    type: 'delete',
                    size: '16'
                  }
                }, '删除')
              ])
            ])
          }
        }
      ]
     this.searchList()
    },
    searchList () {
      let self = this
      this.formData = {}
      if (this.bankAccountNo) {
        this.formData.bankAccountNo = this.bankAccountNo
      } else {
        delete this.formData.bankAccountNo
      }
      if (this.bankAccountName) {
        this.formData.bankAccountName = this.bankAccountName
      } else {
        delete this.formData.bankAccountName
      }
      if (this.reportAmlFlag && 'ALL' !== this.reportAmlFlag) {
        this.formData.reportAmlFlag = this.reportAmlFlag
      } else {
        delete this.formData.reportAmlFlag
      }
      if (this.shareFlag && 'ALL' !== this.shareFlag) {
        this.formData.shareFlag = this.shareFlag
      } else {
        delete this.formData.shareFlag
      }
      let query = {
        pageNo: self.pageNo,
        pageSize: self.pageSize,
        parameters: this.formData
      }
      this.$axios.post('/fundAccount/list', query)
        .then(function (response) {
          self.total = parseInt(response.data.total)
          self.tableData = ''
          self.tableData = response.data.list
        })
        .catch(function (error) {
          console.log(error)
        })
      // }
      //   })
    },
    resetData (row) {
      this.modalData = true
      this.lastDate = ''
      this.fundAccountNo = row.bankAccountNo
    },
    dataChange (val) {
      this.lastDate = val
    },
    getSetData: function () {
      let that = this
      let query = {
        fundAccountNo: this.fundAccountNo,
        lastDate: this.lastDate
      }
      this.$axios.post('industry/updateSyncLastDate', query).then(function (res) {
        that.$Message.success('重置时间成功')
        that.applyBtn = true
      }).catch(function (err) {
        that.applyBtn = true
      })
    },
    createBtn () {
      this.$router.push({
        name: 'addCapitalAcount'
      })
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
    showDetail (row) {
      // localStorage.removeItem('capitalAcountDetailID')
      // localStorage.setItem('capitalAcountDetailID', row.id)
      // localStorage.removeItem('bankAccountNo')
      // localStorage.setItem('bankAccountNo', row.bankAccountNo)
      this.$router.push({
        name: 'capitalAcountDetail',
        params: {
          id: row.id,
          bankAccountNo: row.bankAccountNo
        }
      })
    },
    update (row) {
      // localStorage.removeItem('capitalAcountId')
      // localStorage.setItem('capitalAcountId', row.id)
      this.$router.push({
        name: 'editCapitalAcount',
        params: {
          id: row.id
        }
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
    },
    resetBtn () {
      this.bankAccountName = '',
      this.bankAccountNo = ''
      this.reportAmlFlag = ''
      this.shareFlag = ''
      // this.industryCode = ''
      // this.channelCode = ''
      // this.productCode = ''
      // this.transBeginDate = this.$moment(new Date()).format('YYYYMMDD')
      // this.transEndDate = this.$moment(new Date()).format('YYYYMMDD')
      // this.beginDateOption = {
      //   disabledDate (date) {
      //     return date && date.valueOf() > Date.now()
      //   }
      // }
      // this.endDateOption = {
      //   disabledDate (date) {
      //     return date && date.valueOf() < Date.now() - 86400000
      //   }
      // }
      // this.pageNo = 1
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
