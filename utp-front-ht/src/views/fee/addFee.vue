<style lang="less">
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
          <h4 style="display:inline">添加手续费模板</h4>
          <Button type="ghost" @click="goBack()" style="margin-left: 20px">返回</Button>
        </Col>
      </Row>
      <br>
      <hr>
      <br>
      <i style="height: 10px"></i>
      <Row>
        <Col span="12">
          <row>
            <Col span="24">
          <FormItem label="手续费模板名称：" prop="name">
              <Input v-model="formData.name" style="width: 300px" placeholder="请输入手续费模板名称" :maxlength="nameSize" />
            </FormItem>
            </Col>

            <Col span="24">
              <FormItem label="手续收费方式：" prop="chargeMode">
                <i-select v-model="formData.chargeMode"  style="width:300px" @on-change="chargeModeChange" not-found-text="请先选择手续费结算类型">
                  <i-option v-for="item in chargeModeAry"  :key="item.value" :value="item.value">{{ item.name }}</i-option>
                </i-select>
              </FormItem>
            </Col>

            <Col span="24">
              <FormItem :label="feeYuan" prop="fee" v-if="anPenDis">
                <Input v-model="formData.fee" style="width: 300px" @on-blur="feelVailt" placeholder="请输入手续费" :maxlength="10" />
              </FormItem>
            </Col>

            <Col span="24">
              <FormItem label="最大手续费(元)：" prop="maxFee" v-if="smallFeeDis">
                <Input v-model="formData.maxFee" style="width: 300px" @on-blur="maxFeeBlure" placeholder="请输入手续费参数" :maxlength="10" />
              </FormItem>
            </Col>

          </row>
        </Col>
        <Col span="12">
          <Col span="24">
            <FormItem label="手续费结算类型：" prop="settleType">
              <i-select v-model="formData.settleType"  style="width:300px" @on-change="settleTypeChange">
                <i-option v-for="item in settleTypeAry"  :key="item.value" :value="item.value">{{ item.name }}</i-option>
              </i-select>
            </FormItem>
          </Col>
          <Col span="24">
            <FormItem label="手续费计算方式：" prop="calculateMode">
              <i-select v-model="formData.calculateMode"  style="width:300px" @on-change="calculateModeChange">
                <i-option v-for="item in calculateModeAry"  :key="item.value" :value="item.value">{{ item.name }}</i-option>
              </i-select>
              <i-button type="primary" @click.native="setPage" :disabled="peizhiVal">配置区间价格</i-button>
            </FormItem>
          </Col>
          <Col span="24">
            <FormItem label="最小手续费(元)：" prop="minFee" v-if="smallFeeDis">
              <Input v-model="formData.minFee" style="width: 300px" @on-blur="minFeeBlure" placeholder="请输入手续费参数" :maxlength="10" />
            </FormItem>
          </Col>
          <Col span="24" v-if="remarkDisOne">
            <FormItem label="备注信息：" prop="remark">
              <Input v-model="formData.remark" style="width: 300px" placeholder="请输入备注信息" :maxlength="500" />
            </FormItem>
          </Col>
        </Col>
        <Col span="24" v-if="remarkDisTwo">
          <FormItem label="备注信息：" prop="remark">
            <Input v-model="formData.remark" style="width: 300px" placeholder="请输入备注信息" :maxlength="500" />
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="10" offset="2">
          <FormItem>
            <Button type="primary" @click="handleSubmit('formData')">提交</Button>
            <Button type="ghost" @click="goBack()" style="margin-left: 10px">取消</Button>
          </FormItem>
        </Col>
      </Row>
    </Form>
    <Modal v-model="funcModal" :closable="false" title="按区间收费" width="700" :mask-closable="false">
      <func-list v-if="funcModalShow" @checkFunc="checkFunc" @hideFunc="hideFunc" :selectedItem="this.selectedItem" :sureBtnDisabled=true ref="transEvent">
      </func-list>
      <div slot="footer" class-name="footer-border"></div>
    </Modal>
  </card>
