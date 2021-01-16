<style lang="less">
</style>
<template>
    <card>
      <Row type="flex" justify="center" align="middle">
        <Col span="10">
          <Upload
            :on-success="handleSuccess"
            :on-error="handleError"
            :headers=headers
            :max-size="10000"
            :format="['xls','xlsx']"
            accept=".xls,.xlsx"
            type="drag"
            :data="uploadData"
            :before-upload="beforeUpload"
            :action=uploadUrl>
            <div style="padding: 20px 0">
              <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
              <p>点击或拖拽上传模板文件<em style="color: #ff3300">支持 'xls,xlsx'</em></p>
            </div>
          </Upload>
        </Col>
      </Row>
      <Row type="flex" justify="center" align="middle">
        <Col>
          <Button type="ghost" @click="goBack()" class="margin-top-20">返回</Button>
        </Col>
      </Row>
    </card>
</template>
<script>

export default {
  name: 'importSubPayPayeeWhiteList',
  data () {
    return {
      id: this.$route.params.id,
      uploadUrl: this.$contants.importSubPayPayeeWhiteListCUrl,
      uploadData: {}
    }
  },
  methods: {
    init () {
      let hello = this.headers
      console.log(hello)
    },
    goBack () {
      this.$util.goBack(this)
    },
    beforeUpload () {
      this.uploadData = {
        id: this.id
      }
      let promise = new Promise((resolve) => {
        this.$nextTick(function () {
          resolve(true);
        });
      });
      return promise;

    },
    handleSubmit () {
      let config = {
        transformRequest: [function (data) {
          return data
        }],
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }
      let fd = new FormData()
      for (let key in this.formData) {
        fd.append(key, this.formData[key])
      }
      this.$axios.post('', fd, config)
        .then(function (response) {
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    handleSuccess (res, file) {
      this.$Notice.success({
        title: '文件上传成功',
        desc: '文件 ' + file.name + ' 上传成功。' + res
      })
      this.goBack()
    },
    handleError (event, file) {
      if (event.status && event.status === '401') {
        this.$Message.error('登录已过期，请重新登录')
        this.$store.commit('logout')
        this.$store.commit('clearOpenedSubmenu')
        this.$router.push({
          name: 'login'
        })
      } else {
        this.$Notice.error({
          title: '文件上传失败',
          desc: file.message
        })
      }
    }
  },

  mounted () {
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
  }
}
</script>
