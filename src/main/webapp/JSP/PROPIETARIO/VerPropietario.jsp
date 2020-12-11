<%-- 
    Document   : VerUsuario
    Created on : 23-nov-2020, 18:47:10
    Author     : dwigh
--%>
 
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
            <div class="col-md-12">
                    <h1>Visualizar usuario</h1>
                </div>
            <hr>
            <div class="row box" > 
                <div class="col-sm-12">
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <hr>
                            <form class="form"  action="EditarPropietario" method="post" id="registrationForm">

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="nombre"><h4>Nombre: ${sessionScope.usuario.getNombre()} </h4></label>
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="apellidos"><h4>Apellidos: ${sessionScope.usuario.getApellidos()} </h4></label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="telefono"> <h4>Tel&eacute;fono: ${sessionScope.usuario.getTelefono()} </h4></label>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="dni"><h4>DNI: ${sessionScope.usuario.getDni()}</h4></label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="email"><h4>Email: ${sessionScope.usuario.getEmail()} </h4></label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="numecuenta"><h4>N&uacute;mero de cuenta: ${sessionScope.propietario.getNumecuenta()} </h4></label>
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="direccionpostal"><h4>Direcci&oacute;n postal: ${sessionScope.propietario.getDireccionpostal()} </h4></label> 
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-12 text-center"> 
                                        <input class="btn2  btn-lg" type="submit"  name="boton" value="Volver"> 
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
