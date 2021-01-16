<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="资金账号：" prop="custAccountNo">
            <Input v-model="custAccountNo" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="户名：" prop="custAccountName">
            <Input v-model="custAccountName" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="来款账号：" prop="otherCustAccountNo">
            <Input v-model="otherCustAccountNo" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="来款账户名称：" prop="otherCustName">
            <Input v-model="otherCustName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="入账虚拟账号：" prop="account">
            <Input v-model="account" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="入账户名：" prop="accountName">
            <Input v-model="accountName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="审核状态：" prop="auditStatus">
            <Select v-model="auditStatus" class="input-width-170" @on-change="auditStatusChange">
              <Option value="0">待审核</Option>
              <Option value="1">审核通过</Option>
              <Option value="2">审核驳回</Option>
            </Select>
          </FormItem>
          <FormItem label="银行流水号：" prop="sysReferenceNo">
            <Input v-model="sysReferenceNo" :maxlength="accountSize"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="accountEntryApplyList" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <!--<Button type="success" class="margin-left-10" @click="accountEntryFun" v-access id="accountEntryWrite" :disabled="accountEntry">手工入账</Button>-->
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
      @on-ok = "sumbitExamine"
      width="350"
    >
      <Select v-model="countData.auditStatus" style="width: 180px"  @on-change="objTypeChange">
        <!--<Option value="0">待审核</Option>-->
        <Option value="1">审核通过</Option>
        <Option value="2">审核驳回</Option>
      </Select>
      <i-input type="textarea"  v-model="countData.remark" placeholder="请输入备注"></i-input>
      <div slot="footer">
        <Button type="text" size="large" @click="cancel">取消</Button>
        <Button type="primary" size="large" @click="sumbitAccount">确定</Button>
      </div>
    </Modal>
  </card>
</template>

<script>
export default {
  name: "accountEntryApply",
  data () {
    return {
      sysReferenceNo: '',
      status: '',
      examineStatu: false,
      countData: {},
      account: '',
      accountName: '',
      auditStatus: '',
      accountAry: [],
      selectData: {
        account: '',
        accountName: '',
        transId: ''
      },
      accountEntry: true,
      custAccountNo: '',
      custAccountName: '',
      otherCustAccountNo: '',
      otherCustName: '',
      transBeginDate: '',
      transEndDate: '',
      formData: {},
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
          width: 70
        },
        {
          title: '户名',
          key: 'custAccountName',
          width: 180 * avg
        },
        {
          title: '资金账号',
          key: 'custAccountNo',
          width: 180 * avg
        },
        {
          title: '发生时间',
          key: 'natureDate',
          width: 150 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '交易金额',
          key: 'txnAmount',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.txnAmount / 100 + '元')
          }
        },
        {
          title: '账户余额',
          key: 'accountBalance',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.txnAmount / 100 + '元')
          }
        },
        {
          title: '来款账户名称',
          key: 'otherCustName',
          width: 185 * avg
        },
        {
          title: '来款账号',
          key: 'otherCustAccountNo',
          width: 200 * avg
        },
        {
          title: '银行流水号',
          key: 'sysReferenceNo',
          width: 200 * avg
        },
        {
          title: '入账虚拟账号',
          key: 'account',
          width: 200 * avg
        },
        {
          title: '入账户名',
          key: 'accountName',
          width: 200 * avg
        },
        {
          title: '申请时间',
          key: 'gmtCreate',
          width: 200 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '审核状态',
          key: 'auditStatus',
          width: 200 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.auditStatus === '0') {
              reslut = '待审核'
            }
            if (a.row.auditStatus === '1') {
              reslut = '审核通过'
            }
            if (a.row.auditStatus === '2') {
              reslut = '审核驳回'
            }
            return h('span', reslut)
          }
        },
        {
          title: '审核时间',
          key: 'gmtModified',
          width: 200 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '审核人员',
          key: 'userModified',
          width: 200 * avg
        },
        {
          title: '备注',
          key: 'remark',
          width: 150 * avg
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
                    id: 'accountEntryApplyBtn',
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
                      this.accountEntryApply(params.row)
                    }
                  }
                }, '审核')
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
      this.searchList()
    },
    sumbitAccount () {
      let that = this
      if (this.countData.auditStatus && this.countData.id && this.countData.remark) {
        this.$axios.put('/applicationForManualEntry', this.countData).then(function (res) {
          that.searchList()
          that.$Message.success('手工入账审核成功')
          that.examineStatu = false
        }).catch(function (err) {
          that.examineStatu = false
        })
      } else {
        that.$Message.error('请填写审核状态和备注')
      }
    },
    accountEntryFun () {
      // this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    accountEntryApply (row) {
      this.countData = {}
      this.examineStatu = true
      this.countData.id = row.id
    },
    // selectDataGo (currentRow) {
    //   this.selectData.transId = currentRow.id
    //   if (currentRow.auditStatus === '2' || currentRow.auditStatus === null) {
    //     this.accountEntry = false
    //   } else {
    //     this.accountEntry = true
    //   }
    // },
    pagByJson: function (pagJson) {
      let self = this
      this.funcModal = pagJson.disPlay
      this.selectData.account = pagJson.account.toString()
      this.selectData.accountName = pagJson.accountName.toString()
      this.$axios.post('/applicationForManualEntry', this.selectData).then(function (res) {
      // this.$axios.post('/applicationForManualEntry/', this.selectData).then(function (res) {
        self.$Message.success('手工入账成功！')
      })
      // this.formDataNew.indFeeTemplateId = pagJson.indFeeTemplateId.toString()
      // this.choseText = pagJson.name
    },
    checkFunc (data) {
      this.funcModal = !this.funcModal
      this.funcModalShow = false
    },
    hideFunc: function () {
      this.funcModal = false
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
      let uri = encodeURI('/applicationForManualEntry/list')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.custAccountNo) {
        this.query.parameters.custAccountNo = this.custAccountNo
      } else {
        delete this.query.parameters.custAccountNo
      }
      if (this.custAccountName) {
        this.query.parameters.custAccountName = this.custAccountName
      } else {
        delete this.query.parameters.custAccountName
      }
      if (this.otherCustAccountNo) {
        this.query.parameters.otherCustAccountNo = this.otherCustAccountNo
      } else {
        delete this.query.parameters.otherCustAccountNo
      }
      if (this.otherCustName) {
        this.query.parameters.otherCustName = this.otherCustName
      } else {
        delete this.query.parameters.otherCustName
      }
      if (this.auditStatus) {
        this.query.parameters.auditStatus = this.auditStatus
      } else {
        delete this.query.parameters.transBeginDate
      }
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
      if (this.sysReferenceNo) {
        this.query.parameters.sysReferenceNo = this.sysReferenceNo
      } else {
        delete this.query.parameters.sysReferenceNo
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
    auditStatusChange (val) {
      this.auditStatus = val
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
    objTypeChange (val) {
      this.countData.auditStatus = val
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
      this.custAccountNo = ''
      this.custAccountName = ''
      this.otherCustAccountNo = ''
      this.otherCustName = ''
      this.transBeginDate = ''
      this.transEndDate = ''
      this.sysReferenceNo = ''
      this.auditStatus = ''
      this.account = ''
      this.accountName = ''
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
    changePassword (row) {
      this.$router.push({
        name: 'changeUserPassword',
        params: {
          username: row.username
        }
      })
    },
    resetPassword (row) {
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
