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
        <FormItem label="客户号：" prop="industryCode" >
          <Input v-model="industryCode" style="width: 300px" placeholder="请输入客户号" :maxlength="12" />
        </FormItem>
        <FormItem label="渠道编号：" prop="channelCode" >
          <Input v-model="channelCode" style="width: 300px" placeholder="请输入渠道编号" :maxlength="32" />
        </FormItem>
        <FormItem label="产品类型：" prop="productCode" >
          <Select v-model="productCode" class="input-width-170" @on-change="chanProduct">
            <Option v-for="item in productNoAry" :value="item.code" :key="item.code">{{item.name}}</Option>
          </Select>
        </FormItem>
        <FormItem  label="开始日期：" prop="transBeginDate" >
          <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem  label="结束日期：" prop="transEndDate" >
          <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="searchBtn()" v-access id="listReportForm">查询</Button>
          <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
          <Button type="success" class="margin-left-10" v-access id="listReportFormDownLoad" @click="downLoad" :disabled = "disDownLoad">下载报表</Button>
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
      <!--<Col :span="6">-->
        <!--<span>渠道交易总手续费：{{totalChannelFee}}</span>-->
      <!--</Col>-->
      <!--<Col :span="6">-->
        <!--<span>客户交易总手续费：{{totalIndustryFee}}</span>-->
      <!--</Col>-->
    </Row>
    <Row>
      <Table :columns="tableColumns" :data="tableData" border highlight-row stripe ></Table><br/>
      <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
    </Row>
  </card>
