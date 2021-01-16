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
          <FormItem label="操作类型：" prop="operationType">
            <Select v-model="operationType" style="width: 180px"  @on-change="operationTypeChange">
              <i-option value="2">新增</i-option>
              <i-option value="1">修改</i-option>
              <i-option value="0">删除</i-option>
            </Select>
          </FormItem>
          <FormItem label="审核状态：" prop="auditStatus">
            <Select v-model="auditStatus" style="width: 180px"  @on-change="auditStatusChangeTwo">
              <i-option value="0">待审核</i-option>
              <i-option value="1">审核通过</i-option>
              <i-option value="2">审核驳回</i-option>
            </Select>
          </FormItem>
          <FormItem  label="申请开始时间：" prop="gmtCreate" >
            <Date-picker :options="beginDateOption" type="date" v-model="transBeginDate" :editable="false" placeholder="请选择开始日期" format="yyyy-MM-dd" @on-change="beginTradeDateChange" style="width: 200px"></Date-picker>
            <Time-picker confirm placeholder="选择时间" :editable="false" v-model="beginTransTime"  style="width: 168px"></Time-picker>
          </FormItem>
          <FormItem  label="申请结束时间：" prop="transEndDate" >
            <Date-picker :options="endDateOption" type="date" v-model="transEndDate" :editable="false" placeholder="请选择结束日期" format="yyyy-MM-dd" @on-change="endTradeDateChange" style="width: 200px"></Date-picker>
            <Time-picker confirm placeholder="选择时间" :editable="false" v-model="endTransTime" style="width: 168px"></Time-picker>
          </FormItem>
          <FormItem :label-width="0">
            <Button type="primary" v-access id="fenZhangblacklistApr" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;">重置</Button>
            <!--<Button type="success" v-access id="quotaExaApprovalAdd" @click="createBtn()" style="margin-right: 10px;">新增</Button>-->
            <Button type="warning" v-access id="blacklistAprOperListShenHe" @click="quotaExaApprovalApplyBtn()" style="margin-right: 10px;" :disabled="applyBtn">审核</Button>
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
      title="分账黑名单审核"
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
  name: "blacklistAprOperManger",
  data () {
    return {
      gerenDis: true,
      qiyeDis: false,
      objType: '1',
      entName: '',
      busLicCode: '',
      name: '',
      idCode: '',
      operationType: '',
      transBeginDatePass: '',
      transBeginDate: '',
      beginTransTime: '',
      transEndDatePass: '',
      transEndDate: '',
      endTransTime: '',
      id: '',
      examineStatu: false,
      auditStatus: '',
      remark: '',
      merName: '',
      industryCode: '',
      industryName: '',
      applyBtn: true,
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      data1: [{}],
      beginDateOption: {
        disabledDate (date) {
          return date && date.valueOf() > Date.now()
        }
      },
      endDateOption: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000
        }
      }
    }
  },
  methods: {
    init () {
      let that = this
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
              title: '操作类型',
              key: 'operationType',
              width: 150 * avg,
              render (h, a, b) {
                  let res = ''
                  if (a.row.operationType === '0') {
                      res = '删除'
                  }
                  if (a.row.operationType === '1') {
                      res = '修改'
                  }
                  if (a.row.operationType === '2') {
                      res = '新增'
                  }
                  return h('span', res)
              }
          },
          {
              title: '申请人',
              key: 'userCreate',
              width: 150 * avg
          },
          {
              title: '申请时间',
              key: 'gmtCreate',
              width: 150 * avg,
              render (h, a, b) {
                  return h('div', that.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
              }
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
              title: '审核时间',
              key: 'gmtModified',
              width: 180 * avg,
              render (h, a, b) {
                  if (this.row.gmtModified !== '' && this.row.gmtModified !== null) {
                      return h('div', that.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
                  }
              }
          },
          {
              title: '审核人员',
              key: 'userModified',
              width: 180 * avg
          }
      ]
      // 查询信息
      this.searchList()
    },
    searchList (param) {
      this.applyBtn = true
      let page = {
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      let uri = encodeURI('/blacklistApr/list')
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
      if (this.busLicCode) {
        query.parameters.busLicCode = this.busLicCode
      } else {
        delete query.parameters.busLicCode
      }
      if (this.operationType) {
        query.parameters.operationType = this.operationType
      } else {
        delete query.parameters.operationType
      }
      if (this.auditStatus) {
        query.parameters.auditStatus = this.auditStatus
      } else {
        delete query.parameters.auditStatus
      }
      if (this.transBeginDate) {
        if (this.beginTransTime) {
          query.parameters.transBeginDate =  this.$moment(this.transBeginDate).format('YYYY-MM-DD') + ' ' + this.beginTransTime
        } else {
          query.parameters.transBeginDate = this.$moment(this.transBeginDate).format('YYYY-MM-DD') + ' ' + '00:00:00'
        }
      } else {
        delete query.parameters.transBeginDate
      }
      if (this.transEndDate) {
        if (this.endTransTime) {
          query.parameters.transEndDate = this.$moment(this.transEndDate).format('YYYY-MM-DD') + ' ' + this.endTransTime
        } else {
          query.parameters.transEndDate = this.$moment(this.transEndDate).format('YYYY-MM-DD') + ' ' + '23:59:59'
        }
      } else {
        delete query.parameters.transEndDate
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
          title: '操作类型',
          key: 'operationType',
          width: 150 * avg,
          render (h, a, b) {
            let res = ''
            if (a.row.operationType === '0') {
              res = '删除'
            }
            if (a.row.operationType === '1') {
              res = '修改'
            }
            if (a.row.operationType === '2') {
              res = '新增'
            }
            return h('span', res)
          }
        },
        {
          title: '申请人',
          key: 'userCreate',
          width: 150 * avg
        },
        {
          title: '申请时间',
          key: 'gmtCreate',
          width: 150 * avg,
          render (h, a, b) {
            return h('div', that.$moment(this.row.gmtCreate).format('YYYY-MM-DD HH:mm:ss'))
          }
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
          title: '审核时间',
          key: 'gmtModified',
          width: 180 * avg,
          render (h, a, b) {
            if (this.row.gmtModified !== '' && this.row.gmtModified !== null) {
              return h('div', that.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
            }
          }
        },
        {
          title: '审核人员',
          key: 'userModified',
          width: 180 * avg
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
          this.tableData = response.data.list
          this.total = parseInt(response.data.total)
          this.applyBtn = true
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
      this.entName = ''
      this.busLicCode = ''
      this.idCode = ''
      this.name = ''
      this.operationType = ''
      this.auditStatus = ''
      this.transBeginDate = ''
      this.beginTransTime = ''
      this.transEndDate = ''
      this.endTransTime = ''
      this.transBeginDatePass = ''
      this.transEndDatePass = ''
      this.objType = '1'
      this.gerenDis = true
      this.qiyeDis = false
      this.applyBtn = true
    },
    createBtn () {
      this.$router.push({
        name: 'addQuotaExaApproval'
      })
    },
    beginTradeDateChange (value) {
      this.transBeginDatePass = value
      let dateGet = new Date(value)
      this.endDateOption = {
        disabledDate (date) {
          return date && date.valueOf() < dateGet.valueOf() - 86400000
        }
      }
    },
    endTradeDateChange (value) {
      this.transEndDatePass = value
      let dateGet = new Date(value)
      this.beginDateOption = {
        disabledDate (date) {
          return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
        }
      }
    },
    quotaExaApprovalApplyBtn () {
      this.examineStatu = true
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
    operationTypeChange (val) {
      this.operationType = val
    },
    auditStatusChangeTwo (val) {
      this.auditStatus = val
    },
    cancelAuditStatus () {
      this.examineStatu = false
    },
    auditStatusChange (val){
      this.auditStatus = val
    },
    sumbitAuditStatus () {
      let that = this
      if (this.auditStatus && this.id) {
        let formData = {
          auditStatus: this.auditStatus,
          id: this.id,
          remark: this.remark
        }
        this.$axios.put('/blacklistAprOper', formData).then(function (res) {
          that.auditStatus = ''
          that.id = ''
          that.remark = ''
          that.searchList()
          that.$Message.success('分账黑名单审核成功')
          that.examineStatu = false
          that.applyBtn = true
          that.auditStatus = ''
        }).catch(function (err) {
          that.examineStatu = false
          that.applyBtn = true
          that.auditStatus = ''
          that.id = ''
          that.remark = ''
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
    doDelete (row) {
      this.$axios.delete('/quotaExaApproval' + '/' + row.id)
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
        name: 'editQuotaExaApproval',
        params: {
          type: 'edit',
          id: row.id
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
