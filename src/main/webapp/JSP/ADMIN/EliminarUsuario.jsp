<%-- 
    Document   : EliminarUsuario
    Created on : 24-nov-2020, 12:30:13
    Author     : dwigh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/REGISTRO/Reg.css">
    </head>
    <body>
        <form method="post" action="RedireccionAdmin">
            <div class="container">
                <div class="row ">
                    <h2>¿Desea eliminar este usuario?</h2>
                    <div class="col-md-6  boxTable2 ">
                        <c:if test="${requestScope.msj!=null}">
                            <div class="col-xs-12">
                                <label><h4 style="color: #94b791">${requestScope.msj} </h4></label>
                            </div>
                        </c:if> 
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="nombre"><h4>Nombre: ${sessionScope.usuarioelim.getNombre()} </h4></label>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="apellidos"><h4>Apellidos: ${sessionScope.usuarioelim.getApellidos()} </h4></label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="telefono"> <h4>Tel&eacute;fono: ${sessionScope.usuarioelim.getNombre()} </h4></label>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="dni"><h4>DNI: ${sessionScope.usuarioelim.getDni()}</h4></label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="email"><h4>Email: ${sessionScope.usuarioelim.getEmail()} </h4></label>
                            </div>
                        </div>
                        <div class="col-md-12 text-center">
                            <input type="submit" class="btn" name="volver" value="Cancelar"/>
                            <c:if test="${requestScope.msj==null}">
                                <input class="btn  " type="submit"  name="borrar" value="Eliminar">
                            </c:if> 
                        </div>
                    </div>

                </div>
            </div>
        </form>
    </body>
</html>
