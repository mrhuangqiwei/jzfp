<style lang="scss" scoped>
    #recognizePoor{
        height: 100%;
        background: white;
        span.searchItem{
            display: inline-block;
            border: 1px solid;
            height: 2.5rem;
            margin-left: 2rem;
            width: 5rem;
            text-align: center;
            line-height: 2.5rem;
            border-radius: 4px;
        }
    }
</style>

<template>
    <div id='recognizePoor'>
        <div class='chooseDate'>
            统计日期
            <el-date-picker ref='inputStartDate' v-model="startDate" align="right" type="date" placeholder="选择开始日期"></el-date-picker>
            <el-time-picker ref='inputStartTime' v-model="startTime"  placeholder="任意时间点"></el-time-picker>
            至
            <el-date-picker ref='inputEndDate' v-model="endDate" align="right" type="date" placeholder="选择结束日期"></el-date-picker>
            <el-time-picker ref='inputEndTime' v-model="endTime"  placeholder="任意时间点"></el-time-picker>
            <span class='searchItem' @click='searchItem'>查找</span>
        </div>
        <div class='inputKey'>
            <div><input /></div>
            <div><span>贫困人口单个识别</span></div>
        </div>
        <div class='pageContent'>
            <el-table
                :data="tableData"
                stripe
                style="width: 100%">
                <el-table-column prop="brid" label="患者ID" width="180"></el-table-column>
                <el-table-column prop="brxm" label="患者姓名" width="180"></el-table-column>
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
</template>

<script>
    import api from '../backend/api';
    
    export default {
        props:{
            style:{
                type:String,
                default: 'clinic'
            }
        },
        data: function () {
            return {
                peopleInfo:[],
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

          searchItem(){
            console.log(1111);
            var startDate = this.$refs.inputStartDate.displayValue || '';
            var endDate   = this.$refs.inputEndDate.displayValue || '';
            var startTime = this.$refs.inputStartTime.displayValue || '';
            var endTime   = this.$refs.inputEndTime.displayValue || '';

            if(this.style == 'clinic'){
                api.recognizePoorByClinic(startDate+startTime,endDate+endTime).then((data)=>{
                    this.tableData = JSON.parse(data);
                })
            } else if(this.style='hospitalized'){
                api.recognizePoorByHospitalized(startDate+startTime,endDate+endTime).then((data)=>{
                    this.tableData = JSON.parse(data);
                })
            }
          },
        
        },
        mounted(){
            this.searchItem();
           
        }
    }   
</script>