<%-- 
    Document   : Usuario
    Created on : 29-oct-2020, 20:17:55
    Author     : dwigh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="es.viviengest.beans.Vivienda"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="es.viviengest.beans.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Viviengest -Admin Home</title>
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
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/REGISTRO/Reg.css"> 
    </head>
    <body>
        <form   action="RedireccionAdmin" method="post" >
           
            <nav class="navbar navbar-expand-lg fixed-top nav-style">
                <image class="navbar-brand icono" src="<%=request.getContextPath()%>/IMAGENES/icono2.png"/>
                <input type="submit" class="navbar-brand" name="viviendaelim" value="Visualizar viviendas"/> 
                <input type="submit" class="navbar-brand navbar-expand-lg" name="cerrar" value="Cerrar sesi&oacute;n"/> 
            </nav>
            <div class="container ">
                <div class="row text-center ">
                    <div class="col-md-10  boxTable"> 
                        <c:if test="${sessionScope.usuarios.size() != 0}">
                            
                        
                        <table class="table">
                            <tr>
                                <th>Opcion</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>NIF</th>
                                <th>Email</th>
                                <th>Rol</th>
                            </tr> 
                            <c:forEach var="usuario" items="${sessionScope.usuarios}">  
                            <tr>
                                <td><input type="radio" name="userSelct" checked value="${usuario.getId()}"/></td>
                                <td>${usuario.getNombre()}</td>
                                <td>${usuario.getApellidos()}</td>
                                <td>${usuario.getDni()}</td> 
                                <td>${usuario.getEmail()}</td>   
                                <td>${usuario.getRoll()}</td>
                            </tr>
                            </c:forEach>
                        </table> 
                        <div class="col-md-12 text-center">
                            <input class="btn text-center" type="submit"  name="eliminar" value="Eliminar"> 
                        </div>
                        </c:if>
                         <c:if test="${sessionScope.usuarios.size() == 0}">
                        <h1>No hay usuarios en el sistema</h1>
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
