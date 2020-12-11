<%-- 
    Document   : PropietarioHome
    Created on : 16-nov-2020, 21:43:55
    Author     : dwigh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Viviengest -Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="author" content="MiguelAngel" />
        <meta name="generator" content="NetBeans 11.3" />
        <meta name="copyright" content="Miguel Angel Rueda Muriel" />
        <meta name="robots" content="index, follow" />
        <meta name="description" content="Viviengest" />  
        <meta HTTP-EQUIV="Pragma" CONTENT="no-cache"/>
        <meta HTTP-EQUIV="Expires" CONTENT="-1"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="IMAGENES/icono.png"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/REGISTRO/Registro.css"> 
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    </head>
    <body>  
        <form   action="RedireccionPropietario" method="post" > 
            <c:set var = "nombre" scope = "page" value = "default.jpg"/>
            <nav class="navbar navbar-expand-lg fixed-top nav-style">
                <image class="navbar-brand icono" src="<%=request.getContextPath()%>/IMAGENES/icono2.png"/>
                <input type="submit" class="navbar-brand" name="crear" value="A&ntilde;adir"/> 
                <input type="submit" class="navbar-brand" name="visualizar" value="Visualizar"/>  
                <input type="submit" class="navbar-brand" name="editarVivienda" value="Modificar"/> 
            </nav>
            <div class="container ">
                <div class="row">
                    <div class="col-md-3 col-sm-12 box">

                        <div class="row textUser">
                            <h4>Nombre: ${sessionScope.usuario.getNombre()}</h4> 
                            <h4>Apellidos: ${sessionScope.usuario.getApellidos()} </h4>
                            <h4>Email: ${sessionScope.usuario.getEmail()} </h4>
                            <h4>Tel&eacute;fono: ${sessionScope.usuario.getTelefono()} </h4>
                            <input type="submit" class="btn" name="modificar" value="Editar Perfil" /> 
                            <input type="submit" class="btn" name="cerrar" value="Cerrar sesi&oacute;n" /> 
                        </div>

                    </div>
                    <div class="col-md-8 col-sm-12  box">
                        <c:forEach var="vivienda" items="${sessionScope.viviendas}">
                           
                            <div class="col-md-3 col-sm-6  col-xs-12 casa">
                                <div class="apartments-content">
                                    <div class="image-content">
                                        <a><img class="img" src="IMAGENES/VIVIENDAS/${vivienda.getFoto()}" alt="Foto de la vivienda"></a> 
                                    </div><!-- /.image-content -->

                                    <div class="row ">
                                        <div class="col-xs-12">
                                            <h5><i class="fas fa-map-marked-alt"></i>&nbsp;&nbsp;${vivienda.getDireccion()} / ${vivienda.getProvincia()} / ${vivienda.getLocalidad()}  </h5>
                                            <h5><i class="fas fa-bed"></i>&nbsp;&nbsp;${vivienda.getnHabitaciones()}  dormitorios </h5>
                                            <h5><i class="fas fa-toilet"></i>&nbsp;&nbsp;&nbsp;&nbsp;${vivienda.getnBanios()}  ba&ntilde;os </h5>
                                            <h5><i class="fas fa-money-bill-wave"></i>&nbsp;&nbsp;${vivienda.getImporteMensual()} $ / Mes </h5>
                                            <input type="submit" class="btn btn3 " name="${vivienda.getId()}" value="Visualizar">
                                            <c:if test="${vivienda.getEstado()}">
                                                <input type="submit" class="btn btn3 " name="${vivienda.getId()}" value="Inquilino">
                                            </c:if> 
                                        </div>
                                    </div><!-- /.text-content -->
                                </div><!-- /.partments-content -->
                            </div>
                        </c:forEach>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 text-center">
                                <input class="btn text-center" type="submit"  name="crear" value="Crear vivienda"> 
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="row mt-4 special  ">
                    <div class="col text-center p-2">
                        &copy; Todos los derechos reservados. Miguel Angel Rueda
                    </div>
                </footer> 
            </div> 
        </form>  
    </body>
</html>
