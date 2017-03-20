<style lang="scss" scoped>
    #homePage{
        height: 100%;
        background: white;
 
        div.header{
            line-height: 50px;
            margin-bottom: 10px;
            height:50px;
            span{
                display:inline-block;
                width: 12rem;
                text-align: center;
                border: 1px solid;
            }
        }
        div.pageContent{
            height: calc(100% - 60px);
        }
    }
</style>

<template>
    <div id='homePage'>
        <div class='header'>
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