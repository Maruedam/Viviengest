<%-- 
    Document   : EditarInquilino
    Created on : 23-nov-2020, 19:32:54
    Author     : dwigh
--%>

<%@page import="es.viviengest.beans.Inquilino"%>
<%@page import="es.viviengest.beans.Usuario"%>
<%@page import="es.viviengest.beans.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Viviengest -Editar usuario</title>
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
        <div class="container bootstrap snippet wrapper">
            <div class="row" >
                <div class="col-md-12">
                    <h1>Editar usuario</h1>
                </div>
                <div class="col-sm-12">
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form"  method="post" id="formulario">

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="nombre"><h4>Nombre</h4></label>
                                        <input type="text" maxlength="20"  class="form-control" name="nombre" id="nombre" value="${sessionScope.usuario.getNombre()}" title="Introduzca su nombre">
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="apellidos"><h4>Apellidos</h4></label>
                                        <input type="text" maxlength="30"  class="form-control" name="apellidos" id="apellidos" value="${sessionScope.usuario.getApellidos()}" title="Introduzca sus apellidos">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="telefono"> <h4>Tel&eacute;fono</h4></label>
                                        <input type="tel" maxlength="9"  class="form-control" name="telefono" id="telefono" value="${sessionScope.usuario.getTelefono()}" title="Introduce tu tel&eacute;fono m&oacute;vil">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="passwd"><h4>Contrase&ntilde;a</h4></label>
                                        <input type="password" maxlength="50"  class="form-control" name="passwd" id="passwd" value="${sessionScope.usuario.getPasswd()}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="numecuenta"><h4>&Uacute;ltima n&oacute;mina</h4></label>
                                        <input type="text"  maxlength="6" class="form-control" name="nomina" id="nomina"  value="${sessionScope.inquilino.getultima_nomina()}"> 
                                </div>
                                <div class="col-xs-12 text-center form-group">
                                    <h5 id="error" style="color: red"></h5>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-12 text-center">
                                        <input type="submit" class="btn2 btn-lg" name="boton" id="modif" value="Modificar">
                                        <input class="btn2  btn-lg" type="submit"  name="boton" id="cancelar" value="Volver">
                                        <button class="btn2 btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Limpiar</button>
                                    </div>
                                </div>
                            </form>
                        </div><!--/tab-pane-->
                    </div><!--/tab-content-->
                </div><!--/col-9-->
            </div><!--/row-->
        </div>
        <footer class="row mt-4  page-footer  ">
            <div class="col text-center">
                &copy; Todos los derechos reservados. Miguel Angel Rueda
            </div>
        </footer> 
        <script type="text/javascript" src="<%=request.getContextPath()%>/JS/ModificarIJs.js"></script>                         
    </body>
</html>
