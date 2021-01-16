<style lang="less">
  @import '../../../styles/common.less';
</style>
<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="客户号：" prop="industryCode">
            <Input v-model="industryCode" :maxlength="12"/>
          </FormItem>
          <FormItem label="收款方户名：" prop="receiverName">
            <Input v-model="receiverName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="收款方账号：" prop="receiverNo">
            <Input v-model="receiverNo" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="操作类型：" prop="operationType">
            <Select v-model="operationType" style="width: 180px"  @on-change="operationTypeChange">
              <i-option value="0">新增</i-option>
              <i-option value="1">修改</i-option>
              <i-option value="2">删除</i-option>
            </Select>
          </FormItem>
          <FormItem label="审核状态：" prop="auditStatus">
            <Select v-model="auditStatus" style="width: 180px"  @on-change="auditStatusChange">
              <i-option value="0">待审核</i-option>
              <i-option value="1">审核通过</i-option>
              <i-option value="2">审核驳回</i-option>
            </Select>
          </FormItem>
          <FormItem  label="申请开始时间：" prop="transBeginDate" >
            <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
            <Time-picker confirm placeholder="选择时间" :editable="false" v-model="beginTransTime"  style="width: 168px"></Time-picker>
          </FormItem>
          <FormItem  label="申请结束时间：" prop="transEndDate" >
            <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
            <Time-picker confirm placeholder="选择时间" :editable="false" v-model="endTransTime" style="width: 168px"></Time-picker>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="whiteListPaymentsAuditList" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <!--<Button type="success" v-access id="addWhiteListPayments" @click="createBtn()" style="margin-right: 10px;">新增</Button>-->
            <Button type="warning" v-access id="whiteListPaymentsExamine" @click="industryApply()" style="margin-right: 10px;" :disabled="applyBtn">审核</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData"  @on-current-change="selectDataNew" highlight-row stripe></Table>
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
      title="出款账户白名单审核"
      width="350"
    >
      <Select v-model="auditStatus" style="width: 180px"  @on-change="auditStatusChange">
        <i-option value="1">审核通过</i-option>
        <i-option value="2">审核驳回</i-option>
      </Select>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelAuditStatus">取消</Button>
        <Button type="primary" size="large" @click="sumbitAuditStatus">确定</Button>
      </div>
    </Modal>
  </card>
</template>

