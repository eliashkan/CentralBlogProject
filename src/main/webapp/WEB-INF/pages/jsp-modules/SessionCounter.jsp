<%@ page import="be.intecbrussel.centralblogproject.servlet.SessionCounter" %><%--
  Created by IntelliJ IDEA.
  User: Elias
  Date: 09/12/2019
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session Counter</title>
</head>
<body>
<%
    SessionCounter counter = (SessionCounter) session.getAttribute(
            SessionCounter.COUNTER);
%>

Number of online user(s): <%= counter.getActiveSessionNumber() %>
</body>
</html>
