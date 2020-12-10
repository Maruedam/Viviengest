<%-- 
    Document   : index
    Created on : 26-oct-2020, 9:07:33
    Author     : dwigh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Viviengest -Acceso</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="author" content="MiguelAngel" />
        <meta name="generator" content="NetBeans 11.3" />
        <meta name="copyright" content="Miguel Angel Rueda Muriel" />
        <meta name="robots" content="index, follow" />
        <meta name="description" content="Viviengest" /> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">

        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="IMAGENES/icono.png"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="FONTS/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="FONTS/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="CSS/util.css">
        <link rel="stylesheet" type="text/css" href="CSS/main.css">
        <!--===============================================================================================-->
    </head>
    <body> 
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form class="login100-form validate-form" action="LogIn" method="post">
                        <span class="login100-form-title p-b-43">
                            Inicie sesi&oacute;n 
                        </span> 

                        <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                            <input class="input100" type="text" name="email" placeholder="Correo">
                            <span class="focus-input100"></span>
                        </div>


                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <input class="input100" type="password" name="pass" placeholder="Contrase&ntilde;a">
                            <span class="focus-input100"></span> 
                        </div>
                        <c:if test="${requestScope.msj !=null}">
                            <span class="error ">
                                <%=request.getAttribute("msj")%><br>
                            </span>
                        </c:if> 
                        <div class="container-login100-form-btn">
                            <input class="login100-form-btn" type="submit" name="acceder" value="Acceder">
                            <P>¿No tienes cuenta?<input class="btn" id="registro" type="submit" name="Registrarse" value="Registrarse"></P>
                        </div>

                    </form>

                    <div class="login100-more container-login100" style="background-image: url('IMAGENES/loginizq.jpg');">
                        <div class="row">
                            <span class="login100-form-title-izq ">
                                Viviengest
                                <p class="subtitulo">La mejor plataforma para ayudar a los dueños e inquilinos.</p>
                                <p class="subtitulo">&Uacute;nete!!</p>
                            </span>
                        </div>

                    </div>
                </div>
                <footer class="row mt-4  page-footer  ">
                    <div class="col text-center p-2">
                        &copy; Todos los derechos reservados. Miguel Angel Rueda
                    </div>
                </footer>
            </div>
        </div>
        <script src="JS/main.js"></script>
    </body>
</html>
