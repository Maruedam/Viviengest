/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dwigh
 */
@WebServlet(name = "Redireccion", urlPatterns = {"/Redireccion"})
public class Redireccion extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String URL = "JSP/REGISTROS/Registro.jsp";
        String tipoUsuario = "";

        Enumeration<String> parametros = request.getParameterNames();
        while (parametros.hasMoreElements()) {
            String nombre = parametros.nextElement();

            if (nombre.startsWith("propieta")) {
                tipoUsuario = "p";
                URL = "JSP/REGISTROS/Registro.jsp";
            } else if (nombre.startsWith("inquil")) {
                tipoUsuario = "i";
                URL = "JSP/REGISTROS/Registro.jsp";
            }else if(nombre.startsWith("inic")){
                URL = "index.jsp";
            }
        }
        request.setAttribute("tipoUsuario", tipoUsuario);
        request.getRequestDispatcher(URL).forward(request, response);

    }

}
