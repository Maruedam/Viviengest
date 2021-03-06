<%-- 
    Document   : VerVivienda
    Created on : 29-nov-2020, 9:13:09
    Author     : dwigh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
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
                <div class="col-md-12">
                    <h1>Visualizar vivienda</h1>
                </div>
                <div class="col-sm-12">
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form"  action="RegistroVivienda" method="post"  >

                                <div class="form-group">

                                    <div class="col-xs-4">
                                        <label for="nombre"><h4>Direcci&oacute;n: ${viviendaVis.getDireccion()} </h4></label>
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-4">
                                        <label for="apellidos"><h4>Localidad:  ${viviendaVis.getLocalidad()}</h4></label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="telefono"> <h4>Provincia:  ${viviendaVis.getProvincia()}</h4></label>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="dni"><h4>C&oacute;digo postal: ${viviendaVis.getcPostal()}  </h4></label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="email"><h4>N&uacute;mero de  habitaciones: ${viviendaVis.getnHabitaciones()}  </h4></label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-4"> 
                                        <c:choose>
                                            <c:when test="${requestScope.viviendaVis.ascensor}">  
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
                                            <c:when  test="${requestScope.viviendaVis.calefaccion}"> 
                                                <label for="calefaccion"><h4>Calefacci&oacute;n: si</h4></label>
                                            </c:when>
                                            <c:otherwise>
                                                <label for="calefaccion"><h4>Calefacci&oacute;n: no</h4></label>
                                            </c:otherwise>
                                        </c:choose> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <c:choose>
                                            <c:when  test=" ${requestScope.viviendaVis.getAireAcondicionado() }"> 
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
                                            <c:when  test=" ${requestScope.viviendaVis.amueblado}"> 
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
                                        <label for="direccionpostal"><h4>Tipo de suelo: ${viviendaVis.getTipoDeSuelo()} </h4></label> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>N&uacute;mero de ba&ntilde;os: ${viviendaVis.getnBanios()}  </h4></label> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>Metros cuadrados:${viviendaVis.getMetrosCuadrados()} m²</h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>M&iacute;nimo de meses de alquiler:${viviendaVis.getMinimoMeses()}  </h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>Importe mensual: ${viviendaVis.getImporteMensual()} </h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>Importe fianza: ${viviendaVis.getImporteFinaza()} </h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>A&ntilde;o de construcci&oacute: ${viviendaVis.getAnioContruccion()} </h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-12 text-center"> 
                                        <input class="btn  btn-lg" type="submit"  name="boton" value="Volver"> 
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
