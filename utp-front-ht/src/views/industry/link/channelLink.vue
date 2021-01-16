<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Row>

            <Col>
                <Form ref="form" :model="formData" label-position="right" :inline="true">
                    <FormItem :label-width="0">
                        <Button type="default" @click="backGO()" style="margin-right: 10px;"><Icon type="chevron-left"></Icon> 返回</Button>
                        <Button type="success" @click="sortBtn()" :disabled="sumbitSort"  v-access id="addChannelIndustry" style="margin-right: 10px;">提交排序</Button>
                    </FormItem>
                </Form>
            </Col>
        </Row>
        <Row>
            <Col>
            <Table ref="selection" :columns="tableColumns" :data="tableData" highlight-row border>
            </Table>
              <br>
              <Page :total="total" :current="currentPage" show-total @on-change="changePage" class="page"></Page>
            </Col>
        </Row>
    </div>
</template>
<script>export default {
  name: 'channelLink',
  data () {
    return {
      sumbitSort: true,
      productNo: this.$route.params.productNo,
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
      let that = this
      this.tableColumns = [
        {
          title: '序号',
          key: 'index',
          width: 100,
          render: (h, params) => {
            return h('div', [
              h('Input', {
                props: {
                  value: params.row.roofPlacement
                },
                style: {
                  width: '50px'
                },
                on: {
                  input: (eve) => {
                    let tester = /^[1-9]\d*$/
                    if (tester.test(eve)) {
                      if (eve > this.total) {
                        this.$Message.error('序号不能大于总数')
                        this.sumbitSort = true
                        // params.row.roofPlacement = ''
                      } else {
                        params.row.roofPlacement = eve
                        this.changeTabelData(params.row, eve)
                      }
                    } else {
                      this.$Message.error('请输入正整数')
                      this.sumbitSort = true
                      // params.row.roofPlacement = ''
                    }
                  }
                }
              })
            ])
          }
        },
        {
          title: '客户号',
          key: 'industryCode',
          ellipsis: true
        },
        {
          title: '客户名称',
          key: 'industryName',
          ellipsis: true
        },
        {
          title: '支付产品',
          key: 'productName',
          ellipsis: true
        },
        {
          title: '渠道编号',
          key: 'channelCode',
          ellipsis: true
        },
        {
          title: '渠道名称',
          key: 'channelName',
          ellipsis: true
        },
        {
          title: '通用手续费模板名称',
          key: 'indFeeTemplateName',
          ellipsis: true
        },
        {
          title: '对公手续费模板名称',
          key: 'publicFeeTemplateName',
          ellipsis: true
        },
        {
          title: '对私手续费模板名称',
          key: 'privateFeeTemplateName',
          ellipsis: true
        },
        {

          title: '操作',
          key: 'action',
          align: 'center',
          fixed: 'right',
          width: 150,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'addChannelIndustry',
                  title: '编辑'
                },
                props: {
                  type: 'edit',
                  size: '16'
                },
                style: {
                  marginRight: '20px',
                  cursor: 'pointer'
                },
                directives: [{
                  name: 'access'
                }],
                on: {
                  click: () => {
                    this.update(params.row)
                  }
                }
              }, '编辑'),
              h('Poptip', {
                props: {
                  confirm: true,
                  title: '您确定要删除这条数据吗?',
                  transfer: true
                },
                on: {
                  'on-ok': () => {
                    this.doDelete(params.row)
                  }
                }
              }, [
                h('svg-icon', {
                  attrs: {
                    id: 'addChannelIndustry',
                    title: '删除'
                  },
                  directives: [{
                    name: 'access'
                  }],
                  style: {
                    marginRight: '20px',
                    cursor: 'pointer'
                  },
                  props: {
                    type: 'delete',
                    size: '16'
                  }
                }, '删除')
              ])
            ])
          }
        }
      ]
      // 查询信息
      this.searchList()
    },
    changeTabelData (row, eve) {
      this.sumbitSort = false
      this.tableData.forEach(function (e, i) {
        if (row.id === e.id) {
          e.roofPlacement = eve
          return false
        }
        // if (row.roofPlacement === e.roofPlacement.toString()) {
        //   self.$Message.error('序号不能重复')
        // }
      })
    },
    update (row) {
      this.$router.push({
        name: 'editChannelIndustry',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    doDelete (row) {
      let self = this
      this.$axios.delete('/channelIndustry/' + row.id)
        .then(function () {
          self.$Message.success('删除成功！')
          self.searchListPaixu()
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
      // this.$router.push({
      //   name: 'editChannelIndustry',
      //   params: {
      //     type: 'edit',
      //     id: row.id,
      //     industryCode: row.industryCode
      //   }
      // })
    },
    backGO () {
      this.$util.goBack(this)
    },
    sortBtn () {
      let self = this
      let sort = []
      let arrayIdAry = []
      this.tableData.forEach(function (e, i) {
        sort.push(parseInt(e.roofPlacement))
      })
      let nary = sort.sort()
      for (let i = 0; i < nary.length - 1; i++) {
        if (nary[i] === nary[i + 1]) {
          this.$Message.error('不同数据排序序号不能相同')
          this.sumbitSort = true
          return false
        }
      }
      for (let i = 0; i < sort.length; i++) {
        for (let j = 0; j < self.tableData.length; j++) {
          if (parseInt(self.tableData[j].roofPlacement) === i + 1){
            arrayIdAry.push(self.tableData[j].id)
          }
        }
      }
      let query = {arrayId: arrayIdAry}

      this.$axios.put('channelIndustry/roofPlacement', query).then(function (res) {
        self.sumbitSort = true
        self.searchList()
      })
    },
    sortBtnDelete () {
      let self = this
      let arrayIdAry = []
      this.tableData.forEach(function (e, i) {
        arrayIdAry.push(e.id)
      })
      let query = {arrayId: arrayIdAry}
      this.$axios.put('channelIndustry/roofPlacement', query).then(function (res) {
        self.searchList()
      })
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
    searchListPaixu (param) {
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
      if (!this.$route.params.productNo) {
        let urlNew = ''
        urlNew = window.location.href.split('/')[(window.location.href.split('/').length - 1)]
        param.parameters.industryCode = urlNew.split('%2F')[1]
        param.parameters.productNo = urlNew.split('%2F')[0]
      }
      // 获取 商户列表(证书关联的商户)
      this.$axios.post('channelIndustry/pageList', param)
        .then((response) => {
          self.tableData = response.data.list
          self.total = parseInt(response.data.total)
          self.sortBtnDelete()
        })
        .catch((error) => {
          console.log(error)
        })
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
      if (!this.$route.params.productNo) {
        let urlNew = ''
        urlNew = window.location.href.split('/')[(window.location.href.split('/').length - 1)]
        param.parameters.industryCode = urlNew.split('%2F')[1]
        param.parameters.productNo = urlNew.split('%2F')[0]
      }
      // 获取 商户列表(证书关联的商户)
      this.$axios.post('channelIndustry/pageList', param)
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
