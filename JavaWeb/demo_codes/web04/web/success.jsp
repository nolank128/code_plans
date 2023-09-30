<%--
  Created by IntelliJ IDEA.
  User: SuperBob
  Date: 2023/9/22
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>UPLOAD SUCCESS,userName=${userName}</h1>
    <a href="/downLoad?fileName=${imgName}">下载:</a><br>
<img src="MyUploadFile/${imgName}">
</body>
</html>
