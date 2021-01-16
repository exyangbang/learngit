<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form  :model="formData"  ref="formData" :label-width="150" >
        <Form :label-width="150">
          <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">更新图片资料</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="24">
          <row>
            <Col span="12">
              <FormItem label="营业执照图片：" prop="busLicPic" style="width: 450px;">
                <Upload
                  :before-upload="licensePic"
                  :headers="headers"
                  :on-preview="findImg"
                  :on-exceeded-size="handleMaxSize"
                  :max-size="3072"
                  :show-upload-list="false"
                  :format="['jpg','jpeg','png','gif']"
                  accept=".jpg,.jpeg,.png,.gif"
                  type="drag"
                  v-model="formData.busLicPic"
                  action="">
                  <div style="padding: 20px 0">
                    <img :src=this.formData.busLicPic  style="width: 300px; margin: 0 auto">
                    <p>点击或拖拽上传图片<em style="color: #ff3300">仅支持 'jpg','jpeg','png','gif'</em></p>
                  </div>
                </Upload>
                <i-button type="primary" @click = "getImg(formData.busLicPic)" style="margin-top: 10px">查看原图</i-button>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="法人证件正面图片：" prop="personPic" style="width: 450px;">
                <Upload
                  :before-upload="idCardUpDataOne"
                  :headers="headers"
                  :on-preview="findImg"
                  :max-size="3072"
                  :on-exceeded-size="handleMaxSize"
                  :show-upload-list="false"
                  :format="['jpg','jpeg','png','gif']"
                  accept=".jpg,.jpeg,.png,.gif"
                  type="drag"
                  action=""
                  v-model="formData.personPic">
                  <div style="padding: 20px 0">
                    <img :src=this.formData.personPic style="width: 300px; margin: 0 auto">
                    <p>点击或拖拽上传图片<em style="color: #ff3300">仅支持 'jpg','jpeg','png','gif'</em></p>
                  </div>
                </Upload>
                <i-button type="primary" @click = "getImg(formData.personPic)" style="margin-top: 10px">查看原图</i-button>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="法人证件反面图片：" prop="personReversePic" style="width: 450px;">
                <Upload
                  :before-upload="idCardUpDataTwo"
                  :headers="headers"
                  :on-preview="findImg"
                  :max-size="3072"
                  :on-exceeded-size="handleMaxSize"
                  :show-upload-list="false"
                  :format="['jpg','jpeg','png','gif']"
                  accept=".jpg,.jpeg,.png,.gif"
                  type="drag"
                  action=""
                  v-model="formData.personReversePic">
                  <div style="padding: 20px 0">
                    <img :src=this.formData.personReversePic style="width: 300px; margin: 0 auto">
                    <p>点击或拖拽上传图片<em style="color: #ff3300">仅支持 'jpg','jpeg','png','gif'</em></p>
                  </div>
                </Upload>
                <i-button type="primary" @click = "getImg(formData.personReversePic)" style="margin-top: 10px">查看原图</i-button>
              </FormItem>
            </Col>
            <Col span="12" >
              <FormItem label="开户许可证：" prop="licensePic" style="width: 450px;" v-if="modify">
                <Upload
                  :before-upload="openingPermit"
                  :headers="headers"
                  :on-preview="findImg"
                  :max-size="3072"
                  :on-exceeded-size="handleMaxSize"
                  :show-upload-list="false"
                  :format="['jpg','jpeg','png','gif']"
                  accept=".jpg,.jpeg,.png,.gif"
                  type="drag"
                  action=""
                  v-model="formData.licensePic">
                  <div style="padding: 20px 0">
                    <img :src=this.formData.licensePic style="width: 300px; margin: 0 auto">
                    <p>点击或拖拽上传图片<em style="color: #ff3300">仅支持 'jpg','jpeg','png','gif'</em></p>
                  </div>
                </Upload>
                <i-button type="primary" @click = "getImg(formData.licensePic)" style="margin-top: 10px">查看原图</i-button>
              </FormItem>
            </Col>
          </row>
        </Col>
      </Row>
      <Row>
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
    <Modal title="查看图片" v-model="visible">
      <img v-if="disImg" :src="this.constantsImg + imgName" style="width: 100%">
      <p v-if="disTex">未上传图片</p>
    </Modal>
    </Form>
  </card>
