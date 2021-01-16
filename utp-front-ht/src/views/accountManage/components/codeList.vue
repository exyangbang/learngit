<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="key值：">
            <Input v-model="formData.code" :maxlength="accountSize"/>
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
  name: 'codeList',
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
          title: 'key值',
          key: 'code',
          width: 200 * avg
        },
        {
          title: '信息名称',
          key: 'value',
          width: 120 * avg
        },
        {
          title: '账户创建时间',
          key: 'gmtCreate',
          width: 150 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        }
      ]
      // 查询信息
      let self = this
      // this.$axios.get('/codeDictionary').then(function (res) {
      //   self.bankNameAry = res.data.bank
      // })
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
      let uri = encodeURI('/codeDictionary/list')
      debugger
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.formData.code) {
        this.query.parameters.code = this.formData.code
      } else {
        delete this.query.parameters.code
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
        code: currentRow.code,
        value: currentRow.value,
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
