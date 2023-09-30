<%@ page import="com.bob.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  com.bob.User: SuperBob
  Date: 2023/9/18
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //EL表达式只能从四个作用域中取值
        //EL表达式在取值时，从pageContext往下逐个范围取值（范围越来越大）
        pageContext.setAttribute("k1","pageContext1");
        request.setAttribute("k1","req1");
        session.setAttribute("k1","session1");
        application.setAttribute("k1","app1");
    %>
request=<%=request.getAttribute("k1")%><br>
req2=${k1}

    <%
        //直接定义访问不到，必须存值到作用域中
        int a= 20;
        pageContext.setAttribute("a1",a);//key值（a1）就可以被EL访问到
    %>
${1+2}<br>
${a1+10}<br>
${a1>30}<br>
${a1>30?"aa":"bb"}<br>
    <hr>

<%
    User user = new User();
    user.setName("Bob");
    user.setAge(20);
    pageContext.setAttribute("userName",user.getName());
    pageContext.setAttribute("userBob",user);
    pageContext.setAttribute("userAge",user.getAge());

    List list = new ArrayList();
    list.add("Celtics");
    list.add(user);
    list.add(7);
    pageContext.setAttribute("myList",list);

    Map map = new HashMap();
    map.put("TeamName","Boston Celtics");
    map.put("TeamLead",user);
    pageContext.setAttribute("myMap",map);
%>
userName=${userBob.name}<br>
userAge=${userAge}<br>
${myList[0]}<br>
${myList[1].age}<br>

${myMap.TeamName}<br>
${myMap.TeamLead.name}<br>

</body>
</html>
