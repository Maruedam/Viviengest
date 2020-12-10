/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;
 
import es.viviengest.DAO.UsuariosDAO;
import es.viviengest.beans.Usuario;
import java.io.IOException;
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
@WebServlet(name = "EmailAjax", urlPatterns = {"/EmailAjax"})
public class EmailAjax extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuariosDAO userdao = new UsuariosDAO();
        JSONObject objeto = null;
        if (request.getParameter("parametro") != null) {
            objeto = new JSONObject();
            String email = request.getParameter("email");
            boolean existe = userdao.buscaUserMail(email);
            if (existe) {
                objeto.put("tipo", "existe");
            } else {
                objeto.put("tipo", "noExiste");
            }
            response.setContentType("application/json");
            response.getWriter().print(objeto);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
