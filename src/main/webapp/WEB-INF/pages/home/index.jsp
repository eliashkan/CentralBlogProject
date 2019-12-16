<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <meta content="ie=edge" http-equiv="X-UA-Compatible"/>


    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
    <%--        <link href="${pageContext.request.contextPath}/resources/css/snow.css" rel="stylesheet"/>--%>
    <link href="" rel="stylesheet"/>
    <title>Blog App</title>
</head>

<body class="d-block bg-dark">


<jsp:include page="../header/Header.jsp"/>


<div style="height: 20vh;"></div>

<!-- menu button -->
<div
        class="dropdown d-flex row container justify-content-center col-12 col-md-6 col-lg-6"
>
    <div class="col-12 col-md-12 col-lg-8">
        <button
                class=" btn rounded btn-info dropdown-toggle"
                type="button"
                data-toggle="dropdown"
                aria-expanded="false"
        >
            MENU
        </button>
        <form
                class="dropdown-menu  bg-dark"
                x-placement="bottom-start"
                style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(15px, 48px, 0px);"
                action="postsort"
                method="post"

        >
            <input class="dropdown-item text-light" name="date" type="submit" value="By Date">
            <input class="dropdown-item text-light" name="mostpopular" type="submit" value="Most Popular">
            <input class="dropdown-item text-light" name="showmore" type="submit" value="Show More">
        </form>
    </div>
</div>

<div>


</div>

<!-- blog post and menus -->
<div id="block " ;
     class="d-flex row container-fluid col-12 col-md-12 col-lg-12 justify-content-around m-auto">

    <div class="rounded  blogdivColor col-12 col-md-12 col-lg-6 mt-5"
         style="height: 800px;overflow-y: auto;">


        <c:forEach var="element" items="${postsToShow}">
            <p class="d-flex rounded blogColors" style="font-weight: bold!important">
                <c:out value="${element.getTitle()}"/><br>
                <c:out value="${element.formatDateTime()}"/><br>
                <c:out value="${element.getLikeCounter()}"/> Likes <br>

            </p>
        </c:forEach>


    </div>

    <aside
            class=" rounded bg-light col-12 col-md-12 col-lg-2 mt-5"
            style="height: 500px;"
    ></aside>
</div>
</div>


<%--<script src="resources/js/snow.js"></script>--%>
</body>
</html>
