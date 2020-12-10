/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;

import es.viviengest.DAO.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author dwigh
 */
@WebServlet(name = "DniAjax", urlPatterns = {"/DniAjax"})
public class DniAjax extends HttpServlet {
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
           
        UsuariosDAO userdao = new UsuariosDAO();
        JSONObject objeto = null;
        if (request.getParameter("parametro") != null) {
            objeto = new JSONObject();
            String dni = request.getParameter("dni");
            boolean existe = userdao.buscaUserdni(dni);
            if (existe) {
                objeto.put("tipo", "existe");
            } else {
                objeto.put("tipo", "noExiste");
            }
            response.setContentType("application/json");
            response.getWriter().print(objeto);
        }
    }

}
