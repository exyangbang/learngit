<style lang="less">
  @import '../../../styles/common.less';
</style>
<template>
  <card>
    <Row>
      <Col>
        <Form :label-width="120" ref="form" :model="formData" label-position="right" :inline="true">
          <FormItem label="角色名称：" prop="name">
            <Input v-model="formData.rolename" :maxlength="nameSize" class="input-width-170"/>
          </FormItem>
          <FormItem>
            <Button v-access id="listRole" type="primary" @click="searchBtn()">查询</Button>
            <Button html-type="reset" class="margin-left-10 " @click="resetBtn()">重置</Button>
            <Button type="success" class="margin-left-10 " v-access id="addRole" @click="showCreate()">新增</Button>
          </FormItem>
        </Form>
      </Col>
    </Row>
    <Row>
      <Col span="9" offset="1">
        <Table :columns="tableColumns" :data="tableData" highlight-row stripe border></Table>
        <br/>
        <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page" :page-size="pageSize" />
      </Col>
    </Row>
  </card>
</template>
<script>
    export default {
        name: 'roleManage',
        data() {
            return {
                // nameSize: this.$contants.pageSet.nameSize,
                // accountSize: this.$contants.pageSet.accountSize,
                formData: {},
                tableColumns: [],
                tableData: [],
                total: 0,
                pageNo: 1,
                pageSize: 10,
                editId: '',
                detailId: ''
            }
        },
        methods: {
            init() {
                this.tableColumns = [
                    {
                        title: '序号',
                        type: 'index',
                        width: 80
                    },
                    {
                        title: '角色名称',
                        key: 'rolename'
                    },
                    {
                        fixed: 'right',
                        width: 180,
                        title: '操作',
                        key: 'action',
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('svg-icon', {
                                    attrs: {
                                        id: 'editRole',
                                        title: '编辑'
                                    },
                                    props: {
                                        type: 'edit',
                                        size: '16'
                                    },
                                    style: {
                                        marginRight: '20px',
                                        cursor: 'pointer'
                                    },
                                    directives: [{
                                        name: 'access'
                                    }],
                                    on: {
                                        click: () => {
                                            this.showEdit(params.row)
                                        }
                                    }
                                }, '编辑'),
                                h('svg-icon', {
                                    attrs: {
                                        id: 'detailRole',
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
                                h('Poptip', {
                                    props: {
                                        confirm: true,
                                        title: '您确定要删除这条数据吗?',
                                        transfer: true
                                    },
                                    on: {
                                        'on-ok': () => {
                                            this.doDelete(params.row)
                                        }
                                    }
                                }, [
                                    h('svg-icon', {
                                        attrs: {
                                            id: 'deleteRole',
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
                this.searchList()
            },
            searchList(useFormCache) {
                let self = this
                let queryUrl = this.$contants.restful.roles + '?pageNo=' + this.pageNo + '&pageSize=' + this.pageSize

                if(useFormCache){
                    this.formData = this.$util.getSearchFormCache(this)
                }else{
                    this.$util.setSearchFormCache(this,this.formData)
                }
                if (this.formData.rolename) {
                    queryUrl = queryUrl + '&rolename=' + this.formData.rolename
                }
                queryUrl = encodeURI(queryUrl)
                this.$axios.get(queryUrl)
                    .then(function (response) {
                        self.tableData = response.data.list
                        self.total = parseInt(response.data.total)
                    })
                    .catch(function (error) {
                        console.log(error)
                    })
            },
            changePage(index) {
                // 分页点击事件
                this.pageNo = parseInt(index)
                this.searchList(true)
            },
            searchBtn() {
                this.pageNo = 1
                this.searchList()
            },
            resetBtn() {
                this.formData = {}
                this.pageNo = 1
            },
            showEdit(row) {
                this.editId = row.id;
                this.$router.push({
                    name: 'editRole',
                    params: {
                        id: row.id
                    }
                })
            },
            doDelete(row) {
                let self = this
                this.$axios.delete(this.$contants.restful.role + '/' + row.id)
                    .then(function () {
                        self.$Message.success('删除成功！')
                        if (self.editId === row.id) {
                            self.$store.commit('removeTag', 'editRole')
                        }
                        if (self.detailId === row.id) {
                            self.$store.commit('removeTag', 'detailRole')
                        }
                        self.searchList()
                    })
                    .catch(function (error) {
                        console.log(error)
                    })
            },
            showDetail(row) {
                this.detailId = row.id;
                this.$router.push({
                    name: 'detailRole',
                    params: {
                        id: row.id
                    }
                })
            },
            showCreate() {
                this.$router.push({
                    name: 'addRole'
                })
            }
        },
        mounted() {
            this.init()
        },
        beforeDestroy() {

        },
        created() {
        },
        activated() {
            if (this.$util.isRefresh(this)) {
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
