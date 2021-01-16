<style lang="less">
  @import '../../../styles/common.less';
</style>
<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="客户名称：" prop="name">
            <Input v-model="name" :maxlength="200"/>
          </FormItem>
          <FormItem label="客户号：" prop="industryCode">
            <Input v-model="industryCode" :maxlength="12"/>
          </FormItem>
          <FormItem label="子账户名称：" prop="subObjName">
            <Input v-model="subObjName" :maxlength="200"/>
          </FormItem>
          <FormItem label="子账户账号：" prop="subAccount">
            <Input v-model="subAccount" :maxlength="40"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="quotaExaApprovalList" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="subaccountsAmtLimitAdd" @click="createBtn()" style="margin-right: 10px;">新增</Button>
            <!--<Button type="warning" v-access id="quotaExaApprovalApply" @click="quotaExaApprovalApplyBtn()" style="margin-right: 10px;" :disabled="applyBtn">审核</Button>-->
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" @on-current-change="selectDataNew" highlight-row stripe></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
    </Row>
    <Modal
      v-model="examineStatu"
      title="交易限额管理"
      width="350"
    >
      <Select v-model="auditStatus" style="width: 180px"  @on-change="auditStatusChange">
        <i-option value="1">审核通过</i-option>
        <i-option value="2">审核驳回</i-option>
      </Select>
      <i-input type="textarea" v-model="remark" placeholder="请输入备注" style="margin-top: 10px"></i-input>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelAuditStatus">取消</Button>
        <Button type="primary" size="large" @click="sumbitAuditStatus">确定</Button>
      </div>
    </Modal>
  </card>
</template>
<script>
export default {
  name: "subaccountsList",
  data () {
    return {
      id: '',
      examineStatu: false,
      auditStatus: '',
      remark: '',
      merName: '',
      industryCode: '',
      name: '',
      applyBtn: true,
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}],
      subObjName: '',
      subAccount: ''
    }
  },
  methods: {
    init () {
      let self = this
      // 设置
      // this.provinceAry = this.cityList.China.province
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 70
        },
        {
          title: '客户号',
          key: 'industryCode',
          width: 150 * avg
        },
        {
          title: '客户名称',
          key: 'name',
          width: 150 * avg
        },
        {
          title: '子账户账号',
          key: 'subAccount',
          width: 150 * avg
        },
        {
          title: '子账户名称',
          key: 'subObjName',
          width: 150 * avg
        },
        {
          title: '子账户单笔限额',
          key: 'subaccountsIndividualAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.subaccountsIndividualAmt / 100 + '元')
          }
        },
        {
          title: '子账户单日限额',
          key: 'subaccountsDateAmt',
          width: 150 * avg,
          render (h, a, b) {
            return h('span', a.row.subaccountsDateAmt / 100 + '元')
          }
        },
        {
          title: '备注信息',
          key: 'remark',
          width: 150 * avg
        },
        {
          title: '审核状态',
          key: 'auditStatus',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.auditStatus === '0') {
              res = '待审核'
            }
            if (a.row.auditStatus === '1') {
              res = '审核通过'
            }
            if (a.row.auditStatus === '2') {
              res = '审核驳回'
            }
            return h('span', res)
          }
        },
        {
          title: '最近修改时间',
          key: 'gmtModified',
          width: 150 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '最近修改人',
          key: 'userModified',
          width: 150 * avg
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 150 * avg,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'quotaExaApprovalEdit',
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
                    id: 'deleteProduct',
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
              ]),
              h('svg-icon', {
                attrs: {
                  id: 'quotaExaApprovalShuaXin',
                  title: '刷新额度'
                },
                props: {
                  type: 'reset-pwd',
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
                    this.shuaXinEDu(params.row)
                  }
                }
              }, '刷新额度')
            ])
          }
        }
      ]
      // 查询信息
      this.searchList()
    },
    searchList (param) {
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/subaccountsAmtLimit/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.name) {
        query.parameters.name = this.name
      } else {
        delete query.parameters.name
      }
      if (this.industryCode) {
        query.parameters.industryCode = this.industryCode
      } else {
        delete query.parameters.industryCode
      }
      if (this.subObjName) {
        query.parameters.subObjName = this.subObjName
      } else {
        delete query.parameters.subObjName
      }
      if (this.subAccount) {
        query.parameters.subAccount = this.subAccount
      } else {
        delete query.parameters.subAccount
      }
      // 查询机构列表
      // let that = this
      this.$axios.post(uri, query)
        .then((response) => {
          this.tableData = response.data.list
          this.total = parseInt(response.data.total)
        })
        .catch(function (error) {
          console.log(error)
        })
    },

    changePage (index) {
      // 分页点击事件
      this.currentPage = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.currentPage = 1
      this.searchList()
    },
    shuaXinEDu (row) {
      let that = this
      this.$axios.post('/subAccountLimitAmountOnlineReq', row).then(function (res) {
        that.$Message.success('刷新额度成功')
      })
    },
    clearBtn () {
      this.name = ''
      this.subObjName = ''
      this.subAccount = ''
      this.industryCode = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addSubaccounts'
      })
    },
    quotaExaApprovalApplyBtn () {
      this.examineStatu = true
    },
    // auditStatusChange (val) {
    //   this.auditStatus = val
    // },
    cancelAuditStatus () {
      this.examineStatu = false
    },
    sumbitAuditStatus () {
      let that = this
      if (this.auditStatus && this.id) {
        let formData = {
          auditStatus: this.auditStatus,
          id: this.id,
          remark: this.remark
        }
        this.$axios.put('/quotaExaApprovalAudit', formData).then(function (res) {
          that.auditStatus = ''
          that.id = ''
          that.searchList()
          that.$Message.success('交易限额审核成功')
          that.examineStatu = false
          that.applyBtn = true
        }).catch(function (err) {
          that.examineStatu = false
          that.applyBtn = true
        })
      } else {
        that.$Message.error('请选择审核状态')
        that.applyBtn = true
      }
    },
    selectDataNew (currentRow) {
      if (currentRow.auditStatus === '0') {
        this.id = currentRow.id
        this.applyBtn = false
      } else {
        this.applyBtn = true
      }
    },
    doDelete (row) {
      // debugger
      // let query = {
      //   id: row.id,
      //   operationType: '0'
      // }
      row.operationType = '0'
      this.$axios.post('/subaccountsmtALimitApproval', row)
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
      this.$router.push({
        name: 'editSubaccounts',
        params: {
          type: 'edit',
          id: row.approvalId
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'productDetail',
        params: {
          id: row.id
        }
      })
    },
    changePassword (row) {
      this.$router.push({
        name: 'changeUserPassword',
        params: {
          username: row.username
        }
      })
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
  activated() {
      this.searchList()
  }
}
</script>
