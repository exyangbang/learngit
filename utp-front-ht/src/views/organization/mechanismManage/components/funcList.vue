<template>
    <div>
        <Row>
            <Col>
                <Form :label-width="100" ref="form" :model="formData" label-position="right" :inline="true">
                    <FormItem label="角色编号：">
                        <Input v-model="formData.roleCode" :maxlength="100"/>
                    </FormItem>
                    <FormItem label="角色名称：">
                        <Input v-model="formData.roleName" :maxlength="100"/>
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
                   @on-current-change="currentChange"
                   @on-select="select"
                   @on-select-cancel="selectCancel"
                   @on-select-all="selectAll"
            ></Table>
            <div class="page" style="">
                <div class="page-content">
                    <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
                </div>
            </div>
            </Col>
        </Row>
        <Row>
            <Col>
                <div class="ivu-modal-footer">
                    <Button type="primary" @click="sureSubmit" style="margin-right: 10px;">确定</Button>
                    <Button type="default" @click="sureSubmit">取消</Button>
                </div>
            </Col>
        </Row>
    </div>
</template>
<script>

export default {
  name: 'funcList',
  props: {
    selectedData: Array
  },
  data () {
    return {
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      //                selectedData: [],
      tempData: [],
      firstSelected: true
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
        offset: this.currentPage,
        limit: 10
      }
      param = param || {}
      param.offset = page.offset
      param.limit = page.limit
      param = Object.assign(param, this.formData)
      this.$axios.get(this.$contants.restful.roles + '?' + 'offset=' + param.offset + '&limit=' + param.limit)
        .then(function (response) {
          self.tableData = response.data.list
          self.total = parseInt(response.data.total)
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
      this.$emit('checkFunc', this.selectedData)
    },
    backCancel () {

    },
    // 选择时，合并或者去掉
    handleChange (currentRow) {
      // let isInArray = false
      // let index = -1
      // for (let i = 0; i < this.selectedData.length; i++) {
      //   if (this.selectedData[i] == currentRow) {
      //     isInArray = true
      //     index = i
      //   }
      // }
      //
      //
      // if (!isInArray) {
      //   this.selectedData.push(currentRow[this.selectedData.length])
      // }

      console.log(this.selectedData)
      // 获取选中的id列表，然后设置数组的_checked为true
      // let _tmpArr = []// 选中的数组id
      // let _unSelectArr = [] // 未选中的数组id
      // currentRow.forEach(item => {
      //   _tmpArr.push(item.roleId)
      // })
      // // 设置当前的tableData数据
      // this.tableData.forEach(item => {
      //   if (_tmpArr.in_array(item.roleId)) {
      //     item._checked = true
      //     // 选中的先去重，在添加到selectedData
      //     // flag，判断是否在数组里
      //     let flag = util.isContain(item.roleId, this.selectedData, 'roleId')
      //     // 如果不在，则添加到selectedData
      //     if (!flag) {
      //       this.selectedData.push(item)
      //     }
      //   } else {
      //     item._checked = false
      //     _unSelectArr.push(item.roleId)
      //   }
      // })
      //
      // // 从selectedData中去掉未选中的
      // let deleteArr = []
      // this.selectedData.forEach((item, index) => {
      //   if (_unSelectArr.in_array(item.roleId)) {
      //     // 删除掉之前添加的
      //     deleteArr.push(index)
      //   }
      // })
      // // 逆向删除
      // for (let i = this.selectedData.length - 1; i >= 0; i--) {
      //   if (_unSelectArr.in_array(this.selectedData[i].roleId)) {
      //     // 删除掉之前添加的
      //     this.selectedData.splice(i, 1)
      //   }
      // }
      // this.selectedData
    },
    currentChange (currentRow, oldCurrentRow) {
      console.log('currentChange')
    },
    select (selection, row) {
      console.log('select')
      this.selectedData = selection
    },
    selectCancel (selection, row) {
      console.log('selectCancel')
      this.selectedData = selection
    },
    selectAll (selection) {
      console.log('selectAll')
      this.selectedData = this.tableData
    }

  },
  created () {
    this.init()
  },
  computed: {}
}
</script>
