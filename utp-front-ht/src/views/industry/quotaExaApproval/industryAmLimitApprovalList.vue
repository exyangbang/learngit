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
            <Input v-model="industryCode" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="客户名称：" prop="industryCode">
            <Input v-model="industryName" :maxlength="40"/>
          </FormItem>
          <FormItem label="操作类型：" prop="operationType">
            <Select v-model="operationType" style="width: 180px"  @on-change="operationTypeChange">
              <i-option value="2">新增</i-option>
              <i-option value="1">修改</i-option>
              <i-option value="0">删除</i-option>
            </Select>
          </FormItem>
          <FormItem label="审核状态：" prop="auditStatus">
            <Select v-model="auditStatus" style="width: 180px"  @on-change="auditStatusChangeTwo">
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
            <Button type="primary" v-access id="quotaExaApprovalList" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <!--<Button type="success" v-access id="quotaExaApprovalAdd" @click="createBtn()" style="margin-right: 10px;">新增</Button>-->
            <Button type="warning" v-access id="quotaExaApprovalApply" @click="quotaExaApprovalApplyBtn()" style="margin-right: 10px;" :disabled="applyBtn">审核</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" @on-current-change="selectDataNew" highlight-row stripe></Table>
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
      title="客户风控参数审核"
      width="350"
    >
      <Select v-model="auditStatus" style="width: 180px"  @on-change="auditStatusChange">
        <i-option value="1">审核通过</i-option>
        <i-option value="2">审核驳回</i-option>
      </Select>
      <i-input type="textarea" v-model="remark" placeholder="请输入备注" style="margin-top: 10px"></i-input>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelAuditStatus">取消</Button>
        <Button type="primary" size="large" @click="sumbitAuditStatus">确定</Button>
      </div>
    </Modal>
  </card>
