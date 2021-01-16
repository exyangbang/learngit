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
          <h4 style="display:inline">个体工商户鉴权详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row >
      <Col span="24">
        <row>
          <Col span="12">
            <FormItem label="虚拟账号：" prop="account">
              <span> {{ formData.account }}</span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="营业执照号："  prop="code">
              <span> {{ formData.busLicCode }}</span>
            </FormItem>
          </Col>
        </row>
        <row>
          <Col span="12">
            <FormItem label="姓名：" prop="realName">
              <span> {{ formData.realName }}</span>
            </FormItem>
          </Col>
        </row>
        <row>
          <Col span="12">
            <FormItem label="营业执照图片：" prop="busLicPic">
              <!--<img :src=this.formData.busLicPic  style="width: 50%; margin: 0 auto">-->
              <i-button type="primary" @click = "getImg(formData.busLicPic)">查看原图</i-button>
            </FormItem>
          </Col>
        </row>
        <row>
          <Col span="12">
            <FormItem label="个人身份证正面：" prop="personPic">
              <!--<img :src=this.formData.personPic style="width: 50%; margin: 0 auto">-->
              <i-button type="primary" @click = "getImg(formData.personPic)">查看原图</i-button>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="个人身份证反面：" prop="personReversePic">
              <!--<img :src=this.formData.personReversePic style="width: 50%; margin: 0 auto">-->
              <i-button type="primary" @click = "getImg(formData.personReversePic)">查看原图</i-button>
            </FormItem>
          </Col>
        </row>
      </Col>
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
  name: 'personalInfoAuthDetail',
  data () {
    return {
      disImg: false,
      disTex: false,
      imgName: '',
      constantsImg: '',
      visible: false,
      id: this.$route.params.id,
      danWei: '',
      currentPage: 1,
      roleList: [],
      formData: {},
      provinceAry: [],
      cityAry: [],
      disCity: false,
      disCounty: false
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
      this.$axios.get('/personalInfoAuth/' + this.id)
        .then(function (response) {
          if (response.data.idType === '101') {
            response.data.idType = '身份证'
          }
          if (response.data.idType === '102') {
            response.data.idType = '护照'
          }
          if (response.data.idType === '103') {
            response.data.idType = '军官证'
          }
          self.formData = response.data
          if (self.formData.personPic) {
            self.formData.personPic = self.$contants.base64EchangeConf + self.formData.personPic
          }
          if (self.formData.personReversePic) {
            self.formData.personReversePic = self.$contants.base64EchangeConf + self.formData.personReversePic
          }
          self.formData.licensePic = self.$contants.base64EchangeConf + self.formData.licensePic
          self.formData.busLicPic = self.$contants.base64EchangeConf + self.formData.busLicPic
        })
        .catch(function (error) {
          console.log(error)
        })
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
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    this.init()
  },
  computed: {
  },
  mounted () {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'personalInfoAuthDetail', this.$route.params.id)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.init()
    }
  }
}
</script>
