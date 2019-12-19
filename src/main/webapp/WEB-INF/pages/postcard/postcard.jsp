<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Elias
  Date: 19/12/2019
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

