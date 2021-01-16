<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Row>
            <Col>
                <Form  ref="form" :model="formData" label-position="right" :inline="true">
                    <!--<FormItem label="平台：">-->
                        <!--<Input v-model="formData.industryCode" :maxlength="100"/>-->
                    <!--</FormItem>-->
                    <!--<FormItem label="平台名称：">-->
                        <!--<Input v-model="formData.industryName" :maxlength="100"/>-->
                    <!--</FormItem>-->
                    <FormItem :label-width="0">
                        <!--<Button type="primary" @click="searchBtn()" style="margin-right: 10px;">查询</Button>-->
                        <!--<Button type="default" @click="clearBtn()">清空</Button>-->
                      <Button type="default" @click="backGO()" style="margin-right: 10px;"><Icon type="chevron-left"></Icon> 返回</Button>
                      <Button type="success" @click="createBtn()" v-access id="addChannelIndustry">新增关联</Button>
                    </FormItem>
                </Form>
            </Col>
        </Row>
        <Row>
            <Col>
            <Table ref="selection" :columns="tableColumns" :data="tableData" highlight-row border="" @on-row-click="selectRow">
                   <!--@on-selection-change="handleChange"-->
                   <!--@on-select="select"-->
                   <!--@on-select-cancel="selectCancel"-->
                   <!--@on-select-all="selectAll"-->
              <!---->
            </Table>
              <br>
              <Page :total="total" :current="currentPage" show-total @on-change="changePage" class="page"></Page>
            </Col>
        </Row>
        <!--<Row>-->
            <!--<Col>-->
                <!--<div class="ivu-modal-footer">-->
                    <!--<Button type="primary" @click="sureSubmit" style="margin-right: 10px;"  id="sureBtnId">确定</Button>-->
                    <!--<Button type="default" @click="backCancel">取消</Button>-->
                <!--</div>-->
            <!--</Col>-->
        <!--</Row>-->
      <!-- 弹出商户选择框-->
      <!--<Modal v-model="funcModal" title="新增关联商户" width="1000" :mask-closable="false">-->
        <!--<func-list v-if="funcModalShow" :merId="merId" :industryName="industryName" :industryCode="industryCode" :productNoAry="productNoAry" :chnFeeTemplateIdAry="chnFeeTemplateIdAry">-->
        <!--</func-list>-->
        <!--<div slot="footer" class-name="footer-border"></div>-->
      <!--</Modal>-->
    </div>
</template>
<script>export default {
  name: "linkIndustryList",
  data () {
    return {
      industryCode: this.$route.params.industryCode,
      formData: {},
      productNoAry: [],
      chnFeeTemplateIdAry: [],
      tableColumns: [],
      tableData: [],
      total: 0,
      pageNo: 1,
      currentPage: 1,
      tempData: [],
      firstSelected: true,
      mySelectedData: this.selectedItem,
      selectedMerchant: [],
      selectedMerchId: [],
      funcModal: false,
      funcModalShow: false, // 用来更新数据
      selectedItem: null
    }
  },
  methods: {
    init () {
      // 设置

      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 200
        },
        {
          title: '支付产品',
          key: 'productName',
          ellipsis: true
        }
      ]
      // 查询信息
      this.searchList()
      console.log('create----')
    },
    selectRow (row) {
      this.$router.push({
        name: 'channelLink',
        params: {
          id: row.productNo + '/' + row.industryCode
        }
      })
    },
    backGO () {
      this.$util.goBack(this)
    },
    doDelete (row) {
      let self = this
      this.$axios.delete('/channelIndustry/' + row.id)
        .then(function () {
          self.$Message.success('删除成功！')
          self.searchList()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    getTop (row) {
      let params = {
        id: row.id
      }
      let self = this
      this.$axios.put('/channelIndustry/roofPlacement', params).then(function (res) {
        self.searchList()
      })
    },
    createBtn () {
      this.$router.push({
        name: 'addChannelIndustry',
        params: {
          industryId: this.$route.params.id,
          industryName: this.$route.params.industryName,
          industryCode: this.$route.params.industryCode
        }

      })
      // this.funcModalShow = true
      // this.funcModal = !this.funcModal
    },
    // 关联商户列表
    showRelateMerchant (row) {
      // this.selectedItem = row
      // this.funcModalShow = true
      // this.funcModal = !this.funcModal
    },
    // 获取到选中的数据
    checkFunc (data) {
      // this.funcModal = !this.funcModal
      // this.funcModalShow = false
    },
    hideFunc () {
      this.funcModalShow = false
      this.funcModal = !this.funcModal
    },
    searchList (param) {
      let self = this
      let page = {
        pageNo: this.currentPage,
        pageSize: 10
      }
      param = param || {}
      param.pageNo = page.pageNo
      param.pageSize = page.pageSize
      // param.merId = this.$route.params.id
      // param.industryName = this.$route.params.industryName
      param.parameters = {}
      if (!this.$route.params.industryCode) {
        param.parameters.industryCode = window.location.href.split('/')[(window.location.href.split('/').length - 1)]
      } else {
        param.parameters.industryCode = this.$route.params.industryCode
      }
      // 获取 商户列表(证书关联的商户)
      this.$axios.post('channelIndustry/pageListGroup', param)
        .then((response) => {
          self.tableData = response.data.list
          self.total = parseInt(response.data.total)
        })
        .catch((error) => {
          console.log(error)
        })
    },
    changePage (index) {
      this.currentPage = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.currentPage = 1
      this.tableData = []
      this.selectedMerchant = []
      this.searchList()
    },
    clearBtn () {
      this.formData = {}
    },
    sureSubmit: function () {
      let self = this
      let merchants = []
      self.selectedMerchant.forEach(function (currentPageValues, currentPageIndex) {
        currentPageValues.forEach(function (itemValues, index) {
          merchants.push(itemValues.industryCode)
        })
      })
      let url = self.$contants.restful.certificateMerchantInfo + '/' + self.selectedItem.id
      self.$axios.post(url, merchants)
        .then(() => {
          self.$Message.success('关联成功')
        })
        .catch((error) => {
          console.log(error)
        })
      self.backCancel()
    },
    backCancel () {
      this.$emit('hideFunc')
    },
    // handleChange (selection) {
    //   let self = this
    //   let currentPageSelectedMerchIds = []
    //   selection.forEach(function (value, index) {
    //     currentPageSelectedMerchIds.push(parseInt(value.id))
    //   })
    //   this.selectedMerchId[self.currentPage - 1] = currentPageSelectedMerchIds
    //
    //   this.selectedMerchant[this.currentPage - 1] = selection
    //   let sureBtn = document.getElementById('sureBtnId')
    //   sureBtn.disabled = false
    // },
    // select (selection, row) {
    // },
    // selectCancel (selection, row) {
    // },
    // selectAll (selection) {
    // },
    unique: function (arr) { // 去掉数组中重复数据
      let result = []
      let hash = {}
      for (var i = 0, elem; (elem = arr[i]) != null; i++) {
        if (!hash[elem]) {
          result.push(elem)
          hash[elem] = true
        }
      }
      return result
    },
    inArray (arr, value) {
      if (!arr) {
        return false
      }
      for (let i = 0; i < arr.length; i++) {
        if (arr[i] === value) {
          return true
        }
      }
      return false
    }
  },
  created () {
    this.init()
  },
  activated() {
      this.searchList()
  }
}
</script>
