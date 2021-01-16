<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="虚拟账号：" prop="account">
            <Input v-model="account" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="客户号：" prop="industryCode">
            <Input v-model="industryCode" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="客户名称：" prop="industryName">
            <Input v-model="industryName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="姓名：" prop="realName">
            <Input v-model="realName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="审核状态：" prop="authStatus">
            <i-select :label-in-value = "true" v-model="authStatus" style="width: 162px"  @on-change="jobtaskStateChange">
              <i-option value="0">待审核</i-option>
              <i-option value="1">已认证</i-option>
              <i-option value="2">审核驳回</i-option>
              <i-option value="9">待认证</i-option>
            </i-select>
            <!--<DatePicker v-model="jobDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>-->
          </FormItem>
          <FormItem label="审核开始时间：" prop="">
            <DatePicker type="datetime" :options="beginDateOption" :editable="false"  v-model="transBeginDate" placeholder="请选择审核开始时间" format="yyyy-MM-dd HH:mm:ss" style="width: 200px" @on-change="lastStarttimeChange"></DatePicker>
          </FormItem>
          <FormItem label="审核结束时间：" prop="">
            <DatePicker type="datetime" :options="endDateOption" :editable="false" v-model="transEndDate" placeholder="请选择审核结束时间" format="yyyy-MM-dd HH:mm:ss" style="width: 200px" @on-change="lastEndtimeChange"></DatePicker>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="merchantInfoManager" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="modifyMerchantInfo" @click="modifyMerchantInfoAction()" :disabled="modifyMerchantInfo" style="margin-right: 10px;">更新资料</Button>
            <!--<Button type="info" class="margin-left-10" v-access @click="runAgain" id="runAgain" :disabled = "disAction">重跑</Button>-->
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
      title="审核状态"
      width="350"
    >
      <Form :model="countData" ref="countData" :rules="ruleValidate">
        <FormItem label="审核状态：" prop="authStatus">
          <Select v-model="countData.authStatus" style="width: 210px"  @on-change="objTypeChange">
            <i-option value="1">审核通过</i-option>
            <i-option value="2">审核驳回</i-option>
          </Select>
        </FormItem>
        <FormItem label="审核备注：" prop="authRemark">
          <i-input v-model="countData.authRemark" type="textarea" :autosize="{minRows: 2,maxRows: 5}" style="width: 210px" placeholder="请输入备注"></i-input>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="cancel">取消</Button>
        <Button type="primary" size="large" @click="sumbitAccount('countData')">确定</Button>
      </div>
    </Modal>
  </card>
</template>

