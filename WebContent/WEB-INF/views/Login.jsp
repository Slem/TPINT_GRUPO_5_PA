<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="text-center my-4">Login</h1>
        
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label for="txtUsuario">Usuario</label>
                <input type="text" class="form-control" id="txtUsuario" name="txtUsuario" required>
            </div>
            <div class="form-group">
                <label for="txtPassword">Contraseña</label>
                <input type="password" class="form-control" id="txtPassword" name="txtPassword" required>
            </div>
            <button type="submit" class="btn btn-primary">Ingresar</button>
            <c:if test="${not empty error}">
                <div class="alert alert-danger mt-3">${error}</div>
            </c:if>
        </form>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-3Gxi/xjNlKBS/pJr1TE6s6Pp5Hp6P4R4M2L/cHJwBFSQ+9v5UQ8F/0aEhJmvlxK+" crossorigin="anonymous"></script>
</body>