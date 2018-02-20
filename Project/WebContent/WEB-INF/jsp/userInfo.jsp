<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>USER INFO</title>

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
    <div class="text-info" align="center"><h3>USER INFO</h3></div>
  <br>

    <table class="table">
  <thead class="thead">
    <tr>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Login ID</th>
      <td>${user.loginId}</td>
    </tr>
    <tr>
      <th scope="row">User Name</th>
      <td>${user.name}</td>
    </tr>
    <tr>
      <th scope="row">Birth Date</th>
      <td>${user.birthDate}</td>
    </tr>
     <tr>
      <th scope="row">Registration Date</th>
      <td>${user.createDate}</td>
    </tr>
     <tr>
      <th scope="row">Update Time</th>
      <td>${user.updateDate}</td>
    </tr>
  </tbody>
</table>






  <br><br>

    <div align="right"><a href="MyUserListServlet" class="badge badge-light">Go Back</a></div>

  </div>

  </body>
</html>