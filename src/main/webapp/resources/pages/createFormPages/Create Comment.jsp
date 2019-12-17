<%--
  Created by IntelliJ IDEA.
  User: DIETERK
  Date: 13/12/2019
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <meta content="ie=edge" http-equiv="X-UA-Compatible"/>


    <link href="${pageContext.request.contextPath}/WEB-INF/resources/BlogAppFrontEnd/css/bootstrap.min.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/WEB-INF/resources/BlogAppFrontEnd/css/style.css" rel="stylesheet"/>


    <link href="" rel="stylesheet"/>
    <title>Create Comment</title>
</head>
<body class="d-block bg-dark">
<div class="header mb-3">
    <a href="${pageContext.request.contextPath}/homepage" class="logo">THE BLOGGERS</a>
    <input class="menu-btn" type="checkbox" id="menu-btn"/>
    <label class="menu-icon" for="menu-btn"
    ><span class="navicon"></span
    ></label>
    <ul class="menu">

        <li><a href="${pageContext.request.contextPath}/login">Log-In</a></li>
        <li><a href="${pageContext.request.contextPath}/sign">Sign-In</a></li>

        <li class="column ml-2 mr-3 mt-3">
            <i class="fas fa-search" aria-hidden="true"></i>
            <input style="background-color:#1a5caf2e;" type="text" placeholder="Search" aria-label="Search"
                   class="form-control form-control-sm m-auto">

        </li>

    </ul>
</div>

<div style="height: 20vh;"></div>

<div class="card bg-dark" style="border:none">
    <article class="card-body mx-auto" style="max-width: 500px;">
        <h4 class="card-title mt-3 text-light text-center">Create Comment</h4>

        <!------------------------------------------------------------------------------->
        <!----------------------------Create Comment FORM--------------------->

        <form action="sign" method="POST">
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                </div>

                <input name="userName" class="form-control" placeholder="Username" type="text">
            </div> <!-- form-group// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                </div>
            </div> <!-- form-group// -->

            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                </div>

                <input name="Comment" class="form-control" placeholder="Comment" type="text">
            </div> <!-- form-group// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                </div>
            </div> <!-- form-group// -->
            <div class="form-group ">
                <button type="submit" class="btn btn-primary text-light btn-block"> Create Comment</button>
            </div> <!-- form-group// -->
            <a href="${pageContext.request.contextPath}/index">Back</a></p>
        </form>


    </article>
</div> <!-- card.// -->

</div>


</body>
</html>
