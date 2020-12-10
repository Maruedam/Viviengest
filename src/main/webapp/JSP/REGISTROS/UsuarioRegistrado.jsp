<%-- 
    Document   : UsuarioRegistrado
    Created on : 19-nov-2020, 14:35:28
    Author     : dwigh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Viviengest -Registrado</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="author" content="MiguelAngel" />
        <meta name="generator" content="NetBeans 11.3" />
        <meta name="copyright" content="Miguel Angel Rueda Muriel" />
        <meta name="robots" content="index, follow" />
        <meta name="description" content="Viviengest" /> 
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="IMAGENES/icono.png"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/REGISTRO/Registro.css">
    </head>
    <body>
        <form method="post" action="Redireccion">
            <div class="container">
                <div class="row ">
                    <div class="col-md-12 text-center ">
                        <h1>¡¡Usuario registrado!!</h1>
                        <p>pulse el bot&oacute;n para iniciar sesi&oacute;n.</p>
                        <input type="submit" class="btn" name="inicio" value="Inicio"/>
                    </div>
                </div>
            </div>
        </form>

    </body>
</html>
