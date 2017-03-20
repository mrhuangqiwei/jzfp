<style lang="scss" scoped>
    #homePage{
        height: 100%;
        background: white;
        display:flex;
        flex-direction: column;
        div.nav{
            line-height: 4rem;
            min-height: 4rem;
            span{
                display:inline-block;
                width: 12rem;
                text-align: center;
                border: 1px solid;
            }
            span:first-child{
                border-right:none;
            }
        }
        div.pageContent{
            flex:1;
        }
    }
</style>

<template>
    <div id='homePage'>
        <div class='nav'>
            <span @click='switchTab("checkCode")'>对码</span>
            <span @click='switchTab("poorPopulation")'>贫困人口管理</span>
        </div>
        <div v-if="activeTab=='checkCode'" class='pageContent'>
            <checkCode />
        </div>
        <div v-else class='pageContent'>
            <poorPopulation />
        </div>
    </div>
</template>

<script>
    import api from './backend/api';
    import checkCode from './checkCode/index';
    import poorPopulation from './poorPopulation/index';
    export default {
        data: function () {
            return {
                activeTab:'checkCode'
            }
        },
        components:{
            checkCode,
            poorPopulation
        },
        methods:{
            switchTab(item){
                this.activeTab = item;
            }
        },
    }   
</script>