<style lang="less">
  @import '../../../styles/common.less';
  .footer-border{
    padding:0;
    border:none;
  }
</style>
<template>
  <card>
    <Form  :model="formData"  ref="formData" :label-width="120" :rules="ruleValidate">
      <Row>
        <Col span="10" offset="" >
          <h4 style="display:inline">添加卡Bin信息</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <i style="height: 10px"></i>
      <Row>
        <Col span="24">
          <row>
            <Col span="12">
            <FormItem label="卡BIN号：" prop="binnum">
              <Input v-model="formData.binnum" style="width: 300px" placeholder="请输入卡BIN号" :maxlength="12" />
            </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="所属行行名称：" prop="bankname">
                <Input v-model="formData.bankname" style="width: 300px" placeholder="请输入所属行行名称" :maxlength="140" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="所属行行号：" prop="bankcode">
                <Input v-model="formData.bankcode" style="width: 300px" placeholder="请输入所属行行号" :maxlength="14" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="所属行分类标识：" prop="banktypeflag">
                <Select v-model="formData.banktypeflag" style="width: 300px" placeholder="请选择所属行分类标识">
                  <Option v-for="item in this.$contants.dictionary.banktypeflag" :value="item.value" :key="item.name">{{ item.name }}</Option>
                </Select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="卡BIN长度：" prop="binlen">
                <Input v-model="formData.binlen" style="width: 300px" placeholder="请输入卡BIN长度" :maxlength="2" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="卡BIN起始字节：" prop="binstartpos">
                <Input v-model="formData.binstartpos" style="width: 300px" placeholder="卡BIN起始字节" :maxlength="10" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="主账号长度：" prop="cardnolen">
                <Input v-model="formData.cardnolen" style="width: 300px" placeholder="主账号长度" :maxlength="2" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="主账号起始字节：" prop="cardnostartPos">
                <Input v-model="formData.cardnostartPos" style="width: 300px" placeholder="主账号起始字节" :maxlength="10" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="人行清算行行名：" prop="clearbankname">
                <Input v-model="formData.clearbankname" style="width: 300px" placeholder="请输入人行清算行行名" :maxlength="120" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="人行清算行行号：" prop="clearbankno">
                <Input v-model="formData.clearbankno" style="width: 300px" placeholder="请输入人行清算行行号" :maxlength="14" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="是否银联卡品牌：" prop="cuplogoflag">
                <Select v-model="formData.cuplogoflag" style="width: 300px" placeholder="请选择是否银联卡品牌">
                  <Option v-for="item in this.$contants.dictionary.cuplogoflag" :value="item.value" :key="item.name">{{ item.name }}</Option>
                </Select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="卡种：" prop="debitcreditflag">
                <Select v-model="formData.debitcreditflag" style="width: 300px" placeholder="请选择是否银联卡品牌">
                  <Option v-for="item in this.$contants.dictionary.debitcreditflag" :value="item.value" :key="item.name">{{ item.name }}</Option>
                </Select>
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="发卡行机构代码：" prop="issuercode">
                <Input v-model="formData.issuercode" style="width: 300px" placeholder="请输入发卡行机构代码" :maxlength="14" />
              </FormItem>
            </Col>
            <Col span="12">
              <FormItem label="发卡机构名称：" prop="issuername">
                <Input v-model="formData.issuername" style="width: 300px" placeholder="请输入发卡机构名称" :maxlength="120" />
              </FormItem>
            </Col>
          </row>
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
    name: 'addCardBinInfo',
    data () {
    return {
      industryCode: '',
      industryAry: [],
      industryAryFirst: '',
      choseIndustry: false,
      jobDateAry: [],
      currentPage: 1,
      formData: {
        binnum: '',
        bankname: '',
        bankcode: '',
        banktypeflag: '0',
        binlen: '',
        binstartpos: '',
        cardnolen: '',
        cardnostartPos: '',
        clearbankname: '',
        clearbankno: '',
        cuplogoflag: '0',
        debitcreditflag: '',
        issuercode: '',
        issuername: ''
      },
      ruleValidate: {
        binnum: [
          {required: true, trigger: 'blur', message: ' 请输入卡BIN号'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        bankname: [
          {required: true, trigger: 'blur', message: '请输入所属行行名称'}
        ],
        bankcode: [
          {required: true, trigger: 'blur', message: '请输入所属行行号'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        banktypeflag: [
          {required: true, trigger: 'change', message: '请选择所属行分类标识'}
        ],
        binlen: [
          {required: true, trigger: 'blur', message: '请输入卡BIN长度'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        binstartpos: [
          {required: true, trigger: 'blur', message: '请输入卡BIN起始字节'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        cardnolen: [
          {required: true, trigger: 'blur', message: '请输入主账号长度'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        cardnostartPos: [
          {required: true, trigger: 'blur', message: '请输入主账号起始字节'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        clearbankname: [
          {required: true, trigger: 'blur', message: '请输入人行清算行行名'}
        ],
        clearbankno: [
          {required: true, trigger: 'blur', message: '请输入人行清算行行号'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        cuplogoflag: [
          {required: true, trigger: 'change', message: '请选择是否银联卡品牌'}
        ],
        debitcreditflag: [
          {required: true, trigger: 'blur', message: '请输入卡种'}
        ],
        issuercode: [
          {required: true, trigger: 'blur', message: '请输入发卡行机构代码'},
          {pattern: /^[0-9]*$/, message: '只能输入数字！'}
        ],
        issuername: [
          {required: true, trigger: 'blur', message: '请输入发卡机构名称'}
        ]
      },
      tree: [{}]
    }
  },
  methods: {
    init () {

    },
    handleSubmit () {
      let that = this
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.$axios.post('/cardBinInfo', this.formData).then(function (res) {
            that.$Message.success('添加卡Bin信息成功')
            that.goBack()
          })
        } else {
          that.$Message.error('请正确填写信息')
        }
      })
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    // 用这个对象
    this.init()
  },
  mounted () {},
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
