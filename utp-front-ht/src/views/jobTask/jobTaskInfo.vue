<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="作业名称：" prop="jobName">
            <i-select  style="width:200px" v-model="jobId" :label-in-value = "true"  @on-change="jobNameChange">
              <i-option v-for="item in jobDateAry"  :key="item.jobId" :value="item.jobId">{{ item.jobName }}</i-option>
            </i-select>
          </FormItem>
          <FormItem label="任务ID：" prop="taskId">
            <Input v-model="taskId" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="初始运行日期：" prop="jobDate">
            <DatePicker v-model="jobDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>
          </FormItem>
          <FormItem label="最后运行开始时间：" prop="">
            <DatePicker type="datetime" :options="beginDateOption" :editable="false"  v-model="lastRunStarttime" placeholder="请选择最后运行开始时间" format="yyyy-MM-dd HH:mm:ss" style="width: 200px" @on-change="lastStarttimeChange"></DatePicker>
          </FormItem>
          <FormItem label="最后运行结束时间：" prop="">
            <DatePicker type="datetime" :options="endDateOption" :editable="false" v-model="lastRunEndtime" placeholder="请选择最后运行结束时间" format="yyyy-MM-dd HH:mm:ss" style="width: 200px" @on-change="lastEndtimeChange"></DatePicker>
          </FormItem>
          <FormItem label="状态：" prop="jobtaskState">
            <i-select  style="width:200px" :label-in-value = "true" v-model="jobtaskState"  @on-change="jobtaskStateChange">
              <i-option value="SUCCESS">成功</i-option>
              <i-option value="PREP">初始化</i-option>
              <i-option value="WAITING">等待</i-option>
              <i-option value="RUNNING">正在运行</i-option>
              <i-option value="FAILED">失败</i-option>
              <i-option value="KILLED">取消任务</i-option>
            </i-select>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listJobTask" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addJobTask" @click="createBtn()" style="margin-right: 10px;">新增</Button>
            <Button type="info" class="margin-left-10" v-access @click="runAgain" id="runAgain" :disabled = "disAction">重跑</Button>
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
  </card>
</template>

