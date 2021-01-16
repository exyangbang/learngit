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
          <h4 style="display:inline">渠道详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="24">
          <Col span="12">
            <FormItem label="渠道名称：" prop="channelName">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.channelName }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="渠道编号：" prop="channelCode">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.channelCode }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="支付产品：" prop="productName">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.productName }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="请求前台地址：" prop="frontUrl">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.frontUrl }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="请求后台地址：" prop="backUrl">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.backUrl }} </span>
            </FormItem>
          </Col>
          <!--<Col span="12">-->
            <!--<FormItem label="trid参数：" prop="trid">-->
              <!--<span> {{ formData.trid }} </span>-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--<Col span="12">-->
            <!--<FormItem label="trtp参数：" prop="trtp">-->
              <!--<span> {{ formData.trtp }} </span>-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--<Col span="12">-->
            <!--<FormItem label="机构号：" prop="orgCode">-->
              <!--<span> {{ formData.orgCode }} </span>-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--<Col span="12">-->
            <!--<FormItem label="企业账号：" prop="accNo">-->
              <!--<span> {{ formData.accNo }} </span>-->
            <!--</FormItem>-->
          <!--</Col>-->
          <!--<Col span="12">-->
            <!--<FormItem label="用户编码：" prop="userCode">-->
              <!--<span> {{ formData.userCode }} </span>-->
            <!--</FormItem>-->
          <!--</Col>-->
          <Col span="12">
            <FormItem label="渠道额度：" prop="channelQuota">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.amount / 100 }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费模板：" prop="chnFeeTemplateName">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.chnFeeTemplateName }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="是否可用：" prop="status" v-show="disCounty">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.status }} </span>
            </FormItem>
          </Col>
        </Col>
      </Row>
      <Row>
      </Row>
    </Form>
  </card>
</template>
<script>
export default {
  name: 'channelDetail',
  data () {
    return {
      channelId: this.$route.params.id,
      constantsImg: this.$contants.BaseImageUrl,
      visible: false,
      disCity: false,
      disCounty: true,
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
      if (this.channelId) {
        this.getOrganizationDetail()
      }
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('channelInfo' + '/' + this.channelId)
        .then(function (response) {
          if (response.data.joinType === '1') {
            response.data.joinType = '平台接入'
          }
          if (response.data.joinType === '2') {
            response.data.joinType = '机构接入'
          }
          if (response.data.status === '0') {
            response.data.status = '不启用'
          }
          if (response.data.status === '1') {
            response.data.status = '启用'
          }
          self.formData = response.data
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
  },
  mounted () {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'channelDetail', this.$route.params.id)
    if (this.channelId !== initParamVal) {
      this.channelId = initParamVal
      this.init()
    }
  }
}
</script>
