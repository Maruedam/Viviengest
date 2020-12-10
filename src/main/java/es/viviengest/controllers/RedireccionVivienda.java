/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;
 
import es.viviengest.DAO.ViviendasDAO; 
import es.viviengest.beans.Vivienda;
import java.io.IOException; 
import java.util.Collections; 
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dwigh
 */
@WebServlet(name = "RedireccionVivienda", urlPatterns = {"/RedireccionVivienda"})
public class RedireccionVivienda extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        String URL = "";
        ViviendasDAO vdao = new ViviendasDAO();
        Vivienda vivienda= new Vivienda(); 
        
        List<String> parameterNamesList =   Collections.list(request.getParameterNames());
       
        for (String parameter : parameterNamesList) {
            String accion= request.getParameter(parameter);
            
            if (accion.equals("Editar")) {
                vivienda=vdao.getViviendaId(Long.valueOf(parameter));
                sesion=request.getSession();
                sesion.setAttribute("viviendaEditar", vivienda);
                URL="/JSP/PROPIETARIO/EditarVivienda.jsp";
            }else if (accion.equals("Eliminar")){
                vivienda=vdao.getViviendaId(Long.valueOf(parameter));
                if (vivienda.getEstado().equals(true)) {
                    request.setAttribute("msj", "Esta vivienda esta alquilada por lo que no se puede eliminar");
                }
                sesion=request.getSession();
                sesion.setAttribute("viviendaEliminar", vivienda); 
                URL="/JSP/PROPIETARIO/EliminarVivienda.jsp";
            }else{
                 URL="/JSP/PROPIETARIO/PropietarioHome.jsp";
            }
        }
      
        request.getRequestDispatcher(URL).forward(request, response);

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
