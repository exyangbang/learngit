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
          <h4 style="display:inline">支付产品详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="24">
          <Col span="12">
            <FormItem label="支付产品编码：" prop="code">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.code }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="支付产品名称：" prop="name">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.name }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="产品状态：" prop="status">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.status }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="备注信息：" prop="remark">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.remark }} </span>
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
  name: 'productDetail',
  data () {
    return {
      productId: this.$route.params.id,
      statusAry: [{name: '启用', value: '1'}, {name: '禁用', value: '0'}],
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
      if (this.productId) {
        this.getOrganizationDetail()
      }
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('payProduct' + '/' + this.productId)
        .then(function (response) {
          if (response.data.status === '0') {
            response.data.status = '禁用'
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
    let initParamVal = this.$util.getRefreshInitParam(this, 'productDetail', this.$route.params.id)
    if (this.productId !== initParamVal) {
      this.productId = initParamVal
      this.init()
    }
  }
}
</script>
