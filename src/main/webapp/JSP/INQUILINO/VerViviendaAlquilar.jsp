<%-- 
    Document   : VerViviendaInquilino
    Created on : 02-dic-2020, 15:30:01
    Author     : dwigh
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
    <head>
        <title>Viviengest</title>
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
                    <h1>Vivienda para alquilar</h1> 
                </div>
                <div class="col-md-12 text-center">
                    <h4>¿Esta seguro de que desea alquilar la vivienda?</h4> 
                </div>
                <div class="col-sm-12">
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form"  action="RedireccionInquilino" method="post"  >

                                <div class="form-group">

                                    <div class="col-xs-4">
                                        <label for="nombre"><h4>Direcci&oacute;n: ${viviendaAlquilar.getDireccion()} </h4></label>
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-4">
                                        <label for="apellidos"><h4>Localidad:  ${viviendaAlquilar.getLocalidad()}</h4></label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="telefono"> <h4>Provincia:  ${viviendaAlquilar.getProvincia()}</h4></label>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="dni"><h4>C&oacute;digo postal: ${viviendaAlquilar.getcPostal()}  </h4></label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="email"><h4>N&uacute;mero de  habitaciones: ${viviendaAlquilar.getnHabitaciones()}  </h4></label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-4"> 
                                        <c:choose>
                                            <c:when  test=" ${requestScope.viviendaAlquilar.ascensor}">  
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
                                            <c:when  test=" ${requestScope.viviendaAlquilar.calefaccion}"> 
                                                <label for="calefaccion"><h4>Calefacci&oacute;n: si</h4></label>
                                            </c:when>
                                            <c:otherwise>
                                                <label for="calefaccion"><h4>Calefacci&oacute;n:  no</h4></label>
                                            </c:otherwise>
                                        </c:choose> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <c:choose>
                                            <c:when  test=" ${requestScope.viviendaAlquilar.aireAcondicionado}"> 
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
                                            <c:when  test=" ${requestScope.viviendaAlquilar.amueblado}"> 
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
                                        <label for="direccionpostal"><h4>Tipo de suelo: ${viviendaAlquilar.getTipoDeSuelo()} </h4></label> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>N&uacute;mero de ba&ntilde;os: ${viviendaAlquilar.getnBanios()}  </h4></label> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>Metros cuadrados:${viviendaAlquilar.getMetrosCuadrados()} m²</h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>M&iacute;nimo de meses de alquiler:${viviendaAlquilar.getMinimoMeses()}  </h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>Importe mensual: ${viviendaAlquilar.getImporteMensual()} </h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>Importe fianza: ${viviendaAlquilar.getImporteFinaza()} </h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-4">
                                        <label for="direccionpostal"><h4>A&ntilde;o de construcci&oacute: ${viviendaAlquilar.getAnioContruccion()} </h4></label> 
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-12 text-center"> 
                                        <input class="btn  btn-lg" type="submit"  name="Volver" value="Volver"> 
                                        <input class="btn  btn-lg" type="submit"  name="Alquilar" value="Alquilar"> 
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
