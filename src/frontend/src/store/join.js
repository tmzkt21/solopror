import axios from 'axios'
import router from '@/router'
const state = {
    context : "http://localhost:5000",
    join : "",
    idCheck: false
}
const actions = {
    async find({commit},payload){
        if(state.idCheck === true){
            axios.post(`${state.context}/user/join`,payload,{
                authorization: "JWT fefege..",
                Accept: "application/json",
                ContentType : "application/json"})
                .then(({data})=>{
                    commit("JOIN",data)
                    data? router.push('/login') : router.push('/join')
                    alert(data? "회원가입성공":"아이디 중복")
                })
                .catch(()=>{
                    alert('통신실패')
                })
        } else {alert("아이디 중복체크부터 해주세요!")}
    },
    async check({commit},payload){
        axios.get(`${state.context}/user/check/${payload.userId}`)
            .then(({data})=>{
                commit("CHECK",data)
            })
            .catch(()=>{
                alert('통신실패')
            })
    }
}
const mutations = {
    CHECK(state, data){
        state.idCheck = !data
        alert(data? "아이디가 중복입니다.":"회원가입가능!")
    },
    JOIN(state, data){

        state.join = data;
    }

}
export default {
    name:"join",
    namespaced : true,
    state,
    actions,
    mutations
}