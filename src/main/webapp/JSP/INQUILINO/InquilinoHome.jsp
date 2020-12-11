<%-- 
    Document   : InquilinoHOme
    Created on : 16-nov-2020, 21:44:43
    Author     : dwigh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="es.viviengest.beans.Vivienda"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="es.viviengest.beans.Usuario"%>
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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="IMAGENES/icono.png"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/REGISTRO/Registro.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    </head>
    <body>
        <form   action="RedireccionInquilino" method="post" >
            <nav class="navbar navbar-expand-lg fixed-top nav-style">
                <image class="navbar-brand icono" src="<%=request.getContextPath()%>/IMAGENES/icono2.png"/>
                <input type="submit" class="navbar-brand" name="visualizar" value="Visualizar "/>  
                <input type="submit" class="navbar-brand" name="editarPerfil" value="Modificar "/> 
            </nav>
            <div class="container ">
                <div class="row">
                    <div class="col-sm-3 box">

                        <div class="row textUser">
                            <h4>Nombre: ${sessionScope.usuario.getNombre()} </h4> 
                            <h4>Apellidos:  ${sessionScope.usuario.getApellidos()} </h4>
                            <h4>Email:  ${sessionScope.usuario.getEmail()} </h4>
                            <h4>Tel&eacute;fono:  ${sessionScope.usuario.getTelefono()} </h4>
                            <input type="submit" class="btn" name="editarPerfil" value="Editar Perfil" /> 
                            <input type="submit" class="btn" name="cerrar" value="Cerrar sesi&oacute;n" /> 
                        </div>
                    </div>
                    <div class="col-sm-8 box">
                        <c:if test="${sessionScope.viviendaAlquiler!=null}"> 
                            <div class="col-md-4 col-sm-6  col-xs-12 casa">
                                <div class="apartments-content">
                                    <div class="image-content">
                                        <a><img class="img" src="IMAGENES/VIVIENDAS/${viviendaAlquiler.getFoto()}" alt="Foto de la vivienda"></a> 
                                    </div><!-- /.image-content -->

                                    <div class="row ">
                                        <div class="col-xs-12">
                                            <h5><i class="fas fa-map-marked-alt"></i>&nbsp;&nbsp;${viviendaAlquiler.getDireccion()} / ${viviendaAlquiler.getProvincia()} / ${viviendaAlquiler.getLocalidad()}  </h5>
                                            <h5><i class="fas fa-bed"></i>&nbsp;&nbsp;${viviendaAlquiler.getnHabitaciones()}  dormitorios </h5>
                                            <h5><i class="fas fa-toilet"></i>&nbsp;&nbsp;&nbsp;&nbsp;${viviendaAlquiler.getnBanios()}  ba&ntilde;os </h5>
                                            <h5><i class="fas fa-money-bill-wave"></i>&nbsp;&nbsp;${viviendaAlquiler.getImporteMensual()} $ / Mes </h5>
                                            <input type="submit" class=" btn btn3  " name="${viviendaAlquiler.getId()}"  value="Visualizar">
                                            <input type="submit" class=" btn btn3 " name="${viviendaAlquiler.getId()}" value="Propietario">
                                        </div>
                                    </div><!-- /.text-content -->
                                </div><!-- /.partments-content -->
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.viviendaAlquiler==null}">
                            <c:forEach var="vivienda" items="${sessionScope.viviendas}"> 
                                <div class="col-md-4 col-sm-6  col-xs-12 casa">
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
                                                <input type="submit" class=" btn btn3  " name="${vivienda.getId()}"  value="Visualizar">
                                                <input type="submit" class=" btn btn3 " name="${vivienda.getId()}" value="Alquilar">
                                            </div>
                                        </div><!-- /.text-content -->
                                    </div><!-- /.partments-content -->
                                </div>
                            </c:forEach>
                        </c:if>

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
