<template>
  <div>
    <Row>
      <Col>
        <Form :label-width="100" ref="form" :model="formDataOld" label-position="right" :inline="true">
          <FormItem :label-width="0">
            <Button type="primary" @click="addSection()" style="margin-right: 10px;">新增区间</Button>
            <Button type="default" @click="clearBtn()">清空</Button>
          </FormItem>
        </Form>
      </Col>
      <Row>
        <Col span="24" offset="" style="margin-bottom: 10px">
          <Row>
            <Col span="9" style="height: 30px; background: #cccccc; color: #000; line-height: 30px; text-indent: 0.5em;">交易金额区间</Col>
            <Col span="7" style="height: 30px; background: #cccccc; color: #000; line-height: 30px;">手续费类型</Col>
            <Col span="8" style="height: 30px; background: #cccccc; color: #000; line-height: 30px;">手续费</Col>
          </Row>
        </Col>
      </Row>
      <Form  :model="formData"  ref="formData" :label-width="120">
        <Row v-for="(item, index) in num" :key="index">
          <Col span="9" style="height: 40px; color: #000; line-height: 40px;">
            <i-input ref="firstInput" size="small" placeholder="请输入区间" :value="0" :disabled="true" @on-blur="changeSectionFirst(index)" :maxlength="10" style="width: 100px"></i-input> --
            <i-input ref="secondInput"  size="small" @on-blur="changeSectionSecond(index)" placeholder="请输入区间" :maxlength="10" style="width: 100px"></i-input>
          </Col>
          <Col span="7" style="height: 40px; color: #000; line-height: 40px; display: block"   >
            <i-select ref="typeSelect" size="small" style="width:80%">
              <i-option v-for="item in typeSelectAry"  :key="item.value" :value="item.value">{{ item.name }}</i-option>
            </i-select>
          </Col>
          <Col span="8" style="height: 40px; color: #000; line-height: 40px;">
            <i-input ref="priceInput" size="small" @on-blur="changePrice(index)" placeholder="请输入区间价格" :maxlength="10" style="width: 100px"></i-input>
          </Col>
        </Row>
      </Form>
    </Row>
    <Row>
      <Col>
        <div class="ivu-modal-footer">
          <Button type="primary" @click="sureSubmit" style="margin-right: 10px;"  id="sureBtnId">确定</Button>
          <Button type="default" @click="backCancel">取消</Button>
        </div>
      </Col>
    </Row>
  </div>
</template>
<script>

