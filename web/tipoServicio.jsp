<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Tipos de Servicios</title>
    </head>
    <body>
        <h1>Alta Tipo Servicio</h1>
        
        <form action="SvTipoServicio" method="POST">            
            <p>Ingrese los datos del tipo de servicio</p>
            <p><label>Nombre:</label><input type="text" name="nombre"></p>
            <p><text>Descripcion:</label><textarea type="text" name="descripcion"></textarea></p>
            <button type="submit">Enviar</button>
            <input type="submit">Enviar</input>
        </form>
    </body>
</html>
