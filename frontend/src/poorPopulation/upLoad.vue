<style lang="scss">
    #upload{
        height: 100%;
        background: white;
        display:flex;
        overflow-y: auto;
        $boderGray : #bfcbd9;
        div{
            box-sizing: border-box;
        }
        div.el-tab-pane{
            height:100%;
        }
        div.right{
            flex:1;
            min-width:1000px;
            div.basicInfo,div.fourHelp,
            div.twoProtect,div.tenFree{
                border:1px solid $boderGray;
                padding:15px;
                margin-right:15px;
                margin-bottom:15px;
            }
            div.fourHelp{
                margin-bottom:0;
            }
        }
        div.left{
            width: 450px;
            min-width:450px;
            padding: 0 30px;
            box-sizing: content-box;
            div.chooseDate{
                height: 300px;
                border:1px solid $boderGray;
                padding: 20px 0;
                padding-left: 30px;
                p{
                    margin:10px;
                }
            }
            div.peopleList{
                height: 538px;
                border:1px solid $boderGray;
                overflow-x:auto;

                div.el-table{
                    height:100%;
                    div.hidden-columns{
                        height:100%;
                    }

                    div.el-table__body-wrapper{
                        height:calc(100% - 41px)
                    }
                }

                .el-table .cell, .el-table th>div {
                    padding:0 10px;
                }
            }
            div.btnGroup{
                margin-top:30px;
                span.btn{
                    width: 80px;
                    border: 1px solid $boderGray;
                    display: inline-block;
                    border-radius: 4px;
                    text-align:center;
                    margin-right: 15px;
                }
            }
        }
        ul li{
            div{
                display:inline-block;
                width:49%;
                vertical-align: top;
                span{
                    display:inline-block;
                    input{
                        height: 23px;
                        width: 250px;
                        text-indent: 10px;
                    }
                }
                span:first-child{
                   width:200px;
                }
                span:last-child{
                    border:1px solid $boderGray;
                    width:250px;
                }
            }
        }
    }
</style>

