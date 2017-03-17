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
        return _backend.api().then((data)=>{
            return data;
        });
    }
};

export default Store;