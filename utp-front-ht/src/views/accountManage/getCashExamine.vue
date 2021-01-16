<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="客户端流水：" prop="clientTransId">
            <Input v-model="clientTransId" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="归集账户客户号：" prop="collectAccountNo">
            <Input v-model="collectAccountNo" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="归集账户客户名称：" prop="collectAccountName">
            <Input v-model="collectAccountName" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="手续费账户虚拟账号：" prop="account">
            <Input v-model="account" :maxlength="nameSize"/>
          </FormItem>
          <FormItem  label="审核状态：" prop="auditStatus" >
            <Select v-model="auditStatus" style="width: 180px"  @on-change="objTypeChange">
              <Option value="0">待审核</Option>
              <Option value="1">审核通过</Option>
              <Option value="2">审核驳回</Option>
            </Select>
          </FormItem>
          <FormItem  label="申请开始时间：" prop="gmtCreate" >
            <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem  label="申请结束时间：" prop="transEndDate" >
            <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="getCashList" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" stripe></Table>
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
        <Select v-model="formData.auditStatus" style="width: 180px"  @on-change="objTypeChange">
          <Option value="1">审核通过</Option>
          <Option value="2">审核驳回</Option>
        </Select>

      <div slot="footer">
        <Button type="text" size="large" @click="cancel">取消</Button>
        <Button type="primary" size="large" @click="sumbitAccount">确定</Button>
      </div>
    </Modal>
  </card>
</template>

<script>
export default {
  data () {
    return {
      examineStatu: false,
      clientTransId: '',
      collectAccountNo: '',
      collectAccountName: '',
      account: '',
      auditStatus: '',
      transBeginDate: '',
      transEndDate: '',
      formData: {
        auditStatus: '',
        id: ''
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
          title: '提现客户端流水号',
          key: 'clientTransId',
          width: 180 * avg
        },
        {
          title: '归集账户客户号',
          key: 'collectAccountNo',
          width: 180 * avg
        },
        {
          title: '归集账户客户名称',
          key: 'collectAccountName',
          width: 150 * avg
        },
        {
          title: '手续费账户虚拟账号',
          key: 'account',
          width: 150 * avg
        },
        {
          title: '资金账号',
          key: 'fundAccountNo',
          width: 150 * avg
        },
        {
          title: '资金账户户名',
          key: 'fundAccountName',
          width: 185 * avg
        },
        {
          title: '提现金额',
          key: 'amount',
          width: 200 * avg,
          render (h, a, b) {
            return h('span', a.row.amount / 100 + '元')
          }
        },
        {
          title: '收款方账号',
          key: 'reciveAccountNo',
          width: 200 * avg
        },
        {
          title: '收款方户名',
          key: 'reciveAccountName',
          width: 200 * avg
        },
        {
          title: '申请时间',
          key: 'gmtCreate',
          width: 200 * avg,
          align: 'left',
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '审核状态',
          key: 'auditStatus',
          width: 200 * avg,
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
          title: '操作',
          key: 'action',
          width: 120 * avg,
          align: 'center',
          render: (h, params) => {
            if (params.row.auditStatus === '1') {
              // return h('div', [
              //   h('svg-icon', {
              //     attrs: {
              //       id: 'getCashDetail',
              //       title: '查看明细'
              //     },
              //     props: {
              //       type: 'detail',
              //       size: '16'
              //     },
              //     style: {
              //       marginRight: '20px',
              //       cursor: 'pointer'
              //     },
              //     directives: [{
              //       name: 'access'
              //     }],
              //     on: {
              //       click: () => {
              //         this.showDetail(params.row)
              //       }
              //     }
              //   }, '查看明细')
              //
              // ])
            } else {
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'getCashExamine',
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
                      this.getCashApply(params.row)
                    }
                  }
                }, '审核')
                // h('svg-icon', {
                //   attrs: {
                //     id: 'getCashDetail',
                //     title: '查看明细'
                //   },
                //   props: {
                //     type: 'detail',
                //     size: '16'
                //   },
                //   style: {
                //     marginRight: '20px',
                //     cursor: 'pointer'
                //   },
                //   directives: [{
                //     name: 'access'
                //   }],
                //   on: {
                //     click: () => {
                //       this.showDetail(params.row)
                //     }
                //   }
                // }, '查看明细')

              ])
            }
          }
        }
      ]
      // 查询信息
      let self = this
      // this.$axios.get('/dictionaries').then(function (res) {
      //   self.bankNameAry = res.data.bank
      // })
      this.searchList()
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
      let uri = encodeURI('/withdrawalsRecord/list')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.clientTransId) {
        this.query.parameters.clientTransId = this.clientTransId
      } else {
        delete this.query.parameters.clientTransId
      }
      if (this.collectAccountNo) {
        this.query.parameters.collectAccountNo = this.collectAccountNo
      } else {
        delete this.query.parameters.collectAccountNo
      }
      if (this.collectAccountName) {
        this.query.parameters.collectAccountName = this.collectAccountName
      } else {
        delete this.query.parameters.collectAccountName
      }
      if (this.account) {
        this.query.parameters.account = this.account
      } else {
        delete this.query.parameters.account
      }
      if (this.auditStatus) {
        this.query.parameters.auditStatus = this.auditStatus
      } else {
        delete this.query.parameters.auditStatus
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
      this.formData.auditStatus = val
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
    sumbitAccount () {
      let that = this
      this.$axios.put('/withdrawalsRecord', this.formData).then(function (res) {
        that.searchList()
        that.$Message.success('提款审核成功')
      }).catch(function () {
      })
      this.examineStatu = false
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
      this.clientTransId = ''
      this.collectAccountNo = ''
      this.collectAccountName = ''
      this.account = ''
      this.auditStatus = ''
      this.transBeginDate = ''
      this.transEndDate = ''
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
    getCashApply (row) {
      this.formData = {}
      this.examineStatu = true
      this.formData.id = row.id
    },
    showDetail (row) {
      this.$router.push({
        name: 'cashExamineDetail',
        params: {
          id: row.clientTransId
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
  }
}
</script>
