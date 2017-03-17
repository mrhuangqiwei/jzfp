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
            <li v-for="zflx in payList">
                <span v-text="zflx.zflxmc"></span>
                <span><chooseInput :options='zflx.sub' :getValue='cashPayValue'/></span>
            </li>
        </ul>
    </div>
</template>

<script>
    import api from '../backend/api';
    export default {
        data: function () {
            return {
                payList: []
            }
        },
        components: {},
        mounted() {
            api.medicialFee().then((data) => {
                let dirtyData = JSON.parse(data);
                let zflxBeans = dirtyData.zflxBeans;
                let ylfydmBeans = dirtyData.ylfydmBeans;
                for (let i = 0; i < zflxBeans.length; i++) {
                    zflxBeans[i].sub = [];
                    for (let j = 0; j < ylfydmBeans.length; j++) {
                        if(ylfydmBeans[j].zflxbm === zflxBeans[i].zflxbm) {
                            zflxBeans[i].sub.push(ylfydmBeans[j])
                        }
                    }
                }
                this.payList = zflxBeans;
            });
        },
        methods: {
            cashPayValue(val){
                console.log(val);
            }
        },
    }
</script>