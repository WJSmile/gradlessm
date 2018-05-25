<template>
  <div style="width: 60%;margin: 0 auto 0 auto;padding-top: 20px;text-align: center">
    <Input  v-model="name" placeholder="姓名" style="width: 600px"/>
    <Input  v-model="pwd" placeholder="班级" style="width: 600px;margin-top: 20px"/>
    <div style="margin-top: 20px">
      <Button type="primary" @click="addUser">添加</Button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MyMusic',
  data () {
    return {
      name: '',
      pwd: ''
    }
  },
  methods: {
    addUser: function () {
      console.log(this.name)
      if (this.name !== '' && this.pwd !== '') {
        this.$axios.post('/api/greeting', JSON.stringify({user: this.name, pwd: this.pwd}), {
          headers: {
            'Content-Type': 'application/json;charset=utf-8'
          }
        }).then(res => {
          console.log(res.data)
        }).catch(function (response) {
          console.log(response)
        })
      }
    }
  }
}
</script>

<style scoped>

</style>
