import $ from 'jquery';

var URL = 'www.xxxx.com';
var _backend = {
   
    api(param) {
        return $.ajax({
            url: `${URL}/Hospital/wechatPay`,
            method:'GET',
            contentType:'text/plain'
        })
    },

 };

var Store = {
    api(){
        return _backend.api().then((data)=>{
            return data;
        });
    }
};

export default Store;