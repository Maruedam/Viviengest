<%-- 
    Document   : TipoUsuario
    Created on : 11-nov-2020, 18:49:46
    Author     : dwigh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Viviengest -Tipo de usuario</title>
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
        <div class="wrapper"> 
            <div id="formContent">
                <form id="formulario"  action="Redireccion" method="post">
                    <h2> Escoja un perfil de usuario:</h2>
                    <input class="btn  btn-responsive" type="submit" name="propietario" value="PROPIETARIO">
                    <input class="btn  btn-responsive" type="submit" name="inquilino" value="INQUILINO">
                </form>
            </div> 
            <footer class="row mt-4  page-footer  ">
                <div class="col text-center p-2">
                    &copy; Todos los derechos reservados. Miguel Angel Rueda
                </div>
            </footer>
        </div>
    </body>
</html>
