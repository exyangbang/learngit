<style lang="less">
  .ivu-table-row-highlight td {
    background-color: #B6E2FC!important;
  }
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="收款账号：" prop="payeeAccount">
            <Input v-model="payeeAccount" :maxlength="100"/>
          </FormItem>
          <FormItem label="收款户名：" prop="payeeName">
            <Input v-model="payeeName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="importSubPayPayeeWhiteList" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="importAction" @click="importAction()" style="margin-right: 10px;">上传收款白名单</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" highlight-row stripe></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
    </Row>
    <Modal
      v-model="payeeAccountGetApplyModel"
      title="修改"
      :mask-closable="false"
      width="350"
    >
      <Form :label-width="120" ref="countData" :model="countData" label-position="right" :inline="true">
        <FormItem label="收款账号：" prop="payeeAccount">
          <Input v-model="countData.payeeAccount" placeholder="请输入收款账号" :maxlength="200"/>
        </FormItem>
        <FormItem label="收款户名：" prop="payeeName">
          <Input v-model="countData.payeeName" placeholder="请输入收款户名" :maxlength="200"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="cancel">取消</Button>
        <Button type="primary" size="large" @click="sumbitAccount">确定</Button>
      </div>
    </Modal>
  </card>
</template>

<script>
export default {
  name: 'subPayPayeeWhiteList',
  data () {
    return {
      payeeAccountGetApplyModel: false,
      tableData: [],
      countNew: 0,
      industryId: this.$route.params.id,
      currentPage: 1,
      total: 0,
      payeeAccount: '',
      payeeName: '',
      countData: {
        industryId: this.$route.params.id,
        payeeAccount: '',
        payeeName: '',
        id: 0,
      },
      formData: {},
      query: {
        parameters: {
        }
      }
    }
  },
  methods: {
    name: 'subPayPayeeWhiteList',
    init () {
      // 设置
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 120 * avg
        },
        {
          title: '收款账号',
          key: 'payeeAccount',
          width: 220 * avg
        },
        {
          title: '收款户名',
          key: 'payeeName',
          width: 220 * avg
        },
        {
          title: '更新时间',
          key: 'gmtModified',
          width: 220 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '更新操作员',
          key: 'userModified',
          width: 210 * avg
        },
        {
          title: '操作',
          key: 'action',
          align: 'left',
          width: 200 * avg,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'editIndustry',
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
                    id: 'deleteIndustry',
                    title: '删除'
                  },
                  directives: [{
                    name: 'access'
                  }],
                  style: {
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
      if (this.industryId) {
        this.searchList()
      }

    },
    goBack () {
      this.$util.goBack(this)
    },
    searchList (param) {
      self = this
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      let uri = encodeURI('/subPayPayeeWhiteList/list')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      this.query.parameters.industryId = this.industryId
      if (this.payeeAccount) {
        this.query.parameters.payeeAccount = this.payeeAccount
      } else {
        delete this.query.parameters.payeeAccount
      }
      if (this.payeeName) {
        this.query.parameters.payeeName = this.payeeName
      } else {
        delete this.query.parameters.payeeName
      }
      this.$axios.post(uri, this.query)
        .then((response) => {
          self.tableData = response.data.list
          self.total = parseInt(response.data.total)
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    objTypeChange (val) {
      this.objType = val
    },
    cancel () {
      this.payeeAccountGetApplyModel = false
    },
    sumbitAccount () {
      let that = this
      if (that.countData.payeeAccount.length === 0) {
        that.$Message.error('请选择输入收款账号')
      }
      if (that.countData.payeeName.length === 0) {
        that.$Message.error('请选择输入收款户名')
      }
      this.$axios.put('/subPayPayeeWhiteList', this.countData).then(function (res) {
        that.countData.payeeAccount = ''
        that.countData.payeeName = ''
        that.searchList()
        that.$Message.success('修改成功')
        that.payeeAccountGetApplyModel = false
      }).catch(function (error) {
        console.log(error)
      })
    },
    importAction () {
      this.$router.push({
        name: 'importSubPayPayeeWhiteList'
      })
    },
    changePage (index) {
      // 分页点击事件
      this.currentPage = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.searchList()
    },
    clearBtn () {
      this.payeeAccount = ''
      this.payeeName = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addIndustry'
      })
    },
    doDelete (row) {
      this.$axios.delete('/subPayPayeeWhiteList/' + row.id)
        .then((res) => {
          if (res.status === 200) {
            this.$Message.success('删除成功！')
            this.searchList()
          } else {
            this.$Message.success('删除失败！')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    update (row) {
      this.payeeAccountGetApplyModel = true
      this.countData.payeeAccount = row.payeeAccount
      this.countData.payeeName = row.payeeName
      this.countData.id = row.id
    }
  },
  created () {
    this.init()
  },
  computed: {
    nameSize () {
      return this.$contants.pageSet.nameSize
    },
    accountSize () {
      return this.$contants.pageSet.accountSize
    }
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'subPayPayeeWhiteList', this.$route.params.id)
    if (initParamVal) {
      this.industryId = initParamVal
      this.init()
    }
  }
}
</script>
