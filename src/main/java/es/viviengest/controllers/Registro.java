/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;

import es.viviengest.utilities.Utilidades;
import es.viviengest.DAO.InquilinosDAO;
import es.viviengest.DAO.PropietariosDAO;
import es.viviengest.DAO.UsuariosDAO;
import es.viviengest.beans.Inquilino;
import es.viviengest.beans.Propietario;
import es.viviengest.beans.Usuario;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author dwigh
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

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
        UsuariosDAO userDao = new UsuariosDAO();
        PropietariosDAO propDao = new PropietariosDAO();
        InquilinosDAO inquDao = new InquilinosDAO();
        String url = "";
        Usuario usuario;
        if (request.getParameter("boton").startsWith("Volv")) {
            url = "index.jsp";
        } else {

            usuario = new Usuario();
            try {
                //obtenemos el valor de los campos en el objeto
                BeanUtils.populate(usuario, request.getParameterMap());

                //Introducimos el id de usuario
                List<Usuario> usuarios = new ArrayList<Usuario>();
                usuarios = userDao.getUsuarios();
                Long total = Long.valueOf(0);
                if (usuarios.size() != 0) {
                    for (Usuario usuario1 : usuarios) {
                        total = usuario1.getId();
                    }
                    total = Long.valueOf(total + 1);
                }else{
                    total=Long.valueOf(1);
                }

                usuario.setTelefono(Integer.parseInt(request.getParameter("telefono")));

                //encriptamos la password
                String password = DigestUtils.md5Hex(request.getParameter("passwd"));
                usuario.setPasswd(password);

                //capitalizamos campos
                String apellido = Utilidades.capitalizar(usuario.getApellidos());
                usuario.setApellidos(apellido);
                String nombre = Utilidades.capitalizar(usuario.getNombre());
                usuario.setNombre(nombre);

                //nos aseguramos de que tipo de usuario es
                if (request.getParameter("numecuenta") != null) {
                    usuario.setRoll("PROPIETARIO");
                    userDao.insertarUsuario(usuario);
                    Propietario propietario = new Propietario();
                    propietario.setNumecuenta(request.getParameter("numecuenta"));
                    propietario.setDireccionpostal(request.getParameter("direccionpostal"));
                    usuario = userDao.getUsuario(total);
                    propietario.setUsuario(usuario);

                    propDao.insertarPropietario(propietario);

                    url = "/JSP/REGISTROS/UsuarioRegistrado.jsp";

                } else {
                    usuario.setRoll("INQUILINO");
                    userDao.insertarUsuario(usuario);
                    Inquilino inquilino = new Inquilino();
                    Double ultimaNomina = Double.parseDouble(request.getParameter("ultimaNomina"));
                    inquilino.setultima_nomina(ultimaNomina);
                    usuario = userDao.getUsuario(total);
                    inquilino.setUsuario(usuario);

                    inquDao.insertarInquilino(inquilino);

                    url = "/JSP/REGISTROS/UsuarioRegistrado.jsp";
                }

                request.getRequestDispatcher(url).forward(request, response);

            } catch (InvocationTargetException | IllegalAccessException ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
