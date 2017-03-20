<style lang="scss">
    @import './css/main';
   
    $boderGray: #bfcbd9;
    $fontBlack: #000000;

    #app{
        font-size:1.6rem;
        color: #333333;
        div.showView{
            height: calc(100% - 4rem);
            overflow-x: hidden;
        }
    }
 
</style>

<template>
    <div id='app'>
      <router-view ></router-view>      
    </div>
</template>

<script>
    import api from './backend/api';
    export default {
         data(){
             return{
             }
         },
         methods:{
             
         },
         components:{

         },
         created(){
         
         },
         destroy(){
         },
         mounted(){
          
         }
    }
</script>
