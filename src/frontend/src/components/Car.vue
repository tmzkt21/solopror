<template>
    <div>
        <h3>차목록 : {{pager.rowCount}}</h3>
        <span style="float: right"><input id="searchWord" type="text" style="border: 1px solid black">
    <button @click="retrieve">검 색</button></span>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">사진</th>
                    <th class="text-left">이름</th>
                    <th class="text-left">연식</th>
                    <th class="text-left">연료</th>
                    <th class="text-left">주행</th>
                    <th class="text-left">가격</th>
                    <th class="text-left">지역</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item.name">
                    <td>{{ item.img }}</td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.year }}</td>
                    <td>{{ item.fuel }}</td>
                    <td>{{ item.km }}</td>
                    <td>{{ item.price }}</td>
                    <td>{{ item.span }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
            <div style="margin: 0 auto; width: 500px; height: 100px">
                <span @click="transferPage(pager.prevBlock)" v-if='pager.existPrev'
                      style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">이전</span>
                <span @click="transferPage(i-1)" v-for='i of pages' :key="i"
                      style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">{{i}}</span>
                <span @click="transferPage(pager.nextBlock)" v-if='pager.existNext'
                      style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">다음</span>
            </div>

            <!--<v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>

</template>

<script>
    import {mapState} from "vuex"
    import {proxy} from "./mixins/proxy"

    export default {
        mixins: [proxy],
        created() {
            console.log('페이징 가기 전 : ')
            let json = proxy.methods.paging1(`${this.$store.state.search.context}/car/null/0`)
            this.$store.state.search.list = json.car
            this.$store.state.search.pages = json.pages
            this.$store.state.search.pager = json.temp
            console.log('페이징 다녀온 다음 : ' + json.temp.pageSize)


        },
        computed: {
            ...mapState({
                list: state => state.search.list,
                pages: state => state.search.pages,
                pager: state => state.search.pager
            })
        },
        methods: {
            transferPage(d) {
                proxy.methods.tester(d)
                this.$store.dispatch('search/transferPage',
                    {cate: 'car', searchWord: 'null', pageNumber: d})
            },
            retrieve() {
                let searchWord = document.getElementById('searchWord').value
                if (searchWord === '') searchWord = 'null'
                this.$store.dispatch('search/transferPage', {
                    cate: 'car',
                    searchWord: searchWord,
                    pageNumber: 0
                })
            },
            retrieveOne(carSeq) {
                this.$store.dispatch('search/retrieveOne', {
                    cate: 'car',
                    searchWord: carSeq
                })
            }
        }
    }
</script>