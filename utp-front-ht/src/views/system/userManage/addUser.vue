<style lang="less">
  .footer-border {
    padding: 0;
    border: none;
  }
</style>
<template>
  <card>
    <Form ref="formValidate" :model="formData" :label-width="120" :rules="ruleValidate">
      <Row>
        <Col span="10" offset="1">
          <h4>基本信息</h4>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="10" offset="1">
          <!--<FormItem label="是否使用UM：" prop="umLogin">-->
          <!--<RadioGroup v-model="useUM" @on-change="changeval" type="button">-->
          <!--<Radio label="使用UM" value="0"></Radio>-->
          <!--<Radio label="不使用UM" value="1"></Radio>-->
          <!--</RadioGroup>-->
          <!--</FormItem>-->
          <FormItem label="姓名：" prop="name">
            <Input v-model="formData.name" placeholder="请输入姓名" :maxlength="20"/>
          </FormItem>
          <FormItem label="登录账号：" prop="username">
            <Input v-model="formData.username" placeholder="请输入登录账号(最大40位，不能包含特殊字符)" :maxlength="40"/>
          </FormItem>
          <FormItem label="登录密码：" v-if="passWordDis" prop="password">
            <Input v-model="formData.password"
                   type="password"
                   placeholder="请输入密码(6-20位，必须同时包含数字和字母)"
                   :maxlength="20"
                   onpaste="return false"
                   oncontextmenu="return false"
                   oncopy="return false"
                   oncut="return false"/>
          </FormItem>
          <FormItem label="电话号码：" prop="mobileNo">
            <Input v-model="formData.mobileNo" placeholder="请输入电话号码" :maxlength="20"/>
          </FormItem>
          <FormItem label="邮箱：" prop="email">
            <Input v-model="formData.email" placeholder="请输入邮箱" :maxlength="50"/>
          </FormItem>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <Row>
        <Col span="10" offset="1">
          <h4>关联的角色</h4>
        </Col>
      </Row>
      <Row>
        <Col span="10" offset="1">
          <FormItem label="">
            <Button type="ghost" icon="ios-plus-empty" @click="openFuncModal()">选择</Button>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="20" offset="1">
          <FormItem label="">
            <Table :columns="funcTableColumns" :data="funcTableData"></Table>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="10" offset="1">
          <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">提交</Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
    <!-- 弹出角色选择框-->
    <Modal v-model="funcModal" title="选择关联角色" width="700" :mask-closable="false">
      <func-list v-if="funcModalShow" :selectedData="funcTableData" :sureBtnDisabled=true :mydate=Date()
                 @checkFunc="checkFunc" @hideFunc="hideFunc"></func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>
    import funcList from './components/funcList.vue'
    import crypto from 'crypto'

    export default {
        name: 'addUser',
        components: {
            funcList: funcList
        },
        data() {
            return {
                useUM: '使用UM',
                passWordDis: false,
                userId: null,
                type: null,
                currentPage: 1,
                roleList: [],
                formData: {
                    password: '',
                    umLogin: '1'
                },
                ruleValidate: {
                    name: [
                        {required: true, trigger: 'blur', message: '请输入姓名', max: 20}
                        // {pattern: /^[\u4e00-\u9fff\w]{1,20}$/, message: '姓名为汉字、字母、数字、下划线或其组合！'}
                    ],
                    username: [
                        {required: true, trigger: 'blur', message: '请输入登录账号', max: 20}
                        // {pattern: /^[\u4e00-\u9fff\w]{1,20}$/, message: '登录账号为汉字、字母、数字、下划线或其组合！'}
                    ],
                    mobileNo: [
                        {required: true, trigger: 'blur', message: '请输入电话号码(5-20位数字)', min: 5, max: 20},
                        {pattern: /\+?[\d]{3,20}(-?)[\d]{2,20}$/, trigger: 'blur', message: '请输入正确电话号码(5-20位数字)'}
                    ],
                    email: [
                        {required: true, trigger: 'blur', message: '请输入邮箱', max: 50},
                        {
                            pattern: /^[a-zA-Z0-9]+([._\\-]*[a-zA-Z0-9])*@([a-zA-Z0-9]+[-a-zA-Z0-9]*[a-zA-Z0-9]+.){1,63}[a-zA-Z0-9]+$/,
                            message: '请输入正确邮箱！'
                        }
                    ],
                    password: [
                        {required: true, trigger: 'blur', message: '请输入密码'},
                        {
                            type: 'string',
                            message: '请输入6-20位密码(字母和数字的组合)',
                            trigger: 'blur',
                            pattern: /^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d]{6,20}$/
                        }
                    ]
                },
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
            init() {
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
            },
            // changeval (val) {
            //   if (val === '不使用UM') {
            //     this.passWordDis = true
            //     this.formData.umLogin = '0'
            //   }
            //   if (val === '使用UM') {
            //     this.passWordDis = false
            //     this.formData.umLogin = '1'
            //     this.formData.password = ''
            //   }
            // },
            handleSubmit(name) {
                let self = this
                this.formData.umLogin = '1'
                self.$refs[name].validate((valid) => {
                    if (valid) {
                        let params = {}
                        params = Object.assign(params, this.formData)
                        params.roleList = this.funcTableData

                        if (params.roleList.length <= 0) {
                            this.$Message.error('请先选择要关联的角色')
                            return
                        }
                        let md5 = crypto.createHash('md5')
                        md5.update(params.password)
                        let pwd = md5.digest('hex')
                        params.password = pwd
                        this.$axios.post(this.$contants.restful.user, params)
                            .then(() => {
                                this.$Message.success('添加用户成功')
                                // this.goBack()
                                self.$util.goBackByRouteName(self,"userManage",true)
                            })
                            .catch((error) => {
                                console.log(error)
                            })
                    }
                })
            },
            goBack() {
                this.$util.goBack(this)
            },
            // 打开功能点选择
            openFuncModal() {
                this.funcModalShow = true
                this.funcModal = !this.funcModal
            },

            // 获取到选中的数据
            checkFunc(data) {
                // 监听子组件funcList的事件，接收data
                this.funcTableData = data
                this.funcModal = !this.funcModal
            },
            hideFunc() {
                this.funcModal = !this.funcModal
                this.funcModalShow = false
            },
            validMobile(mobile) {
                var re = /^1\d{10}$/
                if (re.test(mobile)) {
                    return true
                } else {
                    return false
                }
            },
            validEmail(email) {
                var re = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/
                if (re.test(email)) {
                    return true
                } else {
                    return false
                }
            }
        },

        created() {
            this.init()
        },
        computed: {},
        mounted() {
        },
        activated() {
        }
    }
</script>
