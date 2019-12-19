<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<body class="d-block bg-dark" cz-shortcut-listen="true">

<div class="header mb-3">
    <a href="/CentralBlogProject/homepage" class="text-dark logo">BLOG CENTRAL</a>
    <input class="menu-btn" type="checkbox" id="menu-btn">
    <label class="menu-icon" for="menu-btn"><span class="navicon"></span></label>
    <ul class="menu">


        <li><a class="text-dark" href="/CentralBlogProject/logout">Log-Out</a></li>
        <li><a class="text-dark" href="/CentralBlogProject/login">My Account</a></li>


        <li class="column ml-2 mr-3 mt-3 mb-1">
            <i class="fas fa-search" aria-hidden="true"></i>
            <input style="background-color:#1a5caf2e;" type="text" placeholder="Search" aria-label="Search"
                   class="form-control form-control-sm m-auto">
        </li>
    </ul>

</div>

<canvas id="”canvas”" width="”600px”" height="”400px”"></canvas>


<div class="card bg-dark jumbotron" ;="" style="border:none">
    <article class="card-body d-flex-inline m-auto col-12" style="max-width: 500px;">

        <h4 class="card-title mt-3 text-light text-center">Blog Central</h4>

        <form action="blogmanager" method="GET">

            <input type="hidden" name="command" value="CREATE">

            <tr>
                <%--                Title param--%>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="title" class="form-control" placeholder="Title" type="text">
                </div>
            </tr>

            <%--          Blog Text--%>
            <tr>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"></span>
                    </div>
                    <textarea class="form-control" name="blogtext" aria-label=""
                              style="margin-top: 0px; margin-bottom: 0px; height: 500px;"></textarea>
                </div>
            </tr>


            <div class="form-group">
                <input type="submit" value="Publish" class="btn btn-primary btn-block"/>
            </div>
        </form>

    </article>
</div>


</body>


</html>