</template>
<script>import funcList from './components/funcList.vue'
export default {
  name: "addFee",
  components: {
    funcList: funcList
  },
  data () {
    return {
      remarkDisOne: false,
      remarkDisTwo: true,
      peizhiVal: true,
      selectedItem: null,
      tableColumns: [],
      tableData: [],
      total: 0,
      pageNo: 1,
      pageSize: 10,
      funcModal: false,
      funcModalShow: false, // 用来更新数据
      feeYuan: '',
      smallFeeDis: false,
      anPenDis: false,
      constantsImg: this.$contants.BaseImageUrl,
      settleTypeAry: [{name: '实时', value: '1'}, {name: '后结', value: '2'}],
      chargeModeAry: [],
      calculateModeAry: [{name: '按笔定额', value: '1'}, {name: '按固定费率', value: '2'}, {name: '按区间收费', value: '3'}],
      userId: null,
      type: null,
      currentPage: 1,
      roleList: [],
      formData: {
        calculateMode: '',
        chargeMode: '',
        fee: 0,
        maxFee: '',
        minFee: '',
        name: '',
        remark: '',
        settleType: '',
        content: ''
      },
      ruleValidate: {
        name: [
          {required: true, trigger: 'blur', message: '请输入手续费模板名称'}
        ],
        settleType: [
          {required: true, trigger: 'change', message: '请选择手续费结算类型'}
        ],
        calculateMode: [
          {required: true, trigger: 'change', message: '请选择计算方式'}
        ],
        chargeMode: [
          {required: true, trigger: 'change', message: '请选择收费方式'}
        ],
        fee: [
          {required: true, trigger: 'blur', message: '请输入手续费！'},
          {pattern: /^\d+(\.{0,1}\d+){0,1}$/, message: '请输入非负数字'}
        ],
        minFee: [
          // {required: true, trigger: 'blur', message: '请输入最小手续费，并且不能大于最大手续费(%)！'},
          {pattern: /^\d+(\.{0,1}\d+){0,1}$/, message: '请输入非负数字'}
          // {type: 'number',
          //   message: '请输入数字格式,并且不能大于最大手续费',
          //   trigger: 'blur',
          //   transform (value) {
          //     return Number(value)
          //   }
          // }
        ],
        maxFee: [
          // {required: true, trigger: 'blur', message: '请输入最大手续费，并且不能小于最小手续费(%)！'},
          {pattern: /^\d+(\.{0,1}\d+){0,1}$/, message: '请输入非负数字'}
          // {type: 'number',
          //   message: '请输入数字格式，并且不能小于最小手续费',
          //   trigger: 'blur',
          //   transform (value) {
          //     return Number(value)
          //   }
          // }
        ]
      },
      menuTableColumns: [],
      menuTableData: [],
      funcTableColumns: [],
      funcTableData: [],
      treeModal: false,
      tree: [{}],
      provinceAry: [],
      cityAry: [],
      countyAry: [],
      disCity: false,
      disCounty: false
      // funcModal: false,
      // funcModalShow: false // 用来更新数据
    }
  },
  methods: {
    init () {
      // this.provinceAry = this.cityList.China.province
      // if (this.organizationId) {
      //   this.getOrganizationDetail()
      // }
    },
    getOrganizationDetail () {
      // let self = this
      // this.$axios.get('organization' + '/' + this.organizationId)
      //   .then(function (response) {
      //     self.formData = response.data
      //     self.funcTableData = response.data.roleList
      //   })
      //   .catch(function (error) {
      //     console.log(error)
      //   })
    },
    settleTypeChange: function (val) {
      this.formData.settleType = val
      if (val === '2') {
        this.chargeModeAry = [{name: '外扣', value: '2'}]
        this.formData.chargeMode = '2'
      } else {
        this.chargeModeAry = [{name: '内扣', value: '1'}, {name: '外扣', value: '2'}]
        this.formData.chargeMode = ''
      }
    },
    chargeModeChange: function (val) {
      this.formData.chargeMode = val
    },
    setPage () {
      this.funcModal = !this.funcModal
      this.funcModalShow = true
    },
    calculateModeChange: function (val) {
      this.formData.fee = ''
      this.formData.minFee = ''
      this.formData.maxFee = ''
      this.formData.content = ''
      this.formData.calculateMode = val
      if (val === '1') {
        this.smallFeeDis = false
        this.anPenDis = true
        this.feeYuan = '手续费(元)：'
        this.peizhiVal = true
        this.remarkDisOne = true
        this.remarkDisTwo = false
      } if (val === '2') {
        this.smallFeeDis = true
        this.anPenDis = true
        this.feeYuan = '手续费(%)：'
        this.peizhiVal = true
        this.remarkDisOne = true
        this.remarkDisTwo = false
      }
      if (val === '3') {
        this.smallFeeDis = false
        this.anPenDis = false
        this.feeYuan = '手续费(元)：'
        this.peizhiVal = false
        this.remarkDisOne = false
        this.remarkDisTwo = true
      }
    },
    feelVailt: function () {
      if (this.formData.calculateMode === '2') {
        if (this.formData.fee > 100) {
          this.$Message.error('费率最大不能超过100')
          this.formData.fee = ''
        }
        if (this.formData.fee.indexOf('.') > 0) {
          if (this.formData.fee.split('.')[1].length > 3) {
            this.$Message.error('请保留三位小数')
            this.formData.fee = ''
            return false
          }
        }
      } else {
        if (this.formData.fee.indexOf('.') > 0) {
          if (this.formData.fee.split('.')[1].length > 2) {
            this.$Message.error('请保留两位小数')
            this.formData.fee = ''
            return false
          }
        }
      }
    },
    minFeeBlure: function () {
      if (this.formData.minFee.indexOf('.') > 0) {
        if (this.formData.minFee.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formData.minFee = ''
          return false
        }
      }
      if (this.formData.maxFee) {
        if (parseFloat(this.formData.minFee) >= parseFloat(this.formData.maxFee)) {
          this.$Message.error('最小手续费不能大于最大手续费率')
        }
      }
    },
    maxFeeBlure: function () {
      if (this.formData.maxFee.indexOf('.') > 0) {
        if (this.formData.maxFee.split('.')[1].length > 2) {
          this.$Message.error('请保留两位小数')
          this.formData.maxFee = ''
          return false
        }
      }
      if (this.formData.minFee) {
        if (parseFloat(this.formData.maxFee) <= parseFloat(this.formData.minFee)) {
          this.$Message.error('最大手续费不能小于最小手续费率')
        }
      }
    },
    handleSubmit (name) {
      let that = this
      if (this.formData.minFee) {
        this.formData.minFee = (this.formData.minFee * 100).toFixed(0).toString()
      }
      if (this.formData.maxFee) {
        this.formData.maxFee = (this.formData.maxFee * 100).toFixed(0).toString()
      }

      if (this.formData.calculateMode === '1') {
        this.formData.maxFee = ''
        this.formData.minFee = ''
        if (this.formData.fee) {
          this.formData.fee = (parseFloat(this.formData.fee * 100).toFixed(0)).toString()
        }
      }
      if (this.formData.calculateMode === '2') {
        this.formData.content = ''
        if (this.formData.fee) {
          this.formData.fee = (parseFloat(this.formData.fee * 1000).toFixed(0)).toString()
        }
        if (this.formData.maxFee && this.formData.minFee) {
          if (parseFloat(this.formData.maxFee) <= parseFloat(this.formData.minFee)) {
            this.formData.maxFee = ''
            this.formData.minFee = ''
            if (this.formData.fee) {
              this.formData.fee = (this.formData.fee / 1000).toString()
            }
            // this.$Message.error('最大手续费不能小于等于最小手续费率')
            return false
          }
        }
      }
      if (this.formData.calculateMode === '3') {
        this.formData.fee = ''
        this.formData.maxFee = ''
        this.formData.minFee = ''
        if (this.formData.fee) {
          this.formData.fee = (parseFloat(this.formData.fee * 100).toFixed(0)).toString()
        }
        if (this.formData.content === '' || this.formData.content === '[]' || this.formData.content === undefined) {
          this.$Message.error('请配置区间价格')
          this.funcModal = !this.funcModal
          this.funcModalShow = true
          return false
        } else {
          let reslut = JSON.parse(this.formData.content)
          reslut.forEach(function (e, i) {
            e.firstSection = e.firstSection * 100
            e.secondSection = e.secondSection * 100
            if (e.type === 'percent') {
              e.priceSection = (e.priceSection * 1000).toFixed(0).toString()
            } else {
              e.priceSection = (e.priceSection * 100).toFixed(0).toString()
            }

          })
          this.formData.content = JSON.stringify(reslut)
        }
      }
      this.$refs[name].validate((valid) => {
        if (valid) {
          this.$axios.post('/feeTemplate', this.formData).then(function (res) {
            that.$Message.success('添加手续费模板成功')
            that.goBack()
          }).catch(function () {
            if (that.formData.content) {
              if (JSON.parse(that.formData.content)) {
                let reslut = JSON.parse(that.formData.content)
                reslut.forEach(function (e, i) {
                  e.firstSection = e.firstSection / 100
                  e.secondSection = e.secondSection / 100
                  e.priceSection = e.priceSection / 100
                })
                that.formData.content = JSON.stringify(reslut)
              }
            }
            if (that.formData.calculateMode === '2') {
              if (that.formData.fee) {
                that.formData.fee = (that.formData.fee / 1000).toString()
              }
            } else {
              if (that.formData.fee) {
                that.formData.fee = (that.formData.fee / 100).toString()
              }
            }
            // if (that.formData.fee) {
            //   that.formData.fee = (that.formData.fee / 100).toString()
            // }
            if (that.formData.minFee) {
              that.formData.minFee = (that.formData.minFee / 100).toString()
            }
            if (that.formData.maxFee) {
              that.formData.maxFee = (that.formData.maxFee / 100).toString()
            }
          })
        } else {
          that.$Message.error('请正确填写信息')
          this.formData.fee = ''
          this.formData.minFee = ''
          this.formData.maxFee = ''
          // if (that.formData.fee) {
          //   that.formData.fee = (that.formData.fee / 100).toString()
          // }
          if (that.formData.calculateMode === '2') {
            if (that.formData.fee) {
              that.formData.fee = (that.formData.fee / 1000).toString()
            }
          } else {
            if (that.formData.fee) {
              that.formData.fee = (that.formData.fee / 100).toString()
            }
          }
          if (that.formData.minFee) {
            that.formData.minFee = (that.formData.minFee / 100).toString()
          }
          if (that.formData.maxFee) {
            that.formData.maxFee = (that.formData.maxFee / 100).toString()
          }
        }
      })
    },
    sectionValAry () {

    },
    hideFunc (sectionValAry) {
      this.formData.content = JSON.stringify(sectionValAry)
      this.funcModalShow = false
      this.funcModal = !this.funcModal
    },
    goBack () {
      this.$util.goBack(this)
    }
  },
  created () {
    // 用这个对象
    this.init()
  },
  mounted () {
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
    },
    nameSize () {
      return this.$contants.pageSet.nameSize
    },
    accountSize () {
      return this.$contants.pageSet.accountSize
    }
  }
}
</script>
