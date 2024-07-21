<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
   <h1>Login</h1>
   <form action="<spring:url value='/login' />" method="post">
      <table>
         <tr>
            <td><label for="username">Username:</label></td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td><label for="password">Contraseña:</label></td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><button type="submit">Login</button></td>
         </tr>
      </table>
  </form>
  
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-3Gxi/xjNlKBS/pJr1TE6s6Pp5Hp6P4R4M2L/cHJwBFSQ+9v5UQ8F/0aEhJmvlxK+" crossorigin="anonymous"></script>
</body>
