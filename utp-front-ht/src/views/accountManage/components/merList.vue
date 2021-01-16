<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="账号：">
            <Input v-model="formData.account" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="账户类型：">
            <Select v-model="formData.objType" style="width: 180px"  @on-change="objTypeChange">
              <Option value="1">平台代付账户</Option>
              <Option value="2">企业账户</Option>
              <Option value="3">个人账户</Option>
              <Option value="5">手续费支出账户</Option>
              <Option value="8">个体工商户账户</Option>
              <Option value="9">待结算账户</Option>
              <Option value="10">小额打款支出账户</Option>
            </Select>
          </FormItem>
          <FormItem label="证件号：">
            <Input v-model="formData.busLicCode" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="户名：">
            <Input v-model="formData.objName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listAccount" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border ref="selection" :columns="tableColumns" :data="tableData" @on-current-change="handleChange" highlight-row></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
    </Row>
    <Row>
      <Col>
        <div class="ivu-modal-footer">
          <Button id="sureBtn" type="primary" @click="sureSubmit" style="margin-right: 10px;" :disabled=sureBtnDisabled>确定</Button>
          <Button type="default" @click="backCancel">取消</Button>
        </div>
      </Col>
    </Row>
  </card>
</template>

<script>
export default {
  sureBtnDisabled: true,
  name: 'merList',
  props: [
    'selectedItem', 'sureBtnDisabled'
  ],
  data () {
    return {
      busLicCode: '',
      pagJson: {},
      cashGetApplyModel: false,
      cashAccountAry: [],
      fundAccount: '',
      formData: {},
      countData: {
        account: '',
        amount: '',
        reciveId: '',
        accountNo: ''
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
      selectedMerchId: []
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
          title: '账号',
          key: 'account',
          width: 200 * avg
        },
        {
          title: '账号类型',
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
          title: '账户名称',
          key: 'objName',
          width: 150 * avg
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
        }
      ]
      // 查询信息
      let self = this
      this.$axios.get('/dictionaries').then(function (res) {
        self.bankNameAry = res.data.bank
      })
      this.searchList()
    },
    sureSubmit () {
      this.$emit('pagByJson', this.pagJson)
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
      let uri = encodeURI('/account/pageListExclusive')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.formData.account) {
        this.query.parameters.account = this.formData.account
      } else {
        delete this.query.parameters.account
      }
      if (this.formData.objType) {
        this.query.parameters.objType = this.formData.objType
      } else {
        delete this.query.parameters.objType
      }
      if (this.formData.busLicCode) {
        this.query.parameters.busLicCode = this.formData.busLicCode
      } else {
        delete this.query.parameters.busLicCode
      }
      if (this.formData.objName) {
        this.query.parameters.objName = this.formData.objName
      } else {
        delete this.query.parameters.objName
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
    backCancel () {
      this.$emit('hideFunc')
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
    handleChange (currentRow, oldCurrentRow) {
      // account: '',
      //   accountName: '',
      this.sureBtnDisabled = false
      this.pagJson = {
        account: currentRow.account,
        accountName: currentRow.objName,
        disPlay: false
      }

      // this.funcModalShow = false
      // this.funcModal = false
    },
    cashApply (row) {
      let query = {
        pageNo: 1,
        pageSize: 100,
        parameters: {
          account: row.account
        }
      }
      this.countData.account = row.account
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
    sumbitAccount () {
      let that = this
      this.$refs['countData'].validate((valid) => {
        if (valid) {
          this.$axios.post('/withdrawalsRecord', this.countData).then(function (res) {
            that.countData.account = ''
            that.countData.amount = ''
            that.countData.reciveId = ''
            that.searchList()
            that.$Message.success('提现申请成功')
          })
        } else {
          that.countData.account = ''
          that.countData.amount = ''
          that.countData.reciveId = ''
          that.$Message.error('请正确填写信息')
        }
      })
      this.cashGetApplyModel = false
    },
    cancel () {
      this.cashGetApplyModel = false
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
      this.formData = {}
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
    // account () {
    //   return this.searchJson.account
    // },
    // objType () {
    //   return this.searchJson.objType
    // },
    // objCode () {
    //   return this.searchJson.objCode
    // },
    // objName () {
    //   return this.searchJson.objName
    // }
  }
}
</script>
