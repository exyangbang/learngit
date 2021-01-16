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
        <Col span="10" offset="2">
          <h4>证书详情</h4>
        </Col>
      </Row>
      <br>
      <Row>
        <Col span="10" offset="2">
          <FormItem label="证书名称：" prop="certificateName">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.certificateName }} </span>
          </FormItem>
          <FormItem label="证书编号：" prop="nacertificateNome">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.nacertificateNome }} </span>
          </FormItem>
          <FormItem label="证书类型：" prop="certificateType">
            <Select v-model="formData.certificateType">
              <Option value="01">私钥</Option>
              <Option value="02">公钥</Option>
            </Select>
          </FormItem>
          <FormItem label="渠道ID：" prop="channelId">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.channelId }} </span>
          </FormItem>
          <FormItem label="证书生效日期：" prop="effectiveDate">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.effectiveDate }} </span>
          </FormItem>
          <FormItem label="证书过期日期：" prop="expirationDate">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.expirationDate }} </span>
          </FormItem>
          <FormItem label="存储密码：" prop="storePassword">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.storePassword }} </span>
          </FormItem>
          <FormItem label="创建人：" prop="userCreate">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.userCreate }} </span>
          </FormItem>
          <FormItem label="备注：" prop="remark">
            <span style="width: 80%; word-wrap: break-word"> {{ formData.remark }} </span>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="10" offset="2">
          <h4>关联的商户</h4>
        </Col>
      </Row>
      <br>
      <Row>
        <Col span="20" offset="2">
          <FormItem label="">
            <Table :columns="funcTableColumns" :data="funcTableData" ></Table>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col>
          <FormItem>
            <Button type="ghost" @click="goBack()">返回</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
  </card>
</template>
<script>
export default {
  // name: "detailOrgCer",
  data () {
    return {
      id: this.$route.params.id,
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
      let url = this.$contants.restful.certificateInfo + '/' + this.id
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
  }
}
</script>
