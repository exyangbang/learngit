<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="功能账户名称：" prop="name">
            <Input v-model="name" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="功能账户客户号：" prop="code">
            <Input v-model="code" :maxlength="12"/>
          </FormItem>
          <FormItem label="机构代码：" prop="orgCode">
            <Input v-model="orgCode" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="功能账户类型：" prop="industryType">
            <Select v-model="industryType" style="width: 160px" @on-change="chanStatus">
              <Option value="4">手续费收益账户</Option>
              <Option value="5"> 手续费支出账户</Option>
              <Option value="6"> 手续费归集账户</Option>
              <Option value="10">小额打款支出账户</Option>
            </Select>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listFeeAcount" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addFeeAcount" @click="createBtn()" style="margin-right: 10px;">新增</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table :columns="tableColumns" :data="tableData" highlight-row stripe border></Table>
        <br>
        <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"></Page>
      </Col>
    </Row>
    <Modal
      v-model="cashGet"
      title="提现账户配置"
      @on-ok = "getSetData"
      width="350"
    >
      <Form :label-width="120" ref="countData" :model="countData" :rules="ruleValidate" label-position="right" :inline="true">
        <FormItem label="收款方账号：" prop="accountNo">
          <Input v-model="countData.accountNo" :maxlength="20"/>
        </FormItem>
        <FormItem label="收款方户名：" prop="accountName">
          <Input v-model="countData.accountName" :maxlength="200"/>
        </FormItem>
        <FormItem label="清算行号：" prop="payeeOpbk">
          <Input v-model="countData.payeeOpbk" :maxlength="200"/>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="cancel">取消</Button>
        <Button type="primary" size="large" @click="sumbitAccount">确定</Button>
      </div>
    </Modal>
    <!--<Modal-->
      <!--v-model="modalAccount"-->
      <!--title="配置来款账户"-->
    <!--&gt;-->
      <!--<Form :label-width="120" ref="countData" :model="countData" :rules="ruleValidate" label-position="right" :inline="true">-->
        <!--<FormItem label="来款账号：" prop="account">-->
          <!--<Input v-model="countData.account" :maxlength="20"/>-->
        <!--</FormItem>-->
        <!--<FormItem label="来款户名：" prop="accountName">-->
          <!--<Input v-model="countData.accountName" :maxlength="200"/>-->
        <!--</FormItem>-->
      <!--</Form>-->
      <!--<div slot="footer">-->
        <!--<Button type="text" size="large" @click="cancel">取消</Button>-->
        <!--<Button type="primary" size="large" @click="sumbitAccount">确定</Button>-->
      <!--</div>-->
    <!--</Modal>-->
  </card>
</template>

