<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form :label-width="150">
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">任务详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="24">
          <Col span="12">
            <FormItem label="任务ID：" prop="taskId">
              <span> {{ formData.taskId }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="任务初始运行日期：" prop="jobDate">
              <span> {{ formData.jobDate }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="作业名称：" prop="jobName">
              <span> {{ formData.jobName }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="作业ID：" prop="jobId">
              <span> {{ formData.jobId }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="任务最后运行开始时间：" prop="lastRunStarttime">
              <span> {{ formData.lastRunStarttime }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="任务最后运行结束时间：" prop="lastRunEndtime">
              <span> {{ formData.lastRunEndtime }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="任务状态：" prop="jobtaskState">
              <span> {{ formData.jobtaskState }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="重试次数：" prop="retryTimes">
              <span> {{ formData.retryTimes }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="运行参数：" prop="taskArgs">
              <span> {{ formData.taskArgs }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="异常信息：" prop="catchException">
              <span> {{ formData.catchException }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="备注：" prop="description">
              <span> {{ formData.description }} </span>
            </FormItem>
          </Col>
        </Col>
      </Row>
      <Row>
      </Row>
    </Form>
  </card>
</template>
<script>
export default {
  name: 'jobTaskDetail',
  data () {
    return {
      id: this.$route.params.id,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {}
    }
  },
  methods: {
    init () {
      if (this.id) {
        this.getOrganizationDetail()
      }
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('jobTask' + '/' + this.id)
        .then(function (response) {
          if (response.data.jobtaskState === 'SUCCESS') {
            response.data.jobtaskState = '成功'
          }
          if (response.data.jobtaskState === 'PREP') {
            response.data.jobtaskState = '初始化'
          }
          if (response.data.jobtaskState === 'WAITING') {
            response.data.jobtaskState = '等待'
          }
          if (response.data.jobtaskState === 'RUNNING') {
            response.data.jobtaskState = '正在运行'
          }
          if (response.data.jobtaskState === 'FAILED') {
            response.data.jobtaskState = '失败'
          }
          if (response.data.jobtaskState === 'KILLED') {
            response.data.jobtaskState = '取消任务'
          }
          if (response.data.jobDate) {
            let stringAry = response.data.jobDate.split('')
            response.data.jobDate = stringAry[0] + stringAry[1] + stringAry[2] + stringAry[3] + '-' + stringAry[4] + stringAry[5] + '-' + stringAry[6] + stringAry[7]
          }
          if (response.data.lastRunEndtime) {
            let stringAry = response.data.lastRunEndtime.split('')
            response.data.lastRunEndtime = stringAry[0] + stringAry[1] + stringAry[2] + stringAry[3] + '-' + stringAry[4] + stringAry[5] + '-' + stringAry[6] + stringAry[7] + ' ' + stringAry[8] + stringAry[9] + ':' + stringAry[10] + stringAry[11] + ':' + stringAry[12] + stringAry[13]
          }
          if (response.data.lastRunStarttime) {
            let stringAry = response.data.lastRunStarttime.split('')
            response.data.lastRunStarttime = stringAry[0] + stringAry[1] + stringAry[2] + stringAry[3] + '-' + stringAry[4] + stringAry[5] + '-' + stringAry[6] + stringAry[7] + ' ' + stringAry[8] + stringAry[9] + ':' + stringAry[10] + stringAry[11] + ':' + stringAry[12] + stringAry[13]
          }
          self.formData = response.data
          // self.funcTableData = response.data.roleList
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    this.init()
  },
  computed: {
  },
  mounted () {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'jobTaskDetail', this.$route.params.id)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.init()
    }
  }
}
</script>
