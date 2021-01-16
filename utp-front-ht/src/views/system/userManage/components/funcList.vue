<template>
    <div>
        <Row>
            <Col>
                <Form :label-width="100" ref="form" :model="formData" label-position="right" :inline="true">
                    <FormItem label="角色名称：">
                        <Input v-model="formData.rolename" :maxlength="100"/>
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
            ></Table>
              <br>
              <Page :total="total" :current="currentPage" show-total @on-change="changePage" class="page"></Page>
            </Col>
        </Row>
        <Row>
            <Col>
                <div class="ivu-modal-footer">
                    <Button id="sureBtn" type="primary" @click="sureSubmit" style="margin-right: 10px;" :disabled=sureBtnDisabled>确定</Button>
                    <Button type="default" @click="backCancel">取消</Button>
                </div>
            </Col>
        </Row>
    </div>
</template>
<script>

export default {
  name: 'funcList',
  props: {
    selectedData: Array,
    sureBtnDisabled: Boolean,
    mydate: String
  },
  data () {
    return {
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      mySelectedData: this.selectedData,
      tempData: [],
      firstSelected: true,
      currentSelectedDataObj: [],
      selectedRoleIds: []
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
          width: 60
        },
        {
          title: '角色名称',
          key: 'rolename'
        }
      ]
      // 查询信息
      this.searchList()
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
      // param = Object.assign(param, this.formData)
      let url = this.$contants.restful.roles + '?' + 'pageNo=' + param.pageNo + '&pageSize=' + param.pageSize
      if (this.formData.rolename) {
        url = url + '&rolename=' + this.formData.rolename
      }

      url = encodeURI(url)
      this.$axios.get(url)
        .then(function (response) {
          let responseData = response.data.list
          self.total = parseInt(response.data.total)

          let myTableData = []
          let pageArr = []
          let currentPageRoleIds = []
          let currentSelectedRoleIds = self.selectedRoleIds[self.currentPage - 1]
          for (let i = 0; i < responseData.length; i++) {
            let responseItem = responseData[i]
            if (typeof (currentSelectedRoleIds) === 'undefined') {
              for (let j = 0; j < self.selectedData.length; j++) {
                let selectedItem = self.selectedData[j]

                if (selectedItem.id === responseItem.id) {
                  responseItem._checked = true
                  pageArr.push(responseItem)
                  currentPageRoleIds.push(responseItem.id)
                }
              }
            } else {
              if (self.inArray(currentSelectedRoleIds, responseItem.id)) {
                responseItem._checked = true
                pageArr.push(responseItem)
                currentPageRoleIds.push(responseItem.id)
              }
            }
            myTableData.push(responseItem)
          }
          self.currentSelectedDataObj[self.currentPage - 1] = pageArr
          self.selectedRoleIds[self.currentPage - 1] = currentPageRoleIds
          self.tableData = myTableData
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
      this.formData = {}
    },
    sureSubmit () {
      for (let i = 0; i < this.currentSelectedDataObj.length; i++) {
        let itemArr = []
        if (this.currentSelectedDataObj[i]) {
          itemArr = this.currentSelectedDataObj[i]
          for (let j = 0; j < itemArr.length; j++) {
            this.mySelectedData.push(itemArr[j])
          }
        }
      }
      this.$emit('checkFunc', this.mySelectedData)
    },
    backCancel () {
      this.$emit('hideFunc')
    },
    // 选择时，合并或者去掉
    handleChange (selection) {
      let sureBtn = document.getElementById('sureBtn')
      sureBtn.disabled = false

      let currentSelectedRoleIds = []
      selection.forEach(function (value, index) {
        currentSelectedRoleIds.push(value.id)
      })
      this.selectedRoleIds[this.currentPage - 1] = currentSelectedRoleIds
      this.mySelectedData = []
      this.currentSelectedDataObj[this.currentPage - 1] = selection
    },
    currentChange (currentRow, oldCurrentRow) {
      console.log('currentChange')
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
    // select (selection, row) {
    // },
    // selectCancel (selection, row) {
    //   let unSelectedArr = []
    //
    //
    // },
    // selectAll (selection) {
    // }
  },
  created () {
    this.init()
  },
  watch: {
    updateSureBtn: function (newValue, oldValue) {
      let sureBtn = document.getElementById('sureBtn')
      sureBtn.disabled = this.sureBtnDisabled
    }
  },
  computed: {
    updateSureBtn () {
      return this.mydate
    }
  }
}
</script>
