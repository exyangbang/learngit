<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form  :model="formData"  ref="formData" :label-width="120" :rules="ruleValidate">
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">添加定时任务</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <i style="height: 10px"></i>
      <Row>
        <Col span="24">
          <row>
            <!--</Col>-->
            <Col span="12">
              <FormItem label="任务日期：" prop="jobDate">
                <DatePicker v-model="formData.jobDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择交易开始日期" @on-change="beginTradeDateChange"></DatePicker>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="作业名称：" prop="jobName">
                <i-select  style="width:200px" :label-in-value = "true"  @on-change="jobNameChange">
                  <i-option v-for="item in jobDateAry"  :key="item.id" :value="item.jobId">{{ item.jobName }}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="任务优先级：" prop="jobPriority">
                <Input v-model="formData.jobPriority" style="width: 300px" placeholder="请输入任务优先级" :maxlength="8" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="重试次数：" prop="retryTimes">
                <Input v-model="formData.retryTimes" style="width: 300px" placeholder="请输入重试次数" :maxlength="8" />
              </FormItem>
            </Col>

            <Col span="12">
              <FormItem label="任务参数：" prop="taskArgs">
                <Input v-model="formData.taskArgs" style="width: 300px" placeholder="请输入任务参数" :maxlength="1024" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="备注：" prop="description">
                <Input v-model="formData.description" style="width: 300px" placeholder="请输入备注" :maxlength="500" />
              </FormItem>
            </Col>
          </row>
        </Col>
      </Row>
      <Row>
        <Col span="10" offset="2">
          <FormItem>
            <Button type="primary" @click="handleSubmit()">提交</Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
  </card>
</template>
<script>
export default {
  name: "addJobTask",
  data () {
    return {
      industryCode: '',
      industryAry: [],
      industryAryFirst: '',
      choseIndustry: false,
      jobDateAry: [],
      currentPage: 1,
      formData: {
        jobName: '',
        jobId: '',
        jobDate: '',
        jobPriority: '',
        jobtaskState: 'PREP',
        retryTimes: '',
        taskArgs: '',
        description: '',
        taskId: ''
      },
      ruleValidate: {
        jobName: [
          {required: true, trigger: 'blur', message: '请选择作业名称'}
        ],
        jobDate: [
          {required: true, trigger: 'blur', message: '请选择任务日期'}
        ],
        jobPriority: [
          {required: true, trigger: 'blur', message: '请输入优先级'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        retryTimes: [
          {required: true, trigger: 'blur', message: '请输入重试次数'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        taskArgs: [
          {required: true, trigger: 'blur', message: '请输入任务参数'}
        ]
      },
      tree: [{}]
    }
  },
  methods: {
    init () {
      this.getjobDate()
    },
    getjobDate () {
      let self = this
      this.$axios.get('/jobTask/jobDict').then(function (res) {
        self.jobDateAry = res.data
      })
    },
    industryCodeChange (val) {
      this.industryCode = val.value
    },
    jobNameChange (val) {
      this.formData.jobName = val.label
      this.formData.jobId = val.value

      let self = this
      if (val.value === 'sync-accountDetail-ht') {
        self.$axios.post('/industry/list', {}).then(function (res) {
          res.data.forEach(function (e, i) {
            if (e.custNumber && e.custAccountNo) {
              self.industryAry.push(e)
            }
          })
          if (self.industryAry.length >= 1) {
            self.industryAryFirst = self.industryAry[0].code
            self.industryCode = self.industryAry[0].code
          }
        })
        this.choseIndustry = true
      }
    },
    beginTradeDateChange (value) {
      value = value.replace('-', '').replace('-', '')
      this.formData.jobDate = value
    },
    handleSubmit () {
      let that = this
      if (this.formData.jobId === 'sync-accountDetail-ht') {
        this.formData.taskId = 'SYNC-ACCOUNTDETAIL' + '-' + this.industryCode + '-' + this.formData.jobDate
      } else {
        this.formData.taskId = 'OENBANK_FZ_' + this.formData.jobDate
      }
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.post('/jobTask', this.formData).then(function (res) {
            that.$Message.success('添加任务成功')
            that.goBack()
          })
        } else {
          that.$Message.error('请正确填写信息')
        }
      })
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    // 用这个对象
    this.init()
  },
  mounted () {},
  computed: {
    headers () {
      if (!this.$store.state.app.token) {
        this.$store.commit('setToken', localStorage.getItem('token'))
      }
      return {
        'X-Requested-With': 'XMLHttpRequest',
        'X-Authorization': 'Bearer ' + this.$store.state.app.token
      }
    }
  }
}
</script>
