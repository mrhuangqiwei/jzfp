<style lang="scss" scoped>
    #homePage{
        height: 100%;
        background: white;
        div.el-tabs{
            height:100%;
            div.el-tabs__content{
                height: calc(100% - 57px);
            }
            div.el-tab-pane{
                height: 100%;
            }
        }
    }
</style>

<template>
    <div id='homePage'>
    <el-tabs v-model="activeTab" type="card" @tab-click="handleClick">
        <el-tab-pane label="医疗费用" name="first">
            <medicalExpense />
        </el-tab-pane>
        <el-tab-pane label="减免费用" name="second">
            <jianmianFee />
        </el-tab-pane>
        <el-tab-pane label="补助费用" name="third">补助费用</el-tab-pane>
    </el-tabs>
    </div>
</template>

<script>
    import api from '../backend/api';
    import medicalExpense from './medicalExpense';
    import jianmianFee from './jianmianFee'
    export default {
        data: function () {
            return {
               activeTab: 'first'
            }
        },
        components:{
            medicalExpense,
            jianmianFee
        },
        methods:{
          handleClick(){

          }
        },
    }   
</script>