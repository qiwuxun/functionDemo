$(function() {
    //设置text需要验证
    $('input[type=text]').validatebox();
    //自定义validator.js
    //扩展easyui表单的验证
    $.extend($.fn.validatebox.defaults.rules, {

        //1.电话号码验证
        phone: { // 验证电话号码
            validator: function(value) {
                var reg = /(0[1-9][0-9]{9,10}$)|(^(13|14|15|17|18)[0-9]{9}$)/;
                if(!reg.test(value)){
                    return false;
                }else {
                    return true;
                }
            },
            message: '电话号码格式固话（如02911111111/029222222222）或正确手机！'
        },
        // 2.验证身份证
        idcard: { // 验证身份证
            validator: function(value) {
                var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
                if(!reg.test(value)){
                    return false;
                }else {
                    return true;
                }
            },
            message: '身份证号码格式不合法!'
        }
    });
});