<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form  :model="formDataNew"  ref="formDataNew" :label-width="120" :rules="ruleValidate">
      <i style="height: 10px"></i>
      <row>
        <Col span="24">
          <Col span="12">
            <FormItem label="类型：" prop="objType">
              <i-select v-model="formDataNew.objType" :disabled="true" style="width:350px" placeholder="请选择类型">
                <i-option value="1">个人</i-option>
                <i-option value="2">企业</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="12" v-if="objTypeGr">
            <FormItem label="姓名：" prop="name">
              <Input v-model="formDataNew.name" style="width:350px" placeholder="请输入姓名" :maxlength="100"  />
            </FormItem>
          </Col>
          <Col span="12" v-if="objTypeGr">
            <FormItem label="身份证号：" prop="idCode">
              <Input v-model="formDataNew.idCode" :disabled="true" style="width:350px" :maxlength="18" placeholder="请输入身份证号" />
            </FormItem>
          </Col>
          <Col span="12" v-if="objTypeQy">
            <FormItem label="企业名称：" prop="entName">
              <Input v-model="formDataNew.entName" style="width:350px" placeholder="请输入企业名称" :maxlength="200"  />
            </FormItem>
          </Col>
          <Col span="12" v-if="objTypeQy">
            <FormItem label="营业执照编号：" prop="busLicCode">
              <Input v-model="formDataNew.busLicCode" :disabled="true" style="width:350px" :maxlength="32" placeholder="请输入身份证号" />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="备注：" prop="remark">
              <Input v-model="formDataNew.remark"  style="width:350px" placeholder="请输入备注" :maxlength="1000"  />
            </FormItem>
          </Col>
        </Col>
      </row>
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
  name: "editblacklist",
  data () {
    return {
      objTypeGr: true,
      objTypeQy: false,
      funcModal: false,
      funcModalShow: false, // 用来更新数据
      formDataNew: {
        id: '',
        objType: '',
        name: '',
        busLicCode: '',
        idCode: '',
        remark: '',
        entName: '',
      },
      ruleValidate: {
        name: [
          {required: true, trigger: 'change', message: '请输入姓名'}
        ],
        entName: [
          {required: true, trigger: 'change', message: '请输入企业名称'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字'}
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}]
    }
  },
  methods: {
    init () {
      if (this.$route.params.id) {
        this.formDataNew.id = this.$route.params.id
        this.formDataNew.objType = this.$route.params.objType
        this.formDataNew.name = this.$route.params.name
        this.formDataNew.busLicCode = this.$route.params.busLicCode
        this.formDataNew.idCode = this.$route.params.idCode
        this.formDataNew.remark = this.$route.params.remark
        this.formDataNew.entName = this.$route.params.entName
        sessionStorage.setItem('editblacklist.formDataNew',JSON.stringify(this.formDataNew))
      } else {
        this.formDataNew = sessionStorage.getItem('editblacklist.formDataNew')
      }

      if (this.formDataNew.objType === '1') {
        this.objTypeGr = true
        this.objTypeQy = false
        this.$refs.formDataNew.rules.name = [{required: true, trigger: 'change', message: '请输入姓名'}]
        this.$refs.formDataNew.rules.entName = [{required: false, trigger: 'change', message: '请输入企业名称'}]
      } else {
        this.objTypeGr = false
        this.objTypeQy = true
        this.$refs.formDataNew.rules.name = [{required: false, trigger: 'change', message: '请输入姓名'}]
        this.$refs.formDataNew.rules.entName = [{required: true, trigger: 'change', message: '请输入企业名称'}]
      }
    },
    handleSubmit () {
      let that = this
      this.formDataNew.operationType = '1'
      this.$refs['formDataNew'].validate((valid) => {
        if (valid) {
          that.$axios.post('/blacklistApr', this.formDataNew).then(function (res) {
            that.$Message.success('编辑分账黑名单成功')
            that.goBack()
          }).catch(function () {
            // that.$Message.error('编辑分账黑名单失败')
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
    let initParamVal = this.$util.getRefreshInitParam(this, 'editblacklist', this.$route.params.id)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.init()
    }
  }
}
</script>
