<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="客户名称：" prop="name">
            <Input v-model="name" :maxlength="nameSize"/>
          </FormItem>
          <FormItem label="客户号：" prop="code">
            <Input v-model="code" :maxlength="12"/>
          </FormItem>
          <FormItem label="机构代码：" prop="orgCode">
            <Input v-model="orgCode" :maxlength="nameSize"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="listIndustry" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="addIndustry" @click="createBtn()" style="margin-right: 10px;">新增</Button>
            <Button type="warning" v-access id="auditStatusApply" @click="industryApply()" style="margin-right: 10px;" :disabled="applyBtn">审核</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table :columns="tableColumns" :data="tableData" border @on-current-change="selectDataNew" highlight-row stripe></Table>
        <br>
        <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"></Page>
      </Col>
    </Row>
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
        <!--<FormItem label="来款银行名称：" prop="bankName">-->
          <!--<i-select v-model="countData.bankName" style="width: 300px" :label-in-value = "true">-->
            <!--<i-option v-for="item in bankNameAry"  :key="item.key" :value="item.value">{{ item.value }}</i-option>-->
          <!--</i-select>-->
        <!--</FormItem>-->
        <!--<FormItem label="来款银行行号：" prop="bankCode">-->
          <!--<Input v-model="countData.bankCode" :maxlength="20"/>-->
        <!--</FormItem>-->
        <!--<FormItem label="客户号：" prop="custNumber">-->
          <!--<Input v-model="countData.custNumber" :maxlength="40"/>-->
        <!--</FormItem>-->
        <!--<FormItem label="客户账户：" prop="custAccountNo">-->
          <!--<Input v-model="countData.custAccountNo" :maxlength="40"/>-->
        <!--</FormItem>-->
        <!--<FormItem label="客户账号名称：" prop="custAccountName">-->
          <!--<Input v-model="countData.custAccountName" :maxlength="100"/>-->
        <!--</FormItem>-->
      <!--</Form>-->
      <!--<div slot="footer">-->
        <!--<Button type="text" size="large" @click="cancel">取消</Button>-->
        <!--<Button type="primary" size="large" @click="sumbitAccount">确定</Button>-->
      <!--</div>-->
    <!--</Modal>-->
    <Modal
      v-model="modalData"
      title="重置日期"
      @on-ok = "getSetData"
      width="300"
    >
      <Date-picker  @on-change="dataChange" v-model="lastDate" format="yyyyMMdd" type="date" placeholder="选择日期"></Date-picker>
    </Modal>
    <Modal
      v-model="examineStatu"
      title="客户审核"
      width="350"
    >
      <Select v-model="auditStatus" style="width: 180px"  @on-change="auditStatusChange">
        <i-option value="1">审核通过</i-option>
        <i-option value="2">审核驳回</i-option>
      </Select>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelAuditStatus">取消</Button>
        <Button type="primary" size="large" @click="sumbitAuditStatus">确定</Button>
      </div>
    </Modal>
  </card>
</template>

