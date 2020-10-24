function doClear(){
    $("form input[type=text]:visible,form input[class='textbox-value']").val("");//将所有可见的input和class是textbox-value的input框 即代码选择框 的值清空
    $(".cxtj_t").hide();
}
//alert("111");

var table_title = [
    {title:"操作",field:"cz",align:'center',width:'10%',formatter : function(val,row,index){
            var xxzjbh = row.xxzjbh;
            console.log("=========");
            console.log(row);
            var cz="<a onclick=\"toUpd('"+xxzjbh+"')\" class='czbtn' >"+"修改"+"</a>";
            cz+="&nbsp;&nbsp;"+"<a onclick=\"toDel('"+xxzjbh+"')\" class='easyui-linkbutton' >"+"删除"+"</a>"
           /* if(row.spzt == '审批通过'){
                if(row.caseSlCode == null || row.caseSlCode == "" ){
                    cz = cz + "  <a onclick=\"toAjrl('"+xxzjbh+"')\" class='czbtn' >"+"认领"+"</a>"
                }else {
                    cz = cz + "  <a onclick=\"toAjfk('"+xxzjbh+"')\" class='czbtn' >"+"反馈"+"</a>"
                }
            }*/
            return  cz;
        }},
    /*{title:"选择",field:"xz",align:'center',checkbox:true,width:'3%'},*/
    {title:"信息主键编号",field:"xxzjbh",align:'center',width:'20%'},
    {title:"证件号码",field:"kyxsry_Zjhm",align:'center',width:'20%'},
    {title:"可疑依据",field:"kyxsry_kyyj",align:'center',width:'20%'},
    {title:"案事件编号",field:"asjbh",align:'center',width:'20%'},
    {title:"登记时间",field:"djsj",align:'center',width:'20%'}
];

function doQuery(){
 //   alert("ajax");
    $('#suspListTable').datagrid({
        url: "/queryList",
        columns: [table_title],
        striped: true,
        queryParams: serializeObject($("form[name='susListForm']")),
        singleSelect: true,
        nowrap: false, //设置是否换行，false换行，true不换行
        fitColumns: true,
        scrollbarSize: 0,
        selectOnCheck: false,
        checkOnSelect: false,
        idField : 'xxzjbh',
        fit: false,
        pagination: true,
        pageSize: 10,
        pageList: [10, 20, 50, 100, 5], //rows
        pageNumber: 1,
        loadFilter: function (data) {
            console.log("==========");
            console.log(data.rows);
            $(".total").html(data.total);
            return data;
        }
    });
    /*    if($("form").hasClass("hidee")){
            $("form").hide(600);
            $("form").removeClass("hidee");
        }else{
            $("form").addClass("hidee");
            $("form").show(600);
        }*/
}

//将表单序列化
function serializeObject(form){
    var o={};
    $.each(form.serializeArray(),function(index){
        if(o[this['name'] ]){
            o[this['name'] ] = o[this['name'] ] + "," + this['value'];
        }else{
            o[this['name'] ]=this['value'];
        }
    })
    return o;
}


/*function toAjrl(xxzjbh){
    var index=layer.open({
        title: '确定认领该案件吗?',
        area: ['360px', '160px'],
        btnAlign: 'c',
        closeBtn:'1',
        content: '<div><p style="display: inline-block;font-weight: 600;">案件受理号：</p><input name="caseSlCode" id="caseSlCode" style="width:calc(100% - 86px);padding: 0 5px;border:1px solid #ccc;border-radius: 2px;"></input></div>',
        btn:['确认','取消'],
        yes: function (index,layero) {
            layer.close(index);
            var caseSlCodeObj=layero.find('#caseSlCode');
            var caseSlCode = stringTrim($(caseSlCodeObj).val());
            if(caseSlCode == ""){
                layer.alert("案件受理号不能为空！");
                return;
            }
            var url="/jwzyp/ajrl?xxzjbh="+xxzjbh+"&caseSlCode="+caseSlCode;
            var index1 = layer.load(1, {
                content: '数据加载中...',
                shade: [0.35,'#fff'],
                success: function(layero) {
                    layero.find('.layui-layer-content').css({
                        'padding-top': '40px',
                        'width': '70px',
                        'background-position-x': '16px'
                    });
                }
            });
            $.ajax({
                type:"post",
                url:url,
                success:function(data){
                    if(data=="1"){
                        layer.alert("认领成功！","提示");
                        doQuery();
                    }else{
                        layer.alert("认领失败！","提示");
                    }
                    layer.close(index1);
                }

            });
        },
        no:function(index)
        {
            layer.close(index);
        }
    });

};*/


