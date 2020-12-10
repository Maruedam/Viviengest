<%-- 
    Document   : newjspRegistro
    Created on : 30-oct-2020, 9:22:41
    Author     : dwigh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Viviengest -Registro</title>
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
                    <h1>Registro de usuario</h1>
                </div>
                <div class="col-sm-12">
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form"  method="post" id="formulario">

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="nombre"><h4>Nombre</h4></label>
                                        <input type="text" maxlength="20"  class="form-control" name="nombre" id="nombre" placeholder="Antonio" title="Introduzca su nombre">
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="apellidos"><h4>Apellidos</h4></label>
                                        <input type="text" maxlength="30"  class="form-control" name="apellidos" id="apellidos" placeholder="Ramirez Toledo" title="Introduzca sus apellidos">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="telefono"> <h4>Tel&eacute;fono</h4></label>
                                        <input type="tel" maxlength="9"  class="form-control" name="telefono" id="telefono" placeholder="N&uacute;mero de tel&eacute;fono" title="Introduce tu tel&eacute;fono m&oacute;vil">
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="dni"><h4>DNI</h4></label>
                                        <input type="text"  maxlength="9" class="form-control" name="dni" id="nif" pattern="[0-9]{8}[A-Za-z]{1}" placeholder="99999999C" title="Introduzca 8 numeros y una letra">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="email"><h4>Email</h4></label>
                                        <input type="email" maxlength="50"  class="form-control" id="email"  name="email"  placeholder="you@email.com" >
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="passwd"><h4>Contrase&ntilde;a</h4></label>
                                        <input type="password" maxlength="50"  class="form-control" name="passwd" id="passwd" placeholder="password" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <c:if test="${requestScope.tipoUsuario =='i'}">
                                        <div class="col-xs-6">
                                            <label for="ultimaNomina"><h4>&Uacute;ltima n&oacute;mina</h4></label>
                                            <input type="decimal" maxlength="6"  class="form-control" name="ultimaNomina" id="ultimaNomina" placeholder="1.255" >
                                        </div>
                                    </c:if>
                                    <c:if test="${requestScope.tipoUsuario =='p'}">
                                        <div class="col-xs-6">
                                            <label for="numecuenta"><h4>N&uacute;mero de cuenta</h4></label>
                                            <input type="text"  maxlength="20" class="form-control" name="numecuenta" id="numecuenta" placeholder="ES111111111111111111" >
                                        </div>
                                        <div class="col-xs-6">
                                            <label for="direccionpostal"><h4>Direcci&oacute;n postal</h4></label>
                                            <input type="text" maxlength="30"  class="form-control" name="direccionpostal" id="direccionpostal" placeholder="Direcci&oacute;n" >
                                        </div>
                                    </c:if>
                                </div>

                                <div class="col-xs-12 text-center form-group">
                                    <h5 id="error" style="color: red"></h5>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-12 text-center">
                                        <input type="submit" class="btn2 btn-lg" name="boton" id="crear" value="Enviar">
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
        <script type="text/javascript" src="<%=request.getContextPath()%>/JS/RegistroJs.js"></script> 
    </body>
</html>
