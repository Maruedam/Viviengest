/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;

import es.viviengest.DAO.AlquileresDAO;
import es.viviengest.DAO.PropietariosDAO;
import es.viviengest.DAO.UsuariosDAO;
import es.viviengest.DAO.ViviendasDAO;
import es.viviengest.beans.AlquiladaPor;
import es.viviengest.beans.Alquiler;
import es.viviengest.beans.Inquilino;
import es.viviengest.beans.Propietario;
import es.viviengest.beans.Usuario;
import es.viviengest.beans.Vivienda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
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
@WebServlet(name = "RedireccionInquilino", urlPatterns = {"/RedireccionInquilino"})
public class RedireccionInquilino extends HttpServlet {

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
        Inquilino inquilino = new Inquilino();
        Usuario usuario = new Usuario();
        UsuariosDAO udao = new UsuariosDAO();
        ViviendasDAO vdao = new ViviendasDAO();
        Vivienda vivienda = new Vivienda();
        Alquiler alquiler = new Alquiler();
        Propietario propietario = new Propietario();
        PropietariosDAO pdao = new PropietariosDAO();
        AlquileresDAO adao = new AlquileresDAO(); 
        AlquiladaPor alquiladaPor = new AlquiladaPor();
        Enumeration<String> parametros = request.getParameterNames();

        while (parametros.hasMoreElements()) {
            String nombre = parametros.nextElement();

            if (nombre.startsWith("cerrar")) {
                sesion = request.getSession();
                usuario = (Usuario) sesion.getAttribute("usuario");

                //introducimos la ultima fecha de inicio de sesion
                java.util.Date d = new java.util.Date();
                java.sql.Date fecha = new java.sql.Date(d.getTime());
                usuario.setUltimoacceso(fecha);
                udao.actualizarUsuario(usuario);

                sesion.getAttribute("usuario");
                sesion.invalidate();
                sesion = request.getSession();
                sesion.getAttribute("inquilino");
                sesion.invalidate();
                sesion = request.getSession();
                sesion.invalidate();
                URL = "index.jsp";

            } else if (nombre.startsWith("editarPerfil")) {
                URL = "/JSP/INQUILINO/EditarInquilino.jsp";

            } else if (nombre.startsWith("Volv")) {
                URL = "/JSP/INQUILINO/InquilinoHome.jsp";

            } else if (nombre.startsWith("visualiz")) {
                URL = "/JSP/INQUILINO/VerInquilino.jsp";

            } else if (nombre.startsWith("Alquil")) {
                vivienda = new Vivienda();
                sesion = request.getSession();
                vivienda = (Vivienda) sesion.getAttribute("viviendaAlquilar");
                vivienda.setEstado(true);
                vdao.actualizarVivienda(vivienda); 
                java.util.Date d = new java.util.Date();
                java.sql.Date fecha = new java.sql.Date(d.getTime());
                sesion = request.getSession();
                inquilino=(Inquilino) sesion.getAttribute("inquilino");
                propietario = pdao.getPropietario(vivienda.getPropietario().getId());

                alquiler.setFecha_entrada(fecha);
                alquiler.setPropietario(propietario);
                alquiler.setVivienda(vivienda);
                alquiler.setInquilino(inquilino);
                alquiler.setFecha_salida(null);
                
                alquiladaPor.setInquilino(inquilino);
                alquiladaPor.setVivienda(vivienda);
                
                adao.insertarAlquiladaPor(alquiladaPor);
                adao.insertarAlquiler(alquiler);

                sesion = request.getSession();
                sesion.setAttribute("viviendaAlquiler",vivienda);
                
                URL = "/JSP/INQUILINO/InquilinoHome.jsp";
            } else {
                String accion = request.getParameter(nombre);
                if (accion.equals("Visualizar")) {
                    vivienda = vdao.getViviendaId(Long.valueOf(nombre));
                    request.setAttribute("viviendaVis", vivienda);
                    URL = "/JSP/INQUILINO/VerViviendaInquilino.jsp";
                } else if (accion.equals("Alquilar")){
                    vivienda = vdao.getViviendaId(Long.valueOf(nombre));
                    sesion = request.getSession();
                    sesion.setAttribute("viviendaAlquilar", vivienda);
                    URL = "/JSP/INQUILINO/VerViviendaAlquilar.jsp";
                }else if (accion.equals("Propietario")){
                    vivienda = vdao.getViviendaId(Long.valueOf(nombre));
                    propietario=vivienda.getPropietario();
                    request.setAttribute("propietarioDueno", propietario);
                    usuario=udao.getUsuario(propietario.getId());
                    request.setAttribute("usuarioDueno", usuario);
                    URL = "/JSP/INQUILINO/VerPropietarioDuenio.jsp";
                }
            }

        }
        request.getRequestDispatcher(URL).forward(request, response);

    }

}
