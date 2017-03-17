<style lang="scss" scoped>
    #medicalExpense {
        height: 100%;
        background: white;

    li {
        border-top: 1px solid #d3d3d3;
        border-bottom: 1px solid #d3d3d3;

    span {
        padding-left: 50px;
        display: inline-block;
        box-sizing: border-box;
        height: 36px;
        line-height: 36px;
    }

    span:first-child {
        width: 400px;
        border-right: 1px solid #d3d3d3;
    }

    span:last-child {
        width: calc(100% - 500px);
        vertical-align: bottom;
    }

    }
    }
</style>

<template>
    <div id='medicalExpense'>
        <ul>
            <li><span>支付类型名称</span><span>医疗费用名称</span></li>
            <li v-for="zflx in listData.zflxBeans">
                <span v-text="zflx.zflxmc"></span>
                <span><chooseInput :options='listData.ylfyxmBeans' :getValue='cashPayValue' :textField='textField'/></span>
            </li>
        </ul>
    </div>
</template>

<script>
    import api from '../backend/api';
    export default {
        data: function () {
            return {
                listData: {},
                textField: 'ylfyxmmc'
            }
        },
        components: {},
        mounted() {
            api.medicialFee().then((data) => {
                this.listData = JSON.parse(data);
            });
        },
        methods: {
            cashPayValue(val){
                console.log(val);
            }
        },
    }
</script>