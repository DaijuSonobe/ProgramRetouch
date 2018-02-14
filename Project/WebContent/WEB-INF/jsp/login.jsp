<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>LOGIN MENU</title>

  </head>
  <body>

 <div class="container">

 	<div class="header p-3 mb-2 bg-success text-black">
 	  <div align="center"><h2>User Management System</h2></div>
    </div>

  <br>
    <div class="text-info" align="center"><h3>LOGIN MENU</h3></div>
  <br>
    <form>

    <div class="form-group"><div align="center"><h4>
      <label for="exampleInputEmail1">Login ID</label>
      <input type="email" class="form-control w-25" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Login ID ">
    </h4></div></div>

    <div class="form-group"><div align="center"><h4>
      <label for="exampleInputPassword1">Password</label>
      <input type="password" class="form-control w-25" id="exampleInputPassword1" placeholder="Enter Password">
    </h4></div></div>

    </form>

  <br>

    <div align="center"><a href="userList.html" type="submit" class="btn btn-primary">Submit</a></div>

  </div>

  </body>
</html>