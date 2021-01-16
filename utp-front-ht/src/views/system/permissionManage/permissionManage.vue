<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
    <card>
      <Row>
        <Col>
          <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
            <FormItem label="权限名称：" prop="name">
              <Input v-model="formData.name"/>
            </FormItem>
            <FormItem>
              <Button type="primary" @click="searchBtn()">查询</Button>
              <Button html-type="reset" class="margin-left-10 " @click="resetBtn()">重置</Button>
              <Button type="success" class="margin-left-10 " @click="showCreate()">添加</Button>
            </FormItem>
          </Form>
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
    </card>
</template>
<script>
export default {
  name: "permissionManage",
  data () {
    return {
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
          type: 'index'
        },
        {
          title: '权限名称',
          key: 'name'
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '8px'
                },
                on: {
                  click: () => {
                    this.showEdit(params.row)
                  }
                }
              }, '编辑'),
              h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {},
                on: {
                  click: () => {
                    this.showDetail(params.row)
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
    showEdit (row) {
    },
    showDetail (row) {
    },
    showCreate () {
      this.$router.push({
        name: 'addPM'
      })
    }
  },
  mounted () {

  },
  beforeDestroy () {

  },
  created () {
    this.init()
  },
  activated() {
      this.searchList();
  }
}
</script>
