<style lang="less">
  @import '../../../styles/common.less';

</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="类型名称：" prop="type">
            <Select v-model="type" style="width: 180px"  @on-change="objTypeChange">
              <Option value="0001">支付机构编码表</Option>
              <Option value="0002">行业分类表</Option>
              <Option value="0003">职业分类表</Option>
            </Select>
          </FormItem>
          <FormItem label="子项目编码：" prop="code">
            <Input v-model="code"  :maxlength="100" class="input-width-170"/>
          </FormItem>
          <FormItem label="子项目含义：" prop="value">
            <Input v-model="value" class="input-width-170" :maxlength="1000" />
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listAccount" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" @click="createBtn()" style="margin-right: 10px;" v-access id="addCodeDictionary">新增</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" stripe></Table>
        <br>
        <Page :total="total" :current="currentPage" show-total @on-change="changePage" class="page"></Page>
      </Col>
    </Row>
  </card>
</template>

<script>
import Crypto from 'crypto'
import iconv from 'iconv-lite'

export default {
  name: 'codeDictionaryList',
  data () {
    return {
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      type: '',
      code: '',
      value: '',
      currentPage: 1,
      data1: [{}]
    }
  },
  methods: {
    init () {
      // 设置
      let self = this
      let currentUsername = self.$cookies.get('user')
      let avg = (document.body.clientWidth) / 1440
      console.log(currentUsername)
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 80
        },
        {
          title: '类型代码',
          key: 'type',
          width: 180 * avg
        },
        {
          title: '类型名称',
          key: 'type',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.type === '0001') {
              res = '支付机构编码表'
            }
            if (a.row.type === '0002') {
              res = '行业分类表'
            }
            if (a.row.type === '0003') {
              res = '职业分类表'
            }
            return h('span', res)
          }
        },
        {
          title: '子项目编码',
          key: 'code',
          width: 180 * avg
        },
        {
          title: '子项目含义',
          key: 'value',
          width: 180 * avg
        },
        {
          title: '备注说明',
          key: 'remark'
        },
        {
          title: '操作',
          key: 'action',
          align: 'left',
          width: 200 * avg,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'editCodeDictionary',
                  title: '编辑'
                },
                props: {
                  type: 'edit',
                  size: '16'
                },
                style: {
                  marginRight: '20px',
                  cursor: 'pointer'
                  // marginLeft: (params.row.username === 'admin' || params.row.username === currentUsername) ? '-16px' : ''
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
                style: {
                  display: (params.row.userName === currentUsername || params.row.userName === 'admin') ? 'none' : ''
                },
                on: {
                  'on-ok': () => {
                    this.doDelete(params.row)
                  }
                }
              }, [
                h('svg-icon', {
                  attrs: {
                    id: 'deleteCodeDictionary',
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
      let uri = encodeURI('/codeDictionary/list')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.type) {
        this.query.parameters.type = this.type
      } else {
        delete this.query.parameters.type
      }
      if (this.code) {
        this.query.parameters.code = this.code
      } else {
        delete this.query.parameters.code
      }
      if (this.value) {
        this.query.parameters.value = this.value
      } else {
        delete this.query.parameters.value
      }
      // 查询用户信息
      this.$axios.post(uri, this.query)
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
      this.type = ''
      this.code = ''
      this.value = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addCodeDictionary'
      })
    },
    doDelete (row) {
      this.$axios.delete('codeDictionary' + '/' + row.id)
        .then(() => {
          this.$Message.success('删除成功！')
          this.searchList()
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    update (row) {
      this.$router.push({
        name: 'editCodeDictionary',
        params: {
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'userDetail',
        params: {
          id: row.id
        }
      })
    },
    objTypeChange (val) {
      this.type = val
    }
  },
  created () {
    this.init()
  },
  activated(){
    this.searchList();
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
