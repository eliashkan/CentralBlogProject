<%@ page import="be.intecbrussel.centralblogproject.listener.SessionCounter" %>
<%
    SessionCounter counter = (SessionCounter) session.getAttribute(
            SessionCounter.COUNTER);
%>
<span class="badge badge-pill badge-secondary">Visitors: <%= counter.getActiveSessionNumber() %></span>
<span class="badge badge-pill badge-warning">Logged In Users: <%= counter.getActiveLoggedInSessionNumber() %></span>