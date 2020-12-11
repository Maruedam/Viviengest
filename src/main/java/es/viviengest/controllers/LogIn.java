/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;

import es.viviengest.DAO.AlquileresDAO;
import es.viviengest.DAO.InquilinosDAO;
import es.viviengest.DAO.PropietariosDAO;
import es.viviengest.DAO.UsuariosDAO;
import es.viviengest.DAO.ViviendasDAO;
import es.viviengest.beans.Alquiler; 
import es.viviengest.beans.Propietario;
import es.viviengest.beans.Usuario;
import es.viviengest.beans.Inquilino;
import es.viviengest.beans.Vivienda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author dwigh
 */
@WebServlet(name = "LogIn", urlPatterns = {"/LogIn"})
public class LogIn extends HttpServlet {

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

        String URL = "";
        Boolean esta = false;

        ViviendasDAO vivDAO = new ViviendasDAO();
        Vivienda vivienda = new Vivienda();
        List<Vivienda> viviendas = new ArrayList<Vivienda>();
        UsuariosDAO userDAO = new UsuariosDAO();
        PropietariosDAO pdao = new PropietariosDAO();
        Propietario propietario = new Propietario();
        InquilinosDAO idao = new InquilinosDAO();
        Inquilino inquilino = new Inquilino();
        HttpSession sesion = request.getSession();
        List<Usuario> usuarios = new ArrayList<Usuario>(); 
        usuarios = userDAO.getUsuarios();
        AlquileresDAO adao = new AlquileresDAO();
        Alquiler alquiler = new Alquiler();
        Enumeration<String> parametros = request.getParameterNames();

        while (parametros.hasMoreElements()) {
            String nombre = parametros.nextElement();
            String pass = DigestUtils.md5Hex(request.getParameter("pass"));
            if (nombre.startsWith("acceder")) {
                for (Usuario usuario : usuarios) {
                    if (request.getParameter("email").equals(usuario.getEmail()) && pass.equals(usuario.getPasswd()) && usuario.getRoll().equals("ADMIN")) {

                        usuarios = userDAO.getUsuariosDelete();
                        sesion = request.getSession();
                        sesion.setAttribute("usuarios", usuarios);
                        sesion = request.getSession();
                        sesion.setAttribute("usuario", usuario);
                        URL = "JSP/ADMIN/AdminHome.jsp";
                        esta = true;
                    } else try {
                        if (request.getParameter("email").equals(usuario.getEmail()) && pass.equals(usuario.getPasswd()) && usuario.getRoll().equals("PROPIETARIO")) {
                            URL = "JSP/PROPIETARIO/PropietarioHome.jsp";

                            propietario = pdao.getPropietario(usuario.getId());

                            //insertamos la sesion de las viviendas del propietario si es que tenga alaguna
                            viviendas = vivDAO.getVivienda(usuario.getId());
                            if (viviendas.size() > 0 || viviendas != null) {
                                sesion = request.getSession();
                                sesion.setAttribute("viviendas", viviendas);
                            }
                            
                            sesion = request.getSession();
                            sesion.setAttribute("usuario", usuario);
                            sesion = request.getSession();
                            sesion.setAttribute("propietario", propietario); 
                            

                            esta = true;
                        } else if (request.getParameter("email").equals(usuario.getEmail()) && pass.equals(usuario.getPasswd()) && usuario.getRoll().equals("INQUILINO")) {
                            URL = "JSP/INQUILINO/InquilinoHome.jsp";

                            inquilino = idao.getInquilino(usuario.getId());
                            if (adao.getAlquiler(inquilino.getId()) != null) {
                                alquiler = adao.getAlquiler(inquilino.getId());
                                vivienda = vivDAO.getViviendaId(alquiler.getVivienda().getId()); 
                                sesion = request.getSession();
                                sesion.setAttribute("viviendaAlquiler", vivienda);
                            } else {
                                viviendas = vivDAO.getViviendasDisponibles();
                                if (viviendas.size() > 0) {
                                    sesion = request.getSession();
                                    sesion.setAttribute("viviendas", viviendas);
                                }
                            } 
                            sesion = request.getSession();
                            sesion.setAttribute("usuario", usuario);
                            sesion = request.getSession();
                            sesion.setAttribute("inquilino", inquilino);
                            esta = true;
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (esta == false) {
                    URL = "index.jsp";
                    request.setAttribute("msj", "Usuario incorrecto, vuelva a intentarlo.");
                }

            } else if (nombre.startsWith("Registrar")) {
                URL = "JSP/REGISTROS/TipoUsuario.jsp";
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
