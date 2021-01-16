<style lang="less">
  /*@import '../../../styles/common.less';*/
</style>
<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="账号：" prop="account">
            <Input v-model="account" :maxlength="200"/>
          </FormItem>
          <FormItem label="证件号：" prop="busLicCode">
            <Input v-model="busLicCode" :maxlength="18"/>
          </FormItem>
          <FormItem label="账户类型：" prop="objType">
            <Select v-model="objType" style="width: 180px"  @on-change="objTypeChange">
              <i-option value="1">平台账户</i-option>
              <i-option value="2">企业账户</i-option>
              <i-option value="3">个人账户</i-option>
              <i-option value="8">个体工商户账户</i-option>
              <i-option value="9">待结算账户</i-option>
            </Select>
          </FormItem>
          <FormItem label="户名：" prop="objName">
            <Input v-model="objName" :maxlength="200"/>
          </FormItem>
          <FormItem label="操作类型：" prop="operationType">
            <Select v-model="operationType" style="width: 180px"  @on-change="operationTypeChange">
              <i-option value="0">冻结</i-option>
              <i-option value="1">解冻</i-option>
            </Select>
          </FormItem>
          <FormItem label="审核状态：" prop="auditStatus">
            <Select v-model="auditStatus" style="width: 180px"  @on-change="auditStatusChangeTwo">
              <i-option value="0">待审核</i-option>
              <i-option value="1">审核通过</i-option>
              <i-option value="2">审核驳回</i-option>
            </Select>
          </FormItem>
          <FormItem  label="申请开始时间：" prop="gmtCreate" >
            <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem  label="申请结束时间：" prop="transEndDate" >
            <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="freezingFundsOpeRecord" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <!--<Button type="success" v-access id="quotaExaApprovalAdd" @click="createBtn()" style="margin-right: 10px;">新增</Button>-->
            <Button type="warning" v-access id="blacklistAprOperListShenHe" @click="quotaExaApprovalApplyBtn()" style="margin-right: 10px;" :disabled="applyBtn">审核</Button>
            <Button type="success" v-access id="freezingFundsOpeRecordJieDong" @click="thawZiJin()" :disabled="thawBtnZiJin" style="margin-right: 10px;">资金解冻</Button>
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
      title="资金冻结解冻审核"
      width="350"
    >
      <Select v-model="formDataShenHe.auditStatus" style="width: 180px"  @on-change="auditStatusChange">
        <i-option value="1">审核通过</i-option>
        <i-option value="2">审核驳回</i-option>
      </Select>
      <i-input type="textarea" v-model="formDataShenHe.auditRemark" placeholder="请输入备注" style="margin-top: 10px"></i-input>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelAuditStatus">取消</Button>
        <Button type="primary" size="large" @click="sumbitAuditStatus">确定</Button>
      </div>
    </Modal>
    <Modal
      title="确定是否解冻资金"
      v-model="thawZiJinMask"
      @on-ok="thawZinJinOk"
      :mask-closable="false">
      <p>账号：{{newAccount}}</p>
      <br>
      <p>账户名称：{{newobjName}}</p>
      <br>
      <p>解冻资金：{{frozenAmount}}</p>
    </Modal>
  </card>
