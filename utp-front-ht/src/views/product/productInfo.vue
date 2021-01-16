<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="支付产品名称：" prop="name">
            <Input v-model="name" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="支付产品编码：" prop="code">
            <Input v-model="code" :maxlength="10"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listProduct" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <!--<Button type="success" v-access id="addProduct" @click="createBtn()" style="margin-right: 10px;">新增</Button>-->
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
  name: "productInfo",
  data () {
    return {
      provinceAry: [],
      cityList: {},
      name: '',
      code: '',
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
          title: '支付产品编码',
          key: 'code',
          width: 150 * avg
        },
        {
          title: '支付产品名称',
          key: 'name'
        },
        {
          title: '产品状态',
          key: 'status',
          width: 100 * avg
        },
        {
          title: '备注信息',
          key: 'remark'
        },
        {
          title: '最近修改人',
          key: 'userModified',
          width: 200 * avg
        },
        {
          title: '最近修改时间',
          key: 'gmtModified',
          width: 200 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
            // var d = new Date(a.row.gmtModified)
            // let mm = ''
            // let dd = ''
            // let hh = ''
            // let min = ''
            // let ss = ''
            // if (d.getMonth() + 1 < 10) {
            //   mm = '0' + (d.getMonth() + 1).toString()
            // } else {
            //   mm = d.getMonth() + 1
            // }
            // if (d.getDate() < 10) {
            //   dd = '0' + d.getDate().toString()
            // } else {
            //   dd = d.getDate()
            // }
            // if (d.getHours() < 10) {
            //   hh = '0' + d.getHours().toString()
            // } else {
            //   hh = d.getHours()
            // }
            // if (d.getMinutes() < 10) {
            //   min = '0' + d.getMinutes().toString()
            // } else {
            //   min = d.getMinutes()
            // }
            // if (d.getSeconds() < 10) {
            //   ss = '0' + d.getSeconds().toString()
            // } else {
            //   ss = d.getSeconds()
            // }
            // var times = d.getFullYear() + '-' + mm + '-' + dd + ' ' + hh + ':' + min + ':' + ss
            // return h('span', times)
          }
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
              h('svg-icon', {
                attrs: {
                  id: 'detailProduct',
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
      let uri = encodeURI('/payProduct/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {name: this.name, code: this.code}}
      if (this.name) {
        query = {pageNo: param.offset, pageSize: param.limit, parameters: {name: this.name}}
      }
      if (this.code) {
        query = {pageNo: param.offset, pageSize: param.limit, parameters: {code: this.code}}
      }
      if (!this.name && !this.code) {
        query = {pageNo: param.offset, pageSize: param.limit}
      }
      if (this.name && this.code) {
        query = {pageNo: param.offset, pageSize: param.limit, parameters: {name: this.name, code: this.code}}
      }
      // 查询机构列表
      // let that = this
      this.$axios.post(uri, query)
        .then((response) => {
          response.data.list.forEach(function (e, i) {
            if (e.status === '0') {
              e.status = '禁用'
            }
            if (e.status === '1') {
              e.status = '启用'
            }
          })
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
      this.code = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addProduct'
      })
    },
    doDelete (row) {
      this.$axios.delete('/payProduct' + '/' + row.id)
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
        name: 'editProduct',
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