<script>import cityList from '../../libs/content'
export default {
  name: 'industryList',
  data () {
    return {
      id: '',
      applyBtn: true,
      auditStatus: '',
      examineStatu: false,
      lastDate: '',
      modalAccount: false,
      modalData: false,
      provinceAry: [],
      cityList: {},
      name: '',
      pageNo: 1,
      code: '',
      orgCode: '',
      bankNameAry: [],
      formData: {
        account: '',
        accountName: '',
        bankName: '',
        bankCode: ''
      },
      countData: {
        account: '',
        accountName: '',
        bankCode: '',
        bankName: '',
        cityCode: '',
        code: '',
        countyCode: '',
        id: '',
        name: '',
        provinceCode: '',
        simpleName: '',
        status: '',
        custNumber: '',
        custAccountNo: '',
        custAccountName: ''
      },
      ruleValidate: {
        account: [
          {required: true, trigger: 'blur', message: '请输入来款号'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        bankCode: [
          {pattern: /^[0-9]*$/, message: '只能输入数字和字母！'}
        ],
        bankName: [
          {required: true, trigger: 'blur', message: '请选择来款银行名称'}
        ],
        accountName: [
          {required: true, trigger: 'blur', message: '请输入来款户名'}
        ],
        custNumber: [
          {required: true, trigger: 'blur', message: '请输入客户号'}
          // {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        custAccountNo: [
          {required: true, trigger: 'blur', message: '请输入客户账户'}
          // {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        custAccountName: [
          {required: false, trigger: 'blur', message: '请输入客户序号'}
          // {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ]
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
      this.provinceAry = this.cityList.China.province
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
          width: 120 * avg,
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
          width: 150 * avg,
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
          title: '客户名称',
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
          title: '客户简称',
          key: 'simpleName',
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
                  title: params.row.simpleName
                }
              }, params.row.simpleName)
            ])
          }
        },
        {
          title: '客户号',
          key: 'code',
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
                  title: params.row.code
                }
              }, params.row.code)
            ])
          }
        },
        {
          title: '入金通知url',
          key: 'innerNoticeUrl',
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
                  title: params.row.innerNoticeUrl
                }
              }, params.row.innerNoticeUrl)
            ])
          }
        },
        {
          title: '证书DN',
          key: 'dn',
          width: 120 * avg,
        },
        {
          title: '二级账户是否对外接款',
          key: 'whetherExternal',
          width: 150 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.whetherExternal === '0') {
              reslut = '不对外'
            }
            if (a.row.whetherExternal === '1') {
              reslut = '对外'
            }
            return h('span', reslut)
          }
        },
        {
          title: '状态',
          key: 'auditStatus',
          width: 120 * avg,
          render (h, a, b) {
            let reslut = ''
            if (a.row.auditStatus === '0') {
              reslut = '待审核'
            }
            if (a.row.auditStatus === '1') {
              reslut = '审核通过'
            }
            if (a.row.auditStatus === '2') {
              reslut = '审核驳回'
            }
            return h('span', reslut)
          }
        },
        {
          title: '操作',
          key: 'action',
          align: 'left',
          width: 320 * avg,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'editIndustry',
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
                  id: 'subPayPayeeWhiteList',
                  title: '子账户单笔付款收款白名单'
                },
                props: {
                  type: 'user',
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
                    this.subPayPayeeWhiteList(params.row)
                  }
                }
              }, '收款白名单'),
              h('svg-icon', {
                attrs: {
                  id: 'ListIndustryFeeAccount',
                  title: '配置来款账户'
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
                    this.setAccount(params.row)
                  }
                }
              }, '配置来款账户'),
              h('svg-icon', {
                attrs: {
                  id: 'addChannelIndustry',
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
                    this.showRelateIndustry(params.row)
                  }
                }
              }, '关联'),
              h('svg-icon', {
                attrs: {
                  id: 'detailIndustry',
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
              h('svg-icon', {
                attrs: {
                  id: 'resetDate',
                  title: '日期重置'
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
                    this.resetData(params.row)
                  }
                }
              }, '日期重置'),
              h('svg-icon', {
                attrs: {
                  id: 'editIndustry',
                  title: '上传资料'
                },
                props: {
                  type: 'data',
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
                    this.updataMyData(params.row)
                  }
                }
              }, '上传资料'),
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
                    id: 'deleteIndustry',
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
      let self = this
      this.$axios.get('/dictionaries').then(function (res) {
        self.bankNameAry = res.data.bank
      })
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
      let uri = encodeURI('/industry/pageList')
      this.query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      this.query.parameters.industryType = '1'
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
      this.query.parameters.customers = '1'
      // 查询手续费模板列表
      this.$axios.post(uri, this.query)
        .then((response) => {
          this.tableData = response.data.list
          let that = this
          this.applyBtn = true
          response.data.list.forEach(function (e, i) {
            that.provinceAry.forEach(function (even, index) {
              if (that.tableData[i].provinceCode === even.id) {
                that.tableData[i].provinceCode = even.name
                if (that.tableData[i].provinceCode !== '北京' && that.tableData[i].provinceCode !== '上海' && that.tableData[i].provinceCode !== '天津' && that.tableData[i].provinceCode !== '重庆') {
                  even.city.forEach(function (eve, ind) {
                    if (that.tableData[i].cityCode === eve.id) {
                      that.tableData[i].cityCode = eve.name
                      eve.county.forEach(function (event, idx) {
                        if (that.tableData[i].countyCode === event.id) {
                          that.tableData[i].countyCode = event.name
                        }
                      })
                    }
                  })
                } else {
                  even.city.county.forEach(function (a, b) {
                    if (that.tableData[i].countyCode === a.id) {
                      that.tableData[i].cityCode = ''
                      that.tableData[i].countyCode = a.name
                    }
                  })
                }
              }
            })
          })
          // that.tableData = response.data
          this.total = parseInt(response.data.total)
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    resetData (row) {
      this.modalData = true
      this.lastDate = ''
      this.industryCode = row.code
    },
    updataMyData (row) {
      // localStorage.removeItem('addIndustryDataId')
      // localStorage.setItem('addIndustryDataId', row.id)
      this.$router.push({
        name: 'addIndustryData',
        params: {
          id: row.id
        }
      })
    },
    cancelAuditStatus () {
      this.examineStatu = false
    },
    sumbitAuditStatus () {
      let that = this
      if (this.examineStatu && this.id) {
        let formData = {
          auditStatus: this.auditStatus,
          id: this.id
        }
        this.$axios.put('/examine/upd', formData).then(function (res) {
          that.auditStatus = ''
          that.id = ''
          that.searchList()
          that.$Message.success('客户审核成功')
          that.examineStatu = false
          that.applyBtn = true
        }).catch(function (err) {
          that.examineStatu = false
          that.applyBtn = true
        })
      } else {
        that.$Message.error('请选择审核状态')
        that.applyBtn = true
      }
    },
    selectDataNew (currentRow) {
      if (currentRow.auditStatus === '0' || currentRow.auditStatus === '2') {
        this.id = currentRow.id
        this.applyBtn = false
      } else {
        this.applyBtn = true
      }
    },
    auditStatusChange (val) {
      this.auditStatus = val
    },
    dataChange (val) {
      this.lastDate = val
    },
    getSetData: function () {
      let that = this
      let query = {
        industryCode: this.industryCode,
        lastDate: this.lastDate
      }
      this.$axios.post('industry/updateSyncLastDate', query).then(function (res) {
        that.$Message.success('重置时间成功')
        that.applyBtn = true
      }).catch(function (err) {
        that.applyBtn = true
      })
    },
    setAccount (row) {
      this.$router.push({
        name: 'linkBank',
        params: {
          id: row.code,
          industryName: row.name,
          industryCode: row.code
        }
      })
    },
    sumbitAccount () {
      if (this.countData.provinceCode === '01' || this.countData.provinceCode === '02' || this.countData.provinceCode === '03' || this.countData.provinceCode === '04' || this.countData.provinceCode === '32' || this.countData.provinceCode === '33') {
        this.countData.cityCode = '0'
      }
      let that = this
      this.$refs['countData'].validate((valid) => {
        if (valid) {
          this.$axios.put('/industry', this.countData).then(function (res) {
            that.searchList()
            that.$Message.success('设置来款账户成功')
            that.modalAccount = false
          })
        } else {
          that.$Message.error('请正确填写信息')
        }
      })
    },
    // 关联商户列表
    showRelateIndustry (row) {
      localStorage.removeItem('industryCodeGuan')
      localStorage.setItem('industryCodeGuan', row.code)
      this.$router.push({
        name: 'linkIndustryList',
        params: {
          id: row.code,
          industryName: row.name,
          industryCode: row.code
        }
      })
    },
    cancel () {
      this.modalAccount = false
      this.$refs['countData'].resetFields()
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
      this.orgCode = ''
    },
    createBtn () {
      this.$router.push({
        name: 'addIndustry'
      })
    },
    industryApply () {
      this.examineStatu = true
    },
    doDelete (row) {
      this.$axios.delete('/industry' + '/' + row.id)
        .then((res) => {
          if (res.status === 200) {
            this.$Message.success('删除成功！')
            this.searchList()
            this.applyBtn = true
          } else {
            this.$Message.success('删除失败！')
            this.applyBtn = true
          }
        })
        .catch(function (error) {
          console.log(error)
          this.applyBtn = true
        })
    },
    update (row) {
      this.$router.push({
        name: 'editIndustry',
        params: {
          type: 'edit',
          id: row.id
        }
      })
    },
    subPayPayeeWhiteList (row) {
      this.$router.push({
        name: 'subPayPayeeWhiteList',
        params: {
          type: 'subPayPayeeWhiteList',
          id: row.id
        }
      })
    },
    showDetail (row) {
      this.$router.push({
        name: 'industryDetail',
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
