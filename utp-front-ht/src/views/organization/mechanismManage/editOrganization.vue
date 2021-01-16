<style lang="less">
    .footer-border{
        padding:0;
        border:none;
    }
</style>
<template>
  <card>
    <Form  :model="formData"  ref="formData" :label-width="120" :rules="ruleValidate">
      <i style="height: 10px"></i>
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">编辑机构</h4>
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
            <FormItem label="机构名称：" prop="fullName">
              <Input v-model="formData.fullName" style="width: 300px" placeholder="请输入机构名称" :maxlength="200" />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="机构简称：" prop="simpleName">
              <Input v-model="formData.simpleName" style="width: 300px" placeholder="请输入机构简称" :maxlength="200" />
            </FormItem>
          </Col>
          </row>
          <row>
          <Col span="12">
            <FormItem label="机构代码：" prop="orgCode">
              <Input v-model="formData.orgCode" :disabled="true" style="width: 300px" placeholder="请输入机构代码" :maxlength="12" />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="联系人姓名：" prop="contactName">
              <Input v-model="formData.contactName" style="width: 300px" placeholder="请输入联系人姓名" :maxlength="20" />
            </FormItem>
          </Col>
          </row>
          <row>
          <Col span="12">
            <FormItem label="联系人电话：" prop="contactTel">
              <Input v-model="formData.contactTel" style="width: 300px" placeholder="请输务联系人电话" :maxlength="20" />
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="联系人邮箱：" prop="contactEmail">
              <Input v-model="formData.contactEmail" style="width: 300px" placeholder="请输入联系人邮箱" :maxlength="50" />
            </FormItem>
          </Col>
          </row>

          <row>
          <Col span="12">
            <FormItem label="联系人地址：" prop="contactAddr">
              <Input v-model="formData.contactAddr" style="width: 300px" placeholder="请输入联系人地址" :maxlength="200" />
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
<script>import cityList from '../../../libs/content'
export default {
  name: 'editOrganization',
  data () {
    return {
      constantsImg: this.$contants.BaseImageUrl,
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
      organizationId: this.$route.params.id,
      uploadUrl: this.$contants.UploadImageUrl,
      userId: null,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {
        parentId: '',
        fullName: '',
        simpleName: '',
        orgCode: '',
        contactName: '',
        contactTel: '',
        contactEmail: '',
        contactAddr: ''
      },
      ruleValidate: {
        fullName: [
          {required: true, trigger: 'blur', message: '请输入机构名称'}
          // {pattern: /^[\u4e00-\u9fff\w]{1,200}$/, message: '不能输入特殊字符，且长度不超过200！'}
        ],
        simpleName: [
          // {pattern: /^[\u4e00-\u9fff\w]{1,200}$/, message: '不能输入特殊字符，且长度不超过200！'}
        ],
        orgCode: [
          {required: true, max: 12, trigger: 'blur', message: '请输入机构代码！'}
          // {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字，且长度不超过12！'}
        ],
        contactName: [
          {required: true, trigger: 'blur', message: '请输入联系人姓名'},
          {pattern: /^[\u4e00-\u9fff\w]{1,20}$/, message: '不能输入特殊字符，且长度不超过20！'}
        ],
        contactTel: [
          {required: true, trigger: 'blur', min: 5, max: 20, message: '请输入联系人电话(5-20位数字)'}
          // {pattern: /\+?[\d]{3,20}(-?)[\d]{2,20}$/, trigger: 'blur', message: '请输入正确电话号码(5-20位数字)'}
        ],
        contactEmail: [
          {required: true, trigger: 'blur', message: '请输入联系人邮箱'},
          {pattern: /^[a-zA-Z0-9]+([._\\-]*[a-zA-Z0-9])*@([a-zA-Z0-9]+[-a-zA-Z0-9]*[a-zA-Z0-9]+.){1,63}[a-zA-Z0-9]+$/, message: '请输入正确邮箱！'}
        ],
        contactAddr: [
          {required: false, trigger: 'blur', message: '请输入业务联系人地址'}
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],
      provinceAry: [],
      cityAry: [],
      countyAry: [],
      disCity: false,
      disCounty: false,
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
      this.provinceAry = this.cityList.China.province
      if (this.organizationId) {
        this.getOrganizationDetail()
      }
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
      this.$axios.get('organization' + '/' + this.organizationId)
        .then(function (response) {
          self.formData = response.data
          self.idChangeStartGet = response.data.idcardStartDate
          self.idChangeEndGet = response.data.idcardEndDate
          self.setupStartGet = response.data.setupStartDate
          self.setupEndGet = response.data.setupEndDate
          if (response.data.legalIdcardPic) {
            self.idImg = response.data.legalIdcardPic
            // var idCardPic = [{
            //   name: response.data.legalIdcardPic,
            //   url: response.data.legalIdcardPic
            // }]
          }
          if (response.data.businessLicensePic) {
            self.licenseImg = response.data.businessLicensePic
            // var LicensePicList = [{
            //   name: response.data.businessLicensePic,
            //   url: response.data.businessLicensePic
            // }]
          }
          if (response.data.orgCodeCertPic) {
            self.orgImg = response.data.orgCodeCertPic
            // var orgPicList = [{
            //   name: response.data.legalIdcardPic,
            //   url: response.data.legalIdcardPic
            // }]
          }
          if (response.data.taxRegCertPic) {
            self.taxImg = response.data.taxRegCertPic
            // var taxRegList = [{
            //   name: response.data.taxRegCertPic,
            //   url: response.data.taxRegCertPic
            // }]
          }
          if (response.data.accountOpenLicensePic) {
            self.accountImg = response.data.accountOpenLicensePic
            // var accouOpenList = [{
            //   name: response.data.accountOpenLicensePic,
            //   url: response.data.accountOpenLicensePic
            // }]
          }

          // self.idCardPic = idCardPic
          // self.LicensePicList = LicensePicList
          // self.orgPicList = orgPicList
          // self.taxRegList = taxRegList
          // self.accouOpenList = accouOpenList
          if (!response.data.provinceCode) {
            self.getProvince = '请选择省份'
          }
          self.provinceAry.forEach(function (e, i) {
            let that = self
            if (e.id === response.data.provinceCode) {
              that.getProvince = e.name
              if (response.data.cityCode && response.data.cityCode !== '0') {
                that.disCity = true
                that.cityAry = that.provinceAry[i].city
                that.provinceAry[i].city.forEach(function (e, i) {
                  if (e.id === response.data.cityCode) {
                    that.disCounty = true
                    that.getCity = e.name
                    that.countyAry = e.county
                    e.county.forEach(function (e, i) {
                      if (response.data.countyCode === e.id) {
                        that.getCounty = e.name
                      }
                    })
                  }
                })
              } else {
                that.disCounty = true
                that.countyAry = that.provinceAry[i].city.county
                that.provinceAry[i].city.county.forEach(function (e, i) {
                  if (response.data.countyCode === e.id) {
                    that.getCounty = e.name
                  }
                })
              }
            }
          })
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    idChangeStart: function (val) {
      this.formData.idcardStartDate = val
      let dateGet = new Date(val)
      this.idEndData = {
        disabledDate (date) {
          if (dateGet.valueOf() > Date.now() - 86400000) {
            return date && date.valueOf() < dateGet && dateGet.valueOf()
          } else {
            return date && date.valueOf() < Date.now() - 86400000
          }
        }
      }
    },
    idChangeEnd: function (val) {
      this.formData.idcardEndDate = val
      let dateGet = new Date(val)
      this.idStartData = {
        disabledDate (date) {
          return date && date.valueOf() > dateGet.valueOf()
        }
      }
    },
    setupStart: function (val) {
      this.formData.setupStartDate = val
      let dateGet = new Date(val)
      this.setupEndData = {
        disabledDate (date) {
          if (dateGet.valueOf() > Date.now() - 86400000) {
            return date && date.valueOf() < dateGet && dateGet.valueOf()
          } else {
            return date && date.valueOf() < Date.now() - 86400000
          }
        }
      }
    },
    setupEnd: function (val) {
      this.formData.setupEndDate = val
      let dateGet = new Date(val)
      this.setupStartData = {
        disabledDate (date) {
          return date && date.valueOf() > dateGet.valueOf()
        }
      }
    },
    handleMaxSize: function () {
      this.$Message.error('图片大小不能超过500k')
    },
    loadLost: function () {
      this.$Message.error('上传失败')
    },
    idCard: function (val) {
      this.formData.legalIdcardPic = val
      this.idImg = val
    },
    licensePic: function (val) {
      this.formData.businessLicensePic = val
      this.licenseImg = val
    },
    orgPic: function (val) {
      this.formData.orgCodeCertPic = val
      this.orgImg = val
    },
    taxRegPic: function (val) {
      this.formData.taxRegCertPic = val
      this.taxImg = val
    },
    accOpenPic: function (val) {
      this.formData.accountOpenLicensePic = val
      this.accountImg = val
    },
    provinceChange: function (val) {
      var provinceId = val
      this.formData.provinceCode = val
      // this.getCity = '请选择城市'
      this.formData.cityCode = ''
      var that = this
      that.disCity = false
      that.disCounty = false
      this.provinceAry.forEach(function (e, i) {
        if (provinceId === e.id) {
          if (e.city.length > 0) {
            that.disCity = true
            that.cityAry = e.city
          } else {
            that.disCounty = true
            that.countyAry = e.city.county
            that.formData.countyCode = ''
          }
        }
      })
    },
    cityChange (val) {
      var cityId = val
      var that = this
      this.formData.cityCode = val
      this.formData.countyCode = ''
      this.cityAry.forEach(function (e, i) {
        if (cityId === e.id) {
          that.disCounty = true
          that.countyAry = e.county
          // that.countyChange(e.county[0].id)
        }
      })
    },
    countyChange (val) {
      this.formData.countyCode = val
    },
    findImg: function (file) {
      this.visible = true
      this.imgName = file.url
    },
    handleSubmit () {
      if (this.formData.provinceCode === '01' || this.formData.provinceCode === '02' || this.formData.provinceCode === '03' || this.formData.provinceCode === '04') {
        this.formData.cityCode = '0'
      }
      let that = this
      this.formData.idcardStartDate = this.idChangeStartGet
      this.formData.idcardEndDate = this.idChangeEndGet
      this.formData.setupStartDate = this.setupStartGet
      this.formData.setupEndDate = this.setupEndGet
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.put('/organization', this.formData).then(function (res) {
            that.$Message.success('修改机构成功')
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
    this.cityList = cityList
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
    }
  },
  mounted () {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'editOrganization', this.$route.params.id)
    if (this.organizationId !== initParamVal) {
      this.organizationId = initParamVal
      this.init()
    }
  }
}
</script>

