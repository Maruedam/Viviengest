/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;

import es.viviengest.beans.Usuario;
import java.util.List;

/**
 *
 * @author dwigh
 */
public interface IUsuariosDAO {

    public List<Usuario> getUsuarios();

    public Usuario getUsuario(Long id);

    public void deleteUsuario(Long id);

    public void insertarUsuario(Usuario u);

    public void actualizarUsuario(Usuario u);

    public void closeConnection();

    public List<Usuario> getUsuariosDelete();
}
