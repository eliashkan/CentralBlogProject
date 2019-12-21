<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


    <link href="" rel="stylesheet"/>
    <title>Blog App</title>
</head>

<body class="d-block bg-dark">

<jsp:include page="../header/Header.jsp"/>

<div style="height: 20vh;"></div>

<!-- menu button -->
<div
        class="dropdown d-flex row m-auto container-fluid col-12 col-sm-12 col-md-12 col-lg-7"
>


    <div class="col-12 col-md-12 col-lg-10 mb-2">
        <button
                class="btn rounded bg-primary dropdown-toggle text-light"
                type="button"
                data-toggle="dropdown"
                aria-expanded="false"

        >Sort
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

        <%--        <button type="submit" name="create" class="badge-info rounded mb-1 h-75"><a--%>
        <%--                class="btn-link badge-info "--%>
        <%--                role="button"--%>
        <%--                onclick="window.location.href='createpost'">Create--%>
        <%--            Post</a></button>--%>


        <a
                class="btn rounded bg-primary text-light"
                role="button"
                name="create"
                onclick="window.location.href='createpost'">Create a post

        </a>


    </div>
</div>


<%--printing the posts from the user (only the titles)--%>
<jsp:include page="../blogs/blogsprintingUser.jsp"/>


<%--    sidebar--%>
<jsp:include page="../sidebar/sidebar.jsp"/>


</body>
</html>
