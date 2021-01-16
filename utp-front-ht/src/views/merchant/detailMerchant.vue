<style scoped lang="less">
  @import '../../styles/common.less';
</style>
<template>
    <Card class="cw-report">
        <div>
          <Row>
            <Col>
              <h4 style="display:inline">商户基本信息：</h4>
              <Button type="ghost" @click="goBack()" class=" margin-left-10">返回</Button>
            </Col>
          </Row>
          <br><hr><br>
            <Form  :label-width="120">
                <Row>
                    <Col span="12" >
                        <FormItem label="商户名称：">
                            <span>{{formData.merName}}</span>
                        </FormItem>
                      <FormItem label="商户号：">
                        <span>{{formData.merNo}}</span>
                      </FormItem>
                      <FormItem label="所属收单机构：">
                        <span>{{formData.orgName}}</span>
                      </FormItem>
                    </Col>
                </Row>
            </Form>
        </div>
    </Card>
</template>
<script>
export default {
  // name: "detailMerchant",
  data () {
    return {
      id: this.$route.params.id,
      formData: {}
    }
  },
  methods: {
    init () {
      if (this.id) {
        this.getData()
      }
    },
    getData () {
      let self = this
      this.$axios.get(this.$contants.restful.merchantInfo + '/' + this.id)
        .then(function (response) {
          if (response.data) {
            self.formData = response.data
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    tabClick (name) {
      if (name === '1') {
      } else if (name === '2') {
      } else if (name === '3') {
      }
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  mounted () {
    this.init()
  }

}
</script>
