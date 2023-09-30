<%--
  Created by IntelliJ IDEA.
  User: SuperBob
  Date: 2023/9/22
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="/ToUpload" method="post" enctype="multipart/form-data">
      file:<input type="file" name="MyFile"><br>
      userName:<input type="text" name="uName"><br>
      <input type="submit" value="UpLoad">
    </form>

  </body>
</html>
