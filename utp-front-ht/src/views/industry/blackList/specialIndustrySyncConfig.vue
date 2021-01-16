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
          <FormItem label="客户号：" prop="industryCode">
            <Input v-model="industryCode" :maxlength="18"/>
          </FormItem>
          <FormItem label="客户名称：" prop="name">
            <Input v-model="name" :maxlength="200"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="blacklistMangerList" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addIndustry" @click="createBtn()" style="margin-right: 10px;">新增</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" @on-current-change="selectDataNew" highlight-row
               stripe></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
    </Row>
  </card>
</template>

<script>
export default {
  name: 'specialIndustrySyncConfig',
  data () {
    return {
      examineStatu: false,
      applyBtn: true,
      name: '',
      industryCode: '',
      receiverName: '',
      receiverNo: '',
      thawReportMask: false,
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}]
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
          width: 170
        },
        {
          title: '客户号',
          key: 'industryCode',
          width: 250 * avg
        },
        {
          title: '客户名称',
          key: 'name',
          width: 250 * avg
        },
        {
          title: '创建时间',
          key: 'gmtCreate',
          width: 250 * avg,
          render (h, a, b) {
            return h('span', self.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '创建人员',
          key: 'userCreate',
          width: 250 * avg
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 200,
          render: (h, params) => {
            return h('div', [
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
                    id: 'delspecialIndustrySyncConfig',
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
      this.searchList()
    },
    doDelete (row) {
      this.$axios.delete('/specialIndustrySyncConfig' + '/' + row.id)
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
    searchList (param) {
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/specialIndustrySyncConfig/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {name: this.name, industryCode: this.industryCode}}
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
    clearBtn () {
      this.name = ''
      this.industryCode = ''
    },
    industryApply () {
      this.examineStatu = true
    },
    cancelAuditStatus () {
      this.examineStatu = false
    },
    auditStatusChange (val) {
      this.auditStatus = val
    },
    selectDataNew (currentRow) {
      if (currentRow.auditStatus === '0') {
        this.id = currentRow.id
        this.applyBtn = false
      } else {
        this.applyBtn = true
      }
    },
    createBtn () {
      this.$router.push({
        name: 'addSpecialIndustrySyncConfig'
      })
    },
    update (row) {
      this.$router.push({
        name: 'editWhiteListPayments',
        params: {
          type: 'edit',
          id: row.id
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
  activated () {
    this.searchList()
  }
}
</script>
