<%--
  Created by IntelliJ IDEA.
  User: SuperBob
  Date: 2023/9/22
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#uId").blur(function (){
                var uId = $(this).val();
                //ajax
                $.post("/getUserById","uId="+uId,function (rs){
                    //将rs的数据进行转换,rs此时里面是json，属性对应着实体类的字段
                    //rs=eval("("+rs+")"); 这一行将返回的响应数据 rs 当作字符串进行解析，转换成JavaScript对象。
                    var user=JSON.parse(rs)//eval("("+rs+")");
                    $("#uName").val(user.userName);
                    $("#uSex").val(user.sex);
                });
            });
        })
    </script>
</head>
<body>
    userId:<input type="text" id="uId"><br>
    userName:<input type="text" id="uName"><br>
    userSex:<input type="text" id="uSex"><br>
</body>
</html>
