<style lang="scss" scoped>
    #jianmianFee {
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
    <div id='jianmianFee'>
        <ul>
            <li><span>支付类型名称</span><span>医疗费用名称</span></li>
            <li v-for="mxfybm in mxfybmBeans">
                <span v-text="mxfybm.mc"></span>
                <span><chooseInput :options='listData.jmfyxmbmBeans' :selected='mxfybm.selected' :getValue='cashPayValue' :textField="textField"/></span>
            </li>
        </ul>
        <el-button-group>
            <el-button type="primary" icon="arrow-left" v-on:click="loadPage(-1)">上一页</el-button>
            <div style="float: left"><span v-text="curPage+1"></span>/<span v-text="totalPage"></span></div>
            <el-button type="primary" v-on:click="loadPage(1)">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
        </el-button-group>
    </div>
</template>

<script>
    import api from '../backend/api';
    const PAGE_SIZE = 15;
    export default {
        data: function () {
            return {
                listData: {},
                mxfybmBeans: [],
                textField:'jmfymc',
                curPage: 0,
                totalPage:0
            }
        },
        components: {},
        mounted() {
            api.jianmianFee().then((data) => {
                this.listData = JSON.parse(data);
                this.totalPage = Math.ceil(this.listData.mxfybmBeans.length / PAGE_SIZE);
                this.loadPage()
            });
        },
        methods: {
            loadPage(shift=0) {
                if(this.curPage + shift < 0 || this.curPage + shift > this.totalPage){
                    return;
                }
                this.curPage += shift;
                this.mxfybmBeans = this.listData.mxfybmBeans.slice(this.curPage * PAGE_SIZE, (this.curPage + 1)*PAGE_SIZE);
                for(var i=0;i<this.mxfybmBeans.length;i++) {
                    this.mxfybmBeans[i].selected = ' ';
                    for(var j=0; j< this.listData.jmfycxBeans.length;j++) {
                        if(this.listData.jmfycxBeans[j].fyxlbm == this.mxfybmBeans[i].bm){
                            this.mxfybmBeans[i].selected = this.listData.jmfycxBeans[j].jmfymc;
                        }
                    }
                }
            },
            cashPayValue(val){
                console.log(val);
            }
        },
    }
</script>