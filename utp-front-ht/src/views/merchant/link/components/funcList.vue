<template>
  <div>
    <!--<Row>-->
      <!--<Col>-->
        <!--<Form :label-width="100" ref="form" :model="formData" label-position="right" :inline="true">-->
          <!--<FormItem label="商户号：">-->
            <!--<Input v-model="formData.merNo" :maxlength="100"/>-->
          <!--</FormItem>-->
          <!--<FormItem label="商户名称：">-->
            <!--<Input v-model="formData.merName" :maxlength="100"/>-->
          <!--</FormItem>-->
          <!--<FormItem :label-width="0">-->
            <!--<Button type="primary" @click="searchBtn()" style="margin-right: 10px;">查询</Button>-->
            <!--<Button type="default" @click="clearBtn()">清空</Button>-->
          <!--</FormItem>-->
        <!--</Form>-->
      <!--</Col>-->
    <!--</Row>-->
    <Row>
      <Col>
        <Table ref="selection" :columns="tableColumns" :data="tableData"
               @on-current-change="handleChange" highlight-row></Table>
        <br>
        <Page :total="total" :current="currentPage" show-total @on-change="changePage" class="page"></Page>
      </Col>
    </Row>
    <!--<Row>-->
      <!--<Col>-->
        <!--<div class="ivu-modal-footer">-->
          <!--<Button type="primary" @click="sureSubmit" style="margin-right: 10px;" :disabled="sureBtnDisabled" id="sureBtnId">确定</Button>-->
          <!--<Button type="default" @click="backCancel">取消</Button>-->
        <!--</div>-->
      <!--</Col>-->
    <!--</Row>-->
  </div>
</template>
<script>
export default {
  name: 'funcList',
  props: [
    'selectedItem', 'sureBtnDisabled'
  ],
  data () {
    return {
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      tempData: [],
      firstSelected: true,
      mySelectedData: this.selectedItem,
      selectedMerchant: [],
      selectedMerchId: []
    }
  },
  methods: {
    init () {
      // 设置
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 70
        },
        {
          title: '手续费模板名称',
          key: 'name',
        },
        {
          title: '手续费结算类型',
          key: 'settleType',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.settleType === '1') {
              getReslt = '实时'
            }
            if (a.row.settleType === '2') {
              getReslt = '后结'
            }
            // if (a.row.settleType === '3') {
            //   getReslt = '月结'
            // }
            return h('span', getReslt)
          }
        },
        {
          title: '手续费收费方式',
          key: 'chargeMode',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.chargeMode === '1') {
              getReslt = '内扣'
            }
            if (a.row.chargeMode === '2') {
              getReslt = '外扣'
            }
            return h('span', getReslt)
          }
        },
        {
          title: '手续费计算方式',
          key: 'calculateMode',
          render (h, a, b) {
            let getReslt = ''
            if (a.row.calculateMode === '1') {
              getReslt = '按笔定额'
            }
            if (a.row.calculateMode === '2') {
              getReslt = '按固定费率'
            }
            if (a.row.calculateMode === '3') {
              getReslt = '按笔定额-区间'
            }
            return h('span', getReslt)
          }
        },
        {
          title: '手续费',
          key: 'fee',
          render (h, a, b) {
            if (a.row.calculateMode === '1') {
              return h('span', a.row.fee / 100 + '元')
            } else {
              return h('span', a.row.fee / 100 + '%')
            }
          }
        },
        {
          title: '最小手续费',
          key: 'minFee',
          render (h, a, b) {
            if (a.row.calculateMode === '3') {
              return h('span', '')
            } else {
              if (a.row.minFee === null || a.row.minFee === 0) {
                return h('span', '')
              } else {
                return h('span', a.row.minFee / 100 + '元')
              }
            }
          }
        },
        {
          title: '最大手续费',
          key: 'maxFee',
          render (h, a, b) {
            if (a.row.calculateMode === '3') {
              return h('span', '')
            } else {
              if (a.row.maxFee === null || a.row.maxFee === 0) {
                return h('span', '')
              } else {
                return h('span', a.row.maxFee / 100 + '元')
              }
            }
          }
        },
        {
          title: '备注信息',
          key: 'remark'
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
      let uri = encodeURI('/feeTemplate/list')
      let query = {pageNo: param.offset, pageSize: param.limit, parameters: {name: this.name}}
      if (this.name) {
        query = {pageNo: param.offset, pageSize: param.limit, parameters: {name: this.name}}
      } else {
        query = {pageNo: param.offset, pageSize: param.limit}
      }
      // 查询手续费模板列表
      this.$axios.post(uri, query)
        .then((response) => {
          let that = this
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
      this.tableData = []
      this.selectedMerchant = []
      this.searchList()
    },
    clearBtn () {
      this.formData = {}
    },
    sureSubmit: function () {
      let self = this
      let merchants = []
      self.selectedMerchant.forEach(function (currentPageValues, currentPageIndex) {
        currentPageValues.forEach(function (itemValues, index) {
          merchants.push(itemValues.merNo)
        })
      })
      let url = self.$contants.restful.certificateMerchantInfo + '/' + self.selectedItem.id
      self.$axios.post(url, merchants)
        .then(() => {
          self.$Message.success('关联成功')
        })
        .catch((error) => {
          console.log(error)
        })
      self.backCancel()
    },
    backCancel () {
      this.$emit('hideFunc')
    },
    // 选择时，合并或者去掉
    handleChange (currentRow, oldCurrentRow) {
      let pagJson = {
        merFeeTemplateId: currentRow.id,
        name: currentRow.name,
        disPlay: false
      }
      this.$emit('pagByJson', pagJson)
      this.funcModalShow = false
      // self.backCancel()
      // let self = this
      // let currentPageSelectedMerchIds = []
      // selection.forEach(function (value, index) {
      //   currentPageSelectedMerchIds.push(parseInt(value.id))
      // })
      // this.selectedMerchId[self.currentPage - 1] = currentPageSelectedMerchIds
      // this.selectedMerchant[this.currentPage - 1] = selection
      // let sureBtn = document.getElementById('sureBtnId')
      // sureBtn.disabled = false
    },
    select (selection, row) {
    },
    selectCancel (selection, row) {
    },
    selectAll (selection) {
    },
    inArray (arr, value) {
      if (!arr) {
        return false
      }
      for (let i = 0; i < arr.length; i++) {
        if (arr[i] === value) {
          return true
        }
      }
      return false
    }
  },
  created () {
    this.init()
  },
  watch: {
    // updateMyData: function (newValue, oldValue) {
    //   this.tableData = []
    //   this.searchList()
    //   let sureBtn = document.getElementById('sureBtnId')
    //   sureBtn.disabled = true
    // }
  },
  computed: {
    // updateMyData () {
    //   return this.selectedItem.id
    // }
  }
}
</script>