</template>
<script>
export default {
  name: "freezingFundsOpeRecord",
  data () {
    return {
      newAccount: '',
      newobjName: '',
      frozenAmount: '',
      thawZiJinMask: false,
      thawBtnZiJin: true,
      currentRow: '',
      busLicCode: '',
      account: '',
      objType: '',
      objName: '',
      operationType: '',
      auditStatus: '',
      remark: '',
      formDataShenHe: {
        auditStatus: '',
        auditRemark: ''
      },
      transBeginDatePass: '',
      transBeginDate: '',
      beginTransTime: '',
      transEndDatePass: '',
      transEndDate: '',
      endTransTime: '',
      id: '',
      examineStatu: false,
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
          title: '账户',
          key: 'account',
          width: 150 * avg
        },
        {
          title: '账户类型',
          key: 'objType',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', self.$contants.dictionary.accountTypeMap[a.row.objType])
          }
        },
        {
          title: '证件号',
          key: 'busLicCode',
          width: 150 * avg,
        },
        {
          title: '账户名称',
          key: 'objName',
          width: 150 * avg
        },
        {
          title: '客户号',
          key: 'code',
          width: 150 * avg
        },
        {
          title: '客户名称',
          key: 'indName',
          width: 150 * avg
        },
        {
          title: '操作类型',
          key: 'operationType',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.operationType === '0') {
              res = '冻结'
            }
            if (a.row.operationType === '1') {
              res = '解冻'
            }
            return h('span', res)
          }
        },
        {
          title: '金额',
          key: 'frozenAmount',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.frozenAmount / 100 + '元')
          }
        },
        {
          title: '备注',
          key: 'auditRemark',
          width: 150 * avg
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
            if (this.row.gmtCreate) {
              return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
            }
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
            if (this.row.gmtModified) {
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
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/freezingFundsOpeRecord/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.objName) {
        query.parameters.objName = this.objName
      } else {
        delete query.parameters.objName
      }
      if (this.account) {
        query.parameters.account = this.account
      } else {
        delete query.parameters.account
      }
      if (this.busLicCode) {
        query.parameters.busLicCode = this.busLicCode
      } else {
        delete query.parameters.busLicCode
      }
      if (this.objType) {
        query.parameters.objType = this.objType
      } else {
        delete query.parameters.objType
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
      if (this.busLicCode) {
        query.parameters.busLicCode = this.busLicCode
      } else {
        delete query.parameters.busLicCode
      }
      if (this.transBeginDate) {
        this.transBeginDate = this.$moment(this.transBeginDate).format('YYYY-MM-DD') + ' ' + '00:00:00'
        query.parameters.transBeginDate = this.transBeginDate + this.beginTransTime
      } else {
        delete query.parameters.transBeginDate
      }
      if (this.transEndDate) {
        this.transEndDate = this.$moment(this.transEndDate).format('YYYY-MM-DD') + ' ' + '23:59:59'
        query.parameters.transEndDate = this.transEndDate + this.endTransTime
      } else {
        delete query.parameters.transEndDate
      }

      // 查询机构列表 busLicCode
      let that = this
      this.$axios.post(uri, query)
        .then((response) => {
          that.tableData = response.data.list
          that.total = parseInt(response.data.total)
          that.applyBtn = true
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
      this.objName = ''
      this.objType = ''
      this.account = ''
      this.busLicCode = ''
      this.name = ''
      this.operationType = ''
      this.auditStatus = ''
      this.transBeginDate = ''
      this.beginTransTime = ''
      this.transEndDate = ''
      this.endTransTime = ''
      this.transBeginDatePass = ''
      this.transEndDatePass = ''
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
    objTypeChange (val) {
      this.objType = val
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
    thawZinJinOk () {
      let that = this
      this.currentRow.frozenAmount = this.frozenAmount * 100
      this.currentRow.operationType = '1'
      this.$axios.post('/freezingFundsOpeRecord', this.currentRow).then(function (res) {
        if (res.data === '1') {
          that.$Message.success('资金解冻成功')
          that.frozenAmount = ''
          that.currentRow = ''
          that.thawBtnZiJin = true
          that.thawZiJinMask = false
          that.searchList()
        }
      })
    },
    auditStatusChange (val){
      this.formDataShenHe.auditStatus = val
    },
    thawZiJin () {
      this.thawZiJinMask = true
    },
    sumbitAuditStatus () {
      let that = this
      if (this.formDataShenHe.auditStatus && this.formDataShenHe.auditRemark) {
        this.currentRow.auditStatus = this.formDataShenHe.auditStatus
        this.currentRow.auditRemark = this.formDataShenHe.auditRemark
        this.$axios.put('/freezingFundsOpeRecordOper', this.currentRow).then(function (res) {
          that.currentRow = ''
          that.searchList()
          that.$Message.success('资金冻结审核成功')
          that.examineStatu = false
          that.applyBtn = true
          that.formDataShenHe.auditStatus = ''
          that.formDataShenHe.remark = ''
        }).catch(function (err) {
          that.examineStatu = false
          that.applyBtn = true
          that.formDataShenHe.auditStatus = ''
          that.formDataShenHe.remark = ''
        })
      } else {
        that.$Message.error('请选择审核状态并且填写备注信息')
        that.applyBtn = true
      }
    },
    selectDataNew (currentRow) {
      this.currentRow = ''
      this.currentRow = currentRow
      this.newAccount = currentRow.account
      this.newobjName = currentRow.objName
      this.frozenAmount = currentRow.frozenAmount / 100 + '元'
      this.currentRow = currentRow
      if (currentRow.frozenAmount > 0) {
        if (currentRow.operationType === '0' && currentRow.auditStatus === '1' && (currentRow.unfreezeStatus === '2' || currentRow.unfreezeStatus === null)) {
          this.thawBtnZiJin = false
        } else {
          this.thawBtnZiJin = true
        }
      } else {
        this.thawBtnZiJin = true
      }
      if (currentRow.auditStatus === '0') {
        this.applyBtn = false
      } else {
        this.applyBtn = true
      }
      // if (currentRow.auditStatus === '0') {
      //   this.applyBtn = false
      // } else {
      //   this.applyBtn = true
      //   if (currentRow.operationType === '0' && currentRow.auditStatus === '2') {
      //     this.applyBtn = false
      //   }
      // }
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
