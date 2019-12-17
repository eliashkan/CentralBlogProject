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


    <link href="" rel="stylesheet"/>
    <title>Blog App</title>
</head>

<body class="d-block bg-dark">
<!--  <canvas style="position: absolute;" id='canv'></canvas> -->
<jsp:include page="../header/Header.jsp"/>

<div style="height: 20vh;"></div>

<!-- menu button -->
<div
        class="dropdown d-flex row container justify-content-center col-12 col-md-6 col-lg-6"
>
    <div class="col-12 col-md-12 col-lg-8">
        <button
                class=" btn btn-info rounded dropdown-toggle"
                type="button"
                data-toggle="dropdown"
                aria-expanded="false"

        >
            MENU
        </button>
        <div
                class="dropdown-menu bg-dark"
                x-placement="bottom-start"
                style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(15px, 48px, 0px);"
        >
            <a class="dropdown-item text-light" href="#">By old user</a>
            <a class="dropdown-item text-light" href="#">By new user</a>
            <a class="dropdown-item text-light" href="#">Show more blogs</a>
        </div>
    </div>
</div>

<!-- blog post and menus -->
<div
        class="d-flex row container-fluid col-12 col-md-12 col-lg-11 justify-content-start m-auto"
        style="height:fit-content;"
>


    <%--        //printing the posts from user (only the titles)--%>

    <%--    <div class="rounded  blogdivColor col-12 col-md-12 col-lg-6 mt-5" style="height: 600px;overflow-y: auto;">--%>
    <c:forEach var="article" items="${postsToShow}">
        <div class="card rounded d-flex row container-fluid col-12 col-md-6 col-lg-4 align-content-start m-2"
             style="width: 18rem;">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">

                <h5 class="card-title">${article.getTitle()}</h5>

                <p class="card-text" style="color: rebeccapurple">
                    <c:set var="articleText" value="${article.getText()}"/>
                    <%
                        String shortArticle = ( String ) pageContext.getAttribute("articleText");
                        // substring of the article from 0 to index of second period (2 phrases)
                        shortArticle = shortArticle.substring(
                                0,
                                shortArticle.indexOf('.', shortArticle.indexOf('.') + 1) + 1
                        );
                        pageContext.setAttribute("shortArticle", shortArticle);
                    %>
                    <c:out value="${shortArticle} ..."/>
                </p>
            </div>
            <div class="card-body"><c:out value="${article.formatDateTime()}"/></div>
            <div class="card-body">
                <div class="btn-group btn-outline-primary" role="group" aria-label="Basic example">
                    <p class="btn m-0 btn-secondary">
                        <c:out value="${article.getLikeCounter()}"/>
                    </p>
                    <button type="button" class="btn btn-secondary">Like</button>
                </div>
            </div>
        </div>

        <%--            <p class="d-flex rounded blogColors" style="font-weight: bold!important ;">--%>

    </c:forEach>
    <%--    </div>--%>


    <aside class="d-flex-block flex-nowrap rounded bg-light col-10 col-sm-6 col-md-6 col-lg-3 h-lg-25 mt-5"
           style="max-height:600px">
        <img class="pt-2 rounded" src="https://via.placeholder.com/150C" alt="">


        <div class="rounded col-12 object-fit=contain p-2">
            <p class="rounded blogColors ">
                Morbi elementum lacus lobortis, faucibus enim vel, ultricies velit.
                Nam blandit, dui ut sagittis pharetra, odio nisl facilisis velit,
                sit
            </p>

        </div>


    </aside>
</div>
</div>
</canvas>


<script src="/BlogAppFrontEnd/js/snow.js"></script>
</body>
</html>
