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
          <FormItem label="客户名称：" prop="merName">
            <Input v-model="merName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="客户号：" prop="industryCode">
            <Input v-model="industryCode" :maxlength="12"/>
          </FormItem>
          <FormItem label="来款户名：" prop="accountName">
            <Input v-model="accountName" :maxlength="nameSize"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listProduct" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addProduct" @click="createBtn()" style="margin-right: 10px;">新增</Button>
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
  </card>
</template>

<script>
export default {
  name: "listWhiteList",
  data () {
    return {
      merName: '',
      industryCode: '',
      accountName: '',
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
          width: 70
        },
        {
          title: '客户号',
          key: 'industryCode',
          width: 150 * avg
        },
        {
          title: '客户名称',
          key: 'merName'
        },
        {
          title: '来款户名',
          key: 'accountName',
          width: 150 * avg
        },
        {
          title: '最近修改时间',
          key: 'remark',
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '最近修改人',
          key: 'userModified',
          width: 200 * avg
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
                  id: 'editProduct',
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
    searchList (param) {
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/whiteList/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {name: this.name, code: this.code}}
      if (this.merName) {
        query.parameters.merName = this.merName
      } else {
        delete query.parameters.merName
      }
      if (this.industryCode) {
        query.parameters.industryCode = this.industryCode
      } else {
        delete query.parameters.industryCode
      }
      if (this.accountName) {
        query.parameters.accountName = this.accountName
      } else {
        delete query.parameters.accountName
      }
      // 查询机构列表
      // let that = this
      let self = this
      this.$axios.post(uri, query)
        .then((response) => {
          self.tableData = response.data.list
          self.total = parseInt(response.data.total)
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
      this.merName = ''
      this.industryCode = ''
      this.accountName = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addWhiteList'
      })
    },
    doDelete (row) {
      this.$axios.delete('/whiteList' + '/' + row.id)
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
        name: 'editWhiteList',
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
  activated () {
    this.searchList()
  },
  deactivated () {

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
  }
}
</script>
