<%-- 
    Document   : EliminarVivienda
    Created on : 01-dic-2020, 20:24:09
    Author     : dwigh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div class="row boxTableVer" >
                <div class="col-md-12 text-center">
                    <h1>Visualizar vivienda</h1>
                </div>
                <div class="col-sm-12">
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">

                            <hr>
                            <form class="form"  action="RedireccionAdmin" method="post"  >
                                <div class="boxTable2">
                                    <c:if test="${requestScope.eliminar!=null}">
                                        <div class="col-xs-12">
                                            <label style="color: yellow" ><h3>${requestScope.eliminar} </h3></label>
                                        </div>
                                    </c:if> 
                                    <div class="form-group">

                                        <div class="col-xs-4">
                                            <label for="nombre"><h4>Direcci&oacute;n: ${sessionScope.viviendaOpc.getDireccion()} </h4></label>
                                        </div>
                                    </div>

                                    <div class="form-group">

                                        <div class="col-xs-4">
                                            <label for="apellidos"><h4>Localidad:  ${sessionScope.viviendaOpc.getLocalidad()}</h4></label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="telefono"> <h4>Provincia:  ${sessionScope.viviendaOpc.getProvincia()}</h4></label>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="dni"><h4>C&oacute;digo postal: ${sessionScope.viviendaOpc.getcPostal()}  </h4></label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="email"><h4>N&uacute;mero de  habitaciones: ${sessionScope.viviendaOpc.getnHabitaciones()}  </h4></label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-4"> 
                                            <c:choose>
                                                <c:when  test=" ${sessionScope.viviendaOpc.getAscensor()}">  
                                                    <label for="Ascensor"><h4>Ascensor: si</h4></label> 
                                                </c:when>
                                                <c:otherwise>
                                                    <label for="Ascensor"><h4>Ascensor: no</h4></label>
                                                </c:otherwise>
                                            </c:choose> 
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4"> 
                                            <c:choose>
                                                <c:when  test=" ${sessionScope.viviendaOpc.getCalefaccion()}"> 
                                                    <label for="calefaccion"><h4>Calefacci&oacute;n: si</h4></label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label for="calefaccion"><h4>Calefacci&oacute;n: ${sessionScope.viviendaOpc.getCalefaccion()} no</h4></label>
                                                </c:otherwise>
                                            </c:choose> 
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <c:choose>
                                                <c:when  test=" ${sessionScope.viviendaOpc.getAireAcondicionado()}"> 
                                                    <label for="aire"><h4>Aire acondicionado: si</h4></label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label for="aire"><h4>Aire acondicionado: no</h4></label>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <c:choose>
                                                <c:when  test=" ${sessionScope.viviendaOpc.getAmueblado()}"> 
                                                    <label for="Ascensor"><h4>Amueblado: si </h4></label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label for="Ascensor"><h4>Amueblado: no</h4></label>
                                                </c:otherwise> 
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="direccionpostal"><h4>Tipo de suelo: ${sessionScope.viviendaOpc.getTipoDeSuelo()} </h4></label> 
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="direccionpostal"><h4>N&uacute;mero de ba&ntilde;os: ${sessionScope.viviendaOpc.getnBanios()}  </h4></label> 
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="direccionpostal"><h4>Metros cuadrados:${sessionScope.viviendaOpc.getMetrosCuadrados()} m²</h4></label> 
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="direccionpostal"><h4>M&iacute;nimo de meses de alquiler:${sessionScope.viviendaOpc.getMinimoMeses()}  </h4></label> 
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="direccionpostal"><h4>Importe mensual: ${sessionScope.viviendaOpc.getImporteMensual()} </h4></label> 
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="direccionpostal"><h4>Importe fianza: ${sessionScope.viviendaOpc.getImporteFinaza()} </h4></label> 
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-4">
                                            <label for="direccionpostal"><h4>A&ntilde;o de construcci&oacute: ${sessionScope.viviendaOpc.getAnioContruccion()} </h4></label> 
                                        </div> 
                                    </div>
                                    <div class="col-xs-12 text-center"> 
                                        <c:if test="${requestScope.eliminar!=null}">
                                            <input class="btn  btn-lg" type="submit"  name="Veliminar" value="Eliminar">
                                        </c:if> 
                                        <input class="btn  btn-lg" type="submit"  name="volver" value="Volver">
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
    </body>
</html>
