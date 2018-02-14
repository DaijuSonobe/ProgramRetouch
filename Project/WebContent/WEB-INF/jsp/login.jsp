<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>LOGIN MENU</title>

  </head>
  <body>

  <c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
  </c:if>

 <div class="container">

 	<div class="header p-3 mb-2 bg-success text-black">
 	  <div align="center"><h2>User Management System</h2></div>
    </div>

  <br>
    <div class="text-info" align="center"><h3>LOGIN MENU</h3></div>
  <br>
    <form>

    <div class="form-group"><div align="center"><h4>
      <label for="InputLoginId">Login ID</label>
      <input type="text" name="loginId" class="form-control w-25" id="InputLoginId" aria-describedby="emailHelp" placeholder="Enter Login ID "  required autofocus>
    </h4></div></div>

    <div class="form-group"><div align="center"><h4>
      <label for="InputPassword">Password</label>
      <input type="password" name="password" class="form-control w-25" id="InputPassword" placeholder="Enter Password" required>
    </h4></div></div>

    </form>

  <br>

    <div align="center"><button class="btn btn-primary btn-signin" type="submit">Submit</button></div>

  </div>

  </body>
</html>