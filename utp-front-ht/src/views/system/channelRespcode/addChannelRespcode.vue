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
          <h4 style="display:inline">新增错误码</h4>
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
            <Col span="12">
              <FormItem label="渠道响应码：" prop="channelRespcode">
                <Input v-model="formData.channelRespcode" style="width: 300px" placeholder="请输入渠道响应码" :maxlength="200" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="渠道响应码描述：" prop="channelRespdesc">
                <Input v-model="formData.channelRespdesc" style="width: 300px" placeholder="请输入渠道响应码描述" :maxlength="200" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="启用状态：" prop="status">
                <Select v-model="formData.status" class="input-width-170" @on-change="chanStatus">
                  <Option value="0">不启用</Option>
                  <Option value="1">启用</Option>
                </Select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="备注说明：" prop="remark">
                <Input v-model="formData.remark" style="width: 300px" placeholder="请输入备注说明" :maxlength="20" />
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
    name: 'addChannelRespcode',
  data () {
    return {
      currentPage: 1,
      roleList: [],
      formData: {
        transStatus: 'TRADE_FAILURE',
        channelRespcode: '',
        channelRespdesc: '',
        status: '',
        remark: ''
      },
      ruleValidate: {
        channelRespcode: [
          {required: true, trigger: 'blur', message: '请输入渠道响应码'}
          // {pattern: /^[\u4e00-\u9fff\w]{1,200}$/, message: '不能输入特殊字符，且长度不超过200！'}
        ],
        channelRespdesc: [
          {required: true, trigger: 'blur', message: '请输入渠道响应码描述'}
        ],
        status: [
          {required: true, max: 12, trigger: 'blur', message: '请选择启用状态'}
        ],
        remark: [
          {required: true, trigger: 'blur', message: '请输入备注说明'}
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],
      // funcModal: false,
      funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init () {
    },
    handleSubmit () {
      let that = this
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.post('/channelRespcode', this.formData).then(function (res) {
            that.$Message.success('添加错误代码成功')
            that.goBack()
          })
        } else {
          that.$Message.error('请正确填写信息')
        }
      })
    },
    chanStatus (val) {
      this.formData.status = val
    },
    goBack () {
      // this.$util.goBack(this)
      this.$util.goBackByRouteName(this,"channelRespcodeList",true)
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
