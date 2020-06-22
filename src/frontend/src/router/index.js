import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../components/Home"
import List from "../components/List"
import Effort from "../components/Effort";
import Teddy from "../components/Teddy";
import Faker from "../components/Faker";
import Canna from "../components/Canna";
import Cuzz from "../components/Cuzz";
import Login from "../components/Login";
import Sign from "../components/Join";
import Rank from "../components/Rank";
import Car from "../components/Car";
import Datatable from "../components/Datatable";

Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    { path: "/", component: Home },
    { path: "/list", component: List },
    { path: "/effort", component: Effort},
    { path: "/teddy", component: Teddy},
    { path: "/faker", component: Faker},
    { path: "/canna", component: Canna},
    { path: "/cuzz", component: Cuzz},
    { path: "/login", component: Login},
    { path: "/sign", component: Sign},
    { path: "/rank", component: Rank},
    { path: "/car", component: Car},
    { path: "/datatable", component: Datatable},
  ]
});
