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
          <h4 style="display:inline">新增机构</h4>
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
              <Input v-model="formData.orgCode" style="width: 300px" placeholder="请输入机构代码" :maxlength="12" />
            </FormItem>
            </Col>
              <!--<Col span="12">-->
                <!--<FormItem label="所属省直辖市：" prop="provinceCode">-->
                  <!--<i-select v-model="formData.provinceCode"  style="width:200px" @on-change="provinceChange">-->
                    <!--<i-option v-for="item in provinceAry"  :key="item.id" :value="item.id">{{ item.name }}</i-option>-->
                  <!--</i-select>-->
                <!--</FormItem>-->
              <!--</Col>-->

          <!--</row>-->
          <!--<Row>-->
            <!--<Col span="12">-->
          <!--<FormItem label="所属城市：" prop="cityCode" v-show="disCity">-->
            <!--<i-select v-model="formData.cityCode"  style="width:200px" @on-change="cityChange">-->
              <!--<i-option v-for="item in cityAry" :key="item.id" :value="item.id">{{ item.name }}</i-option>-->
            <!--</i-select>-->
          <!--</FormItem>-->
            <!--</Col>-->
            <!--<Col span="12">-->
            <!--<FormItem label="所属县区：" prop="countyCode" v-show="disCounty">-->
              <!--<i-select v-model="formData.countyCode"  style="width:200px" @on-change="countyChange">-->
                <!--<i-option v-for="item in countyAry" :key="item.id" :value="item.id">{{ item.name }}</i-option>-->
              <!--</i-select>-->
            <!--</FormItem>-->
            <!--</Col>-->
          <!--<Row>-->
            <!--<Col span="24">-->
              <!--<h4 style="display:inline">资质资料</h4>-->
              <!--<Button type="ghost" style="opacity: 0;cursor: default" >返回</Button>-->
            <!--</Col>-->
          <!--</Row>-->
          <!--<br>-->
          <!--<hr>-->
          <!--<br>-->
          <!--<Row>-->
          <!--<Col span="12">-->
            <!--<FormItem label="注册资本(元)：" prop="registeredCapital">-->
              <!--<Input v-model="formData.registeredCapital" placeholder="请输入注册资本（元）" :maxlength="15" />-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--<Col span="12">-->
            <!--<FormItem label="法人姓名：" prop="legalName">-->
              <!--<Input v-model="formData.legalName" placeholder="请输入法人姓名" :maxlength="20" />-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--</Row>-->
          <!--<Row>-->
          <!--<Col span="12">-->
            <!--<FormItem label="法人身份证号：" prop="legalIdcard">-->
              <!--<Input v-model="formData.legalIdcard" placeholder="请输入法人身份证号" :maxlength="18" />-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--<Col span="12">-->
            <!--<FormItem label="身份证生效：" prop="idcardStartDate">-->
              <!--<Date-picker type="date" :options="idStartData" v-model="formData.idcardStartDate" placeholder="请选择身份证生效开始日期" @on-change="idChangeStart" style="width: 200px"></Date-picker>-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--</Row>-->
          <!--<Row>-->
          <!--<Col span="12">-->
            <!--<FormItem label="身份证过期：" prop="idcardEndDate">-->
              <!--<Date-picker type="date" v-model="formData.idcardEndDate" placeholder="请选择身份证生效截止日期" @on-change="idChangeEnd" format="yyyy-MM-dd" :options="idEndData" style="width: 200px"></Date-picker>-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--<Col span="12">-->
            <!--<FormItem label="营业执照号码：" prop="businessLicense">-->
              <!--<Input v-model="formData.businessLicense" placeholder="请输入营业执照号码" :maxlength="18" />-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--</Row>-->
          <!--<Row>-->
          <!--<Col span="12">-->
            <!--<FormItem label="营业执照生效：" prop="setupStartDate">-->
              <!--<Date-picker type="date" :options="setupStartData" v-model="formData.setupStartDate" placeholder="请选择营业执照生效开始日期" @on-change="setupStart" style="width: 200px"></Date-picker>-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--<Col span="12">-->
            <!--<FormItem label="营业执照过期：" prop="setupEndDate">-->
              <!--<Date-picker type="date" :options="setupEndData" v-model="formData.setupEndDate" placeholder="请选择营业执照生效截止日期" @on-change="setupEnd" style="width: 200px"></Date-picker>-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--</Row>-->
          <!--<Row>-->
          <!--<Col span="12">-->
            <!--<FormItem label="注册地址：" prop="address">-->
              <!--<Input v-model="formData.address" placeholder="请输入注册地址" :maxlength="200" />-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--</Row>-->
          <!--<Row>-->
            <!--<Col span="24" offset="" >-->
              <!--<h4 style="display:inline">联系人</h4>-->
              <!--<Button type="ghost" style="opacity: 0;cursor: default" ></Button>-->
            <!--</Col>-->
          <!--</Row>-->
          <!--<br>-->
          <!--<hr>-->
          <!--<br>-->
          <!--<Col span="12">-->
            <!--<span style="text-indent: 1.8em; display: block">业务联系人:</span>-->
          <!--</Col>-->
          <!--<Col span="12">-->
            <!--<span style="text-indent: 1.8em; display: block">技术联系人:</span>-->
          <!--</Col>-->
          <!--<br>-->
          <!--<br>-->
          <!--<Row>-->
          <Col span="12">
            <FormItem label="联系人姓名：" prop="contactName">
              <Input v-model="formData.contactName" style="width: 300px" placeholder="请输入联系人姓名" :maxlength="20" />
            </FormItem>
          </Col>
          </row>
          <!--<Col span="12">-->
            <!--<FormItem label="联系人姓名：" prop="technologyContactName">-->
              <!--<Input v-model="formData.technologyContactName" placeholder="请输入技术联系人姓名" :maxlength="20" />-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--</Row>-->
          <!--<Row>-->
          <row>
          <Col span="12">
            <FormItem label="联系人电话：" prop="contactTel">
              <Input v-model="formData.contactTel" style="width: 300px" placeholder="请输入联系人电话" :maxlength="20" />
            </FormItem>
          </Col>
          <!--<Col span="12">-->
            <!--<FormItem label="联系人电话：" prop="technologyContactTel">-->
              <!--<Input v-model="formData.technologyContactTel" placeholder="请输入技术联系人电话" :maxlength="20" />-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--</Row>-->
          <!--<Row>-->
          <Col span="12">
            <FormItem label="联系人邮箱：" prop="contactEmail">
              <Input v-model="formData.contactEmail" style="width: 300px" placeholder="请输入联系人邮箱" :maxlength="50" />
            </FormItem>
          </Col>
          </row>
          <!--<Col span="12">-->
            <!--<FormItem label="联系人邮箱：" prop="technologyContactEmail">-->
              <!--<Input v-model="formData.technologyContactEmail" placeholder="请输入技术联系人邮箱" :maxlength="50" />-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--</Row>-->
          <!--<Row>-->
          <row>
          <Col span="12">
            <FormItem label="联系人地址：" prop="contactAddr">
              <Input v-model="formData.contactAddr" style="width: 300px" placeholder="请输入联系人地址" :maxlength="200" />
            </FormItem>
          </Col>
          </row>
            <!--<Col span="12">-->
            <!--<FormItem label="联系人地址：" prop="technologyContactAddr">-->
              <!--<Input v-model="formData.technologyContactAddr" placeholder="请输入技术联系人地址" :maxlength="200" />-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--</Row>-->
          <!--<Row>-->
            <!--<Col span="24" offset="" >-->
              <!--<h4 style="display:inline;">照片资料</h4>-->
              <!--<Button type="ghost" style="opacity: 0;cursor: default" >返回</Button>-->
            <!--</Col>-->
          <!--</Row>-->
          <!--<br>-->
          <!--<hr>-->
          <!--<br>-->
          <!--<FormItem label="法人身份照片：" prop="legalIdcardPic" style="width: 60%">-->
            <!--<Upload-->
              <!--:on-success="idCard"-->
              <!--:headers="headers"-->
              <!--:on-preview="findImg"-->
              <!--:on-progress="onProgress"-->
              <!--:max-size="500"-->
              <!--:on-exceeded-size="handleMaxSize"-->
              <!--:show-upload-list="false"-->
              <!--:on-error="loadLost"-->
              <!--type="drag"-->
              <!--:format="['jpg','jpeg','png','gif']"-->
              <!--accept=".jpg,.jpeg,.png,.gif"-->
              <!--:action=uploadUrl>-->
              <!--<div style="padding: 20px 0">-->
                <!--&lt;!&ndash;<Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>&ndash;&gt;-->
                <!--<img :src="this.constantsImg + this.idImg" v-if="idImg"  style="width: 80%; margin: 0 auto">-->
                <!--<p>点击或拖拽上传图片<em style="color: #ff3300">仅支持 'jpg','jpeg','png','gif'</em></p>-->
              <!--</div>-->
            <!--</Upload>-->
          <!--</FormItem>-->
          <!--<img :src="this.constantsImg + this.idImg" v-if="idImg" style="width: 50%; margin-left: 120px; margin-bottom: 20px">-->
          <!--<FormItem label="营业执照照片：" prop="businessLicensePic" style="width: 60%">-->
            <!--<Upload-->
              <!--:on-success="licensePic"-->
              <!--:headers="headers"-->
              <!--:on-preview="findImg"-->
              <!--:on-progress="onProgress"-->
              <!--:max-size="500"-->
              <!--:on-exceeded-size="handleMaxSize"-->
              <!--:show-upload-list="false"-->
              <!--:on-error="loadLost"-->
              <!--:format="['jpg','jpeg','png','gif']"-->
              <!--accept=".jpg,.jpeg,.png,.gif"-->
              <!--type="drag"-->
              <!--:action=uploadUrl>-->
              <!--<div style="padding: 20px 0">-->
                <!--<img :src="this.constantsImg + this.licenseImg" v-if="licenseImg" style="width: 80%; margin: 0 auto">-->
                <!--<p>点击或拖拽上传图片<em style="color: #ff3300">仅支持 'jpg','jpeg','png','gif'</em></p>-->
              <!--</div>-->
            <!--</Upload>-->
          <!--</FormItem>-->
          <!--<FormItem label="组织机构代码：" prop="orgCodeCertPic" style="width: 60%">-->
            <!--<Upload-->
              <!--:on-success="orgPic"-->
              <!--:headers="headers"-->
              <!--:on-preview="findImg"-->
              <!--:on-progress="onProgress"-->
              <!--:max-size="500"-->
              <!--:on-exceeded-size="handleMaxSize"-->
              <!--:show-upload-list="false"-->
              <!--:on-error="loadLost"-->
              <!--:format="['jpg','jpeg','png','gif']"-->
              <!--accept=".jpg,.jpeg,.png,.gif"-->
              <!--type="drag"-->
              <!--:action=uploadUrl>-->
              <!--<div style="padding: 20px 0">-->
                <!--<img :src="this.constantsImg + this.orgImg" v-if="orgImg" style="width: 80%; margin: 0 auto">-->
                <!--<p>点击或拖拽上传图片<em style="color: #ff3300">仅支持 'jpg','jpeg','png','gif'</em></p>-->
              <!--</div>-->
            <!--</Upload>-->
          <!--</FormItem>-->
          <!--<FormItem label="税务登记证照：" prop="taxRegCertPic" style="width: 60%">-->
            <!--<Upload-->
              <!--:on-success="taxRegPic"-->
              <!--:headers="headers"-->
              <!--:on-progress="onProgress"-->
              <!--:on-preview="findImg"-->
              <!--:max-size="500"-->
              <!--:on-exceeded-size="handleMaxSize"-->
              <!--:show-upload-list="false"-->
              <!--:on-error="loadLost"-->
              <!--:format="['jpg','jpeg','png','gif']"-->
              <!--accept=".jpg,.jpeg,.png,.gif"-->
              <!--type="drag"-->
              <!--:action=uploadUrl>-->
              <!--<div style="padding: 20px 0">-->
                <!--<img :src="this.constantsImg + this.taxImg" v-if="taxImg" style="width: 80%; margin: 0 auto">-->
                <!--<p>点击或拖拽上传图片<em style="color: #ff3300">仅支持 'jpg','jpeg','png','gif'</em></p>-->
              <!--</div>-->
            <!--</Upload>-->
          <!--</FormItem>-->
          <!--<FormItem label="开户许可证照：" prop="accountOpenLicensePic" style="width: 60%">-->
            <!--<Upload-->
              <!--:on-success="accOpenPic"-->
              <!--:headers="headers"-->
              <!--:on-progress="onProgress"-->
              <!--:on-preview="findImg"-->
              <!--:max-size="500"-->
              <!--:on-exceeded-size="handleMaxSize"-->
              <!--:show-upload-list="false"-->
              <!--:on-error="loadLost"-->
              <!--:format="['jpg','jpeg','png','gif']"-->
              <!--accept=".jpg,.jpeg,.png,.gif"-->
              <!--type="drag"-->
              <!--:action=uploadUrl>-->
              <!--<div style="padding: 20px 0">-->
                <!--<img :src="this.constantsImg + this.accountImg" v-if="accountImg" style="width: 80%; margin: 0 auto">-->
                <!--<p>点击或拖拽上传图片<em style="color: #ff3300">仅支持 'jpg','jpeg','png','gif'</em></p>-->
              <!--</div>-->
            <!--</Upload>-->
          <!--</FormItem>-->
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
    <Modal title="查看图片" v-model="visible">
      <img :src="this.constantsImg + imgName" v-if="visible" style="width: 100%">
    </Modal>
  </card>
