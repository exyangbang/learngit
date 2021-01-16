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
          <h4 style="display:inline">手续费详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="24">
          <Col span="12">
            <FormItem label="手续费模板名称：" prop="name">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.name }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费模板类型：" prop="settleType">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.settleType }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续收费方式：" prop="chargeMode">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.chargeMode }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费计算方式：" prop="calculateMode">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.calculateMode }} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="最小手续费：" v-show="disMin" prop="minFee">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.minFee }} {{danWeiMin}} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="最大手续费："  v-show="disMax" prop="maxFee">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.maxFee }} {{danWeiMax}} </span>
            </FormItem>
          </Col>
          <Col span="12">
            <FormItem label="手续费：" prop="fee">
              <span style="width: 80%; word-wrap: break-word"> {{ formData.fee }} {{danWei}}</span>
              <i-button type="ghost" shape="circle" @click.native="setPage" v-if="num">查看详情</i-button>
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
    <Modal v-model="funcModal" title="按笔定额-区间" width="700" :mask-closable="false">
      <Row v-if="num">
        <Col span="24" offset="" style="margin-bottom: 10px">
          <Row>
            <Col span="9" style="height: 30px; background: #cccccc; color: #000; line-height: 30px; text-indent: 1em;">交易金额区间(元)</Col>
            <Col span="7" style="height: 30px; background: #cccccc; color: #000; line-height: 30px;">手续费类型</Col>
            <Col span="8" style="height: 30px; background: #cccccc; color: #000; line-height: 30px; text-indent: 1em;">价格</Col>
          </Row>
        </Col>
        <Col span="24" offset="" style="margin-bottom: 10px">
          <Row v-for="(item, index) in content" :key="index">
            <Col span="9" style="height: 30px; background: #fff; color: #000; line-height: 30px; text-indent: 1em;">{{item.firstSection}} —— {{item.secondSection}}</Col>
            <Col span="7" style="height: 30px; background: #fff; color: #000; line-height: 30px; text-indent: 1em;">{{item.type}}</Col>
            <Col span="8" style="height: 30px; background: #fff; color: #000; line-height: 30px; text-indent: 1em;">{{item.priceSection}}</Col>
          </Row>
        </Col>
      </Row>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>
export default {
  name: 'feeDetail',
  data () {
    return {
      productId: this.$route.params.id,
      disMax: false,
      disMin: false,
      type: null,
      danWei: '',
      danWeiMin: '元',
      danWeiMax: '元',
      minFee: '',
      maxFee: '',
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
      disTaxRegCertPic: false,
      num: 0,
      content: []
    }
  },
  methods: {
    init () {
      if (this.productId) {
        this.getOrganizationDetail()
      }
    },
    setPage () {
      this.funcModal = !this.funcModal
      this.funcModalShow = true
    },
    getOrganizationDetail () {
      let self = this
      this.$axios.get('feeTemplate' + '/' + this.productId)
        .then(function (response) {
          if (response.data.content !== null && response.data.content !== '[]' && response.data.content !== '') {
            if (JSON.parse(response.data.content).length >= 1) {
              let reslut = JSON.parse(response.data.content)
              reslut.forEach(function (e, i) {
                e.firstSection = e.firstSection / 100
                e.secondSection = e.secondSection / 100
                if (e.type === 'amount') {
                  e.type = '定额'
                  e.priceSection = e.priceSection / 100 + '元'
                }
                if (e.type === 'percent') {
                  e.type = '比例'
                  e.priceSection = e.priceSection / 1000 + '%'
                }
              })
              self.content = reslut
              // self.content = JSON.parse(response.data.content)
              self.num = 1
            }
          }
          if (response.data.calculateMode === '1') {
            response.data.calculateMode = '按笔定额'
            response.data.fee = response.data.fee / 100
            self.danWei = '元'
          }
          if (response.data.calculateMode === '2') {
            response.data.calculateMode = '按固定费率'
            self.disMax = true
            self.disMin = true
            if (response.data.minFee) {
              response.data.minFee = response.data.minFee / 100
            } else {
              self.danWeiMin = ''
            }
            if (response.data.maxFee) {
              response.data.maxFee = response.data.maxFee / 100
            } else {
              self.danWeiMax = ''
            }
            // response.data.maxFee = response.data.maxFee / 100
            response.data.fee = response.data.fee / 1000
            self.danWei = '%'
          }
          if (response.data.calculateMode === '3') {
            response.data.calculateMode = '按笔定额-区间'
            self.disMax = false
            self.disMin = false
            response.data.minFee = response.data.minFee / 100
            response.data.maxFee = response.data.maxFee / 100
            response.data.fee = ''
          }
          if (response.data.settleType === '1') {
            response.data.settleType = '实时'
          }
          if (response.data.settleType === '2') {
            response.data.settleType = '后结'
          }
          // if (response.data.settleType === '3') {
          //   response.data.settleType = '月结'
          // }
          if (response.data.chargeMode === '1') {
            response.data.chargeMode = '内扣'
          }
          if (response.data.chargeMode === '2') {
            response.data.chargeMode = '外扣'
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
    let initParamVal = this.$util.getRefreshInitParam(this, 'feeDetail', this.$route.params.id)
    if (this.productId !== initParamVal) {
      this.productId = initParamVal
      this.init()
    }
  }
}
</script>
