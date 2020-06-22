import Vue from 'vue'
import Vuex from 'vuex'
import search from "./search"
import cars from "./cars";
import join from "./join";
import login from "./login";


Vue.use(Vuex)

export const store = new Vuex.Store({
  modules : {
      search,cars,join,login
  }
})
