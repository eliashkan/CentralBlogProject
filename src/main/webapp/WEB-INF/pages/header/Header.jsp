<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header mb-3">
    <a href="${pageContext.request.contextPath}/homepage" class="logo">THE BLOGGERS</a>
    <input class="menu-btn" type="checkbox" id="menu-btn"/>
    <label class="menu-icon" for="menu-btn"
    ><span class="navicon"></span
    ></label>
    <ul class="menu">

        <c:choose>
            <c:when test="${loggedUser==null}">
                <li><a href="${pageContext.request.contextPath}/login">Log-In</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${pageContext.request.contextPath}/login">Log-Out</a></li>
            </c:otherwise>
        </c:choose>

        <li><a href="${pageContext.request.contextPath}/sign">Sign-In</a></li>

        <li class="column ml-2 mr-3 mt-3">
            <i class="fas fa-search" aria-hidden="true"></i>
            <input style="background-color:#1a5caf2e;" type="text" placeholder="Search" aria-label="Search"
                   class="form-control form-control-sm m-auto">
        </li>
    </ul>

</div>
