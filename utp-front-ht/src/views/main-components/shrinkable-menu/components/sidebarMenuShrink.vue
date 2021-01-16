<style>
  .icon-change{
    width: 70px;
    margin-left: -5px;
    padding:10px 0;
    color:rgba(255,255,255,.7)!important;
  }
  .icon-change:hover{
    color:#ffffff!important;
  }
</style>
<template>
  <div>
    <template v-for="(item, index) in menuList">
      <div style="text-align: center" :key="index">
        <Dropdown transfer placement="right-start" :key="index"
                  @on-click="changeMenu">
          <div class="icon-change">
            <svg-icon :size="20" :type="item.icon"></svg-icon>
          </div>
          <DropdownMenu style="width: 200px" slot="list">
            <template v-for="(child, i) in item.children">
              <DropdownItem :name="child.name" :key="i">
                <svg-icon :type="child.icon"></svg-icon>
                <span style="padding-left:10px">{{ itemTitle(child) }}</span></DropdownItem>
            </template>
          </DropdownMenu>
        </Dropdown>
      </div>
    </template>
  </div>
</template>

<script>
export default {
  name: 'sidebarMenuShrink',
  props: {
    menuList: {
      type: Array
    },
    iconColor: {
      type: String,
      default: 'white'
    },
    menuTheme: {
      type: String,
      default: 'dark'
    }
  },
  methods: {
    changeMenu (active) {
      this.$emit('on-change', active)
    },
    itemTitle (item) {
      if (typeof item.title === 'object') {
        return this.$t(item.title.i18n)
      } else {
        return item.title
      }
    }
  }
}
</script>
