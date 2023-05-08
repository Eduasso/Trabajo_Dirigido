<%--
  Created by IntelliJ IDEA.
  User: eduar
  Date: 04/05/2023
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Reserva</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"/>
    <link rel="stylesheet" href="styles.css"/>
</head>
<body>
<%--CABECERA--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand me-2" href="../../index.jsp">
            <img src="../../../img/logo.png" alt="Logo" height="80" style="margin-top: -1px;"/>
        </a>

        <!-- Right links -->
        <div class="d-flex align-items-center">
            <a>
                <button type="button" class="btn btn-link px-3 me-2" style="color:#40C9A2">
                    Iniciar Sesión
                </button>
            </a>
            <a href="<c:url value="/usuarios/registrar"/>" >
                <button type="button" class="btn btn-primary me-3" style="background-color:#40C9A2;border-color:#40C9A2">
                    Registrarse
                </button>
            </a>
        </div>
    </div>
</nav>
<%--CABECERA--%>
<main>
    <div class="d-flex flex-column justify-content-center align-items-center" style="background-image: url(../../img/registrado.jpg); background-repeat: no-repeat; background-size: cover; height: 85vh; ">
        <h1 class="p-2 display-1" style="color: #000000;text-shadow: 2px 2px 10px #ffffff;">USUARIO REGISTRADO CORRECTAMENTE</h1>
    </div>
</main>
</body>
<%@include file="/WEB-INF/templates/pie.jspx" %>
</html>