</template>
<script>
  // import cityList from '../../../libs/content'
export default {
  name: "addOrganization",
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
      setupEndData: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000
        }
      },
      cityList: {},
      idImg: '',
      licenseImg: '',
      taxImg: '',
      orgImg: '',
      accountImg: '',
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
        // technologyContactName: '',
        // technologyContactTel: '',
        // technologyContactEmail: '',
        // technologyContactAddr: '',
        // registeredCapital: '',
        // legalName: '',
        // legalIdcard: '',
        // idcardStartDate: '',
        // idcardEndDate: '',
        // businessLicense: '',
        // setupStartDate: '',
        // setupEndDate: '',
        // address: '',
        // provinceCode: '',
        // cityCode: '',
        // countyCode: '',
        // legalIdcardPic: '',
        // businessLicensePic: '',
        // orgCodeCertPic: '',
        // taxRegCertPic: '',
        // accountOpenLicensePic: ''
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
          {required: true, max: 12, trigger: 'blur', message: '请输入机构代码'}
          // {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字，且长度不超过12！'}
        ],
        // technologyContactName: [
        //   {required: false, trigger: 'blur', message: '请输入技术联系人姓名'},
        //   {pattern: /^[\u4e00-\u9fff\w]{1,20}$/, message: '不能输入特殊字符，且长度不超过20！'}
        // ],
        // technologyContactTel: [
        //   {required: false, trigger: 'blur', min: 5, max: 20, message: '请输入电话号码(5-20位数字)'},
        //   {pattern: /\+?[\d]{3,20}(-?)[\d]{2,20}$/, trigger: 'blur', message: '请输入正确电话号码(5-20位数字)'}
        // ],
        // technologyContactEmail: [
        //   {required: false, trigger: 'blur', message: '请输入技术联系人邮箱'},
        //   {pattern: /^[a-zA-Z0-9]+([._\\-]*[a-zA-Z0-9])*@([a-zA-Z0-9]+[-a-zA-Z0-9]*[a-zA-Z0-9]+.){1,63}[a-zA-Z0-9]+$/, message: '请输入正确邮箱，且长度不超过50！'}
        // ],
        // technologyContactAddr: [
        //   {required: false, trigger: 'blur', message: '请输入技术联系人地址'}
        // ],
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
          // {required: true, trigger: 'blur', message: '请输入业务联系人地址'}
        ]
        // registeredCapital: [
          // {required: true, trigger: 'blur', message: '请输入注册资本'},
        //   {type: 'number',
        //     message: '请输入数字格式',
        //     trigger: 'blur',
        //     transform (value) {
        //       return Number(value)
        //     }
        //   }
        // ],
        // legalName: [
        //   {required: false, trigger: 'blur', message: '请输入法人姓名'},
        //   {pattern: /^[\u4e00-\u9fff\w]{1,20}$/, message: '不能输入特殊字符，且长度不超过20！'}
        // ],
        // legalIdcard: [
        //   {required: false, trigger: 'blur', message: '请输入法人身份证号'},
        //   { min: 18, max: 18, message: '法人身份证号码长度为18位', trigger: 'blur' },
        //   { type: 'number',
        //     message: '请输入数字格式',
        //     trigger: 'blur',
        //     transform (value) {
        //       return Number(value)
        //     }
        //   }
        // ],
        // idcardStartDate: [
        //   {required: false, trigger: 'blur', message: '请选择身份证生效开始日期'}
        // ],
        // idcardEndDate: [{required: false, trigger: 'blur', message: '请选择身份证生效截止日期'}],
        // businessicense: [
        //   {required: false, trigger: 'blur', message: '请输入营业执照号码'},
        //   { type: 'number',
        //     message: '请输入数字格式',
        //     trigger: 'blur',
        //     transform (value) {
        //       return Number(value)
        //     }
        //   }
        // ],
        // setupStartDate: [
        //   {required: false, trigger: 'blur', message: '请选择营业执照生效开始日期'}
        // ],
        // setupEndDate: [
        //   {required: false, trigger: 'blur', message: '请选择营业执照生效截止日期'}
        // ],
        // address: [
        //   {required: false, trigger: 'blur', message: '请输入注册地址'}
        // ],
        // provinceCode: [
        //   {required: true, trigger: 'change', message: '请输入所属省份名称'}
        // ],
        // cityCode: [
        //   {required: true, trigger: 'change', message: '请输入所属城市名称'}
        // ],
        // countyCode: [
        //   {required: true, trigger: 'change', message: '请输入所属区县名称'}
        // ],
        // legalIdcardPic: [
        //   {required: false, trigger: 'blur', message: '请上传法人身份证号照片'}
        // ],
        // businessLicense: [
        //   {required: false, max: 18, trigger: 'blur', message: '请输入营业执照号码，且长度不超过18！'},
        //   {pattern: /^[\u4e00-\u9fff\w]{1,20}$/, message: '不能输入特殊字符，且长度不超过18！'}
        // ],
        // businessLicensePic: [
        //   {required: true, trigger: 'blur', message: '请上传营业执照号照片'}
        // ],
        // orgCodeCertPic: [
        //   {required: true, trigger: 'blur', message: '请上传组织机构代码证照片'}
        // ],
        // taxRegCertPic: [
        //   {required: true, trigger: 'blur', message: '请上传税务登记证照片'}
        // ],
        // accountOpenLicensePic: [
        //   {required: false, trigger: 'blur', message: '请上传开户许可证照片'}
        // ]
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
      // funcModal: false,
      funcModalShow: false // 用来更新数据
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
          self.funcTableData = response.data.roleList
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
    cityChange: function (val) {
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
    findImg: function (file) {
      this.visible = true
      this.imgName = file.response
    },
    countyChange: function (val) {
      this.formData.countyCode = val
    },
    handleSubmit () {
      if (this.formData.provinceCode === '01' || this.formData.provinceCode === '02' || this.formData.provinceCode === '03' || this.formData.provinceCode === '04' || this.formData.provinceCode === '32' || this.formData.provinceCode === '33') {
        this.formData.cityCode = '0'
      }
      let that = this
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.post('/organization', this.formData).then(function (res) {
            that.$Message.success('添加机构成功')
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
    this.cityList = cityList
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
