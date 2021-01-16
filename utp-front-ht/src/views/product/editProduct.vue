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
          <h4 style="display:inline">编辑支付产品</h4>
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
              <FormItem label="支付产品编码：" prop="code">
                <Input v-model="formData.code" style="width: 300px;"   placeholder="请输入支付产品编码" :disabled="true" :maxlength="10" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="支付产品名称：" prop="name">
                <Input v-model="formData.name" style="width: 300px;"  placeholder="请输入支付产品名称" :maxlength="nameSize" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="是否可用：" prop="status">
                <i-select v-model="formData.status" style="width:300px" @on-change="statusChange" >
                  <i-option v-for="item in statusAry" :value="item.value" :key="item.id">{{ item.name }}</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="备注信息：" prop="remark">
                <Input v-model="formData.remark" style="width: 300px;" placeholder="请输入备注信息" :maxlength="500" />
              </FormItem>
            </Col>
          </Row>
          <Row>
          </Row>

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
    <!--<Modal title="查看图片" v-model="visible">-->
      <!--<img :src="'http://132.232.16.103:8088' + imgName" v-if="visible" style="width: 100%">-->
    <!--</Modal>-->
  </card>
</template>
<script>
export default {
  name: "editProduct",
  // components: {
  //   funcList: funcList
  // },
  data () {
    return {
      constantsImg: this.$contants.BaseImageUrl,
      statusAry: [{name: '启用', value: '1'}, {name: '禁用', value: '0'}],
      idStartData: {},
      idEndData: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000
        }
      },
      setupStartData: {},
      setupEndData: {},
      cityList: {},
      idImg: '',
      licenseImg: '',
      taxImg: '',
      orgImg: '',
      accountImg: '',
      getProvince: '',
      getCity: '',
      getCounty: '',
      imgName: '',
      visible: false, // 查看图片
      productId: this.$route.params.id,
      uploadUrl: this.$contants.UploadImageUrl,
      userId: null,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {
        code: '',
        id: this.productId,
        gmtCreate: '',
        gmtModified: '',
        name: '',
        remark: '',
        status: '',
        userCreate: '',
        userModified: ''
      },
      ruleValidate: {
        code: [
          {required: true, trigger: 'blur', message: '请输入产品编码'},
          {pattern: /^[0-9a-zA-Z]+$/, message: '只能输入字母和数字，且长度不超过10！'}
        ],
        name: [
          {required: true, trigger: 'blur', message: '请输入产品名称，且长度不超过100！'}
          // {pattern: /^[\u4e00-\u9fff\w]{1,200}$/, message: '不能输入特殊字符，且长度不超过100！'}
        ],
        status: [
          {required: true, trigger: 'blur', message: '请选择产品状态'}
        ]
        // remark: [
        //   {required: true, trigger: 'blur', message: '请输入备注！'}
        // ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],
      funcModal: false,
      funcModalShow: false, // 用来更新数据
      idCardPic: [],
      LicensePicList: [],
      orgPicList: [],
      taxRegList: [],
      accouOpenList: [],
      idChangeStartGet: '',
      idChangeEndGet: '',
      setupStartGet: '',
      setupEndGet: ''
    }
  },

  methods: {
    init () {
      if (this.productId) {
        this.getOrganizationDetail()
      }
    },
    statusChange: function (val) {
      this.formData.status = val
    },
    onProgress: function (event, file, fileList) {
      // if (fileList.length >= 2) {
      //   this.$Message.error('只能添加一张图片')
      //   fileList.length = 1
      //   return false
      // }
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('payProduct' + '/' + this.productId)
        .then(function (response) {
          self.formData = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    handleSubmit () {
      let that = this
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.put('/payProduct', this.formData).then(function (res) {
            that.$Message.success('修改支付产品成功')
            that.goBack()
          })
        } else {
          that.$Message.error('请正确填写信息')
        }
      })
    },
    goBack () {
      this.$util.goBack(this)
    },
    // 打开功能点选择
    openFuncModal () {
      if (this.type !== 'edit') {
        this.funcModalShow = true
      }
      this.funcModal = !this.funcModal
    },

    // 获取到选中的数据
    checkFunc (data) {
      // 监听子组件funcList的事件，接收data
      this.funcTableData = data
      this.funcModal = !this.funcModal
    }
  },
  created () {
    this.init()
  },
  computed: {
    headers () {
      if (!this.$store.state.app.token) {
        this.$store.commit('setToken', localStorage.getItem('token'))
      }
      return {
        'X-Requested-With': 'XMLHttpRequest',
        'X-Authorization': 'Bearer ' + this.$store.state.app.token
      }
    },
    nameSize () {
      return this.$contants.pageSet.nameSize
    },
    accountSize () {
      return this.$contants.pageSet.accountSize
    }
  },
  mounted () {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'editProduct', this.$route.params.id)
    if (this.productId !== initParamVal) {
      this.productId = initParamVal
      this.init()
    }
  }
}
</script>
