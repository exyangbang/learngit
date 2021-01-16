<template>
    <div>
        <Row>
            <Col>
                <Form ref="form" :model="formData" label-position="right" :inline="true">
                    <FormItem :label-width="0">
                      <Button type="default" @click="backGO()" style="margin-right: 10px;"><Icon type="chevron-left"></Icon> 返回</Button>
                      <Button type="success" style="left: 10px" @click="createBtn()" v-access id="addIndustryFeeAccount">新增提现账户</Button>
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
  name: 'infoFeeCashSet',
  data () {
    return {
      industryCode: this.$route.params.industryCode,
      id: this.$route.params.id,
      account: this.$route.params.account,
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
          title: '收款方账号',
          key: 'accountNo',
          ellipsis: true
        },
        {
          title: '收款方户名',
          key: 'accountName',
          ellipsis: true
        },
        {
          title: '清算行号',
          key: 'payeeOpbk',
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
                  id: 'getCash',
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
                    id: 'getCash',
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
      if (this.account) {
        this.searchList()
      }
    },
    doDelete (row) {
      let self = this
      this.$axios.delete('/withdrawCashAccount/' + row.id)
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
        name: 'editFeeCashSet',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    backGO () {
      this.$util.goBack(this)
    },
    createBtn () {
      this.$router.push({
        name: 'addFeeCashSet',
        params: {
          id: this.id
        }

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
      param.parameters = {}
      param.parameters.account = this.account
      // 获取 平台来款账户
      this.$axios.post('/withdrawCashAccount/list', param)
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
    }
  },
  created () {
    this.init()
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'infoFeeCashSet', this.$route.params.account)
    let tempindustryCode = this.$util.getRefreshInitParam(this, 'infoFeeCashSetindustryCode', this.$route.params.industryCode)
    let temid = this.$util.getRefreshInitParam(this, 'infoFeeCashSetid', this.$route.params.id)
    this.account = initParamVal
    this.industryCode = tempindustryCode
    this.id = temid
    this.init()
  }
}
</script>
