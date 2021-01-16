<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="手续费模板名称：" prop="name">
            <Input v-model="name" :maxlength="nameSize"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listFee" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addFee" @click="createBtn()" style="margin-right: 10px;">新增</Button>
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
  name: "feeManageList",
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
      data1: [{}],
      mySelectedData: this.selectedItem,
      selectedMerchant: [],
      selectedMerchId: []
    }
  },
  methods: {
    init () {
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
          title: '手续费模板名称',
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
          title: '手续费结算类型',
          key: 'settleType',
          width: 150 * avg
        },
        {
          title: '手续费收费方式',
          key: 'chargeMode',
          width: 150 * avg
        },
        {
          title: '手续费计算方式',
          key: 'calculateMode',
          width: 150 * avg
        },
        {
          title: '手续费',
          key: 'fee',
          width: 120 * avg
        },
        {
          title: '最小手续费',
          key: 'minFee',
          width: 100 * avg,
          render (h, a, b) {
            if (a.row.minFee === '0元') {
              return h('span', '')
            } else {
              return h('span', a.row.minFee)
            }
          }
        },
        {
          title: '最大手续费',
          key: 'maxFee',
          width: 100 * avg,
          render (h, a, b) {
            if (a.row.maxFee === '0元') {
              return h('span', '')
            } else {
              return h('span', a.row.maxFee)
            }
          }
        },
        {
          title: '备注信息',
          key: 'remark',
          ellipsis: true,
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
                  id: 'editFee',
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
                  id: 'detailFee',
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
                    id: 'deleteFee',
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
      let uri = encodeURI('/feeTemplate/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {name: this.name}}
      if (this.name) {
        query = {pageNo: param.offset, pageSize: param.limit, parameters: {name: this.name}}
      } else {
        query = {pageNo: param.offset, pageSize: param.limit}
      }
      // 查询手续费模板列表
      this.$axios.post(uri, query)
        .then((response) => {
          let that = this
          response.data.list.forEach(function (e, i) {
            if (e.calculateMode === '1') {
              e.calculateMode = '按笔定额'
              e.fee = e.fee / 100 + '元'
              e.maxFee = ''
              e.minFee = ''
              // if (e.maxFee !== 'null' && e.maxFee !== null) {
              //   e.maxFee = e.maxFee / 100 + '元'
              //   e.minFee = e.minFee / 100 + '元'
              // }
            }
            if (e.calculateMode === '2') {
              e.calculateMode = '按固定费率'
              if (e.fee || e.fee === 0) {
                e.fee = e.fee / 1000 + '%'
                if (e.maxFee !== 'null' && e.maxFee !== 'null') {
                  e.maxFee = e.maxFee / 100 + '元'
                  e.minFee = e.minFee / 100 + '元'
                }
              }
            }
            if (e.calculateMode === '3') {
              e.calculateMode = '按笔定额-区间'
              e.fee = '区间价格'
              e.maxFee = ''
              e.minFee = ''
            }
            if (e.settleType === '1') {
              e.settleType = '实时'
            }
            if (e.settleType === '2') {
              e.settleType = '后结'
            }
            if (e.chargeMode === '1') {
              e.chargeMode = '内扣'
            }
            if (e.chargeMode === '2') {
              e.chargeMode = '外扣'
            }
          })
          that.tableData = response.data.list
          that.total = parseInt(response.data.total)
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
      localStorage.removeItem('contentEdit')
      this.$router.push({
        name: 'addFee'
      })
    },
    doDelete (row) {
      this.$axios.delete('/feeTemplate' + '/' + row.id)
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
      localStorage.removeItem('contentEdit')
      this.$router.push({
        name: 'editFee',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'feeDetail',
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