export default {
  name: 'funcList',
  props: [
    'selectedItem', 'sureBtnDisabled', 'content'
  ],
  data () {
    return {
      // typePushAry: [],
      typeSelectAry: [{name: '定额', value: 'amount'}, {name: '比例', value: 'percent'}],
      sectionValAry: [],
      num: 1,
      formData: {
        type: 'amount'
      },
      formDataOld: [],
      ruleValidate: [],
      countVal: 0,
      content: this.content
    }
  },
  methods: {
    init () {
      // 设置
      // 查询信息
      if (localStorage.getItem('contentEdit') != null) {
        this.num = JSON.parse(localStorage.getItem('contentEdit')).length
        this.content = JSON.parse(localStorage.getItem('contentEdit'))
      } else {
        if (this.content.length >= 1) {
          this.num = this.content.length
        } else {
          this.num = 1
        }
      }
    },
    getDataNew: function () {
      if (this.num > 1) {
        for (let i = 1; i < this.num; i++) {
          this.$refs.firstInput[i].disabled = true
        }
      }
      let self = this
      if (localStorage.getItem('contentEdit') != null) {
        self.content = JSON.parse(localStorage.getItem('contentEdit'))
        for (let x = 0; x < this.num; x++) {
          self.$refs.firstInput[x].currentValue = self.content[x].firstSection
          self.$refs.secondInput[x].currentValue = self.content[x].secondSection
          self.$refs.priceInput[x].currentValue = self.content[x].priceSection
          let labelTxt = ''
          self.typeSelectAry.forEach(function (e, i) {
            if (self.content[x].type === e.value) {
              labelTxt = e.name
            }
          })
          self.$refs.typeSelect[x].values.push({value: self.content[x].type, label: labelTxt})
        }
      } else {
        for (let x = 0; x < this.num; x++) {
          this.$refs.firstInput[x].currentValue = this.content[x].firstSection
          this.$refs.secondInput[x].currentValue = this.content[x].secondSection
          this.$refs.priceInput[x].currentValue = this.content[x].priceSection
          let labelTxt = ''
          self.typeSelectAry.forEach(function (e, i) {
            if (self.content[x].type === e.value) {
              labelTxt = e.name
            }
          })
          self.$refs.typeSelect[x].values.push({value: self.content[x].type, label: labelTxt})
        }
      }
    },
    addSection: function () {
      for (let i = 0; i < this.num; i++) {
        if (this.$refs.firstInput[i].currentValue === '' || this.$refs.secondInput[i].currentValue === '' || this.$refs.priceInput[i].currentValue === '') {
          this.$Message.error('请填写完整区间数据')
          return false
        }
      }
      this.num += 1
      let self = this
      setTimeout(function () {
        self.$refs.firstInput[self.num - 1].currentValue = self.$refs.secondInput[self.num - 2].currentValue
        self.$refs.firstInput[self.num - 1].disabled = true
      }, 100)
    },
    clearBtn: function () {
      for (let i = 0; i < this.num; i++) {
        this.$refs.firstInput[i].currentValue = ''
        this.$refs.secondInput[i].currentValue = ''
        this.$refs.priceInput[i].currentValue = ''
      }
      this.num = 1
    },
    changeSectionFirst: function (val) {
      let res = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/
      if (!res.test(this.$refs.firstInput[val].currentValue)) {
        this.$Message.error('请输入正数')
        this.$refs.firstInput[val].currentValue = ''
        return false
      } else {
        if (this.$refs.firstInput[val].currentValue.indexOf('.') > 0) {
          if (this.$refs.firstInput[val].currentValue.split('.')[1].length > 2) {
            this.$Message.error('请保留两位小数')
            this.$refs.firstInput[val].currentValue = ''
            return false
          }
        }
        if (parseFloat(this.$refs.secondInput[val].currentValue)) {
          if (parseFloat(this.$refs.secondInput[val].currentValue) <= parseFloat(this.$refs.firstInput[val].currentValue)) {
            this.$Message.error('前面的数字不能大于或等于后面的数字')
            this.$refs.firstInput[val].currentValue = ''
          }
        }
        if (parseFloat(this.$refs.secondInput[val - 1].currentValue)) {
          if (parseFloat(this.$refs.firstInput[val].currentValue) < parseFloat(this.$refs.secondInput[val - 1].currentValue)) {
            this.$Message.error('前面的数字不能大于后面的数字')
            this.$refs.firstInput[val].currentValue = ''
          }
        }
      }
    },
    changeSectionSecond: function (val) {
      let res = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/
      if (!res.test(this.$refs.secondInput[val].currentValue)) {
        this.$Message.error('请输入正数')
        this.$refs.secondInput[val].currentValue = ''
        return false
      } else {
        if (this.$refs.secondInput[val].currentValue.indexOf('.') > 0) {
          if (this.$refs.secondInput[val].currentValue.split('.')[1].length > 2) {
            this.$Message.error('请保留两位小数')
            this.$refs.secondInput[val].currentValue = ''
            return false
          }
        }
        if (parseFloat(this.$refs.secondInput[val].currentValue) <= parseFloat(this.$refs.firstInput[val].currentValue)) {
          this.$Message.error('后面的数字不能小于前面的数字')
          this.$refs.secondInput[val].currentValue = ''
        }
        if (this.num > val + 1) {
          this.$refs.firstInput[val + 1].currentValue = this.$refs.secondInput[val].currentValue
          this.$refs.firstInput[val + 1].disabled = true
          for (let i = val + 1; i < this.num; i++) {
            this.$refs.secondInput[i].currentValue = ''
            this.$refs.firstInput[i + 1].currentValue = ''
            this.$refs.firstInput[i + 1].disabled = true
          }
        }
      }
    },
    changePrice: function (val) {
      let res = /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/
      if (!res.test(this.$refs.priceInput[val].currentValue)) {
        this.$Message.error('请输入正数')
        this.$refs.priceInput[val].currentValue = ''
        return false
      } else {
        if (this.$refs.priceInput[val].currentValue.indexOf('.') > 0) {
          if (this.$refs.typeSelect[val].values[0].value === 'percent') {
            if (this.$refs.priceInput[val].currentValue.split('.')[1].length > 3) {
              this.$Message.error('请保留三位小数')
              this.$refs.priceInput[val].currentValue = ''
              return false
            }
          } else {
            if (this.$refs.priceInput[val].currentValue.split('.')[1].length > 2) {
              this.$Message.error('请保留两位小数')
              this.$refs.priceInput[val].currentValue = ''
              return false
            }
          }
        }
      }
    },
    sureSubmit: function () {
      let self = this
      for (let i = 0; i < this.num; i++) {
        if (this.$refs.firstInput[i].currentValue === '' || this.$refs.secondInput[i].currentValue === '' || this.$refs.priceInput[i].currentValue === '' || self.$refs.typeSelect[i].values[0] === undefined) {
          self.$Message.error('请填写完整区间数据')
          return false
        }

        if (self.$refs.typeSelect[i].values[0].value === 'percent') {
          if (self.$refs.priceInput[i].currentValue > 100) {
            self.$refs.priceInput[i].currentValue = ''
            self.$Message.error('比例不能大于100')
            return false
          }
        }
      }
      for (let j = 0; j < this.num; j++) {
        let dataNew = {'firstSection': self.$refs.firstInput[j].currentValue, 'secondSection': self.$refs.secondInput[j].currentValue, 'priceSection': self.$refs.priceInput[j].currentValue, 'type': self.$refs.typeSelect[j].values[0].value}
        self.sectionValAry.push(dataNew)
      }
      localStorage.setItem('contentEdit', JSON.stringify(self.sectionValAry))
      self.backCancel(self.sectionValAry)
    },
    backCancel (sectionValAryNew) {
      if (Array.isArray(sectionValAryNew)) {
        this.$emit('hideFunc', sectionValAryNew)
      } else {
        this.$emit('hideFunc', this.content)
      }
      // this.$emit('sectionValAry', this.sectionValAry)
    }
  },
  mounted () {
    this.getDataNew()
  },
  created () {
    this.init()
  },
  watch: {
    // updateMyData: function (newValue, oldValue) {
    //   this.tableData = []
    //   this.searchList()
    //   let sureBtn = document.getElementById('sureBtnId')
    //   sureBtn.disabled = true
    // }
  },
  computed: {
    // updateMyData () {
    //   return this.selectedItem.id
    // }
  }
}
</script>
