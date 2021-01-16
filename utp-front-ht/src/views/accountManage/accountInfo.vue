<style lang="less">
  .ivu-table-row-highlight td {
    background-color: #B6E2FC!important;
  }
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="130" ref="formData" :model="formData" label-position="right" :inline="true" :rules="ruleValidate">
          <FormItem label="账号：" prop="account">
            <Input v-model="account" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="账户类型：" prop="objType">
            <Select v-model="objType" style="width: 141px"  @on-change="objTypeChange">
              <Option v-for="item in accountTypeArray" :value="item.value" :key="item.value">{{item.name}}</Option>
            </Select>
          </FormItem>
          <FormItem label="证件号：" prop="busLicCode">
            <Input v-model="busLicCode" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="户名：" prop="objName">
            <Input v-model="objName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="资金账号：" prop="bankAccountNo">
            <Input v-model="bankAccountNo" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="客户号：" prop="code">
            <Input v-model="code" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="银行客户号：" prop="bankClientNo">
            <Input v-model="bankClientNo" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="银行客户号关联标志：" prop="bankClientStatus">
            <Select v-model="bankClientStatus" style="width: 141px"  @on-change="bankClientNoStaChange">
              <Option value="0">开户未上报</Option>
              <Option value="1">开户已上报</Option>
              <Option value="2">更新未上报</Option>
              <Option value="3">更新已上报</Option>
              <Option value="4">销户未上报</Option>
              <Option value="5">全部</Option>
            </Select>
          </FormItem>
          <FormItem label="账户状态：" prop="status" @on-change="statusChange">
            <Select v-model="status" style="width: 141px">
              <Option value="0">冻结</Option>
              <Option value="1">正常</Option>
              <Option value="2">销户</Option>
            </Select>
          </FormItem>
          <FormItem label="距离证件失效天数：" prop="expireDays">
            <Input style="width: 141px" v-model="expireDays" />
          </FormItem>
          <FormItem  label="开始日期：" prop="beginTradeDate1">
            <DatePicker style="width: 141px" :options="beginDateOption" v-model="beginTradeDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>
          </FormItem>
          <FormItem  label="开始时间：" prop="beginTransTime" >
            <Time-picker confirm placeholder="选择时间" :editable="false" v-model="beginTransTime"  style="width: 141px"></Time-picker>
          </FormItem>
          <FormItem label="结束日期：" prop="endTradeDate1" >
            <DatePicker style="width: 141px" :options="endDateOption" v-model="endTradeDate" class="input-width-170" type="date" :editable="false" format="yyyy-MM-dd" placeholder="请选择交易结束日期" @on-change="endTradeDateChange"></DatePicker>
          </FormItem>
          <FormItem label="结束时间：" prop="endTransTime" >
            <Time-picker confirm placeholder="选择时间" :editable="false" v-model="endTransTime" style="width: 141px"></Time-picker>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listAccount" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="frozenBtn" @click="frozen()" :disabled="frozenBtn" style="margin-right: 10px;">账户冻结</Button>
            <Button type="success" v-access id="thawBtn" @click="thaw()" :disabled="thawBtn" style="margin-right: 10px;">账户解冻</Button>
            <Button type="success" v-access id="thawBtnZiJin" @click="thawZiJin()" :disabled="thawBtnZiJin" style="margin-right: 10px;">资金冻结</Button>
            <Button type="success" v-access id="accountReportBank" @click="accountReportBank()" :disabled="thawBtnReport" style="margin-right: 10px;">上报银行系统</Button>
            <Button type="success" v-access id="accounElectronic" @click="downloadBtn()" :disabled="downloadBtnabled" style="margin-right: 10px;">下载电子回单</Button>
            <Button type="success" v-access id="batchAcctFrozenBtn" @click="batchAcctFrozenModal = true" :disabled="this.tempIdListChuLi.length == 0 || this.batchOperationType != 'batchAcctFrozen'" style="margin-right: 10px;">批量账户冻结</Button>
            <Button type="success" v-access id="batchAcctUnFrozenBtn" @click="batchAcctUnFrozenModal = true" :disabled="this.tempIdListChuLi.length == 0 || this.batchOperationType != 'batchAcctUnFrozen'" style="margin-right: 10px;">批量账户解冻</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <RadioGroup v-model="batchOperationType" type="button" @on-change="batchOperationTypeChage">
          <Radio label = "batchAcctFrozen">批量账户冻结</Radio>
          <Radio label = "batchAcctUnFrozen">批量账户解冻</Radio>
          <Radio label = "batchReportBank">上报银行系统</Radio>
      </RadioGroup>
    </Row>
    <br/>
    <Row style=" height: 40px; background: #9ea7b4; color: #fff; line-height: 40px; text-indent: 1.2em">
      <Col :span="8">
        <span>账户总余额：{{balanceTotal}}</span>
      </Col>
      <Col :span="8">
        <span>冻结总金额：{{frozenAmountTotal}}</span>
      </Col>
      <Col :span="8">
        <span>可用总余额：{{availAmountTotal}}</span>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" ref="selection" :data="tableData" @on-current-change="selectDataTabelNew" highlight-row stripe @on-selection-change="selectDataGo"></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
    </Row>
    <Modal
      v-model="cashGetApplyModel"
      title="提现申请"
      :mask-closable="false"
      width="350"
    >
      <Form :label-width="120" ref="countData" :model="countData" label-position="right" :inline="true">
        <FormItem label="提现账户：" prop="reciveId">
          <i-select v-model="countData.reciveId"   @on-change="cashAccountChange" placeholder="请选择提现账户">
            <i-option v-for="item in cashAccountAry"  :key="item.id" :value="item.id">{{ item.accountName.length > 8?item.accountName.slice(0,8)+'...' : item.accountName }}</i-option>
          </i-select>
        </FormItem>
        <FormItem label="提现金额：" prop="amount">
          <Input v-model="countData.amount" placeholder="请输入提现金额" :maxlength="200"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="cancel">取消</Button>
        <Button type="primary" size="large" @click="sumbitAccount">确定</Button>
      </div>
    </Modal>
    <Modal
      title="确定是否冻结"
      v-model="frozenMask"
      @on-ok="frozenOk"
      :mask-closable="false">
      <p>账号：{{newAccount}}</p>
        <br/>
        <p>账户类型：{{newobjType}}</p>
        <br/>
        <p>账户名称：{{newobjName}}</p>
        <br/>
        <i-input type="textarea" placeholder="请输入申请备注" v-model="auditRemark" :maxlength="200"></i-input>
    </Modal>
    <Modal
      title="确定是否解冻"
      v-model="thawMask"
      @on-ok="thawOk"
      :mask-closable="false">
        <p>账号：{{newAccount}}</p>
        <br/>
        <p>账户类型：{{newobjType}}</p>
        <br/>
        <p>账户名称：{{newobjName}}</p>
        <br/>
        <i-input type="textarea" placeholder="请输入申请备注" v-model="auditRemark" :maxlength="200"></i-input>
    </Modal>
    <Modal
      title="确定是否冻结资金"
      v-model="thawZiJinMask"
      @on-ok="thawZinJinOk"
      :mask-closable="false">
      <p>账号：{{newAccount}}</p>
      <br>
      <p>账户名称：{{newobjName}}</p>
      <br>
      冻结资金(元)：<Input v-model="frozenAmount" style="width: 300px" :maxlength="200"/>
      <br><br>
      备注：
      <Input v-model="auditRemark" style="width: 300px" :maxlength="200"/>
    </Modal>
    <Modal
      title="确定是否上报银行系统"
      v-model="thawReportMask"
      @on-ok="thawReportOk"
      :mask-closable="false">
      <p>请选择确定或取消</p>
      <br>
    </Modal>
    <Modal
      title="确定是否批量账户冻结"
      v-model="batchAcctFrozenModal"
      @on-ok="submitBatch(2)"
      :mask-closable="false">
      <i-input type="textarea" placeholder="请输入申请备注" v-model="auditRemark" :maxlength="200"></i-input>
      <br>
    </Modal>
    <Modal
      title="确定是否批量账户解冻"
      v-model="batchAcctUnFrozenModal"
      @on-ok="submitBatch(3)"
      :mask-closable="false">
      <i-input type="textarea" placeholder="请输入申请备注" v-model="auditRemark" :maxlength="200"></i-input>
      <br>
    </Modal>
  </card>
