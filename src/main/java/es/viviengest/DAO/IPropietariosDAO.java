/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;

import es.viviengest.beans.Propietario;
import java.util.List;

/**
 *
 * @author dwigh
 */
public interface IPropietariosDAO {
    public List<Propietario> getPropietarios();

    public Propietario getPropietario(Long id);

    public void deletePropietario(Long id);

    public void insertarPropietario(Propietario p);

    public void actualizarPropietario(Propietario p);

    public void closeConnection();
}
