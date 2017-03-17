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
    }
};

export default Store;