</template>
<script>export default {
  name: "reportFormList",
  data () {
    return {
      disDownLoad: true,
      isHidden: true,
      year: new Date().getFullYear(),
      month: new Date().getMonth(),
      day: new Date().getDay(),
      transBeginDate: this.$moment(new Date()).format('YYYY-MM-DD'),
      transEndDate: this.$moment(new Date()).format('YYYY-MM-DD'),
      productNoAry: [],
      switchType: 'chevron-down',
      switchTitle: '点击展开',
      reconcileDate: '',
      orgCode: '',
      industryCode: '',
      channelCode: '',
      productCode: '',
      formData: {},
      tableColumns: [],
      tableData: [],
      orgData: [],
      totalCount: 0 + '笔',
      total: 0,
      totalMoney: 0 + '元',
      totalFee: 0,
      totalChannelFee: 0,
      totalIndustryFee: 0,
      pageNo: 1,
      pageSize: 10,
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
    getDateStr (AddDayCount) {
      var dd = new Date()
      dd.setDate(dd.getDate() + AddDayCount)
      var year = dd.getFullYear()
      var mon = dd.getMonth() + 1
      var day = dd.getDate()
      return year + '' + mon + '' + day
    },
    chanProduct (val) {
      this.productCode = val
    },
    // chanMer () {
    //   if (this.reconcileDate) {
    //     this.disDownLoad = false
    //   }
    // },
    init () {
      let self = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          width: 100 * avg,
          title: '客户号',
          key: 'industryCode'
        },
        {
          width: 150 * avg,
          title: '客户名称',
          key: 'industryName'
        },
        {
          width: 100 * avg,
          title: '渠道编号',
          key: 'channelCode'
        },
        {
          width: 100 * avg,
          title: '渠道名称',
          key: 'channelName'
        },
        {
          width: 150 * avg,
          title: '产品类型',
          key: 'productCode'
          // render: function (h, a, b) {
          //   let getReslt = ''
          //   if (a.row.productCode === 'ACCOUNT') {
          //     getReslt = '代付'
          //   }
          //   return h('span', getReslt)
          // }
        },
        {
          width: 150 * avg,
          title: '交易总笔数',
          key: 'totalCount'
        },
        {
          width: 150 * avg,
          title: '交易总金额',
          key: 'totalAmount',
          render (h, a, b) {
            return h('span', a.row.totalAmount / 100 + '元')
          }
        },
        {
          title: '渠道交易总手续费',
          key: 'totalChannelFee',
          render (h, a, b) {
            return h('span', a.row.totalChannelFee / 100 + '元')
          }
        },
        {
          title: '客户交易总手续费',
          key: 'totalIndustryFee',
          render (h, a, b) {
            return h('span', a.row.totalIndustryFee / 100 + '元')
          }
        }
      ]
      let queryOld = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      // this.$axios.post('/payProduct/list', queryOld).then(function (res) {
      //   res.data.list.forEach(function (e, i) {
      //     self.productNoAry.push(e)
      //   })
      // })
      this.$axios.post('/payProduct/list', queryOld).then(function (res) {
        res.data.list.forEach(function (e, i) {
          if (e.status !== '0') {
            self.productNoAry.push(e)
          }
          // (e.code === '1000') && (self.productMap['COLLECTION'] = e.name);
          // (e.code === '1001') && (self.productMap['ACCOUNT'] = e.name)
        })
      })
      // this.searchList()
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
      let self = this
      this.formData = {}
      if (this.industryCode) {
        this.formData.industryCode = this.industryCode
      } else {
        delete this.formData.industryCode
      }
      if (this.channelCode) {
        this.formData.channelCode = this.channelCode
      } else {
        delete this.formData.channelCode
      }
      if (this.productCode) {
        this.formData.productCode = this.productCode
      } else {
        delete this.formData.productCode
      }
      if (this.transBeginDate.length === 8) {
        this.formData.transBeginDate = this.transBeginDate
      } else {
        let getMon = ''
        if (this.transBeginDate.getMonth() + 1 < 10) {
          getMon = '0' + (this.transBeginDate.getMonth() + 1).toString()
        }
        this.formData.transBeginDate = this.transBeginDate.getFullYear() + '' + getMon + '' + this.transBeginDate.getDate()
      }
      if (this.transEndDate.length === 8) {
        this.formData.transEndDate = this.transEndDate
      } else {
        let getMon = ''
        if (this.transEndDate.getMonth() + 1 < 10) {
          getMon = '0' + (this.transEndDate.getMonth() + 1).toString()
        }
        this.formData.transEndDate = this.transEndDate.getFullYear() + '' + getMon + '' + this.transEndDate.getDate()
      }
      let query = {
        pageNo: self.pageNo,
        pageSize: self.pageSize,
        parameters: this.formData
      }
      this.$axios.post('/transSumInfo/list', query)
        .then(function (response) {
          self.tableData = ''
          self.tableData = response.data.page.list
          if (response.data.total.totalCount > 0) {
            self.totalMoney = response.data.total.totalAmount / 100 + '元'
          } else {
            self.totalMoney = 0 + '元'
          }
          if (response.data.total.totalCount > 0) {
            self.totalChannelFee = response.data.total.totalChannelFee / 100 + '元'
          } else {
            self.totalChannelFee = 0 + '元'
          }
          if (response.data.total.totalCount > 0) {
            self.totalIndustryFee = response.data.total.totalIndustryFee / 100 + '元'
          } else {
            self.totalIndustryFee = 0 + '元'
          }
          if (response.data.total.totalCount !== 0) {
            self.totalFee = response.data.total.totalFee / 100 + '元'
          } else {
            self.totalFee = 0 + '元'
          }
          if (response.data.total.totalCount !== 0) {
            self.totalCount = response.data.total.totalCount + '笔'
          } else {
            self.totalCount = 0 + '笔'
          }
          self.total = response.data.page.total
          if (self.tableData.length > 0) {
            self.disDownLoad = false
          } else {
            self.disDownLoad = true
          }
        })
        .catch(function (error) {
          console.log(error)
        })
      // }
      //   })
    },

    downLoad () {
      let self = this
      let parameters = this.formData
      self.$axios({
        method: 'post',
        url: '/transSumInfo/download',
        data: parameters,
        responseType: 'blob'
      }).then(response => {
        self.download(response.data)
      }).catch((error) => {

      })
    },
    download (data) {
      if (!data) {
        return
      }
      let dateLast = this.$moment(this.transEndDate).format('YYYYMMDD')
      let downName = '交易统计报表' + dateLast + '.xlsx' // 文件下载名称
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
        let dateLast = this.$moment(this.transEndDate).format('YYYYMMDD')
        link.setAttribute('download', '交易统计报表' + dateLast + '.xlsx')
        document.body.appendChild(link)
        link.click()
      }

    },
    searchBtn () {
      this.pageNo = 1
      this.searchList()
      // if (this.reconcileDate && this.merNo) {
      //   this.searchList()
      // } else {
      //   this.$Message.error('请完整输入两个查询条件')
      // }
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    resetBtn () {
      this.industryCode = ''
      this.channelCode = ''
      this.productCode = ''
      this.transBeginDate = this.$moment(new Date()).format('YYYYMMDD')
      this.transEndDate = this.$moment(new Date()).format('YYYYMMDD')
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
