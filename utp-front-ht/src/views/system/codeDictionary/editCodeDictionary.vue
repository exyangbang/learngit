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
          <h4 style="display:inline">编辑数据字典</h4>
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
              <FormItem label="类型代码：" >
                <Input v-model="formData.type" style="width: 300px" placeholder="请输入类型代码" :maxlength="200" disabled="none"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="类型名称：" >
                <Input v-model="formData.typeName" style="width: 300px" placeholder="请输入类型名称" :maxlength="100" disabled="none"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="子项目编码：" prop="code">
                <Input v-model="formData.code" style="width: 300px" placeholder="请输入子项目编码" :maxlength="100" disabled="none"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="子项目含义：" prop="value">
                <Input v-model="formData.value" style="width: 300px" placeholder="请输子项目含义" :maxlength="1000" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="备注说明：" prop="remark">
                <Input v-model="formData.remark" style="width: 300px" placeholder="请输入备注说明" :maxlength="1000" />
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
  name: 'editCodeDictionary',
  data () {
    return {
      currentPage: 1,
      roleList: [],
      formData: {
        id: this.$route.params.id,
        type: '',
        typeName: '',
        code: '',
        value: '',
        remark: ''
      },
      ruleValidate: {
        type: [
          {required: true, trigger: 'blur', message: '请选择类型代码'}
          // {pattern: /^[\u4e00-\u9fff\w]{1,200}$/, message: '不能输入特殊字符，且长度不超过200！'}
        ],
        code: [
          {required: true, trigger: 'blur', message: '请输入子项目编码'}
        ],
        value: [
          {required: true, trigger: 'blur', message: '请输入子项目含义'}
        ]
      }
    }
  },
  methods: {
    init () {
      if (this.formData.id) {
        this.getCodeDictionaryDetail()
      }
    },
    getCodeDictionaryDetail () {
      let self = this
      this.$axios.get('codeDictionary/' + this.formData.id)
        .then(function (response) {
          self.formData = response.data
          switch (self.formData.type) {
            case '0001':
              self.formData.typeName = '支付机构编码表'
              break
            case '0002':
              self.formData.typeName = '行业分类表'
              break
            case '0003':
              self.formData.typeName = '职业分类表'
              break
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    handleSubmit () {
      let that = this
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.put('/codeDictionary', this.formData).then(function (res) {
            that.$Message.success('修改数据字典成功')
            that.goBack()
          })
        } else {
          that.$Message.error('请正确填写信息')
        }
      })
    },
    objTypeChange (val) {
      this.formData.type = val
      switch (val) {
        case '0001':
          this.formData.typeName = '支付机构编码表'
          break
        case '0002':
          this.formData.typeName = '行业分类表'
          break
        case '0003':
          this.formData.typeName = '职业分类表'
          break
      }
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
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'editCodeDictionary', this.$route.params.id)
    if (this.formData.id !== initParamVal) {
      this.formData.id = initParamVal
      this.init()
    }
  }
}
</script>
