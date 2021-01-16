<style lang="less">
  @import '../../styles/common.less';
  .hidden {
    display: none;
  }
</style>
<template>
  <card>
    <Form :label-width="120" ref="form" :model="formData.parameters" label-position="right" :inline="true" :rules="ruleValidate">
      <Row>
        <FormItem  label="交易开始日期：" prop="beginTradeDate" >
          <DatePicker :options="beginDateOption" v-model="beginTradeDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>
        </FormItem>
        <FormItem label="交易结束日期：" prop="endTradeDate" >
          <DatePicker :options="endDateOption" v-model="endTradeDate" class="input-width-170" type="date" :editable="false" format="yyyy-MM-dd" placeholder="请选择交易结束日期" @on-change="endTradeDateChange"></DatePicker>
        </FormItem>
        <FormItem label="交易开始时间：" prop="beginTransTime" >
          <Time-picker type="time" placeholder="请选择时间" :editable="false" v-model="beginTransTime" style="width: 168px"></Time-picker>
        </FormItem>
        <FormItem label="交易结束时间：" prop="endTransTime" >
          <Time-picker type="time" placeholder="请选择时间" :editable="false" v-model="endTransTime"   style="width: 168px"></Time-picker>
        </FormItem>
        <FormItem label="虚拟账号：" prop="payerAccount">
          <Input v-model="payerAccount" class="input-width-170" :maxlength="accountSize" placeholder="请输入虚拟账号"/>
        </FormItem>
        <FormItem label="客户端流水号：" prop="clientTransId">
          <Input v-model="clientTransId" :maxlength="accountSize" class="input-width-170" placeholder="请输入客户端流水号"/>
        </FormItem>
        <FormItem label="服务端流水号：" prop="serverTransId">
          <Input v-model="serverTransId" :maxlength="accountSize" class="input-width-170" placeholder="请输入服务端流水号"/>
        </FormItem>
        <FormItem label="客户号：" prop="industryCode" >
          <Input v-model="industryCode" :maxlength="12" class="input-width-170" placeholder="请输入客户号"/>
        </FormItem>
        <FormItem label="产品类型：" prop="productCode" >
          <Select v-model="productCode" class="input-width-170" @on-change="chanProduct">
            <Option v-for="item in productNoAry" :value="item.code" :key="item.code">{{item.name}}</Option>
          </Select>
        </FormItem>
        <FormItem label="交易类型：" prop="tradeType">
          <Select v-model="tradeType" class="input-width-170" @on-change="chanTrade">
            <Option v-for="item in tradeTypeAry" :value="item.value" :key="item.value">{{item.name}}</Option>
          </Select>
        </FormItem>
        <FormItem label="差错类型：" prop="errorType">
          <Select v-model="errorType" class="input-width-170" @on-change="chanErrTypes">
            <Option value="b">渠道多流水</Option>
            <Option value="c">平台状态失败，渠道成功</Option>
            <Option value="d">平台状态未知，渠道成功</Option>
            <Option value="e">平台多流水</Option>
            <!--<Option value="f">平台状态未知，渠道失败</Option>-->
            <Option value="g">交易信息不匹配</Option>
          </Select>
        </FormItem>
        <FormItem label="处理状态：" prop="status">
          <Select v-model="status" class="input-width-170" @on-change="chanChuliStatus">
            <Option value="0">未处理</Option>
            <Option value="1">已处理</Option>
          </Select>
        </FormItem>
      </Row>
      <Row>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listErrorQuery">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <Button type="success" class="margin-left-10" v-access id="listErrorQueryRun" :disabled = "disAction" @click="handleGo('run')">批量人工处理</Button>
          <Button type="success" class="margin-left-10" v-access id="listErrorQueryApply" :disabled = "disActionShen" @click="handleGo('apply')">批量人工审核</Button>
          <Button type="success" class="margin-left-10" @click="downLoad" v-access id="listErrorQueryDown" :disabled="disBtn">导出</Button>
        </FormItem>
      </Row>
    </Form>
    <Row style=" height: 40px; background: #9ea7b4; color: #fff; line-height: 40px; text-indent: 1.2em; width: 100%">
      <Col :span="6">
        <span>总笔数：{{totalCount}}</span>
      </Col>
      <Col :span="6">
        <span>总金额：{{totalMoney}}</span>
      </Col>
    </Row>
    <Row>
      <Table :columns="tableColumns" :data="tableData" @on-selection-change="selectDataGo"  border highlight-row stripe></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
    <Modal
      v-model="displayModal"
      title="批量人工处理"
      @on-ok="sumbit"
      @on-cancel="cancel"
    >
        <i-select  style="width:200px" :label-in-value = "true" v-model="transStatus"  @on-change="transStatusChange">
          <i-option value="TRADE_SUCCESS">成功</i-option>
          <i-option value="TRADE_FAILURE">失败</i-option>
        </i-select>
      <i-input type="textarea" v-model="remark" :maxlength="500" :rows="4" placeholder="请输入处理说明"></i-input>
    </Modal>
    <Modal
      v-model="displayModalShen"
      title="批量人工审核"
      @on-ok="sumbitShen"
      @on-cancel="cancel"
    >
      <i-select  style="width:200px" :label-in-value = "true" v-model="auditStatus"  @on-change="auditStatusChange">
        <i-option value="1">审核通过</i-option>
        <i-option value="2">审核驳回</i-option>
      </i-select>
      <!--<i-input type="textarea" v-model="remark" :maxlength="500" :rows="4" placeholder="请输入处理说明"></i-input>-->
    </Modal>
  </card>