function toUpd(xxzjbh) {
   // var Zjhm=$("#update_Zjhm");
   // alert($("#update_Zjhm").val()+"==");
    //alert("我进来了");
   /* $.ajax({
        url:'/quy_xxzjbh',
        data:{"xxzjbh":xxzjbh},
        type:"get",
       // async:false,
        success:function (data) {
            alert(444444444444);
          //var tbXwKyxsRy=data.tbXwKyxsRy;
          console.log("444444444444");
          console.log(data.tbXwKyxsRy);
          console.log(data.tbXwKyxsRy.kyxsry_Zjhm);
              fuzhi(data.tbXwKyxsRy);
            $("#update_Zjhm").html(data.tbXwKyxsRy.kyxsry_Zjhm);

      //   $("#update_Zjhm").attr("value",data.tbXwKyxsRy.kyxsry_Zjhm);
         //$("#update_Kyyj").set("1111");
         // $("#update_Kyyj").val(data.tbXwKyxsRy.kyxsry_Kyyj);
           alert($("#update_Zjhm").val());

        }


    });*/
    var url = "update_Sus?xxzjbh="+xxzjbh;
    window.open(url);


}
/*function fuzhi(tbXwKyxsRy) {
    console.log("tbXwKyxsRy"+tbXwKyxsRy);
    $("#update_Zjhm").attr("value","12345");

}*/
function doUpdate() {
    //console.log(${xxzjbh});
    var s = window.location.href;
    var split = s.split("=");
    var xxzjbh = split[1];
    console.log("++++++++");
    console.log(xxzjbh);
        var  update_Zjhm = $('#update_Zjhm').val();
     //   alert($('#update_Zjhm').val());
    var update_Kyyj = $('#update_Kyyj').val();
    var update_person = $('#update_person').val();
    var update_address = $('#update_address').val();
    var update_date = $('#update_date').val();
     alert(update_Kyyj);

    if(!update_Zjhm)
    {
        alert('证件号码不能为空！');
        return false;
    }
    if(!update_Kyyj)
    {
        alert('可疑证据不能为空！');
        return false;
    }if(!update_person)
    {
        alert('录入人不能为空！');
        return false;
    }if(!update_address)
    {
        alert('录入单位不能为空！');
        return false;
    }if(!update_date)
    {
        alert('录入时间不能为空！');
        return false;
    }
    /*serializeObject($("form[name='add_Sus_Form']"))
    * {'xxzjbh':xxzjbh,'kyxsry_Zjhm':update_Zjhm,'kyxsry_Kyyj':update_Kyyj,
                'xxdjry_xm':update_person,'xxdjdw_Gajgmc':update_address,
                'djsj':update_date}
    * */
    $.ajax(
        {
            url: "/up_Sus",
            data:{'xxzjbh':xxzjbh,'kyxsry_Zjhm':update_Zjhm,'kyxsry_Kyyj':update_Kyyj,
                'xxdjry_xm':update_person,'xxdjdw_Gajgmc':update_address,
                'djsj':update_date},
            type: "post",
            beforeSend:function()
            {
                $("#msg_up").html("<span style='color:blue'>正在处理...</span>");

                return true;
            },
            success:function(data)
            {
                console.log(data);
                console.log(data.Msg);
                console.log(data.Msg);
                // var msg=data.Msg+"";
                alert(data.Msg+"");
                //   alert(msg);
                     window.open("suspicious");
                location.reload();
            },
            error:function()
            {
                alert('请求出错');
            },
            /*complete:function()
            {
            //    $('#acting_tips').hide();
            }*/
        });

    return false;


}
function add_Sus() {
   // window.location.href="add_Sus";
    /*alert("这里是按钮点击事件");*/
   var url ="add_Sus";
   window.open(url);
}
function toDel(xxzjbh) {
    $.messager.confirm('删除信息', 'Are you confirm this?', function(r){
        if (r){
            /*alert('confirmed: '+r);*/
            $.ajax({
                url:'del_Sus',
                data:{'xxzjbh':xxzjbh},
                type:'post',
                success:function (data) {
                    alert(data.Msg);
                    location.reload();
                },
                error:function()
                {
                    alert('请求出错');
                }

            })
        }
    });
}
/*
function toAjfk(xxzjbh) {
    var url = "/jwzfk/index?xxzjbh="+xxzjbh+"&flag=fk";
    window.open(url);
}*/
