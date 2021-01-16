<style lang="less">
  @import '../../styles/common.less';
</style>
<template>
  <card>
    <Row>
      <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
        <Col>
          <FormItem label="机构名称：" prop="orgCode">
            <Select v-model="formData.parameters.orgCode" class="input-width-170">
              <Option v-for="item in orgData" :value="item.orgCode" :key="item.orgCode">{{ item.fullName }}</Option>
            </Select>
          </FormItem>
          <FormItem label="商户号：" prop="merNo">
            <Input v-model="formData.parameters.merNo" :maxlength="12" class="input-width-170"/>
          </FormItem>
          <FormItem label="商户名称：" prop="merName" >
            <Input v-model="formData.parameters.merName" class="input-width-170"/>
          </FormItem>
          <FormItem>
            <Button type="primary" @click="searchBtn()" v-access id="listMerchant">查询</Button>
            <Button html-type="reset" class="margin-left-10 " @click="resetBtn()">重置</Button>
            <Button type="info" class="margin-left-10 " @click="showImport()" v-access id="importMerchant">商户导入</Button>
            <Button type="success" class="margin-left-10 " @click="createBtn()" v-access id="addMerchant">新增商户</Button>
          </FormItem>
        </Col>
      </Form>
    </Row>
    <Row>
      <Col>
        <Table :columns="tableColumns" :data="tableData" border stripe></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
          </div>
        </div>
      </Col>
    </Row>
  </card>
</template>
<script>
export default {
  name: "merchantManageList",
  data () {
    return {
      formData: {parameters: {}},
      tableColumns: [],
      tableData: [],
      orgData: [],
      total: 0,
      pageNo: 1,
      pageSize: 10
    }
  },
  methods: {
    init () {
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 80
        },
        {
          title: '商户号',
          key: 'merNo',
          width: 200 * avg,
          ellipsis: true
        },
        {
          title: '商户名称',
          key: 'merName',
          width: 200 * avg,
          ellipsis: true
        },
        {
          title: '所属收单机构代码',
          key: 'orgCode',
          width: 200 * avg,
          ellipsis: true
        },
        {
          title: '所属收单机构名称',
          key: 'orgName',
          width: 200 * avg,
          ellipsis: true
        },
        {
          title: '所属平台编号',
          key: 'industryCode',
          width: 200 * avg,
          ellipsis: true
        },
        {
          title: '所属平台名称',
          key: 'industryName',
          width: 200 * avg,
          ellipsis: true
        },
        {
          title: '商户类型',
          key: 'accountType',
          width: 100 * avg,
          ellipsis: true,
          render (h, a, b) {
            let getReslt = ''
            if (a.row.accountType === 'public') {
              getReslt = '对公'
            }
            if (a.row.accountType === 'private') {
              getReslt = '对私'
            }
            return h('span', getReslt)
          }
        },
        {
          title: '商户账户名称',
          key: 'accountName',
          width: 100 * avg,
          ellipsis: true
        },
        {
          title: '商户账号',
          key: 'accountNo',
          width: 100 * avg,
          ellipsis: true,
          render (h, a, b) {
            let getReslt = ''
            if (a.row.accountNo) {
              if (a.row.accountNo.length >= 11) {
                let stringAry = a.row.accountNo.split('')
                stringAry[8] = '*'
                stringAry[9] = '*'
                stringAry[10] = '*'
                getReslt = stringAry.join('')
              }
            }
            return h('span', getReslt)
          }
        },
        {
          title: '商户清算行号',
          key: 'bankCode',
          width: 100 * avg,
          ellipsis: true
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 200 * avg,
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
              // h('svg-icon', {
              //   attrs: {
              //     id: 'detailOrganization',
              //     title: '详情'
              //   },
              //   props: {
              //     type: 'detail',
              //     size: '16'
              //   },
              //   style: {
              //     marginRight: '20px',
              //     cursor: 'pointer'
              //   },
              //   directives: [{
              //     name: 'access'
              //   }],
              //   on: {
              //     click: () => {
              //       this.showDetail(params.row)
              //     }
              //   }
              // }, '详情'),
              // h('svg-icon', {
              //   attrs: {
              //     id: 'channelRefCertificateInfo',
              //     title: '关联'
              //   },
              //   props: {
              //     type: 'link',
              //     size: '16'
              //   },
              //   style: {
              //     marginRight: '20px',
              //     cursor: 'pointer'
              //   },
              //   directives: [{
              //     name: 'access'
              //   }],
              //   on: {
              //     click: () => {
              //       this.showRelateMerchant(params.row)
              //     }
              //   }
              // }, '关联'),
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
      this.searchList()
      // this.searchOrg()
    },
    // 关联商户列表
    showRelateMerchant (row) {
      this.$router.push({
        name: 'linkMerchantList',
        params: {
          id: row.merNo,
          merName: row.merName,
          merNo: row.merNo
        }
      })
    },
    // 获取到选中的数据
    checkFunc (data) {
      this.funcModal = !this.funcModal
      this.funcModalShow = false
    },
    hideFunc () {
      this.funcModalShow = false
      this.funcModal = !this.funcModal
    },
    update (row) {
      this.$router.push({
        name: 'editMerchant',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    searchOrg () {
      let self = this
      this.$axios.get(this.$contants.restful.organizations + '?pageNo=1&pageSize=1000')
        .then(function (response) {
          self.orgData = response.data.list
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    searchList () {
      let self = this
      // let queryUrl = this.$contants.restful.merchantInfos
      self.formData.pageNo = self.pageNo
      self.formData.pageSize = self.pageSize
      this.$axios.post('merchantInfo/list', self.formData)
        .then(function (response) {
          self.tableData = response.data.list
          self.total = response.data.total
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    createBtn () {
      this.$router.push({
        name: 'addMerchant'
      })
    },
    changePage (index) {
      // 分页点击事件
      this.pageNo = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.pageNo = 1
      this.searchList()
    },
    resetBtn () {
      this.formData = {parameters: {}}
      this.pageNo = 1
      // this.searchOrg()
    },
    showEdit (row) {
      this.$router.push({
        name: 'editMerchant',
        params: {
          id: row.id
        }
      })
    },
    doDelete (row) {
      let self = this
      this.$axios.delete('merchantInfo/delete/' + row.id)
        .then(function () {
          self.$Message.success('删除成功！')
          self.searchList()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    showDetail (row) {
      this.$router.push({
        name: 'detailMerchant',
        params: {
          id: row.id
        }
      })
    },
    showImport () {
      this.$router.push({
        name: 'importMerchant'
      })
    }
  },
  mounted () {
    this.init()
  },
  beforeDestroy () {

  },
  created () {
  },
  activated() {
      this.searchList()
  }
}
</script>
