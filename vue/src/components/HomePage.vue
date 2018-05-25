<template>
  <div>
    <Menu mode="horizontal" theme="primary" :active-name="'/'" @on-select="greet" >
      <div class="title">
        <MenuItem v-for="(val,key,index) in titleList" :name="key" :key="index" >
          {{val}}
        </MenuItem>
      </div>
    </Menu>
      <router-view />
  </div>
</template>

<script>
export default {
  name: 'HomePage',
  data () {
    return {
      titleList: {'/': '发现音乐', 'mymusic': '我的音乐', 'friend': '朋友', 'mall': '商城', 'musician': '音乐人', 'client': '下载客户端'}
    }
  },
  methods: {
    greet: function (name) {
      this.$router.push(name)
    }
  }
}
</script>

<style scoped>
  .title {
    width: 65%;
    margin: 0 auto 0 auto;
  }
</style>
