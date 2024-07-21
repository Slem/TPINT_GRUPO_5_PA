<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Dashboard Administrador</h2>
        <table id="example" class="table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Dirección</th>
                    <th>Código Postal</th>
                    <th>Provincia</th>
                    <th>Nacionalidad</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Email</th>
                    <th>Teléfono</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>36985478</td>
                    <td>Pedro</td>
                    <td>Gomes</td>
                    <td>Avenida Centenario 645</td>
                    <td>1642</td>
                    <td>Buenos Aires</td>
                    <td>Argentina</td>
                    <td>1996/05/10</td>
                    <td>ejemplo1@ejemplo.com</td>
                    <td>1144778855</td>
                </tr>
                <tr>
                    <td>37481456</td>
                    <td>Maria</td>
                    <td>Perez</td>
                    <td>Avenida Libertador 700</td>
                    <td>1478</td>
                    <td>Buenos Aires</td>
                    <td>Argentina</td>
                    <td>1990/10/15</td>
                    <td>ejemplo2@ejemplo.com</td>
                    <td>115487965</td>
                </tr>
                <tr>
                    <td>25698741</td>
                    <td>Jorge</td>
                    <td>Martinez</td>
                    <td>Blanco Encalada 100</td>
                    <td>1574</td>
                    <td>Buenos Aires</td>
                    <td>Argentina</td>
                    <td>1976/01/09</td>
                    <td>ejemplo3@ejemplo.com</td>
                    <td>112254856</td>
                </tr>
            </tbody>
        </table>

        <!-- Logout -->
        <div class="mt-3">
            <a href="<c:url value='/logout' />" class="btn btn-danger">Logout</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#example').DataTable();
        });
    </script>
</body>
</html>
