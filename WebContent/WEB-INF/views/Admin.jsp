<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ejemplo de Tabla</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Tabla de Ejemplo</h2>
        <table id="example" class="table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Direccion</th>
                    <th>Codigo Postal</th>
                    <th>Provincia</th>
                    <th>Nacionalidad</th>
                    <th>Fecha de nacimiento</th>
                    <th>Email</th>
                    <th>Telefono</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>36985478</td>
                    <td>Pedro</th>
                    <td>Gomes</th>
                    <td>Avenida Centenario 645</th>
                    <td>1642</th>
                    <td>Buenos Aires</th>
                    <td>Argentina</th>
                    <td>1996/05/10</th>
                    <td>ejemplo1@ejemplo.com</th>
                    <td>1144778855</th>
                </tr>
                <tr>
                    <td>37481456</td>
                    <td>Maria</th>
                    <td>Perez</th>
                    <td>Avenida Libertador 700</th>
                    <td>1478</th>
                    <td>Buenos Aires</th>
                    <td>Argentina</th>
                    <td>1990/10/15</th>
                    <td>ejemplo2@ejemplo.com</th>
                    <td>115487965</th>
                </tr>
                <tr>
                    <<td>25698741</td>
                    <td>Jorge</th>
                    <td>Martinez</th>
                    <td>Blanco Encalada 100</th>
                    <td>1574</th>
                    <td>Buenos Aires</th>
                    <td>Argentino</th>
                    <td>1976/01/09</th>
                    <td>ejemplo3@ejemplo.com</th>
                    <td>112254856</th>
                </tr>
            </tbody>
        </table>
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
