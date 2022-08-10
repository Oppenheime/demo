<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-alert
      title="成功提示的文案"
      type="success"
      show-icon>
    </el-alert>
    <el-form-item label="图书编号" prop="id">
      <el-input v-model="ruleForm.id" readOnly></el-input>
    </el-form-item>
    <el-form-item label="图书名称" prop="name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="作者" prop="author">
      <el-input v-model="ruleForm.author"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  import axios from 'axios'
  export default {
    data() {
      return {
        ruleForm: {
          id: '1',
          name: '1212',
          author: '23323'
        },
        rules: {
          name: [
            {required: true, message: '请输入活动名称', trigger: 'blur'}, // trigger：触发事件  blur失去焦点
            {min: 1, max: 15, message: '长度在 1 到 15 个字符', trigger: 'blur'}
          ],
          author: [
            {required: true, message: '请选择活动区域', trigger: 'blur'}
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        const _this = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(_this.ruleForm)
            // alert('校验通过');
            axios.put('http://localhost:3000/vue-master/book/update', this.ruleForm).then(function (resp) {
              console.log(resp)
              if (resp.data === 'success') {
                // alert('添加成功');
                // _this.$message('添加成功');  // 提示一条信息
                // _this.$router.push('/BookManage') // 添加成功后跳转到BookManage页面
                _this.$alert('《' + _this.ruleForm.name + '》修改成功！', '消息', {
                  confirmButtonText: '确定',
                  callback: action => {
                    _this.$router.push('/BookManage')
                  }
                });
              }
            })
          } else {
            console.log('校验未通过');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
    created() {
      // 拿到edit传过来的id参数
      // alert(this.$route.query.id)
      const _this = this
      // this.$route.query.id 选参数用$route这个
      // this.$router.push 跳转用$router这个
      axios.get('http://localhost:3000/vue-master/book/findById/'+this.$route.query.id).then(function(resp){
        _this.ruleForm = resp.data
      })
    }
  }
</script>
