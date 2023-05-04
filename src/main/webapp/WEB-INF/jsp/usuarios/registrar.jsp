<%--
  Created by IntelliJ IDEA.
  User: eduar
  Date: 04/05/2023
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <a class="navbar-brand me-2" href="index.jsp">
            <img src="../../../img/logo.png" alt="Logo" height="80" style="margin-top: -1px;"/>
        </a>

        <!-- Right links -->
        <div class="d-flex align-items-center">
            <a href="index.jsp">
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
    <div class="container pt-5 p-4">
        <h3 style="border-bottom: 0.01rem solid #9a9a9a">Registro de usuario</h3>

        <form:form method="POST" class="row" modelAttribute="usuario">
        <div class="col-6">
            <form:label path="nombre">Nombre: </form:label>
            <form:input path="nombre" class="form-control"/>
            <div><form:errors cssClass="form-text text-danger" path="nombre"/></div>
        </div>
        <div class="col-6">
            <form:label path="apellidos">Apellidos: </form:label>
            <form:input path="apellidos" class="form-control"/>
            <div><form:errors cssClass="form-text text-danger" path="apellidos"/></div>
        </div>
        <div class="col-6">
            <form:label path="dni">DNI: </form:label>
            <form:input path="dni" class="form-control"/>
            <div><form:errors cssClass="form-text text-danger" path="dni"/></div>
        </div>
        <div class="col-6">
            <form:label path="telef">Nº teléfono: </form:label>
            <form:input path="telef" onkeypress="if(event.which &lt; 48 || event.which &gt; 57) return false;" class="form-control"/>
            <div><form:errors cssClass="form-text text-danger" path="telef"/></div>
        </div>
        <div class="col-12">
            <form:label path="direccion">Dirección: </form:label>
            <form:input path="direccion" class="form-control"/>
            <div><form:errors cssClass="form-text text-danger" path="direccion"/></div>
        </div>
        <div class="col-6">
            <form:label path="correo">Correo electrónico: </form:label>
            <form:input path="correo" class="form-control"/>
            <div><form:errors cssClass="form-text text-danger" path="correo"/></div>
        </div>
        <div class="col-6">
            <form:label path="password">Contraseña: </form:label>
            <form:input type="password" path="password" class="form-control"/>
            <div><form:errors cssClass="form-text text-danger" path="password"/></div>
        </div>
            <div class="d-flex justify-content-center pt-4">
                <a href="<c:url value="/index.jsp"/>">
                    <button class="btn btn-secondary m-4" style="background-color:#ff545b;border-color:#ff545b">Cancelar</button>
                </a>
                <input name="enviar" type="Submit" value="Registrarse" class="btn btn-secondary m-4" style="background-color:#40C9A2;border-color:#40C9A2">
            </div>
        </form:form>
    </div>
</main>

</body>
<%@include file="/WEB-INF/templates/pie.jspx" %>
</html>
