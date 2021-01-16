<template>
  <div style="display: inline-block" @click="handleClick">
    <svg :class="svgClass" aria-hidden="true" :style="styles">
      <use :xlink:href="iconName"></use>
    </svg>
  </div>
</template>

<script>
export default {
  name: 'svg-icon',
  props: {
    size: [Number, String],
    type: {
      type: String,
      required: true
    },
    color: String,
    className: {
      type: String
    }
  },
  computed: {
    iconName () {
      return `#icon-${this.type}`
    },
    svgClass () {
      if (this.className) {
        return 'svg-icon ' + this.className
      } else {
        return 'svg-icon'
      }
    },
    styles () {
      let style = {}
      style['display'] = 'inline-block'
      style['pointer-events'] = 'none'
      if (this.size) {
        style['font-size'] = `${this.size}px`
      }
      if (this.color) {
        style.color = this.color
      }
      return style
    }
  },
  methods: {
    handleClick (event) {
      this.$emit('click', event)
    }
  }
}
</script>

<style scoped>
  .svg-icon {
    width: 1em;
    height: 1em;
    vertical-align: -0.15em;
    fill: currentColor;
    overflow: hidden;
  }
</style>
