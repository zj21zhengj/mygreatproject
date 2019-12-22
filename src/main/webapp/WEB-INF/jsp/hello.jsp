<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hello World</title>
</head>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://www.layuicdn.com/layui/css/layui.css" />
<script src="https://www.layuicdn.com/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function() {
        var laydate = layui.laydate //日期
            ,laypage = layui.laypage //分页
            ,layer = layui.layer //弹层
            ,table = layui.table //表格
            ,carousel = layui.carousel //轮播
            ,upload = layui.upload //上传
            ,element = layui.element; //元素操作 等等...

        /*layer弹出一个示例*/
        layer.msg('Hello World');
    });
    //结论是不行 还是拼接字符串把 10-19,10-
    var show = function () {
        var obj1 = {};
        obj1['id'] = 10;
        obj1['age'] = 19;
        var obj2 = {};
        obj2['id'] = 11;
        obj2['age'] = 18;
        var array = [];
        //var str = JSON.stringify(array);
        array.push(obj1);
        array.push(obj2)
        var str = "10-19,10-";
        console.log(str);
        layer.open({
            type: 2,
            content:"${pageContext.request.contextPath}/hello6?id="+str
        });
    }
</script>
<body>
    <h2>Hello, ${message}</h2>
    <input type="button" onclick="show()" value="啊啊啊"/>
</body>
</html>