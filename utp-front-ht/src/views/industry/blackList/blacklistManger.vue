<style lang="less">
  @import '../../../styles/common.less';
</style>
<style lang="less">
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="类型：" prop="objType">
            <Select v-model="objType" style="width: 180px"  @on-change="objTypeChange">
              <i-option value="1">个人</i-option>
              <i-option value="2">企业</i-option>
            </Select>
          </FormItem>
          <FormItem label="姓名：" prop="name" v-if="gerenDis">
            <Input v-model="name" :maxlength="200"/>
          </FormItem>
          <FormItem label="身份证号：" prop="idCode" v-if="gerenDis">
            <Input v-model="idCode" :maxlength="18"/>
          </FormItem>
          <FormItem label="企业名称：" prop="entName" v-if="qiyeDis">
            <Input v-model="entName" :maxlength="200"/>
          </FormItem>
          <FormItem label="营业执照编号：" prop="busLicCode" v-if="qiyeDis">
            <Input v-model="busLicCode" :maxlength="18"/>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="blacklistMangerList" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <Button type="success" v-access id="blacklistAprAdd" @click="createBtn()" style="margin-right: 10px;">新增</Button>
            <!--<Button type="warning" v-access id="quotaExaApprovalApply" @click="quotaExaApprovalApplyBtn()" style="margin-right: 10px;" :disabled="applyBtn">审核</Button>-->
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" @on-current-change="selectDataNew" highlight-row stripe></Table>
        <br/>
        <div class="page" style="">
          <div class="page-content">
            <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
          </div>
        </div>
      </Col>
    </Row>
    <Modal
      v-model="examineStatu"
      title="交易限额管理"
      width="350"
    >
      <Select v-model="auditStatus" style="width: 180px"  @on-change="auditStatusChange">
        <i-option value="1">审核通过</i-option>
        <i-option value="2">审核驳回</i-option>
      </Select>
      <i-input type="textarea" v-model="remark" placeholder="请输入备注" style="margin-top: 10px"></i-input>
      <div slot="footer">
        <Button type="text" size="large" @click="cancelAuditStatus">取消</Button>
        <Button type="primary" size="large" @click="sumbitAuditStatus">确定</Button>
      </div>
    </Modal>
  </card>
