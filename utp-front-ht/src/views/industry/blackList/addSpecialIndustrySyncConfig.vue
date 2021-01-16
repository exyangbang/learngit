<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="客户名称：" prop="name">
            <Input v-model="name" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="客户号：" prop="code">
            <Input v-model="code" :maxlength="12"/>
          </FormItem>
          <FormItem label="机构代码：" prop="orgCode">
            <Input v-model="orgCode" :maxlength="nameSize"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listIndustry" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addIndustry" @click="createBtn()" :disabled = "disActionShen" style="margin-right: 10px;">添加</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table :columns="tableColumns" :data="tableData" border  @on-selection-change="selectDataNew" highlight-row stripe></Table>
        <br>
        <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"></Page>
      </Col>
    </Row>
  </card>
</template>

<script>
export default {
  // name: "industryList",
  data () {
    return {
      id: '',
      disActionShen: true,
      applyBtn: true,
      auditStatus: '',
      examineStatu: false,
      lastDate: '',
      modalAccount: false,
      modalData: false,
      idList: [],
      industryModel: {
        industryCode: '',
        name: ''
      },
      name: '',
      pageNo: 1,
      code: '',
      orgCode: '',
      bankNameAry: [],
      formData: {
        account: '',
        accountName: '',
        bankName: '',
        bankCode: ''
      },
      countData: {
        account: '',
        accountName: '',
        bankCode: '',
        bankName: '',
        cityCode: '',
        code: '',
        countyCode: '',
        id: '',
        name: '',
        provinceCode: '',
        simpleName: '',
        status: '',
        custNumber: '',
        custAccountNo: '',
        custAccountName: ''
      },
      ruleValidate: {
        account: [
          {required: true, trigger: 'blur', message: '请输入来款号'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        bankCode: [
          {pattern: /^[0-9]*$/, message: '只能输入数字和字母！'}
        ],
        bankName: [
          {required: true, trigger: 'blur', message: '请选择来款银行名称'}
        ],
        accountName: [
          {required: true, trigger: 'blur', message: '请输入来款户名'}
        ],
        custNumber: [
          {required: true, trigger: 'blur', message: '请输入客户号'}
          // {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        custAccountNo: [
          {required: true, trigger: 'blur', message: '请输入客户账户'}
          // {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        custAccountName: [
          {required: false, trigger: 'blur', message: '请输入客户序号'}
          // {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ]
      },
      accountFormData: {

      },
      query: {
        parameters: {
        }
      },
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}],
      mySelectedData: this.selectedItem,
      selectedMerchant: [],
      selectedMerchId: []
    }
  },
  methods: {
    init () {
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          type: 'selection',
          width: 60,
          align: 'center'
        },
        {
          title: '序号',
          type: 'index',
          width: 70
        },
        {
          title: '机构代码',
          key: 'orgCode',
          width: 120 * avg,
          ellipsis: true,
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.orgCode
                }
              }, params.row.orgCode)
            ])
          }
        },
        {
          title: '机构名称',
          key: 'orgName',
          width: 150 * avg,
          ellipsis: true,
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.orgName
                }
              }, params.row.orgName)
            ])
          }
        },
        {
          title: '客户名称',
          key: 'name',
          ellipsis: true,
          width: 150 * avg,
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.name
                }
              }, params.row.name)
            ])
          }
        },
        {
          title: '客户简称',
          key: 'simpleName',
          ellipsis: true,
          width: 150 * avg,
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.simpleName
                }
              }, params.row.simpleName)
            ])
          }
        },
        {
          title: '客户号',
          key: 'code',
          ellipsis: true,
          width: 150 * avg,
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.code
                }
              }, params.row.code)
            ])
          }
        },
        {
          title: '入金通知url',
          key: 'innerNoticeUrl',
          ellipsis: true,
          width: 150 * avg,
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.innerNoticeUrl
                }
              }, params.row.innerNoticeUrl)
            ])
          }
        },
        {
          title: '证书DN',
          key: 'dn',
          width: 120 * avg,
        },
        {
          title: '二级账户是否对外接款',
          key: 'whetherExternal',
          width: 150 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.whetherExternal === '0') {
              reslut = '不对外'
            }
            if (a.row.whetherExternal === '1') {
              reslut = '对外'
            }
            return h('span', reslut)
          }
        }
      ]
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
      let uri = encodeURI('/industry/pageListExclude')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      this.query.parameters.industryType = '1'
      if (this.name) {
        this.query.parameters.name = this.name
      } else {
        delete this.query.parameters.name
      }
      if (this.code) {
        this.query.parameters.code = this.code
      } else {
        delete this.query.parameters.code
      }
      if (this.orgCode) {
        this.query.parameters.orgCode = this.orgCode
      } else {
        delete this.query.parameters.orgCode
      }
      this.query.parameters.customers = '1'
      // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          this.tableData = response.data.list
          this.applyBtn = true
          this.total = response.data.total
          response.data.page.list.forEach(function (e, i) {
            e.transDate = e.transDate + e.transTime

          })
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    resetData (row) {
      this.modalData = true
      this.lastDate = ''
      this.industryCode = row.code
    },
    cancelAuditStatus () {
      this.examineStatu = false
    },
    selectDataNew (currentRow) {
      let that = this
      that.idList = currentRow
      currentRow.forEach(function (e, i) {
        if (currentRow.length > 0) {
          that.disActionShen = false
        } else {
          that.disActionShen = true
        }
      })
    },
    auditStatusChange (val) {
      this.auditStatus = val
    },
    dataChange (val) {
      this.lastDate = val
    },
    setAccount (row) {
      this.$router.push({
        name: 'linkBank',
        params: {
          id: row.code,
          industryName: row.name,
          industryCode: row.code
        }
      })
    },
    // 关联商户列表
    showRelateIndustry (row) {
      localStorage.removeItem('industryCodeGuan')
      localStorage.setItem('industryCodeGuan', row.code)
      this.$router.push({
        name: 'linkIndustryList',
        params: {
          id: row.code,
          industryName: row.name,
          industryCode: row.code
        }
      })
    },
    cancel () {
      this.modalAccount = false
      this.$refs['countData'].resetFields()
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
    clearBtn () {
      this.name = ''
      this.code = ''
      this.orgCode = ''
    },
    createBtn () {
      let self = this
      this.$axios.post('/specialIndustrySyncConfig', this.idList).then(res => {
        self.$Message.success('添加成功！')
        self.disActionShen = true
        self.idList = []
        this.searchList()
      }).catch( function (err) {
        self.disActionShen = false
        self.idList = []
      })
    },
    industryApply () {
      this.examineStatu = true
    }
  },
  created () {
    // this.cityList = cityList
    this.init()
  },
  computed: {
    nameSize () {
      return this.$contants.pageSet.nameSize
    },
    accountSize () {
      return this.$contants.pageSet.accountSize
    }
  }
}
</script>
