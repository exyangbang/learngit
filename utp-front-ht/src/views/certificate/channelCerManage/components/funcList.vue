<template>
    <div>
        <Row>
            <Col>
                <Form :label-width="100" ref="form" :model="formData" label-position="right" :inline="true">
                    <FormItem label="商户号：">
                        <Input v-model="formData.merNo" :maxlength="20"/>
                    </FormItem>
                    <FormItem label="商户名称：">
                        <Input v-model="formData.merName" :maxlength="100"/>
                    </FormItem>
                    <FormItem :label-width="0">
                        <Button type="primary" @click="searchBtn()" style="margin-right: 10px;">查询</Button>
                        <Button type="default" @click="clearBtn()">清空</Button>
                    </FormItem>
                </Form>
            </Col>
        </Row>
        <Row>
            <Col>
            <Table ref="selection" :columns="tableColumns" :data="tableData"
                   @on-selection-change="handleChange" highlight-row
                   @on-select="select"
                   @on-select-cancel="selectCancel"
                   @on-select-all="selectAll"
            ></Table>
              <br>
              <Page :total="total" :current="currentPage" show-total @on-change="changePage" class="page"></Page>
            </Col>
        </Row>
        <Row>
            <Col>
                <div class="ivu-modal-footer">
                    <Button type="primary" @click="sureSubmit" style="margin-right: 10px;" :disabled="sureBtnDisabled" id="sureBtnId">确定</Button>
                    <Button type="default" @click="backCancel">取消</Button>
                </div>
            </Col>
        </Row>
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
          type: 'selection',
          width: 60
        },
        {
          title: '序号',
          type: 'index',
          width: 160
        },
        {
          title: '商户名称',
          key: 'merName'
        },
        {
          title: '商户号',
          key: 'merNo'
        }
      ]

      // 查询信息
      this.searchList()
      console.log('create----')
    },
    searchList (param) {
      let self = this
      let page = {
        pageNo: this.currentPage,
        pageSize: 10
      }
      param = param || {}
      param.pageNo = page.pageNo
      param.pageSize = page.pageSize
      let parameters = {
        orgCode: null
      }
      parameters.orgCode = this.selectedItem.orgCode
      parameters.certificateType = this.selectedItem.certificateType
      parameters.certificateId = this.selectedItem.id
      parameters = Object.assign(parameters, this.formData)
      param.parameters = parameters
      // 获取 商户列表(证书关联的商户)
      this.$axios.post(this.$contants.restful.merchantInfoCers, param)
        .then((response) => {
          self.tableData = []
          self.total = parseInt(response.data.total)
          let myTableData = response.data.list
          // self.selectedMerchant = []
          let currentPageSelected = []
          let currentPageSelectedMerchIds = []
          let handeledCurrentPageSelectedMearchIds = self.selectedMerchId[self.currentPage - 1]
          for (let i = 0; i < myTableData.length; i++) {
            let merchItem = myTableData[i]
            if (typeof (handeledCurrentPageSelectedMearchIds) === 'undefined') {
              if (parseInt(merchItem.certId) === self.selectedItem.id) {
                merchItem._checked = true
                currentPageSelected.push(merchItem)
                currentPageSelectedMerchIds.push(parseInt(merchItem.id))
              }
            } else {
              if (self.inArray(handeledCurrentPageSelectedMearchIds, parseInt(merchItem.id))) {
                merchItem._checked = true
                currentPageSelected.push(merchItem)
                currentPageSelectedMerchIds.push(parseInt(merchItem.id))
              }
            }
            self.tableData.push(merchItem)
          }
          self.selectedMerchId[self.currentPage - 1] = currentPageSelectedMerchIds
          self.selectedMerchant[self.currentPage - 1] = currentPageSelected
        })
        .catch((error) => {
          console.log(error)
        })
    },
    changePage (index) {
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
    handleChange (selection) {
      let self = this
      let currentPageSelectedMerchIds = []
      selection.forEach(function (value, index) {
        currentPageSelectedMerchIds.push(parseInt(value.id))
      })
      this.selectedMerchId[self.currentPage - 1] = currentPageSelectedMerchIds

      this.selectedMerchant[this.currentPage - 1] = selection
      let sureBtn = document.getElementById('sureBtnId')
      let count = 0
      self.selectedMerchant.forEach(function (currentPageValues, currentPageIndex) {
        currentPageValues.forEach(function (itemValues, index) {
          count++
        })
      })
      if (count === 0) {
        sureBtn.disabled = true
      } else {
        sureBtn.disabled = false
      }
    },
    select (selection, row) {
    },
    selectCancel (selection, row) {
    },
    selectAll (selection) {
    },
    unique: function (arr) { // 去掉数组中重复数据
      let result = []
      let hash = {}
      for (var i = 0, elem; (elem = arr[i]) != null; i++) {
        if (!hash[elem]) {
          result.push(elem)
          hash[elem] = true
        }
      }
      return result
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
    updateMyData: function (newValue, oldValue) {
      this.tableData = []
      this.searchList()
      let sureBtn = document.getElementById('sureBtnId')
      sureBtn.disabled = true
    }
  },
  computed: {
    updateMyData () {
      return this.selectedItem.id
    }
  }
}
</script>
