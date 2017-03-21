<style lang="scss" scoped>
    #medicalExpense{
        height: 100%;
        background: white;
        li{
            border-top:    1px solid #d3d3d3;
            border-bottom: 1px solid #d3d3d3;
            span{
                padding-left: 50px;
                display: inline-block;
                box-sizing: border-box;
            }
            span:first-child{
                width: 400px;
                border-right: 1px solid #d3d3d3;
            }
            span:last-child{
                width: calc(100% - 400px);
            }
        }
    }
</style>

<template>
    <div>
        <el-select v-model="value" placeholder="请选择">
            <el-option
            v-for="item in options"
            :label="item[textField]?item[textField]:' '"
            :value="item">
            </el-option>
        </el-select>
    </div>
</template>

<script>

    export default {
        props:['options','selected','getValue','textField'],
        data: function () {
            return {
                value: this.selected
            }
        },
        components:{

        },
        methods:{
        
        },
        watch:{
            value:function(val,oldVal){
                if(typeof this.getValue == 'function'){
                    this.getValue(val);
                }
            }
        },
        mounted(){

        }
    }   
</script>