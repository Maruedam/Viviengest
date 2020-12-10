/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.controllers;
 
import es.viviengest.DAO.PropietariosDAO;
import es.viviengest.DAO.UsuariosDAO; 
import es.viviengest.beans.Propietario;
import es.viviengest.beans.Usuario;
import es.viviengest.utilities.Utilidades;

import java.io.IOException; 
import java.lang.reflect.InvocationTargetException;  
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils; 

/** 
 *
 * @author dwigh
 */
@WebServlet(name = "EditarUsuario", urlPatterns = {"/EditarPropietario"})
public class EditarPropietario extends HttpServlet {

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
        Propietario propietario = new Propietario();
        HttpSession sesion = request.getSession();
        String url = "";
        Usuario usuario;
        Usuario usuarioAnterior;
        if (request.getParameter("boton").startsWith("Volv")) {
            url = "/JSP/PROPIETARIO/PropietarioHome.jsp";
        } else {
            usuario = new Usuario();
            usuarioAnterior = new Usuario();
            try {
                //obtenemos el valor de los campos en el objeto
                BeanUtils.populate(usuario, request.getParameterMap());

                usuario.setTelefono(Integer.parseInt(request.getParameter("telefono")));

                sesion = request.getSession();
                usuarioAnterior = (Usuario) sesion.getAttribute("usuario");
                String password = DigestUtils.md5Hex(request.getParameter("passwd"));
                //encriptamos la password
                String pw1=usuarioAnterior.getPasswd();
                String pw2=request.getParameter("passwd");
                if (pw1.equals(pw2)) {
                    usuario.setPasswd(usuarioAnterior.getPasswd());
                } else { 
                    usuario.setPasswd(password);
                }

                //capitalizamos campos
                String apellido = Utilidades.capitalizar(usuario.getApellidos());
                usuario.setApellidos(apellido);
                String nombre = Utilidades.capitalizar(usuario.getNombre());
                usuario.setNombre(nombre);

                usuario.setDni(usuarioAnterior.getDni());
                usuario.setEmail(usuarioAnterior.getEmail());
                usuario.setRoll("PROPIETARIO");
                usuario.setId(usuarioAnterior.getId());
                userDao.actualizarUsuario(usuario);

                propietario.setNumecuenta(request.getParameter("numecuenta"));
                propietario.setDireccionpostal(request.getParameter("direccionpostal"));
                propietario.setUsuario(usuario);
                propietario.setId(usuario.getId());
                propDao.actualizarPropietario(propietario);

               

                sesion = request.getSession();
                sesion.setAttribute("usuario", usuario);
                sesion = request.getSession();
                sesion.setAttribute("propietario", propietario);

                url = "/JSP/PROPIETARIO/VerPropietario.jsp";

            } catch (InvocationTargetException | IllegalAccessException ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
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