</template>
<script>
  // import storejs from 'storeJs'
export default {
  name: "errorQuery",
  data () {
    return {
      payerAccount: '',
      formDataauditStatus: {
        tempIdList: [],
        auditStatus: '',
        remark: '',
        transStatus: ''
      },
      disBtn: true,
      totalCount: 0 + '笔',
      totalMoney: 0 + '元',
      displayModal: false,
      displayModalShen: false,
      disAction: true,
      disActionShen: true,
      auditStatus: '',
      remark: '',
      beginTranDate: '',
      tradeTypeAry: this.$contants.dictionary.tradeType,
      endTranDate: '',
      isHidden: true,
      tempIdListChuLi: [], // id处理数组
      tempIdListShenHe: [], // id审核数组
      // tempIdList: [], // id数组
      productNoAry: [],
      productMap: {},
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      beginTradeDate: '',
      endTradeDate: '',
      beginTransDate: '',
      endTransDate: '',
      beginTransTime: '',
      endTransTime: '',
      beginTranTime: '',
      endTranTime: '',
      serverTransId: '',
      clientTransId: '',
      errorType: '',
      status: '',
      clientTradeId: '',
      transStatus: '',
      productCode: '',
      tradeType: '',
      industryCode: '',
      merNo: '',
      selectData: {
        tempIdList: []
      },
      formData: {
        parameters: {}
      },
      tableColumns: [],
      tableData: [],
      orgData: [],
      total: 0,
      pageNo: 1,
      pageSize: 10,
      beginDateOption: {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      },
      endDateOption: {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      },
      ruleValidate: {
        beginTradesDate: [
          {required: true, trigger: 'blur', message: '请输入交易开始时间'}
        ],
        endTradesDate: [
          {required: true, trigger: 'blur', message: '请输入交易结束时间'}
        ]
      }
    }
  },
  methods: {
    sumbit () {
      let self = this
      if (this.transStatus && this.remark) {
        this.selectData.transStatus = this.transStatus
        this.selectData.remark = this.remark
        this.$axios.put('/settleCheckInfo', this.selectData).then(res => {
          if (res.status === 200) {
            self.$Message.success('处理成功！')
            self.displayModal = false
          }
          self.searchList()
        })
      } else {
        self.$Message.error('请填写正确信息！')
      }
      this.remark = ''
    },
    sumbitShen () {
      let self = this
      this.$axios.put('/settleCheckInfoExamine', this.formDataauditStatus).then(res => {
        if (this.formDataauditStatus.auditStatus === '2') {
          if (res.status === 200) {
            self.$Message.success('驳回成功！')
            self.displayModalShen = false
          } else {
            self.$Message.success('驳回失败！')
            self.displayModalShen = false
          }
        } else {
          if (res.status === 200) {
            self.$Message.success('审核成功！')
            self.displayModalShen = false
          } else {
            self.$Message.success('审核失败！')
            self.displayModalShen = false
          }
        }
        self.auditStatus = ''
        self.searchList()
        self.disActionShen = true
      }).catch(function (err) {
        self.auditStatus = ''
        self.searchList()
        self.disActionShen = true
      })
      this.remark = ''
      this.auditStatus = ''
    },
    beginTradeDateChange (value) {
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() < dateGet.valueOf() - 86400000)
        }
      }
      this.beginTransDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
      // this.STOREJS.set('errorQueryBeginTradeDate', this.beginTransDate)
    },
    endTradeDateChange (value) {
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
        }
      }
      this.endTransDate = value.split(' ')[0].split('-')[0] + value.split(' ')[0].split('-')[1] + value.split(' ')[0].split('-')[2]
      // this.STOREJS.set('errorQueryEndTransDate', this.endTransDate)
    },
    init () {
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          type: 'selection',
          width: 60,
          align: 'center'
        },
        {
          width: 150 * avg,
          title: '客户端流水号',
          key: 'clientTransId'
        },
        {
          width: 150 * avg,
          title: '服务端流水号',
          key: 'serverTransId'
        },
        {
          width: 120 * avg,
          title: '交易发起时间',
          key: 'transDate',
          render (h, a, b) {
            if (a.row.transDate.length >= 10) {
              let newTime = a.row.transDate.split('')
              return h('span', newTime[0] + newTime[1] + newTime[2] + newTime[3] + '-' + newTime[4] + newTime[5] + '-' + newTime[6] + newTime[7] + ' ' + newTime[8] + newTime[9] + ':' + newTime[10] + newTime[11] + ':' + newTime[12] + newTime[13])
            }
          }
        },
        {
          width: 120 * avg,
          title: '清算日期',
          key: 'channelSettleDate',
          render (h, a, b) {
            if (a.row.channelSettleDate !== 'null' && a.row.channelSettleDate !== '') {
              let newTime = a.row.channelSettleDate.split('')
              return h('span', newTime[0] + newTime[1] + newTime[2] + newTime[3] + '-' + newTime[4] + newTime[5] + '-' + newTime[6] + newTime[7])
            }
          }
        },
        {
          width: 100 * avg,
          title: '客户名称',
          key: 'industryName'
        },
        {
          width: 120 * avg,
          title: '虚拟账号',
          key: 'payerAccount'
        },
        {
          width: 150 * avg,
          title: '收款人账号',
          key: 'showPayeeAccountNo'
        },
        {
          width: 150 * avg,
          title: '收款人户名',
          key: 'showPayeeAccountName'
        },
        {
          width: 100 * avg,
          title: '交易金额',
          key: 'transAmount',
          render (h, a, b) {
            return h('span', a.row.transAmount / 100 + '元')
          }
        },
        {
          width: 100 * avg,
          title: '交易状态',
          key: 'transStatus',
          render (h, a, b) {
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
              getReslt = '交易错误、不明确状态'
            }
            if (a.row.tradeType === 'SPLIT_PAYMENT') {
              getReslt = '平台分账'
            }
            if (a.row.tradeType === 'SUBACCOUNT_SPLIT_PAYMENT') {
              getReslt = '子账户分账'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 120 * avg,
          title: '差错类型',
          key: 'errorType',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.errorType === 'b') {
              getReslt = '渠道多流水'
            }
            if (a.row.errorType === 'c') {
              getReslt = '平台状态失败，渠道成功'
            }
            if (a.row.errorType === 'd') {
              getReslt = '平台状态未知，渠道成功'
            }
            if (a.row.errorType === 'e') {
              getReslt = '平台多流水'
            }
            if (a.row.errorType === 'f') {
              getReslt = '平台多流水'
              // getReslt = '平台状态未知，渠道失败'
            }
            if (a.row.errorType === 'g') {
              getReslt = '交易信息不匹配'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 120 * avg,
          title: '处理标志',
          key: 'status',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.status === '0') {
              getReslt = '未处理'
            }
            if (a.row.status === '1') {
              getReslt = '已经处理'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 120 * avg,
          title: '处理说明',
          key: 'remark'
        },
        {
          width: 120 * avg,
          title: '审核状态',
          key: 'auditStatus',
          render (h, a, b) {
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
          width: 100 * avg,
          title: '产品类型',
          key: 'productCode',
          render: function (h, a, b) {
            let getReslt = ''
            if (a.row.productCode === 'ACCOUNT') {
              getReslt = '代付'
            }
            return h('span', getReslt)
          }
        },
        {
          width: 100 * avg,
          title: '交易类型',
          key: 'tradeType',
          render (h, a, b) {
            return h('span', self.$contants.dictionary.totalTradeTypeMap[a.row.tradeType])
          }
        },
        {
          width: 120 * avg,
          title: '渠道编号',
          key: 'channelCode'
        },
        {
          width: 120 * avg,
          title: '渠道名称',
          key: 'channelName',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.tradeType === 'SPLIT_PAYMENT') {
              getReslt = ''
            } else {
              getReslt = a.row.channelName
            }
            return h('span', getReslt)
          }
        },
        {
          width: 120 * avg,
          title: '渠道返回时间',
          key: 'channelRespTime'
        },
        {
          width: 120 * avg,
          title: '渠道返回码',
          key: 'channelRespCode'
        },
        {
          width: 120 * avg,
          title: '渠道返回信息',
          key: 'channelRespMsg'
        }
      ]
      let queryOld = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      this.$axios.post('/payProduct/list', queryOld).then(function (res) {

        res.data.list.forEach(function (e, i) {
          if (e.status !== '0') {
            self.productNoAry.push(e)
          }
          (e.code === '1000') && (self.productMap['COLLECTION'] = e.name);
          (e.code === '1001') && (self.productMap['ACCOUNT'] = e.name)
        })
      })
      // this.beginTradeDate = this.STOREJS.get('errorQueryBeginTradeDate')
      // this.endTradeDate = this.STOREJS.get('errorQueryEndTransDate')
      this.searchList()
      // this.searchOrg()
    },
    searchOrg () {
      let self = this
      this.$axios.get(this.$contants.restful.organizations + '?pageNo=1&pageSize=1000')
        .then(function (response) {
          self.orgData = response.data.list
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    transStatusChange (val) {
      this.transStatus = val.value
    },
    auditStatusChange (val) {
      this.formDataauditStatus.auditStatus = val.value
    },
    downLoad () {
      let self = this
      let query = self.formData
      self.$axios({
        method: 'post',
        url: '/settleCheckInfo/download',
        data: query,
        responseType: 'blob'
      }).then(response => {
        self.downloadGo(response.data)
      }).catch((error) => {

      })
    },
    downloadGo (data) {
      if (!data) {
        return
      }
      let downName = '差错流水.xlsx' // 文件下载名称
      const blob = new Blob([data])
      if (window.navigator.msSaveOrOpenBlob) {
        // 兼容IE10
        navigator.msSaveBlob(blob, downName)
      } else {
        // chrome/firefox
        let url = window.URL.createObjectURL(new Blob([data]))
        let link = document.createElement('a')
        link.style.display = 'none'
        link.href = url
        link.setAttribute('download', '差错流水' + '.xlsx')
        document.body.appendChild(link)
        link.click()
      }
    },
    searchList () {
      this.disAction = true
      this.disActionShen = true
      let self = this
      if (this.beginTransDate) {
        if (this.beginTransTime) {
          this.beginTransTime = this.beginTransTime.split(':')
          let newTime = this.beginTransTime.join('')
          this.beginTransTime = newTime
        } else {
          this.beginTransTime = '000000'
        }
        this.formData.parameters.beginTransDatetime = this.beginTransDate + this.beginTransTime
      } else {
        delete this.formData.parameters.beginTransDatetime
      }
      if (this.endTransDate) {
        if (this.endTransTime) {
          this.endTransTime = this.endTransTime.split(':')
          let newTime = this.endTransTime.join('')
          this.endTransTime = newTime
        } else {
          this.endTransTime = '235959'
        }
        this.formData.parameters.endTransDatetime = this.endTransDate + this.endTransTime
      } else {
        delete this.formData.parameters.endTransDatetime
      }
      if (this.productCode) {
        this.formData.parameters.productCode = this.productCode
      } else {
        delete this.formData.parameters.productCode
      }
      if (this.errorType) {
        self.formData.parameters.errorType = self.errorType
      } else {
        delete this.formData.parameters.errorType
      }
      if (this.status) {
        self.formData.parameters.status = self.status
      } else {
        delete this.formData.parameters.status
      }
      if (this.clientTransId) {
        self.formData.parameters.clientTransId = self.clientTransId
      } else {
        delete self.formData.parameters.clientTransId
      }
      if (this.serverTransId) {
        self.formData.parameters.serverTransId = self.serverTransId
      } else {
        delete self.formData.parameters.serverTransId
      }
      if (this.transStatus) {
        self.formData.parameters.transStatus = self.transStatus
      } else {
        delete self.formData.parameters.transStatus
      }
      if (this.productCode) {
        self.formData.parameters.productCode = this.productCode
      } else {
        delete self.formData.parameters.productCode
      }
      if (this.tradeType) {
        self.formData.parameters.tradeType = self.tradeType
      } else {
        delete self.formData.parameters.tradeType
      }
      if (this.industryCode) {
        self.formData.parameters.industryCode = self.industryCode
      } else {
        delete self.formData.parameters.industryCode
      }
      if (this.payerAccount) {
        self.formData.parameters.payerAccount = self.payerAccount
      } else {
        delete self.formData.parameters.payerAccount
      }
      this.formData.pageNo = self.pageNo
      this.formData.pageSize = self.pageSize
      let query = self.formData
      this.$axios.post('/settleCheckInfo/list', query)
        .then(function (response) {
          if (response.data.total.totalCount >= 1) {
            self.disBtn = false
          } else {
            self.disBtn = true
          }
          response.data.page.list.forEach(function (e, i) {
            e.transDate = e.transDate + e.transTime
            if (e.auditStatus === '1') {
              e._disabled = true
            }
          })

          self.totalCount = response.data.total.totalCount + '笔'
          self.totalMoney = response.data.total.inTotalAmount / 100 + '元'
          self.tableData = response.data.page.list
          self.total = response.data.page.total
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    chanRefundStatus (val) {
      this.refundStatus = val
    },
    chanChuliStatus (val) {
      this.status = val
    },
    chanErrTypes (val) {
      this.errorType = val
    },
    chanTrade (val) {
      this.tradeType = val
    },
    // chanOrg (val) {
    //   this.orgCode = val
    // },
    chanProduct (val) {
      this.productCode = val
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    selectDataGo (currentRow) {
      let self = this
      this.tempIdListChuLi = []
      this.tempIdListShenHe = []
      this.transStatus = ''
      this.selectData.id = currentRow.id
      // this.formDataauditStatus.id = currentRow.id
      // this.formDataauditStatus.remark = currentRow.remark
      // this.formDataauditStatus.transStatus = currentRow.transStatus
      currentRow.forEach(function (e, i) {
        if (e.errorType !== 'b' || e.errorType !== 'g') {
          if (e.auditStatus === null || e.auditStatus === '2') {
            self.tempIdListChuLi.push(e.id)
            // self.disAction = false
            // self.disActionShen = true
          }
          if (e.auditStatus === '0') {
            self.tempIdListShenHe.push(e.id)
            // self.disAction = true
            // self.disActionShen = false
          }
          if (e.auditStatus === '1') {
            self.tempIdListShenHe.push(e.id)
            self.disAction = true
            self.disActionShen = true
          }
        } else {
          self.disAction = true
          self.disActionShen = true
        }
      })
      self.formDataauditStatus.tempIdList = self.tempIdListShenHe
      self.selectData.tempIdList = self.tempIdListChuLi
      if (self.tempIdListShenHe.length > 0 && self.tempIdListChuLi.length === 0) {
        self.disAction = true
        self.disActionShen = false
      }
      if (self.tempIdListShenHe.length > 0 && self.tempIdListChuLi.length > 0) {
        self.disAction = true
        self.disActionShen = true
      }
      if (self.tempIdListShenHe.length === 0 && self.tempIdListChuLi.length > 0) {
        self.disAction = false
        self.disActionShen = true
      }
      if (self.tempIdListShenHe.length === 0 && self.tempIdListChuLi.length === 0) {
        self.disAction = true
        self.disActionShen = true
      }
    },
    handleGo (val) {
      this.auditStatus = ''
      this.transStatus = ''
      if (val === 'run') {
        this.displayModal = true
      }
      if (val === 'apply') {
        this.displayModalShen = true
      }
    },

    cancel () {
      this.remark = ''
    },
    searchBtn () {
      this.pageNo = 1
      this.searchList()
    },
    resetBtn () {
      // this.STOREJS.remove('errorQueryBeginTradeDate')
      // this.STOREJS.remove('errorQueryEndTransDate')
      this.beginTranDate = ''
      this.endTranDate = ''
      this.beginTransDate = ''
      this.beginTransTime = ''
      this.endTransDate = ''
      this.beginTradeDate = ''
      this.endTradeDate = ''
      this.endTransTime = ''
      this.formData.parameters = {}
      this.clientTradeId = ''
      this.clientTransId = ''
      this.serverTransId = ''
      this.transStatus = ''
      this.status = ''
      this.errorType = ''
      this.payerAccount = ''
      this.productCode = ''
      this.tradeType = ''
      this.industryCode = ''
      this.merNo = ''
      this.pageNo = 1
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
