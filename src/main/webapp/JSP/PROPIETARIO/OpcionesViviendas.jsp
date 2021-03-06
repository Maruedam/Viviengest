<%-- 
    Document   : EditarViviendas
    Created on : 01-dic-2020, 16:57:54
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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="IMAGENES/icono.png"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/REGISTRO/Registro.css"> 
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    </head>
    <body>
        <form   action="RedireccionVivienda" method="post" > 
            <c:set var = "nombre" scope = "page" value = "default.jpg"/> 
            <div class="container "> 
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h1>Opciones vivienda</h1>
                    </div>
                    <hr>
                </div>

                <div class="row boxModif"> 
                    <div class="col-md-12 col-sm-12 ">
                        <c:forEach var="vivienda" items="${sessionScope.viviendas}">

                            <div class="col-md-4 col-sm-6  col-xs-12 casa">
                                <div class="apartments-content">
                                    <div class="image-content">
                                        <a><img class="img" src="IMAGENES/VIVIENDAS/${vivienda.foto}" alt="Foto de la vivienda"></a> 
                                    </div><!-- /.image-content -->

                                    <div class="row ">
                                        <div class="col-xs-12">
                                            <h5><i class="fas fa-map-marked-alt"></i>&nbsp;&nbsp;${vivienda.getDireccion()} / ${vivienda.getProvincia()} / ${vivienda.getLocalidad()}  </h5>
                                            <h5><i class="fas fa-bed"></i>&nbsp;&nbsp;${vivienda.getnHabitaciones()}  dormitorios </h5>
                                            <h5><i class="fas fa-toilet"></i>&nbsp;&nbsp;&nbsp;&nbsp;${vivienda.getnBanios()}  ba&ntilde;os </h5>
                                            <h5><i class="fas fa-money-bill-wave"></i>&nbsp;&nbsp;${vivienda.getImporteMensual()} $ / Mes </h5>
                                            <input type="submit" class=" btn btn3  " name="${vivienda.getId()}" id="" value="Editar">
                                            <c:if test="${!vivienda.getEstado()}">
                                                <input type="submit" class=" btn btn3 " name="${vivienda.getId()}" value="Eliminar">
                                            </c:if> 
                                        </div>
                                    </div><!-- /.text-content -->
                                </div><!-- /.partments-content -->
                            </div>
                        </c:forEach>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 text-center">
                                <input class="btn text-center" type="submit"  name="volver" value="Volver"> 
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
