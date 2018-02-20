<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>USER LIST</title>

  </head>
  <body>

  <div class="container">

    <div class="header p-3 mb-2 bg-success  text-black">
      <div align="center"><h2>User Management System</h2></div>
    </div>

    <div class="header text-info">
      <div align="right">Hi! ${userInfo.name}<span style="margin-right: 1em;"></span>
      <a href=""MyLogoutServlet"" type="button" class="btn btn-secondary btn-sm">Logout</a>
      </div>
    </div>

  <br>
    <div class="text-info" align="center"><h3>USER LIST</h3></div>
  <br>

    <form>

    <div class="form-group"><h4>
      <label for="exampleInputEmail1">Login ID</label>
      <input type="email" class="form-control w-25" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Login ID">
    </h4></div>

    <div class="form-group"><h4>
      <label for="exampleInputPassword1">User Name</label>
      <input type="password" class="form-control w-25" id="exampleInputPassword1" placeholder="User Name">
    </h4></div>

    <div class="form-group"><h4>
      <label for="InputBirthDate">Birth Date</label>

      <br>

      <input type="date" name="date" value="">

      ～

      <input type="date" name="date" value="">
    </h4></div>

    </form>

<br>

    <button type="submit" class="btn btn-primary">Search</button>

<br><br>

    <a href="registerUser.html" type="button" class="btn btn-outline-info">Add User</a>

<br><br><br>

    <table class="table table-sm">
    <thead>
      <tr>
        <th scope="col"><h5>Login ID</h5></th>
        <th scope="col"><h5>User Name</h5></th>
        <th scope="col"><h5>Birth Date</h5></th>
        <th scope="col"></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="user" items="${userList}" >
      <tr>
        <td>${user.loginId}</td>
        <td>${user.name}</td>
        <td>${user.birthDate}</td>
        <td>
          <a href="MyUserDetailServlet?id=${user.id}" type="submit" class="btn btn-primary btn-sm">Detail</a><span style="margin-right: 1em;"></span>
          <a href="MyUserUpdateServlet?id=${user.id}" type="submit" class="btn btn-primary btn-sm">Update</a><span style="margin-right: 1em;"></span>
          <a href="MyUserDeleteServlet?id=${user.id}" type="submit" class="btn btn-primary btn-sm">Delete</a>
        </td>
        </tr>
      </c:forEach>
    </tbody>
    </table>
</div>
</body>
</html>
