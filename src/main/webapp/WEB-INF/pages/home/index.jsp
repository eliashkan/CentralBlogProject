<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/cosmo/bootstrap.min.css"></script>
    <meta content="ie=edge" http-equiv="X-UA-Compatible"/>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/snow.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="" rel="stylesheet"/>

    <title>Blog App</title>


</head>

<body class="d-block bg-dark">

<%--<canvas style="position: absolute;" id='canv'></canvas>--%>


<jsp:include page="../header/Header.jsp"/>


<div style="height: 20vh;"></div>


<!-- menu button -->
<div
        class="dropdown d-flex row container justify-content-center col-9 col-md-9 col-lg-9 m-auto"
>


    <div class="col-12 col-md-12 col-lg-10 mb-2">
        <button
                class="btn rounded bg-primary dropdown-toggle text-light"
                type="button"
                data-toggle="dropdown"
                aria-expanded="false"
        >
            Sort
        </button>
        <form
                class="dropdown-menu bg-primary"
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
<div
        class="d-flex row container-fluid col-12 col-md-12 col-lg-10 justify-content-around m-auto"
        style="height:fit-content;"
>


    <%--printing the posts global (only the titles)--%>
    <jsp:include page="../blogs/blogsprintingVisitor.jsp"/>


    <aside class="d-flex-block flex-nowrap rounded bg-light col-10 col-sm-6 col-md-6 col-lg-3 h-lg-25"
           style="max-height:600px">
        <c:choose>
            <c:when test="${loggedUser==null}">
            </c:when>
            <c:otherwise>
                <img class="pt-2 rounded" src="${avatar}" alt="">
            </c:otherwise>
        </c:choose>


        <div class="rounded col-12 object-fit=contain p-2">
            <p class="rounded blogColors ">
                Morbi elementum lacus lobortis, faucibus enim vel, ultricies velit.
                Nam blandit, dui ut sagittis pharetra, odio nisl facilisis velit,
                sit
            </p>

        </div>
        <jsp:include page="../sessioncounterbadges/sessioncounterbadges.jsp"/>


    </aside>
</div>


<script src="resources/js/snow.js"></script>
</body>
</html>
