/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;

import es.viviengest.DAO.UsuariosDAO;
import es.viviengest.DAO.ViviendasDAO;
import es.viviengest.beans.Foto;
import es.viviengest.beans.Propietario;
import es.viviengest.beans.Usuario;
import es.viviengest.beans.Vivienda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author dwigh
 */
@MultipartConfig
@WebServlet(name = "RegistroVivienda", urlPatterns = {"/RegistroVivienda"})
public class RegistroVivienda extends HttpServlet {

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

        UsuariosDAO udao = new UsuariosDAO();
        List<Vivienda> viviendas = new ArrayList<Vivienda>();
        List<Foto> fotos = new ArrayList<Foto>();
        ViviendasDAO vdao = new ViviendasDAO();
        Propietario propietario = new Propietario();
        Usuario user = new Usuario();
        HttpSession sesion = request.getSession();
        String url = "";
        Vivienda vivienda = new Vivienda();
        if (request.getParameter("boton").startsWith("Volv")) {
            url = "/JSP/PROPIETARIO/PropietarioHome.jsp";
        } else {
            vivienda = new Vivienda();
            //obtenemos el valor de los campos en el objeto
            vivienda.setDireccion(request.getParameter("direccion"));
            vivienda.setcPostal(Integer.valueOf(request.getParameter("cPostal")));
            vivienda.setLocalidad(request.getParameter("localidad"));
            vivienda.setProvincia(request.getParameter("provincia"));
            vivienda.setnHabitaciones(Integer.valueOf(request.getParameter("nHabitaciones")));
            vivienda.setTipoDeSuelo(request.getParameter("tipoDeSuelo"));
            vivienda.setnBanios(Integer.valueOf(request.getParameter("nBanios")));
            vivienda.setMetrosCuadrados(Integer.valueOf(request.getParameter("metrosCuadrados")));
            vivienda.setMinimoMeses(Integer.valueOf(request.getParameter("minimoMeses")));
            vivienda.setImporteMensual(Double.valueOf(request.getParameter("importeMensual")));
            vivienda.setImporteFinaza(Double.valueOf(request.getParameter("importeFinaza")));
            vivienda.setAnioContruccion(Integer.valueOf(request.getParameter("anioContruccion")));
            if (request.getParameter("comunidad").length() > 0) {
                vivienda.setComunidad(Double.valueOf(request.getParameter("comunidad")));
            } else {
                vivienda.setComunidad(Double.valueOf(0));
            }

            //RELLENAMOS LOS CHECKBOX
            Boolean ascensor = false;
            if (request.getParameter("ascensor") == null || request.getParameter("ascensor").equals(false)) {
                vivienda.setAscensor(ascensor);
            } else {
                ascensor = true;
                vivienda.setAscensor(ascensor);
            }
            Boolean amueblado = false;
            if (request.getParameter("amueblado") == null || request.getParameter("amueblado").equals(false)) {
                vivienda.setAmueblado(amueblado);
            } else {
                amueblado = true;
                vivienda.setAmueblado(amueblado);
            }
            Boolean calefaccion = false;
            if (request.getParameter("calefaccion") == null || request.getParameter("calefaccion").equals(false)) {
                vivienda.setCalefaccion(calefaccion);
            } else {
                calefaccion = true;
                vivienda.setCalefaccion(calefaccion);
            }
            Boolean aireAcondicionado = false;
            if (request.getParameter("aireAcondicionado") == null || request.getParameter("aireAcondicionado").equals(false)) {
                vivienda.setAireAcondicionado(aireAcondicionado);
            } else {
                aireAcondicionado = true;
                vivienda.setAireAcondicionado(aireAcondicionado);
            }
            //establecemos el propietario
            sesion = request.getSession();
            propietario = (Propietario) sesion.getAttribute("propietario");
            vivienda.setPropietario(propietario);
            //Establecemos los campos sin asignar
            vivienda.setEstado(false);
            vivienda.setPagadoMes(false);

            //insertamos la vivienda y obtenemos su id
            vdao.insertarVivienda(vivienda);
            viviendas = vdao.getViviendas();
            Long total = null;
            for (Vivienda vivienda1 : viviendas) {
                total = vivienda1.getId();
            }
            vivienda = new Vivienda();
            vivienda = vdao.getViviendaId(total);
            request.setAttribute("viviendaVis", vivienda);
            //introducimos las fotos en el servidor y la bbdd
            String nombreImagen = "";
            String rutaImagen = "";
            Part filePart = request.getPart("foto");
            nombreImagen = filePart.getSubmittedFileName();
            if (nombreImagen.equals("")) {
                nombreImagen = "default.jpg";
            } else {
                rutaImagen = request.getServletContext().getRealPath("/IMAGENES/VIVIENDAS/" + nombreImagen);
                System.out.println("rutaimagen " + rutaImagen);
                filePart.write(rutaImagen);
                Foto foto = new Foto();
                foto.setNombre(nombreImagen);
                foto.setVivienda(vivienda);
                vdao.insertarFotoVivienda(foto);
            }
            //insertamos la vivienda en sesion
            //insertamos la sesion de las viviendas del propietario si es que tenga alaguna

            viviendas = vdao.getVivienda(propietario.getId());
            fotos = vdao.getFotos();
 
            sesion = request.getSession();
            sesion.setAttribute("viviendas", viviendas);
            sesion = request.getSession();
            sesion.setAttribute("fotos", fotos);
            sesion = request.getSession();

            url = "/JSP/PROPIETARIO/VerVivienda.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
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
