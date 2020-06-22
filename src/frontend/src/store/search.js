import router from "@/router";
import axios from "axios";

const state ={
    context : "http://localhost:5000",
    searchWord : 'null',
    pageNumber: '0',
    list : [],
    pages : [],
    pager: {},
    item: {}

}
const actions ={
    async find({commit},searchWord){
        commit("SEARCHWORD",searchWord)
        switch (searchWord) {
            case '순위': router.push("/rank")
                break
            case '차': router.push("/car")
                break
            case '테이블': router.push("/datatable")
                break

        }
    },
    async transferPage({commit},payload){
        axios.
        get(`${state.context}/${payload.cate}/${payload.searchWord}/${payload.pageNumber}`)
            .then(({data})=>{
                commit("TRANSFER",data)
            })
            .catch()

    },
    async retrieveOne({commit}, payload){
        axios.
        get(`${state.context}/${payload.cate}/${payload.searchWord}`)
            .then(({data})=>{
                commit("DETAIL",data)
                router.push('/movieDetail')
            })
            .catch()
    }
}
const mutations ={
    DETAIL(state, data){
        state.item = data
    },
    SEARCHWORD(state, data){
        state.searchWord = data
    },
    TRANSFER(state, data){
        state.pager = data.pager
        state.list = data.list
    },

}




export default {
    name:"search",
    namespaced: true,
    state,
    actions,
    mutations
}