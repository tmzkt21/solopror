import axios from 'axios';
const state = {
    context : "http://localhost:5000",
    list : []
}
const actions = {
    async  all({commit}){
        axios.get(`${state.context}/cass/list`)
            .then(({data})=>{
                alert("액션 성공 자바데이터")
                commit("LIST",data)
            })
            .catch((e)=>{
                alert("자바연결실패")
                console.log(e)
            })
    },

}
// const actions = {
//     async list({commit}){
//         axios.get(`${state.context}/car/list`)
//             .then(({data})=>{
//                 commit("LIST",data)
//             })
//             .catch((e)=>{
//                 console.log(e)
//             })
//     }
// }
const mutations = {
    LIST(state,data){
        state.list = data
        data.forEach(item => {
            state.list.push({
                img : item.img,
                name : item.name,
                year : item.year,
                fuel : item.fuel,
                km : item.km,
                price : item.price,
                span : item.span
            })
        })
    }
}

export default {
    name:"car",
    namespaced : true,
    state,
    actions,
    mutations
}