import axios from "axios";

export const proxy={
    methods: {
        tester(d){
            alert(d)
        },
        paging(url){
            const help = []
            const pages = []
            let temp = {}
            axios
                .get(url)
                .then(({data})=>{
                    data.list.forEach(elem => {help.push(elem)})
                    let pager = data.pager
                    let i = pager.pageStart
                    for(; i <= pager.pageEnd;i++){
                        pages.push(i+1)
                    }
                    temp.rowCount = pager.rowCount
                    temp.existPrev = pager.existPrev
                    temp.existNext = pager.existNext
                    temp.nextBlock = pager.nextBlock
                    temp.prevBlock = pager.prevBlock
                    temp.nowPage = pager.nowPage
                })
                .catch(err=>{
                    alert(`통신 실패 ${err}`)
                })

            return {help, pages, temp}
        },
        paging1(url){
            const car = []
            const pages = []
            let temp = {}
            axios
                .get(url)
                .then(({data})=>{
                    data.list.forEach(elem => {car.push(elem)})
                    let pager = data.pager
                    let i = pager.pageStart
                    for(; i <= pager.pageEnd;i++){
                        pages.push(i+1)
                    }
                    temp.rowCount = pager.rowCount
                    temp.existPrev = pager.existPrev
                    temp.existNext = pager.existNext
                    temp.nextBlock = pager.nextBlock
                    temp.prevBlock = pager.prevBlock
                    temp.nowPage = pager.nowPage
                })
                .catch(err=>{
                    alert(`통신 실패 ${err}`)
                })

            return {car, pages, temp}
        }
    }
}