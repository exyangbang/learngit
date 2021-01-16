<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form border :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="证书名称：" prop="certificateName">
            <Input v-model="formData.certificateName" class="input-width-170" :maxlength="200"/>
          </FormItem>
          <FormItem label="客户号：" prop="merNo">
            <Input v-model="formData.industryCode" class="input-width-170" :maxlength="50"/>
          </FormItem>
          <FormItem>
            <Button type="primary" v-access id="orgListCertificateInfo" @click="searchBtn()">查询</Button>
            <Button html-type="reset" class="margin-left-10 " @click="resetBtn()">重置</Button>
            <Button type="success" class="margin-left-10 " v-access id="orgAddCertificateInfo" @click="showCreate()">添加</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table :columns="tableColumns" :data="tableData" border stripe></Table>
        <br>
        <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"></Page>
      </Col>
    </Row>
    <!-- 弹出商户选择框-->
    <Modal v-model="funcModal" title="选择关联客户" width="700" :mask-closable="false">
      <func-list v-if="funcModalShow"  @checkFunc="checkFunc" @hideFunc="hideFunc" :selectedItem="this.selectedItem" :sureBtnDisabled=true></func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>

import funcList from './components/funcListNew.vue'

export default {
  name: "orgCerManage",
  components: {
    funcList: funcList
  },
  data () {
    return {
      selectedItem: '',
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      pageNo: 1,
      pageSize: 10,
      funcTableColumns: [],
      funcModal: false,
      funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init () {
      // 关联商户
      this.funcTableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 160
        },
        // {
        //   title: '商户名称',
        //   key: 'merName'
        // },
        {
          title: '商户号',
          key: 'merNo'
        }
      ]
      let self = this
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 80
        },
        {
          title: '证书名称',
          key: 'certificateName'
        },
        {
          title: '生效日期',
          key: 'effectiveDate',
          render: function (h) {
            return h('div', self.$moment(this.row.effectiveDate).format('YYYY-MM-DD'))
          }
        },
        {
          title: '失效日期',
          key: 'expirationDate',
          render: function (h) {
            return h('div', self.$moment(this.row.expirationDate).format('YYYY-MM-DD'))
          }
        },
        {
          title: '最近修改时间',
          key: 'gmtModified',
          width: 200,
          render: function (h) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '最近修改人',
          key: 'userModified'
        },
        {
          title: '备注',
          key: 'remark'
        },
        {
          title: '操作',
          key: 'action',
          fixed: 'right',
          align: 'center',
          width: 180,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'orgEditCertificateInfo',
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
                    this.showEdit(params.row)
                  }
                }
              }, '编辑'),
              h('svg-icon', {
                attrs: {
                  id: 'orgRefCertificateInfo',
                  title: '关联'
                },
                props: {
                  type: 'link',
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
                    this.showRelateMerchant(params.row)
                  }
                }
              }, '关联'),
              h('Poptip', {
                attrs: {
                  id: 'orgDeleteCertificateInfo'
                },
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
                    id: 'orgDeleteCertificateInfo',
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
      this.searchList()
    },
    searchList (param) {
      let page = {
        pageNo: this.pageNo,
        pageSize: '10'
      }
      param = param || {}
      param.pageNo = page.pageNo
      param.pageSize = page.pageSize
      let parameters = {
        certificateType: null
      }
      parameters.certificateType = '1'
      parameters = Object.assign(parameters, this.formData)
      param.parameters = parameters
      this.$axios.post(this.$contants.restful.certificateInfos, param)
        .then((response) => {
          this.tableData = response.data.list
          this.total = response.data.total
        })
        .catch(function (error) {
          console.log(error)
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
      this.formData = {}
      this.pageNo = 1
    },
    showEdit (row) {
      this.$router.push({
        name: 'editOrgCer',
        params: {
          id: row.id
        }
      })
    },
    doDelete (row) {
      let self = this
      this.$axios.delete(this.$contants.restful.certificateInfo + '/' + row.id)
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
        name: 'detailOrgCer',
        params: {
          id: row.id
        }
      })
    },
    showCreate () {
      this.$router.push({
        name: 'addOrgCer'
      })
    },
    // 关联商户列表
    showRelateMerchant (row) {
      this.selectedItem = row
      this.funcModalShow = true
      this.funcModal = !this.funcModal
    },
    // 获取到选中的数据
    checkFunc (data) {
      this.funcModal = !this.funcModal
      this.funcModalShow = false
    },
    hideFunc () {
      this.funcModalShow = false
      this.funcModal = !this.funcModal
    }
  },
  mounted () {
    this.init()
  },
  activated() {
      this.searchList()
  }
}
</script>