<script>
export default {
  name: "whiteListPaymentsShenhe",
  data () {
    return {
      examineStatu: false,
      applyBtn: true,
      name: '',
      industryCode: '',
      receiverName: '',
      receiverNo: '',
      operationType: '',
      auditStatus: '',
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}],
      transBeginDate: '',
      beginTransTime: '',
      transEndDate: '',
      endTransTime: '',
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
    init () {
      let self = this
      // 设置
      // this.provinceAry = this.cityList.China.province
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 70
        },
        // {
        //   title: '客户号',
        //   key: 'industryCode',
        //   width: 150 * avg
        // },
        {
          title: '客户名称',
          key: 'name',
          width: 150 * avg
        },
        {
          title: '收款方户名',
          key: 'receiverName',
          width: 150 * avg
        },
        {
          title: '收款方账号',
          key: 'receiverAccount',
          width: 150 * avg
        },
        {
          title: '生效日期',
          key: 'beginDate',
          width: 150 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.beginDate).format('YYYY-MM-DD'))
          }
        },
        {
          title: '失效日期',
          key: 'endDate',
          width: 150 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.endDate).format('YYYY-MM-DD'))
          }
        },
        {
          title: '单日交易限额',
          key: 'oneDayTradingQuota',
          width: 200 * avg,
          render (h, a, b) {
            return h('span', a.row.oneDayTradingQuota / 100 + '元')
          }
        },
        {
          title: '备注信息',
          key: 'remark',
          width: 150 * avg
        },
        {
          title: '操作类型',
          key: 'operationType',
          width: 200 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.auditStatus === '0') {
              res = '新增'
            }
            if (a.row.auditStatus === '1') {
              res = '修改'
            }
            if (a.row.auditStatus === '2') {
              res = '删除'
            }
            return h('span', res)
          }
        },
        {
          title: '申请人',
          key: 'userCreate',
          width: 200 * avg
        },
        {
          title: '申请时间',
          key: 'gmtCreate',
          width: 150 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '审核状态',
          key: 'auditStatus',
          width: 200 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.auditStatus === '0') {
              res = '待审核'
            }
            if (a.row.auditStatus === '1') {
              res = '审核通过'
            }
            if (a.row.auditStatus === '2') {
              res = '审核驳回'
            }
            return h('span', res)
          }
        },
        {
          title: '审核人员',
          key: 'userModified',
          width: 200 * avg
        },
        {
          title: '审核人员',
          key: 'gmtModified',
          width: 150 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        // {
        //   title: '操作',
        //   key: 'action',
        //   align: 'center',
        //   width: 150 * avg,
        //   render: (h, params) => {
        //     return h('div', [
        //       h('svg-icon', {
        //         attrs: {
        //           id: 'addWhiteListPayments',
        //           title: '编辑'
        //         },
        //         props: {
        //           type: 'edit',
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
        //             this.update(params.row)
        //           }
        //         }
        //       }, '编辑'),
        //       h('Poptip', {
        //         props: {
        //           confirm: true,
        //           title: '您确定要删除这条数据吗?',
        //           transfer: true
        //         },
        //         on: {
        //           'on-ok': () => {
        //             this.doDelete(params.row)
        //           }
        //         }
        //       }, [
        //         h('svg-icon', {
        //           attrs: {
        //             id: 'delWhiteListPayments',
        //             title: '删除'
        //           },
        //           directives: [{
        //             name: 'access'
        //           }],
        //           style: {
        //             cursor: 'pointer'
        //           },
        //           props: {
        //             type: 'delete',
        //             size: '16'
        //           }
        //         }, '删除')
        //       ])
        //     ])
        //   }
        // }
      ]
      // 查询信息
      this.searchList()
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
      let uri = encodeURI('/whiteListPaymentsAudit/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.industryCode) {
        query.parameters.industryCode = this.industryCode
      } else {
        delete query.parameters.industryCode
      }
      if (this.receiverName) {
        query.parameters.receiverName = this.receiverName
      } else {
        delete query.parameters.receiverName
      }
      if (this.receiverNo) {
        query.parameters.receiverNo = this.receiverNo
      } else {
        delete query.parameters.receiverNo
      }
      if (this.operationType) {
        query.parameters.operationType = this.operationType
      } else {
        delete query.parameters.operationType
      }
      if (this.auditStatus) {
        query.parameters.auditStatus = this.auditStatus
      } else {
        delete query.parameters.auditStatus
      }
      if (this.transBeginDate) {
        if (this.beginTransTime) {
          this.beginTransTime = this.beginTransTime.split(':')
          let newTime = this.beginTransTime.join('')
          this.beginTransTime = newTime
        } else {
          this.beginTransTime = '000000'
        }
        query.parameters.transBeginDate = this.transBeginDate + this.beginTransTime
      } else {
        delete query.parameters.transBeginDate
      }
      if (this.transEndDate) {
        if (this.endTransTime) {
          this.endTransTime = this.endTransTime.split(':')
          let newTime = this.endTransTime.join('')
          this.endTransTime = newTime
        } else {
          this.endTransTime = '235959'
        }
        query.parameters.transEndDate = this.transEndDate + this.endTransTime
      } else {
        delete query.parameters.transEndDate
      }

      // 查询机构列表
      // let that = this
      this.$axios.post(uri, query)
        .then((response) => {
          this.tableData = response.data.list
          this.total = parseInt(response.data.total)
        })
        .catch(function (error) {
          console.log(error)
        })
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
      this.operationType = ''
      this.auditStatus = ''
      this.industryCode = ''
      this.receiverName = ''
      this.receiverNo = ''
      this.transBeginDate = ''
      this.transEndDate = ''
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
    },
    industryApply () {
      this.examineStatu = true
    },
    sumbitAuditStatus () {
      let that = this

      if (this.examineStatu && this.id) {
        let formData = {
          auditStatus: this.auditStatus,
          id: this.id
        }
        this.$axios.put('/whiteListPaymentsExamine', formData).then(function (res) {
          that.auditStatus = ''
          that.id = ''
          that.searchList()
          that.$Message.success('出款白名单审核成功')
          that.examineStatu = false
          that.applyBtn = true
        }).catch(function (err) {
          that.examineStatu = false
          that.applyBtn = true
        })
      } else {
        that.$Message.error('请选择审核状态')
        that.applyBtn = true
      }
    },
    cancelAuditStatus () {
      this.examineStatu = false
    },
    auditStatusChange (val) {
      this.auditStatus = val
    },
    beginTradeDateChange (value) {
      this.transBeginDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return date && date.valueOf() < dateGet.valueOf() - 86400000
        }
      }
    },
    endTradeDateChange (value) {
      this.transEndDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
        }
      }
    },
    operationTypeChange (val) {
      this.operationType = val
    },
    selectDataNew (currentRow) {
      if (currentRow.auditStatus === '0') {
        this.id = currentRow.id
        this.applyBtn = false
      } else {
        this.applyBtn = true
      }
    },
    createBtn () {
      this.$router.push({
        name: 'addWhiteListPayments'
      })
    },
    doDelete (row) {
      this.$axios.delete('/whiteListPayments' + '/' + row.id)
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
        name: 'editWhiteListPayments',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'productDetail',
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
