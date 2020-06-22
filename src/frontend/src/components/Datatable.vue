<template>
    <v-container>
        <a> 자동차 목록 : {{ count }}</a>
        <v-card>
            <v-card-title>
                <v-spacer/>
                <v-text-field
                        v-model="search"
                        append-icon="mdi-magnify"
                        label="Search"
                        single-line
                        hide-details
                ></v-text-field>
            </v-card-title>

            <v-data-table
                    :headers="headers"
                    :items="list"
                    :search="search">
                <template v-slot:item.img="{item}">
                    <img :src=item.img width="50" height="50"/>
                </template>

            </v-data-table>
        </v-card>
    </v-container>
</template>

<script>
    import {mapState} from'vuex'
    export default {
        data(){
            return {
                OK: true,
                search: '',
                headers: [
                    {
                        text: 'img',
                        value: 'img'
                    },
                    {
                        text: 'name',
                        value: 'name'
                    },
                    {
                        text: 'year',
                        value: 'year'
                    },
                    {
                        text: 'fuel',
                        value: 'fuel'
                    },
                    {
                        text: 'km',
                        value: 'km'
                    },
                    {
                        text: 'price',
                        value: 'price'
                    },
                    {
                        text: 'span',
                        value: 'span'
                    },
                ]
            }
        },
        computed :{
            ...mapState ({
                all : state => state.car.all
            })
        },
        // mounted() {
        //     this.$store.dispatch('car/list')
        // },
        created() {
            this.$store.dispatch('cars/all')
        }
    }
</script>

<style scoped>
</style>