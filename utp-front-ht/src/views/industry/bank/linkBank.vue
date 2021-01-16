<template>
    <div>
        <Row>
            <Col>
                <Form ref="form" :model="formData" label-position="right" :inline="true">
                    <!--<FormItem label="平台：">-->
                        <!--<Input v-model="formData.industryCode" :maxlength="100"/>-->
                    <!--</FormItem>-->
                    <!--<FormItem label="平台名称：">-->
                        <!--<Input v-model="formData.industryName" :maxlength="100"/>-->
                    <!--</FormItem>-->
                    <FormItem :label-width="0">
                      <Button type="default" @click="backGO()" style="margin-right: 10px;"><Icon type="chevron-left"></Icon> 返回</Button>
                      <Button type="success" @click="createBtn()"  v-access id="addIndustryFeeAccount" style="margin-right: 10px;">新增账户</Button>
                    </FormItem>
                </Form>
            </Col>
        </Row>
        <Row>
            <Col>
            <Table ref="selection" :columns="tableColumns" :data="tableData" highlight-row border>
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
  name: "linkBank",
  data () {
    return {
      industryCode: this.$route.params.industryCode,
      formData: {},
      productNoAry: [],
      chnFeeTemplateIdAry: [],
      tableColumns: [],
      tableData: [],
      total: 0,
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
          width: 100
        },
        {
          title: '来款账号',
          key: 'accountNo',
          ellipsis: true
        },
        {
          title: '来款户名',
          key: 'accountName',
          ellipsis: true
        },
        // {
        //   title: '银行开户行',
        //   key: 'bankName',
        //   ellipsis: true
        // },
        // {
        //   title: '银行开户行行号',
        //   key: 'bankCode',
        //   ellipsis: true
        // },
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
                  id: 'editIndustryFeeAccount',
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
                    id: 'deleteIndustryFeeAccount',
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
    doDelete (row) {
      let self = this
      this.$axios.delete('/industryAccountInfo/' + row.id)
        .then(function () {
          self.$Message.success('删除成功！')
          self.searchList()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    update (row) {
      this.$router.push({
        name: 'editBank',
        params: {
          type: 'edit',
          id: row.id,
          industryCode: row.industryCode
        }
      })
    },
    createBtn () {
      this.$router.push({
        name: 'addBank',
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
      param.parameters = {}
      param.parameters.industryType = '1'
      if (!this.$route.params.industryCode) {
        param.parameters.industryCode = window.location.href.split('/')[(window.location.href.split('/').length - 1)]
      } else {
        param.parameters.industryCode = this.$route.params.industryCode
      }
      // 获取 平台来款账户
      this.$axios.post('industryAccountInfo/pageList', param)
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
    backGO () {
      this.$util.goBack(this)
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
