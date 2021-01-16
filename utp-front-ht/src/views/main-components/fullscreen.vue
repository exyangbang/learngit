<template>
  <div @click="handleChange" v-if="showFullScreenBtn" class="full-screen-btn-con">
    <Tooltip :content="value ? '退出全屏' : '全屏'" placement="bottom">
      <svg-icon :type="value ? 'out-full-screen' : 'full-screen'" :size="16"></svg-icon>
    </Tooltip>
  </div>
</template>

<script>
export default {
  name: 'fullScreen',
  props: {
    value: {
      type: Boolean,
      default: false
    }
  },
  computed: {
    showFullScreenBtn () {
      return window.navigator.userAgent.indexOf('MSIE') < 0
    }
  },
  methods: {
    handleFullscreen () {
      let main = document.body
      if (this.value) {
        if (document.exitFullscreen) {
          document.exitFullscreen()
        } else if (document.mozCancelFullScreen) {
          document.mozCancelFullScreen()
        } else if (document.webkitCancelFullScreen) {
          document.webkitCancelFullScreen()
        } else if (document.msExitFullscreen) {
          document.msExitFullscreen()
        }
      } else {
        if (main.requestFullscreen) {
          main.requestFullscreen()
        } else if (main.mozRequestFullScreen) {
          main.mozRequestFullScreen()
        } else if (main.webkitRequestFullScreen) {
          main.webkitRequestFullScreen()
        } else if (main.msRequestFullscreen) {
          main.msRequestFullscreen()
        }
      }
    },
    handleChange () {
      this.handleFullscreen()
    }
  },
  created () {
    let self = this
    let isFullscreen = document.fullscreenElement || document.mozFullScreenElement || document.webkitFullscreenElement || document.fullScreen || document.mozFullScreen || document.webkitIsFullScreen
    isFullscreen = !!isFullscreen
    document.addEventListener('fullscreenchange', () => {
      this.$emit('input', !self.value)
      this.$emit('on-change', !self.value)
    })
    document.addEventListener('mozfullscreenchange', () => {
      this.$emit('input', !self.value)
      this.$emit('on-change', !self.value)
    })
    document.addEventListener('webkitfullscreenchange', () => {
      this.$emit('input', !self.value)
      this.$emit('on-change', !self.value)
    })
    document.addEventListener('msfullscreenchange', () => {
      this.$emit('input', !self.value)
      this.$emit('on-change', !self.value)
    })
    document.addEventListener('MSFullscreenChange', () => {
      this.$emit('input', !self.value)
      this.$emit('on-change', !self.value)
    })
    this.$emit('input', isFullscreen)
  }
}
</script>
