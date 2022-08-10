<template>
  <div id="app">
    <el-container style="height: 500px; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <!--动态设定导航栏：menu与router进行绑定-->
        <!--要实现路由跳转，先要在el-menu标签上添加router属性，然后只要在每个el-menu-item标签内的index属性设置一下url即可实现点击el-menu-item实现路由跳转。-->
        <el-menu router :default-openeds="['0']">
          <!--这里的index指的是下标 从0开始计算 -->
          <el-submenu v-for="(item, index) in $router.options.routes" :index="index+''" v-if="item.show" :key="index+''">
            <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
            <!-- <el-menu-item>标签中的index值就是要跳转的router -->
            <!-- <el-menu-item>标签中的class属性用来控制导航栏的选中(route.path：指的是地址栏的path)-->
            <el-menu-item v-for="(item, index2) in item.children" :index="item.path" :class="$route.path==item.path?'is-active':''" :key="index2">{{item.name}}</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <!-- 路由匹配到的组件将显示在这里，相当于一个容器，用来动态渲染你选择的router -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  export default {
  };
</script>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>
