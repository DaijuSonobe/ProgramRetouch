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

    <form>

    <div class="form-group"><div align="center">
      <font size="+2">Login ID</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span><input type="email" class="form w-25" id="InputLogId" aria-describedby="emailHelp" placeholder="Enter Login ID ">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">Password</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="password" class="form w-25" id="InputPassword1" placeholder="Enter Password">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">Password(again)</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="password" class="form w-25" id="InputPassword2" placeholder="Enter the same Password">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">User Name</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="password" class="form w-25" id="InputUserNm" placeholder="Enter User Name">
    </div></div>

    <br>

    <div class="form-group"><div align="center">
      <font size="+2">Birth Date</font><span style="margin-right: 2em;"></span>:<span style="margin-right: 2em;"></span>
      <input type="password" class="form w-25" id="InputBD" placeholder="Enter Birth Date">
    </div></div>

    </form>

  <br><br>

    <div align="center"><button type="submit" class="btn btn-primary">Register</button></div>

  <br><br>

    <div align="right"><a href="userList.html" class="badge badge-light">Go Back</a></div>

  </div>

  </body>
</html>