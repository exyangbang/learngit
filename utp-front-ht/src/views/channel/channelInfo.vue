<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="渠道名称：" prop="channelName">
            <i-select   style="width:200px" v-model="formData.channelName" :label-in-value = "true" @on-change="channelNameChange">
              <i-option v-for="item in channelNameAry"  :key="item.key" :value="item.key">{{ item.value }}</i-option>
            </i-select>
          </FormItem>
          <FormItem label="渠道编号：" prop="channelCode">
            <Input v-model="channelCode" style="width:200px" :maxlength="32"/>
          </FormItem>
          <FormItem label="支付产品：" prop="productNo">
            <i-select v-model="productNo" style="width:200px" @on-change="productNoChange">
              <i-option v-for="item in productNoAry"  :key="item.id" :value="item.code">{{ item.name }}</i-option>
            </i-select>
          </FormItem>
          <FormItem label="是否可用：" prop="status">
            <i-select v-model="status" style="width:200px" @on-change="statusChange" >
              <i-option v-for="item in statusAry" :value="item.value" :key="item.id">{{ item.name }}</i-option>
            </i-select>
          </FormItem>
          <FormItem label="银联商户号：" prop="channelMerNo">
            <Input v-model="channelMerNo" style="width:200px" :maxlength="32"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listChannel" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addChannel" @click="createBtn()" style="margin-right: 10px;">新增</Button>
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

<script>import Cookies from 'js-cookie'
export default {
  name: 'channelManageList',
  data () {
    return {
      channelNameAry: [],
      productNoAry: [],
      joinTypeAry: [{name: '平台接入', value: '1'}, {name: '机构接入', value: '2'}],
      statusAry: [{name: '启用', value: '1'}, {name: '禁用', value: '0'}],
      channelName: '',
      channelCode: '',
      channelMerNo: '',
      productNo: '',
      pageNo: 1,
      parameters: {},
      status: '',
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
      let that = this
      // 设置
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 70 * avg
        },
        {
          title: '渠道名称',
          key: 'channelName',
          width: 130 * avg,
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
                  title: params.row.channelName
                }
              }, params.row.channelName)
            ])
          }
        },
        {
          title: '银联商户号',
          key: 'channelMerNo',
          width: 120 * avg
        },
        {
          title: '渠道编号',
          key: 'channelCode',
          width: 130 * avg
        },
        {
          title: '支付产品',
          key: 'productName',
          width: 130 * avg
        },
        {
          title: '接入类型',
          key: 'joinType',
          width: 100 * avg
        },
        {
          title: '商户名称',
          key: 'channelMerName',
          width: 100 * avg
        },
        {
          title: '商户简称',
          key: 'channelMerShortName',
          width: 100 * avg
        },
        {
          title: '商户类别',
          key: 'channelMerategory',
          width: 100 * avg
        },
        {
          title: '资金来源',
          key: 'channelCapitalSource',
          width: 100 * avg,
          render (h, a, b) {
            return h('span', that.$contants.dictionary.fundResourcesDic[a.row.channelCapitalSource])
          }
        },
        {
          title: '渠道额度',
          key: 'amount',
          width: 140 * avg,
          render (h, a, b) {
            return h('span', a.row.amount / 100)
          }
        },
        {
          title: '手续费模板名称',
          key: 'chnFeeTemplateName',
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
                  title: params.row.chnFeeTemplateName
                }
              }, params.row.chnFeeTemplateName)
            ])
          }
        },
        {
          idth: 150 * avg,
          title: '操作',
          key: 'action',
          width: 178 * avg,
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'editChannel',
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
                  id: 'detailChannel',
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
                    id: 'deleteChannel',
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
      let channelAry = JSON.parse(Cookies.get('channelDictions'))
      channelAry.forEach(function (e, i) {
        if (e.type === 'channel') {
          that.channelNameAry.push(e)
        }
      })
      let getQuery = {
        pageNo: 1,
        pageSize: 100,
        parameters: {}
      }
      this.$axios.post('/payProduct/list', getQuery).then(function (res) {
        res.data.list.forEach(function (e, i) {
          if (e.status !== '0') {
            that.productNoAry.push(e)
          }
        })
      })
      this.searchList()
    },
    channelNameChange: function (value) {
      if (value) {
        this.channelName = value.label
        this.parameters.channelName = value.label
      } else {
        this.channelName = ''
        this.parameters.channelName = ''
      }
    },
    shuaXinEDu (row) {
      let that = this
      this.$axios.post('/channelLimitAmountReq', row).then(function (res) {
        that.$Message.success('刷新额度成功')
      })
    },
    productNoChange: function (val) {
      this.productNo = val
      this.parameters.productNo = this.productNo
    },
    statusChange: function (val) {
      this.status = val
      this.parameters.status = this.status
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
      let uri = encodeURI('/channelInfo/pageList')
      if (this.channelCode) {
        this.parameters.channelCode = this.channelCode
      } else {
        delete this.parameters.channelCode
      }
      if (this.channelName) {
        this.parameters.channelName = this.channelName
      } else {
        delete this.parameters.channelName
      }
      if (this.status) {
        this.parameters.status = this.status
      } else {
        delete this.parameters.status
      }
      if (this.channelMerNo) {
        this.parameters.channelMerNo = this.channelMerNo
      } else {
        delete this.parameters.channelMerNo
      }
      // let query = {pageNo: param.offset, pageSize: param.limit, parameters: this.parameters}
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: this.parameters}
      // 查询渠道列表
      this.$axios.post(uri, query)
        .then((response) => {
          let that = this
          response.data.list.forEach(function (e, i) {
            if (e.joinType === '1') {
              e.joinType = '平台接入'
            } else {
              e.joinType = '机构接入'
            }
            if (e.status === '1') {
              e.status = '是'
            } else {
              e.status = '否'
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
      this.channelName = ''
      this.channelCode = ''
      this.productNo = ''
      this.status = ''
      this.formData.channelName = ''
      this.channelMerNo = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addChannel'
      })
    },
    doDelete (row) {
      this.$axios.delete('/channelInfo' + '/' + row.id)
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
        name: 'editChannel',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'channelDetail',
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
  computed: {},
  activated() {
      this.searchList()
  }
}
</script>
