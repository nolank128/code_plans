<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  com.bob.User: SuperBob
  Date: 2023/9/15
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%!  //javaCodes
      int a=10;
  String b = "abc"; %>

  <%!  public String test(){
    return b;
  }%>

  <%! public int test1(){
    int res = new Random().nextInt();

    return res;
  }%>

  a=<%=test1()%><br>
  btest=<%=test()%>
  <h1>当前用户：${sessionScope.userName}</h1>
  </body>
</html>
