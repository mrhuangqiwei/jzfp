<style lang="scss">
    #poorPopulation{
        height: 100%;
        background: white;
        display:flex;
        flex-direction: column;

        div.el-tab-pane,
        div.el-tabs{
            height:100%;
        }
        div.el-tabs__content{
            height: calc(100% - 60px);
        }
    }
</style>

<template>
    <div id='poorPopulation'>
        <el-tabs v-model="activeTab" type="card" @tab-click="handleClick">
            <el-tab-pane label="贫困人口识别(门诊)" name="first">
                <recognizePoor :recStyle='recType'/>
            </el-tab-pane>
            <el-tab-pane label="就诊信息上传(门诊)" name="second">
               <upLoad :recStyle='recType'/>
            </el-tab-pane>
            <el-tab-pane label="贫困人口识别(住院)" name="third">
                <recognizePoor :recStyle='recType'/>
            </el-tab-pane>
             <el-tab-pane label="就诊信息上传(住院)" name="forth">
                <upLoad :recStyle='recType'/>
            </el-tab-pane>
             <el-tab-pane label="上传信息" name="fifth">
                
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    import api from '../backend/api';
    import recognizePoor from './recognizePoor';
    import upLoad from './upLoad';

    export default {
        data: function () {
            return {
               activeTab: 'first',
               recType:'clinic'
            }
        },
        components:{
            recognizePoor,
            upLoad
        },
        methods:{
            handleClick(e){
                switch(this.activeTab){
                    case 'first':
                    case 'second':
                        this.recType = 'clinic';
                        break;
                    case 'third':
                    case 'forth':
                        this.recType = 'hospitalized';
                        break;
                    case 'fifth':
                        break;
                }
            }
        },
    }   
</script>