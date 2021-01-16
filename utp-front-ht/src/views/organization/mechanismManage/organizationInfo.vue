<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="机构名称：" prop="name">
            <Input v-model="name" :maxlength="200"/>
          </FormItem>
          <FormItem label="机构代码：" prop="orgCode">
            <Input v-model="orgCode" :maxlength="200"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listOrganization" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addOrganization" @click="createBtn()" style="margin-right: 10px;">新增</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns"  :data="tableData" highlight-row stripe></Table>
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

<script>import cityList from '../../../libs/content'
export default {
  name: "organizationManageList",
  data () {
    return {
      provinceAry: [],
      cityList: {},
      name: '',
      orgCode: '',
      query: {
        parameters: {
        }
      },
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
      // 设置
      this.provinceAry = this.cityList.China.province
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 120 * avg,
        },
        {
          title: '机构名称',
          key: 'fullName',
          ellipsis: true,
          width: 180 * avg,
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
                  title: params.row.fullName
                }
              }, params.row.fullName)
            ])
          }
        },
        {
          title: '机构简称',
          key: 'simpleName',
          ellipsis: true,
          width: 180 * avg,
        },
        {
          title: '机构代码',
          key: 'orgCode',
          ellipsis: true,
          width: 150 * avg,
        },
        {
          title: '联系人姓名',
          key: 'contactName',
          ellipsis: true,
          width: 150 * avg,
        },
        {
          title: '联系人电话',
          key: 'contactTel',
          ellipsis: true,
          width: 180 * avg,
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
                  title: params.row.contactTel
                }
              }, params.row.contactTel)
            ])
          }
        },
        {
          title: '联系人邮箱',
          key: 'contactEmail',
          ellipsis: true,
          width: 180 * avg,
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
                  title: params.row.contactEmail
                }
              }, params.row.contactEmail)
            ])
          }
        },
        {
          title: '联系人地址',
          key: 'contactAddr',
          ellipsis: true,
          width: 120 * avg,
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
                  title: params.row.contactAddr
                }
              }, params.row.contactAddr)
            ])
          }
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 200,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'editOrganization',
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
              h('svg-icon', {
                attrs: {
                  id: 'detailOrganization',
                  title: '详情'
                },
                props: {
                  type: 'detail',
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
                    this.showDetail(params.row)
                  }
                }
              }, '详情'),
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
                    id: 'deleteOrganization',
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
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.orgCode) {
        this.query.parameters.orgCode = this.orgCode
      } else {
        delete this.query.parameters.orgCode
      }
      if (this.name) {
        this.query.parameters.name = this.name
      } else {
        delete this.query.parameters.name
      }
      // 查询机构列表
      let that = this
      this.$axios.post('/organization/list', this.query)
        .then((response) => {
          this.tableData = response.data.list
          response.data.list.forEach(function (e, i) {
            let self = that
            self.provinceAry.forEach(function (even, index) {
              if (self.tableData[i].provinceCode === even.id) {
                self.tableData[i].provinceCode = even.name
                if (self.tableData[i].cityCode && self.tableData[i].cityCode !== '0') {
                  even.city.forEach(function (eve, ind) {
                    if (self.tableData[i].cityCode === eve.id) {
                      self.tableData[i].cityCode = eve.name
                    }
                  })
                } else {
                  even.city.county.forEach(function (a, b) {
                    if (self.tableData[i].countyCode === a.id) {
                      self.tableData[i].cityCode = a.name
                    }
                  })
                }
              }
            })
          })
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
      this.orgCode = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addOrganization'
      })
    },
    doDelete (row) {
      this.$axios.delete('/organization' + '/' + row.id)
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
        name: 'editOrganization',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'organizationDetail',
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
    },
    resetPassword (row) {
      let self = this
      let param = {}
      param.id = row.id
      param.password = '123456'
      this.$axios.put(this.$contants.restful.userResetPwd, param)
        .then(function (response) {
          self.$Message.success('重置密码成功')
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },
  created () {
    this.cityList = cityList
    this.init()
  },
  computed: {},
  activated() {
      this.searchList()
  }
}
</script>
