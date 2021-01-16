<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form  :model="formData"  ref="formData" :label-width="150" :rules="ruleValidate">
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">添加客户资料</h4>
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
              <FormItem label="企业账户名称(佣金户)：" prop="entName">
                <Input v-model="formData.entName" style="width: 300px" placeholder="请输入企业账户名称" :maxlength="nameSize" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="企业账号(佣金户)：" prop="accountNo">
                <Input v-model="formData.accountNo" style="width: 300px" placeholder="请输入企业账号" :maxlength="accountSize" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="营业执照号：" prop="busLicCode">
                <Input v-model="formData.busLicCode" style="width: 300px" placeholder="请输入营业执照号" :maxlength="18" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="企业注册地址：" prop="regAddress">
                <Input v-model="formData.regAddress" style="width: 300px" placeholder="请输入企业注册地址" :maxlength="nameSize" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="法人姓名：" prop="legalPerson">
                <Input v-model="formData.legalPerson" style="width: 300px" placeholder="请输入法人姓名" :maxlength="nameSize" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="法人证件类型：" prop="idType">
                <i-select v-model="formData.idType" @on-change="idTypeChange" style="width: 300px" placeholder="请选择法人证件类型">
                  <i-option value="101">身份证</i-option>
                  <i-option value="102">护照</i-option>
                  <i-option value="103">军官证</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="法人证件号：" prop="idCode">
                <Input v-model="formData.idCode" :maxlength="20" style="width: 300px" placeholder="请输入法人证件号"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="国籍：" prop="nationality">
                <Select v-model="formData.nationality" @on-change = "nationalityChange" style="width: 300px" filterable>
                  <Option v-for="item in nationalityAry" :value="item.threeBitLetters" :key="item.id">{{item.chName}}</Option>
                </Select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="联系电话：" prop="phone">
                <Input v-model="formData.phone" :maxlength="20" style="width: 300px" placeholder="请输入联系电话"/>
              </FormItem>
            </Col>
            <Col span="12">

              <FormItem label="客户行业：" prop="customerTrade">
                <Select v-model="formData.customerTrade" @on-change = "codeChange" filterable style="width: 300px">
                  <Option v-for="item in codeAry" :value="item.code" :key="item.id">{{item.value}}({{item.code}})</Option>
                </Select>
              </FormItem>
<!--              <FormItem label="客户行业：" prop="customerTrade">-->
<!--                <Input v-model="formData.customerTrade" :maxlength="40" style="width: 300px" placeholder="请输入客户行业"/>-->
<!--              </FormItem>-->
            </Col>
