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
            var cz="<a onclick=\"toAjxq('"+xxzjbh+"')\" class='czbtn' >"+"修改"+"</a>";
            cz+="&nbsp;&nbsp"+"<a onclick=\"toAjxq('"+xxzjbh+"')\" class='czbtn' >"+"删除"+"</a>"
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


function toAjxq(xxzjbh) {
    var url = "/jwzfk/index?xxzjbh="+xxzjbh;
    window.open(url);
}

/*
function toAjfk(xxzjbh) {
    var url = "/jwzfk/index?xxzjbh="+xxzjbh+"&flag=fk";
    window.open(url);
}*/
