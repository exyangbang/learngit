<style lang="less">
  @import '../../styles/common.less';
  .hidden {
    display: none;
  }
</style>
<template>
  <card>
    <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
        <Row>
          <FormItem  label="交易开始日期：" prop="beginTradeDate" >
            <DatePicker :options="beginDateOption" v-model="formData.parameters.beginTradeDate" class="input-width-170" type="date" :value="formData.parameters.beginTradeDate" placeholder="请选择交易开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange"></DatePicker>
          </FormItem>
          <FormItem  label="交易开始时间：" prop="beginTradeTime" style="margin-bottom: 10px">
            <TimePicker :readonly="beginTimeDisable" :disabled="beginTimeDisable" :disabled-hours="beginTimeHour" :disabled-minutes="beginTimeMin" :disabled-seconds="beginTimeSec" v-model="formData.parameters.beginTradeTime" class="input-width-170"  :value="formData.parameters.beginTradeTime" placeholder="请选择交易开始时间" format="HH:mm:ss" @on-change="beginTradeTimeChange"></TimePicker>
          </FormItem>
          <FormItem label="客户端流水号：" prop="orderId">
            <Input v-model="formData.parameters.orderId" class="input-width-170"/>
          </FormItem>

          <FormItem label="交易结束日期：" prop="endTradeDate" >
            <DatePicker :options="endDateOption" v-model="formData.parameters.endTradeDate" class="input-width-170" type="date" :value="formData.parameters.endTradeDate" placeholder="请选择交易结束日期" format="yyyy-MM-dd" @on-change="endTradeDateChange"></DatePicker>
          </FormItem>
          <FormItem label="交易结束时间：" prop="endTradeTime" style="margin-bottom: 10px">
            <TimePicker :readonly="endTimeDisable" :disabled="endTimeDisable" :disabled-hours="endTimeHour" :disabled-minutes="endTimeMin" :disabled-seconds="endTimeSec" :v-model="formData.parameters.endTradeTime" class="input-width-170"  :value="formData.parameters.endTradeTime" placeholder="请选择交易结束时间" format="HH:mm:ss" @on-change="endTradeTimeChange"></TimePicker>
          </FormItem>
          <FormItem label="交易状态：" prop="respCode">
            <Select v-model="formData.parameters.respCode" class="input-width-170">
              <Option value="S">交易成功</Option>
              <Option value="E">交易失败</Option>
              <Option value="R">未知状态</Option>
            </Select>
          </FormItem>
          <FormItem label="产品类型：" prop="bizType" >
            <Select v-model="formData.parameters.bizType" class="input-width-170">
              <Option v-for="item in this.$contants.dictionary.bizType" :value="item.code" :key="item.code">{{item.name}}</Option>
            </Select>
          </FormItem>
          <FormItem label="交易类型：" prop="txnType" >
            <Select v-model="formData.parameters.txnType" class="input-width-170">
              <Option value="WITHDRAW">提现</Option>
            </Select>
          </FormItem>
          <FormItem label="机构：" prop="acqInsCode" >
            <Select v-model="formData.parameters.acqInsCode" class="input-width-170">
              <Option v-for="item in orgData" :value="item.orgCode" :key="item.orgCode">{{ item.fullName }}</Option>
            </Select>
          </FormItem>
          <FormItem label="商户号：" prop="merId">
            <Input v-model="formData.parameters.merId" class="input-width-170"/>
          </FormItem>
          <FormItem label="卡号：" prop="accNo">
            <Input v-model="formData.parameters.accNo" class="input-width-170"/>
          </FormItem>
      </Row>
          <!--<div style="margin-bottom:10px;left: 28%;position:relative;">-->
            <!--<a style="text-decoration:underline;color: #2b85e4;display: inline;margin-right: 3px" @click="switchSearch">{{switchTitle}}</a><Icon :type="switchType" :title="switchTitle" style="color:#2b85e4;:pointer;width: 13px" @click="switchSearch"/>-->
          <!--</div>-->
          <!--<div v-bind:class="{hidden:isHidden}">-->
      <Row>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listTradeFlowCash">查询</Button>
          <Button html-type="reset" class="margin-left-10 " @click="resetBtn()">重置</Button>
        </FormItem>
      </Row>
    </Form>
    <Row>
        <Table :columns="tableColumns" :data="tableData" border stripe ></Table><br/>
        <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>
