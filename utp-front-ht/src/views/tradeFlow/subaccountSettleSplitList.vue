<template>
    <card>
        <Form :label-width="120" ref="formData" :model="formData" label-position="right" :inline="true">
            <Row>
                <FormItem  label="清算开始日期：" prop="beginSettleDate">
                    <DatePicker :options="beginSettleDateOption" v-model="formData.beginSettleDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择清算开始日期" @on-change="beginSettleDateChange"></DatePicker>
                </FormItem>
                <FormItem  label="清算结束日期：" prop="endSettleDate">
                    <DatePicker :options="endSettleDateOption" v-model="formData.endSettleDate" class="input-width-170" type="date" :editable="false"  format="yyyy-MM-dd" placeholder="请选择清算结束日期" @on-change="endSettleDateChange"></DatePicker>
                </FormItem>
                <FormItem label="客户号：" prop="industryCode" >
                    <Input v-model="formData.industryCode" placeholder="请输入客户号" style="width: 170px" />
                </FormItem>
                <FormItem label="转出用户账户：" prop="payerSubAccount" >
                    <Input v-model="formData.payerSubAccount" placeholder="请输入客户号" style="width: 170px" />
                </FormItem>
                <FormItem label="转入用户账户：" prop="payeeSubAccount" >
                    <Input v-model="formData.payeeSubAccount" placeholder="请输入客户号" style="width: 170px"/>
                </FormItem>
                <FormItem label="批次号：" prop="batchNo" >
                    <Input v-model="formData.batchNo" placeholder="请输入客户号" style="width: 170px"/>
                </FormItem>
                <FormItem label="入账状态：" prop="status">
                    <Select v-model="formData.status" style="width: 170px">
                        <i-option value="0">未入账</i-option>
                        <i-option value="1">已入账</i-option>
                    </Select>
                    </FormItem>
                <FormItem label="交易状态：" prop="transStatus">
                    <Select v-model="formData.transStatus" style="width: 170px">
                        <i-option value="PRE_CREATE">创建订单</i-option>
                        <i-option value="PROCESSING">处理中</i-option>
                        <i-option value="TRADE_SUCCESS">交易成功</i-option>
                        <i-option value="TRADE_FAILURE">交易失败</i-option>
                    </Select>
                </FormItem>
                <FormItem>
                    <Button type="primary" @click="searchBtn()" v-access id="subaccountSettleSplitForm">查询</Button>
                    <Button type="ghost" class="margin-left-10 " @click="resetBtn()">重置</Button>
                    <Button type="success" class="margin-left-10" v-access id="subaccountSettleSplitFormDownLoad" @click="downLoad()" :disabled = "disDownLoad">导出</Button>
                </FormItem>
            </Row>
        </Form>
        <Row style=" height: 40px; background: #9ea7b4; color: #fff; line-height: 40px; text-indent: 1.2em; width: 100%">
            <Col :span="6">
                <span>交易总笔数：{{totalCount}}</span>
            </Col>
            <Col :span="6">
                <span>交易总金额：{{totalMoney}}</span>
            </Col>
        </Row>
        <Row>
            <Table border :columns="tableColumns" :data="tableData" highlight-row stripe ></Table>
            <br/>
            <Page :total="total" :current="pageNo" show-total @on-change="changePage" class="page"/>
        </Row>
    </card>
