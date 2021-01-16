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
          <FormItem  label="发生开始时间：" prop="transBeginDate" >
            <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem  label="发生结束时间：" prop="transEndDate" >
            <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="bankAccountTransDetail" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" class="margin-left-10" @click="accountEntryFun" v-access id="accountEntryWrite" :disabled="accountEntry">手工入账</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" @on-current-change="selectDataGo" highlight-row stripe></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
    </Row>
    <!--<Modal-->
      <!--v-model="examineStatu"-->
      <!--title="手工入账"-->
      <!--@on-ok = "sumbitExamine"-->
      <!--width="350"-->
    <!--&gt;-->
      <!--<i-select v-model="selectData.account" style="width: 300px" :label-in-value = "true">-->
        <!--<i-option v-for="item in bankNameAry"  :key="item.key" :value="item.value">{{ item.value }}</i-option>-->
      <!--</i-select>-->
      <!--<div slot="footer">-->
        <!--<Button type="text" size="large" @click="cancel">取消</Button>-->
        <!--<Button type="primary" size="large" @click="sumbitAccount">确定</Button>-->
      <!--</div>-->
    <!--</Modal>-->
    <!-- 弹出手续费选择框-->
    <Modal v-model="funcModal" title="选择入账账户" width="1000" :mask-closable="false">
      <mer-list v-if="funcModalShow" v-on:pagByJson="pagByJson" @checkFunc="checkFunc"  @hideFunc="hideFunc" :selectedItem="this.selectedItem" :sureBtnDisabled=true></mer-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>

<script>import merList from './components/merList'
export default {
  name: "bankAccountTransDetail",
  components: {
    merList: merList
  },
  data () {
    return {
      funcModal: false,
      funcModalShow: false,
      accountAry: [],
      examineStatu: false,
      selectData: {
        account: '',
        accountName: '',
        transId: ''
      },
      // searchJson: {
      //   account: '',
      //   objType: '',
      //   objCode: '',
      //   objName: ''
      // },
      selectedItem: [],
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
          width: 150 * avg
        },
        {
          title: '操作序号',
          key: 'detailSerialNumber',
          width: 150 * avg
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
        }
      ]
      // 查询信息
      let self = this
      this.$axios.get('/dictionaries').then(function (res) {
        self.bankNameAry = res.data.bank
      })
      this.searchList()
    },
    accountEntryFun () {
      // this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },

    selectDataGo (currentRow) {
      this.selectData.transId = currentRow.id
      if (currentRow.auditStatus === '2' || currentRow.auditStatus === null) {
        this.accountEntry = false
      } else {
        this.accountEntry = true
      }
    },

    pagByJson: function (pagJson) {
      let self = this
      this.funcModal = pagJson.disPlay
      this.selectData.account = pagJson.account.toString()
      this.selectData.accountName = pagJson.accountName.toString()
      this.$axios.post('/applicationForManualEntry', this.selectData).then(function (res) {

        self.$Message.success('手工入账成功！')
        self.accountEntry = true
        self.searchList()
        // window.location.reload(true)
      }).catch(function (err) {
        self.accountEntry = true
        // window.location.reload(true)
      })
      // window.location.reload(true)
    },
    // goBack () {
    //   this.$util.goBack(this)
    // },
    checkFunc (data) {
      this.funcModal = !this.funcModal
      this.funcModalShow = false
    },
    hideFunc: function () {
      // this.funcModal = false
      this.funcModal = !this.funcModal
      this.funcModalShow = false
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
      let uri = encodeURI('/bankAccountTransDetail/pageList')
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
      // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          response.data.list.forEach(function (e, i) {
            if (e.txnDate && e.txnTime) {
              e.natureDate = e.txnDate.slice(0, 4) + '-' + e.txnDate.slice(4, 6) + '-' + e.txnDate.slice(6) + ' ' + e.txnTime.substring(0, 8)
            }
          })
          this.tableData = response.data.list
          this.total = response.data.total
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
    objTypeChange (val) {
      this.objType = val
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
      this.modalAccount = false
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
      // this.transBeginDate
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
