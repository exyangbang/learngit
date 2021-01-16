<style lang="less">
  .footer-border {
    padding: 0;
    border: none;
  }
</style>
<template>
  <card>
    <Form :label-width="150">
      <Row>
        <Col span="10" offset="">
          <h4 style="display:inline">机构详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="24">
          <Col span="12">
            <FormItem label="机构名称：" prop="fullName">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.fullName }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="机构简称：" prop="simpleName" v-show="disSimpleName">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.simpleName }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="机构代码：" prop="orgCode">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.orgCode }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="联系人姓名：" prop="orgCode">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.contactName }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="联系人电话：" prop="contactTel">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.contactTel }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="联系人邮箱：" prop="orgCode">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.contactEmail }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="联系人地址：" prop="contactAddr">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.contactAddr }} </span>
            </FormItem>
          </Col>
        </Col>
      </Row>
      <Row>
      </Row>
    </Form>
  </card>
</template>
<script>import cityList from '../../../libs/content'

export default {
  name: 'organizationDetail',
  data () {
    return {
      constantsImg: this.$contants.BaseImageUrl,
      cityList: {},
      visible: false,
      disCity: false,
      disCounty: false,
      imgName: '',
      organizationId: this.$route.params.id,
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
      this.provinceAry = this.cityList.China.province
      if (this.organizationId) {
        this.getOrganizationDetail()
      }
    },
    getOrganizationDetail() {
      let self = this
      this.$axios.get('organization' + '/' + this.organizationId)
        .then(function (response) {
          if (response.data.simpleName) {
            self.disSimpleName = true
          }
          if (response.data.contactAddr) {
            self.disContAddre = true
          }
          if (response.data.registeredCapital) {
            self.disRegisteredCapital = true
          }
          if (response.data.orgCodeCertPic) {
            self.disOrgCodeCertPic = true
          }
          if (response.data.taxRegCertPic) {
            self.disTaxRegCertPic = true
          }
          self.formData = response.data
          self.provinceAry.forEach(function (e, i) {
            if (e.id === response.data.provinceCode) {
              self.formData.provinceCode = e.name
              if (response.data.cityCode && response.data.cityCode !== '0') {
                self.disCity = true
                self.provinceAry[i].city.forEach(function (e, i) {
                  if (e.id === response.data.cityCode) {
                    self.disCounty = true
                    self.formData.cityCode = e.name
                    e.county.forEach(function (e, i) {
                      if (response.data.countyCode === e.id) {
                        self.formData.countyCode = e.name
                      }
                    })
                  }
                })
              } else {
                self.disCounty = true
                self.provinceAry[i].city.county.forEach(function (e, i) {
                  if (response.data.countyCode === e.id) {
                    self.formData.countyCode = e.name
                  }
                })
              }
            }
          })
          self.funcTableData = response.data.roleList
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    goBack() {
      this.$util.goBack(this)
    }
  },
  created() {
    this.cityList = cityList
    this.init()
  },
  computed: {
    legalIdcardPic() {
      let imgUrl = this.constantsImg + (this.formData.legalIdcardPic ? this.formData.legalIdcardPic : '')
      return imgUrl
    },
    businessLicensePic() {
      let imgUrl = this.constantsImg + (this.formData.businessLicensePic ? this.formData.businessLicensePic : '')
      return imgUrl
    },
    orgCodeCertPic() {
      let imgUrl = this.constantsImg + (this.formData.orgCodeCertPic ? this.formData.orgCodeCertPic : '')
      return imgUrl
    },
    taxRegCertPic() {
      let imgUrl = this.constantsImg + (this.formData.taxRegCertPic ? this.formData.taxRegCertPic : '')
      return imgUrl
    },
    accountOpenLicensePic() {
      let imgUrl = this.constantsImg + (this.formData.accountOpenLicensePic ? this.formData.accountOpenLicensePic : '')
      return imgUrl
    }
  },
  mounted() {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'organizationDetail', this.$route.params.id)
    if (this.organizationId !== initParamVal) {
      this.organizationId = initParamVal
      this.getOrganizationDetail()
    }
  }
}
</script>
