import Vue from 'vue'
import VueRouter from 'vue-router'
import BookManage from '../views/BookManage.vue'  // 后缀vue可以省略
import BookAdd from '../views/BookAdd.vue'
import BookUpdate from '../views/BookUpdate.vue'
import PageThree from '../views/PageThree.vue'
import PageFour from '../views/PageFour.vue'
import Index from '../views/Index.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '图书管理',
    component: Index,
    show: true,
    redirect: '/BookManage',
    children: [ // 子页面
      {
        path: '/BookManage',
        name: '查询图书',
        component: BookManage
      },
      {
        path: '/BookAdd',
        name: '添加图书',
        component: BookAdd
      }
    ]
  },
  {
    path:'/BookUpdate',
    component:BookUpdate,
    show:false
  },
  {
    path: '/navigation',
    name: '导航2',
    show: true,
    component: Index,
    children: [ // 子页面
      {
        path: '/PageThree',
        name: '导航2-页面1',
        component: PageThree
      },
      {
        path: '/PageFour',
        name: '导航2-页面2',
        component: PageFour
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
