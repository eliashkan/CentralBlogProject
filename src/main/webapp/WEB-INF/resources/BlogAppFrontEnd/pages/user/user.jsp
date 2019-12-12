<!DOCTYPE html>
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
  <title>Blog App</title>
</head>

<body class="d-block bg-dark">
<!--  <canvas style="position: absolute;" id='canv'></canvas> -->
<div class="header mb-3">
    <a href="${pageContext.request.contextPath}/homepage" class="logo">THE BLOGGERS</a>
    <input class="menu-btn" type="checkbox" id="menu-btn"/>
    <label class="menu-icon" for="menu-btn"
    ><span class="navicon"></span
    ></label>
    <ul class="menu">

        <li><a href="${pageContext.request.contextPath}/login">Log-Out</a></li>
        <li><a href="">Create new post</a></li>
        <li><a href="">Show my post</a></li>
        <li><a href="">Account Settings</a></li>

    </ul>
</div>

<div style="height: 20vh;"></div>

<!-- menu button -->
<div
        class="dropdown d-flex row container justify-content-center col-12 col-md-6 col-lg-6"
>
  <div class="col-12 col-md-12 col-lg-8">
    <button
            class=" btn btn-info dropdown-toggle"
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
        class="d-flex row container-fluid col-12 col-md-12 col-lg-12 justify-content-around m-auto"
        style="height:fit-content;"
>
  <div
          class="rounded blogdivColor col-12 col-md-12 col-lg-6 mt-5"
          style="height:fit-content;"
  >
    <p class="rounded blogColors ">
      Morbi elementum lacus lobortis, faucibus enim vel, ultricies velit.
      Nam blandit, dui ut sagittis pharetra, odio nisl facilisis velit,
      sit
    </p>
    <p class="rounded blogColors ">
      Morbi elementum lacus lobortis, faucibus enim vel, ultricies velit.
      Nam blandit, dui ut sagittis pharetra, odio nisl facilisis velit,
      sit
    </p>
    <p class="rounded blogColors ">
      Morbi elementum lacus lobortis, faucibus enim vel, ultricies velit.
      Nam blandit, dui ut sagittis pharetra, odio nisl facilisis velit,
      sit Morbi elementum lacus lobortis, faucibus enim vel, ultricies
      velit. Nam blandit, dui ut sagittis pharetra, odio nisl facilisis
      velit, sit Morbi elementum lacus lobortis, faucibus enim vel,
      ultricies velit. Nam blandit, dui ut sagittis pharetra, odio nisl
      facilisis velit, sit
    </p>
    <p class="rounded blogColors ">
      Morbi elementum lacus lobortis, faucibus enim vel, ultricies velit.
      Nam blandit, dui ut sagittis pharetra, odio nisl facilisis velit,
      sit
    </p>
    <p class="rounded blogColors ">
      Morbi elementum lacus lobortis, faucibus enim vel, ultricies velit.
      Nam blandit, dui ut sagittis pharetra, odio nisl facilisis velit,
      sit
    </p>
    <p class="rounded blogColors ">
      Morbi elementum lacus lobortis, faucibus enim vel, ultricies velit.
      Nam blandit, dui ut sagittis pharetra, odio nisl facilisis velit,
      sit Morbi elementum lacus lobortis, faucibus enim vel, ultricies
      velit. Nam blandit, dui ut sagittis pharetra, odio nisl facilisis
      velit, sit
    </p>
    <p class="rounded blogColors ">
      Morbi elementum lacus lobortis, faucibus enim vel, ultricies velit.
      Nam blandit, dui ut sagittis pharetra, odio nisl facilisis velit,
      sit
    </p>
  </div>

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


<script src="/js/snow.js"></script>
</body>
</html>
