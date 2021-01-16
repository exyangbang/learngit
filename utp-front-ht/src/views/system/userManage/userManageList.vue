<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="登录账号：" prop="username">
            <Input v-model="formData.username" :maxlength="accountSize" class="input-width-170"/>
          </FormItem>
          <FormItem label="姓名：" prop="name">
            <Input v-model="formData.name" class="input-width-170" :maxlength="20"/>
          </FormItem>
          <FormItem>
            <Button type="primary" @click="searchBtn()" style="margin-right: 10px;" v-access id="listUser">查询</Button>
            <Button type="default" @click="clearBtn()" style="margin-right: 10px;" v-access>重置</Button>
            <Button type="success" @click="createBtn()" style="margin-right: 10px;" v-access id="addUser">新增</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col>
        <Table border :columns="tableColumns" :data="tableData" highlight-row stripe></Table>
        <br>
        <Page :total="total" :current="currentPage" show-total @on-change="changePage" class="page"></Page>
      </Col>
    </Row>
  </card>
</template>

<script>
    import Crypto from 'crypto'
    import iconv from 'iconv-lite'
    import util from "../../../libs/util";

    export default {
        name: 'userManage',
        data() {
            return {
                formData: {},
                tableColumns: [],
                tableData: [],
                total: 0,
                currentPage: 1,
                data1: [{}],
                editId: '',
                detailId: ''
                // ruleValidate: {
                //   name: [
                //     {required: true, trigger: 'blur', message: '请输入姓名', max: 20},
                //     {pattern: /^[\u4e00-\u9fff\w]{1,20}$/, message: '姓名为汉字、字母、数字、下划线或其组合！'}
                //   ],
                //   username: [
                //     {required: true, trigger: 'blur', message: '登录账号', max: 20},
                //     {pattern: /^[a-zA-Z0-9_]{1,20}$/, message: '登录账号为字母、数字、下划线或其组合！'}
                //   ]
                // }
            }
        },
        methods: {
            init() {
                // 设置
                let self = this
                let currentUsername = self.$cookies.get('user')
                let avg = (document.body.clientWidth) / 1440
                console.log(currentUsername)
                this.tableColumns = [
                    {
                        title: '序号',
                        type: 'index',
                        width: 80
                    },
                    {
                        title: '登录账号',
                        key: 'username',
                        width: 150 * avg
                    },
                    {
                        title: '姓名',
                        key: 'name',
                        width: 180 * avg
                    },
                    {
                        title: '联系电话',
                        key: 'mobileNo',
                        width: 180 * avg
                    },
                    {
                        title: '邮箱',
                        key: 'email'
                    },
                    {
                        title: '更新时间',
                        key: 'gmtModified',
                        render: function (h, a, b) {
                            if (this.row.gmtModified) {
                                return h('div', self.$moment(this.row.gmtModified).format('YYYY-MM-DD HH:mm:ss'))
                            }
                            //   var d = new Date(a.row.gmtModified)
                            //   let mm = ''
                            //   let dd = ''
                            //   let hh = ''
                            //   let min = ''
                            //   let ss = ''
                            //   if (d.getMonth() + 1 < 10) {
                            //     mm = '0' + (d.getMonth() + 1).toString()
                            //   } else {
                            //     mm = d.getMonth() + 1
                            //   }
                            //   if (d.getDate() < 10) {
                            //     dd = '0' + d.getDate().toString()
                            //   } else {
                            //     dd = d.getDate()
                            //   }
                            //   if (d.getHours() < 10) {
                            //     hh = '0' + d.getHours().toString()
                            //   } else {
                            //     hh = d.getHours()
                            //   }
                            //   if (d.getMinutes() < 10) {
                            //     min = '0' + d.getMinutes().toString()
                            //   } else {
                            //     min = d.getMinutes()
                            //   }
                            //   if (d.getSeconds() < 10) {
                            //     ss = '0' + d.getSeconds().toString()
                            //   } else {
                            //     ss = d.getSeconds()
                            //   }
                            //   var times = d.getFullYear() + '-' + mm + '-' + dd + ' ' + hh + ':' + min + ':' + ss
                            //   return h('span', times)
                            // return h('div', self.$moment(this.row.updateTime).format('YYYY-MM-DD HH:mm:ss'))
                        }
                    },
                    {
                        title: '操作',
                        key: 'action',
                        align: 'left',
                        width: 200 * avg,
                        render: (h, params) => {
                            return h('div', [
                                h('svg-icon', {
                                    attrs: {
                                        id: 'editUser',
                                        title: '编辑'
                                    },
                                    props: {
                                        type: 'edit',
                                        size: '16'
                                    },
                                    style: {
                                        marginRight: '20px',
                                        cursor: 'pointer'
                                        // marginLeft: (params.row.username === 'admin' || params.row.username === currentUsername) ? '-16px' : ''
                                    },
                                    directives: [{
                                        name: 'access'
                                    }],
                                    on: {
                                        click: () => {
                                            this.update(params.row)
                                        }
                                    }
                                }, '编辑'),
                                h('svg-icon', {
                                    attrs: {
                                        id: 'detailUser',
                                        title: '详情'
                                    },
                                    directives: [{
                                        name: 'access'
                                    }],
                                    props: {
                                        type: 'detail',
                                        size: '16'
                                    },
                                    style: {
                                        marginRight: '20px',
                                        cursor: 'pointer'
                                    },
                                    on: {
                                        click: () => {
                                            this.showDetail(params.row)
                                        }
                                    }
                                }, '详情'),
                                // h('svg-icon', {
                                //   attrs: {
                                //     id: 'modifyPwdUser',
                                //     title: '修改密码'
                                //   },
                                //   props: {
                                //     type: 'modify-pwd',
                                //     size: '16'
                                //   },
                                //   style: {
                                //     marginRight: '20px',
                                //     cursor: 'pointer',
                                //     display: (params.row.umLogin === '1') ? 'none' : 'inline'
                                //   },
                                //   directives: [{
                                //     name: 'access'
                                //   }],
                                //   on: {
                                //     click: () => {
                                //       this.changePassword(params.row)
                                //     }
                                //   }
                                // }, '修改密码'),
                                // h('Poptip', {
                                //   props: {
                                //     confirm: true,
                                //     title: '确认重置该用户密码吗？',
                                //     transfer: true
                                //   },
                                //   on: {
                                //     'on-ok': () => {
                                //       this.resetPassword(params.row)
                                //     }
                                //   }
                                // }, [
                                //   h('svg-icon', {
                                //     attrs: {
                                //       id: 'resetPwdUser',
                                //       title: '重置密码'
                                //     },
                                //     directives: [{
                                //       name: 'access'
                                //     }],
                                //     style: {
                                //       marginRight: '20px',
                                //       cursor: 'pointer',
                                //       display: (params.row.umLogin === '1') ? 'none' : ''
                                //     },
                                //     props: {
                                //       type: 'reset-pwd',
                                //       size: '16'
                                //     }
                                //   }, '重置密码')
                                // ]),
                                h('Poptip', {
                                    props: {
                                        confirm: true,
                                        title: '您确定要删除这条数据吗?',
                                        transfer: true
                                    },
                                    style: {
                                        display: (params.row.username === currentUsername || params.row.username === 'admin') ? 'none' : ''
                                    },
                                    on: {
                                        'on-ok': () => {
                                            this.doDelete(params.row)
                                        }
                                    }
                                }, [
                                    h('svg-icon', {
                                        attrs: {
                                            id: 'deleteUser',
                                            title: '删除'
                                        },
                                        directives: [{
                                            name: 'access'
                                        }],
                                        style: {
                                            cursor: 'pointer'
                                        },
                                        props: {
                                            type: 'delete',
                                            size: '16'
                                        }
                                    }, '删除')
                                ])
                            ])
                        }
                    }
                ]
                // 查询信息
                this.searchList()
            },
            searchList(param,useCacheFormData) {
                let page = {
                    pageNo: this.currentPage,
                    pageSize: 10
                }
                param = param || {}
                param.pageNo = page.pageNo
                param.pageSize = page.pageSize
                if(useCacheFormData){
                    this.formData = this.$util.getSearchFormCache(this)
                }else{
                    this.$util.setSearchFormCache(this,this.formData)
                }
                param = Object.assign(param, this.formData)

                let uri = ''
                uri = this.$contants.restful.users + '?' + 'pageNo=' + param.pageNo + '&pageSize=' + param.pageSize
                if (param.username) {
                    uri = uri + '&username=' + param.username
                }
                if (param.name) {
                    uri = uri + '&name=' + param.name
                }
                // 查询用户信息
                uri = encodeURI(uri)
                this.$axios.get(uri)
                    .then((response) => {
                        this.tableData = response.data.list
                        this.total = parseInt(response.data.total)
                    })
                    .catch(function (error) {
                        console.log(error)
                    })
            },
            changePage(index) {
                // 分页点击事件
                this.currentPage = parseInt(index)
                this.searchList({},true)
            },
            searchBtn() {
                this.currentPage = 1
                this.searchList()
            },
            clearBtn() {
                this.formData = {}
            },
            createBtn() {
                this.$router.push({
                    name: 'addUser'
                })
            },
            doDelete(row) {
                this.$axios.delete(this.$contants.restful.user + '/' + row.id)
                    .then(() => {
                        this.$Message.success('删除成功！')
                        if (this.editId === row.id) {
                            this.$store.commit('removeTag', 'editUser')
                        }
                        if (this.detailId === row.id) {
                            this.$store.commit('removeTag', 'userDetail')
                        }
                        this.searchList()
                    })
                    .catch(function (error) {
                        console.log(error)
                    })
            },
            update(row) {
                this.editId = row.id;
                this.$router.push({
                    name: 'editUser',
                    params: {
                        id: row.id
                    }
                })
            },
            showDetail(row) {
                this.detailId = row.id;
                this.$router.push({
                    name: 'userDetail',
                    params: {
                        id: row.id
                    }
                })
            },
            changePassword(row) {
                this.$router.push({
                    name: 'changeUserPassword',
                    params: {
                        username: row.username
                    }
                })
            },
            resetPassword(row) {
                let self = this
                let param = {}
                param.id = row.id
                param.password = '123456'
                // let md5 = crypto.createHash('md5')
                // md5.update(param.password)
                // let pwd = md5.digest('hex')
                // param.password = pwd
                let md5 = Crypto.createHash('sha256')
                let str = param.password + '{' + row.username + '}'
                str = iconv.decode(str, 'gbk')
                md5.update(str)
                let newPwd = md5.digest('hex').toUpperCase()
                param.password = newPwd
                this.$axios.put(this.$contants.restful.userResetPwd, param)
                    .then(function (response) {
                        self.$Message.success('重置密码成功')
                    })
                    .catch(function (error) {
                        console.log(error)
                    })
            }
        },
        created() {
            this.init();
        },
        activated() {
            if(util.isRefresh(this)) {
                this.searchList()
            }
        },
        computed: {
            nameSize() {
                return this.$contants.pageSet.nameSize
            },
            accountSize() {
                return this.$contants.pageSet.accountSize
            }
        }
    }
</script>
