/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;

import es.viviengest.DAO.AlquileresDAO;
import es.viviengest.DAO.InquilinosDAO; 
import es.viviengest.DAO.UsuariosDAO;
import es.viviengest.DAO.ViviendasDAO;
import es.viviengest.beans.AlquiladaPor;
import es.viviengest.beans.Alquiler;
import es.viviengest.beans.Inquilino;
import es.viviengest.beans.Propietario;
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
@WebServlet(name = "RedireccionPropietario", urlPatterns = {"/RedireccionPropietario"})
public class RedireccionPropietario extends HttpServlet {

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
        UsuariosDAO udao = new UsuariosDAO();
        Propietario p = new Propietario();
        Vivienda vivienda = new Vivienda();
        ViviendasDAO vdao = new ViviendasDAO();
        List<Vivienda> viviendas = new ArrayList<Vivienda>();
        AlquileresDAO adao = new AlquileresDAO();
        Alquiler alquiler = new Alquiler();
        AlquiladaPor alquiladaPor = new AlquiladaPor();
        Inquilino inquilino = new Inquilino();
        InquilinosDAO idao = new InquilinosDAO();
        Enumeration<String> parametros = request.getParameterNames();
        while (parametros.hasMoreElements()) {
            String nombre = parametros.nextElement();

            if (nombre.startsWith("cerrar")) {
                sesion = request.getSession();
                if (sesion.getAttribute("usuario") != null) {
                    usuario = (Usuario) sesion.getAttribute("usuario");

                    //introducimos la ultima fecha de inicio de sesion
                    java.util.Date d = new java.util.Date();
                    java.sql.Date fecha = new java.sql.Date(d.getTime());
                    //fecha = new java.sql.Date(d.getTime());
                    usuario.setUltimoacceso(fecha);

                    udao.actualizarUsuario(usuario);
                }

                sesion = request.getSession();
                sesion.invalidate();
                URL = "index.jsp";

            } else if (nombre.startsWith("crea")) {
                URL = "/JSP/PROPIETARIO/CrearVivienda.jsp";
            } else if (nombre.startsWith("volv")) {
                URL = "/JSP/PROPIETARIO/PropietarioHome.jsp";
            } else if (nombre.startsWith("visuali")) {
                URL = "/JSP/PROPIETARIO/VerPropietario.jsp";
            } else if (nombre.startsWith("modif")) {
                URL = "/JSP/PROPIETARIO/EditarPropietario.jsp";
            } else if (nombre.startsWith("editarVivien")) {
                URL = "/JSP/PROPIETARIO/OpcionesViviendas.jsp";
            } else if (nombre.startsWith("Acabar")) {
                sesion = request.getSession();
                vivienda = (Vivienda) sesion.getAttribute("viviendaAlqu");

                vivienda.setEstado(false);
                vdao.actualizarVivienda(vivienda);

                adao.deleteAlquiladaPor(vivienda.getId());
                adao.deleteAlquiler(vivienda.getId());

                usuario = (Usuario) sesion.getAttribute("usuario");
                viviendas = vdao.getVivienda(usuario.getId());
                if (viviendas.size() > 0 ) {
                    sesion = request.getSession();
                    sesion.setAttribute("viviendas", viviendas);
                }
                URL = "/JSP/PROPIETARIO/PropietarioHome.jsp";
            } else {
                String accion = request.getParameter(nombre);
                if (accion.equals("Visualizar")) {
                    sesion = request.getSession();
                    Long opc = Long.valueOf(nombre);
                    vivienda = vdao.getViviendaId(opc);
                    request.setAttribute("viviendaVis", vivienda);
                    URL = "/JSP/PROPIETARIO/VerVivienda.jsp";
                } else if (accion.equals("Inquilino")) {
                    Long opc = Long.valueOf(nombre);
                    vivienda = vdao.getViviendaId(opc);
                    alquiladaPor = adao.getAlquiladaPor(vivienda.getId());
                    inquilino = idao.getInquilino(alquiladaPor.getInquilino().getId());
                    alquiler = adao.getAlquiler(inquilino.getId());
                    usuario = udao.getUsuario(inquilino.getId());

                    sesion = request.getSession();
                    sesion.setAttribute("inquilino", inquilino);
                    sesion = request.getSession();
                    sesion.setAttribute("alquiler", alquiler);
                    sesion = request.getSession();
                    sesion.setAttribute("usuarioInquilino", usuario);
                    sesion = request.getSession();
                    sesion.setAttribute("viviendaAlqu", vivienda);

                    URL = "/JSP/PROPIETARIO/VerInquilinoOpc.jsp";
                }

            }

        }
        request.getRequestDispatcher(URL).forward(request, response);

    }
}
