<%-- 
    Document   : EditarVivienda
    Created on : 01-dic-2020, 20:23:44
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
            <div class="row boxTableCrear" >
                <div class="col-md-12">
                    <h1>Modificar vivienda</h1>
                </div>
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <hr>
                        <form class="form" method="post" id="formulario"  enctype="multipart/form-data" >

                            <div class="form-group"> 
                                <div class="col-xs-4">
                                    <label for="direccion"><h4>Direcci&oacute;n</h4></label>
                                    <input type="text" maxlength="50"  value="${sessionScope.viviendaEditar.getDireccion()}"  class="form-control" name="direccion" id="direccion"placeholder="C/Madrid 32/1ºB" title="Introduzca su direccion">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-4">
                                    <label for="cPostal"><h4>C&oacute;digo postal</h4></label>
                                    <input type="number" maxlength="5" value="${sessionScope.viviendaEditar.getcPostal()}"  oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  class="form-control" name="cPostal" id="cPostal" placeholder="06800" title="Introduzca el codigo postal de su vivienda">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-4">
                                    <label for="localidad"> <h4>Localidad</h4></label>
                                    <input type="text" maxlength="30"  value="${sessionScope.viviendaEditar.getLocalidad()}"  class="form-control" name="localidad" id="localidad" placeholder="Madrid" title="Introduce la localidad de la vivienda">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-4">
                                    <label for="provincia"> <h4>Provincia</h4></label>
                                    <input type="text" maxlength="20"  value="${sessionScope.viviendaEditar.getProvincia()}"  class="form-control" name="provincia" id="provincia" placeholder="Madrid" title="Introduce la provincia de la vivienda">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-4">
                                    <label for="nHabitaciones"><h4>N&uacute;mero de habitaciones</h4></label>
                                    <input type="number" maxlength="2" value="${sessionScope.viviendaEditar.getnHabitaciones()}"  oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  class="form-control" name="nHabitaciones" id="nHabitaciones" placeholder="3" title="Introduzca el numero de habitaciones de su vivienda">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-4">
                                    <label for="tipoDeSuelo"><h4>Tipo de suelo</h4></label>
                                    <input type="text"  maxlength="20" value="${sessionScope.viviendaEditar.getTipoDeSuelo()}"  class="form-control" name="tipoDeSuelo" id="tipoDeSuelo"  placeholder="Madera" title="Introduzca el tipo de suelo">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-4">
                                    <label for="nBanios"><h4>N&uacute;mero de ba&ntilde;os</h4></label>
                                    <input type="number" maxlength="2" value="${sessionScope.viviendaEditar.getnBanios()}"  oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  class="form-control" name="nBanios" id="nBanios" placeholder="2" title="Introduzca el numero de ba&ntilde; de su vivienda">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-4">
                                    <label for="metrosCuadrados"><h4>Metros cuadrados</h4></label>
                                    <input type="number" maxlength="6" value="${sessionScope.viviendaEditar.getMetrosCuadrados()}"  oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  class="form-control" name="metrosCuadrados" id="metrosCuadrados" placeholder="200" title="Introduzca el numero de ba&ntilde; de su vivienda">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-4">
                                    <label for="minimoMeses"><h4>M&iacute;nimo de meses de alquiler</h4></label>
                                    <input type="number"  maxlength="2" value="${sessionScope.viviendaEditar.getMinimoMeses()}"  oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  class="form-control" name="minimoMeses" id="minimoMeses" placeholder="12" title="Introduzca el numero de ba&meses minimo para alquilar su vivienda">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-4">
                                    <label for="importeMensual"><h4>Importe mensual</h4></label>
                                    <input type="number" min="0" step='0.01' value="${sessionScope.viviendaEditar.getImporteMensual()}"  maxlength="6" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  class="form-control" name="importeMensual" id="importeMensual" placeholder="750,50" title="Introduzca el importe mensual vivienda">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-4">
                                    <label for="importeFinaza"><h4>Importe fianza</h4></label>
                                    <input type="number" min="0"  step='0.01' value="${sessionScope.viviendaEditar.getImporteFinaza()}"  maxlength="6" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  class="form-control" name="importeFinaza" id="importeFinaza" placeholder="750,50" title="Introduzca el importe de la fianza de la vivienda">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-4">
                                    <label for="anioContruccion"><h4>A&ntilde;o de construcci&oacute;n</h4></label>
                                    <input type="number"   maxlength="4" value="${sessionScope.viviendaEditar.getAnioContruccion()}"  oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  class="form-control" name="anioContruccion" id="anioContruccion" placeholder="1995" title="Introduzca el a&ntilde;o de construccion de la vivienda">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-6">
                                    <label for="comunidad"><h4>Importe comunidad</h4></label>
                                    <input type="number"  maxlength="6" value="${sessionScope.viviendaEditar.getComunidad()}"  oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  class="form-control" name="comunidad" id="comunidad" placeholder="20" title="Introduzca el importe de la comunidad de la vivienda">
                                </div>
                            </div>

                            <div class="form-group"> 
                                <div class="col-xs-6">
                                    <div class="row">
                                        <div class="col-xs-6">

                                            <label class="form-check-label" for="ascensor"><h4>Ascensor</h4></label>
                                            <c:if test="${sessionScope.viviendaEditar.ascensor}">
                                                <input type="checkbox" checked class="form-check-input" name="ascensor" id="ascensor"><br>
                                            </c:if>
                                            <c:if test="${!sessionScope.viviendaEditar.ascensor}">
                                                <input type="checkbox" class="form-check-input" name="ascensor" id="ascensor"><br>
                                            </c:if>
                                            <label class="form-check-label" for="calefaccion"><h4>Calefaccion</h4></label>
                                            <c:if test="${sessionScope.viviendaEditar.calefaccion}">
                                                <input type="checkbox" checked class="form-check-input" name="calefaccion" id="calefaccion">
                                            </c:if>
                                            <c:if test="${!sessionScope.viviendaEditar.calefaccion}">
                                                <input type="checkbox" class="form-check-input" name="calefaccion" id="calefaccion">
                                            </c:if>

                                        </div>
                                        <div class="col-xs-6">
                                            <label class="form-check-label" for="aireAcondicionado"><h4>Aire acondicionado</h4></label>
                                            <c:if test="${sessionScope.viviendaEditar.aireAcondicionado}">
                                                <input type="checkbox" checked class="form-check-input" name="aireAcondicionado" id="aireAcondicionado">
                                            </c:if>
                                            <c:if test="${!sessionScope.viviendaEditar.aireAcondicionado}">
                                                <input type="checkbox" class="form-check-input" name="aireAcondicionado" id="aireAcondicionado">
                                            </c:if>
                                            <label class="form-check-label" for="amueblado"><h4>Amueblado</h4></label>
                                            <c:if test="${sessionScope.viviendaEditar.amueblado}">
                                                <input type="checkbox" checked class="form-check-input" name="amueblado" id="amueblado">
                                            </c:if>
                                            <c:if test="${!sessionScope.viviendaEditar.amueblado}">
                                                <input type="checkbox" class="form-check-input" name="amueblado" id="amueblado">
                                            </c:if>
                                        </div>
                                    </div> 
                                </div>
                            </div> 

                            <div class="form-group"> 
                                <div class="col-xs-6 ">
                                    <label for="foto"><h4>Fotos de la vivienda</h4></label>
                                    <input type="file"  class="form-control-file file-upload" name="foto"   id="fileCasa" > 
                                </div>
                                <div class="col-xs-6 foto"   >
                                    <img id="previa" class="foto" src=""> 
                                </div>
                            </div>

                            <div class="col-xs-12 text-center form-group">
                                <h5 id="error" style="color: red"></h5>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-12 text-center"> 
                                    <input type="submit" class="btn btn-lg" name="boton" id="editar" value="Editar">
                                    <input type="submit" class="btn  btn-lg" name="boton" id="cancelar" value="Volver">
                                    <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Limpiar</button>
                                </div>
                            </div>
                        </form>
                    </div><!--/tab-pane-->
                </div><!--/tab-content-->
            </div><!--/col-9-->
        </div><!--/row-->
        <footer class="row mt-4 page-footer">
            <div class="col text-center">
                &copy; Todos los derechos reservados. Miguel Angel Rueda.
            </div>
        </footer>
        <script type="text/javascript" src="<%=request.getContextPath()%>/JS/FileCasaEdit.js"></script>
    </body>
</html>
