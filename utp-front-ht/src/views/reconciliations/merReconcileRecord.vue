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
        <FormItem  label="清算日期：" prop="reconcileDate" >
          <Date-picker type="date" v-model="reconcileDate" :editable="false" placeholder="请选择清算日期" format="yyyyMMdd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem label="商户号：" prop="merNo" >
          <Input v-model="merNo" style="width: 300px" placeholder="请输入商户名称" :maxlength="200" />
        </FormItem>
        <FormItem label="对账状态：" prop="reconcileStatus">
          <Select v-model="reconcileStatus" class="input-width-170" @on-change="chanReconcileStatus">
            <Option value="0">未对账</Option>
            <Option value="1">已对账</Option>
          </Select>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listTradeFlowCash">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <Button type="success" class="margin-left-10" @click="reconRecord" :disabled = "disAction">人工对账</Button>
        </FormItem>
      </Row>
    </Form>
    <Row>
      <Table :columns="tableColumns" :data="tableData" @on-current-change="selectDataGo" highlight-row border stripe ></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>export default {
  name: "merReconcileRecord",
  data () {
    return {
      reconcileStatus: '',
      disDownLoad: true,
      isHidden: true,
      disAction: true,
      productNoAry: [],
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      reconcileDate: '',
      orgCode: '',
      merNo: '',
      formData: {},
      selectData: {},
      tableColumns: [],
      tableData: [],
      orgData: [],
      totalCount: 0,
      total: 0,
      totalMoney: 0,
      totalFee: 0,
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
        beginTradeDate: [
          {required: true, trigger: 'blur', message: '请输入交易开始时间'}
        ],
        endTradeDate: [
          {required: true, trigger: 'blur', message: '请输入交易结束时间'}
        ]
      }
    }
  },
  methods: {
    beginTradeDateChange (value) {
      this.reconcileDate = value
    },
    init () {
      // let self = this
      // let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '清算日期',
          key: 'reconcileDate'
        },
        {
          title: '商户号',
          key: 'merNo'
        },
        {
          title: '机构名称',
          key: 'orgName'
        },
        {
          title: '对账状态',
          key: 'reconcileStatus',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.reconcileStatus === '0') {
              getReslt = '未对账'
            }
            if (a.row.reconcileStatus === '1') {
              getReslt = '已对账'
            }
            return h('span', getReslt)
          }
        }
      ]
      // this.searchOrg()
    },
    selectDataGo (currentRow) {
      this.selectData.reconcileDate = currentRow.reconcileDate
      this.selectData.merNo = currentRow.merNo
      if (currentRow.reconcileStatus === '0') {
        this.disAction = false
      } else {
        this.disAction = true
      }
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
    chanReconcileStatus (val) {
      this.reconcileStatus = val
    },
    searchList () {
      let self = this
      this.formData = {}
      if (this.merNo) {
        this.formData.merNo = this.merNo
      } else {
        delete this.formData.merNo
      }
      if (this.reconcileDate) {
        this.formData.reconcileDate = this.reconcileDate
      } else {
        delete this.formData.reconcileDate
      }
      if (this.reconcileStatus) {
        this.formData.reconcileStatus = this.reconcileStatus
      } else {
        delete this.formData.reconcileStatus
      }
      let query = {
        pageNo: self.pageNo,
        pageSize: self.pageSize,
        parameters: this.formData
      }
      this.$axios.post('/merReconcileRecord/list', query)
        .then(function (response) {
          self.tableData = ''
          self.tableData = response.data.list
          if (response.data.total !== null) {
            self.totalMoney = response.data.total.totalAmount / 100
          } else {
            self.totalMoney = 0
          }
          if (response.data.total !== null) {
            self.totalFee = response.data.total.totalFee / 100
          } else {
            self.totalFee = 0
          }
          if (response.data.total !== null) {
            self.totalCount = response.data.total
          } else {
            self.totalCount = 0
          }
          self.total = response.data.total
        })
        .catch(function (error) {
          console.log(error)
        })
    },

    reconRecord () {
      let self = this
      self.$axios.post('/merReconcileRecord/restart', this.selectData).then(res => {
        if (res.status === 200) {
          self.$Message.success('对账重跑中！')
          self.searchList()
        } else {
          self.$Message.success('对账重跑失败！')
          self.searchList()
        }
      })
    },
    download (data) {
      if (!data) {
        return
      }
      let url = window.URL.createObjectURL(new Blob([data]))
      let link = document.createElement('a')
      link.style.display = 'none'
      link.href = url
      link.setAttribute('download', '商户对账单' + this.reconcileDate + '.xlsx')
      document.body.appendChild(link)
      link.click()
    },
    searchBtn () {
      this.pageNo = 1
      if (this.merNo) {
        this.searchList()
      } else {
        this.$Message.error('请输入商户号')
      }
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    resetBtn () {
      this.merNo = ''
      this.reconcileDate = ''
      this.pageNo = 1
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
  activated() {
      this.searchList()
  }
}
</script>
