<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form :label-width="150" :rules="ruleValidate" ref="formData" :model="formData">
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">账户详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row  v-if="this.objType == '9' && this.userType == '0'">
        <Col span="24">
          <row>
            <Col span="12">
              <FormItem label="姓名：" prop="realName">
                <Input v-model="formData.realName" :disabled="true" style="width: 300px" placeholder="请输入姓名" :maxlength="nameSize" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="手机号码：" prop="telephone">
                <Input v-model="formData.telephone" :disabled="true" style="width: 300px" placeholder="请输入手机号码" :maxlength="20" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="居民类型：" prop="residentType">
                <i-select v-model="formData.residentType" :disabled="true" @on-change="residentTypeChange" style="width: 300px" placeholder="请选择居民类型">
                  <i-option value="0">非居民</i-option>
                  <i-option value="1">居民</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="证件有效期：" prop="idIndate">
                <DatePicker :options="idIndateOption" v-model="formData.idIndate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择证件有效期" @on-change="beginTradeDateChange" :disabled="true"></DatePicker>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="法人证件类型：" prop="idType">
                <i-select v-model="formData.idType" @on-change="idTypeChange" style="width: 300px" placeholder="请选择法人证件类型" :disabled="true">
                  <i-option value="101">身份证</i-option>
                  <i-option value="102">护照</i-option>
                  <i-option value="103">军官证</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="证件号：" prop="idCode">
                <Input v-model="formData.idCode" :disabled="true" :maxlength="accountSize" style="width: 300px" placeholder="请输入证件号"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="性别：" prop="sex">
                <i-select v-model="formData.sex" @on-change="sexChange" style="width: 300px" placeholder="请选择性别" :disabled="true">
                  <i-option value="F">女</i-option>
                  <i-option value="M">男</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="国籍：" prop="country">
                <Select v-model="formData.country" @on-change = "nationalityChange" style="width: 300px" filterable :disabled="true">
                  <Option v-for="item in nationalityAry" :value="item.threeBitLetters" :key="item.id">{{item.chName}}</Option>
                </Select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="职业：" prop="prosession">
              <Select v-model="formData.prosession" @on-change = "prosessionChange" style="width: 300px" filterable :disabled="true">
                <Option v-for="item in codeDictionaryList" :value="item.code" :key="item.id">{{item.value}}</Option>
              </Select>
            </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="住所/工作地址：" prop="businessAddress" :disabled="true">
                <Input v-model="formData.businessAddress" :disabled="true" :maxlength="nameSize" style="width: 300px" placeholder="请输入住所/工作地址"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="个人证件正面图片：" prop="busLicPic" >
                <!--<img :src=this.formData.personPic  style="width: 300px; margin: 0 auto">-->
                <i-button type="primary" @click = "getImg2(formData.personPic,'person_pic')" >查看图片</i-button>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="个人证件反面图片：" prop="personReversePic">
                <!--<img :src=this.formData.personReversePic style="width: 300px; margin: 0 auto">-->
                <i-button type="primary" @click = "getImg2(formData.personReversePic,'person_reverse_pic')">查看图片</i-button>
              </FormItem>
            </Col>
          </row>
          <row v-if="this.personBus == 1">
            <Col span="12">
              <FormItem label="营业执照号：" prop="busLicCode">
                <Input v-model="formData.busLicCode" :disabled="true" style="width: 300px" placeholder="请输入营业执照号" :maxlength="accountSize" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="营业执照图片：" prop="busLicPic">
                <i-button type="primary" @click = "getImg2(formData.busLicPic,'bus_lic_pic')">查看图片</i-button>
              </FormItem>
            </Col>
          </row>
        </Col>
      </Row>
      <Row  v-if=" this.objType == '9' && this.userType == '1'">
        <Col span="24">
          <row>
            <Col span="12">
              <FormItem label="企业名称：" prop="entName">
                <Input v-model="formData.entName" :disabled="true" style="width: 300px" placeholder="请输入企业账户名称" :maxlength="nameSize" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="联系电话：" prop="telephone">
                <Input v-model="formData.telephone" :maxlength="20" :disabled="true" style="width: 300px" placeholder="请输入联系电话"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="企业注册地址：" prop="regAddress">
                <Input v-model="formData.regAddress" style="width: 300px" placeholder="请输入企业注册地址" :maxlength="nameSize" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="经营范围：" prop="businessScope">
                <Input v-model="formData.businessScope" style="width: 300px" placeholder="请输入经营范围" :maxlength="nameSize" :disabled="true"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="企业注册资金：" prop="registerFund">
                <Input v-model="formData.registerFund" style="width: 300px" placeholder="请输入企业注册资金" :maxlength="20" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="营业执照号：" prop="busLicCode">
                <Input v-model="formData.busLicCode" style="width: 300px" :disabled="true" placeholder="请输入营业执照号" :maxlength="accountSize" />
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="法人姓名：" prop="legalName">
                <Input v-model="formData.legalName" style="width: 300px" placeholder="请输入法人姓名" :maxlength="nameSize" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="法人证件类型：" prop="idType">
                <i-select v-model="formData.idType" @on-change="idTypeChange" style="width: 300px" placeholder="请选择法人证件类型" :disabled="true">
                  <i-option value="101">身份证</i-option>
                  <i-option value="102">护照</i-option>
                  <i-option value="103">军官证</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="法人证件号：" prop="idCode">
                <Input v-model="formData.idCode" :maxlength="accountSize" style="width: 300px" placeholder="请输入法人证件号" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="法人证件有效期：" prop="legalIndate">
                <DatePicker :options="legalIndateOption" v-model="formData.legalIndate" class="input-width-170" type="date" :editable="false" :disabled="true"  format="yyyy-MM-dd" placeholder="请选择法人证件有效期" @on-change="legalIndateChange"></DatePicker>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="控股股东或者实际控制人姓名：" prop="controlName">
                <Input v-model="formData.controlName" style="width: 300px" placeholder="请输入控股股东或者实际控制人姓名" :maxlength="nameSize" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="控股股东或者实际控制人证件类型：" prop="controlCerfileType">
                <i-select v-model="formData.controlCerfileType" @on-change="controlCerfileTypeChange" style="width: 300px" placeholder="请选择控股股东或者实际控制人证件类型" :disabled="true">
                  <i-option value="101">身份证</i-option>
                  <i-option value="102">护照</i-option>
                  <i-option value="103">军官证</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="控股股东或者实际控制人证件号：" prop="controlCerfileNo">
                <Input v-model="formData.controlCerfileNo" :maxlength="accountSize" style="width: 300px" placeholder="请输入控股股东或者实际控制人证件号" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="控股股东或者实际控制人证件有效期：" prop="controlIndate">
                <DatePicker :options="controlIndateOption" v-model="formData.controlIndate" class="input-width-170" type="date" :editable="false" :disabled="true" format="yyyy-MM-dd" placeholder="请选择控股股东或者实际控制人证件有效期" @on-change="controlIndateChange"></DatePicker>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="负责人姓名：" prop="chargeName">
                <Input v-model="formData.chargeName" style="width: 300px" placeholder="请输入负责人姓名" :maxlength="nameSize" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="负责人证件类型：" prop="chargeCerfileType">
                <i-select v-model="formData.chargeCerfileType" @on-change="chargeCerfileTypeChange" style="width: 300px" placeholder="请选择负责人证件类型" :disabled="true">
                  <i-option value="101">身份证</i-option>
                  <i-option value="102">护照</i-option>
                  <i-option value="103">军官证</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="负责人证件号：" prop="chargeCerfileNo">
                <Input v-model="formData.chargeCerfileNo" :maxlength="accountSize" style="width: 300px" placeholder="请输入负责人证件号" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="负责人证件有效期：" prop="chargeIndate">
                <DatePicker :options="chargeIndateOption" v-model="formData.chargeIndate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择负责人证件有效期" @on-change="chargeIndateChange"></DatePicker>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="授权办理业务人员姓名：" prop="authBusName">
                <Input v-model="formData.authBusName" style="width: 300px" placeholder="请输入授权办理业务人员姓名" :maxlength="nameSize" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="授权办理业务人员证件类型：" prop="authBusType">
                <i-select v-model="formData.authBusType" @on-change="authBusTypeChange" style="width: 300px" placeholder="请选择授权办理业务人员证件类型" :disabled="true">
                  <i-option value="101">身份证</i-option>
                  <i-option value="102">护照</i-option>
                  <i-option value="103">军官证</i-option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="授权办理业务人员证件号：" prop="authBusNo">
                <Input v-model="formData.authBusNo" :maxlength="accountSize" style="width: 300px" placeholder="请输入授权办理业务人员证件号" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="授权办理业务人员证件有效期：" prop="authBusIndate">
                <DatePicker :options="authBusIndateOption" v-model="formData.authBusIndate" class="input-width-170" type="date" :editable="false" :disabled="true"  format="yyyy-MM-dd" placeholder="请选择授权办理业务人员证件有效期" @on-change="authBusIndateChange"></DatePicker>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="客户经理：" prop="customerManager">
                <Input v-model="formData.customerManager" style="width: 300px" placeholder="请输入客户经理" :maxlength="nameSize" :disabled="true"/>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="客户经理联系方式（固话或者手机号码）：" prop="customerManagerPhone">
                <Input v-model="formData.customerManagerPhone" style="width: 300px" placeholder="请输入客户经理联系方式（固话或者手机号码）" :maxlength="20" :disabled="true"/>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="企业类型：" prop="enterpriseType">
                <i-select v-model="formData.enterpriseType" @on-change="enterpriseTypeChange" style="width: 300px" placeholder="请选择企业类型" :disabled="true">
                  <Option v-for="item in enterpriseTypeAry" :value="item.value" :key="item.value">{{item.name}}</Option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="企业规模：" prop="enterpriseSale">
                <i-select v-model="formData.enterpriseSale" @on-change="enterpriseSaleChange" style="width: 300px" placeholder="请选择企业规模" :disabled="true">
                  <Option v-for="item in enterpriseSaleAry" :value="item.value" :key="item.value">{{item.name}}</Option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="上市类型：" prop="listingType">
                <i-select v-model="formData.listingType" @on-change="listingTypeChange" style="width: 300px" placeholder="请选择上市类型" :disabled="true">
                  <Option v-for="item in listingTypeAry" :value="item.value" :key="item.value">{{item.name}}</Option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="企业经济性质：" prop="enterpriseEcoNature">
                <i-select v-model="formData.enterpriseEcoNature" @on-change="enterpriseEcoNatureChange" style="width: 300px" placeholder="请选择企业经济性质" :disabled="true">
                  <Option v-for="item in enterpriseEcoNatureAry" :value="item.value" :key="item.value">{{item.name}}</Option>
                </i-select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="居民类型：" prop="residentType">
                <i-select v-model="formData.residentType" @on-change="residentTypeChange" style="width: 300px" placeholder="请选择居民类型" :disabled="true">
                  <i-option value="0">非居民</i-option>
                  <i-option value="1">居民</i-option>
                </i-select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="国籍：" prop="country">
                <Select v-model="formData.country" @on-change = "nationalityChange" style="width: 300px" filterable :disabled="true">
                  <Option v-for="item in nationalityAry" :value="item.threeBitLetters" :key="item.id">{{item.chName}}</Option>
                </Select>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <!--              <FormItem label="职业：" prop="prosession">-->
              <!--                <Select v-model="formData.prosession" @on-change = "prosessionChange" style="width: 300px" filterable>-->
              <!--                  <Option v-for="item in codeDictionaryList" :value="item.code" :key="item.id">{{item.value}}</Option>-->
              <!--                </Select>-->
              <!--              </FormItem>-->
              <FormItem label="行业：" prop="prosession">
                <Select v-model="formData.prosession" @on-change = "prosessionChange" style="width: 300px" filterable :disabled="true">
                  <Option v-for="item in codeDictionaryList" :value="item.code" :key="item.id">{{item.value}}</Option>
                </Select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="营业执照有效期：" prop="businessIndate">
                <DatePicker :options="businessIndateOption" v-model="formData.businessIndate" class="input-width-170" type="date" :editable="false" :disabled="true" format="yyyy-MM-dd" placeholder="请选择营业执照有效期" @on-change="businessIndateChange"></DatePicker>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="个人证件正面图片：" prop="busLicPic">
                <i-button type="primary" @click = "getImg2(formData.personPic,'person_pic')">查看图片</i-button>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="个人证件反面图片：" prop="personReversePic">
                <i-button type="primary" @click = "getImg2(formData.personReversePic,'person_reverse_pic')">查看图片</i-button>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="营业执照图片：" prop="busLicPic">
                <i-button type="primary" @click = "getImg2(formData.busLicPic,'bus_lic_pic')">查看图片</i-button>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="开户许可证图片：" prop="licensePic">
                <i-button type="primary" @click = "getImg2(formData.personReversePic,'license_pic')">查看图片</i-button>
              </FormItem>
            </Col>
          </row>
        </Col>
      </Row>
      <Row>
        <Col span="10" offset="2">
          <FormItem>
            <!--            <Button type="prima  ry" @click="handleSubmit()">提交</Button>-->
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
    <!--个人证件正面图片-->
    <Modal title="查看图片" v-model="visible">
      <img v-if="disImg" :src=this.formData.personPic style="width: 100%">
      <p v-if="disTex">未上传图片</p>
    </Modal>
    <!--    个人证件反面面图片-->
    <Modal title="查看图片" v-model="personReversePicvisible">
      <img v-if="disImgA" :src=this.formData.personReversePic style="width: 100%">
      <p v-if="disTexA">未上传图片</p>
    </Modal>
    <!--    营业执照图片-->
    <Modal title="查看图片" v-model="busLicPicVisible">
      <img v-if="disImgB" :src=this.formData.busLicPic style="width: 100%">
      <p v-if="disTexB">未上传图片</p>
    </Modal>
    <!--    开户许可证图片-->
    <Modal title="查看图片" v-model="licensePicVisible">
      <img v-if="disImgC" :src=this.formData.licensePic style="width: 100%">
      <p v-if="disTexC">未上传图片</p>
    </Modal>
    <!-- 弹出商户选择框-->
    <Modal v-model="funcModal" title="选择通职业" width="1000" :mask-closable="false">
      <code-list v-if="funcModalShow" v-on:pagByJson="pagByJson"  @checkFunc="checkFunc" @hideFunc="hideFunc" :selectedItem="this.selectedItem" :sureBtnDisabled=true></code-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>
