<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <!--<FormItem label="卡名称：" prop="cardname">-->
            <!--<Input v-model="cardname" :maxlength="20"/>-->
          <!--</FormItem>-->
          <FormItem label="卡BIN号：" prop="binnum">
            <Input v-model="binnum" :maxlength="accountSize"/>
          </FormItem>
          <FormItem label="卡种：" prop="debitcreditflag">
            <i-select  style="width:200px" :label-in-value = "true" v-model="debitcreditflag"  @on-change="debitcreditflagChange">
              <i-option value="D">借记卡</i-option>
              <i-option value="C">贷记卡</i-option>
              <i-option value="Z">准贷记卡</i-option>
              <i-option value="Y">预付卡</i-option>
            </i-select>
          </FormItem>
          <FormItem label="发卡行机构名称：" prop="issuername">
            <Input v-model="issuername" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="发卡行机构代码：" prop="issuercode">
            <Input v-model="issuercode" :maxlength="accountSize"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listCardBinInfo" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addCardBinInfo" @click="createBtn()" style="margin-right: 10px;">新增</Button>
            <Button type="warning" v-access @click="importBtn()" id="importCardBinInfo" style="margin-right: 10px;">导入</Button>
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
    name: 'cardBinInfoList',
  data () {
    return {
      jobDateAry: [],
      // cardname: '',
      binnum: '',
      issuercode: '',
      issuername: '',
      debitcreditflag: '',
      formData: {},
      startTime: '',
      endTime: '',
      query: {
        parameters: {
        }
      },
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}],
      mySelectedData: this.selectedItem,
      selectedMerchant: [],
      selectedMerchId: [],
      beginDateOption: {

      },
      endDateOption: {

      }
    }
  },
  methods: {
    init () {
      // 设置
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 80
        },
        {
          title: '卡BIN号 ',
          key: 'binnum',
          width: 100 * avg
        },
        {
          title: '所属行行名称',
          key: 'bankname',
          width: 120 * avg
        },
        {
          title: '所属行行号',
          key: 'bankcode',
          width: 120 * avg
        },
        {
          title: '所属行分类标识',
          key: 'banktypeflag',
          width: 100 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.banktypeflag === '0') {
              reslut = '一般银行'
            }
            if (a.row.banktypeflag === '1') {
              reslut = '村镇银行'
            }
            if (a.row.banktypeflag === '2') {
              reslut = '港澳外资银行'
            }
            return h('span', reslut)
          }
        },
        {
          title: '卡BIN长度',
          width: 80 * avg,
          key: 'binlen'
        },
        {
          title: '卡BIN起始字节',
          key: 'binstartpos',
          width: 100 * avg
        },
        {
          title: '主账号长度',
          key: 'cardnolen',
          width: 100 * avg
        },
        {
          title: '主账号起始字节',
          key: 'cardnostartPos',
          width: 100 * avg
        },
        {
          title: '人行清算行行名',
          key: 'clearbankname',
          width: 120 * avg
        },
        {
          title: '人行清算行行号',
          key: 'clearbankno',
          width: 120 * avg
        },
        {
          title: '是否银联卡品牌',
          key: 'cuplogoflag',
          width: 120 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.cuplogoflag === '0') {
              reslut = '否'
            }
            if (a.row.cuplogoflag === '1') {
              reslut = '是'
            }
            return h('span', reslut)
          }
        },
        {
          title: '卡种',
          key: 'debitcreditflag',
          width: 100 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.debitcreditflag === 'D') {
              reslut = '借记卡'
            }
            if (a.row.debitcreditflag === 'C') {
              reslut = '贷记卡'
            }
            if (a.row.debitcreditflag === 'Z') {
              reslut = '准贷记卡'
            }
            if (a.row.debitcreditflag === 'Y') {
              reslut = '预付卡'
            }
            return h('span', reslut)
          }
        },
        {
          title: '发卡行机构代码',
          key: 'issuercode',
          width: 100 * avg
        },
        {
          title: '发卡机构名称 ',
          key: 'issuername',
          width: 100 * avg
        },
        {
          title: '状态',
          key: 'status',
          width: 60 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.status === '0') {
              reslut = '禁用'
            }
            if (a.row.status === '1') {
              reslut = '启用'
            }
            return h('span', reslut)
          }
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 150,
          render: (h, params) => {
            return h('div', [
              // h('svg-icon', {
              //   attrs: {
              //     id: 'editOrganization',
              //     title: '编辑'
              //   },
              //   props: {
              //     type: 'edit',
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
              //       this.update(params.row)
              //     }
              //   }
              // }, '编辑'),
              h('svg-icon', {
                attrs: {
                  id: 'detailCardBinInfo',
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
                    id: 'deleteCardBinInfo',
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
      // 查询信息
      let self = this
      this.$axios.get('/dictionaries').then(function (res) {
        self.bankNameAry = res.data.bank
      })
      this.searchList()
    },
    debitcreditflagChange (val) {
      this.debitcreditflag = val.value
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
      let uri = encodeURI('/cardBinInfo/pageList')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.binnum) {
        this.query.parameters.binnum = this.binnum
      } else {
        delete this.query.parameters.binnum
      }
      if (this.issuercode) {
        this.query.parameters.issuercode = this.issuercode
      } else {
        delete this.query.parameters.issuercode
      }
      if (this.issuername) {
        this.query.parameters.issuername = this.issuername
      } else {
        delete this.query.parameters.issuername
      }
      if (this.debitcreditflag) {
        this.query.parameters.debitcreditflag = this.debitcreditflag
      } else {
        delete this.query.parameters.debitcreditflag
      }
      // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          this.tableData = response.data.list
          this.total = response.data.total
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    jobNameChange (val) {
      this.jobName = val.label
      this.jobId = val.value
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
      this.binnum = ''
      this.issuercode = ''
      this.issuername = ''
      this.debitcreditflag = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addCardBinInfo'
      })
    },
    importBtn() {
      this.$router.push({
        name: 'importCardBinInfo'
      })
    },
    doDelete (row) {
      this.$axios.delete('/cardBinInfo' + '/' + row.id)
        .then((res) => {
          if (res.status === 200) {
            this.$Message.success('删除成功！')
            this.searchList()
          } else {
            this.$Message.error('删除失败！')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    update (row) {
      this.$router.push({
        name: 'editCardBinInfo',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'cardBinInfoDetail',
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
  activated() {
        this.searchList()
  }
}
</script>
