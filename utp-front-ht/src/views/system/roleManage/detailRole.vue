<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
    <card>
      <Form  :model="formData" :label-width="150" label-position="right">
        <Row>
          <Col span="13" offset="4">
            <FormItem label="角色名称：" prop="rolename">
              <span>{{formData.rolename}}</span>
            </FormItem>
            <FormItem label="角色权限：" prop="permissionList">
                <!--<Tree :data="menuList" show-checkbox/>-->
              <Table :columns="tableColumns" :data="tableData" border stripe></Table>
            </FormItem>
            <FormItem>
              <Button type="ghost" @click="goBack()" class="margin-top-20 margin-left-10">返回</Button>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </card>
</template>
<script>

export default {
  name: 'detailRole',
  data () {
    return {
      id: this.$route.params.id,
      formData: {},
      menuList: [],
      tableData: [],
      tableColumns: []
    }
  },
  methods: {
    goBack () {
      this.$util.goBack(this)
    },
    setDis (permissionList) {
      permissionList.forEach((item) => {
        item.disabled = true
        item.expand = true
        if (item.children) {
          this.setDis(item.children)
        } else if (item.checked) {
          this.tableData.push(item)
        }
      })
    },
    getData () {
      let self = this
      this.$axios.get(this.$contants.restful.role + '/' + this.id)
        .then(function (response) {
          if (response.data) {
            self.formData = response.data
            self.setDis(response.data.permissionList)
            self.menuList = response.data.permissionList
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    init () {
      this.tableColumns = [
        {
          title: '权限名称',
          key: 'title',
          width: 160
        },
        {
          title: '权限路径',
          key: 'path'
        }
      ]
      if (this.id) {
        this.getData()
      }
    }
  },

  computed: {},
  mounted () {
    this.init()
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'detailRole', this.$route.params.id)
    if (this.id !== initParamVal) {
      this.id = initParamVal
      this.init()
    }
  }
}
</script>
