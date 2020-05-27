<%--
  Created by IntelliJ IDEA.
  User: xulei
  Date: 2019/7/20
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function getJSONData(pn) {
        // alert(pn);
        $.getJSON(function(data) {
            data=JSON.parse(${array})
            alert(data.toString());
            var totalCount = data.totalCount; // 总记录数
            var pageSize = 3; // 每页显示几条记录
            var pageTotal = Math.ceil(totalCount / pageSize); // 总页数
            var startPage = pageSize * (pn - 1);
            var endPage = startPage + pageSize - 1;
            var $ul = $("#json-list");
            $ul.empty();
            for (var i = 0; i < pageSize; i++) {
                $ul.append('<li class="li-tag"></li>');
            }
            var dataRoot = data.jsonRoot;
            if (pageTotal == 1) {     // 当只有一页时
                for (var j = 0; j < totalCount; j++) {
                    $(".li-tag").eq(j).append("<span class='col1'><input type='checkbox' value='"+parseInt(j + 1)+"'/></span>")
                        .append("<span class='col2'>" + parseInt(j + 1)
                            + "</span>").append("<span class='col3'>" + dataRoot[j].id
                        + "</span>").append("<span class='col4'>" + dataRoot[j].name
                        + "</span>").append("<span class='col5'>" + dataRoot[j].address
                        + "</span>").append("<span class='col6'>" + dataRoot[j].phone
                        + "</span>").append("<span class='col7'>" + dataRoot[j].phone
                        + "</span>")
                }
            } else {
                for (var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {
                    if( j == totalCount){
                        break;       // 当遍历到最后一条记录时，跳出循环
                    }
                    $(".li-tag").eq(k).append("<span class='col1'><input type='checkbox' value='"+parseInt(j + 1)+"'/></span>")
                        .append("<span class='col2'>" + parseInt(j + 1)
                            + "</span>").append("<span class='col3'>" + dataRoot[j].id
                        + "</span>").append("<span class='col4'>" + dataRoot[j].name
                        + "</span>").append("<span class='col5'>" + dataRoot[j].address
                        + "</span>").append("<span class='col6'>" + dataRoot[j].phone
                        + "</span>").append("<span class='col7'>" + dataRoot[j].phone
                        + "</span>")
                }
            }
            $(".page-count").text(pageTotal);
        })
    }
    function getPage() {
        $.getJSON(function(data) {
            data=JSON.parse(${array})
            pn = 1;
            var totalCount = data.totalCount; // 总记录数
            var pageSize = 10; // 每页显示几条记录
            var pageTotal = Math.ceil(totalCount / pageSize); // 总页数
            $("#next").click(function() {
                if (pn == pageTotal) {
                    alert("后面没有了");
                    pn = pageTotal;
                } else {
                    pn++;
                    gotoPage(pn);
                }
            });
            $("#prev").click(function() {
                if (pn == 1) {
                    alert("前面没有了");
                    pn = 1;
                } else {
                    pn--;
                    gotoPage(pn);
                }
            })
            $("#firstPage").click(function() {
                pn = 1;
                gotoPage(pn);
            });
            $("#lastPage").click(function() {
                pn = pageTotal;
                gotoPage(pn);
            });
            $("#page-jump").click(function(){
                if($(".page-num").val()  <= pageTotal && $(".page-num").val() != ''){
                    pn = $(".page-num").val();
                    gotoPage(pn);
                }else{
                    alert("您输入的页码有误！");
                    $(".page-num").val('').focus();
                }
            })
            $("#firstPage").trigger("click");

        })
    }
    function gotoPage(pn) {
        // alert(pn);
        $(".current-page").text(pn);
        getJSONData(pn)
    }

    $(function() {
        getPage();
    })

</script>
<script type="text/javascript">
    function fenye() {
        var ls = ${ls};
        var num = ls.size();
        alert(num);
    }
</script>
<script type="text/javascript">

    $(function () {
        //方式一 Ajax方式获取Json数据
        $.ajax({
            url: 'getJson',
            type: 'GET',
            data: ${array},
            dataType: 'json',
            timeout: 1000,
            cache: false,
            beforeSend: LoadFunction, //加载执行方法
            error: erryFunction,  //错误执行方法
            success: succFunction //成功执行方法
        })

        function LoadFunction() {
            $("#list").html('加载中...');
        }

        function erryFunction() {
            alert("error");
            <%--var a = ${array};--%>
            <%--for(var i=0;i<a.length;i++){--%>
                <%--var obj = a[i];--%>
                <%--alert(obj.id);}--%>
        }

        function succFunction(tt) {
            var json = eval(tt); //数组
            var tt = "";
            $.each(json, function (index) {
                //循环获取数据
                var Id = json[index].id;
                tt += Id + "___"  + "<br>";
            });
            $("#list").html('');
            $("#list").html(tt);
        }
    })
</script>
<html>
<head>
    <title>Title</title>
    ${array.toString()}<br>
    ${array.toJSONString()}
</head>
<body>
<button >分页查询</button>
<ul class="ul" id="ul"></ul>
<ul class="json-list" id="json-list"></ul>
<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li class="active"><a href="#">1</a></li>
    <li class="disabled"><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
<div>点击加载json中的数据</div>
<input type="button" id="button" value="确定" />
<div id="result"></div>
<div id="list"></div>
</body>
</html>