<script>
export default {
  name: "jobTaskList",
  data () {
    return {
      jobDateAry: [],
      jobId: '',
      disAction: true,
      runID: '',
      jobtaskState: '',
      runStead: '',
      jobName: '',
      taskId: '',
      lastRunEndtime: '',
      lastRunStarttime: '',
      jobDate: '',
      formData: {},
      startTime: '',
      endTime: '',
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
          title: '任务ID',
          key: 'taskId',
          width: 200 * avg
        },
        {
          title: '任务初始运行日期',
          key: 'jobDate',
          width: 100 * avg,
          render (h, a, b) {
            if (a.row.jobDate) {
              let reslut = ''
              let stringAry = a.row.jobDate.split('')
              reslut = stringAry[0] + stringAry[1] + stringAry[2] + stringAry[3] + '-' + stringAry[4] + stringAry[5] + '-' + stringAry[6] + stringAry[7]
              return h('span', reslut)
            }
          }
        },
        {
          title: '作业名称',
          key: 'jobName',
          width: 150 * avg
        },
        {
          title: '作业Id',
          width: 150 * avg,
          key: 'jobId'
        },
        {
          title: '任务最后运行开始时间',
          key: 'lastRunStarttime',
          width: 120 * avg,
          render (h, a, b) {
            if (a.row.lastRunStarttime) {
              let reslut = ''
              let stringAry = a.row.lastRunStarttime.split('')
              reslut = stringAry[0] + stringAry[1] + stringAry[2] + stringAry[3] + '-' + stringAry[4] + stringAry[5] + '-' + stringAry[6] + stringAry[7] + ' ' + stringAry[8] + stringAry[9] + ':' + stringAry[10] + stringAry[11] + ':' + stringAry[12] + stringAry[13]
              return h('span', reslut)
            }
          }
        },
        {
          title: '任务最后运行结束时间',
          key: 'lastRunEndtime',
          width: 120 * avg,
          render (h, a, b) {
            if (a.row.lastRunEndtime) {
              let reslut = ''
              let stringAry = a.row.lastRunEndtime.split('')
              reslut = stringAry[0] + stringAry[1] + stringAry[2] + stringAry[3] + '-' + stringAry[4] + stringAry[5] + '-' + stringAry[6] + stringAry[7] + ' ' + stringAry[8] + stringAry[9] + ':' + stringAry[10] + stringAry[11] + ':' + stringAry[12] + stringAry[13]
              return h('span', reslut)
            }
          }
        },
        {
          title: '任务下次运行时间',
          key: 'nextRerunTime',
          width: 120 * avg,
          render (h, a, b) {
            if (a.row.nextRerunTime) {
              let reslut = ''
              let stringAry = a.row.nextRerunTime.split('')
              reslut = stringAry[0] + stringAry[1] + stringAry[2] + stringAry[3] + '-' + stringAry[4] + stringAry[5] + '-' + stringAry[6] + stringAry[7] + ' ' + stringAry[8] + stringAry[9] + ':' + stringAry[10] + stringAry[11] + ':' + stringAry[12] + stringAry[13]
              return h('span', reslut)
            }
          }
        },
        {
          title: '任务状态',
          key: 'jobtaskState',
          width: 100 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.jobtaskState === 'SUCCESS') {
              reslut = '成功'
            }
            if (a.row.jobtaskState === 'PREP') {
              reslut = '初始化'
            }
            if (a.row.jobtaskState === 'WAITING') {
              reslut = '等待'
            }
            if (a.row.jobtaskState === 'RUNNING') {
              reslut = '正在运行'
            }
            if (a.row.jobtaskState === 'FAILED') {
              reslut = '失败'
            }
            if (a.row.jobtaskState === 'KILLED') {
              reslut = '取消任务'
            }
            return h('span', reslut)
          }
        },
        {
          title: '重试次数',
          key: 'retryTimes',
          width: 80 * avg
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 150 * avg,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'detailJobTask',
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
              h('Poptip', {
                props: {
                  confirm: true,
                  title: '您确定要删除这条数据吗?',
                  transfer: true
                },
                on: {
                  'on-ok': () => {
                    this.doDelete(params.row)
                  }
                }
              }, [
                h('svg-icon', {
                  attrs: {
                    id: 'deleteJobTask',
                    title: '删除'
                  },
                  directives: [{
                    name: 'access'
                  }],
                  style: {
                    marginRight: '20px',
                    cursor: 'pointer'
                  },
                  props: {
                    type: 'delete',
                    size: '16'
                  }
                }, '删除')
              ])
            ])
          }
        }
      ]
      // 查询信息
      let self = this
      this.$axios.get('/dictionaries').then(function (res) {
        self.bankNameAry = res.data.bank
      })
      this.getjobDate()
      this.searchList()
    },
    jobtaskStateChange (val) {
      this.jobtaskState = val.value
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
      let uri = encodeURI('/jobTask/pageList')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.jobId) {
        this.query.parameters.jobId = this.jobId
      } else {
        delete this.query.parameters.jobId
      }
      if (this.taskId) {
        this.query.parameters.taskId = this.taskId
      } else {
        delete this.query.parameters.taskId
      }
      if (this.lastRunEndtime) {
        this.query.parameters.lastRunEndtime = this.endTime
      } else {
        delete this.query.parameters.lastRunEndtime
      }
      if (this.lastRunStarttime) {
        this.query.parameters.lastRunStarttime = this.startTime
      } else {
        delete this.query.parameters.lastRunStarttime
      }
      if (this.jobDate) {
        this.query.parameters.jobDate = this.jobDate
      } else {
        delete this.query.parameters.jobDate
      }
      if (this.jobtaskState) {
        this.query.parameters.jobtaskState = this.jobtaskState
      } else {
        delete this.query.parameters.jobtaskState
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
    getjobDate () {
      let self = this
      this.$axios.get('/jobTask/jobDict').then(function (res) {
        self.jobDateAry = res.data
      })
    },
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
          this.lastRunStarttime = ''
          this.$Message.error('最后运行开始时间不能大于最后运行结束时间')
        } else {
          this.lastRunStarttime = val
        }
      }
    },
    lastEndtimeChange (val) {
      this.endTime = ''
      val = val.replace('-', '').replace('-', '').replace(' ', '').replace(':', '').replace(':', '')
      this.endTime = val
      if (this.startTime) {
        if (val < this.startTime) {
          this.lastRunEndtime = ''
          this.$Message.error('最后运行结束时间不能小于最后运行开始时间')
        } else {
          this.lastRunEndtime = val
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
    clearBtn () {
      this.jobtaskState = ''
      this.jobName = ''
      this.jobId = ''
      this.taskId = ''
      this.lastRunEndtime = ''
      this.startTime = ''
      this.endTime = ''
      this.lastRunStarttime = ''
      this.jobDate = ''
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
        name: 'jobTaskDetail',
        params: {
          id: row.id
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
  activated() {
      this.searchList()
  }
}
</script>