</template>
<script>
export default {
  name: "blacklistManger",
  data () {
    return {
      gerenDis: true,
      qiyeDis: false,
      id: '',
      examineStatu: false,
      auditStatus: '',
      remark: '',
      merName: '',
      idCode: '',
      entName: '',
      busLicCode: '',
      name: '',
      applyBtn: true,
      formData: {},
      tableColumns1: [],
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}],
      objType: '1'
    }
  },
  methods: {
    init () {
      let self = this
      // 设置
      // this.provinceAry = this.cityList.China.province
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns1 = [
        {
          title: '序号',
          type: 'index',
          width: 70
        },
        {
          title: '类型',
          key: 'objType',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.objType === '1') {
              res = '个人'
            } else {
              res = '企业'
            }
            return h('span', res)
          }
        },
        {
          title: '姓名',
          key: 'name',
          width: 150 * avg
        },
        {
          title: '身份证号',
          key: 'idCode',
          width: 150 * avg
        },
        {
          title: '企业名称',
          key: 'entName',
          width: 150 * avg,

            // render (h, a, b) {
            //   if (a.row.objType === '1') {
            //       debugger
            //   }
            // }
        },
        {
          title: '营业执照编号',
          key: 'busLicCode',
          width: 150 * avg
        },
        {
          title: '备注信息',
          key: 'remark',
          width: 150 * avg,
        },
        {
          title: '审核状态',
          key: 'privateIndividualAmt',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.auditStatus === '0') {
              res = '待审核'
            }
            if (a.row.auditStatus === '1') {
              res = '审核通过'
            }
            if (a.row.auditStatus === '2') {
              res = '审核驳回'
            }
            return h('span', res)
          }
        },
        {
          title: '最近修改时间',
          key: 'gmtModified',
          width: 180 * avg,
          render (h, a, b) {
            return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '最近修改人',
          key: 'userModified',
          width: 180 * avg
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 235 * avg,
          render: (h, params) => {
              return h('div', [
                h('svg-icon', {
                  attrs: {
                    id: 'blacklistAprAdd',
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
                      id: 'blacklistAprAdd',
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
                  }, '删除'),
                ]),
              ])
          }
        }
      ]
      // 查询信息
      this.searchList()
    },
    objTypeChange (val) {
      this.objType = val
      if (val === '1') {
        this.gerenDis = true
        this.qiyeDis = false
        this.busLicCode = ''
        this.entName = ''
        this.name = ''
        this.idCode = ''
      } else {
        this.gerenDis = false
        this.qiyeDis = true
        this.busLicCode = ''
        this.entName = ''
        this.name = ''
        this.idCode = ''
      }
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
      let uri = encodeURI('/blacklist/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {}}
      if (this.name) {
        query.parameters.name = this.name
      } else {
        delete query.parameters.name
      }
      if (this.idCode) {
        query.parameters.idCode = this.idCode
      } else {
        delete query.parameters.idCode
      }
      if (this.entName) {
        query.parameters.entName = this.entName
      } else {
        delete query.parameters.entName
      }
      if (this.busLicCode) {
        query.parameters.busLicCode = this.busLicCode
      } else {
        delete query.parameters.busLicCode
      }
      query.parameters.objType = this.objType
      // 查询机构列表
      let that = this
      let avg = (document.body.clientWidth) / 1440
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 70
        },
        {
          title: '类型',
          key: 'objType',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.objType === '1') {
              res = '个人'
            } else {
              res = '企业'
            }
            return h('span', res)
          }
        },
        {
          title: '姓名',
          key: 'name',
          width: 150 * avg
        },
        {
          title: '身份证号',
          key: 'idCode',
          width: 150 * avg
        },
        {
          title: '企业名称',
          key: 'entName',
          width: 150 * avg
        },
        {
          title: '营业执照编号',
          key: 'busLicCode',
          width: 150 * avg
        },
        {
          title: '备注信息',
          key: 'remark',
          width: 150 * avg,
        },
        {
          title: '审核状态',
          key: 'privateIndividualAmt',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.auditStatus === '0') {
              res = '待审核'
            }
            if (a.row.auditStatus === '1') {
              res = '审核通过'
            }
            if (a.row.auditStatus === '2') {
              res = '审核驳回'
            }
            return h('span', res)
          }
        },
        {
          title: '最近修改时间',
          key: 'gmtModified',
          width: 180 * avg,
          render (h, a, b) {
            return h('div', that.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
          }
        },
        {
          title: '最近修改人',
          key: 'userModified',
          width: 180 * avg
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 235 * avg,
          render: (h, params) => {
            return h('div', [
              h('svg-icon', {
                attrs: {
                  id: 'blacklistAprAdd',
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
                    id: 'blacklistAprAdd',
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
      this.$axios.post(uri, query)
        .then((response) => {
          if (that.objType === '1') {
            for (let i = 0; i < that.tableColumns.length; i++) {
              if (that.tableColumns[i].key === 'entName') {
                that.tableColumns.splice(i, 2)
              }
            }
          }
          if (that.objType === '2') {
            that.tableColumns.forEach(function (e, i) {
              if (e.key === 'name') {
                that.tableColumns.splice(i, 2)
              }
            })
          }
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
      this.objType = '1'
      this.busLicCode = ''
      this.entName = ''
      this.name = ''
      this.idCode = ''
      this.gerenDis = true
      this.qiyeDis = false
    },
    createBtn () {
      this.$router.push({
        name: 'addblacklist'
      })
    },
    quotaExaApprovalApplyBtn () {
      this.examineStatu = true
    },
    // auditStatusChange (val) {
    //   this.auditStatus = val
    // },
    cancelAuditStatus () {
      this.examineStatu = false
    },
    sumbitAuditStatus () {
      let that = this
      if (this.auditStatus && this.id) {
        let formData = {
          auditStatus: this.auditStatus,
          id: this.id,
          remark: this.remark
        }
        this.$axios.put('/quotaExaApprovalAudit', formData).then(function (res) {
          that.auditStatus = ''
          that.id = ''
          that.searchList()
          that.$Message.success('交易限额审核成功')
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
      if (currentRow.auditStatus === '0') {
        this.id = currentRow.id
        this.applyBtn = false
      } else {
        this.applyBtn = true
      }
    },
    shuaXinEDu (row) {
      let that = this
      this.$axios.post('/industryAmtLimitApprovalReq', row).then(function (res) {
        that.$Message.success('刷新额度成功')
      })
    },
    doDelete (row) {

      // let query = {
      //   approvalId: row.id,
      //   operationType: '0'
      // }
      // row.approvalId = row.id
      row.operationType = '0'
      this.$axios.post('/blacklistApr', row)
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
        name: 'editblacklist',
        params: {
          type: 'edit',
          id: row.id,
          name: row.name,
          remark: row.remark,
          busLicCode: row.busLicCode,
          idCode: row.idCode,
          objType: row.objType,
          entName: row.entName
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
