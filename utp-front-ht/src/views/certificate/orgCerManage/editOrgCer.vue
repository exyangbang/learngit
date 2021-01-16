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
                    action="" accept=".cer" name="uploadFile">
              <div style="padding: 20px 0">
                <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
                <p>点击或拖拽上传公钥文件</p>
              </div>
            </Upload>
            <div v-if="fileName">
              <p> {{fileName}} </p>
            </div>
          </FormItem>
          <FormItem label="证书编号：">
            <span>{{formData.certificateNo}}</span>
          </FormItem>
          <!--<FormItem label="收单机构：">-->
            <!--<span> {{ formData.orgName }} </span>-->
          <!--</FormItem>-->
          <FormItem label="证书名称：" prop="certificateName">
            <Input v-model="formData.certificateName" placeholder="证书名称" :maxlength="200" />
          </FormItem>
          <FormItem label="备注：" prop="remark">
            <Input v-model="formData.remark" type="textarea"  placeholder="备注" :autosize="true" :maxlength="500" />
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="10" offset="2">
          <FormItem>
            <Button type="primary" @click="handleSubmit()">提交</Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
  </card>
</template>
<script>

export default {
  name: "editOrgCer",
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
        effectiveDate: [
          {required: true, trigger: 'blur', message: '请选择证书生效日期'}
        ],
        expirationDate: [
          {required: true, trigger: 'blur', message: '请选择证书失效日期'}
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],
      funcModal: false,
      funcModalShow: false, // 用来更新数据
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
      // 查询机构列表
      this.searchOrgList()
    },
    handleSubmit () {
      let self = this
      self.$refs['formValidate'].validate((lidate) => {
        if (lidate) {
          self.formData.certificateType = '1'
          self.formData.channelId = '0000'
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
          for (let key in self.formData) {
            fd.append(key, self.formData[key])
          }
          self.$axios.put(this.$contants.UpdatePublicCertificateUrl, fd, config)
            .then(function (response) {
              self.$Message.success('更新客户证书成功')
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

    // 获取机构列表
    searchOrgList () {
      // let self = this
      let param = {}
      param.pageNo = 1
      param.pageSize = 1000000
      param = Object.assign(param, this.formData)
      // 获取机构列表
      // this.$axios.get(this.$contants.restful.organizations + '?pageNo=' + param.pageNo + '&pageSize=' + param.pageSize)
      //   .then((response) => {
      //     self.funcTableData = response.data.list
      //   })
      //   .catch((error) => {
      //     console.log(error)
      //   })
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
