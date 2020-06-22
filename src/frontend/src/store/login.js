import axios from 'axios'
import router from '@/router';
const state = {
    context : "http://localhost:5000",
    find : false
}
const actions = {
    async login({commit},payload){
        console.log(payload.userId)
        axios.post(`${state.context}/user/login`,payload,{
            authorization: "JWT fefege..",
            Accept: "application/json",
            ContentType : "application/json"})
            .then(({data})=>{
                console.log(data)
                if(data === true){
                    commit("LOGIN",data)
                    alert("로그인성공")
                    router.push('/car')
                } else if (data===false){
                    alert("로그인실패")
                }
            })
            .catch(()=>{
                alert("통신실패")
            })
    }
}
const mutations = {
    LOGIN(state,data){
        alert(data)
    }
}
export default {
    name:"login",
    namespaced : true,
    state,
    actions,
    mutations
}