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
        class="dropdown d-flex row container justify-content-center col-9 col-md-9 col-lg-9"
>


    <div class="col-12 col-md-12 col-lg-10 mb-2">
        <button
                class=" btn rounded btn-info dropdown-toggle"
                type="button"
                data-toggle="dropdown"
                aria-expanded="false"
        >
            Sort
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
<div
        class="d-flex row container-fluid col-12 col-md-12 col-lg-10 justify-content-around"
        style="height:fit-content;"
>


    <%--        //printing the posts global (only the titles)--%>
    <div class="rounded d-flex row blogdivColor justify-content-center col-12 col-md-12 col-lg-5"
         style="height: 900px;overflow-y: auto;">

        <c:forEach var="article" items="${postsToShow}">
            <div class="card rounded d-flex row container-fluid col-12 col-md-12 col-lg-12 mt-3 mb-3 bg-light"
                 style="width: 18rem;height: fit-content">
                <div class="card-body rounded bg-dark mt-2">

                        <%--Setting the url for each post--%>
                    <c:url var="templink" value="/blogmanager">
                        <c:param name="command" value="DELETE"/>
                        <c:param name="postId" value="${article.getIdPost()}"/>
                    </c:url>

                    <c:url var="templink" value="/blogmanager">
                        <c:param name="command" value="LIKE"/>
                        <c:param name="postId" value="${article.getIdPost()}"/>
                    </c:url>

                    <c:url var="templink" value="/blogmanager">
                        <c:param name="command" value="COMMENT"/>
                        <c:param name="postId" value="${article.getIdPost()}"/>
                    </c:url>


                    <h5 class="card-title text-light">${article.getTitle()}</h5>
                    <p class="card-text p-2 rounded-left bg-light text-primary" style="color: rebeccapurple">

                        <c:set var="articleText" value="${article.getText()}"/>
                        <%
                            String shortArticle = (String) pageContext.getAttribute("articleText");
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

                <div class="card-body p-2 font-weight-bold text-info"><c:out value="${article.formatDateTime()}"/></div>


                <div class="card-body pl-0 d-flex column col-1 col-sm-12">
                    <div class="m-0 p-0" role="group" aria-label="Basic example">

                        <c:choose>
                            <c:when test="${loggedUser==null}">
                                <%--                                    Only likes if user is not logged --%>
                                <form action="blogmanager" method="GET">
                            <span class="rounded text-dark p-2 mb-1"><c:out
                                    value="${article.getLikeCounter()}"/> Like</span>

                                    <button type="submit" name="LIKE" class="badge-success rounded mb-1"><a
                                            class="btn-link badge-success"
                                            role="button"
                                            href="${templink}">Like
                                    </a></button>

                                </form>
                            </c:when>
                            <c:otherwise>

                                <%--                                    Otherwise Likes comment--%>
                                <form action="blogmanager" method="GET">
                            <span class="rounded text-dark p-2 mb-1"><c:out
                                    value="${article.getLikeCounter()}"/> Like</span>

                                    <button type="submit" name="LIKE" class="badge-success rounded mb-1"><a
                                            class="btn-link badge-success"
                                            role="button"
                                            href="${templink}">Like
                                    </a></button>

                                    <button type="submit" name="COMMENT" class="badge-info rounded mb-1"><a
                                            class="btn-link badge-info"
                                            role="button"
                                            href="${templink}">Comment
                                    </a></button>

                                </form>


                            </c:otherwise>
                        </c:choose>


                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


    <aside class="d-flex-block flex-nowrap rounded bg-light col-10 col-sm-6 col-md-6 col-lg-3 h-lg-25"
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


</div>


<%--<script src="resources/js/snow.js"></script>--%>
</body>
</html>
