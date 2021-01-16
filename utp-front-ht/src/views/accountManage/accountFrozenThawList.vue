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
          <FormItem label="账号：" prop="account">
            <Input v-model="account" :maxlength="accountSize"/>
          </FormItem>
          <FormItem  label="账户类型：" prop="objType" >
            <Select v-model="objType" style="width: 180px"  @on-change="objTypeChange">
              <Option value="1">平台账户</Option>
              <Option value="2">企业账户</Option>
              <Option value="3">个人账户</Option>
              <Option value="7">佣金账户</Option>
              <Option value="8">个体工商户账户</Option>
              <Option value="9">待结算账户</Option>
            </Select>
          </FormItem>
          <FormItem label="证件号：" prop="busLicCode">
            <Input v-model="busLicCode" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="户名：" prop="objName">
            <Input v-model="objName" :maxlength="accountSize"/>
          </FormItem>
          <FormItem  label="操作类型：" prop="status" >
            <Select v-model="status" style="width: 180px">
              <Option value="0">冻结</Option>
              <Option value="1">解冻</Option>
            </Select>
          </FormItem>
          <FormItem label="审核状态：" prop="account">
            <Select v-model="operationType" style="width: 180px" @on-change="operationTypeChange">
              <Option value="0">冻结审批通过</Option>
              <Option value="1">冻结审批驳回</Option>
              <Option value="2">冻结待审核</Option>
              <Option value="3">解冻待审核</Option>
              <Option value="4">解冻审核驳回</Option>
              <Option value="5">解冻审核通过</Option>
            </Select>
          </FormItem>
          <FormItem  label="申请开始时间：" prop="beginTransDatetime" >
            <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem  label="申请结束时间：" prop="transEndDate" >
            <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="getCashList" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="accountShenHe" @click="shenHe()" :disabled="shenHeBtn" style="margin-right: 10px;">审核</Button>
            <Button type="warning" v-access id="accountBatchAudit" :disabled="batchSelectRows.length === 0" style="margin-right: 10px;" @click="batchAuditClick()">批量审核</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" @on-current-change="selectDataTabelNew" highlight-row stripe @on-selection-change="selectChange"></Table>
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
        <Select v-model="formData.operationType" style="width: 180px"  @on-change="auditStatusChange">
          <Option value="1">审核通过</Option>
          <Option value="2">审核驳回</Option>
        </Select>
      <i-input type="textarea" v-model="formData.remarks" placeholder="请输入备注"></i-input>
      <div slot="footer">
        <Button type="text" size="large" @click="cancel">取消</Button>
        <Button type="primary" size="large" @click="sumbitAccount">确定</Button>
      </div>
    </Modal>
    <Modal v-model="batchAuditModal" title="批量审核" width="350">
      <Form ref="batchAuditFormData" :model="batchAuditFormData" :rules="ruleValidate">
        <FormItem ref="batchAuditFormData" prop="operationType">
          <Select style="width: 180px" v-model="batchAuditFormData.operationType">
            <Option value="1">审核通过</Option>
            <Option value="2">审核驳回</Option>
          </Select>
        </FormItem>
        <FormItem prop="remarks">
          <i-input type="textarea" placeholder="请输入审核备注" v-model="batchAuditFormData.remarks"></i-input>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelBatchAudit">取消</Button>
        <Button type="primary" size="large" @click="submitBatchAudit">确定</Button>
      </div>
    </Modal>
  </card>
</template>