</template>

<script>
export default {
  name: 'accountList',
  data () {
    const validateExpireDays = (rule, value, callback) => {
      if (this.expireDays === '') {
        callback()
      } else if (!/^[0-9]*$/.test(this.expireDays)) {
        callback(new Error('只能输入数字'))
      } else if (this.expireDays < 1 || this.expireDays > 90) {
        callback(new Error('距离证件失效天数范围[1,90]'))
      } else {
        callback()
      }
    }
    return {
      tempIdListChuLi: [],
      accountTypeArray: this.$contants.dictionary.accountTypeArray,
      beginTradeDate: this.$moment(new Date()).format('YYYY-MM-DD'),
      beginTransTime: '00:00:00',
      endTradeDate: this.$moment(new Date()).format('YYYY-MM-DD'),
      endTransTime: '23:59:59',
      thawZiJinRow: '',
      frozenAmount: '',
      auditRemark: '',
      newAccount: '',
      newobjName: '',
      newobjType: '',
      expireDays: '',
      batchOperationType: 'batchReportBank',
      frozenMask: false,
      thawMask: false,
      thawZiJinMask: false,
      thawReportMask: false,
      batchAcctFrozenModal: false,
      batchAcctUnFrozenModal: false,
      currentRow: {},
      frozenBtn: true,
      thawBtn: true,
      thawBtnZiJin: true,
      thawBtnReport: true,
      downloadBtnabled: true,
      balanceTotal: 0 + '元',
      frozenAmountTotal: 0 + '元',
      availAmountTotal: 0 + '元',
      busLicCode: '',
      cashGetApplyModel: false,
      cashAccountAry: [],
      fundAccount: '',
      account: '',
      objType: '',
      objCode: '',
      objName: '',
      code: '',
      bankClientNo: '', // 银行客户号
      bankClientStatus: '', // 银行客户号关联标志
      verifyStatus: '', // 打款验证
      bankAccountNo: '',
      status: '',
      formData: {},
      countData: {
        account: '',
        amount: '',
        reciveId: ''
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
          return date && date.valueOf() < Date.now()
        }
      },
      ruleValidate: {
        expireDays: [
          {pattern: /^[0-9]*$/, message: '只能输入数字'},
          {validator: validateExpireDays, trigger: 'blur'}
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
          title: '账号',
          key: 'account',
          width: 200 * avg
        },
        {
          title: '账户类型',
          key: 'objType',
          width: 120 * avg,
          render (h, a, b) {
            return h('span', self.$contants.dictionary.accountTypeMap[a.row.objType])
          }
        },
        {
          title: '证件号',
          key: 'busLicCode',
          width: 140 * avg
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
          width: 140 * avg,
          title: '客户号',
          key: 'code'
        },
        {
          width: 140 * avg,
          title: '客户名称',
          key: 'indName'
        },
        {
          width: 140 * avg,
          title: '资金账号',
          key: 'bankAccountNo'
        },
        {
          width: 140 * avg,
          title: '资金账号名称',
          key: 'bankAccountName'
        },
        {
          title: '账户创建时间',
          key: 'gmtCreate',
          width: 150 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '账户余额',
          key: 'balance',
          width: 100 * avg,
          render (h, a, b) {
            return h('span', a.row.balance / 100 + '元')
          }
        },
        {
          title: '冻结金额',
          key: 'frozenAmount',
          width: 100 * avg,
          render (h, a, b) {
            return h('span', a.row.frozenAmount / 100 + '元')
          }
        },
        {
          title: '可用余额',
          key: 'availAmount',
          width: 100 * avg,
          render (h, a, b) {
            return h('span', a.row.availAmount / 100 + '元')
          }
        },
        {
          width: 140 * avg,
          title: '银行客户号',
          key: 'bankClientNo'
        },
        {
          width: 140 * avg,
          title: 'ECIF开户渠道',
          key: 'bankClientChnFlag',
          render (h, a, b) {
            let res = ''
            if (a.row.bankClientChnFlag === '0') {
              res = '自有渠道'
            }
            if (a.row.bankClientChnFlag === '1') {
              res = '其他渠道'
            }
            return h('span', res)
          }
        },
        {
          width: 140 * avg,
          title: 'ECIF开户关联标识',
          key: 'bankClientStatus',
          render (h, a, b) {
            let res = ''
            if (a.row.bankClientStatus === '0') {
              res = '开户未上报'
            }
            if (a.row.bankClientStatus === '1') {
              res = '开户已上报'
            }
            if (a.row.bankClientStatus === '2') {
              res = '更新未上报'
            }
            if (a.row.bankClientStatus === '3') {
              res = '更新已上报'
            }
            if (a.row.bankClientStatus === '4') {
              res = '销户未上报'
            }
            return h('span', res)
          }
        },

        {
          title: '账户状态',
          key: 'status',
          width: 100 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.status === '0') {
              res = '冻结'
            }
            if (a.row.status === '1') {
              res = '正常'
            }
            if (a.row.status === '2') {
              res = '销户'
            }
            return h('span', res)
          }
        },
        {
          title: '审核状态',
          key: 'operationType',
          width: 100 * avg,
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
          title: '操作',
          key: 'action',
          align: 'center',
          width: 190 * avg,
          render: (h, params) => {
            if (params.row.objType === '1') {
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'detailAccount',
                    title: '账户详情'
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
                      this.showDetailTwo(params.row)
                    }
                  }
                }, '账户详情'),
                h('svg-icon', {
                  attrs: {
                    id: 'detailAccount',
                    title: '资金明细'
                  },
                  props: {
                    type: 'zijinmingxi',
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
                }, '资金明细')
              ])
            }
            if (params.row.objType === '2' || params.row.objType === '3' || params.row.objType === '7' || params.row.objType === '8' ) {
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'detailAccount',
                    title: '账户详情'
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
                      this.showDetailTwo(params.row)
                    }
                  }
                }, '账户详情'),
                h('svg-icon', {
                  attrs: {
                    id: 'detailAccount',
                    title: '资金明细'
                  },
                  props: {
                    type: 'zijinmingxi',
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
                }, '资金明细'),
                h('svg-icon', {
                  attrs: {
                    id: 'accountSetFee',
                    title: '配置手续费'
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
                      this.setFee(params.row)
                    }
                  }
                }, '配置手续费'),
                h('svg-icon', {
                  attrs: {
                    id: 'accountBankCardListBtn',
                    title: '银行卡列表'
                  },
                  props: {
                    type: 'bankList',
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
                      this.accountBankCardList(params.row)
                    }
                  }
                }, '银行卡列表')
              ])
            } else {
              if (params.row.objType === '6' ) {
                return h('div', [
                  h('svg-icon', {
                    attrs: {
                      id: 'detailAccount',
                      title: '资金明细'
                    },
                    props: {
                      type: 'zijinmingxi',
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
                  }, '资金明细'),
                  h('svg-icon', {
                    attrs: {
                      id: 'cashApply',
                      title: '提现申请'
                    },
                    props: {
                      type: 'getCash',
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
                        this.cashApply(params.row)
                      }
                    }
                  }, '提现申请')
                ])
              } else if ( params.row.objType === '9'){
                return h('div', [
                  h('svg-icon', {
                    attrs: {
                      id: 'detailAccount',
                      title: '账户详情'
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
                        this.showDetailTwo(params.row)
                      }
                    }
                  }, '账户详情'),
                  h('svg-icon', {
                    attrs: {
                      id: 'detailAccount',
                      title: '资金明细'
                    },
                    props: {
                      type: 'zijinmingxi',
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
                  }, '资金明细')
                ])
              } else {
                return h('div', [
                  h('svg-icon', {
                    attrs: {
                      id: 'detailAccount',
                      title: '资金明细'
                    },
                    props: {
                      type: 'zijinmingxi',
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
                  }, '资金明细')
                ])
              }
            }
          }
        }
      ]
      // 查询信息
      let self = this
      this.$axios.get('/dictionaries').then(function (res) {
        self.bankNameAry = res.data.bank
      })
    },
    beginTradeDateChange (value) {

      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() < dateGet.valueOf() - 86400000)
        }
      }
      this.beginTransDate = value
    },
    endTradeDateChange (value) {
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf() - 86400000)
        }
      }
      this.endTransDate = value
    },
    thawOk () {
      let that = this
      this.currentRow.operationType = '3'
      if (this.auditRemark === '') {
        that.$Message.error('申请备注不能为空')
        return false
      }
      let parameters = {
        bankAccountName: this.currentRow.bankAccountName,
        bankAccountNo: this.currentRow.bankAccountNo,
        indName: this.currentRow.indName,
        code: this.currentRow.code,
        objName: this.currentRow.objName,
        busLicCode: this.currentRow.busLicCode,
        objType: this.currentRow.objType,
        account: this.currentRow.account,
        status: this.currentRow.status,
        operationType: this.currentRow.operationType,
        applyRemark: this.auditRemark, 
      }
      this.$axios.post('/operationRecord', parameters).then(function (res) {
        that.auditRemark = ''
        if (res.data === '1') {
          that.$Message.success('解冻成功')
          that.searchList()
        }
      })
    },
    thawZinJinOk () {
      let that = this
      if (this.frozenAmount === '') {
        that.$Message.error('冻结资金不能为空')
        that.frozenAmount = ''
        return false
      } else {
        let tester = /^\d+(\.{0,1}\d+){0,2}$/
        if (tester.test(this.frozenAmount) && this.frozenAmount > 0) {
          if (this.frozenAmount.indexOf('.') >= 0){
            if (this.frozenAmount.split('.')[1].length > 2) {
              that.$Message.error('冻结金额金额格式不正确')
              that.frozenAmount = ''
              that.auditRemark = ''
              that.thawBtnZiJin = true
              that.searchList()
              return false
            }
          }
          this.currentRow.frozenAmount = this.frozenAmount * 100
          this.currentRow.operationType = '0'
          this.currentRow.auditRemark = this.auditRemark
          this.$axios.post('/freezingFundsOpeRecord', this.currentRow).then(function (res) {
            if (res.data === '1') {
              that.frozenAmount = ''
              that.auditRemark = ''
              that.currentRow.frozenAmount = ''
              that.thawBtnZiJin = true
              that.$Message.success('资金冻结成功')
              that.searchList()
            }
          })
        } else {
          this.$Message.error('冻结金额金额格式不正确')
          this.frozenAmount = ''
          this.auditRemark = ''
        }
      }
    },
    thawReportOk () { // 上报银行系统
      if (this.tempIdListChuLi.length === 0) {
        this.$Message.error('请选择上报信息')
        return false
      }
      let ids = []
      this.tempIdListChuLi.forEach(function (e, i) {
        ids.push(e.id)
      })
      this.currentRow.idList = ids
      let that = this
      this.$axios.put('/account/reportBank', this.currentRow).then(function (res) {
        if (res.status === 200) {
          that.thawBtnReport = true
          that.$Message.success('上报成功')
          that.searchList()
        }
      })
    },
    frozenOk () {
      let that = this
      this.currentRow.operationType = '2'
      if (this.auditRemark === '') {
        that.$Message.error('申请备注不能为空')
        return false
      }
      let parameters = {
        bankAccountName: this.currentRow.bankAccountName,
        bankAccountNo: this.currentRow.bankAccountNo,
        indName: this.currentRow.indName,
        code: this.currentRow.code,
        objName: this.currentRow.objName,
        busLicCode: this.currentRow.busLicCode,
        objType: this.currentRow.objType,
        account: this.currentRow.account,
        status: this.currentRow.status,
        operationType: this.currentRow.operationType,
        applyRemark: this.auditRemark, 
      }
      this.$axios.post('/operationRecord', parameters).then(function (res) {
        if (res.data === '1') {
          that.auditRemark = ''
          that.$Message.success('冻结成功')
          that.searchList()
        }
      })
    },
    frozen () {
      this.frozenMask = true
    },
    thaw () {
      this.thawMask = true
    },
    thawZiJin () {
      this.thawZiJinMask = true
    },
    accountReportBank () {
      this.thawReportMask = true
    },
    downloadBtn () {
      this.downloadBtnabled = true
      let self = this
      // let query = self.formData
      self.$axios({
        method: 'get',
        url: '/accounElectronic/download/' + self.newAccount,
        responseType: 'arraybuffer'
      }).then(response => {
        self.downLoadGo(response.data)
      }).catch((error) => {

      });
    },
    downLoadGo (data) {
      if (!data) {
        return
      }
      let downName = '开户电子回单.pdf' // 文件下载名称
      const blob = new Blob([data])
      if (window.navigator.msSaveOrOpenBlob) {
        // 兼容IE
        navigator.msSaveBlob(blob, downName)
      } else {
        let url = window.URL.createObjectURL(new Blob([data]))
        let link = document.createElement('a')
        link.style.display = 'none'
        link.href = url
        link.setAttribute('download', '开户电子回单' + '.pdf')
        document.body.appendChild(link)
        link.click()
      }
    },
    selectDataGo (currentRow) {
      let self = this
      this.frozenBtn = true
      this.thawBtn = true
      this.thawBtnZiJin = true
      this.downloadBtnabled = true
      this.thawBtnReport = true
      self.tempIdListChuLi = []
      currentRow.forEach(function (e, i) {
        let params = {
        bankAccountName: e.bankAccountName,
        bankAccountNo: e.bankAccountNo,
        indName: e.indName,
        code: e.code,
        objName: e.objName,
        busLicCode: e.busLicCode,
        objType: e.objType,
        account: e.account,
        status: e.status,
        id: e.id
      }
        self.tempIdListChuLi.push(params)
      })
      if (self.tempIdListChuLi.length > 0) {
        if (self.batchOperationType === 'batchReportBank') {
          self.thawBtnReport = false
        }
      }
    },
    selectDataTabelNew (currentRow) {
      this.$refs.selection.selectAll(false)
      this.thawZiJinRow = currentRow
      this.newAccount = currentRow.account
      this.newobjName = currentRow.objName
      let getReslt = this.$contants.dictionary.accountTypeMap[currentRow.objType]
      this.newobjType = getReslt
      this.frozenBtn = true
      this.thawBtn = true
      this.thawBtnZiJin = true
      this.currentRow = currentRow
      this.thawBtnReport = true
      this.downloadBtnabled = true
      if (currentRow.objType === '1' || currentRow.objType === '2' || currentRow.objType === '3' || currentRow.objType === '7' || currentRow.objType === '8' || currentRow.objType === '9') {
        if (currentRow.operationType === '1' || currentRow.operationType === '5' || currentRow.operationType === null) {
          this.frozenBtn = false
        }
        if (currentRow.operationType === '4' || currentRow.operationType === '0') {
          this.thawBtn = false
        }
      }
      if (currentRow.objType === '1' || currentRow.objType === '2' || currentRow.objType === '3' || currentRow.objType === '8' || currentRow.objType === '9') {
        if (currentRow.availAmount > 0) {
          this.thawBtnZiJin = false
        }
      }
      // if (currentRow.objType === '1' || currentRow.objType === '2' || currentRow.objType === '3' || currentRow.objType === '7' || currentRow.objType === '8') {
      //   if ((currentRow.bankClientStatus === '0' || currentRow.bankClientStatus === '2') && currentRow.bankClientChnFlag === '0') {
      //     this.tempIdListChuLi = []
      //     this.tempIdListChuLi.push(this.currentRow.id)
      //     this.thawBtnReport = false
      //   }
      // }
      if ( currentRow.objType === '2' || currentRow.objType === '3' || currentRow.objType === '8') {
        this.downloadBtnabled = false
      }
    },
    searchList (param) {
      this.tempIdListChuLi.length = 0
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/account/pageList')
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
      if (this.objName) {
        this.query.parameters.objName = this.objName
      } else {
        delete this.query.parameters.objName
      }
      if (this.code) {
        this.query.parameters.code = this.code
      } else {
        delete this.query.parameters.code
      }
      if (this.bankAccountNo) {
        this.query.parameters.bankAccountNo = this.bankAccountNo
      } else {
        delete this.query.parameters.bankAccountNo
      }
      if (this.bankClientNo) {
        this.query.parameters.bankClientNo = this.bankClientNo
      } else {
        delete this.query.parameters.bankClientNo
      }
      if (this.bankClientStatus) {
        this.query.parameters.bankClientStatus = this.bankClientStatus
      } else {
        delete this.query.parameters.bankClientStatus
      }
      if (this.verifyStatus) {
        this.query.parameters.verifyStatus = this.verifyStatus
      } else {
        delete this.query.parameters.verifyStatus
      }
      if (this.status) {
        this.query.parameters.status = this.status
      } else {
        delete this.query.parameters.status
      }
      if (this.expireDays) {
        this.query.parameters.expireDays = this.expireDays
      } else {
        delete this.query.parameters.expireDays
      }
      let beginTransTime = this.beginTransTime
      let endTransTime = this.endTransTime
      if (this.beginTransDate === undefined) {
        this.beginTransDate = this.$moment(new Date()).format('YYYY-MM-DD')
      }
      if (this.endTransDate === undefined) {
        this.endTransDate = this.$moment(new Date()).format('YYYY-MM-DD')
      }
      this.query.parameters.beginTransDatetime = this.beginTransDate + ' ' + beginTransTime
      this.query.parameters.endTransDatetime = this.endTransDate + ' ' + endTransTime
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          this.frozenBtn = true
          this.thawBtn = true
          this.tableData = response.data.page.list
          this.total = parseInt(response.data.page.total)
          if (response.data.total.totalAvailAmount > 0) {
            this.availAmountTotal = response.data.total.totalAvailAmount / 100 + '元'
          } else {
            this.availAmountTotal = 0 + '元'
          }
          if (response.data.total.totalFrozenAmount > 0) {
            this.frozenAmountTotal = response.data.total.totalFrozenAmount / 100 + '元'
          } else {
            this.frozenAmountTotal = 0 + '元'
          }
          if (response.data.total.totalBalance > 0) {
            this.balanceTotal = response.data.total.totalBalance / 100 + '元'
          } else {
            this.balanceTotal = 0 + '元'
          }
          this.eachDataSelectDisabled(this.batchOperationType, response.data.page.list)
        })
        .catch(function (error) {
          console.log(error)
        })
        }
      })
    },
    setFee (row) {
      this.$router.push({
        name: 'setFee',
        params: {
          id: row.id,
          feeTemplateId: row.feeTemplateId,
          feeTemplateName: row.feeTemplateName
        }
      })
    },
    accountBankCardList (row) {
      this.$router.push({
        name: 'accountBankCardList',
        params: {
          id: row.id,
          account: row.account,
          bindStatus: '-1'
        }
      })
    },
    cashApply (row) {
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {
          account: row.account
        }
      }
      localStorage.removeItem('accountGo')
      localStorage.setItem('accountGo', row.account)
      this.countData.account = localStorage.getItem('accountGo')
      this.cashGetApplyModel = true
      // this.fundAccount = row.fundAccount
      let self = this
      this.$axios.post('/withdrawCashAccount/list', query).then(function (res) {
        self.cashAccountAry = res.data.list
      })
    },
    cashAccountChange (val) {
      this.countData.reciveId = val
    },
    objTypeChange (val) {
      this.objType = val
    },
    statusChange(val) {
      this.status = val
    },
    bankClientNoStaChange (val) {
      this.bankClientStatus = val
    },
    sumbitAccount () {
      let that = this
      if (this.countData.amount) {
        if (this.countData.amount.indexOf('.') > 0) {
          if (this.countData.amount.split('.')[1].length >= 3) {
            this.$Message.error('请输入小于12位的正整数，最多保留2位小数')
          }
        }
     }
      let tester = /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/
      if (tester.test(this.countData.amount) && this.countData.amount.length <= 12) {
        if (this.countData.reciveId) {
          this.$refs['countData'].validate((valid) => {
            if (valid) {
              this.countData.amount = (parseFloat(this.countData.amount * 100).toFixed(0)).toString()
              this.$axios.post('/withdrawalsRecord', this.countData).then(function (res) {
                that.countData.account = ''
                that.countData.amount = ''
                that.countData.reciveId = ''
                that.searchList()
                that.$Message.success('提现申请成功')
                that.cashGetApplyModel = false
              }).catch(function (err) {
                that.countData.account = ''
                that.countData.amount = ''
                that.countData.reciveId = ''
                that.searchList()
                // that.$Message.error('提现申请失败')
                that.cashGetApplyModel = false
              })
            } else {
              that.countData.account = ''
              that.countData.amount = ''
              that.countData.reciveId = ''
              that.$Message.error('请正确填写信息')
              that.cashGetApplyModel = false
            }
          })
        } else {
          that.$Message.error('请选择提现账户')
        }
      } else {
        that.$Message.error('请输入小于12位的正整数，最多保留2位小数')
        this.countData.amount = ''
      }
    },
    cancel () {
      this.cashGetApplyModel = false
      this.countData = {}
    },
    changePage (index) {
      // 分页点击事件
      this.currentPage = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.frozenBtn = true
      this.thawBtn = true
      this.thawBtnZiJin = true
      this.thawBtnReport = true
      this.currentPage = 1
      this.searchList()
    },
    clearBtn () {
      this.account = ''
      this.objType = ''
      this.objCode = ''
      this.objName = ''
      this.code = ''
      this.bankAccountNo = ''
      this.busLicCode = ''
      this.bankClientStatus = ''
      this.verifyStatus = ''
      this.bankClientNo = ''
      this.frozenBtn = true
      this.thawBtn = true
      this.thawBtnZiJin = true
      this.thawBtnReport = true
      this.beginTransTime = '00:00:00'
      this.endTransTime = '23:59:59'
      this.beginTransDate = this.$moment(new Date()).format('YYYY-MM-DD')
      this.beginTradeDate = this.$moment(new Date()).format('YYYY-MM-DD')
      this.endTransDate = this.$moment(new Date()).format('YYYY-MM-DD')
      this.endTradeDate = this.$moment(new Date()).format('YYYY-MM-DD')
      this.status = ''
      this.expireDays = ''
      this.tempIdListChuLi.length = 0
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
        name: 'accountDetail',
        params: {
          id: row.account
        }
      })
    },
    showDetailTwo (row) {
      this.$router.push({
        // name: 'accountDetailTwo',
        name: row.objType === '9' ? 'accountDetailThree' : 'accountDetailTwo',
        params: {
          id: row.id,
          objType: row.objType,
          userType: row.userType,
          code: row.code,
          bankClientStatus: row.bankClientStatus
        }
      })
    },
    eachDataSelectDisabled(batchOperationType, data) {
      data.forEach(function (e, i) {
        e._disabled = true // 禁用
        if (batchOperationType === 'batchReportBank') {
          if (e.objType === '1' || e.objType === '2' || e.objType === '3' || e.objType === '7' || e.objType === '8') {
            if ((e.bankClientStatus === '0' || e.bankClientStatus === '2') && e.bankClientChnFlag === '0') {
              e._disabled = false
            }
            if (e.objType === '2' && (e.merAuthStatus != '1' || e.status != '1')) {
              e._disabled = true
            } 
            if ((e.objType === '3' || e.objType === '8') && (e.merStatus !== '1')) {
              e._disabled = true
            }
          }
        } else if (batchOperationType === 'batchAcctFrozen') {
          if (e.objType === '1' || e.objType === '2' || e.objType === '3' || e.objType === '7' || e.objType === '8' || e.objType === '9') {
            if (e.operationType === '1' || e.operationType === '5' || e.operationType === null) {
              e._disabled = false
            }
          }
        } else if (batchOperationType === 'batchAcctUnFrozen') {
          if (e.objType === '1' || e.objType === '2' || e.objType === '3' || e.objType === '7' || e.objType === '8' || e.objType === '9') {
            if (e.operationType === '4' || e.operationType === '0') {
              e._disabled = false
            }
          }
        }
      })
    },
    batchOperationTypeChage() {
      let self = this
      self.tempIdListChuLi.length = 0
      self.thawBtnReport = true
      let dataList  = JSON.parse(JSON.stringify(this.tableData))
      this.$options.methods.eachDataSelectDisabled(self.batchOperationType, dataList)
      this.tableData = dataList
    },
    submitBatch(operationType) {
      let self = this
      if (this.auditRemark === '') {
        this.$Message.error('申请备注不能为空')
        return false
      }
      let parameters = {
        operationType: operationType,
        operationRecords: this.tempIdListChuLi,
        applyRemark: this.auditRemark
      }
      this.$axios.post('/operationRecord/batch', parameters).then(function (res) {
        self.auditRemark = ''
        if (operationType === 2) {
          self.$Message.success('冻结成功')
        } else if (operationType === 3) {
          self.$Message.success('解冻成功')
        }
        self.searchList()
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
    },
    backgroundColor () {
      return this.$contants.pageSet.backgroundColor
    }
  },
  activated() {
      this.searchList()
  }
}
</script>
