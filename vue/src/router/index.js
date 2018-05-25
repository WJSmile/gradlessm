import Vue from 'vue'
import Router from 'vue-router'
import HomePage from '@/components/HomePage'

import MyMusic from '@/components/page/MyMusic'
import FindMusic from '@/components/page/FindMusic'
import Friend from '@/components/page/Friend'
import Mall from '@/components/page/Mall'
import Musician from '@/components/page/Musician'
import Client from '@/components/page/Client'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import axios from 'axios'
Vue.prototype.$axios = axios

Vue.use(iView)
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: HomePage,
      children: [{
        path: '',
        name: 'HomePage',
        component: MyMusic
      }, {
        path: 'mymusic',
        name: 'FindMusic',
        component: FindMusic
      }, {
        path: 'friend',
        name: 'Friend',
        component: Friend
      }, {
        path: 'mall',
        name: 'Mall',
        component: Mall
      }, {
        path: 'musician',
        name: 'Musician',
        component: Musician
      }, {
        path: 'client',
        name: 'Client',
        component: Client
      }
      ]
    }
  ]
})
