<style lang="less">
  @import '../../../styles/common.less';

</style>
<template>
  <card>
    <Row>
      <Col>
        <Form ref="form" :model="formData" label-position="right" :inline="true">
          <!--<FormItem label="登录账号：" prop="userName">-->
            <!--<Input v-model="formData.userName" :maxlength="accountSize" class="input-width-170"/>-->
          <!--</FormItem>-->
          <!--<FormItem label="姓名：" prop="name">-->
            <!--<Input v-model="formData.name" class="input-width-170" :maxlength="20" />-->
          <!--</FormItem>-->
          <FormItem>
            <!--<Button type="primary" @click="searchBtn()" style="margin-right: 10px;" v-access id="channelRespcodeList">查询</Button>-->
            <!--<Button type="default" @click="clearBtn()" style="margin-right: 10px;" v-access >重置</Button>-->
            <Button type="success" @click="createBtn()" style="margin-right: 10px;" v-access id="channelRespcodeDelete">新增</Button>
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
    name: 'channelRespcodeList',
    data () {
    return {
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}]
      // ruleValidate: {
      //   name: [
      //     {required: true, trigger: 'blur', message: '请输入姓名', max: 20},
      //     {pattern: /^[\u4e00-\u9fff\w]{1,20}$/, message: '姓名为汉字、字母、数字、下划线或其组合！'}
      //   ],
      //   username: [
      //     {required: true, trigger: 'blur', message: '登录账号', max: 20},
      //     {pattern: /^[a-zA-Z0-9_]{1,20}$/, message: '登录账号为字母、数字、下划线或其组合！'}
      //   ]
      // }
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
          title: '交易状态',
          key: 'transStatus',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.transStatus === 'TRADE_SUCCESS') {
              res = '交易成功'
            }
            if (a.row.transStatus === 'TRADE_FAILURE') {
              res = '交易失败'
            }
            if (a.row.transStatus === 'PROCESSING') {
              res = '交易处理中'
            }
            return h('span', res)
          }
        },
        {
          title: '渠道响应码',
          key: 'channelRespcode',
          width: 180 * avg
        },
        {
          title: '渠道响应码描述',
          key: 'channelRespdesc',
          width: 180 * avg
        },
        {
          title: '启用状态',
          key: 'status',
          render (h, a, b) {
            let res = ''
            if (a.row.status === '0') {
              res = '不启用'
            }
            if (a.row.status === '1') {
              res = '启用'
            }
            return h('span', res)
          }
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
                  id: 'channelRespcodeDelete',
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
                    id: 'channelRespcodeDelete',
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
        pageNo: this.currentPage,
        pageSize: 10
      }
      param = param || {}
      param.pageNo = page.pageNo
      param.pageSize = page.pageSize
      // param = Object.assign(param, this.formData)
      let uri = '/channelRespcode/list'
      // 查询用户信息
      this.$axios.post(uri, param)
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
    // clearBtn () {
    //   this.formData = {}
    // },
    createBtn () {
      this.$router.push({
        name: 'addChannelRespcode'
      })
    },
    doDelete (row) {
      this.$axios.delete('channelRespcode' + '/' + row.id)
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
        name: 'editChannelRespcode',
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
    changePassword (row) {
      this.$router.push({
        name: 'userChangePassword',
        params: {
          userName: row.userName
        }
      })
    },
    resetPassword (row) {
      let self = this
      let param = {}
      param.id = row.id
      param.password = '123456'
      // let md5 = crypto.createHash('md5')
      // md5.update(param.password)
      // let pwd = md5.digest('hex')
      // param.password = pwd
      let sha256 = Crypto.createHash('sha256')
      let str = param.password + '{' + row.userName + '}'
      str = iconv.decode(str, 'gbk')
      sha256.update(str)
      let newPwd = sha256.digest('hex').toUpperCase()
      param.password = newPwd
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