<script>
export default {
  name: "feeAcountList",
  data () {
    return {
      ttaskOffice: '',
      cashGet: false,
      provinceAry: [],
      // cityList: {},
      name: '',
      orgCode: '',
      industryType: '',
      code: '',
      pageNo: 1,
      code: '',
      bankNameAry: [],
      formData: {
        account: '',
        accountName: ''
      },
      countData: {
        accountNo: '',
        accountName: '',
        payeeOpbk: '',
        industryId: '',
        fundAccount: ''
      },
      ruleValidate: {
        accountNo: [
          {required: true, trigger: 'blur', message: '请输入收款方账号'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        accountName: [
          {required: true, trigger: 'blur', message: '请输入收款方名称'}
        ],
        payeeOpbk: [
          {required: true, trigger: 'blur', message: '请输入清算行号'}
        ]
        // custNumber: [
        //   {required: true, trigger: 'blur', message: '请输入客户号'}
        //   // {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        // ],
        // custAccountNo: [
        //   {required: true, trigger: 'blur', message: '请输入客户账户'}
        //   // {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        // ],
        // custAccountName: [
        //   {required: false, trigger: 'blur', message: '请输入客户序号'}
        //   // {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        // ]
      },
      accountFormData: {

      },
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
          title: '机构代码',
          key: 'orgCode',
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
                  title: params.row.orgCode
                }
              }, params.row.orgCode)
            ])
          }
        },
        {
          title: '机构名称',
          key: 'orgName',
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
                  title: params.row.orgName
                }
              }, params.row.orgName)
            ])
          }
        },
        {
          title: '功能账户类型',
          key: 'industryType',
          ellipsis: true,
          render: (h, a, b) => {
            let reslut = ''
            if (a.row.industryType === '4') {
              reslut = '手续费收益账户'
            }
            if (a.row.industryType === '5') {
              reslut = '手续费支出账户'
            }
            if (a.row.industryType === '6') {
              reslut = '手续费归集账户'
            }
            if (a.row.industryType === '10') {
              reslut = '小额打款支出账户'
            }
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
                  title: reslut
                }
              }, reslut)
            ])
          }
        },
        {
          title: '功能账户名称',
          key: 'name',
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
                  title: params.row.name
                }
              }, params.row.name)
            ])
          }
        },
        {
          title: '功能账户简称',
          key: 'simpleName',
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
                  title: params.row.simpleName
                }
              }, params.row.simpleName)
            ])
          }
        },
        {
          title: '功能账户客户号',
          key: 'code',
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
                  title: params.row.code
                }
              }, params.row.code)
            ])
          }
        },
        {
          title: '入金通知URL地址',
          key: 'innerNoticeUrl',
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
                  title: params.row.innerNoticeUrl
                }
              }, params.row.innerNoticeUrl)
            ])
          }
        },
        {
          title: '操作',
          key: 'action',
          width: 250 * avg,
          align: 'left',
          render: (h, params) => {
            if (params.row.industryType === '6') {  // 归集账户
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'editFeeAcount',
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
                    id: 'getCash',
                    title: '提现账户配置'
                  },
                  props: {
                    type: 'cash',
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
                      this.cashGetApply(params.row)
                    }
                  }
                }, '提现账户配置'),
                h('svg-icon', {
                  attrs: {
                    id: 'detailFeeAcount',
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
                      id: 'deleteFeeAcount',
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
            } else if (params.row.industryType === '4') { // 收益账户
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'editFeeAcount',
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
                    id: 'detailFeeAcount',
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
                      id: 'deleteFeeAcount',
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
            } else {
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'editFeeAcount',
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
                    id: 'aboutFeeAcount',
                    title: '来款账户配置'
                  },
                  props: {
                    type: 'modify-pwd',
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
                      this.showRelateIndustry(params.row)
                    }
                  }
                }, '来款账户配置'),

                h('svg-icon', {
                  attrs: {
                    id: 'detailFeeAcount',
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
                      id: 'deleteFeeAcount',
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
      let uri = encodeURI('/industry/pageListFeeAccount')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.name) {
        this.query.parameters.name = this.name
      } else {
        delete this.query.parameters.name
      }
      if (this.code) {
        this.query.parameters.code = this.code
      } else {
        delete this.query.parameters.code
      }
      if (this.orgCode) {
        this.query.parameters.orgCode = this.orgCode
      } else {
        delete this.query.parameters.orgCode
      }
      if (this.industryType) {
        this.query.parameters.industryType = this.industryType
      } else {
        delete this.query.parameters.industryType
      }
      // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          this.tableData = response.data.list
          // let that = this
          // response.data.list.forEach(function (e, i) {
          //   that.provinceAry.forEach(function (even, index) {
          //     if (that.tableData[i].provinceCode === even.id) {
          //       that.tableData[i].provinceCode = even.name
          //       if (that.tableData[i].provinceCode !== '北京' && that.tableData[i].provinceCode !== '上海' && that.tableData[i].provinceCode !== '天津' && that.tableData[i].provinceCode !== '重庆') {
          //         even.city.forEach(function (eve, ind) {
          //           if (that.tableData[i].cityCode === eve.id) {
          //             that.tableData[i].cityCode = eve.name
          //             eve.county.forEach(function (event, idx) {
          //               if (that.tableData[i].countyCode === event.id) {
          //                 that.tableData[i].countyCode = event.name
          //               }
          //             })
          //           }
          //         })
          //       } else {
          //         even.city.county.forEach(function (a, b) {
          //           if (that.tableData[i].countyCode === a.id) {
          //             that.tableData[i].cityCode = ''
          //             that.tableData[i].countyCode = a.name
          //           }
          //         })
          //       }
          //     }
          //   })
          // })
          // that.tableData = response.data
          this.total = response.data.total
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    chanStatus (val) {
      this.industryType = val
    },
    sumbitAccount () {
      let that = this
      this.$refs['countData'].validate((valid) => {
        if (valid) {
          this.$axios.post('/withdrawCashAccount', this.countData).then(function (res) {
            // that.searchList()
            that.$Message.success('提现账户配置成功')
            that.cashGet = false
            that.countData.accountNo = ''
            that.countData.accountName = ''
            that.countData.payeeOpbk = ''
            that.countData.industryId = ''
            that.countData.fundAccount = ''
          })
        } else {
          that.$Message.error('请正确填写信息')
        }
      })
    },
    // 关联商户列表
    showRelateIndustry (row) {
      localStorage.removeItem('industryCodeComing')
      localStorage.setItem('industryCodeComing', row.code)
      localStorage.removeItem('industryType')
      localStorage.setItem('industryType', row.industryType)
      this.$router.push({
        name: 'listIncoming',
        params: {
          id: row.code
        }
      })
    },
    cashGetApply (row) {
      // localStorage.removeItem('accountCash')
      // localStorage.setItem('accountCash', row.account)
      localStorage.removeItem('industryIdCash')
      localStorage.setItem('industryIdCash', row.id)
      localStorage.removeItem('fundAccountCash')
      localStorage.setItem('fundAccountCash', row.fundAccount)

      // industryId: '',
      //   fundAccount: ''
      this.$router.push({
        name: 'infoFeeCashSet',
        params: {
          account: row.account
        }
      })
      // this.cashGet = true
      // this.countData.fundAccount = row.fundAccount
      // this.countData.industryId = row.id
    },
    cancel () {
      this.cashGet = false
      // this.$refs['countData'].resetFields()
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
      this.orgCode = ''
      this.name = ''
      this.code = ''
      this.industryType = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addFeeAcount'
      })
    },
    doDelete (row) {
      this.$axios.delete('/industry/' + row.id)
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
        name: 'editFeeAcount',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'feeAcountDetail',
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
    // this.cityList = cityList
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
