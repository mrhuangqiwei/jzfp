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
                height: 36px;
                line-height: 36px;
            }
            span:first-child{
                width: 400px;
                border-right: 1px solid #d3d3d3;
            }
            span:last-child{
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
            <li><span>现金支付</span>
               <span><chooseInput :options='cashPay' :getValue='cashPayValue'/></span>
            </li>
            <li><span>个帐支付</span><span></span></li>
            <li><span>统筹支付</span><span></span></li>
            <li><span>农合支付</span><span></span></li>
            <li><span>项目支付</span><span></span></li>
            <li><span>民政补助</span><span></span></li>
        </ul>
    </div>
</template>

<script>
    var cashPayOptions = [{
                            value: '1',
                            label: '医疗机构减免'
                            }, {
                            value: '2',
                            label: '基本医疗保险支付'
                            }, {
                            value: '3',
                            label: '大病医疗保险赔付'
                            }, {
                            value: '4',
                            label: '补充医疗保险赔付'
                            },{
                            value: '5',
                            label: '基本医疗保险倾斜支付'
                            },{
                            value: '6',
                            label: '特殊补充医疗保险赔付'
                            }, {
                            value: '7',
                            label: '民政医疗赔付'
                          }];
    export default {
        data: function () {
            return {
                cashPay:cashPayOptions
            }
        },
        components:{

        },
        methods:{
            cashPayValue(val){
                console.log(cashPayOptions[+val].label);
            }
        },
    }   
</script>