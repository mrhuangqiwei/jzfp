import $ from 'jquery';

const BASE_URL = 'http://182.141.186.113:8929';

var _backend = {
   
    medicialFee() {
        return $.ajax({
            url: `${BASE_URL}/jzfp/jzfpylfycx`,
            method:'GET',
            contentType:'text/plain'
        })
    },

    jianmianFee() {
        return $.ajax({
            url: `${BASE_URL}/jzfp/jmfycxservlet`,
            method:'GET',
            contentType:'text/plain'
        })
    },

    buzhuFee() {
        return $.ajax({
            url: `${BASE_URL}/jzfp/bzfycxservlet`,
            method:'GET',
            contentType:'text/plain'
        })
    },

    recognizePoorByClinic(startDate='',endDate=''){
        return $.ajax({
            url: `http://182.141.186.113:8929/jzfp/jzfpmzcxservlet?kssj=2016-12-13&jssj=2016-12-14&%E6%8F%90%E4%BA%A4=%E6%8F%90%E4%BA%A4%E6%9F%A5%E8%AF%A2%E5%86%85%E5%AE%B9`,
            method:'GET',
            contentType:'text/plain'
        })
    },

    recognizePoorByHospitalized(startDate='',endDate=''){
        return $.ajax({
            url: `http://182.141.186.113:8929/jzfp/jzfpmzcxservlet?kssj=2016-12-13&jssj=2016-12-14&%E6%8F%90%E4%BA%A4=%E6%8F%90%E4%BA%A4%E6%9F%A5%E8%AF%A2%E5%86%85%E5%AE%B9`,
            method:'GET',
            contentType:'text/plain'
        })
    },

    checkPoorMan(name,sfzh){
        return $.ajax({
            url: `https://171.221.252.191:8087/pkrkwebapi/GetPinkunpb?xingming=${name}&shenfenzh=${sfzh}&jigouid=510000003998`,
            method:'GET',
            contentType:'text/plain'
        })
    }


 };

var Store = {

    /**
     * 说明 ylfydmBeans:为对码后的医疗费用项目
     * 左边显示的是：zflxmc ：支付类型名称 又边显示的是ylfymc 医疗费用项目名称。
     右边的spanner点击后显示的是：ylfyxmBeans 及ylfyxmmc通过选择对应的是编码
     回传时传id, zflxbm,ylfybm给我。

     如果还没有对码的。也就是ylfydmBeans为空的时候左边显示的是
     zflxBeans 支付类型中的zflxmc 右边显示的是ylfyxmBeans 及ylfyxmmc通过选择对应的是编码。
     回传给我的参数是zflxbm,ylfybm
     */
    medicialFee(){
        return _backend.medicialFee().then((data)=>{
            return data;
        });
    },

    /***
     * 返回值说明：jmfycxBeans 如果这个不为空证明已经对过码，只是更新码表的对应
     * 右边显示已经对了码的费用项目。当点击时应该显示jmfyxmbmBeans       中的jmfymc。
     通过jmfyxmbm对应。回传给我的json中需要三个参数 id,fyxlbm,jmfybm。
     当jmfycxBeans 为空时，也就是从来没有对过码时。
     左边显示mxfybmBeans 中的mc,左边为空。点击后显示jmfyxmbmBeans       中的jmfymc
     通过mxfybmBeans中的bm 和 jmfyxmBeans中的jmfyxmbm对应。返回给为的json数据包含两个参数 bm, jmfyxmbm
     * @returns {*|Promise.<TResult>}
     */
    jianmianFee() {
        return _backend.jianmianFee().then((data)=>{
            return data;
        });
    },


    /**
     * 返回参数说明：
     当bzfycxBeans不为空时左边显示zflxmc，右边显示bzfymc。当点击右边的兰时显示bzfybmBeans 中的bzcymc  通过bzfybm 关联 回传给我的参数对应后的id, zflxbm,bzfybm。
     当bzfycxBeans 为空时，左边显示zflxBeans中的 zflxmc 右边点击显示 bzfybmBeans中的bzfymc 回传给我的参数需要对应后的 zflxbm,bzfybm
     * @returns {*|Promise.<TResult>}
     */
    buzhuFee() {
        return _backend.buzhuFee().then((data)=>{
            return data;
        });
    },

    /** 
     * 贫困人口识别，门诊！！！！ 
     提交参数 kssj ;   jssj  如：2017-03-14 08:03:16.323   2017-03-15 08:03:16.323
       {
        "jsjlid": "20161213000091",    结算记录id
        "ghxh": "20161213000054",      挂号序号 
        "jscs": "1",                   结算参数
        "jkpzh": "20161213000002",     交款凭证号
        "czybm": "0176",               结算操作员编码
        "czyxm": "凌绪敏",              结算操作员姓名
        "ywckbm": "01",                业务窗口编码
        "brid": "20161213000019",      患者ID
        "fyhj": 5,                     费用合计
        "ylkzf": 0,                    医疗卡支付
        "xjzf": 5,                     现金支付
        "ybkzf": 0,                    医保卡支付
        "tbje": 0,                     退补金额
        "jsqf": 0,                     结算欠费
        "qfbj": 0,                     欠费补缴
        "fphm": "",                    发票号码
        "jszt": "0",                   结算状态
        "ryrq": "2016-12-13 09:21:59.590",                   入院日期
        "czyks": "0022 ",              操作员科室编码
        "bzms": "挂号结算",             备注描述
        "bxlbbm": "",                  保险类别编码
        "bxjsbh": "",                  保险结算编号
        "brxm": "罗贤燕",               病人姓名
        "brxb": "2",                   病人性别
        "brnl": 29,                    病人年龄
        "sfzh": "513427198711022224",  身份证号
        "jzfpbz": " ",                 精准扶贫标志 1 是 其他否
        "pydm": "LXY"                  拼音代码
    }

     */
    recognizePoorByClinic(startDate,endDate){
        return _backend.recognizePoorByClinic(startDate,endDate).then((data)=>{
            return data;
        });
    },
    recognizePoorByHospitalized(){
        return _backend.recognizePoorByHospitalizeds(tartDate,endDate).then((data)=>{
            return data;
        });
    },
    /*
        机构系统调用人口数据库系统发布的webservice接口，通
        过该方法上传病人姓名、身份证号和机构ID，识别是否为贫困人口，机构ID必须上传
        如果是，则接口返回1，否则返回0。通讯失败，返回-1。
    */
    checkPoorMan(name,sfzh){
        return _backend.checkPoorMan(name,sfzh).then((data)=>{
            return data;
        })
    }
};

export default Store;