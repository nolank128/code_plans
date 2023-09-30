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
  <script type="text/javascript">
    function checkName() {
      //1.获取用户名
      var uName = document.getElementById("uName").value;
      //2.异步发送到服务器
      //2.1 创建异步对象
      var xmlHttp;
      if (window.XMLHttpRequest) {
        //非IE
        xmlHttp = new XMLHttpRequest();
      } else if (window.ActiveXObject) {
        //IE
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
      }
      //2.2指定方法
      xmlHttp.open("get","/checkName?userName="+uName,true);
       // xmlHttp.open("post","/checkName",true);
      //2.3指定回调函数
      xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
          //接收服务器返回的内容
         var txt = xmlHttp.responseText;
         document.getElementById("rs").innerHTML = txt;
        }
      }
      //2.4发送请求
        xmlHttp.send(null);
       // xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
       // xmlHttp.send("userName="+uName);

    }
  </script>
</head>
<body>
    <h1>注册</h1>
    userName:<input type="text" id="uName" onblur="checkName()"><span id="rs" color="red"></span>
</body>
</html>