<template>
    <div id='upload'>
        <div class='left'>
            <div class='chooseDate'>
                <p>统计日期</p>
                <el-date-picker ref='inputStartDate' v-model="startDate" align="right" type="date" placeholder="选择开始日期"></el-date-picker>
                <el-time-picker ref='inputStartTime' v-model="startTime"  placeholder="任意时间点"></el-time-picker>
                <p>至</p>
                <el-date-picker ref='inputEndDate' v-model="endDate" align="right" type="date" placeholder="选择结束日期"></el-date-picker>
                <el-time-picker ref='inputEndTime' v-model="endTime"  placeholder="任意时间点"></el-time-picker>
                <div class='btnGroup'>
                    <span class='btn' @click='uploadSingle'>上传</span>
                    <span class='btn' @click='searchInfo'>查找</span>
                </div>
            </div>
            <div class='peopleList'>
                <el-table
                    :data="tableData"
                    stripe
                    style="width: 100%">
                    <el-table-column prop="brid" label="患者ID"></el-table-column>
                    <el-table-column prop="brxm" label="患者姓名"></el-table-column>
                    <el-table-column prop="brxb" label="性别"></el-table-column>
                    <el-table-column prop="brnl" label="年龄"></el-table-column>
                    <el-table-column prop="jzfpbz" label="贫困识别"></el-table-column>
                    <el-table-column prop="sfzh" label="身份证号"></el-table-column>
                    <el-table-column prop="ghxh" label="挂号序号"></el-table-column>
                    <el-table-column prop="jsjlid" label="结算记录"></el-table-column>
                    <el-table-column prop="fyhj" label="费用合计"></el-table-column>
                    <el-table-column prop="ylkzf" label="医疗卡支付"></el-table-column>
                    <el-table-column prop="xjzf" label="现金支付"></el-table-column>
                    <el-table-column prop="ybkzf" label="保险支付"></el-table-column>
                    <el-table-column prop="tbje" label="退补金额"></el-table-column>
                </el-table>
            </div>
        </div>
        <div class='right'>
            <div class='basicInfo'>
                <ul>
                    <p>基本信息</p>
                    <li><div><span>交易ID：</span><span><input /></span></div><div><span>姓名：</span><span><input /></span></div></li>
                    <li><div><span>身份证号：</span><span><input /></span></div><div><span>门诊住院标志：</span><span><input /></span></div></li>
                    <li><div><span>就诊日起：</span><span><input /></span></div><div><span>住院号：</span><span><input /></span></div></li>
                    <li><div><span>出院日期：</span><span><input /></span></div><div><span>就诊机构代码：</span><span><input /></span></div></li>
                    <li><div><span>主要诊断编码：</span><span><input /></span></div><div><span>主要诊断名称：</span><span><input /></span></div></li>
                    <li><div><span>次要诊断：</span><span><input /></span></div><div><span>次要诊断名称：</span><span><input /></span></div></li>
                </ul>
            </div>
            <div class='twoProtect'>
                <ul>
                    <p>两保三救助三基金</p>
                    <li><div><span>总金额：</span><span><input /></span></div><div><span>自费金额：</span><span><input /></span></div></li>
                    <li><div><span>报销补助金额：</span><span><input /></span></div><div><span>医疗机构减免：</span><span><input /></span></div></li>
                    <li><div><span>基本医疗保险支付：</span><span><input /></span></div><div><span>大病医疗保险：</span><span><input /></span></div></li>
                    <li><div><span>重大疾病扶贫基金：</span><span><input /></span></div><div><span>住院费用全报销救助：</span><span><input /></span></div></li>
                    <li><div><span>疾病应急救助：</span><span><input /></span></div><div><span>民政医疗救助：</span><span><input /></span></div></li>
                    <li><div><span>卫生扶贫基金：</span><span><input /></span></div><div><span>医药爱心基金：</span><span><input /></span></div></li>
                    <li><div><span>商业保险：</span><span><input /></span></div><div><span>姓其他保险金额：</span><span><input /></span></div></li>
                </ul>
            </div>
            <div class='tenFree'>
                <ul>
                    <p>十免</p>
                    <li><div><span>一般诊疗费：</span><span><input /></span></div><div><span>院内会诊费：</span><span><input /></span></div></li>
                    <li><div><span>白内障复明手术费：</span><span><input /></span></div><div><span>艾滋病抗病毒治疗：</span><span><input /></span></div></li>
                    <li><div><span>基本公共卫生服务：</span><span><input /></span></div><div><span>妇幼卫生健康服务：</span><span><input /></span></div></li>
                    <li><div><span>巡回医疗服务：</span><span><input /></span></div><div><span>药物治疗包虫病：</span><span><input /></span></div></li>
                    <li><div><span>基本医保个人缴费：</span><span><input /></span></div><div><span>贫困孕产妇住院分娩：</span><span><input /></span></div></li>
                </ul>
            </div>
            <div class='fourHelp'>
                <ul>
                    <p>四补助</p>
                    <li><div><span>晚期血吸虫病人补助：</span><span><input /></span></div><div><span>手术治疗包虫病补助：</span><span><input /></span></div></li>
                    <li><div><span>大骨节患者年补助：</span><span><input /></span></div><div><span>0-6岁残疾儿童、康复康复训练和辅具：</span><span><input /></span></div></li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
    import api from '../backend/api';
    export default {
        props:{
            recStyle:{
                type:String
            }
        },
        data: function () {
            return {
                startDate:'',
                endDate:'',
                startTime:'',
                endTime:'',
                tableData:[]
            }
        },
        components:{
            
        },
        methods:{
            handleClick(){

            },
            uploadSingle(){

            },
            searchInfo(){
                var startDate = this.$refs.inputStartDate.displayValue || '';
                var endDate   = this.$refs.inputEndDate.displayValue || '';
                var startTime = this.$refs.inputStartTime.displayValue || '';
                var endTime   = this.$refs.inputEndTime.displayValue || '';

                if(this.recStyle == 'clinic'){
                    api.getPoorInfoByClinic((startDate+' '+startTime).trim(),(endDate+' '+endTime).trim()).then((data)=>{
                        this.tableData = JSON.parse(data);
                    })
                } else if(this.recStyle == 'hospitalized'){
                    api.getPoorInfoByHospitalized((startDate+' '+startTime).trim(),(endDate+' '+endTime).trim()).then((data)=>{
                        this.tableData = JSON.parse(data);
                    })
                }
            }
        }
    }   
</script>