<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>UPDATE USER INFO</title>

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
    <div class="text-info" align="center"><h3>UPDATE USER INFO</h3></div>
  <br>

    <form class="form" action="MyUserUpdateServlet" method="post">

    <div class="form-group"><div align="center">
      <font size="+2">Login ID<span style="margin-right: 0.5em;"></span>/<span style="margin-right: 0.5em;"></span>${user.loginId}</font>
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">Password</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="password" class="form w-25" id="InputPassword1" name="password" autofocus placeholder="Enter Password">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">Password(again)</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="password" class="form w-25" id="InputPassword2" name="password2" placeholder="Enter the same Password">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">User Name</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="text" class="form w-25" id="InputUserNm" name="name" value="${user.name}">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">Birth Date</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="datetime" class="form w-25" id="InputBD" name="birthDate" value="${user.birthDate}">
    </div></div>

    <input type="hidden"  name="id" value="${user.id}">

    <input type="hidden"  name="updateDate" value="<%= System.currentTimeMillis() %>">

  <br><br>

    <div align="center"><button type="submit" class="btn btn-primary">Update</button></div>

  <br><br>

    </form>

    <div align="right"><a href="MyUserListServlet" class="badge badge-light">Go Back</a></div>

  </div>

  </body>
</html>