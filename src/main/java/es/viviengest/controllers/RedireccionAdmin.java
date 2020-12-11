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
import es.viviengest.beans.Usuario;
import es.viviengest.beans.Vivienda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
@WebServlet(name = "RedireccionAdmin", urlPatterns = {"/RedireccionAdmin"})
public class RedireccionAdmin extends HttpServlet {

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
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        PropietariosDAO pdao = new PropietariosDAO();
        InquilinosDAO idao = new InquilinosDAO();
        UsuariosDAO udao = new UsuariosDAO();
        List<Vivienda> viviendas = new ArrayList<Vivienda>(); 
        ViviendasDAO vdao = new ViviendasDAO();
        Vivienda vivienda = new Vivienda();
        List<Alquiler> alquileres= new ArrayList<Alquiler>();
        AlquileresDAO adao= new AlquileresDAO();
        Enumeration<String> parametros = request.getParameterNames();
        while (parametros.hasMoreElements()) {
            String nombre = parametros.nextElement();

            if (nombre.startsWith("cerra")) {
                
                sesion = request.getSession();
                usuario = (Usuario) sesion.getAttribute("usuario");

                //introducimos la ultima fecha de inicio de sesion
                java.util.Date d = new java.util.Date();
                java.sql.Date fecha = new java.sql.Date(d.getTime());
                usuario.setUltimoacceso(fecha);

                udao.actualizarUsuario(usuario);

                sesion.getAttribute("usuario");
                sesion.invalidate();
                URL = "index.jsp";

            } else if (nombre.startsWith("elim")) {
                
                if (request.getParameter("userSelct") != null) {
                    String idUser = request.getParameter("userSelct");
                    Long id = Long.valueOf(idUser);
                    usuario = udao.getUsuario(id);
                    
                    sesion = request.getSession();
                    sesion.setAttribute("usuarioelim", usuario);
                    if (vdao.getVivienda(id)!=null) {
                        viviendas=vdao.getVivienda(id);
                        for (Vivienda vivienda1 : viviendas) { 
                            if (vivienda1.getEstado()) {
                                request.setAttribute("msj", "No se puede eliminar este usuario ya que tiene una vivienda alquilada");
                            }
                        }
                    }
                    if (adao.getAlquiler(id)!= null) {
                         request.setAttribute("msj", "No se puede eliminar este usuario ya que tiene una vivienda alquilada");
                    }
                    
                }
                URL = "/JSP/ADMIN/EliminarUsuario.jsp";
            } else if (nombre.startsWith("volv")) {
                
                URL = "/JSP/ADMIN/AdminHome.jsp";
            } else if (nombre.startsWith("viviendael")) {
                
                viviendas = vdao.getViviendas();  
                sesion = request.getSession();
                sesion.setAttribute("viviendas", viviendas);
                
                URL = "/JSP/ADMIN/AllViviendas.jsp";
                
            }  else if (nombre.startsWith("Veliminar")) {
                
               
                sesion = request.getSession();
                vivienda=(Vivienda) sesion.getAttribute("viviendaOpc");
                vdao.deleteVivienda(vivienda.getId());
                
                URL = "/JSP/ADMIN/AdminHome.jsp";
                
            } else if (nombre.startsWith("borr")) {
                
                sesion = request.getSession();
                usuario = (Usuario) sesion.getAttribute("usuarioelim");
                if (usuario.getRoll().equals("PROPIETARIO")) {
                    pdao.deletePropietario(usuario.getId()); 
                   viviendas=vdao.getVivienda(usuario.getId());
                    for (Vivienda vivienda1 : viviendas) {
                        vdao.deleteVivienda(vivienda1.getId()); 
                    }
                } else {
                    idao.deleteInquilino(usuario.getId());
                }
                udao.deleteUsuario(usuario.getId());
                usuarios = udao.getUsuariosDelete();
                sesion = request.getSession();
                sesion.setAttribute("usuarios", usuarios);
                URL = "/JSP/ADMIN/AdminHome.jsp";
            } else {
                String accion = request.getParameter(nombre);
                if (accion.equals("Visualizar")) {
                    sesion = request.getSession();
                    Long opc = Long.valueOf(nombre);
                    vivienda = vdao.getViviendaId(opc);
                    sesion.setAttribute("viviendaOpc", vivienda);

                    URL = "/JSP/ADMIN/OpcVivienda.jsp";
                } else if (accion.equals("Eliminar")) {
                    sesion = request.getSession();
                    Long opc = Long.valueOf(nombre);
                    vivienda = vdao.getViviendaId(opc);
                    sesion.setAttribute("viviendaOpc", vivienda);
                    request.setAttribute("eliminar",  "¿Desea eliminar esta vivienda?");
                    
                    URL = "/JSP/ADMIN/OpcVivienda.jsp";
                }
            }

        }
        request.getRequestDispatcher(URL).forward(request, response);

    }

}
