<%@page import="sun.security.util.Password"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>REGISTRATION SCREEN</title>

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
    <div class="text-info" align="center"><h3>NEW USER</h3></div>
  <br>

    <form class="form" action="MyUserRegisterServlet" method="post">

    <div class="form-group"><div align="center">
      <font size="+2">Login ID</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="text" class="form w-25" name="id" id="Id" autofocus placeholder="Enter Login ID ">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">Password</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="password" class="form w-25" name="password1" id="Password1" placeholder="Enter Password">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">Password(again)</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="password" class="form w-25" name="password2" id="Password2" placeholder="Enter the same Password">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">User Name</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="text" class="form w-25" name="userNm" id="UserNm" placeholder="Enter User Name">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">Birth Date</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="text" class="form w-25" name="birthDate" id="BirthDate" placeholder="Enter Birth Date (sample: 2000-01-01)">
    </div></div>

    <input type="hidden"  name="createDate" value="<%= System.currentTimeMillis() %>">
    <input type="hidden"  name="updateDate" value="<%= System.currentTimeMillis() %>">

  <br><br>

    <div align="center"><button type="submit" class="btn btn-primary">Register</button></div>

    </form>

  <br><br>

    <div align="right"><a href="MyUserListServlet" class="badge badge-light">Go Back</a></div>

  </div>

  </body>
</html>