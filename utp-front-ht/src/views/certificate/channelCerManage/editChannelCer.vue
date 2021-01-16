<style lang="less">
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form ref="formValidate" :model="formData" :label-width="120" :rules="ruleValidate" method="post" enctype="multipart/form-data">
      <Row>
        <Col span="10" offset="2">
          <FormItem>
            <Upload multiple
                    type="drag"
                    :on-success="handleSuccess"
                    :on-error="handleError"
                    :headers="headers" :before-upload="beforeUpload"
                    action="" accept=".pfx" name="uploadFile">
              <div style="padding: 20px 0">
                <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
                <p>点击或拖拽上传私钥文件</p>
              </div>
            </Upload>
            <div v-if="fileName">
              <p>{{fileName}}</p>
            </div>
          </FormItem>
          <FormItem label="证书编号：">
            <span>{{formData.certificateNo}}</span>
          </FormItem>
          <FormItem label="收单机构：" prop="orgCode">
            <span> {{ formData.orgName }} </span>
          </FormItem>
          <FormItem label="证书名称：" prop="certificateName">
            <Input v-model="formData.certificateName" placeholder="证书名称" :maxlength="200" />
          </FormItem>
          <FormItem label="证书密码：" prop="privateKeyPassword">
            <Input v-model="formData.privateKeyPassword" type="password" placeholder="请输入证书密码" :maxlength="8" onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>
          </FormItem>
          <FormItem label="store密码：" prop="privateStorePassword">
            <Input v-model="formData.privateStorePassword" type="password" placeholder="请输入store密码" :maxlength="8" onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>
          </FormItem>
          <FormItem label="备注：" prop="remark">
            <Input v-model="formData.remark" type="textarea"  placeholder="备注" :autosize="true" :maxlength="500" />
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="10" offset="2">
          <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')"  >提交 </Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
  </card>
</template>
<script>

export default {
  name: "editChannelCer",
  data () {
    return {
      id: this.$route.params.id,
      type: this.$route.params.type,
      uploadHeader: null,
      currentPage: 1,
      roleList: [],
      formData: {},
      uploadUrl: this.$contants.UploadImageUrl,
      ruleValidate: {
        certificateName: [
          {required: true, trigger: 'blur', message: '请输入证书名称'},
          {max: 200, message: '最大长度200', trigger: 'blur'},
          {pattern: /^[\u4e00-\u9fff\w]{1,200}$/, message: '证书名称为汉字、字母、数字、下划线或其组合！'}
        ],
        privateKeyPassword: [
          {required: true, trigger: 'blur', message: '请输入密码'},
          { type: 'string', min: 6, max: 8, message: '请输入6-8位密码', trigger: 'blur' }
        ],
        privateStorePassword: [
          {required: true, trigger: 'blur', message: '请输入存储密码'},
          { type: 'string', min: 6, max: 8, message: '请输入6-8位密码', trigger: 'blur' }
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],

      fileContent: null,
      fileName: null
    }
  },
  methods: {
    init () {
      this.funcTableColumns = [
        {
          title: '序号',
          type: 'index',
          width: 160
        },
        {
          title: '机构名称',
          key: 'contactName'
        },
        {
          title: '机构代码',
          key: 'countyCode'
        }
      ]

      this.searchDetail()
    },
    handleSubmit (name) {
      let self = this
      self.$refs[name].validate((lidate) => {
        if (lidate) {
          this.formData.certificateType = '2'
          this.formData.channelId = '0000'

          if (!self.$util.validPasswordPrivatekey(self.formData.privateKeyPassword)) {
            self.$Message.error('证书密码只能为6-8位字母或数字')
            return
          }

          if (!self.$util.validPasswordPrivatekey(self.formData.privateStorePassword)) {
            self.$Message.error('store密码只能为6-8位字母或数字')
            return
          }

          let config = {
            transformRequest: [function (data) {
              return data
            }],
            headers: {
              'Content-Type': 'multipart/form-data'
            },
            onUploadProgress: {}
          }
          let fd = new FormData()
          for (let key in this.formData) {
            fd.append(key, this.formData[key])
          }
          this.$axios.put(this.$contants.UpdatePrivateKeyUrl, fd, config)
            .then(function (response) {
              self.$Message.success('更新渠道证书成功')
              self.goBack()
            })
            .catch(function () {
            })
        }
      })
    },
    beforeUpload (file) {
      this.fileName = file.name
      this.formData.file = file

      return false
    },
    handleSuccess (event, file) {
      this.formData.certificatePath = file.response
      console.log(file)
      this.$Notice.success({
        title: '文件上传成功',
        desc: '文件 ' + file.name + ' 上传成功。'
      })
    },
    handleError (event, file) {
      this.$Notice.error({
        title: '文件上传失败',
        desc: '文件 ' + file.name + ' 上传失败。'
      })
    },
    searchDetail () {
      let self = this
      let url = this.$contants.restful.certificateInfo + '/' + this.id
      url = encodeURI(url)
      this.$axios.get(url)
        .then((response) => {
          self.formData = response.data
        })
        .catch((error) => {
          console.log(error)
        })
    },
    goBack () {
      this.$util.goBack(this)
    },
    dateCheckStart (val) {
      if (val && this.formData.endTime && val > this.formData.endTime) {
        this.$Message.error('结束日期不能小于开始日期')
        this.formData.effectiveDate = ''
      } else {
        this.formData.effectiveDate = val
      }
    },
    dateCheckEnd (val) {
      if (this.formData.startTime && val && this.formData.startTime > val) {
        this.$Message.error('结束日期不能小于开始日期')
        this.formData.expirationDate = ''
      } else {
        this.formData.expirationDate = val
      }
    }
  },
  created () {
    this.init()
  },
  computed: {
    headers () {
      if (!this.$store.state.app.token) {
        this.$store.commit('setToken', localStorage.getItem('token'))
      }
      return {
        'X-Requested-With': 'XMLHttpRequest',
        'X-Authorization': 'Bearer ' + this.$store.state.app.token
      }
    }
  },
  mounted () {
  }
}
</script>