export default {
  data () {
    return {
      isHidden: true,
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      formData: {parameters: {}},
      tableColumns: [],
      tableData: [],
      orgData: [],
      total: 0,
      pageNo: 1,
      pageSize: 10,
      beginDateOption: {},
      endDateOption: {},
      beginTimeHour: [],
      beginTimeMin: [],
      beginTimeSec: [],
      endTimeHour: [],
      endTimeMin: [],
      endTimeSec: [],
      beginTimeDisable: true,
      endTimeDisable: true
    }
  },
  methods: {
    switchSearch () {
      if (this.switchType === 'chevron-down') {
        this.switchType = 'chevron-up'
        this.switchTitle = '点击收缩'
        this.isHidden = false
      } else {
        this.switchType = 'chevron-down'
        this.switchTitle = '点击展开'
        this.isHidden = true
      }
    },
    disableEndTradeTime () {
      this.endTimeHour = []
      if (this.formData.parameters.beginTradeDate && this.formData.parameters.endTradeDate && this.formData.parameters.beginTradeTime) {
        let beginDate = new Date(this.formData.parameters.beginTradeDate.replace(/-/, '/'))
        let endDate = new Date(this.formData.parameters.endTradeDate.replace(/-/, '/'))
        if (beginDate.valueOf() > endDate.valueOf()) {
          this.endTimeDisable = true
        } else if (beginDate.valueOf() === endDate.valueOf()) {
          let timeArr = this.formData.parameters.beginTradeTime.split(':')
          if (timeArr.length === 3) {
            let max = parseInt(timeArr[0])
            this.endTimeHour = []
            this.endTimeMin = []
            this.endTimeSec = []
            for (let i = 0; i <= max; i++) {
              this.endTimeHour.push(i)
            }
            if (!this.formData.parameters.endTradeTime) {
              for (let i = 0; i <= 60; i++) {
                this.endTimeMin.push(i)
                this.endTimeSec.push(i)
              }
            }
          }
        }
      }
    },
    disableBeginTradeTime () {
      this.beginTimeHour = []
      if (this.formData.parameters.beginTradeDate && this.formData.parameters.endTradeDate && this.formData.parameters.endTradeTime) {
        let beginDate = new Date(this.formData.parameters.beginTradeDate.replace(/-/, '/'))
        let endDate = new Date(this.formData.parameters.endTradeDate.replace(/-/, '/'))
        if (beginDate.valueOf() === endDate.valueOf()) {
          let timeArr = this.formData.parameters.endTradeTime.split(':')
          if (timeArr.length === 3) {
            let min = parseInt(timeArr[0])
            this.beginTimeHour = []
            this.beginTimeMin = []
            this.beginTimeSec = []
            for (let i = min; i <= 23; i++) {
              this.beginTimeHour.push(i)
              if (!this.formData.parameters.beginTradeTime) {
                for (let i = 0; i <= 60; i++) {
                  this.beginTimeMin.push(i)
                  this.beginTimeSec.push(i)
                }
              }
            }
          }
        }
      }
    },
    beginTradeDateChange (value) {
      this.formData.parameters.beginTradeDate = value
      this.formData.parameters.beginTradeTime = ''
      if (value) {
        this.beginTimeDisable = false
        let dateGet = new Date(value.replace(/-/, '/'))
        this.endDateOption = {
          disabledDate (date) {
            let bol = date && date.valueOf() < dateGet.valueOf()
            let bolMonth = new Date(dateGet.setMonth(dateGet.getMonth() + 1)).valueOf() < date.valueOf()
            return bol || bolMonth
          }
        }
        this.disableEndTradeTime()
      } else {
        this.endDateOption = {}
        this.beginTimeDisable = true
      }
    },
    endTradeDateChange (value) {
      this.formData.parameters.endTradeDate = value
      this.formData.parameters.endTradeTime = ''
      if (value) {
        let dateGet = new Date(value.replace(/-/, '/'))
        this.beginDateOption = {
          disabledDate (date) {
            let bol = date && date.valueOf() > dateGet.valueOf()
            return bol
          }
        }
        this.endTimeDisable = false
        this.disableEndTradeTime()
      } else {
        this.beginDateOption = {}
        this.endTimeDisable = true
      }
    },
    beginTradeTimeChange (value) {
      if (value) {
        let timeArr = value.split(':')
        if (timeArr.length === 3) {
          if (parseInt(timeArr[0]) > 0 && parseInt(timeArr[1]) === 0 && parseInt(timeArr[1]) === 0) {
            this.beginTimeMin = []
            this.beginTimeSec = []
          }
        }
      }
      this.formData.parameters.beginTradeTime = value
      this.disableEndTradeTime()
    },
    endTradeTimeChange (value) {
      this.formData.parameters.endTradeTime = value
      if (value) {
        let timeArr = value.split(':')
        if (timeArr.length === 3) {
          if (parseInt(timeArr[0]) > 0 && parseInt(timeArr[1]) === 0 && parseInt(timeArr[1]) === 0) {
            this.endTimeMin = []
            this.endTimeSec = []
          }
        }
        this.disableBeginTradeTime()
      } else {
        this.endTimeMin = []
        this.endTimeSec = []
        for (let i = 0; i <= 60; i++) {
          this.endTimeMin.push(i)
          this.endTimeSec.push(i)
        }
        this.beginTimeHour = []
      }
    },
    init () {
      this.formData.parameters.beginTradeDate = this.$moment(new Date()).format('YYYY-MM-DD')
      this.formData.parameters.endTradeDate = this.$moment(new Date()).format('YYYY-MM-DD')
      this.formData.parameters.beginTradeTime = '00:00:00'
      this.formData.parameters.endTradeTime = '23:59:59'
      this.beginTimeDisable = false
      this.endTimeDisable = false
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 100 * avg,
          title: '机构编号',
          key: 'acqInsCode'
        },
        {
          width: 180 * avg,
          title: '卡号',
          key: 'accNo'
        },
        {
          width: 150 * avg,
          title: '商户号',
          key: 'merId'
        },
        {
          width: 100 * avg,
          title: '商户名称',
          key: 'merName'
        },
        {
          width: 100 * avg,
          title: '产品类型',
          key: 'bizType',
          render: function (h) {
            return h('span', self.$contants.dictionary.bizTypeMap[this.row.bizType])
          }
        },
        {
          width: 100 * avg,
          title: '交易类型',
          key: 'txnType',
          render: function (h) {
            return h('span', self.$contants.dictionary.txnTypeMap[this.row.txnType])
          }
        },
        {
          width: 150 * avg,
          title: '客户端流水号',
          key: 'orderId'
        },
        {
          width: 150 * avg,
          title: '实际交易金额(分)',
          key: 'txnAmt'
        },
        {
          width: 100 * avg,
          title: '交易状态',
          key: 'respCode',
          render: function (h) {
            return h('span', self.$contants.dictionary.respCodeMap[this.row.respCode])
          }
        },
        {
          width: 150 * avg,
          title: '交易发起时间',
          key: 'txnTime',
          render: function (h) {
            return h('span', self.$moment(parseInt(this.row.txnTime)).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          width: 120 * avg,
          title: '渠道返回信息',
          key: 'respMsg'
        }
      ]
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
    searchList () {
      if (this.formData.beginTradeDate && this.formData.endTradeDate) {
        if (new Date(this.formData.beginTradeDate) > new Date(this.formData.endTradeDate)) {
          this.$Message.error('交易结束日期在交易开始日期之前')
          return 0
        }
      }
      if (this.formData.beginTradeTime && this.formData.endTradeTime) {
        if (!this.formData.beginTradeDate || !this.formData.endTradeDate) {
          this.$Message.error('交易结束日期和交易开始日期不能为空')
          return 0
        }
        if (new Date(this.formData.beginTradeDate + ' ' + this.formData.beginTradeTime) > new Date(this.formData.endTradeDate + ' ' + this.formData.endTradeTime)) {
          this.$Message.error('交易结束时间在交易开始时间之前')
          return 0
        }
      }
      let self = this
      let queryUrl = self.$contants.restful.tradeFlowCashs
      self.formData.pageNo = self.pageNo
      self.formData.pageSize = self.pageSize
      this.$axios.post(queryUrl, self.formData)
        .then(function (response) {
          self.tableData = response.data.list
          self.total = response.data.total
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.pageNo = 1
      this.searchList()
    },
    resetBtn () {
      this.beginTimeDisable = true
      this.endTimeDisable = true
      this.beginDateOption = {}
      this.endDateOption = {}
      this.beginTimeHour = []
      this.beginTimeMin = []
      this.beginTimeSec = []
      this.endTimeHour = []
      this.endTimeMin = []
      this.endTimeSec = []
      this.formData = {parameters: {}}
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
  }
}
</script>
