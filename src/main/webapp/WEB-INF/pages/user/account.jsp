<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


    <link href="" rel="stylesheet"/>
    <title>Blog App</title>
</head>

<body class="d-block bg-dark">
<div class="header mb-3">
    <a href="${pageContext.request.contextPath}/homepage" class="logo">THE BLOGGERS</a>
    <input class="menu-btn" type="checkbox" id="menu-btn"/>
    <label class="menu-icon" for="menu-btn"
    ><span class="navicon"></span
    ></label>
    <ul class="menu">


    </ul>
</div>

<div style="height: 20vh;"></div>

<div class="card bg-dark" ; style="border:none">
    <article class="card-body mx-auto" style="max-width: 500px;">

        <h4 class="card-title mt-3 text-light text-center">THE BLOGGERS</h4>


        <form method="post">

            <h1><input type="submit" value="deleteProfile"></h1>

        </form>
    </article>
</div> <!-- card.// -->

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

</div>

</body>


</html>