<!--            <Col span="12">-->
<!--              <FormItem label="控股股东或实际控制人证明文件类型：" prop=" fileType">-->
<!--                <Input v-model="formData.fileType" :maxlength="128" style="width: 300px" placeholder="请输入控股股东证明文件类型"/>-->
<!--              </FormItem>-->
<!--            </Col>-->
<!--            <Col span="12">-->
<!--              <FormItem label="控股股东或实际控制人其他证明文件类型：" prop=" otherFileType">-->
<!--                <Input v-model="formData.otherFileType" :maxlength="128" style="width: 300px" placeholder="请输入控股股东其他证明文件类型"/>-->
<!--              </FormItem>-->
<!--            </Col>-->
<!--            <Col span="12">-->
<!--              <FormItem label="控股股东或实际控制人证明文件号码：" prop=" fileNum">-->
<!--                <Input v-model="formData.fileNum" :maxlength="128" style="width: 300px" placeholder="请输入控股股东证明文件号码"/>-->
<!--              </FormItem>-->
<!--            </Col>-->
          </row>
          <row>
            <Col span="12">
              <FormItem label="营业执照图片：" prop="busLicPic" style="width: 450px;">
                <Upload
                  :before-upload="licensePic"
                  :headers="headers"
                  :on-progress="onProgress"
                  :on-preview="findImg"
                  :on-exceeded-size="handleMaxSize"
                  :max-size="3072"
                  :show-upload-list="false"
                  :on-error="loadLost"
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
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="法人证件正面图片：" prop="personPic" style="width: 450px;">
                <Upload
                  :before-upload="idCardUpDataOne"
                  :headers="headers"
                  :on-progress="onProgress"
                  :on-preview="findImg"
                  :max-size="3072"
                  :on-exceeded-size="handleMaxSize"
                  :show-upload-list="false"
                  :on-error="loadLost"
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
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="法人证件反面图片：" prop="personReversePic" style="width: 450px;">
                <Upload
                  :before-upload="idCardUpDataTwo"
                  :headers="headers"
                  :on-progress="onProgress"
                  :on-preview="findImg"
                  :max-size="3072"
                  :on-exceeded-size="handleMaxSize"
                  :show-upload-list="false"
                  :on-error="loadLost"
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
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="开户许可证：" prop="licensePic" style="width: 450px;">
                <Upload
                  :before-upload="openingPermit"
                  :headers="headers"
                  :on-progress="onProgress"
                  :on-preview="findImg"
                  :max-size="3072"
                  :on-exceeded-size="handleMaxSize"
                  :show-upload-list="false"
                  :on-error="loadLost"
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
  name: 'addIndustryData',
  data () {
    return {
      busLicPicChange: false,
      personPicChange: false,
      personReversePicChange: false,
      licensePicChange: false,
      nationalityAry: [], // 国籍~
      codeAry: [], // 客户号~
      userId: null,
      type: null,
      currentPage: 1,
      roleList: [],
      uploadUrl: this.$contants.UploadImageUrl,
      addIndustryDataId: this.$route.params.id,
      formData: {
        id: this.$route.params.id,
        nationality: '',
        phone: '',
        customerTrade: '',
        // fileType: '',
        // otherFileType: '',
        // fileNum: '',
        legalPerson: '',
        entName: '',
        accountNo: '',
        busLicCode: '',
        regAddress: '',
        idType: '',
        idCode: '',
        busLicPic: '',
        personPic: '',
        personReversePic: '',
        licensePic: ''
      },
      ruleValidate: {
        customerTrade: [
          {required: true, trigger: 'blur', message: '请选择客户行业'}
        ],
        entName: [
          {required: true, trigger: 'blur', message: '请输入企业账户名称'}
        ],
        accountNo: [
          {required: true, trigger: 'blur', message: '请输入企业账号'}
        ],
        busLicCode: [
          {required: true, trigger: 'blur', message: '请输入营业执照号'},
          {pattern: /^[A-Z0-9]{18}$/, message: '只能输入18位数字和大写字母！'}
        ],
        regAddress: [
          {required: true, trigger: 'blur', message: '请输入企业注册地址'}
          // {pattern: /^[0-9]*$/, message: '请输入客户账户！'}
        ],
        legalPerson: [
          {required: true, trigger: 'blur', message: '请输入法人姓名！'}
          // {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入数字和字母！'}
        ],
        idType: [
          {required: true, trigger: 'change', message: '请选择法人证件类型！'}
          // {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        idCode: [
          {required: true, trigger: 'blur', message: '请输入法人证件号'},
          {pattern: /^[a-zA-Z0-9]{10}|\d{18}$ /, message: '只能输入10-20位！'}
        ],
        nationality: [
          {required: true, trigger: 'change', message: '请选择国籍'}
        ],
        phone: [
          {required: true, trigger: 'blur', message: '请输入联系电话'},
          {pattern: /^[0-9^%&',-;=?$\x22+]*$/, message: '只能输入数字！'}
        ],
        busLicPic: [
          {required: true, trigger: 'change', message: '请选择营业执照图片'}
        ],
        personPic: [
          {required: true, trigger: 'change', message: '请选择法人证件正面图片'}
        ],
        personReversePic: [
          {required: true, trigger: 'change', message: '请选择法人证件反面图片'}
        ],
        collectionAccount: [
          {required: true, trigger: 'change', message: '请选择手续费归集账户'}
        ],
        licensePic: [
          {required: false, trigger: 'change', message: '请选择开户许可证'}
        ]
      },
      tree: [{}],
      // funcModal: false,
      funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init () {
      if (this.addIndustryDataId){
        let self = this
        // let addIndustryDataId = localStorage.getItem('addIndustryDataId')
        this.$axios.get('/industry/' + this.addIndustryDataId).then(function (res) {
          if (res.data.busLicPic) {
            res.data.busLicPic = self.$contants.base64EchangeConf + res.data.busLicPic
          }
          if (res.data.personPic) {
            res.data.personPic = self.$contants.base64EchangeConf + res.data.personPic
          }
          if (res.data.personReversePic) {
            res.data.personReversePic = self.$contants.base64EchangeConf + res.data.personReversePic
          }
          if (res.data.licensePic) {
            res.data.licensePic = self.$contants.base64EchangeConf + res.data.licensePic
          }
          self.formData = res.data
        })
        this.$axios.post('/industry/countryList').then(function (res) {
          self.nationalityAry = res.data
        })
        let getQuery = {
          pageNo: 1,
          pageSize: 4500,
          parameters: {type: '0002'}
        }
        this.$axios.post('/codeDictionary/list', getQuery).then(function (res) {
          self.codeAry = res.data.list
        })
      }
    },
    nationalityChange (val) {
      this.formData.nationality = val
    },
    codeChange (val) {
      this.formData.customerTrade = val
    },
    licensePic: function (file) { // 营业执照
      this.formData.busLicPic = ''
      let reader = new FileReader()
      reader.readAsDataURL(file)
      if (file.size <= 3 * 1024 * 1024) {
        reader.onload = e => {
          this.busLicPicChange = true
          let _file = e.target.result
          this.formData.busLicPic = _file
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
          this.personPicChange = true
          let _file = e.target.result
          this.formData.personPic = _file
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
          this.personReversePicChange = true
          let _file = e.target.result
          this.formData.personReversePic = _file
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
          this.licensePicChange = true
          let _file = e.target.result
          this.formData.licensePic = _file
        }
      } else {
        this.formData.licensePic = ''
      }
    },
    onProgress: function (event, file, fileList) {
      // if (fileList.length >= 2) {
      //   this.$Message.error('只能添加一张图片')
      //   fileList.length = 1
      //   return false
      // }
    },
    findImg: function (file) {
      this.visible = true
      this.imgName = file.url
    },
    handleMaxSize: function (val, valList) {
      this.$Message.error('图片大小不能超过3072K')
      return false
    },
    idTypeChange: function (val) {
      this.formData.idType = val
    },
    handleSubmit () {
      debugger
      let that = this
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
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          let self = this
          // 图片没有修改的不需要上传
          if (self.busLicPicChange === false) {
            self.formData.busLicPic = ''
          }
          if (self.personPicChange === false) {
            self.formData.personPic = ''
          }
          if (self.personReversePicChange === false) {
            self.formData.personReversePic = ''
          }
          if (self.licensePicChange === false) {
            self.formData.licensePic = ''
          }
          this.$axios.put('industry/createIndustryAccountInfo', self.formData).then(function (res) {
            that.$Message.success('添加代付客户资料成功')
            that.goBack()
          })
        } else {
          that.$Message.error('请正确填写信息')
          if (that.formData.busLicPic) {
            that.formData.busLicPic = 'data:image/jpeg;base64,' + that.formData.busLicPic
          }
          if (that.formData.personPic) {
            that.formData.personPic = 'data:image/jpeg;base64,' + that.formData.personPic
          }
          if (that.formData.personReversePic) {
            that.formData.personReversePic = 'data:image/jpeg;base64,' + that.formData.personReversePic
          }
          if (that.formData.licensePic) {
            that.formData.licensePic = 'data:image/jpeg;base64,' + that.formData.licensePic
          }
        }
      })
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    // 用这个对象
    // this.cityList = cityList
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
    },
    nameSize () {
      return this.$contants.pageSet.nameSize
    },
    accountSize () {
      return this.$contants.pageSet.accountSize
    }
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'addIndustryData', this.$route.params.id)
    if (this.addIndustryDataId !== initParamVal) {
      this.addIndustryDataId = initParamVal
      this.init()
    }
  }
}
</script>
