<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<%--        //printing the posts global (only the titles)--%>
<div class="rounded d-flex row blogdivColor justify-content-center col-12 col-md-12 col-lg-5"
     style="height: 900px;overflow-y: auto;">

    <c:forEach var="article" items="${postsToShow}" varStatus="theCount">
        <div class="card rounded d-flex row container-fluid col-12 col-md-12 col-lg-12 mt-3 mb-3 bg-light"
             style="width: 18rem;height: fit-content">
            <div class="card-body rounded bg-dark mt-2">

                    <%--Setting the url for each post--%>
                <c:url var="DELETE" value="/blogmanager">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="postId" value="${article.getIdPost()}"/>
                </c:url>

                <c:url var="LIKE" value="/blogmanager">
                    <c:param name="command" value="LIKE"/>
                    <c:param name="postId" value="${article.getIdPost()}"/>
                </c:url>

                <c:url var="COMMENT" value="/blogmanager">
                    <c:param name="command" value="COMMENT"/>
                    <c:param name="postId" value="${article.getIdPost()}"/>
                </c:url>


                <h5 class="card-title text-light">${article.getTitle()}</h5>

                <p>
                    <button class="btn btn-secondary p-2 rounded" data-toggle="collapse"
                            aria-expanded="false" data-target="#iteration${theCount.count}"
                            aria-controls="iteration${theCount.count}">
                        Show More
                    </button>
                </p>

                <div class="collapse h-25" id="iteration${theCount.count}">

                    <div class="card card-body">
                        <p><c:out value="${article.text}"/></p>
                    </div>
                </div>

            </div>

            <div class="card-body p-2 font-weight-bold text-info"><c:out value="${article.formatDateTime()}"/></div>


            <div class="card-body pl-0 d-flex column col-1 col-sm-12">
                <div class="m-0 p-0" role="group" aria-label="Basic example">

                    <c:choose>
                        <c:when test="${loggedUser==null}">
                            <%--                                    Only likes if user is not logged --%>
                            <form action="blogmanager" method="GET">

                                <a
                                        class="badge badge-pill badge-success p-2 mb-1"
                                        role="button"
                                        name="LIKE"
                                        href="${LIKE}" style="text-decoration: none;">
                                    <c:out
                                            value="${article.getLikeCounter()}"/> Like
                                </a>

                            </form>
                        </c:when>
                        <c:otherwise>

                            <%--                                    Otherwise Likes comment--%>
                            <form action="blogmanager" method="GET">
                                <a
                                        class="badge badge-pill badge-success p-2 mb-1"
                                        role="button"
                                        name="LIKE"
                                        href="${LIKE}" style="text-decoration: none;">
                                    <c:out
                                            value="${article.getLikeCounter()}"/> Like
                                </a>

                                <a
                                        class="badge badge-pill badge-dark p-2 mb-1"
                                        role="button"
                                        name="COMMENT"
                                        href="${COMMENT}" style="text-decoration: none;">
                                    Comment
                                </a>


                            </form>


                        </c:otherwise>
                    </c:choose>


                </div>
            </div>
        </div>
    </c:forEach>
</div>