<script>
export default {
  name: "accountFrozenThawList",
  data () {
    return {
      currentRow: {},
      operationTypeNew: '',
      examineStatu: false,
      shenHeBtn: true,
      batchSelectRows: [],
      batchAuditModal: false,
      operationType: '',
      account: '',
      objType: '',
      busLicCode: '',
      objName: '',
      status: '',
      auditStatus: '',
      transBeginDate: '',
      transEndDate: '',
      formData: {
        remarks: '',
        operationType: '',
        id: ''
      },
      batchAuditFormData: {
        remarks: '',
        operationType: '',
        ids: []
      },
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
          return date && date.valueOf() < Date.now() - 86400000
        }
      },
      ruleValidate: {
        operationType: [
          {required: true, trigger: 'change', message: '请选择审核状态'}
        ],
        remarks: [
          {required: true, trigger: 'blur', message: '请输入审核备注'}
        ]
      }
    }
  },
  methods: {
    init () {
      // 设置
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          type: 'selection',
          width: 60,
          align: 'center'
        },
        {
          title: '序号',
          type: 'index',
          width: 70
        },
        {
          title: '账户',
          key: 'account',
          width: 180 * avg
        },
        {
          title: '账户类型',
          key: 'objType',
          width: 180 * avg,
          render (h, a, b) {
            return h('span', self.$contants.dictionary.accountTypeMap[a.row.objType])
          }
        },
        {
          title: '证件号',
          key: 'busLicCode',
          width: 150 * avg
        },
        {
          title: '证件有效期',
          key: 'idValidity',
          width: 150 * avg
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
          width: 185 * avg
        },
        {
          title: '申请备注',
          key: 'applyRemark',
          width: 200 * avg
        },
        {
          title: '审核备注',
          key: 'remarks',
          width: 200 * avg
        },
        {
          title: '申请人',
          key: 'userCreate',
          width: 200 * avg
        },
        {
          title: '申请时间',
          key: 'gmtCreate',
          width: 200 * avg,
          render (h, a, b) {
            return h('span', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '审核状态',
          key: 'operationType',
          width: 200 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.operationType === '0') {
              res = '冻结审批通过'
            }
            if (a.row.operationType === '1') {
              res = '冻结审批驳回'
            }
            if (a.row.operationType === '2') {
              res = '冻结待审核'
            }
            if (a.row.operationType === '3') {
              res = '解冻待审核'
            }
            if (a.row.operationType === '4') {
              res = '解冻审核驳回'
            }
            if (a.row.operationType === '5') {
              res = '解冻审核通过'
            }
            return h('span', res)
          }
        },
        {
          title: '操作类型',
          key: 'status',
          width: 200 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.status === '0') {
              res = '冻结'
            }
            if (a.row.status === '1') {
              res = '解冻'
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
          title: '审核时间',
          key: 'gmtModified',
          width: 200 * avg,
          render (h, a, b) {
            if (this.row.gmtModified) {
              return h('span', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
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
    searchList (param) {
      this.shenHeBtn = true
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/operationRecord/pageList')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.account) {
        this.query.parameters.account = this.account
      } else {
        delete this.query.parameters.account
      }
      if (this.objType) {
        this.query.parameters.objType = this.objType
      } else {
        delete this.query.parameters.objType
      }
      if (this.busLicCode) {
        this.query.parameters.busLicCode = this.busLicCode
      } else {
        delete this.query.parameters.busLicCode
      }
      if (this.status) {
        this.query.parameters.status = this.status
      } else {
        delete this.query.parameters.status
      }
      if (this.objName) {
        this.query.parameters.objName = this.objName
      } else {
        delete this.query.parameters.objName
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
      if (this.operationType) {
        this.query.parameters.operationType = this.operationType
      } else {
        delete this.query.parameters.operationType
      }
      // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          this.tableData = response.data.list
          this.total = parseInt(response.data.total)
          this.tableData.forEach(item => {
            if (item.operationType !== '2' && item.operationType !== '3') {
              item._disabled = true
            }
          });
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    setAccount (row) {
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
    selectDataTabelNew (currentRow) {
      this.currentRow = currentRow
      this.shenHeBtn = true
      if (currentRow.operationType === '2' || currentRow.operationType === '3') {
        this.shenHeBtn = false
      }
    },
    shenHe () {
      this.examineStatu = true
      this.formData.remarks = null
    },
    objTypeChange (val) {
      this.formData.objType = val
    },
    operationTypeChange (val) {
      this.operationType = val
    },
    auditStatusChange (val) {
      this.formData.id = this.currentRow.id
      if (this.currentRow.operationType === '2') {
        if (val === '1') {
          this.operationTypeNew = '0'
        }
        if (val === '2') {
          this.operationTypeNew = '1'
        }
      }
      if (this.currentRow.operationType === '3') {
        if (val === '1') {
          this.operationTypeNew = '5'
        }
        if (val === '2') {
          this.operationTypeNew = '4'
        }
      }
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
    sumbitAccount () {
      let that = this
      this.formData.operationType = this.operationTypeNew
      if (this.formData.remarks && this.formData.id && this.formData.operationType) {
        this.$axios.put('/operationRecordOper/operation', {
          id: this.formData.id,
          remarks: this.formData.remarks,
          operationType: this.formData.operationType
        }).then(function (res) {
          that.$Message.success('审核成功')
          that.shenHeBtn = true
          that.searchList()
        }).catch(function () {
        })
      } else {
        that.$Message.error('请填写正确信息！')
      }
      this.examineStatu = false
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
      this.shenHeBtn = true
      this.status = ''
      this.operationType = ''
      this.objType = ''
      this.busLicCode = ''
      this.objName = ''
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
    selectChange(selection) {
      this.batchSelectRows = selection
    },
    batchAuditClick() {
      this.$refs['batchAuditFormData'].resetFields()
      this.batchAuditModal = true
      this.batchAuditFormData.operationType = ''
      this.batchAuditFormData.remarks = ''
      this.batchAuditFormData.ids.length = 0
      this.batchSelectRows.forEach(item => {
        this.batchAuditFormData.ids.push(item.id)
      })
    },
    submitBatchAudit() {
      let self = this
      self.$refs['batchAuditFormData'].validate((valid) => {
        if (valid) {
          let parameters = {
            ids: self.batchAuditFormData.ids,
            operationType: self.batchAuditFormData.operationType,
            remarks: self.batchAuditFormData.remarks
          }
          self.batchAuditModal = false
          self.$axios.put('/operationRecordOper/batchAudit', parameters).then(function (res) {
            self.$Message.success('审核成功')
            self.batchSelectRows.length = 0
            self.batchAuditFormData.ids.length = 0
            self.searchList()
          }).catch(function () {
          })
        } else {
          self.$Message.error('请正确填写信息')
          return
        }
      })
    },
    cancelBatchAudit() {
      this.batchAuditModal = false
      this.$refs['batchAuditFormData'].resetFields()
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
