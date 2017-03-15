<style lang="scss">
    @import './css/main';
   
    $boderGray: #dcd8d8;
    $fontBlack: #000000;

    #app{
        font-size:1.6rem;
        color: #333333;
        div.showView{
            height: calc(100% - 4rem);
            overflow-x: hidden;
        }

        div.nav{
            background: white;
            color: #000000;
            width: 100%;
            display: flex;
            position: relative;
            bottom: 0;
            height: 4rem;
            border-top: 1px solid $boderGray;
            box-sizing: border-box;
            .homePageLink,
            .askOnlineLink{
                border-right:1px solid $boderGray; 
            }
            a{
                flex: 1;
                text-align: center;
                line-height: 4rem;
                font-size: 1.9rem;
                color:#000000;
            }
            a:focus,a:visited,a:hover,a:active{
                color:#000000;
            }
        }
    }
    button{
        font-size: 1.7rem;
        margin: 1rem auto;
        /*height: 3rem;*/
        width: 24rem;
        display:block;
        border-radius: 4px;
    }
    button.GOBACK{
        background: #58b5af;
        color: white;
        height: 3rem;
    }
    .darkGreen{
        color:#31B6AA;
    }
    .red{
        color: #ff3c23;
    }
    .gold{
        color: #F49245 !important;
    }
    .darkBlue{
        /*color: #295286;*/
        color: #14387d;
        font-weight: 500;
    }
    .fontGray{
        color:#A3A3A3;
    }
    i{
        font-style: normal;
    }
    .TITLE{
        color:#336666;
        height: 5rem;
        line-height: 5rem;
        background: white;
        text-align: center;
        font-size:2.6rem;
        border-top-right-radius: 4px;
        border-top-left-radius: 4px;
        border-bottom: 1px solid black;
    }
    .height100{
        height: 100%;
    }
    input{
        font-size: 1.6rem;
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
