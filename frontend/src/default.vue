<style lang="scss" scrope>
    @import './css/main';
    #default{
        height: 100%;
    }
</style>

<template>
    <div id='default'>
        <router-view></router-view>
    </div>
</template>
<script>
    import homePage from './homePage';
    export default {
         data(){
             return{
                 selected:'homePage',
             }
         },
         components:{
             homePage
         }
    }
</script>