</template>
<script>
export default {
    name: 'subAccountSettleSplitList',
    data() {
        return {
            disDownLoad: true,
            formData: {},
            tableColumns: [],
            tableData: [],
            pageNo: 1,
            pageSize: 10,
            total: 0,
            totalCount: 0,
            totalMoney: 0,
            beginSettleDateOption: {
                disabledDate (date) {
                    return date && date.valueOf() > Date.now()
                }
            },
            endSettleDateOption: {
                disabledDate (date) {
                    return date && date.valueOf() < Date.now() - 86400000
                }
            }
        }
    },
    methods: {
        beginSettleDateChange(value) {
            let dateGet = new Date(value)
            this.endSettleDateOption = {
                disabledDate (date) {
                    return date && date.valueOf() < dateGet.valueOf() - 86400000
                }
            }
        },
        endSettleDateChange(value) {
            let dateGet = new Date(value)
            this.beginSettleDateOption = {
                disabledDate (date) {
                    return (date && date.valueOf() > Date.now()) || (date && date.valueOf() > dateGet.valueOf())
                }
            }
        },
        searchBtn() {
            this.searchList()
        },
        searchList() {
            let self = this
            let parameters = {}
            if (self.formData.beginSettleDate) {
                parameters.beginSettleDate = self.$moment(self.formData.beginSettleDate).format('YYYYMMDD')
            }
            if (self.formData.endSettleDate) {
                parameters.endSettleDate = self.$moment(self.formData.endSettleDate).format('YYYYMMDD')
            }
            if (self.formData.industryCode) {
                parameters.industryCode = self.formData.industryCode
            }
            if (self.formData.payerSubAccount) {
                parameters.payerSubAccount = self.formData.payerSubAccount
            }
            if (self.formData.payeeSubAccount) {
                parameters.payeeSubAccount = self.formData.payeeSubAccount
            }
            if (self.formData.batchNo) {
                parameters.batchNo = self.formData.batchNo
            }
            if (self.formData.status) {
                parameters.status = self.formData.status
            }
            if (self.formData.transStatus) {
                parameters.transStatus = self.formData.transStatus
            }
            let query = {
                pageNo: self.pageNo,
                pageSize: self.pageSize,
                parameters: parameters
            }
            self.$axios.post(self.$contants.restful.subaccountSettleSplitFormList, query).then(function(response) {
                self.tableData = response.data.page.list
                self.total = parseInt(response.data.page.total)
                self.totalCount = response.data.statistics.total + '笔'
                self.totalMoney = response.data.statistics.totalAmount / 100 + '元'
                if (self.tableData.length > 0) {
                    self.disDownLoad = false
                } else {
                    self.disDownLoad = true
                }
            }).catch(function (error) {
                console.error(error)
            })
        },
        resetBtn() {
            this.formData = {}
            this.pageNo = 1
            this.beginSettleDateOption = {
                disabledDate (date) {
                    return date && date.valueOf() > Date.now()
                }
            },
            this.endSettleDateOption = {
                disabledDate (date) {
                    return date && date.valueOf() < Date.now() - 86400000
                }
            }
        },
        downLoad() {
            let self = this
            let parameters = {}
            if (self.formData.beginSettleDate) {
                parameters.beginSettleDate = self.$moment(self.formData.beginSettleDate).format('YYYYMMDD')
            }
            if (self.formData.endSettleDate) {
                parameters.endSettleDate = self.$moment(self.formData.endSettleDate).format('YYYYMMDD')
            }
            if (self.formData.industryCode) {
                parameters.industryCode = self.formData.industryCode
            }
            if (self.formData.payerSubAccount) {
                parameters.payerSubAccount = self.formData.payerSubAccount
            }
            if (self.formData.payeeSubAccount) {
                parameters.payeeSubAccount = self.formData.payeeSubAccount
            }
            if (self.formData.batchNo) {
                parameters.batchNo = self.formData.batchNo
            }
            if (self.formData.status) {
                parameters.status = self.formData.status
            }
            if (self.formData.transStatus) {
                parameters.transStatus = self.formData.transStatus
            }
            let query = {
                parameters: parameters
            }
            self.$axios({
                method: 'post',
                url: '/subAccountSettleSplit/download',
                data: query,
                responseType: 'blob'
            }).then(response => {
                self.download(response.data)
            }).catch((error) => {

            })
        },
        showDetail (row) {
            this.$router.push({
                name: 'subAccountSettleSplitDetail',
                params: {
                transOrderId: row.transOrderIds
                }
            })
        },
        download (data) {
            if (!data) {
                return
            }
            let downName = '子账户分账信息' + '.xlsx' // 文件下载名称
            const blob = new Blob([data])
            if (window.navigator.msSaveOrOpenBlob) {
                // 兼容IE10
                navigator.msSaveBlob(blob, downName)
            } else {
                // chrome/firefox
                let url = window.URL.createObjectURL(new Blob([data]))
                let link = document.createElement('a')
                link.style.display = 'none'
                link.href = url
                link.setAttribute('download', '子账户分账信息' + '.xlsx')
                document.body.appendChild(link)
                link.click()
            }
        },
        changePage(index) {
            // 分页点击事件
            this.pageNo = parseInt(index)
            this.searchList()
        },
        init() {
            let self = this
            let avg = (document.body.clientWidth) / 1440
            this.tableColumns = [
                {
                    width: 150 * avg,
                    title: '批次号',
                    key: 'batchNo',
                },
                {
                    width: 150 * avg,
                    title: '清算日期',
                    key: 'settleDate',
                    render (h, a, b) {
                        if (a.row.settleDate) {
                        return h('div', self.$moment(this.row.settleDate).format('YYYY-MM-DD'))
                        }
                    }
                },
                {
                    width: 150 * avg,
                    title: '客户号',
                    key: 'industryCode',
                },
                {
                    width: 150 * avg,
                    title: '客户名称',
                    key: 'industryName',
                },
                {
                    width: 150 * avg,
                    title: '客户端流水号',
                    key: 'clientTransId',
                },
                {
                    width: 150 * avg,
                    title: '转出用户账户',
                    key: 'payerSubAccount',
                },
                {
                    width: 150 * avg,
                    title: '转出用户户名',
                    key: 'payerSubAccountName',
                },
                {
                    width: 150 * avg,
                    title: '转入用户账户',
                    key: 'payeeSubAccount',
                },
                {
                    width: 150 * avg,
                    title: '转入用户户名',
                    key: 'payeeSubAccountName',
                },
                {
                    width: 150 * avg,
                    title: '金额',
                    key: 'amount',
                    render (h, a, b) {
                        return h('span', a.row.amount / 100 + '元')
                    }
                },
                {
                    width: 150 * avg,
                    title: '结算方式',
                    key: 'settleMode',
                    render: (h, params) => {
                        return h('span', this.$contants.dictionary.splitSettleModeMap[params.row.settleMode])
                    }
                },
                {
                    width: 150 * avg,
                    title: '账期',
                    key: 'period',
                },
                {
                    width: 150 * avg,
                    title: '入账状态',
                    key: 'status',
                    render: (h, params) => {
                        return h('span', this.$contants.dictionary.splitStatusMap[params.row.status])
                    }
                },
                {
                    width: 150 * avg,
                    title: '交易状态',
                    key: 'transStatus',
                    render: (h, params) => {
                        return h('span', this.$contants.dictionary.transStatusMap[params.row.transStatus])
                    }
                },
                {
                    width: 150 * avg,
                    title: '交易结果描述',
                    key: 'transDesc',
                },
                {
                    width: 150 * avg,
                    title: '备注说明',
                    key: 'remark',
                },
                {
                    title: '操作',
                    key: 'action',
                    align: 'center',
                    width: 150 * avg,
                    render: (h, params) => {
                        return h('div', [
                        h('svg-icon', {
                            attrs: {
                            id: 'detailProduct',
                            title: '关联支付流水'
                            },
                            props: {
                            type: 'detail',
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
                                this.showDetail(params.row)
                            }
                            }
                        }, '关联支付流水')
                        ])
                    }
                }
            ]
            this.searchList()
        }
    },
    mounted () {
        this.init()
    }
}
</script>
<style lang="less">
  @import '../../styles/common.less';
  .hidden {
    display: none;
  }
</style>