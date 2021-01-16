<template>
    <div>
        <Row>
            <Col>
            <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
                <FormItem label="采购对象：" prop="pTarget">
                    <Input v-model="formData.pTarget"/>
                </FormItem>
                <FormItem label="采购方式：" prop="pWay">
                    <Input v-model="formData.pWay"/>
                </FormItem>
                <FormItem label="采购范围：" prop="pScope">
                    <Input v-model="formData.pScope"/>
                </FormItem>

                <FormItem>
                    <Button type="primary" class="search margin-r-10" @click="searchBtn()">查询</Button>
                    <Button html-type="reset" class="reset" @click="resetBtn()">重置</Button>
                </FormItem>
            </Form>
            <Button type="success" class="addButton" @click="createBth()" style="margin-bottom: 5px;">添加</Button>
            </Col>
        </Row>
        <Row>
            <Col>
            <Table :columns="tableColumns" :data="tableData" stripe></Table>
            <div class="page" style="">
                <div class="page-content">
                    <Page :total="total" :current="currentPage" show-total @on-change="changePage"></Page>
                </div>
            </div>
            </Col>
        </Row>
    </div>
</template>
<script>
export default {
  data () {
    return {
      comNo: this.$store.state.comNo,
      formData: {},
      tableColumns: [],
      tableData: [],
      total: 0,
      currentPage: 1,
      pageSize: 10
    }
  },
  methods: {
    init () {
      this.comNo = this.$route.params.comNo
      this.tableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 60
        },
        {
          title: '采购范围',
          key: 'pscope',
          width: 250
        },
        {
          title: '采购对象',
          key: 'ptarget',
          width: 250
        },
        {
          title: '采购方式',
          key: 'pway',
          width: 150
        },
        {
          title: '结算方式',
          key: 'balanceWay',
          width: 150
        },
        {
          title: '结算周期',
          key: 'balanceCycle',
          width: 150
        },
        {
          title: '其他需要说明的事项',
          key: 'potherExplain',
          width: 250
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 180,
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.showDetail(params.row)
                  }
                }
              }, '编辑'),
              h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.showDetails(params.row)
                  }
                }
              }, '详情')
            ])
          }
        }
      ]
      this.searchList()
    },
    searchList (param) {
      param = param || {}
      param.pageNo = this.currentPage + ''
      param.pageSize = this.pageSize + ''
      // param.comNo = this.comNo;

      param = Object.assign(param, this.formData)
      // 查询用户信息
      this.$util.post(this.$contants.TRANCODE.getPurchaseList, param, (data) => {
        this.tableData = data.voList
        this.total = parseInt(data.totalRecord)
      })
    },
    changePage (index) {
      // 分页点击事件
      this.currentPage = parseInt(index)
      this.searchList()
    },
    searchBtn () {
      this.searchList()
    },
    resetBtn () {
      this.formData = {}
      this.currentPage = 1
    },
    showDetail (row) {
      this.$router.push({
        name: 'editCgqk',
        params: {
          id: row.pno,
          detail: JSON.stringify(row)
        }
      })
    },
    showDetails (row) {
      this.$router.push({
        name: 'cgqkDetail',
        params: {
          id: row.pno,
          detail: JSON.stringify(row)
        }
      })
    },
    createBth () {
      this.$router.push({
        name: 'addCgqk'
      })
    }
  },
  mounted () {

  },
  beforeDestroy () {

  },
  created () {
    this.init()
  }
}
</script>