<script>
export default {
  name: "personalInfoAuth",
  data () {
    return {
      modifyMerchantInfo: true,
      industryCode: '',
      industryName: '',
      examineStatu: false,
      jobDateAry: [],
      account: '',
      accountName: '',
      realName: '',
      authStatus: '',
      disAction: true,
      runID: '',
      transBeginDate: '',
      transEndDate: '',
      runStead: '',
      jobName: '',
      lastRunEndtime: '',
      lastRunStarttime: '',
      jobDate: '',
      formData: {},
      startTime: '',
      endTime: '',
      countData: {
        authStatus: '',
        id: '',
        authRemark: '',
        sign: ''
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

      },
      endDateOption: {

      },
      ruleValidate: {
        authStatus: [
          {required: true, trigger: 'blur', message: '请选择审核状态'}
        ],
        authRemark: [
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
          title: '序号',
          type: 'index',
          width: 80
        },
        {
          title: '虚拟账号',
          key: 'account',
          width: 150 * avg
        },
        {
          title: '客户号',
          key: 'industryCode',
          width: 125 * avg
        },
        {
          title: '客户名称',
          key: 'industryName',
          width: 125 * avg
        },
        {
          title: '姓名',
          key: 'realName',
          width: 125 * avg
        },
        {
          title: '营业执照号',
          key: 'busLicCode',
          width: 125 * avg
        },
        {
          title: '审核状态',
          key: 'authStatus',
          width: 100 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.authStatus === '0') {
              reslut = '待审核'
            }
            if (a.row.authStatus === '1') {
              reslut = '已认证'
            }
            if (a.row.authStatus === '2') {
              reslut = '审核驳回'
            }
            if (a.row.authStatus === '9') {
              reslut = '待认证'
            }
            return h('span', reslut)
          }
        },
        {
          title: '审核时间',
          key: 'gmtModified',
          width: 180 * avg,
          render: function (h, a, b) {
            if (this.row.gmtModified) {
              return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
            }
          }
        },
        {
          title: '审核人员',
          key: 'userModified',
          width: 120 * avg
        },
        {
          title: '备注',
          key: 'authRemark',
          width: 120 * avg
        },
        {
          title: '操作',
          key: 'action',
          align: 'left',
          width: 150 * avg,
          render: (h, params) => {
            if (params.row.authStatus === '0') {
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'merchantInfoManagerDetail',
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
                h('svg-icon', {
                  attrs: {
                    id: 'merchantInfoApply',
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
                      this.merchantInfoApplyFun(params.row)
                    }
                  }
                }, '审核'),
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
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'personalInfoAuthDetail',
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
            }

          }
        }
      ]
      // 查询信息
      let self = this
      this.$axios.get('/dictionaries').then(function (res) {
        self.bankNameAry = res.data.bank
      })
      // this.getjobDate()
      this.searchList()
    },
    objTypeChange (val) {
      this.countData.authStatus = val
    },
    jobtaskStateChange (val) {
      this.jobtaskState = val.value
    },
    merchantInfoApplyFun (row) {
      this.countData = {}
      this.examineStatu = true
      this.countData.id = row.id
    },
    cancel () {
      this.examineStatu = false
      this.countData = {}
    },
    sumbitAccount (name) {
      let that = this
      this.examineStatu = false
      if (!this.countData.authStatus || !this.countData.authRemark){
        that.$Message.error('请填写正确信息！')
      }
      this.$refs[name].validate((valid) => {
        if (valid) {
          this.$axios.put('/merchantInfoAuth', this.countData).then(function (res) {
            that.countData = {}
            that.searchList()
            that.$Message.success('企业证件审核成功')
            that.examineStatu = false
          }).catch(function (err) {
            that.searchList()
            that.examineStatu = false
            that.countData = {}
          })
        }
      })
      // let that = this
      // if (this.countData.authStatus && this.countData.id) {
      //   this.$axios.put('/merchantInfoAuth', this.countData).then(function (res) {
      //     that.countData = {}
      //     that.searchList()
      //     that.$Message.success('企业证件审核成功')
      //     that.examineStatu = false
      //   }).catch(function (err) {
      //     that.examineStatu = false
      //     that.countData = {}
      //   })
      // } else {
      //   that.$Message.error('请选择审核状态')
      //   that.countData = {}
      // }
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
      let uri = encodeURI('/personalInfoAuth/list')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.account) {
        this.query.parameters.account = this.account
      } else {
        delete this.query.parameters.account
      }
      if (this.accountName) {
        this.query.parameters.accountName = this.accountName
      } else {
        delete this.query.parameters.accountName
      }
      if (this.transEndDate) {
        this.query.parameters.transEndDate = this.endTime
      } else {
        delete this.query.parameters.transEndDate
      }
      if (this.transBeginDate) {
        this.query.parameters.transBeginDate = this.startTime
      } else {
        delete this.query.parameters.transBeginDate
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
      if (this.authStatus) {
        this.query.parameters.authStatus = this.authStatus
      } else {
        delete this.query.parameters.authStatus
      }
      if (this.realName) {
        this.query.parameters.realName = this.realName
      } else {
        delete this.query.parameters.realName
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
    jobNameChange (val) {
      this.jobName = val.label
      this.jobId = val.value
    },
    // getjobDate () {
    //   let self = this
    //   this.$axios.get('/jobTask/jobDict').then(function (res) {
    //     self.jobDateAry = res.data
    //   })
    // },
    beginTradeDateChange (value) {
      value = value.replace('-', '').replace('-', '')
      this.jobDate = value
    },
    selectDataNew (currentRow) {
      if (currentRow.jobtaskState === 'FAILED' || currentRow.jobtaskState === 'PREP') {
        this.runID = currentRow.id
        this.disAction = false
      } else {
        this.disAction = true
      }
      if (currentRow.status === '4' && currentRow.authStatus === '2') {
        this.modifyMerchantInfo = false
        this.id = currentRow.id
      } else {
        this.modifyMerchantInfo = true
      }
    },
    runAgain () {
      this.$Modal.confirm({
        title: '是否重跑任务',
        content: '<p>是否重跑任务</p>',
        onOk: () => {
          let self = this
          let runQuery = {
            id: this.runID,
            jobtaskState: 'WAITING'
          }
          self.$axios.put('/jobTask', runQuery).then(res => {
            if (res.status === 200) {
              self.$Message.success('重跑成功！')
              self.searchList()
            }
          })
        },
        onCancel: () => {
          this.$Message.info('取消重跑')
        }
      })
    },
    lastStarttimeChange (val) {
      this.startTime = ''
      val = val.replace('-', '').replace('-', '').replace(' ', '').replace(':', '').replace(':', '')
      this.startTime = val
      if (this.endTime) {
        if (val > this.endTime) {
          this.transBeginDate = ''
          this.$Message.error('最后运行开始时间不能大于最后运行结束时间')
        } else {
          this.transBeginDate = val
        }
      }
    },
    lastEndtimeChange (val) {
      this.endTime = ''
      val = val.replace('-', '').replace('-', '').replace(' ', '').replace(':', '').replace(':', '')
      this.endTime = val
      if (this.startTime) {
        if (val < this.startTime) {
          this.transEndDate = ''
          this.$Message.error('最后运行结束时间不能小于最后运行开始时间')
        } else {
          this.transEndDate = val
        }
      }
    },
    changePage (index) {
      // 分页点击事件
      this.currentPage = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.currentPage = 1
      this.disAction = true
      this.searchList()
    },
    modifyMerchantInfoAction () {
      this.$router.push({
        name: 'modifyMerchantInfo',
        params: {
          id: this.id,
          modify: false
        }
      })
    },
    clearBtn () {
      this.account = ''
      this.accountName = ''
      this.authStatus = ''
      this.transBeginDate = ''
      this.transEndDate = ''
      this.industryName = ''
      this.industryCode = ''
      this.realName = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addJobTask'
      })
    },
    doDelete (row) {
      if (row.jobtaskState === 'FAILED') {
        this.$axios.delete('/jobTask' + '/' + row.id)
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
      } else {
        this.$Message.error('失败状态的任务才能删除！')
      }
    },
    update (row) {
      this.$router.push({
        name: 'editJobTask',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'personalInfoAuthDetail',
        params: {
          id: row.id,
          objType: 3
        }
      })
    },
    accountBankCardList (row) {
      this.$router.push({
        name: 'accountBankCardList',
        params: {
          id: row.id,
          account: row.account,
          bindStatus: '0'
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
  activated () {
    this.searchList()
  }
}
</script>