import CodeList from './components/codeList'
export default {
  name: 'accountDetailThree',
  components: {CodeList},
  data () {
    return {
      imageDic: {
        account: '',
        objType: ''
      },
      personBus: 0,
      funcModal: false,
      funcModalShow: false, // 用来更新数据
      codeAry: [], // 客户号~
      nationalityAry: [],
      codeDictionaryList: [],
      enterpriseTypeAry: this.$contants.dictionary.typeOfEnterpriseArray,
      enterpriseSaleAry: this.$contants.dictionary.enterpriseScaleArray,
      enterpriseEcoNatureAry: this.$contants.dictionary.econNatureOfEnterprisesArray,
      listingTypeAry: this.$contants.dictionary.ListingTypeArray,
      disImg: false,
      disTex: false,
      disImgA: false,
      disTexA: false,
      disImgB: false,
      disTexB: false,
      disImgC: false,
      disTexC: false,
      imgName: '',
      constantsImg: '',
      visible: false,
      personReversePicvisible: false,
      busLicPicVisible: false,
      licensePicVisible: false,
      id: this.$route.params.id,
      objType: this.$route.params.objType,
      userType: this.$route.params.userType,
      industryCode: this.$route.params.code,
      danWei: '',
      currentPage: 1,
      roleList: [],
      formData: {
        // personPic: '',
        // personReversePic: '',
        // busLicPic: '',
        // licensePic: ''
      },
      provinceAry: [],
      cityAry: [],
      disCity: false,
      disCounty: false,
      tableColumns: [],
      tableData: [],
      ruleValidate: {
        regAddress: [
          {required: true, trigger: 'blur', message: '请输入企业注册地址'}
        ],
        registerFund: [
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        controlCerfileNo: [
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        chargeCerfileNo: [
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        authBusNo: [
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        customerManagerPhone: [
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        businessIndate: [
          {required: true, trigger: 'change', message: '请选择营业执照有效期', pattern: /.+/}
        ],
        legalName: [
          {required: true, trigger: 'blur', message: '请输入法人姓名'}
        ],
        idType: [
          {required: true, trigger: 'blur', message: '请选择法人证件类型'}
        ],
        idCode: [
          {required: true, trigger: 'blur', message: '请输入法人证件号'},
          {pattern: /^[a-zA-Z0-9]*$/, message: '只能输入字母和数字！'}
        ],
        legalIndate: [
          {required: true, trigger: 'change', message: '请选择法人证件有效期', pattern: /.+/}
        ],
        enterpriseSale: [
          {required: true, trigger: 'change', message: '请选择企业规模'}
        ],
        enterpriseEcoNature: [
          {required: true, trigger: 'change', message: '请选择企业经济性质'}
        ],
        country: [
          {required: true, trigger: 'change', message: '请选择国籍'}
        ],
        prosession: [
          {required: true, trigger: 'change', message: '请选择行业'}
        ],
        residentType: [
          {required: true, trigger: 'change', message: '请选择居民类型'}
        ]
      },
      legalIndateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now()
        }
      },
      idIndateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now()
        }
      }
      ,
      controlIndateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now()
        }
      },
      chargeIndateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now()
        }
      },
      authBusIndateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now()
        }
      },
      businessIndateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now()
        }
      }
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
      this.$axios.get('/account/accountDetail/' + this.id)
        .then(function (response) {
          self.formData = response.data
          self.userType = self.formData.userType
          self.tableData = response.data.merList
          // 国籍
          self.nationalityAry = response.data.countryList
          // 职业
          self.codeDictionaryList = response.data.codeDictionaryList
          if (!self.formData.residentType) {
            self.formData.residentType = '1'
          }
          self.personBus = response.data.personBus
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    residentTypeChange: function (val) {
      this.formData.residentType = val
    },
    beginTradeDateChange: function (val) {
      this.formData.idIndate = val
    },
    idTypeChange: function (val) {
      this.formData.idType = val
    },
    controlCerfileTypeChange: function (val) {
      this.formData.controlCerfileType = val
    },
    chargeCerfileTypeChange: function (val) {
      this.formData.chargeCerfileType = val
    },
    enterpriseTypeChange: function (val) {
      this.formData.enterpriseType = val
    },
    enterpriseSaleChange: function (val) {
      this.formData.enterpriseSale = val
    },
    listingTypeChange: function (val) {
      this.formData.listingType = val
    },
    enterpriseEcoNatureChange: function (val) {
      this.formData.enterpriseEcoNature = val
    },
    authBusTypeChange: function (val) {
      this.formData.authBusType = val
    },
    sexChange: function (val) {
      this.formData.sex = val
    },
    nationalityChange: function (val) {
      this.formData.country = val
    },
    prosessionChange: function (val) {
      this.formData.prosession = val
    },
    prosessionFeeTem: function (row) {
      this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    checkFunc (data) {
      this.funcModal = !this.funcModal
      this.funcModalShow = false
    },
    pagByJson: function (pagJson) {
      this.funcModal = pagJson.disPlay
      // this.formDataNew.indFeeTemplateId = pagJson.indFeeTemplateId
      // this.choseText = pagJson.name
      this.formData.prosessionName = '(' + pagJson.value + ')' + pagJson.code
      this.formData.prosession = pagJson.code

      // this.formDataNew.choseText = pagJson.name + '(模板ID:' + pagJson.indFeeTemplateId + ')'

      // this.funcModalShow = pagJson.disPlay
    },
    hideFunc: function () {
      this.funcModal = false
    },
    idCardUpDataOne: function (file) { // 证件正面图片
      this.formData.personPic = ''
      let reader = new FileReader()
      reader.readAsDataURL(file)
      if (file.size <= 3 * 1024 * 1024) {
        reader.onload = e => {
          let _file = e.target.result
          this.formData.personPic = _file
        }
      } else {
        this.formData.personPic = ''
      }
    },
    idCardUpDataTwo: function (file) { // 证件反面图片
      this.formData.personReversePic = ''
      let reader = new FileReader()
      reader.readAsDataURL(file)
      if (file.size <= 3 * 1024 * 1024) {
        reader.onload = e => {
          let _file = e.target.result
          this.formData.personReversePic = _file
        }
      } else {
        this.formData.personReversePic = ''
      }
    },
    busLicPicUpDataTwo: function (file) { // 营业执照图片
      this.formData.busLicPic = ''
      let reader = new FileReader()
      reader.readAsDataURL(file)
      if (file.size <= 3 * 1024 * 1024) {
        reader.onload = e => {
          let _file = e.target.result
          this.formData.busLicPic = _file
        }
      } else {
        this.formData.busLicPic = ''
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
        }
      } else {
        this.formData.licensePic = ''
      }
    },
    legalIndateChange (val) {
      this.formData.legalIndate = val
    },
    controlIndateChange (val) {
      this.formData.controlIndate = val
    },
    chargeIndateChange (val) {
      this.formData.chargeIndate = val
    },
    authBusIndateChange (val) {
      this.formData.authBusIndate = val
    },
    businessIndateChange (val) {
      this.formData.businessIndate = val
    },
    getImg2 (val, pciType) {
      // debugger
      let self = this
      if (pciType === 'person_pic') {
        if (self.formData.personPic == null) {
          self.getImage(val, pciType)
        }
        self.visible = true
        self.disImg = true
        self.disTex = false
      }
      if (pciType === 'person_reverse_pic') {
        if (self.formData.personReversePic == null) {
          self.getImage(val, pciType)
        }
        this.personReversePicvisible = true
        self.disImgA = true
        self.disTexA = false
      }
      if (pciType === 'bus_lic_pic') {
        if (self.formData.busLicPic == null) {
          self.getImage(val, pciType)
        }
        self.busLicPicVisible = true
        self.disImgB = true
        self.disTexB = false
      }
      if (pciType === 'license_pic') {
        if (self.formData.licensePic == null) {
          self.getImage(val, pciType)
        }
        this.licensePicVisible = true
        self.disImgC = true
        self.disTexC = false
      }
    },
    getImage (val, pciType) {
      let self = this
      this.imageDic.account = self.formData.account
      this.imageDic.objType = self.objType
      this.imageDic.pciType = pciType
      this.$axios.post('/account/getImage', this.imageDic).then(function (res) {
        if (res.data.personPic != null) {
          self.formData.personPic = self.$contants.base64EchangeConf + res.data.personPic
        } else {
          self.disImg = false
          self.disTex = true
        }
        if (res.data.personReversePic != null) {
          self.formData.personReversePic = self.$contants.base64EchangeConf + res.data.personReversePic
        } else {
          self.disImgA = false
          self.disTexA = true
        }
        if (res.data.busLicPic != null) {
          self.formData.busLicPic = self.$contants.base64EchangeConf + res.data.busLicPic
        } else {
          self.disImgB = false
          self.disTexB = true
        }
        if (res.data.licensePic != null) {
          self.formData.licensePic = self.$contants.base64EchangeConf + res.data.licensePic
        } else {
          self.disImgC = false
          self.disTexC = true
        }
      }).catch(function (error) {
        console.log(error)
      })
    },
    handleSubmit () {
      let that = this
      that.$refs['formData'].validate((valid) => {
        if (valid) {
          let self = this
          if (that.formData.personReversePic) {
            that.formData.personReversePic = that.formData.personReversePic.split(',')[1]
          }
          if (that.formData.personPic) {
            that.formData.personPic = that.formData.personPic.split(',')[1]
          }
          if (that.formData.busLicPic) {
            that.formData.busLicPic = that.formData.busLicPic.split(',')[1]
          }
          if (that.formData.licensePic) {
            that.formData.licensePic = that.formData.licensePic.split(',')[1]
          }
          if (that.formData.idIndate){
            that.formData.idIndate = self.$moment(that.formData.idIndate).format('YYYY-MM-DD')
          }
          if (that.formData.legalIndate) {
            that.formData.legalIndate = self.$moment(that.formData.legalIndate).format('YYYY-MM-DD')
          }
          if (that.formData.controlIndate) {
            that.formData.controlIndate = self.$moment(that.formData.controlIndate).format('YYYY-MM-DD')
          }
          if (that.formData.chargeIndate) {
            that.formData.chargeIndate = self.$moment(that.formData.chargeIndate).format('YYYY-MM-DD')
          }
          if (that.formData.authBusIndate) {
            that.formData.authBusIndate = self.$moment(that.formData.authBusIndate).format('YYYY-MM-DD')
          }
          if (that.formData.businessIndate) {
            that.formData.businessIndate = self.$moment(that.formData.businessIndate).format('YYYY-MM-DD')
          }
          that.formData.objType = that.objType
          that.formData.userType = that.userType
          that.formData.industryCode = that.industryCode
          that.$axios.put('/account/updateAccInfo', that.formData).then(function (res) {
            self.$Message.success('修改资料成功')
            self.goBack()
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
    this.init()
  },
  computed: {
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
    let initParamValid = this.$util.getRefreshInitParam(this, 'accountDetailThreeid', this.$route.params.id)
    let initParamValobjType = this.$util.getRefreshInitParam(this, 'accountDetailThreeobjType', this.$route.params.objType)
    let initParamValuserType = this.$util.getRefreshInitParam(this, 'accountDetailThreeuserType', this.$route.params.userType)
    let code = this.$util.getRefreshInitParam(this, 'accountDetailThreeCode', this.$route.params.code)
    if (this.objType !== initParamValobjType) {
      this.id = initParamValid
      this.objType = initParamValobjType
      this.userType = initParamValuserType
      this.industryCode = code
      this.getOrganizationDetail()
    }
  }
}
</script>
