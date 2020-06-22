<template>
    <v-app id="inspire">
        <v-navigation-drawer

                app
                clipped
        >
            <v-list dense>

                <v-list-item-content>
                    <v-list-item-title>
                        <input class="display-1" type="text" value="전력"/>
                    </v-list-item-title>
                </v-list-item-content>



                <v-list-item-avatar>
                    <img :src="`https://t1.daumcdn.net/news/202002/19/DAILYESPORTS/20200219213414907mxgd.jpg`"
                         alt=""
                         type="button">
                </v-list-item-avatar>
                <router-link to="canna"><input type="button" value="Canna"/></router-link>
                <v-spacer></v-spacer>
                <v-list-item-avatar>
                    <img :src="`https://cgeimage.commutil.kr/phpwas/restmb_allidxmake.php?idx=3&simg=20190609185006055663cf949c6b9123811052.jpg`"
                         alt=""
                         type="button">
                </v-list-item-avatar>
                <router-link to="/cuzz"><input type="button" value="Cuzz"/></router-link>
                <v-spacer></v-spacer>
                <v-list-item-avatar>
                    <img :src="`https://img1.daumcdn.net/thumb/S600x434/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/pnn/ae7f17f2949349f68d70456362becfb3.jpg`"
                         alt=""
                         type="button">
                </v-list-item-avatar>
                <router-link to="/faker"><input type="button" value="Faker"/></router-link>
                <v-spacer></v-spacer>
                <v-list-item-avatar>
                    <img :src="`https://cgeimage.commutil.kr/phpwas/restmb_allidxmake.php?idx=3&simg=2019072522274606468283f60ce7c11045166174.jpg`"
                         alt=""
                         type="button">
                </v-list-item-avatar>
                <router-link to="/teddy"><input type="button" value="Teddy"/></router-link>
                <v-spacer></v-spacer>
                <v-list-item-avatar>
                    <img :src="`https://cgeimage.commutil.kr/phpwas/restmb_allidxmake.php?idx=3&simg=20190629190225005333cf949c6b911045166174.jpg`"
                         alt=""
                         type="button">
                </v-list-item-avatar>
                <router-link to="/effort"><input type="button" value="Effort"/></router-link>
                <v-spacer></v-spacer>


            </v-list>
        </v-navigation-drawer>

        <v-app-bar
                app
                clipped-left
                color="red"
                dense
        >

            <v-icon
                    class="mx-4"
                    large
            >
            </v-icon>
            <v-toolbar-title>
                <router-link to="/"><span class="display-2 white--text" type="button">T1</span></router-link>
            </v-toolbar-title>

            <v-spacer></v-spacer>

            <v-row
                    align="center"
                    style="max-width: 650px"
            >

                <input type="text"
                       :append-icon-cb="() => {}"
                       placeholder="입력란"
                       v-on:keyup.enter="search"
                       v-model="searchWord"
                       single-line
                       append-icon="mdi-magnify"
                       color="white"
                       hide-details>

                <form onsubmit="return false">
                    <input @click="search"
                       onkeyup="onkeyup();"
                       id="google_search"
                       type="button"
                       value="검색"/>
                </form>

            </v-row>
            <router-link to="/login"><input @click="search"
                                            id="login"
                                            type="button"
                                            value="로그인"/></router-link>

            <router-link to="sign"><input @click="search"
                                          type="button"
                                          value="회원가입"/></router-link>
        </v-app-bar>


        <v-main>
            <v-container class="fill-height">
                <v-row
                        justify="center"
                        align="center"
                >
                    <v-col class="shrink">
                        <v-tooltip right>
                        </v-tooltip>
                    </v-col>
                </v-row>
            </v-container>


        </v-main>
        <center><img src="https://images-na.ssl-images-amazon.com/images/I/61azOoJ-UfL._SX425_.jpg" alt=""></center>
<!--        <center><video width="80%" height="80%" src="https://www.youtube.com/embed/4T-pam-MiAI"-->
<!--               poster="//i.ytimg.com/vi/4T-pam-MiAI/maxresdefault.jpg" controls autoplay muted loop></video></center>-->
        <center><iframe width="2000" height="800" src="https://www.youtube.com/embed/4T-pam-MiAI" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></center>

        <h3>검색된 키워드: {{ searchWord }}</h3>
    </v-app>
</template>

<script>
    export default {
        data() {
            return {
                searchWord: ""
            };
        },

        methods: {
            search() {
                this.$store.dispatch("search/find",this.searchWord)
                // this.$store.dispatch("crawling/search",this.searchWord)
            }
        },









    }
</script>
