

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Empleados</title>
    </head>
    <body>
        <h1>Alta Empleados</h1>
        
        <form action="SvEmpleado" method="POST">            
            <p>Ingrese los datos del empleado</p>
            <p><label>Nombre:</label><input type="text" name="nombre"></p>
            <p><label>Apellido:</label><input type="text" name="apellido"></p>
            <p><label>Direccion:</label><input type="text" name="direccion"></p>
            <p><label>Dni:</label><input type="text" name="dni"></p>
            <p><label>Fecha Nacimiento:</label><input type="text" name="fechaNacimiento"></p>
            <p><label>Nacionalidad:</label><input type="text" name="nacionalidad"></p>
            <p><label>Tel. Contacto:</label><input type="text" name="telefono"></p>
            <p><label>Email:</label><input type="text" name="email"></p>
            <p><label>Usuario:</label><input type="text" name="usuario"></p>
            <p><label>Contrasenia:</label><input type="password" name="contrasenia"></p>
            <p><label>Cargo:</label><input type="text" name="cargo"></p>
            <p><label>Sueldo:</label><input type="text" name="sueldo" ></p>

            <button type="submit">Enviar</button>
            
        </form>
    </body>
</html>

<!-- <a href="cliente.jsp"> Cliente</a> 
        <a href="empleado.jsp"> Empleado</a>
        <a href="tipoServicio.jsp"> Tipo Servicio</a>
        <form action="SvConsultaCliente" method="GET">
            <a href="SvConsultaCliente" class="SUBMIT"> Ver Personas</a>
        </form> -->