<template>
  <div>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column
        fixed
        prop="id"
        label="编号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="name"
        label="书名"
        width="520">
      </el-table-column>
      <el-table-column
        prop="author"
        label="作者"
        width="120">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="5"
      :total=total
      @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    methods: {
      edit(row) {
        this.$router.push({
          path: '/BookUpdate',
          query:{ // 这里写要传的参数
            id: row.id
          }
        })
        // row.id
        // console.log(row)
      },
      deleteBook(row) {
        const _this = this
        axios.delete('http://localhost:3000/vue-master/book/delete/'+row.id).then(function(resp){
          _this.$alert('《'+row.name+'》删除成功！', '消息', {
            confirmButtonText: '确定',
            callback: action => {
              window.location.reload() // 动态刷新
            }
          })
        })
      },
      page(curentPage) {
        // alert(curentPage)
        const _this = this
        axios.get('http://localhost:3000/vue-master/book/findAll?page=' + curentPage + '&size=5').then(function (resp) {
          console.log(resp)
          _this.tableData = resp.data
          _this.total = resp.data.total
        })
      }
    },
    created() {
      const _this = this
      axios.get('http://localhost:3000/vue-master/book/findAll?page=' + 1 + '&size=5').then(function (resp) {
        console.log(resp)
        _this.tableData = resp.data
        _this.total = resp.data.total
      })
    },
    data() {
      return {
        tableData:null,
        total:null
      }
    }
  }
</script>
