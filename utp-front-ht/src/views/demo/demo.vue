<template>
  <div></div>
</template>

<script>
import cityList from '../../libs/content'
export default {
  name: 'demo',
  data () {},
  methods: {
    init () {
      let aa = cityList.China
      console.log(aa)
    }
  },
  mounted () {
    this.init()
  }
}
</script>

<style scoped>

</style>
