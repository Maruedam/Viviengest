/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;

import es.viviengest.beans.Alquiler; 
import java.util.List;

/**
 *
 * @author dwigh
 */
public interface IAlquileresDAO {
    public List<Alquiler> getAlquileres();

    public Alquiler getAlquiler(Long idInquilino);
    
    public List<Alquiler> getAlquileresPropietario(Long idPropietario);

    public void deleteAlquiler(Long id);

    public void insertarAlquiler(Alquiler alquiler);

    public void actualizarAlquiler(Alquiler alquiler);

    public void closeConnection();
    
}
