<template>
   <div style="width: 60%;margin: 0 auto 0 auto">
     <Table :columns="columns" :data="data" ></Table>
     <Modal
       v-model="modal1"
       title="提示"
       @on-ok="ok">
       <p>你确定删除这条数据吗</p>
     </Modal>
     <Modal
       v-model="modal2"
       title="提示"
       @on-ok="update">
       <Input  v-model="updateData.BlogName" placeholder="姓名" style="width: 400px"/>
       <Input  v-model="updateData.BlogContest" placeholder="班级" style="width: 400px;margin-top: 20px"/>
     </Modal>
   </div>
</template>

<script>
export default {
  name: 'FindMusic',
  data () {
    return {
      columns: [
        {
          title: 'Id',
          key: 'id'
        },
        {
          title: 'Name',
          key: 'BlogName'
        },
        {
          title: 'Class',
          key: 'BlogContest'
        }, {
          title: 'Action',
          key: 'action',
          width: 150,
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.modify(params.index)
                  }
                }
              }, '修改'),
              h('Button', {
                props: {
                  type: 'error',
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.getItem(params.index)
                  }
                }
              }, '删除')
            ])
          }
        }
      ],
      data: [
      ],
      modal1: false,
      itemData: 0,
      modal2: false,
      updateData: {
        id: 0,
        BlogName: '',
        BlogContest: ''
      }
    }
  },
  methods: {
    getUser: function () {
      this.$axios.post('/api/getblog').then(res => {
        this.data = res.data
      }).catch(function (response) {
        console.log(response)
      })
    },
    getItem: function (index) {
      this.modal1 = true
      this.itemData = this.data[index].id
    },
    ok: function () {
      this.$axios.post('/api/deleteblog', JSON.stringify({id: this.itemData}), {
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        }
      }).then(res => {
        console.log(res.data)
        this.getUser()
      }).catch(function (response) {
        console.log(response)
      })
    },
    modify: function (index) {
      this.modal2 = true
      this.updateData.id = this.data[index].id
      this.updateData.BlogName = this.data[index].BlogName
      this.updateData.BlogContest = this.data[index].BlogContest
    },
    update: function () {
      this.$axios.post('/api/updateblog', JSON.stringify(this.updateData), {
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        }
      }).then(res => {
        console.log(res.data)
        this.getUser()
      }).catch(function (response) {
        console.log(response)
      })
    }
  },
  mounted: function () {
    this.getUser()
  }
}
</script>

<style scoped>

</style>
