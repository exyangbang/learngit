<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form :label-width="150">
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">企业鉴权详情</h4>
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
              <FormItem label="虚拟账号：" prop="fullName">
                <span> {{ formData.account }} </span>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="企业名称：" prop="simpleName">
                <span> {{ formData.merName }} </span>
              </FormItem>
            </Col>
          </row>
<!--          <row>-->
<!--            <Col span="12">-->
<!--              <FormItem label="国籍：" prop="country">-->
<!--                <span> {{ formData.country }} </span>-->
<!--              </FormItem>-->
<!--            </Col>-->
<!--            <Col span="12">-->
<!--              <FormItem label="行业：" prop="prosession">-->
<!--                <span> {{ formData.prosession }} </span>-->
<!--              </FormItem>-->
<!--            </Col>-->
<!--          </row>-->
          <row>
            <Col span="12">
              <FormItem label="企业注册地址：" prop="regAddress">
                <span> {{ formData.regAddress }} </span>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="营业执照号：" prop="busLicCode">
                <span> {{ formData.busLicCode }} </span>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="法人姓名：" prop="legalName">
                <span> {{ formData.legalName }} </span>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="法人证件类型：" prop="idType">
                <span> {{ formData.idType }} </span>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="法人证件号：" prop="idCode">
                <span> {{ formData.idCode }} </span>
              </FormItem>
            </Col>
<!--            <Col>-->
<!--              <FormItem label="手机号码：" prop="telephone">-->
<!--                <span> {{ formData.telephone }} </span>-->
<!--              </FormItem>-->
<!--            </Col>-->
          </row>
          <row>
            <Col span="12">
              <FormItem label="营业执照图片：" prop="busLicPic">
                <!--<img :src=formData.busLicPic style="width: 50%">-->
                <i-button type="primary" @click = "getImg(formData.busLicPic)">查看原图</i-button>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="法人证件图片正面：" prop="personPic">
                <!--<img :src=formData.personPic style="width: 50%">-->
                <i-button type="primary" @click = "getImg(formData.personPic)">查看原图</i-button>
              </FormItem>
            </Col>
          </row>
          <row>
            <Col span="12">
              <FormItem label="法人证件图片反面：" prop="personReversePic">
                <!--<img :src=formData.personReversePic style="width: 50%">-->
                <i-button type="primary" @click = "getImg(formData.personReversePic)">查看原图</i-button>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="开户许可证：" prop="licensePic">
                <i-button type="primary" @click = "getImg(formData.licensePic)">查看原图</i-button>
              </FormItem>
            </Col>
          </row>
        </Col>
      </Row>
      <Row>
      </Row>
    </Form>
    <Modal title="查看图片" v-model="visible">
      <img v-if="disImg" :src="this.constantsImg + imgName" style="width: 100%">
      <p v-if="disTex">未上传图片</p>
    </Modal>
  </card>
</template>
<script>
export default {
  name: 'merchantInfoDetail',
  data () {
    return {
      disImg: false,
      disTex: false,
      imgBase: '',
      visible: false,
      constantsImg: '',
      imgName: '',
      id: this.$route.params.id,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {},
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
    }
  },
  mounted () {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'merchantInfoDetail', this.$route.params.id)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.init()
    }
  }

}
</script>
