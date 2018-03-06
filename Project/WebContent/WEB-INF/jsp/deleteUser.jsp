<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>DELETE INFO</title>

  </head>
  <body>

  <div class="container">

 	<div class="header p-3 mb-2 bg-success text-black">
 	  <div align="center"><h2>User Management System</h2></div>
    </div>


    <div class="header text-info">
      <div align="right">Hi! ${userInfo.name}<span style="margin-right: 1em;"></span>
      <a href="MyLogoutServlet" type="button" class="btn btn-secondary btn-sm">Logout</a>
      </div>
    </div>

 <br>
    <div class="text-info" align="center"><h3>DELETE USER INFO</h3></div>
  <br>

  <div align="center">
      <font size="+2">Login ID<span style="margin-right: 0.5em;"></span>/<span style="margin-right: 0.5em;"></span>${user.loginId}</font>
  </div>
  <div align="center">
      <font size="+2">User Name<span style="margin-right: 0.5em;"></span>/<span style="margin-right: 0.5em;"></span>${user.name}</font>
  </div>

  <br><br>

  <div align="center">
  <p>You are deleting this user from the user list.</p>
  Are you really sure you want to delete this user info?
  </div>

  <br><br>

    <form class="form" action="MyUserDeleteServlet" method="post">

    <div align="center"><a href="MyUserListServlet" type="button" class="btn btn-outline-info">Cancel</a>
    <span style="margin-right: 6em;"></span>

    <input type="hidden" name="id" value="${user.id}">
    <button type="submit" class="btn btn-primary">YES</button></div>

    </form>

  <br><br>

    <div align="right"><a href="MyUserListServlet" class="badge badge-light">Go Back</a></div>

  </div>

  </body>
</html>