</template>
<script>
export default {
  name: "industryAmLimitApprovalList",
  data () {
    return {
      operationType: '',
      transBeginDatePass: '',
      transBeginDate: '',
      beginTransTime: '',
      transEndDatePass: '',
      transEndDate: '',
      endTransTime: '',
      id: '',
      examineStatu: false,
      auditStatus: '',
      remark: '',
      merName: '',
      industryCode: '',
      industryName: '',
      applyBtn: true,
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}],
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
        {
          title: '客户号',
          key: 'industryCode',
          width: 150 * avg
        },
        {
          title: '客户名称',
          key: 'industryName',
          width: 150 * avg
        },
        {
          title: '对公单笔提现/代付限额',
          key: 'publicIndividualAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.publicIndividualAmt / 100 + '元')
          }
        },
        {
          title: '对私单笔提现/代付限额',
          key: 'privateIndividualAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.privateIndividualAmt / 100 + '元')
          }
        },
        {
          title: '客户号单日提现/代付限额',
          key: 'industryDateAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.industryDateAmt / 100 + '元')
          }
        },
        {
          title: '单位结算卡单笔提现/代付限额',
          key: 'unitIndividualAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.unitIndividualAmt / 100 + '元')
          }
        },
        {
          title: '对私子账户提现/代付单日限额',
          key: 'subaccountsDateAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.subaccountsDateAmt / 100 + '元')
          }
        },
        {
          title: '对公子账户提现/代付单日限额',
          key: 'publicSubaccountsDateAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.publicSubaccountsDateAmt / 100 + '元')
          }
        },
        {
          title: '客户号余额支付单日限额',
          key: 'industryBalanceDateAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.industryBalanceDateAmt / 100 + '元')
          }
        },
        {
          title: '对私子账户余额支付单日限额',
          key: 'privateSubaccountsBalanceDateAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.privateSubaccountsBalanceDateAmt / 100 + '元')
          }
        },
        {
          title: '对公子账户余额支付单日限额',
          key: 'publicSubaccountsBalanceDateAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.publicSubaccountsBalanceDateAmt / 100 + '元')
          }
        },
        {
          title: '相同订单最大分账数量',
          key: 'sameOrderMaxSpeAmt',
          width: 150 * avg
        },
        {
          title: '相同提现金额最大次数',
          key: 'sameCashMaxAmt',
          width: 150 * avg
        },
        {
          title: '一分钟内最大提现交易笔数',
          key: 'minuteMaxCashTranAmt',
          width: 150 * avg
        },
        {
          title: '备注信息',
          key: 'remark',
          width: 150 * avg
        },
        {
          title: '操作类型',
          key: 'operationType',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.operationType === '0') {
              res = '删除'
            }
            if (a.row.operationType === '1') {
              res = '修改'
            }
            if (a.row.operationType === '2') {
              res = '新增'
            }
            return h('span', res)
          }
        },
        {
          title: '申请人',
          key: 'userCreate',
          width: 150 * avg
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
          width: 150 * avg,
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
          title: '审核时间',
          key: 'gmtModified',
          width: 150 * avg,
          render (h, a, b) {
            if (this.row.gmtModified !== null) {
              return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
            }
          }
        },
        {
          title: '审核人员',
          key: 'userModified',
          width: 150 * avg
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
        //           id: 'quotaExaApprovalEdit',
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
        //             id: 'deleteProduct',
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
      this.applyBtn = true
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/industryAmLimitApproval/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.industryName) {
        query.parameters.industryName = this.industryName
      } else {
        delete query.parameters.merName
      }
      if (this.industryCode) {
        query.parameters.industryCode = this.industryCode
      } else {
        delete query.parameters.industryCode
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
      this.transBeginDate = ''
      this.transEndDate = ''
      if (this.transBeginDatePass) {
        if (this.beginTransTime) {
          this.transBeginDate = this.transBeginDatePass + ' '+ this.beginTransTime
        } else {
          this.transBeginDate = this.transBeginDatePass + ' '+ '00:00:00'
        }
        query.parameters.transBeginDate = this.transBeginDate
      } else {
        delete query.parameters.transBeginDatePass
      }
      if (this.transEndDatePass) {
        if (this.endTransTime) {
          this.transEndDate = this.transEndDatePass + ' '+ this.endTransTime
        } else {
          this.transEndDate = this.transEndDatePass + ' '+ '23:59:59'
        }
        query.parameters.transEndDate = this.transEndDate
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
      this.industryCode = ''
      this.industryName = ''
      this.operationType = ''
      this.auditStatus = ''
      this.transBeginDate = ''
      this.beginTransTime = ''
      this.transEndDate = ''
      this.endTransTime = ''
      this.transBeginDatePass = ''
      this.transEndDatePass = ''
      this.applyBtn = true
    },
    createBtn () {
      this.$router.push({
        name: 'addQuotaExaApproval'
      })
    },
    beginTradeDateChange (value) {
      this.transBeginDatePass = value
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return date && date.valueOf() < dateGet.valueOf() - 86400000
        }
      }
    },
    endTradeDateChange (value) {
      this.transEndDatePass = value
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
        }
      }
    },
    quotaExaApprovalApplyBtn () {
      this.examineStatu = true
    },
    operationTypeChange (val) {
      this.operationType = val
    },
    auditStatusChangeTwo (val) {
      this.auditStatus = val
    },
    cancelAuditStatus () {
      this.examineStatu = false
    },
    sumbitAuditStatus () {
      let that = this
      if (this.auditStatus && this.id) {
        let formData = {
          auditStatus: this.auditStatus,
          id: this.id,
          remark: this.remark
        }
        this.$axios.put('/industryAmLimitApprovalAudit', formData).then(function (res) {
          that.auditStatus = ''
          that.id = ''
          that.remark = ''
          that.searchList()
          that.$Message.success('交易限额审核成功')
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
    selectDataNew (currentRow) {
      if (currentRow.auditStatus === '0') {
        this.id = currentRow.id
        this.applyBtn = false
      } else {
        this.applyBtn = true
      }
    },
    doDelete (row) {
      this.$axios.delete('/quotaExaApproval' + '/' + row.id)
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
        name: 'editQuotaExaApproval',
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
