<style lang="less">
    @import "./home.less";
    @import "../../styles/common.less";
</style>
<template>
    <div class="home-main">
        <Row :gutter="10">
            <Col :md="24" :lg="8">
                <Row class-name="home-page-row1" :gutter="10">
                    <Col :md="12" :lg="24" :style="{marginBottom: '10px'}">
                        <Card>
                            <Row type="flex" class="user-infor">
                                <Col span="8">
                                    <Row class-name="made-child-con-middle" type="flex" align="middle">
                                        <img class="avator-img" :src="avatorPath" />
                                    </Row>
                                </Col>
                                <Col span="16" style="padding-left:6px;">
                                    <Row class-name="made-child-con-middle" type="flex" align="middle">
                                        <div>
                                            <b class="card-user-infor-name">{{username}}</b>
                                            <p>当前用户</p>
                                        </div>
                                    </Row>
                                </Col>
                            </Row>
                            <!--<div class="line-gray"></div>-->
                            <!--<Row class="margin-top-8">-->
                                <!--<Col span="8"><p class="notwrap">上次登录时间:</p></Col>-->
                                <!--<Col span="16" class="padding-left-8">2017.09.12-13:32:20</Col>-->
                            <!--</Row>-->
                            <!--<Row class="margin-top-8">-->
                                <!--<Col span="8"><p class="notwrap">上次登录地点:</p></Col>-->
                                <!--<Col span="16" class="padding-left-8">北京</Col>-->
                            <!--</Row>-->
                        </Card>
                    </Col>
                </Row>
            </Col>
        </Row>
      <Modal
        v-model="haveUrl"
        title="未对账提示"
        :loading="loading"
        @on-ok="getUrlGO">
        <p>有未对账的数据，点击确定进入对账页面！</p>
      </Modal>
    </div>
</template>

<script>
import cityData from './map-data/get-city-value.js'
import Cookies from 'js-cookie'
export default {
  name: 'home',
  components: {
  },
  data () {
    return {
      avatorPath: 'static/default-avatar.svg',
      cityData: cityData,
      // haveUrl: false,
      loading: true
    }
  },
  computed: {
    // avatorPath () {
    //   return localStorage.avatorImgPath
    // },
    haveUrl () {
      if (this.$store.state.app.changeShowUrl && this.$store.state.app.isAle) {
        this.$store.commit('changeShowUrl', false)
        this.$store.commit('isAle', false)
        return true
      } else {
        return false
      }
      // return this.$store.state.app.showUrl
    },
    username () {
      return Cookies.get('user')
    }
  },
  methods: {
    init () {
      // this.$store.commit('changeShowUrl', false)
    },

    getUrlGO () {
      this.$router.push({
        name: 'jobTaskRecordList'
      })
    }
  },
  created () {
    this.init()
  }
}
</script>
