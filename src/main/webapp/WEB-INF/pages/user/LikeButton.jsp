<%--
  Created by IntelliJ IDEA.
  User: DIETERK
  Date: 10/12/2019
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Like button</title>
</head>
<body>
<span class="likebtn-wrapper"></span>
<script>
    (function (d, e, s) {
        if (d.getElementById("likebtn_wjs"))
            return;
        a = d.createElement(e);
        m = d.getElementsByTagName(e)[0];
        a.async = 1;
        a.id = "likebtn_wjs";
        a.src = s;
        m.parentNode.insertBefore(a, m)
    })(document, "script", "//w.likebtn.com/js/w/widget.js");
</script>
</body>
</html>
