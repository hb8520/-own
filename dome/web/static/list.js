$(document).ready(function () {
    getlist();//一开始加载数据
    function getlist() {
        $.ajax({
            url:ctx+"/rainqs",
            data:{"opr":"getPageList"},
            type:"post",
            dataType:"json",
            success:function (result) {
                var $Info=('<a href="javascript:;" id="add">新增信息</a><table border="1" width="60%">\n' +
                    '        <tr>\n' +
                    '            <th>序号</th>\n' +
                    '            <th>区域名称</th>\n' +
                    '            <th>监测时间</th>\n' +
                    '            <th>雨量值（mm）</th>\n' +
                    '            <th>监测站</th>\n' +
                    '            <th>站点地址</th>\n' +
                    '            <th>操作</th>\n' +
                    '        </tr>\n' +
                    '        \n' +
                    '    </table>');
                $("#ceshi").append($Info);
                for (var i=0;i<result.length;i++){
                    var $Info=(' <tr>\n' +
                        '            <td>'+result[i].id+'</td>\n' +
                        '            <td>'+result[i].districtName+'</td>\n' +
                        '            <td>'+result[i].monitorTime+'</td>\n' +
                        '            <td>'+result[i].rain+'（mm）</td>\n' +
                        '            <td>'+result[i].monitoringStation+'</td>\n' +
                        '            <td>'+result[i].monitoringAddress+'</td>\n' +
                        '            <td><a href="javascript:;" id="update" update_id="'+result[i].id+'">修改</a><a href="javascript:;" id="del" del_id="'+result[i].id+'">删除</a></td>\n' +
                        '        </tr>');
                    $("table").append($Info);
                }

            }
        });
    }

    /**
     * 新增数据
     */
    $("body").on("click","#add",function () {
        //清空原有的数据
        $("#ceshi").html('');
        var $add=('<form action="">\n' +
            '        <p>区域名:<input type="text" name="districtName"></p>\n' +
            '        <p>时间:<input type="text" name="monitorTime"></p>\n' +
            '        <p>雨量:<input type="text" name="rain"></p>\n' +
            '        <p>出发站:<input type="text" name="monitoringStation"></p>\n' +
            '        <p>目的地:<input type="text" name="monitoringAddress"></p>\n' +
            '        <input type="submit" id="insert" value="提交">    <input type="submit" id="shuaxin" value="返回"></p>\n' +
            '    </form>');
        $("#ceshi").append($add);
    });

    //新增按钮点击事件
    $("body").on("click","#insert",function () {
        //获取表单中的数据
        var infos=$("form").serialize();
        //发送ajax请求
        $.ajax({
            url:ctx+"/rainqs",
            data:infos+"&opr=add",
            type:"post",
            dataType:"json",
            success:function (result) {
                if (result){
                    alert("新增成功！");
                    getlist();
                } else{
                    alert("新增失败！");
                }
            }
        });
    });

    //返回按钮
    $("body").on("click","#shuaxin",function () {
        getlist();//刷新页面
    });

    //删除点击事件
    $("body").on("click","#del",function () {
        $("#ceshi").html('');
        //获取选中行的id
        var del_id=$(this).attr("del_id");
        //友好提示，判断是否删除
        if(confirm("确定要删除吗？")){
            //发送ajax请求
            $.ajax({
                url:ctx+"/rainqs",
                data:{"opr":"del","del_id":del_id},
                type:"post",
                dataType:"json",
                success:function (result) {
                        if (result){
                            alert("删除成功");
                        } else{
                            alert("删除失败");
                        }
                    getlist();
                }
            });
        }
    });

    /**
     * 修改点击事件
     */
    $("body").on("click","#update",function () {
        //清空页面
        $("#ceshi").html('');
        //获取当前行的id
        var update_id=$(this).attr("update_id");
        //发送ajax请求
        $.ajax({
            url:ctx+"/rainqs",
            data:{"opr":"updateById","update_id":update_id},
            type:"post",
            dataType:"json",
            success:function (result) {
                var $upd=('<form action="">\n' +
                    '<input type="hidden" name="id" value="'+update_id+'">\n'+
                    '        <p>区域名:<input type="text" name="districtName" value="'+result.districtName+'"></p>\n' +
                    '        <p>时间:<input type="text" name="monitorTime" value="'+result.monitorTime+'"></p>\n' +
                    '        <p>雨量:<input type="text" name="rain" value="'+result.rain+'"></p>\n' +
                    '        <p>出发站:<input type="text" name="monitoringStation" value="'+result.monitoringStation+'"></p>\n' +
                    '        <p>目的地:<input type="text" name="monitoringAddress" value="'+result.monitoringAddress+'"></p>\n' +
                    '        <input type="submit" id="upda" value="修改">    <input type="submit" id="shuaxin" value="返回"></p>\n' +
                    '    </form>');
                $("#ceshi").append($upd);


            }
            });
    });

    //修改按钮点击事件
    $("body").on("click","#upda",function () {
        //获取表单中的数据
        var infos=$("form").serialize();
        //发送ajax请求
        $.ajax({
            url:ctx+"/rainqs",
            data:infos+"&opr=update",
            type:"post",
            dataType:"json",
            success:function (result) {
                if (result){
                    alert("修改成功！");
                    getlist();
                } else{
                    alert("修改失败！");
                }
            }
        });
    });
});