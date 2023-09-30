<%--
  Created by IntelliJ IDEA.
  User: SuperBob
  Date: 2023/9/21
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#uName").blur(function (){
                //接收输入的信息
                var uName = $(this).val();
                //发送Ajax
               /* $.ajax({
                    url:"/checkName",
                    type:"post",
                    data:"userName="+uName,
                    dataType:"text",
                    success:function (rs){
                        $("#rs").html(rs);
                    }
                });*/
                $.get("/checkName","userName="+uName,function (rs) {
                    $("#rs").html(rs);
                })
            });
        })
    </script>
    <style type="text/css">
        #rs{color:green}
    </style>
</head>
<body>
    <h1>注册</h1>
    userName:<input type="text" id="uName"><span id="rs"></span>
</body>
</html>