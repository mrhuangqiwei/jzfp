<style lang="scss" scoped>
    #poorPopulation{
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
    <div id='poorPopulation'>
        <el-tabs v-model="activeTab" type="card" @tab-click="handleClick">
            <el-tab-pane label="贫困人口识别(门诊)" name="first">
                贫困人口识别
            </el-tab-pane>
            <el-tab-pane label="就诊信息上传(门诊)" name="second">
                就诊信息上传
            </el-tab-pane>
            <el-tab-pane label="贫困人口识别(住院)" name="third">
                贫困人口识别
            </el-tab-pane>
             <el-tab-pane label="就诊信息上传(住院)" name="forth">
                就诊信息上传
            </el-tab-pane>
             <el-tab-pane label="上传信息" name="fifth">
                上传信息
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    import api from '../backend/api';
    
    export default {
        data: function () {
            return {
               activeTab: 'first',
            }
        },
        components:{
        },
        methods:{
          handleClick(){

          }
        },
    }   
</script>