</template>
<script>
export default {
  name: 'modifyMerchantInfo',
  data () {
    return {
      isupload: false, // 至少更新一张图片
      disImg: false,
      disTex: false,
      imgBase: '',
      visible: false,
      constantsImg: '',
      imgName: '',
      id: this.$route.params.id,
      modify: this.$route.params.modify,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {
        id: this.$route.params.id,
        busLicPic: '',
        personPic: '',
        personReversePic: '',
        licensePic: ''
      },
      provinceAry: [],
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],
      funcModal: false,
      funcModalShow: false, // 用来更新数据
      disSimpleName: false,
      disContAddre: false,
      disRegisteredCapital: false,
      disOrgCodeCertPic: false,
      disTaxRegCertPic: false
    }
  },
  methods: {
    init () {
      if (this.id) {
        this.getOrganizationDetail()
      }
    },
    getImg (val) {
      this.visible = true
      this.constantsImg = val
      // if (this.constantsImg.indexOf('null') >= 0) {
      if (this.constantsImg.length < 30) {
        this.disTex = true
        this.disImg = false
      } else {
        this.disTex = false
        this.disImg = true
      }
    },
    handleMaxSize: function (val, valList) {
      this.$Message.error('图片大小不能超过3072K')
      return false
    },
    findImg: function (file) {
      this.visible = true
      this.imgName = file.url
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('/merchantInfo/' + this.id)
        .then(function (response) {
          self.formData = response.data
          if (response.data.idType === '101') {
            response.data.idType = '身份证'
          }
          if (response.data.idType === '102') {
            response.data.idType = '护照'
          }
          if (response.data.idType === '103') {
            response.data.idType = '军官证'
          }
          self.formData.busLicPic = self.$contants.base64EchangeConf + self.formData.busLicPic
          self.formData.personPic = self.$contants.base64EchangeConf + self.formData.personPic
          self.formData.personReversePic = self.$contants.base64EchangeConf + self.formData.personReversePic
          self.formData.licensePic = self.$contants.base64EchangeConf + self.formData.licensePic
          self.funcTableData = response.data.roleList
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    licensePic: function (file) { // 营业执照
      this.formData.busLicPic = ''
      let reader = new FileReader()
      reader.readAsDataURL(file)
      if (file.size <= 3 * 1024 * 1024) {
        reader.onload = e => {
          let _file = e.target.result
          this.formData.busLicPic = _file
          this.isupload = true
        }
      } else {
        this.formData.busLicPic = ''
      }
    },
    idCardUpDataOne: function (file) { // 法人证件正面图片
      this.formData.personPic = ''
      let reader = new FileReader()
      reader.readAsDataURL(file)
      if (file.size <= 3 * 1024 * 1024) {
        reader.onload = e => {
          let _file = e.target.result
          this.formData.personPic = _file
          this.isupload = true
        }
      } else {
        this.formData.personPic = ''
      }
    },
    idCardUpDataTwo: function (file) { // 法人证件反面图片
      this.formData.personReversePic = ''
      let reader = new FileReader()
      reader.readAsDataURL(file)
      if (file.size <= 3 * 1024 * 1024) {
        reader.onload = e => {
          let _file = e.target.result
          this.formData.personReversePic = _file
          this.isupload = true
        }
      } else {
        this.formData.personReversePic = ''
      }
    },
    openingPermit: function (file) { // 开户许可证
      this.formData.licensePic = ''
      let reader = new FileReader()
      reader.readAsDataURL(file)
      if (file.size <= 3 * 1024 * 1024) {
        reader.onload = e => {
          let _file = e.target.result
          this.formData.licensePic = _file
          this.isupload = true
        }
      } else {
        this.formData.licensePic = ''
      }
    },
    handleSubmit () {
      let that = this
      if (this.isupload === false) {
        this.$Message.error('请至少更新一张图片')
        return
      }
      if (this.formData.busLicPic) {
        this.formData.busLicPic = this.formData.busLicPic.split(',')[1]
      }
      if (this.formData.personPic) {
        this.formData.personPic = this.formData.personPic.split(',')[1]
      }
      if (this.formData.personReversePic) {
        this.formData.personReversePic = this.formData.personReversePic.split(',')[1]
      }
      if (this.formData.licensePic) {
        this.formData.licensePic = this.formData.licensePic.split(',')[1]
      }
      if (!this.formData.busLicPic && !this.formData.personPic &&
         !this.formData.personReversePic && !this.formData.licensePic) {
        that.$Message.error('请至少上传一张图片')
        return
      }
      this.$axios.put('/merchantInfo', this.formData).then(function (res) {
        that.$Message.success('资料更新成功')
        that.goBack()
      })
      // this.$refs['formData'].validate((valid) => {
      //   if (valid) {
      //     let self = this
      //     this.$axios.put('/merchantInfo', self.formData).then(function (res) {
      //       that.$Message.success('资料更新成功')
      //       that.goBack()
      //     })
      //   } else {
      //     that.$Message.error('请正确填写信息')
      //     if (that.formData.busLicPic) {
      //       that.formData.busLicPic = 'data:image/jpeg;base64,' + that.formData.busLicPic
      //     }
      //     if (that.formData.personPic) {
      //       that.formData.personPic = 'data:image/jpeg;base64,' + that.formData.personPic
      //     }
      //     if (that.formData.personReversePic) {
      //       that.formData.personReversePic = 'data:image/jpeg;base64,' + that.formData.personReversePic
      //     }
      //     if (that.formData.licensePic) {
      //       that.formData.licensePic = 'data:image/jpeg;base64,' + that.formData.licensePic
      //     }
      //   }
      // })
    },
    goBack () {
      this.$util.goBack(this)
    }
  },

  created () {
    this.init()
  },
  computed: {
    legalIdcardPic () {
      let imgUrl = this.constantsImg + (this.formData.legalIdcardPic ? this.formData.legalIdcardPic : '')
      return imgUrl
    },
    businessLicensePic () {
      let imgUrl = this.constantsImg + (this.formData.businessLicensePic ? this.formData.businessLicensePic : '')
      return imgUrl
    },
    orgCodeCertPic () {
      let imgUrl = this.constantsImg + (this.formData.orgCodeCertPic ? this.formData.orgCodeCertPic : '')
      return imgUrl
    },
    taxRegCertPic () {
      let imgUrl = this.constantsImg + (this.formData.taxRegCertPic ? this.formData.taxRegCertPic : '')
      return imgUrl
    },
    accountOpenLicensePic () {
      let imgUrl = this.constantsImg + (this.formData.accountOpenLicensePic ? this.formData.accountOpenLicensePic : '')
      return imgUrl
    },
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
    let initParamVal = this.$util.getRefreshInitParam(this, 'modifyMerchantInfoId', this.$route.params.id)
    let mid = this.$util.getRefreshInitParam(this, 'modifyMerchantInfoModify', this.$route.params.modify)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.modify = mid
      this.init()
    }
  }
}
</script>
