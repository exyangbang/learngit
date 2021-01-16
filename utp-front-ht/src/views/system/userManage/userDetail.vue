<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form :label-width="150">
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">用户详情</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="6" offset="">
          <FormItem label="姓名：" prop="name">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.name }} </span>
          </FormItem>
          <FormItem label="登录账号：" prop="username">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.username }} </span>
          </FormItem>
        </Col>
        <Col span="6">
          <FormItem label="邮箱：" prop="email">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.email }} </span>
          </FormItem>
          <FormItem label="联系电话：" prop="mobileNo">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.mobileNo }} </span>
          </FormItem>
        </Col>
      </Row>
      <hr>
      <br>
      <Row>
        <Col span="10" offset="">
          <h4>关联的角色</h4>
        </Col>
      </Row>
      <br>
      <Row>
        <Col span="20" offset="">
          <FormItem label="">
            <Table :columns="funcTableColumns" :data="funcTableData" ></Table>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col>
          <!--<FormItem>-->
            <!--<Button type="ghost" @click="goBack()">返回</Button>-->
          <!--</FormItem>-->
        </Col>
      </Row>
    </Form>
  </card>
</template>
<script>
export default {
  name: 'userDetail',
  data () {
    return {
      userId: this.$route.params.id,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {},
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],
      funcModal: false,
      funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init () {
      // 角色列表
      this.funcTableColumns = [
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

      if (this.userId) {
        this.getUserDetail()
      }
    },
    getUserDetail () {
      let self = this
      let url = this.$contants.restful.user + '/' + this.userId
      url = encodeURI(url)
      this.$axios.get(url)
        .then(function (response) {
          self.formData = response.data
          self.funcTableData = response.data.roleList
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    this.init()
  },
  computed: {
  },
  mounted () {
  },
  activated () {
    let initParamVal = this.$util.getRefreshInitParam(this, 'userDetail', this.$route.params.id)
    if (this.userId !== initParamVal) {
      this.userId = initParamVal
      this.init()
    }
  }
}
</script>
