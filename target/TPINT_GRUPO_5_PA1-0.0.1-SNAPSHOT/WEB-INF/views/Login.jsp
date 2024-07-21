<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
   <h1>Login</h1>
   <form action="<spring:url value='/procesar_login'/>" method="post">
      <table>
         <tr>
            <td><label for="username">Usuario:</label></td>
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
  

</body>
